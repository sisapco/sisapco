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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.Contrato;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class PqrsController {
	
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
	
	//Copropietario
	@RequestMapping("/pqrs")
	public String pqrs(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit =copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		
		int copId =  copropiedadDTO.getCopId();
		
		//consultamos el ultimo consecutivo
		Pqrs pqrsconsecutivo = userService.getPqrsByIdConsecutivoForm(copNit);
		int consecutivo = pqrsconsecutivo.getIdPqrs();
		consecutivo = consecutivo+1;
		model.addAttribute("consecutivopqrs", consecutivo);
		
		//Fecha Actual del sistema
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		
		Pqrs pqrsform = new Pqrs();
		pqrsform.setPqrsFechaCreacion(timeStamp);
		
		model.addAttribute("pqrsForm", pqrsform);		
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
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearpqrs");
		
		
		//Activamos el bloqueo de los campos
		model.addAttribute("respuestainactivarcampos","false");
		model.addAttribute("respuestainactivarcamposCreacion","true");
		model.addAttribute("respuestainactivarcamposRespuesta","true");
		model.addAttribute("vistarespuestainactivarcamposRespuesta","true");
		
		//Inactivamos el campo cedula con validacion
		model.addAttribute("respuestaCedula","true");
		
		//Activamos el campo para adjuntar archivos
		model.addAttribute("respuestaAdjunto","true");
		
		return "administrador/pqrs";
	}
	
	
	@PostMapping("/crearpqrs")
	public String crearPqrs(@Valid @ModelAttribute("pqrsForm")Pqrs pqrs,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("pqrsDocumentoAdjuntos") MultipartFile[] filesPqrs) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		String copNitString = req.getParameter("copNit");
		int copNit = Integer.parseInt(copNitString);
		String copNombre = req.getParameter("copNombre");
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
		int procc = userPanel.getProCc();

		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		int copId = copropiedadDTO.getCopId();
		
		//Fecha actual del sistema
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		pqrs.setPqrsFechaCreacion(timeStamp);
		
		if(result.hasErrors()) {
			model.addAttribute("pqrsForm", pqrs);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				//Asignamos el ID del usuario que esta registros la PQRS en el log
				pqrs.setPqrsLogs(String.valueOf(usuId));				

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGooglePqrs = userService.getAlmacenamientoGoogleByIdForm(copNit, "pqrs");
				String codigoGooglePqrs = almacenamientoGooglePqrs.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesPqrs.length; i++) {
				  
					  MultipartFile file = filesPqrs[i];
					  String name = filesPqrs[i].getOriginalFilename();					  
					  String formato = filesPqrs[i].getContentType();					 
					  byte[] bytes = file.getBytes();
					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGooglePqrs, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    Pqrs guardarPqrs = new Pqrs();
						    guardarPqrs.setCopNit(copNit);
						    guardarPqrs.setProCc(procc);
						    guardarPqrs.setProNombres(pqrs.getProNombres());
						    guardarPqrs.setProApellidos(pqrs.getProApellidos());
						    guardarPqrs.setProNumeroResidencia(pqrs.getProNumeroResidencia());
						    guardarPqrs.setPqrsEmail(pqrs.getPqrsEmail());
						    guardarPqrs.setPqrsTelefono(pqrs.getPqrsTelefono());
						    guardarPqrs.setPqrsDireccionCorrespondecia(pqrs.getPqrsDireccionCorrespondecia());						    
						    guardarPqrs.setPqrsDescripcionPqrs(pqrs.getPqrsDescripcionPqrs());
						    guardarPqrs.setPqrsEstado(pqrs.getPqrsEstado());
						    guardarPqrs.setPqrsAdjunto(codigoDescarga);
						    guardarPqrs.setPqrsFechaCreacion(pqrs.getPqrsFechaCreacion());
						    guardarPqrs.setPqrsFechaRespuesta(pqrs.getPqrsFechaRespuesta());
						    guardarPqrs.setPqrsVisualizacion(codigoVista);
						    guardarPqrs.setPqrsLogs(pqrs.getPqrsLogs());						  						 
						    userService.createPqrs(guardarPqrs);
					    }			   
				  }
				
				
				model.addAttribute("pqrsForm", pqrs);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("pqrsForm", pqrs);
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
		
		//Menu Atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		//consultamos el ultimo consecutivo
		Pqrs pqrsconsecutivo = userService.getPqrsByIdConsecutivoForm(copNit);
		int consecutivo = pqrsconsecutivo.getIdPqrs();
		consecutivo = consecutivo+1;
		model.addAttribute("consecutivopqrs", consecutivo);
		model.addAttribute("consecutivopqrsguardado", (consecutivo-1));
		
		//Activamos el bloqueo de los campos
		model.addAttribute("respuestainactivarcampos","false");
		model.addAttribute("respuestainactivarcamposCreacion","true");
		model.addAttribute("respuestainactivarcamposRespuesta","true");
		
		model.addAttribute("vistarespuestainactivarcamposRespuesta","false");
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearpqrs");
		
		return "administrador/pqrs";
	}
	
	
	@RequestMapping("/consultapqrs")
	public String consultaContrato(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//Instanciamos la clase MD5DatosGet para cifrar
		MD5DatosGet encrypted = new MD5DatosGet();
		
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
		
		model.addAttribute("pqrslist", userService.getPqrsByNit(copNit));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		model.addAttribute("perfil",userPanel.getPerId());
		
		//Validarmos si es perfil administrador para activarle botones de respuesta
		if(userPanel.getPerId() == 1) {
			model.addAttribute("activarRespuesta",true);
		}else {
			model.addAttribute("activarRespuesta",false);
		}
		
		//Activamos la respuesta del archivo adjunto
		model.addAttribute("activarRespuestaAdjunto",true);
		
        ///////////Ciframos el codigo del
        Iterable<Pqrs> pqrs= userService.getPqrsByNit(copNit);
        
        String pqrIdEncryted ="";
	    int pqrId=0;		
		for (Pqrs x: pqrs) {
			pqrId = x.getIdPqrs();
			String pqrIdEcr = String.valueOf(pqrId);
			pqrIdEncryted = encrypted.encrypted(pqrIdEcr);
			pqrIdEncryted = pqrIdEncryted.replace("=", "co");
			x.setPqrsLogs(pqrIdEncryted);
		}
				
		//Instanciamos la clase para cifrar el codigo
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//Menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/consultapqrs";
	}
	
	@RequestMapping("/respuestapqrs")
	public String pqrsRespuesta(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		/////Capturamos el codigo del pqrs y lo desencrytamos
		String idPqrsString = req.getParameter("Pqrs");
		MD5DatosGet decrypted = new MD5DatosGet();
		idPqrsString = idPqrsString.replace("co", "");
	    String idPqrsDecrypted = decrypted.decrypted(idPqrsString);
	    int idPqrs = Integer.parseInt(idPqrsDecrypted);
	    
	    //Fecha Actual del sistema, para asignarsela al campo de Fecha de Creación
	    String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		Pqrs pqrsform = new Pqrs();
		pqrsform = userService.getPqrsByIdForm(idPqrs);
		pqrsform.setPqrsFechaRespuesta(timeStamp);
	    
	    model.addAttribute("consecutivopqrs", idPqrs);
	    
	    model.addAttribute("pqrsForm", pqrsform);		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		model.addAttribute("respuesta","active");
		
		//Activamos el bloqueo de los campos
		model.addAttribute("respuestainactivarcampos","true");
		model.addAttribute("respuestainactivarcamposCreacion","true");
		//Inactivamos el campo cedula con validacion
		model.addAttribute("respuestaCedula","false");
		
		model.addAttribute("vistarespuestainactivarcamposRespuesta","true");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultapqrs";
		model.addAttribute("rutamenu", menuAdmin);
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "responderpqrs");
		
		return "administrador/pqrs";
	}
	
	//Responder PRQS Administrador
	@PostMapping("/responderpqrs")
	public String responderPqrs(@Valid @ModelAttribute("pqrsForm")Pqrs pqrs,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("pqrsDocumentoAdjuntos") MultipartFile[] filesPqrs, @RequestParam("pqrsAdjuntoRespuestas") MultipartFile[] filesPqrsRespuesta) throws Exception {
		
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
			model.addAttribute("pqrsForm", pqrs);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				//Asignamos el ID del usuario que esta registros la PQRS en el log
				pqrs.setPqrsLogs(String.valueOf(usuId));				

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGooglePqrs = userService.getAlmacenamientoGoogleByIdForm(copNit, "pqrs");
				String codigoGooglePqrs = almacenamientoGooglePqrs.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				String codigoDescarga ="";
				String codigoVista ="";
				String codigoDescargaRespuesta ="";
				String codigoVistaRespuesta ="";
				
				//Guardar Archivo Adjunto en google
				for (int i = 0; i < filesPqrs.length; i++) {
				  
					  MultipartFile file = filesPqrs[i];
					  String name = filesPqrs[i].getOriginalFilename();					  
					  String formato = filesPqrs[i].getContentType();					 
					  byte[] bytes = file.getBytes();
					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGooglePqrs, formato, name, bytes);						    
						    codigoDescarga = googleFile.getWebContentLink();
						    codigoVista = googleFile.getWebViewLink();
						    
					    }			   
				 }
				
				//Guardar Archivo Adjunto Respuesta en google
				for (int i = 0; i < filesPqrsRespuesta.length; i++) {
				  
					  MultipartFile file = filesPqrsRespuesta[i];
					  String name = filesPqrsRespuesta[i].getOriginalFilename();					  
					  String formato = filesPqrsRespuesta[i].getContentType();					 
					  byte[] bytes = file.getBytes();
					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGooglePqrs, formato, name, bytes);						    
						    codigoDescargaRespuesta = googleFile.getWebContentLink();
						    codigoVistaRespuesta = googleFile.getWebViewLink();
						    
					    }			   
				 }
				
				//Guardamos la respuesta en base de datos
				Pqrs guardarPqrs = new Pqrs();
			    guardarPqrs.setIdPqrs(pqrs.getIdPqrs());
			    guardarPqrs.setCopNit(pqrs.getCopNit());
			    guardarPqrs.setProCc(pqrs.getProCc());
			    guardarPqrs.setProNombres(pqrs.getProNombres());
			    guardarPqrs.setProApellidos(pqrs.getProApellidos());
			    guardarPqrs.setProNumeroResidencia(pqrs.getProNumeroResidencia());
			    guardarPqrs.setPqrsEmail(pqrs.getPqrsEmail());
			    guardarPqrs.setPqrsTelefono(pqrs.getPqrsTelefono());
			    guardarPqrs.setPqrsDireccionCorrespondecia(pqrs.getPqrsDireccionCorrespondecia());						    
			    guardarPqrs.setPqrsDescripcionPqrs(pqrs.getPqrsDescripcionPqrs());
			    guardarPqrs.setPqrsEstado(pqrs.getPqrsEstado());
			    guardarPqrs.setPqrsAdjunto(pqrs.getPqrsAdjunto());
			    guardarPqrs.setPqrsFechaCreacion(pqrs.getPqrsFechaCreacion());
			    guardarPqrs.setPqrsFechaRespuesta(pqrs.getPqrsFechaRespuesta());
			    guardarPqrs.setPqrsVisualizacion(pqrs.getPqrsVisualizacion());
			    guardarPqrs.setPqrsRespuestaPqrs(pqrs.getPqrsRespuestaPqrs());
			    
			    //Validamos que el codigo de descarga de la respuesta este lleno
			    if(codigoDescargaRespuesta!=""){
			    	  guardarPqrs.setPqrsAdjuntoRespuesta(codigoDescargaRespuesta);
			    }else{
			    	 guardarPqrs.setPqrsAdjuntoRespuesta(pqrs.getPqrsAdjuntoRespuesta());
			    }
			  
			    guardarPqrs.setPqrsLogs(pqrs.getPqrsLogs());						  						 
			    userService.createPqrs(guardarPqrs);
			    			   
				model.addAttribute("pqrsForm", pqrs);
				model.addAttribute("bienrespuesta","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("pqrsForm", pqrs);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
			}
		}
		model.addAttribute("pqrsForm", userService.getPqrsByIdForm(pqrs.getIdPqrs()));	
        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("rutaroot", "");
		model.addAttribute("seguimiento", "");
		model.addAttribute("copId", copId);
		model.addAttribute("consecutivopqrs", pqrs.getIdPqrs());
			
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//Activamos el bloqueo de los campos
		model.addAttribute("respuestainactivarcampos","true");
		model.addAttribute("respuestainactivarcamposCreacion","true");
		
		model.addAttribute("vistarespuestainactivarcamposRespuesta","true");
		
		//Inactivamos el campo cedula con validacion
		model.addAttribute("respuestaCedula","false");
		model.addAttribute("respuesta","active");
		
		//Inactivamos el campo para adjuntar archivos
		model.addAttribute("respuestaAdjunto","false");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultapqrs";
		model.addAttribute("rutamenu", menuAdmin);
		
		//Ruta Formulario
	    model.addAttribute("rutaFormulario", "responderpqrs");
		
		return "administrador/pqrs";
	}

}
