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
import co.com.sisapco.entity.Actas;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.Comunicados;
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.EnvioEmail;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class ComunicadosController {
	
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
	
    @Autowired
    private EnvioEmail envioEmail;
	
	@RequestMapping("/uploadComunicados")
	public String uploadComunicados(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		 //Fecha Actual del sistema, para asignarsela al campo de Fecha de Creación
	    String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	    Comunicados comunicadosform = new Comunicados();
		comunicadosform.setComuFecha(timeStamp);
		model.addAttribute("fechaDeCargaPrecargada", timeStamp);
		
		model.addAttribute("comunicadosForm",comunicadosform );
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
		model.addAttribute("rutaFormulario", "crearcomunicado");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadComunicados";
	}
	
	   //Crear Comunicados
		@PostMapping("/crearcomunicado")
		public String crearComunicado(@Valid @ModelAttribute("comunicadosForm")Comunicados comunicados,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
				@RequestParam("comuArchivos") MultipartFile[] filesComunicados) throws Exception {
			
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
				model.addAttribute("comunicadosForm", comunicados);
				model.addAttribute("errorcampos","active");
			}else {
				try {
					
					comunicados.setComuLog(String.valueOf(usuId));
					
					//Consultamos el ID de Google para guardar el contrato
					AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "comunicados");
					String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
					
					//Instanciar la clase de google para guardar la imagen
					CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				    String codigoDescarga = "";
				    String codigoVista = "";
					
					//Guardar Imagenes Antes
					for (int i = 0; i < filesComunicados.length; i++) {
					  
						  MultipartFile file = filesComunicados[i];
						  String name = filesComunicados[i].getOriginalFilename();					  
						  String formato = filesComunicados[i].getContentType();					 
						  byte[] bytes = file.getBytes();

						  
						    if(!file.isEmpty()) {						         
							    //Llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
						        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
							    codigoDescarga = googleFile.getWebContentLink();
							    codigoVista = googleFile.getWebViewLink();
							    
							    Comunicados guardarComunicados = new Comunicados();							    
							    guardarComunicados.setCopNit(copNit);
							    guardarComunicados.setComuNombre(comunicados.getComuNombre());
							    guardarComunicados.setComuFecha(comunicados.getComuFecha());
							    guardarComunicados.setComuEstado(comunicados.getComuEstado());
							    guardarComunicados.setComuDescripcion(comunicados.getComuDescripcion());
							    guardarComunicados.setComuArchivo(codigoDescarga);
							    guardarComunicados.setComuLog(comunicados.getComuLog());
							    guardarComunicados.setComuVisualizacion(codigoVista);
							    							   
							    userService.createComunicados(guardarComunicados);
						    }			   
					  }
					
					//Madamos el email
					String contenidoEmail=comunicados.getComuDescripcion()+"\\n Para visualizar el comunicado de click en el siguiente enlace: "+codigoVista;
					try {
					     envioEmail.send("sisapcoweb@gmail.com", "sisapcoweb@gmail.com", comunicados.getComuNombre(), contenidoEmail);
					}
					catch (Exception e) {
						model.addAttribute("errorEmail","active");
						model.addAttribute("errorEmailMensaje",e.getMessage()+" - "+e.getCause());
					}
					
					model.addAttribute("comunicadosForm", comunicados);
					model.addAttribute("bien","active");
					model.addAttribute("activarmodalactualizar", "A");
					
				} catch (Exception e) {
					model.addAttribute("error","active");
					model.addAttribute("formErrorMessage",e.getMessage());
					model.addAttribute("comunicadosForm", comunicados);
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
			String menuAdmin = rutamenu+"consultacomunicados";
			model.addAttribute("rutamenu", menuAdmin);
			
			return "administrador/uploadComunicados";
		}
		
		//Consulta Comunicados
		@RequestMapping("/consultacomunicados")
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
			
			model.addAttribute("comunicadoslist", userService.getComunicadosByNit(copNit));
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
			
	        ///////////Ciframos el id del comunicado
	        Iterable<Comunicados> comunicados = userService.getComunicadosByNit(copNit);
	        	      
		    String comunicadosIdEncryted ="";
		    int comuId=0;		
		    for (Comunicados x: comunicados) {
		    	comuId = x.getComuId();
				String comunicadosIdEcr = String.valueOf(comuId);
				comunicadosIdEncryted = encrypted.encrypted(comunicadosIdEcr);
				comunicadosIdEncryted = comunicadosIdEncryted.replace("=", "co");   
				x.setComuLog(comunicadosIdEncryted);
		    }
			
			//Instanciamos la clase para cifrar el codigo
			String copIdEcr = String.valueOf(copId);
		    String copIdEncryted ="";
			copIdEncryted = encrypted.encrypted(copIdEcr);
			copIdEncryted = copIdEncryted.replace("=", "co");
			model.addAttribute("copIdEncryted", copIdEncryted);
			
			//Menu Atras
			String menuAdmin = rutamenu+"admin";
			model.addAttribute("rutamenu", menuAdmin);
			
			model.addAttribute("activarComunicado","active");
			
			return "administrador/documentacion";
		}
		
		
		//Formulario para modificar el estado
		@RequestMapping("/modComunicados")
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
			
			/////Capturamos el codigo del comunicados y lo desencrytamos
			String idComunicadoString = req.getParameter("comunic");
			MD5DatosGet decrypted = new MD5DatosGet();
			idComunicadoString = idComunicadoString.replace("co", "");
		    String idComunicadoDecrypted = decrypted.decrypted(idComunicadoString);
		    int idComunicados = Integer.parseInt(idComunicadoDecrypted);
		    
		    Comunicados comunicadosForm = new Comunicados();
		    comunicadosForm = userService.getComunicadosByIdForm(idComunicados);
		   		    
		    model.addAttribute("comunicadosForm", comunicadosForm);		
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
			String menuAdmin = rutamenu+"consultacomunicados";
			model.addAttribute("rutamenu", menuAdmin);
			
			//Ruta Formulario
			model.addAttribute("rutaFormulario", "actualizarEstadoComunicado");
			
			return "administrador/uploadComunicados";
		}
		
	    //Actualizar estado comunicado
		@PostMapping("/actualizarEstadoComunicado")
		public String actualizarEstadoComunicado(@Valid @ModelAttribute("comunicadosForm")Comunicados comunicados,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, 
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
				model.addAttribute("manualConvivenciaForm", comunicados);
				model.addAttribute("errorcampos","active");
			}else {
				try {
					//Asignamos el ID del usuario que esta modificar en el log								
					comunicados.setComuLog(String.valueOf(usuId));

					Comunicados guardarComunicados = new Comunicados();
					guardarComunicados.setComuId(comunicados.getComuId());
					guardarComunicados.setCopNit(comunicados.getCopNit());
					guardarComunicados.setComuNombre(comunicados.getComuNombre());
					guardarComunicados.setComuDescripcion(comunicados.getComuEstado());
					guardarComunicados.setComuFecha(comunicados.getComuFecha());
					guardarComunicados.setComuEstado(comunicados.getComuEstado());
					guardarComunicados.setComuLog(comunicados.getComuLog());					
					userService.createComunicados(guardarComunicados);
									
					model.addAttribute("manualConvivenciaForm", comunicados);
					model.addAttribute("bien","active");
					model.addAttribute("activarmodalactualizar", "A");
					
				} catch (Exception e) {
					model.addAttribute("error","active");
					model.addAttribute("formErrorMessage",e.getMessage());
					model.addAttribute("manualConvivenciaForm", comunicados);
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
			model.addAttribute("rutaFormulario", "actualizarEstadoComunicado");
			//Inactivamos los campos
			model.addAttribute("inactivarcampos","true");
			
			//Menu atras
			String menuAdmin = rutamenu+"consultacomunicados";
			model.addAttribute("rutamenu", menuAdmin);
					
			return "administrador/uploadComunicados";
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
import co.com.sisapco.entity.Actas;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.Comunicados;
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.EnvioEmail;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class ComunicadosController {
	
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
	
    @Autowired
    private EnvioEmail envioEmail;
	
	@RequestMapping("/uploadComunicados")
	public String uploadComunicados(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		 //Fecha Actual del sistema, para asignarsela al campo de Fecha de Creación
	    String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	    Comunicados comunicadosform = new Comunicados();
		comunicadosform.setComuFecha(timeStamp);
		model.addAttribute("fechaDeCargaPrecargada", timeStamp);
		
		model.addAttribute("comunicadosForm",comunicadosform );
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
		model.addAttribute("rutaFormulario", "crearcomunicado");
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/uploadComunicados";
	}
	
	   //Crear Comunicados
		@PostMapping("/crearcomunicado")
		public String crearComunicado(@Valid @ModelAttribute("comunicadosForm")Comunicados comunicados,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
				@RequestParam("comuArchivos") MultipartFile[] filesComunicados) throws Exception {
			
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
				model.addAttribute("comunicadosForm", comunicados);
				model.addAttribute("errorcampos","active");
			}else {
				try {
					
					comunicados.setComuLog(String.valueOf(usuId));
					
					//Consultamos el ID de Google para guardar el contrato
					AlmacenamientoGoogle almacenamientoGoogleContrato = userService.getAlmacenamientoGoogleByIdForm(copNit, "comunicados");
					String codigoGoogleContrato = almacenamientoGoogleContrato.getAlmaIdcarpeta();
					
					//Instanciar la clase de google para guardar la imagen
					CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				    String codigoDescarga = "";
				    String codigoVista = "";
					
					//Guardar Imagenes Antes
					for (int i = 0; i < filesComunicados.length; i++) {
					  
						  MultipartFile file = filesComunicados[i];
						  String name = filesComunicados[i].getOriginalFilename();					  
						  String formato = filesComunicados[i].getContentType();					 
						  byte[] bytes = file.getBytes();

						  
						    if(!file.isEmpty()) {						         
							    //Llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
						        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleContrato, formato, name, bytes);						    
							    codigoDescarga = googleFile.getWebContentLink();
							    codigoVista = googleFile.getWebViewLink();
							    
							    Comunicados guardarComunicados = new Comunicados();							    
							    guardarComunicados.setCopNit(copNit);
							    guardarComunicados.setComuNombre(comunicados.getComuNombre());
							    guardarComunicados.setComuFecha(comunicados.getComuFecha());
							    guardarComunicados.setComuEstado(comunicados.getComuEstado());
							    guardarComunicados.setComuDescripcion(comunicados.getComuDescripcion());
							    guardarComunicados.setComuArchivo(codigoDescarga);
							    guardarComunicados.setComuLog(comunicados.getComuLog());
							    guardarComunicados.setComuVisualizacion(codigoVista);
							    							   
							    userService.createComunicados(guardarComunicados);
						    }			   
					  }
					
					//Madamos el email
					String contenidoEmail=comunicados.getComuDescripcion()+"\\n Para visualizar el comunicado de click en el siguiente enlace: "+codigoVista;
					try {
					     envioEmail.send("sisapcoweb@gmail.com", "sisapcoweb@gmail.com", comunicados.getComuNombre(), contenidoEmail);
					}
					catch (Exception e) {
						model.addAttribute("errorEmail","active");
						model.addAttribute("errorEmailMensaje",e.getMessage()+" - "+e.getCause());
					}
					
					model.addAttribute("comunicadosForm", comunicados);
					model.addAttribute("bien","active");
					model.addAttribute("activarmodalactualizar", "A");
					
				} catch (Exception e) {
					model.addAttribute("error","active");
					model.addAttribute("formErrorMessage",e.getMessage());
					model.addAttribute("comunicadosForm", comunicados);
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
			String menuAdmin = rutamenu+"consultacomunicados";
			model.addAttribute("rutamenu", menuAdmin);
			
			return "administrador/uploadComunicados";
		}
		
		//Consulta Comunicados
		@RequestMapping("/consultacomunicados")
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
			
			model.addAttribute("comunicadoslist", userService.getComunicadosByNit(copNit));
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
			
	        ///////////Ciframos el id del comunicado
	        Iterable<Comunicados> comunicados = userService.getComunicadosByNit(copNit);
	        	      
		    String comunicadosIdEncryted ="";
		    int comuId=0;		
		    for (Comunicados x: comunicados) {
		    	comuId = x.getComuId();
				String comunicadosIdEcr = String.valueOf(comuId);
				comunicadosIdEncryted = encrypted.encrypted(comunicadosIdEcr);
				comunicadosIdEncryted = comunicadosIdEncryted.replace("=", "co");   
				x.setComuLog(comunicadosIdEncryted);
		    }
			
			//Instanciamos la clase para cifrar el codigo
			String copIdEcr = String.valueOf(copId);
		    String copIdEncryted ="";
			copIdEncryted = encrypted.encrypted(copIdEcr);
			copIdEncryted = copIdEncryted.replace("=", "co");
			model.addAttribute("copIdEncryted", copIdEncryted);
			
			//Menu Atras
			String menuAdmin = rutamenu+"admin";
			model.addAttribute("rutamenu", menuAdmin);
			
			model.addAttribute("activarComunicado","active");
			
			return "administrador/documentacion";
		}
		
		
		//Formulario para modificar el estado
		@RequestMapping("/modComunicados")
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
			
			/////Capturamos el codigo del comunicados y lo desencrytamos
			String idComunicadoString = req.getParameter("comunic");
			MD5DatosGet decrypted = new MD5DatosGet();
			idComunicadoString = idComunicadoString.replace("co", "");
		    String idComunicadoDecrypted = decrypted.decrypted(idComunicadoString);
		    int idComunicados = Integer.parseInt(idComunicadoDecrypted);
		    
		    Comunicados comunicadosForm = new Comunicados();
		    comunicadosForm = userService.getComunicadosByIdForm(idComunicados);
		   		    
		    model.addAttribute("comunicadosForm", comunicadosForm);		
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
			String menuAdmin = rutamenu+"consultacomunicados";
			model.addAttribute("rutamenu", menuAdmin);
			
			//Ruta Formulario
			model.addAttribute("rutaFormulario", "actualizarEstadoComunicado");
			
			return "administrador/uploadComunicados";
		}
		
	    //Actualizar estado comunicado
		@PostMapping("/actualizarEstadoComunicado")
		public String actualizarEstadoComunicado(@Valid @ModelAttribute("comunicadosForm")Comunicados comunicados,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, 
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
				model.addAttribute("manualConvivenciaForm", comunicados);
				model.addAttribute("errorcampos","active");
			}else {
				try {
					//Asignamos el ID del usuario que esta modificar en el log								
					comunicados.setComuLog(String.valueOf(usuId));

					Comunicados guardarComunicados = new Comunicados();
					guardarComunicados.setComuId(comunicados.getComuId());
					guardarComunicados.setCopNit(comunicados.getCopNit());
					guardarComunicados.setComuNombre(comunicados.getComuNombre());
					guardarComunicados.setComuDescripcion(comunicados.getComuEstado());
					guardarComunicados.setComuFecha(comunicados.getComuFecha());
					guardarComunicados.setComuEstado(comunicados.getComuEstado());
					guardarComunicados.setComuLog(comunicados.getComuLog());					
					userService.createComunicados(guardarComunicados);
									
					model.addAttribute("manualConvivenciaForm", comunicados);
					model.addAttribute("bien","active");
					model.addAttribute("activarmodalactualizar", "A");
					
				} catch (Exception e) {
					model.addAttribute("error","active");
					model.addAttribute("formErrorMessage",e.getMessage());
					model.addAttribute("manualConvivenciaForm", comunicados);
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
			model.addAttribute("rutaFormulario", "actualizarEstadoComunicado");
			//Inactivamos los campos
			model.addAttribute("inactivarcampos","true");
			
			//Menu atras
			String menuAdmin = rutamenu+"consultacomunicados";
			model.addAttribute("rutamenu", menuAdmin);
					
			return "administrador/uploadComunicados";
		}
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
