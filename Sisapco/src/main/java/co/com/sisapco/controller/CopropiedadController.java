package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.ControlPagos;
import co.com.sisapco.entity.Copropiedad;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class CopropiedadController {
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
	
	
	@RequestMapping("/copropiedad2")
	public String copropiedad(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		//Fecha Actual del sistema
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		
		Copropiedad copropiedadform = new Copropiedad();
		copropiedadform.setCopFechaCreacion(timeStamp);
	
		
		model.addAttribute("copropiedadForm", copropiedadform);		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		/*model.addAttribute("error","active");
		model.addAttribute("errorcampos","active");
		model.addAttribute("bien","active");*/
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/copropiedad";
	}
	
	
	//Crear copropiedad
	@PostMapping("/crearCopropiedad")
	public String crearCopropiedad(@Valid @ModelAttribute("copropiedadForm")ControlPagos controlPagos,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("controlAdjuntos") MultipartFile[] filesControlPagos) throws Exception {
		
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
		

		if(result.hasErrors()) {
			model.addAttribute("copropiedadForm", controlPagos);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				//controlPagos.setContraLog(String.valueOf(usuId));
				int idcontrolpagos = controlPagos.getControlId();

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "control_pagos");
				String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar adjunto
				for (int i = 0; i < filesControlPagos.length; i++) {
				  
					  MultipartFile file = filesControlPagos[i];
					  String name = filesControlPagos[i].getOriginalFilename();					  
					  String formato = filesControlPagos[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    ControlPagos guardarControlPagos = new ControlPagos();
						    
						    guardarControlPagos.setCopNit(copNit);
						    guardarControlPagos.setControlNombreProveedor(controlPagos.getControlNombreProveedor());
						    guardarControlPagos.setControlDescripcion(controlPagos.getControlDescripcion());
						    guardarControlPagos.setControlValor(controlPagos.getControlValor());
						    guardarControlPagos.setControlFechaPago(controlPagos.getControlFechaPago());
						    guardarControlPagos.setControlEstadoPago(controlPagos.getControlEstadoPago());
						    guardarControlPagos.setControlEstado(controlPagos.getControlEstado());
						    guardarControlPagos.setControlObservacion(controlPagos.getControlObservacion());
						    guardarControlPagos.setControlAdjunto(codigoDescarga);
						    guardarControlPagos.setControlEstado("");
						   
						    //Guardamos el formulario de control pagos
						    userService.createControlPagos(guardarControlPagos);
					    }			   
				  }
				
				
				model.addAttribute("controlpagosForm", controlPagos);
				model.addAttribute("bien","active");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("controlpagosForm", controlPagos);
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
		
		return "administrador/copropiedad";
	}
	

}
