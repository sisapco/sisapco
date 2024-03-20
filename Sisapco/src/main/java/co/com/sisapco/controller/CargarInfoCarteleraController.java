package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
//import co.com.sisapco.entity.Contrato;

import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.entity.Cartelera;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

import org.springframework.security.core.Authentication;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;




@Controller
public class CargarInfoCarteleraController {
	
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
	
	
	@RequestMapping("/cartelera")
	public String cartelera(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		
		model.addAttribute("carteleraForm", new Cartelera());
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
		
		return "administrador/cargarinfocartelera";
	}
	
	//Crear cartelera
	@PostMapping("/crearcartelera")
	public String crearCartelera(@Valid @ModelAttribute("carteleraForm")Cartelera cartelera,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("carteleraDocumentoAdjuntos") MultipartFile[] filesCartelera) throws Exception {
		
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
			model.addAttribute("carteleraForm", cartelera);
			model.addAttribute("errorcampos","active");
		}else {
			try {
				cartelera.setCarteleraLog(String.valueOf(usuId));				
				//cartelera = userService.createActividad(cartelera);
				int carteleraId = cartelera.getCarteleraId();

				//Consultamos el ID de Google para guardar el cartelera
				AlmacenamientoGoogle almacenamientoGoogleCartelera = userService.getAlmacenamientoGoogleByIdForm(copNit, "carteleraPropietarios");
				String codigoGoogleCartelera = almacenamientoGoogleCartelera.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				String codigoDescarga="";
				String codigoVista ="";
				//Guardar Imagenes Antes
				for (int i = 0; i < filesCartelera.length; i++) {
				  
					  MultipartFile file = filesCartelera[i];
					  String name = filesCartelera[i].getOriginalFilename();					  
					  String formato = filesCartelera[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					  
					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleCartelera, formato, name, bytes);						    
						    codigoDescarga = googleFile.getWebContentLink();
						    codigoVista = googleFile.getWebViewLink();						    
						   
					    }			   
				  }
				
				Cartelera guardarCartelera = new Cartelera();
			    guardarCartelera.setCopNit(copNit);
			    guardarCartelera.setCarteleraDescripcion(cartelera.getCarteleraDescripcion());
			    guardarCartelera.setCarteleraDocumentoAdjunto(codigoVista);
			    guardarCartelera.setCarteleraEstado(cartelera.getCarteleraEstado());
			    guardarCartelera.setCarteleraFechaFin(cartelera.getCarteleraFechaFin());
			    guardarCartelera.setCarteleraFechaInicio(cartelera.getCarteleraFechaInicio());
			    guardarCartelera.setCarteleraNombrePublicacion(cartelera.getCarteleraNombrePublicacion());
			    guardarCartelera.setProNumeroResidencia(cartelera.getProNumeroResidencia());
			    guardarCartelera.setCarteleraLog("");
			    
			    userService.createCartelera(guardarCartelera);
				
				
				model.addAttribute("carteleraForm", cartelera);
				model.addAttribute("bien","active");
				model.addAttribute("activarmodalactualizar", "A");
				
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("carteleraForm", cartelera);
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
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/cargarinfocartelera";
	}
	
	
    //Consultar Cartelera
	@RequestMapping("/consultarcartelera")
	public String consultarCartelera(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//Instanciamos la clase MD5DatosGet para cifrar
	    MD5DatosGet encrypted = new MD5DatosGet();
	    
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit =copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		int copId =  copropiedadDTO.getCopId();
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("cateleralist", userService.getCarteleraByNit(copNit));
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
		
        ///////////Ciframos el ID de la cartelera
        Iterable<Cartelera> carlera = userService.getCarteleraByNit(copNit);
      
	    String carteleraIdEncryted ="";
	    int carteleraId=0;		
	    for (Cartelera x: carlera) {
	    	carteleraId = x.getCarteleraId();
			String carteleraIdEcr = String.valueOf(carteleraId);
			carteleraIdEncryted = encrypted.encrypted(carteleraIdEcr);
			carteleraIdEncryted = carteleraIdEncryted.replace("=", "co");
			x.setCarteleraLog(carteleraIdEncryted);    
	    }

		String copIdEcr = String.valueOf(copId);
	    String copIdEncryted ="";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		//menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		return "administrador/cartelera";
	}
	
	
	
	/*
	@RequestMapping("/consultacartelera")
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
		
		model.addAttribute("carteleralist", userService.getContratoByNit(copNit));
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
		
		return "administrador/consultacartelera";
	}
*/
	

}
