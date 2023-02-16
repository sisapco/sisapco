package co.com.sisapco.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
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
import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.Copropiedad;
import co.com.sisapco.entity.EvidenciaActividades;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;


import org.springframework.boot.context.properties.ConfigurationProperties;

@Controller
public class ActividadesController {
	
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
	
	
	@RequestMapping("/seguimientotareasadmin")
	public String seguimientoTareasAdmin(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//Instanciamos la clase MD5DatosGet para cifrar
		MD5DatosGet encrypted = new MD5DatosGet();
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		
		int copId = copropiedadDTO.getCopId();
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
        ///////////Ciframos el campo copId
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		
		///////////Ciframos el codigo de la actividad
        Iterable<Actividades> actividades= userService.getActividadesByNit(copNit);
        
	    String actIdEncryted ="";
	    int actId=0;		
		for (Actividades x: actividades) {
			actId = x.getActId();
			String actIdEcr = String.valueOf(actId);
			actIdEncryted = encrypted.encrypted(actIdEcr);
			actIdEncryted = actIdEncryted.replace("=", "co");
		    x.setActLog(actIdEncryted);
		}

		model.addAttribute("actividadeslist", actividades);
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);		
		model.addAttribute("copIdEncryted", copIdEncryted);		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/seguimientotareasadmin";
	}
	
	@RequestMapping("/asignaractividadesadmin")
	public String asignarActividadesAdmin(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit =copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		
		int copId =  copropiedadDTO.getCopId();
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
				
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		
		
		model.addAttribute("actividadesForm", new Actividades());
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("actividadeslist", userService.getActividadesByNit(copNit));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		return "administrador/asignaractividadesadmin";
	}
	
	
	@PostMapping("/crearactividadesadmin")
	public String crearActividadesAdmin(@Valid @ModelAttribute("actividadesForm")Actividades actividades,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("actEvidenciaAntes") MultipartFile[] filesAntes, @RequestParam("actEvidenciaDespues") MultipartFile[] filesDespues) throws Exception {
		
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
		
		String directoryNameHome = System.getProperty("user.home");
		String uploadfolder=directoryNameHome;
		
		if(result.hasErrors()) {
			model.addAttribute("actividadesForm", actividades);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				actividades.setActLog(String.valueOf(usuId));
				actividades = userService.createActividad(actividades);
				int idactividad = actividades.getActId();

				//Consultamos el ID de Google para guardar las imagenenes de Evidencia Antes y despues
				AlmacenamientoGoogle almacenamientoGoogleAntes = userService.getAlmacenamientoGoogleByIdForm(copNit, "evidencia_antes");
				AlmacenamientoGoogle almacenamientoGoogleDespues = userService.getAlmacenamientoGoogleByIdForm(copNit, "evidencia_despues");
				String codigoGoogleAntes = almacenamientoGoogleAntes.getAlmaIdcarpeta();
				String codigoGoogleDespues = almacenamientoGoogleDespues.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesAntes.length; i++) {
				  
					  MultipartFile file = filesAntes[i];
					  String name = filesAntes[i].getOriginalFilename();					  
					  String formato = filesAntes[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleAntes, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    EvidenciaActividades evidenciaActividades = new EvidenciaActividades();
						    
						    evidenciaActividades.setActId(idactividad);
						    evidenciaActividades.setEviNombreImagen(name);
						    evidenciaActividades.setEviRutaImagen(codigoDescarga);
						    evidenciaActividades.setEviVisualizacion(codigoVista);
						    
						    evidenciaActividades.setEviFormatoImagen(formato);
						    evidenciaActividades.setEviEstadoImagen("1");
						    evidenciaActividades.setEviAntesDespues("A");
						    userService.createEvidenciaActividad(evidenciaActividades);
					    }			   
				  }
				
				//Guardar Imagenes Despues
				for (int i = 0; i < filesDespues.length; i++) {
				  
					  MultipartFile file = filesDespues[i];
					  String name = filesDespues[i].getOriginalFilename();
					  String formato = filesDespues[i].getContentType();
					  
					  byte[] bytes = file.getBytes();
					  
					    if(!file.isEmpty()) {					    	 						    
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleDespues, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    EvidenciaActividades evidenciaActividades = new EvidenciaActividades();
						    
						    evidenciaActividades.setActId(idactividad);
						    evidenciaActividades.setEviNombreImagen(name);						    
						    evidenciaActividades.setEviRutaImagen(codigoDescarga);
						    evidenciaActividades.setEviVisualizacion(codigoVista);
						    
						    evidenciaActividades.setEviFormatoImagen(formato);
						    evidenciaActividades.setEviEstadoImagen("1");
						    evidenciaActividades.setEviAntesDespues("D");
						    userService.createEvidenciaActividad(evidenciaActividades);
					    }			   
				  }
				
				
				model.addAttribute("actividadesForm", actividades);
				model.addAttribute("bien","active");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("actividadesForm", actividades);
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
		model.addAttribute("rutaroot", directoryNameHome);
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
		
		return "administrador/asignaractividadesadmin";
	}
	
	@RequestMapping("/visualizaractividades")
	public String visualizaractividades(@Valid @ModelAttribute("actividadesForm")Actividades actividades,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
			
		/////Capturamos el codigo de la propiedad y lo desencrytamos
		String actIdString = req.getParameter("actId");
		MD5DatosGet decrypted = new MD5DatosGet();
		actIdString = actIdString.replace("co", "");
	    String actIdDecrypted = decrypted.decrypted(actIdString);
	    int actId = Integer.parseInt(actIdDecrypted);
		
		String directoryName = System.getProperty("user.home");
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit =copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();		
		int copId = copropiedadDTO.getCopId();
		

		//Formateamos las fechas
		//Instanciamos el objeto de Actividades
		//Actividades actividadesMod = new Actividades();
		//actividadesMod = userService.getActividadesByIdForm(actId);
		
		//Le damos el formato a la fecha
		//String formato = "MM/dd/yyyy";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
		//String actFechaEntregaRealMod = simpleDateFormat.format(actividadesMod.getActFechaEntregaReal());
		
		//Date fechaConvertida =  (Date) simpleDateFormat.parse(actFechaEntregaRealMod);
		//fechaConvertida = (Date) simpleDateFormat.parse(actFechaEntregaRealMod);
		
		//actividadesMod.setActFechaEntregaReal(fechaConvertida);
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("actividadesForm", userService.getActividadesByIdForm(actId));
		model.addAttribute("actividadeslist", userService.getActividadesByIdForm(actId));
		model.addAttribute("evidenciaactividadeslist", userService.getEvidenciaActividadesByActId(actId));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("rutaroot", directoryName);
		model.addAttribute("copId", copId);
		
		model.addAttribute("codAntes", 'A');
		model.addAttribute("codDespues", 'D');
		
		//Instanciamos la clase MD5DatosGet para cifrar el copId
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		String menuAdminSeguimiento = rutamenu+"seguimientotareasadmin";
		model.addAttribute("rutamenu", menuAdmin);
		model.addAttribute("rutamenuseguimiento", menuAdminSeguimiento);
		
		return "administrador/visualizaractividades";
	}
	
	//Actualizar Actividades
	@PostMapping("/actualizaractividadesadmin")
	public String actualizarActividadesAdmin(@Valid @ModelAttribute("actividadesForm")Actividades actividades,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("actEvidenciaAntes") MultipartFile[] filesAntes, @RequestParam("actEvidenciaDespues") MultipartFile[] filesDespues) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		String copNitString = req.getParameter("copNit");
		int copNit = Integer.parseInt(copNitString);
		String copNombre = req.getParameter("copNombre");
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
		int actId = actividades.getActId();
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		int copId = copropiedadDTO.getCopId();
		
		String directoryNameHome = System.getProperty("user.home");

		//debug
		String seguimiento ="";
	
		if(result.hasErrors()) {
			model.addAttribute("actividadesForm", actividades);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				actividades.setActLog(String.valueOf(usuId));
				actividades = userService.createActividad(actividades);
				int idactividad = actividades.getActId();
				seguimiento = seguimiento+"-1";
				
				//Consultamos el ID de Google para guardar las imagenenes de Evidencia Antes y despues
				AlmacenamientoGoogle almacenamientoGoogleAntes = userService.getAlmacenamientoGoogleByIdForm(copNit, "evidencia_antes");
				AlmacenamientoGoogle almacenamientoGoogleDespues = userService.getAlmacenamientoGoogleByIdForm(copNit, "evidencia_despues");
				String codigoGoogleAntes = almacenamientoGoogleAntes.getAlmaIdcarpeta();
				String codigoGoogleDespues = almacenamientoGoogleDespues.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesAntes.length; i++) {				  
					  MultipartFile file = filesAntes[i];
					  String name = filesAntes[i].getOriginalFilename();					  
					  String formato = filesAntes[i].getContentType();
					  
					  byte[] bytes = file.getBytes();
					  seguimiento = seguimiento+"-2";
					  
					    if(!file.isEmpty()) {
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleAntes, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    EvidenciaActividades evidenciaActividades = new EvidenciaActividades();
						    
						    evidenciaActividades.setActId(idactividad);
						    evidenciaActividades.setEviNombreImagen(name);
						    evidenciaActividades.setEviRutaImagen(codigoDescarga);
						    evidenciaActividades.setEviVisualizacion(codigoVista);
						    evidenciaActividades.setEviFormatoImagen(formato);
						    evidenciaActividades.setEviEstadoImagen("1");
						    evidenciaActividades.setEviAntesDespues("A");
						    userService.createEvidenciaActividad(evidenciaActividades);
						   
					    }			   
				  }
				
				//Guardar Imagenes Despues
				for (int i = 0; i < filesDespues.length; i++) {
				  
					  MultipartFile file = filesDespues[i];
					  String name = filesDespues[i].getOriginalFilename();
					  String formato = filesAntes[i].getContentType();
					  
					  byte[] bytes = file.getBytes();
					  
					    if(!file.isEmpty()) {					    	
							//llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleDespues, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    EvidenciaActividades evidenciaActividades = new EvidenciaActividades();
						    
						    evidenciaActividades.setActId(idactividad);
						    evidenciaActividades.setEviNombreImagen(name);
						    evidenciaActividades.setEviRutaImagen(codigoDescarga);
						    evidenciaActividades.setEviVisualizacion(codigoVista);
						    evidenciaActividades.setEviFormatoImagen(formato);
						    evidenciaActividades.setEviEstadoImagen("1");
						    evidenciaActividades.setEviAntesDespues("D");
						    userService.createEvidenciaActividad(evidenciaActividades);						    
					    }			   
				  }
				
				
				model.addAttribute("actividadesForm", actividades);
				model.addAttribute("bien","active");
				
			} catch (Exception e) {
				seguimiento= seguimiento+" error:"+e;
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("actividadesForm", actividades);
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
		
		model.addAttribute("actividadesForm", userService.getActividadesByIdForm(actId));
		model.addAttribute("actividadeslist", userService.getActividadesByIdForm(actId));
		model.addAttribute("Evidenciaactividadeslist", userService.getEvidenciaActividadesByActId(actId));

		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("rutaroot", directoryNameHome);
		model.addAttribute("seguimiento", seguimiento);
		model.addAttribute("copId", copId);
		
		//Instanciamos la clase MD5DatosGet para cifrar el copId
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		String menuAdminSeguimiento = rutamenu+"seguimientotareasadmin";
		model.addAttribute("rutamenu", menuAdmin);
		model.addAttribute("rutamenuseguimiento", menuAdminSeguimiento);
				
	    //return "administrador/visualizaractividades";
		
		return "administrador/seguimientotareasadmin";
	}

}
