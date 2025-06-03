<<<<<<< HEAD
package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class ManualConvivenciaController {
	
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
	
	@RequestMapping("/uploadManualConvivencia")
	public String uploadManualConvivencia(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("manualConvivenciaForm", new ManualConvivencia());
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Activamos el adjunto
		model.addAttribute("modificar","active");
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearmanualconviviencia");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadManualConvivencia";
	}
	
	//Crear Manual Conviviencia
    @PostMapping("/crearmanualconviviencia")
    public String crearManualConviviencia(@Valid @ModelAttribute("manualConvivenciaForm")ManualConvivencia manualConvivencia,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
	@RequestParam("conviArchivos") MultipartFile[] filesManualConvivencia) throws Exception {
			
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
			model.addAttribute("manualConvivenciaForm", manualConvivencia);
			model.addAttribute("errorcampos","active");
		}else {
			try {				
				manualConvivencia.setConviLog(String.valueOf(usuId));
				
				//int idcontrato = estadosFinancieros.getEstId();

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "manualConvivencia");
				String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesManualConvivencia.length; i++) {
				  
					  MultipartFile file = filesManualConvivencia[i];
					  String name = filesManualConvivencia[i].getOriginalFilename();					  
					  String formato = filesManualConvivencia[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //Llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    ManualConvivencia guardarManualConvivencia = new ManualConvivencia();						    
						    guardarManualConvivencia.setCopNit(copNit);
						    guardarManualConvivencia.setConviNombre(manualConvivencia.getConviNombre());
						    guardarManualConvivencia.setConviArchivo(codigoDescarga);
						    guardarManualConvivencia.setConviAnoPublicacion(manualConvivencia.getConviAnoPublicacion());
						    guardarManualConvivencia.setConviEstado(manualConvivencia.getConviEstado());
						    guardarManualConvivencia.setConviLog(manualConvivencia.getConviLog());
						    guardarManualConvivencia.setConviVisualizacion(codigoVista);
						    
						    userService.createManualConvivencia(guardarManualConvivencia);
					    }			   
				  }
				
				
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("actividadeslist", userService.getActividadesByNit(copNit));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
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
		String menuAdmin = rutamenu+"consultamanualconvivencia";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadManualConvivencia";
	}
    
	//Consulta Manual de convivencia
	@RequestMapping("/consultamanualconvivencia")
	public String consultaManualConvivencia(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("manualconvivencialist", userService.getManualConvivenciaByNit(copNit));		                
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
	
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Activamos el boton modificar solo para el administrador
		if(userPanel.getPerId() == 1) {
			model.addAttribute("activarRespuesta","active");
		}else {
			model.addAttribute("activarRespuesta","false");
		}

		///////////Ciframos el id del manual de covivencia
        Iterable<ManualConvivencia> manualConvivencia = userService.getManualConvivenciaByNit(copNit);
      
	    String manualConvivenciaIdEncryted ="";
	    int estId=0;		
	    for (ManualConvivencia x: manualConvivencia) {
		    estId = x.getConviId();
			String manualConvivenciaIdEcr = String.valueOf(estId);
			manualConvivenciaIdEncryted = encrypted.encrypted(manualConvivenciaIdEcr);
			manualConvivenciaIdEncryted = manualConvivenciaIdEncryted.replace("=", "co");
			x.setConviLog(manualConvivenciaIdEncryted);    
	    }
		
		//Instanciamos la clase para cifrar el codigo
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		model.addAttribute("activarManualConvivencia","active");
		
		return "administrador/documentacion";
	}
	
	//Formulario para modificar el estado
	@RequestMapping("/modManuelConvivencia")
	public String modificarManuelConvivencia(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
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
		
		/////Capturamos el codigo del manual de convivencia y lo desencrytamos
		String idManualConvivenciaString = req.getParameter("manualc");
		MD5DatosGet decrypted = new MD5DatosGet();
		idManualConvivenciaString = idManualConvivenciaString.replace("co", "");
	    String idManualConvivenciaDecrypted = decrypted.decrypted(idManualConvivenciaString);
	    int idManualConvivencia = Integer.parseInt(idManualConvivenciaDecrypted);
	    
	    ManualConvivencia manualConvivenciaform = new ManualConvivencia();
	    manualConvivenciaform = userService.getManualConvivenciaByIdForm(idManualConvivencia);
	    
	    model.addAttribute("manualConvivenciaForm", manualConvivenciaform);		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Inactivamos los campos
		model.addAttribute("inactivarcampos","true");
				
		//Menu atras
		String menuAdmin = rutamenu+"consultamanualconvivencia";
		model.addAttribute("rutamenu", menuAdmin);
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "actualizarestadoMC");
		
		return "administrador/uploadManualConvivencia";
	}
	
    //Actualizar estado manual de convivencia
	@PostMapping("/actualizarestadoMC")
	public String actualizarEstadoMC(@Valid @ModelAttribute("manualConvivenciaForm")ManualConvivencia manualConvivencia,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		
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
			model.addAttribute("manualConvivenciaForm", manualConvivencia);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				//Asignamos el ID del usuario que esta modificar en el log			
				manualConvivencia.setConviLog(String.valueOf(usuId));

				ManualConvivencia guardarManualConvivencia = new ManualConvivencia();
				guardarManualConvivencia.setConviId(manualConvivencia.getConviId());
				guardarManualConvivencia.setCopNit(manualConvivencia.getCopNit());
				guardarManualConvivencia.setConviNombre(manualConvivencia.getConviNombre());
				guardarManualConvivencia.setConviAnoPublicacion(manualConvivencia.getConviAnoPublicacion());
				guardarManualConvivencia.setConviEstado(manualConvivencia.getConviEstado());
				guardarManualConvivencia.setConviLog(manualConvivencia.getConviLog());
				
			    userService.createManualConvivencia(guardarManualConvivencia);
			    
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
			}
		}
		//model.addAttribute("manualConvivenciaForm", userService.getEstadosFinancierosByIdForm(estadosFinancieros.getEstId()));	
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
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "actualizarestadoMC");
		//Inactivamos los campos
		model.addAttribute("inactivarcampos","true");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultamanualconvivencia";
		model.addAttribute("rutamenu", menuAdmin);
				
		return "administrador/uploadManualConvivencia";
	}
		
}
=======
package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class ManualConvivenciaController {
	
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
	
	@RequestMapping("/uploadManualConvivencia")
	public String uploadManualConvivencia(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("manualConvivenciaForm", new ManualConvivencia());
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Activamos el adjunto
		model.addAttribute("modificar","active");
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearmanualconviviencia");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadManualConvivencia";
	}
	
	//Crear Manual Conviviencia
    @PostMapping("/crearmanualconviviencia")
    public String crearManualConviviencia(@Valid @ModelAttribute("manualConvivenciaForm")ManualConvivencia manualConvivencia,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
	@RequestParam("conviArchivos") MultipartFile[] filesManualConvivencia) throws Exception {
			
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
			model.addAttribute("manualConvivenciaForm", manualConvivencia);
			model.addAttribute("errorcampos","active");
		}else {
			try {				
				manualConvivencia.setConviLog(String.valueOf(usuId));
				
				//int idcontrato = estadosFinancieros.getEstId();

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "manualConvivencia");
				String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesManualConvivencia.length; i++) {
				  
					  MultipartFile file = filesManualConvivencia[i];
					  String name = filesManualConvivencia[i].getOriginalFilename();					  
					  String formato = filesManualConvivencia[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //Llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    ManualConvivencia guardarManualConvivencia = new ManualConvivencia();						    
						    guardarManualConvivencia.setCopNit(copNit);
						    guardarManualConvivencia.setConviNombre(manualConvivencia.getConviNombre());
						    guardarManualConvivencia.setConviArchivo(codigoDescarga);
						    guardarManualConvivencia.setConviAnoPublicacion(manualConvivencia.getConviAnoPublicacion());
						    guardarManualConvivencia.setConviEstado(manualConvivencia.getConviEstado());
						    guardarManualConvivencia.setConviLog(manualConvivencia.getConviLog());
						    guardarManualConvivencia.setConviVisualizacion(codigoVista);
						    
						    userService.createManualConvivencia(guardarManualConvivencia);
					    }			   
				  }
				
				
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("actividadeslist", userService.getActividadesByNit(copNit));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
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
		String menuAdmin = rutamenu+"consultamanualconvivencia";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadManualConvivencia";
	}
    
	//Consulta Manual de convivencia
	@RequestMapping("/consultamanualconvivencia")
	public String consultaManualConvivencia(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("manualconvivencialist", userService.getManualConvivenciaByNit(copNit));		                
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
	
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Activamos el boton modificar solo para el administrador
		if(userPanel.getPerId() == 1) {
			model.addAttribute("activarRespuesta","active");
		}else {
			model.addAttribute("activarRespuesta","false");
		}

		///////////Ciframos el id del manual de covivencia
        Iterable<ManualConvivencia> manualConvivencia = userService.getManualConvivenciaByNit(copNit);
      
	    String manualConvivenciaIdEncryted ="";
	    int estId=0;		
	    for (ManualConvivencia x: manualConvivencia) {
		    estId = x.getConviId();
			String manualConvivenciaIdEcr = String.valueOf(estId);
			manualConvivenciaIdEncryted = encrypted.encrypted(manualConvivenciaIdEcr);
			manualConvivenciaIdEncryted = manualConvivenciaIdEncryted.replace("=", "co");
			x.setConviLog(manualConvivenciaIdEncryted);    
	    }
		
		//Instanciamos la clase para cifrar el codigo
		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		model.addAttribute("activarManualConvivencia","active");
		
		return "administrador/documentacion";
	}
	
	//Formulario para modificar el estado
	@RequestMapping("/modManuelConvivencia")
	public String modificarManuelConvivencia(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
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
		
		/////Capturamos el codigo del manual de convivencia y lo desencrytamos
		String idManualConvivenciaString = req.getParameter("manualc");
		MD5DatosGet decrypted = new MD5DatosGet();
		idManualConvivenciaString = idManualConvivenciaString.replace("co", "");
	    String idManualConvivenciaDecrypted = decrypted.decrypted(idManualConvivenciaString);
	    int idManualConvivencia = Integer.parseInt(idManualConvivenciaDecrypted);
	    
	    ManualConvivencia manualConvivenciaform = new ManualConvivencia();
	    manualConvivenciaform = userService.getManualConvivenciaByIdForm(idManualConvivencia);
	    
	    model.addAttribute("manualConvivenciaForm", manualConvivenciaform);		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Inactivamos los campos
		model.addAttribute("inactivarcampos","true");
				
		//Menu atras
		String menuAdmin = rutamenu+"consultamanualconvivencia";
		model.addAttribute("rutamenu", menuAdmin);
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "actualizarestadoMC");
		
		return "administrador/uploadManualConvivencia";
	}
	
    //Actualizar estado manual de convivencia
	@PostMapping("/actualizarestadoMC")
	public String actualizarEstadoMC(@Valid @ModelAttribute("manualConvivenciaForm")ManualConvivencia manualConvivencia,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		
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
			model.addAttribute("manualConvivenciaForm", manualConvivencia);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				//Asignamos el ID del usuario que esta modificar en el log			
				manualConvivencia.setConviLog(String.valueOf(usuId));

				ManualConvivencia guardarManualConvivencia = new ManualConvivencia();
				guardarManualConvivencia.setConviId(manualConvivencia.getConviId());
				guardarManualConvivencia.setCopNit(manualConvivencia.getCopNit());
				guardarManualConvivencia.setConviNombre(manualConvivencia.getConviNombre());
				guardarManualConvivencia.setConviAnoPublicacion(manualConvivencia.getConviAnoPublicacion());
				guardarManualConvivencia.setConviEstado(manualConvivencia.getConviEstado());
				guardarManualConvivencia.setConviLog(manualConvivencia.getConviLog());
				
			    userService.createManualConvivencia(guardarManualConvivencia);
			    
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("manualConvivenciaForm", manualConvivencia);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
			}
		}
		//model.addAttribute("manualConvivenciaForm", userService.getEstadosFinancierosByIdForm(estadosFinancieros.getEstId()));	
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
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "actualizarestadoMC");
		//Inactivamos los campos
		model.addAttribute("inactivarcampos","true");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultamanualconvivencia";
		model.addAttribute("rutamenu", menuAdmin);
				
		return "administrador/uploadManualConvivencia";
	}
		
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
