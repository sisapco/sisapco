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
//import co.com.sisapco.entity.ControlPagos;
import co.com.sisapco.entity.Copropiedad;
import co.com.sisapco.entity.Pqrs;
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
	
	
	@RequestMapping("/actualizarCopropiedad")
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
		/*String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		
		// Copropiedad copropiedadform = new Copropiedad();
		//copropiedadform.setCopFechaCreacion(timeStamp);
	*/
		
		//model.addAttribute("copropiedadForm", new Copropiedad);		
		model.addAttribute("copropiedadForm", new Copropiedad());
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
			@PostMapping("/crearcopropiedad")
			public String crearCopropiedad(@Valid @ModelAttribute("copropiedadForm")Copropiedad copropiedad,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
					@RequestParam("copLogo") MultipartFile[] filesCopropiedad) throws Exception {
				
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
					model.addAttribute("copropiedadForm", copropiedad);
					model.addAttribute("errorcampos","active");
				}else {
					try {
						copropiedad.setCopLog(String.valueOf(usuId));				
						//copropiedad = userService.createActividad(copropiedad);
						int copropiedadId = copropiedad.getCopId();

						//Consultamos el ID de Google para guardar el copropiedad
						AlmacenamientoGoogle almacenamientoGoogleCopropiedad = userService.getAlmacenamientoGoogleByIdForm(copNit, "logo");
						String codigoGoogleCopropiedad = almacenamientoGoogleCopropiedad.getAlmaIdcarpeta();
						
						//Instanciar la clase de google para guardar la imagen
						CreateGoogleFile createGoogleFile = new CreateGoogleFile();
						String codigoDescarga="";
						String codigoVista ="";
						//Guardar Imagenes Antes
						for (int i = 0; i < filesCopropiedad.length; i++) {
						  
							  MultipartFile file = filesCopropiedad[i];
							  String name = filesCopropiedad[i].getOriginalFilename();					  
							  String formato = filesCopropiedad[i].getContentType();					 
							  byte[] bytes = file.getBytes();
							  
							    if(!file.isEmpty()) {						         
								    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
							        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleCopropiedad, formato, name, bytes);						    
								    codigoDescarga = googleFile.getWebContentLink();
								    codigoVista = googleFile.getWebViewLink();						    
								   																																		 
							    }			   
						  }
						
						Copropiedad guardarCopropiedad = new Copropiedad();
						 guardarCopropiedad.setCopNit(copNit);
						    guardarCopropiedad.setCopNombreCopropiedad(copropiedad.getCopNombreCopropiedad());
						    guardarCopropiedad.setCopBarrio(copropiedad.getCopBarrio());
						    guardarCopropiedad.setCopCarpeta(copropiedad.getCopCarpeta());
						    guardarCopropiedad.setCopDireccion(copropiedad.getCopDireccion());
						    guardarCopropiedad.setCopEmail(copropiedad.getCopEmail());
						    guardarCopropiedad.setCopEstado(copropiedad.getCopEstado());
						    guardarCopropiedad.setCopFechaCreacion(copropiedad.getCopFechaCreacion());
						    guardarCopropiedad.setCopFechaFin(copropiedad.getCopFechaFin());
						    guardarCopropiedad.setCopId(copropiedad.getCopId());
						    guardarCopropiedad.setCopTelefono(copropiedad.getCopTelefono());
						    guardarCopropiedad.setCopUbicacion(copropiedad.getCopUbicacion());
						    
					    
					    userService.createCopropiedad(guardarCopropiedad);
						
						
						model.addAttribute("copropiedadForm", copropiedad);
						model.addAttribute("bien","active");
						model.addAttribute("activarmodalactualizar", "A");
						
					} catch (Exception e) {
						model.addAttribute("error","active");
						model.addAttribute("formErrorMessage",e.getMessage());
						model.addAttribute("copropiedadForm", copropiedad);
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
				
				return "administrador/copropiedad";
			}
			
	

}
