package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.util.Value;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.Actas;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.SancionesMulta;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class SancionesMultaController {
	
	@Autowired
    HttpServletResponse response;

    @Autowired
    HttpServletRequest request;

    @Autowired
    UserService userService;

    @Autowired
    CopropiedadRepository copropiedadRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Value("${rutamenu}")
    private String rutamenu;
    
	@RequestMapping("/sanciones")
	public String sanciones(Authentication authenticationnn,ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
 
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		
		int copId =  copropiedadDTO.getCopId();
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		//Fecha Actual del sistema
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	    
		//Consultamos el ultimo consecutivo sanciones y multas
        SancionesMulta sancionesmultasconsecutivo = userService.findBySancionesMultaNitConsecutivoForm(copNit);
		int consecutivo = sancionesmultasconsecutivo.getMulNumero();
		consecutivo = consecutivo+1;
		
		SancionesMulta sancionesMultaForm = new SancionesMulta();
		sancionesMultaForm.setMulFecha(timeStamp);
		sancionesMultaForm.setMulNumero(consecutivo);
		
		model.addAttribute("sancionesMultaForm", sancionesMultaForm);	
		
		model.addAttribute("actaslist", userService.getActasByNit(copNit));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);

		 //Fecha Actual del sistema
        model.addAttribute("mulFecha", timeStamp);
        
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
        
		return "administrador/sanciones_multas";
	}
	
	@PostMapping("/crearsancionesmultas")
	public String crearSancionesMulta(@Valid @ModelAttribute("sancionesMultaForm")SancionesMulta sancionesMulta,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("mulAdjuntoEvidencias") MultipartFile[] filesmulAdjuntoEvidencias) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		String numeroConsecutivo = req.getParameter("mulNumero");
		
		String copNitString = req.getParameter("copNit");
		int copNit = Integer.parseInt(copNitString);
		String copNombre = req.getParameter("copNombre");
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;

		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		int copId = copropiedadDTO.getCopId();
		
		//Fecha Actual del sistema
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
						
		if(result.hasErrors()) {
			model.addAttribute("sancionesMultaForm", sancionesMulta);
			model.addAttribute("errorcampos","active");
		}else {
			try {

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "sancionesMulta");
				String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Evidencia
				for (int i = 0; i < filesmulAdjuntoEvidencias.length; i++) {
				  
					  MultipartFile file = filesmulAdjuntoEvidencias[i];
					  String name = filesmulAdjuntoEvidencias[i].getOriginalFilename();					  
					  String formato = filesmulAdjuntoEvidencias[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    SancionesMulta guardarSancionesMulta = new SancionesMulta();
						    guardarSancionesMulta.setMulNumero(sancionesMulta.getMulNumero());
						    guardarSancionesMulta.setCopNit(copNit);
						    guardarSancionesMulta.setProCc(sancionesMulta.getProCc());
						    guardarSancionesMulta.setProNombres(sancionesMulta.getProNombres());
						    guardarSancionesMulta.setProApellidos(sancionesMulta.getProApellidos());
						    guardarSancionesMulta.setProNumeroResidencia(sancionesMulta.getProNumeroResidencia());
						    guardarSancionesMulta.setMulDescripcion(sancionesMulta.getMulDescripcion());
						    guardarSancionesMulta.setMulTipoSancion(sancionesMulta.getMulTipoSancion());
						    guardarSancionesMulta.setMulEstado(sancionesMulta.getMulEstado());
						    guardarSancionesMulta.setMulFecha(sancionesMulta.getMulFecha());
						    guardarSancionesMulta.setProDireccionCorrespondencia(sancionesMulta.getProDireccionCorrespondencia());
						    guardarSancionesMulta.setMulAdjuntoEvidencia(codigoDescarga);
						    guardarSancionesMulta.setProEmail(sancionesMulta.getProEmail());
						    guardarSancionesMulta.setMulValor(sancionesMulta.getMulValor());
						    
						    userService.createSancionesMulta(guardarSancionesMulta);
					    }			   
				  }
				
				sancionesMulta.setMulFecha(timeStamp);
				sancionesMulta.setMulNumero(sancionesMulta.getMulNumero()+1);
				
				model.addAttribute("sancionesMultaForm", sancionesMulta);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				sancionesMulta.setMulFecha(timeStamp);
				sancionesMulta.setMulNumero(sancionesMulta.getMulNumero()+1);
				
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("sancionesMultaForm", sancionesMulta);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
			}
		}
		
        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("rutaroot", "");
		model.addAttribute("seguimiento", "");
		model.addAttribute("copId", copId);
		
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/sanciones_multas";
	}
	
	@RequestMapping("/consultasacionesymultas")
	public String consultaSacionesMultas(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		int copId = copropiedadDTO.getCopId();
		
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("sacionesmultaslist", userService.getSancionesMultaByNit(copNit));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/consultasacionesymultas";
	}
}
