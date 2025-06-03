<<<<<<< HEAD
package co.com.sisapco.controller;

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
import co.com.sisapco.entity.AutorizacionIngreso;

import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class AutorizacionIngresoController {
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

	@RequestMapping("/autorizacionIngreso")
	public String autorizacionIngreso(Authentication authenticationnn, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);

		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");

		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();

		int copId = copropiedadDTO.getCopId();

		// Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
		String copIdEncryted = "";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");

		model.addAttribute("autorizacioningresoForm", new AutorizacionIngreso());
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));

		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);

		model.addAttribute("admin", "active");
		model.addAttribute("consejo", "active");

		// menu atras
		String menuAdmin = rutamenu + "admin";
		model.addAttribute("rutamenu", menuAdmin);

		return "administrador/autorizacionIngreso";
	}
	
	//Crear autorizacion ingreso
			@PostMapping("/crearautorizacion")
			public String crearAutorizacion(@Valid @ModelAttribute("autorizaForm")AutorizacionIngreso autoriza,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
					@RequestParam("contraDocumentoAdjuntos") MultipartFile[] filesAutorizacion) throws Exception {
				
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
					model.addAttribute("autorizaForm", autoriza);
					model.addAttribute("errorcampos","active");
				}else {
					try {
					
								    
						AutorizacionIngreso guardarAutorizacion = new AutorizacionIngreso();
						
					    guardarAutorizacion.setAutoriApellidos(autoriza.getAutoriApellidos());  
					    guardarAutorizacion.setCopNit(copNit); 
					    //guardarAutorizacion.setAutoriCantidadPersonas(autoriza.getAutoriCantidadPersonas());
					    //guardarAutorizacion.setAutoriCantidadVehiculos(autoriza.getAutoriCantidadVehiculos());
					    //guardarAutorizacion.setAutoriCcVisitante(autoriza.getAutoriCcVisitante());
					    guardarAutorizacion.setAutoriEstado(autoriza.getAutoriEstado());
					    guardarAutorizacion.setAutoriFechaIngreso(autoriza.getAutoriFechaIngreso());
					    guardarAutorizacion.setAutoriFechaSalida(autoriza.getAutoriFechaSalida());
					    guardarAutorizacion.setAutoriNombres(autoriza.getAutoriNombres());
					    //guardarAutorizacion.setAutoriObservaciones(autoriza.getAutoriObservaciones());
					    guardarAutorizacion.setAutoriPlacaVehiculo(autoriza.getAutoriPlacaVehiculo());
					    guardarAutorizacion.setProCc(autoriza.getProCc());
					    guardarAutorizacion.setProNumeroResidencia(autoriza.getProNumeroResidencia());
				
					    userService.createAutorizacion(guardarAutorizacion);
					//   userService.createAutorizacion(guardarAutorizacion);
							   			   
				 
						
						model.addAttribute("autorizaForm", autoriza);
						model.addAttribute("bien","active");
						model.addAttribute("activarmodalactualizar", "A");
						
					} catch (Exception e) {
						model.addAttribute("error","active");
						model.addAttribute("formErrorMessage",e.getMessage());
						model.addAttribute("autorizaForm", autoriza);
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
				
				return "administrador/autorizacionIngreso";
			}
				
	
=======
package co.com.sisapco.controller;

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
import co.com.sisapco.entity.AutorizacionIngreso;

import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class AutorizacionIngresoController {
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

	@RequestMapping("/autorizacionIngreso")
	public String autorizacionIngreso(Authentication authenticationnn, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);

		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");

		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();

		int copId = copropiedadDTO.getCopId();

		// Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
		String copIdEcr = String.valueOf(copId);
		String copIdEncryted = "";
		copIdEncryted = encrypted.encrypted(copIdEcr);
		copIdEncryted = copIdEncryted.replace("=", "co");

		model.addAttribute("autorizacioningresoForm", new AutorizacionIngreso());
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));

		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);

		model.addAttribute("admin", "active");
		model.addAttribute("consejo", "active");

		// menu atras
		String menuAdmin = rutamenu + "admin";
		model.addAttribute("rutamenu", menuAdmin);

		return "administrador/autorizacionIngreso";
	}
	
	//Crear autorizacion ingreso
			@PostMapping("/crearautorizacion")
			public String crearAutorizacion(@Valid @ModelAttribute("autorizaForm")AutorizacionIngreso autoriza,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
					@RequestParam("contraDocumentoAdjuntos") MultipartFile[] filesAutorizacion) throws Exception {
				
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
					model.addAttribute("autorizaForm", autoriza);
					model.addAttribute("errorcampos","active");
				}else {
					try {
					
								    
						AutorizacionIngreso guardarAutorizacion = new AutorizacionIngreso();
						
					    guardarAutorizacion.setAutoriApellidos(autoriza.getAutoriApellidos());  
					    guardarAutorizacion.setCopNit(copNit); 
					    //guardarAutorizacion.setAutoriCantidadPersonas(autoriza.getAutoriCantidadPersonas());
					    //guardarAutorizacion.setAutoriCantidadVehiculos(autoriza.getAutoriCantidadVehiculos());
					    //guardarAutorizacion.setAutoriCcVisitante(autoriza.getAutoriCcVisitante());
					    guardarAutorizacion.setAutoriEstado(autoriza.getAutoriEstado());
					    guardarAutorizacion.setAutoriFechaIngreso(autoriza.getAutoriFechaIngreso());
					    guardarAutorizacion.setAutoriFechaSalida(autoriza.getAutoriFechaSalida());
					    guardarAutorizacion.setAutoriNombres(autoriza.getAutoriNombres());
					    //guardarAutorizacion.setAutoriObservaciones(autoriza.getAutoriObservaciones());
					    guardarAutorizacion.setAutoriPlacaVehiculo(autoriza.getAutoriPlacaVehiculo());
					    guardarAutorizacion.setProCc(autoriza.getProCc());
					    guardarAutorizacion.setProNumeroResidencia(autoriza.getProNumeroResidencia());
				
					    userService.createAutorizacion(guardarAutorizacion);
					//   userService.createAutorizacion(guardarAutorizacion);
							   			   
				 
						
						model.addAttribute("autorizaForm", autoriza);
						model.addAttribute("bien","active");
						model.addAttribute("activarmodalactualizar", "A");
						
					} catch (Exception e) {
						model.addAttribute("error","active");
						model.addAttribute("formErrorMessage",e.getMessage());
						model.addAttribute("autorizaForm", autoriza);
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
				
				return "administrador/autorizacionIngreso";
			}
				
	
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
}