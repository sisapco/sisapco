<<<<<<< HEAD
package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import co.com.sisapco.entity.Contrato;
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class EstadosFinancierosController {
	
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
	
	@RequestMapping("/uploadEstadosFinancieros")
	public String uploadEstadosFinancieros(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("estadosFinancierosForm", new EstadosFinancieros());
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
		model.addAttribute("rutaFormulario", "crearestadofinanciero");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadEstadosFinancieros";
	}
	
    //Crear estado financiero
	@PostMapping("/crearestadofinanciero")
	public String crearEstadoFinanciero(@Valid @ModelAttribute("estadosFinancierosForm")EstadosFinancieros estadosFinancieros,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("estArchivos") MultipartFile[] filesEstadosFinancieros) throws Exception {
		
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
			model.addAttribute("estadosFinancierosForm", estadosFinancieros);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				estadosFinancieros.setEstLog(String.valueOf(usuId));
				//int idcontrato = estadosFinancieros.getEstId();

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "estadosFinancieros");
				String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesEstadosFinancieros.length; i++) {
				  
					  MultipartFile file = filesEstadosFinancieros[i];
					  String name = filesEstadosFinancieros[i].getOriginalFilename();					  
					  String formato = filesEstadosFinancieros[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //Llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    EstadosFinancieros guardarEstadoFinanciero = new EstadosFinancieros();
						    guardarEstadoFinanciero.setCopNit(copNit);
						    guardarEstadoFinanciero.setEstNombreEstado(estadosFinancieros.getEstNombreEstado());
						    guardarEstadoFinanciero.setEstDescripcion(estadosFinancieros.getEstDescripcion());
						    guardarEstadoFinanciero.setEstMes(estadosFinancieros.getEstMes());
						    guardarEstadoFinanciero.setEstAno(estadosFinancieros.getEstAno());
						    guardarEstadoFinanciero.setEstArchivo(codigoDescarga);
						    guardarEstadoFinanciero.setEstEstado(estadosFinancieros.getEstEstado());
						    guardarEstadoFinanciero.setEstVisualizacion(codigoVista);
						    guardarEstadoFinanciero.setEstLog(estadosFinancieros.getEstLog());
						   
						    userService.createEstadosFinancieros(guardarEstadoFinanciero);
					    }			   
				  }
				
				
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
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
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearestadofinanciero");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultaestadosfinancieros";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadEstadosFinancieros";
	}

	//Consulta Estados Financieros
	@RequestMapping("/consultaestadosfinancieros")
	public String consultaComunicados(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("estadosfinancieroslist", userService.getEstadosFinancierosByNit(copNit));
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
		
		
        ///////////Ciframos el codigo del
        Iterable<EstadosFinancieros> estadosFinancieros = userService.getEstadosFinancierosByNit(copNit);
      
	    String estadosFinancierosIdEncryted ="";
	    int estId=0;		
	    for (EstadosFinancieros x: estadosFinancieros) {
		    estId = x.getEstId();
			String estadosFinancierosIdEcr = String.valueOf(estId);
			estadosFinancierosIdEncryted = encrypted.encrypted(estadosFinancierosIdEcr);
			estadosFinancierosIdEncryted = estadosFinancierosIdEncryted.replace("=", "co");
			x.setEstLog(estadosFinancierosIdEncryted);    
	    }

		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		model.addAttribute("activarEstadosFinancieros","active");
		
		return "administrador/documentacion";
	}
	
	@RequestMapping("/modEstadoFinanciero")
	public String modificarEstadoFinanciero(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
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
		String idEstadoFinancieroString = req.getParameter("est");
		MD5DatosGet decrypted = new MD5DatosGet();
		idEstadoFinancieroString = idEstadoFinancieroString.replace("co", "");
	    String idEstadoFinancieroDecrypted = decrypted.decrypted(idEstadoFinancieroString);
	    int idEstadoFinanciero = Integer.parseInt(idEstadoFinancieroDecrypted);
	    
	    EstadosFinancieros estadosFinancierosform = new EstadosFinancieros();
	    estadosFinancierosform = userService.getEstadosFinancierosByIdForm(idEstadoFinanciero);
	  
	    model.addAttribute("estadosFinancierosForm", estadosFinancierosform);		
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
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearpqrs");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultapqrs";
		model.addAttribute("rutamenu", menuAdmin);
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "actualizarestado");
		
		return "administrador/uploadEstadosFinancieros";
	}
	
    //Actualizar estado financiero
	@PostMapping("/actualizarestado")
	public String actualizarEstadoF(@Valid @ModelAttribute("estadosFinancierosForm")EstadosFinancieros estadosFinancieros,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, 
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
			model.addAttribute("estadosFinancierosForm", estadosFinancieros);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				//Asignamos el ID del usuario que esta modificar en el log			
				estadosFinancieros.setEstLog(String.valueOf(usuId));

			    EstadosFinancieros guardarEstadoFinanciero = new EstadosFinancieros();
			    guardarEstadoFinanciero.setEstId(estadosFinancieros.getEstId());
			    guardarEstadoFinanciero.setCopNit(estadosFinancieros.getCopNit());
			    guardarEstadoFinanciero.setEstNombreEstado(estadosFinancieros.getEstNombreEstado());
			    guardarEstadoFinanciero.setEstDescripcion(estadosFinancieros.getEstDescripcion());			    
			    guardarEstadoFinanciero.setEstMes(estadosFinancieros.getEstMes());
			    guardarEstadoFinanciero.setEstAno(estadosFinancieros.getEstAno());
			    guardarEstadoFinanciero.setEstEstado(estadosFinancieros.getEstEstado());
			    guardarEstadoFinanciero.setEstLog(estadosFinancieros.getEstLog());
			    userService.createEstadosFinancieros(guardarEstadoFinanciero);
			    
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
			}
		}
		model.addAttribute("estadosFinancierosForm", userService.getEstadosFinancierosByIdForm(estadosFinancieros.getEstId()));	
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
		model.addAttribute("rutaFormulario", "actualizarestado");
		//Inactivamos los campos
		model.addAttribute("inactivarcampos","true");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultaestadosfinancieros";
		model.addAttribute("rutamenu", menuAdmin);
				
		return "administrador/uploadEstadosFinancieros";
	}
}
=======
package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import co.com.sisapco.entity.Contrato;
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class EstadosFinancierosController {
	
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
	
	@RequestMapping("/uploadEstadosFinancieros")
	public String uploadEstadosFinancieros(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("estadosFinancierosForm", new EstadosFinancieros());
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
		model.addAttribute("rutaFormulario", "crearestadofinanciero");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadEstadosFinancieros";
	}
	
    //Crear estado financiero
	@PostMapping("/crearestadofinanciero")
	public String crearEstadoFinanciero(@Valid @ModelAttribute("estadosFinancierosForm")EstadosFinancieros estadosFinancieros,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("estArchivos") MultipartFile[] filesEstadosFinancieros) throws Exception {
		
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
			model.addAttribute("estadosFinancierosForm", estadosFinancieros);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				estadosFinancieros.setEstLog(String.valueOf(usuId));
				//int idcontrato = estadosFinancieros.getEstId();

				//Consultamos el ID de Google para guardar el contrato
				AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "estadosFinancieros");
				String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				//Guardar Imagenes Antes
				for (int i = 0; i < filesEstadosFinancieros.length; i++) {
				  
					  MultipartFile file = filesEstadosFinancieros[i];
					  String name = filesEstadosFinancieros[i].getOriginalFilename();					  
					  String formato = filesEstadosFinancieros[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //Llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    
						    EstadosFinancieros guardarEstadoFinanciero = new EstadosFinancieros();
						    guardarEstadoFinanciero.setCopNit(copNit);
						    guardarEstadoFinanciero.setEstNombreEstado(estadosFinancieros.getEstNombreEstado());
						    guardarEstadoFinanciero.setEstDescripcion(estadosFinancieros.getEstDescripcion());
						    guardarEstadoFinanciero.setEstMes(estadosFinancieros.getEstMes());
						    guardarEstadoFinanciero.setEstAno(estadosFinancieros.getEstAno());
						    guardarEstadoFinanciero.setEstArchivo(codigoDescarga);
						    guardarEstadoFinanciero.setEstEstado(estadosFinancieros.getEstEstado());
						    guardarEstadoFinanciero.setEstVisualizacion(codigoVista);
						    guardarEstadoFinanciero.setEstLog(estadosFinancieros.getEstLog());
						   
						    userService.createEstadosFinancieros(guardarEstadoFinanciero);
					    }			   
				  }
				
				
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
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
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearestadofinanciero");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultaestadosfinancieros";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadEstadosFinancieros";
	}

	//Consulta Estados Financieros
	@RequestMapping("/consultaestadosfinancieros")
	public String consultaComunicados(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("estadosfinancieroslist", userService.getEstadosFinancierosByNit(copNit));
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
		
		
        ///////////Ciframos el codigo del
        Iterable<EstadosFinancieros> estadosFinancieros = userService.getEstadosFinancierosByNit(copNit);
      
	    String estadosFinancierosIdEncryted ="";
	    int estId=0;		
	    for (EstadosFinancieros x: estadosFinancieros) {
		    estId = x.getEstId();
			String estadosFinancierosIdEcr = String.valueOf(estId);
			estadosFinancierosIdEncryted = encrypted.encrypted(estadosFinancierosIdEcr);
			estadosFinancierosIdEncryted = estadosFinancierosIdEncryted.replace("=", "co");
			x.setEstLog(estadosFinancierosIdEncryted);    
	    }

		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		model.addAttribute("activarEstadosFinancieros","active");
		
		return "administrador/documentacion";
	}
	
	@RequestMapping("/modEstadoFinanciero")
	public String modificarEstadoFinanciero(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
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
		String idEstadoFinancieroString = req.getParameter("est");
		MD5DatosGet decrypted = new MD5DatosGet();
		idEstadoFinancieroString = idEstadoFinancieroString.replace("co", "");
	    String idEstadoFinancieroDecrypted = decrypted.decrypted(idEstadoFinancieroString);
	    int idEstadoFinanciero = Integer.parseInt(idEstadoFinancieroDecrypted);
	    
	    EstadosFinancieros estadosFinancierosform = new EstadosFinancieros();
	    estadosFinancierosform = userService.getEstadosFinancierosByIdForm(idEstadoFinanciero);
	  
	    model.addAttribute("estadosFinancierosForm", estadosFinancierosform);		
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
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "crearpqrs");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultapqrs";
		model.addAttribute("rutamenu", menuAdmin);
		
		//Ruta Formulario
		model.addAttribute("rutaFormulario", "actualizarestado");
		
		return "administrador/uploadEstadosFinancieros";
	}
	
    //Actualizar estado financiero
	@PostMapping("/actualizarestado")
	public String actualizarEstadoF(@Valid @ModelAttribute("estadosFinancierosForm")EstadosFinancieros estadosFinancieros,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, 
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
			model.addAttribute("estadosFinancierosForm", estadosFinancieros);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				//Asignamos el ID del usuario que esta modificar en el log			
				estadosFinancieros.setEstLog(String.valueOf(usuId));

			    EstadosFinancieros guardarEstadoFinanciero = new EstadosFinancieros();
			    guardarEstadoFinanciero.setEstId(estadosFinancieros.getEstId());
			    guardarEstadoFinanciero.setCopNit(estadosFinancieros.getCopNit());
			    guardarEstadoFinanciero.setEstNombreEstado(estadosFinancieros.getEstNombreEstado());
			    guardarEstadoFinanciero.setEstDescripcion(estadosFinancieros.getEstDescripcion());			    
			    guardarEstadoFinanciero.setEstMes(estadosFinancieros.getEstMes());
			    guardarEstadoFinanciero.setEstAno(estadosFinancieros.getEstAno());
			    guardarEstadoFinanciero.setEstEstado(estadosFinancieros.getEstEstado());
			    guardarEstadoFinanciero.setEstLog(estadosFinancieros.getEstLog());
			    userService.createEstadosFinancieros(guardarEstadoFinanciero);
			    
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("estadosFinancierosForm", estadosFinancieros);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				model.addAttribute("activarmodalactualizar", "E");
			}
		}
		model.addAttribute("estadosFinancierosForm", userService.getEstadosFinancierosByIdForm(estadosFinancieros.getEstId()));	
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
		model.addAttribute("rutaFormulario", "actualizarestado");
		//Inactivamos los campos
		model.addAttribute("inactivarcampos","true");
		
		//Menu atras
		String menuAdmin = rutamenu+"consultaestadosfinancieros";
		model.addAttribute("rutamenu", menuAdmin);
				
		return "administrador/uploadEstadosFinancieros";
	}
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
