package co.com.sisapco.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.sisapco.dto.CopropiedadDTO;

import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.Contrato;

import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

import org.springframework.security.core.Authentication;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;




@Controller
public class ContratoController {
	
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
	
	
	@RequestMapping("/contratos")
	public String contratos(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit =copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		
		int copId =  copropiedadDTO.getCopId();
		
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		
		model.addAttribute("contratoForm", new Contrato());		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/contratos";
	}
	
	
	@PostMapping("/crearcontrato")
	public String crearContrato(@Valid @ModelAttribute("contratoForm")Contrato contrato,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("contraDocumentoAdjuntos") MultipartFile[] filesContrato) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		String copNitString = req.getParameter("copNit");
		int copNit = Integer.parseInt(copNitString);
		String copNombre = req.getParameter("copNombre");
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;

		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		int copId = copropiedadDTO.getCopId();
		
		//String directoryNameHome = System.getProperty("user.home");
		//String uploadfolder=directoryNameHome;
		
		
		if(result.hasErrors()) {
			model.addAttribute("contratoForm", contrato);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				contrato.setContraLog(String.valueOf(usuId));
				//contrato = userService.createActividad(contrato);
				int idcontrato = contrato.getContraId();

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "contratos");
				String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesContrato.length; i++) {
				  
					  MultipartFile file = filesContrato[i];
					  String name = filesContrato[i].getOriginalFilename();					  
					  String formato = filesContrato[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    Contrato guardarContrato = new Contrato();
						    guardarContrato.setContraNumContrato(contrato.getContraNumContrato());
						    guardarContrato.setCopNit(copNit);
						    guardarContrato.setContraNombreContratista(contrato.getContraNombreContratista());
						    guardarContrato.setContraDescripcion(contrato.getContraDescripcion());
						    guardarContrato.setContraFechaInicio(contrato.getContraFechaInicio());
						    guardarContrato.setContraFechaFin(contrato.getContraFechaFin());
						    guardarContrato.setContraPlazo(contrato.getContraPlazo());
						    guardarContrato.setContraTiempo(contrato.getContraTiempo());
						    guardarContrato.setContraValor(contrato.getContraValor());
						    guardarContrato.setContraInterventor(contrato.getContraInterventor());
						    guardarContrato.setContraDocumentoAdjunto(codigoDescarga);
						    guardarContrato.setContraEstado(contrato.getContraEstado());
						    guardarContrato.setContraObservaciones(contrato.getContraEstado());
						    guardarContrato.setContraLog("");
						    guardarContrato.setContraVisualizacion(codigoVista);
						    
						    userService.createContrato(guardarContrato);
					    }			   
				  }
				
				
				model.addAttribute("contratoForm", contrato);
				model.addAttribute("bien","active");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("contratoForm", contrato);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("actividadeslist", userService.getActividadesByNit(copNit));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
			}
		}
		
        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("actividadeslist", userService.getActividadesByNit(copNit));
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
		
		return "administrador/contratos";
	}
	
	
	@RequestMapping("/consultacontratos")
	public String consultaContrato(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("contratolist", userService.getContratoByNit(copNit));
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
		
		return "administrador/consultacontratos";
	}

}
