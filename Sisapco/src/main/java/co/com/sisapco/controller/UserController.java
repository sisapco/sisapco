package co.com.sisapco.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.sisapco.dto.ChangePasswordForm;
import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.Copropiedad;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Propietarios;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.MD5DatosGet;

import javax.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CopropiedadRepository copropiedadRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpServletRequest request;
	
	@Value("${rutamenu}")
	private String rutamenu;
	
	
	@GetMapping({"/","/index","/sisapco"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	@GetMapping("/ingresar")
	public String ingresar() {
		return "ingresar";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("param.error", false);
		return "login";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
	
	@GetMapping("/ingresarcuenta")
	public String ingresarcuenta() {
		return "ingresarcuenta";
	}
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		model.addAttribute("userForm", new Usuarios());

		model.addAttribute("copropiedades", copropiedadRepository.findAll());
		model.addAttribute("perfiles", perfilRepository.findAll());
		
		model.addAttribute("userList", userService.getAllUsers());
		
		model.addAttribute("listTab","active");
		
		return "user-form/user-view";
	}
	
	@RequestMapping("/admin")
	public String administrador(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		HttpSession session = request.getSession();
		
		//Capturamos el codigo de la propiedad y lo desencrytamos
		String copIdString = req.getParameter("copId");
		MD5DatosGet decrypted = new MD5DatosGet();
		copIdString = copIdString.replace("co", "");
	    String copIdDecrypted = decrypted.decrypted(copIdString);
	    
	    int copId=0;
	    if(copIdDecrypted.equals("")) {
			CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
			copId = copropiedadDTO.getCopId();
	    }
	    else {
	    	copId = Integer.parseInt(copIdDecrypted);
	    }
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
		int contadorcopro=0;
		int copIdControl = 0;
		
		
		if(copId>0) {
			CopropiedadDTO copropiedadDTO = new CopropiedadDTO();
			Copropiedad copropiedadD = userService.getCopropiedadById(copId);
			copropiedadDTO.setCopId(copropiedadD.getCopId());
			copropiedadDTO.setCopNit(copropiedadD.getCopNit());
			copropiedadDTO.setCopNombreCopropiedad(copropiedadD.getCopNombreCopropiedad());
			copropiedadDTO.setCopCarpeta(copropiedadD.getCopCarpeta());
			copropiedadDTO.setCodLogo(copropiedadD.getCopLogo());
			
			session.setAttribute("copropiedadDTO", copropiedadDTO);			
			model.addAttribute("copropiedadlist", userService.getCopropiedadById(copId));
			
		}else {
		}
	
		String retorno="";
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		if(copId>0) {
			retorno="administrador/admin";
		}
		else {
			Iterable<Copropiedad> copro= userService.getCopropiedadUsuario(usuId);
			for (Copropiedad x: copro) {
				copIdControl = x.getCopId();
				contadorcopro=contadorcopro+1;
			}
			
			if(contadorcopro>1) {
				retorno="administrador/propiedad";
				model.addAttribute("copropiedadlist", userService.getCopropiedadUsuario(usuId));
			}
			else if(contadorcopro==1) {
				retorno="administrador/admin";
				model.addAttribute("copropiedadlist", userService.getCopropiedadById(copIdControl));
			}else {
				retorno="administrador/propiedad";
				model.addAttribute("copropiedadlist", userService.getCopropiedadUsuario(usuId));
			}
			
		}
		
		//menu atras
		String menuAdmin = rutamenu+"propiedad";
		model.addAttribute("rutamenu", menuAdmin);
		
		return retorno;
	}
	
	
	@GetMapping("/propiedad")
	public String propiedad(Authentication authenticationnn,  ModelMap model) throws Exception {
		
		String ruta="";
		int contadorcopro=0;
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
		
		int copId = 0;
		
		Iterable<Copropiedad> copro= userService.getCopropiedadUsuario(usuId);
		
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
	
		//Instanciamos la clase para cifrar el codigo
		MD5DatosGet encrypted = new MD5DatosGet();
	    String copIdEncryted ="";
				
		for (Copropiedad x: copro) {
			copId = x.getCopId();
			contadorcopro=contadorcopro+1;
			
			String copIdEcr = String.valueOf(copId);
			//Ciframos el codigo de la propiedad
			copIdEncryted = encrypted.encrypted(copIdEcr);
			copIdEncryted = copIdEncryted.replace("=", "co");
            
		    x.setCopDireccion(copIdEncryted);
		}
		
		
		model.addAttribute("copropiedadDTO", copro);
		
		if(contadorcopro>1) {
			ruta="administrador/propiedad";
			model.addAttribute("copropiedadlist", userService.getCopropiedadUsuario(usuId));
		}
		else if(contadorcopro==1) {
			ruta="administrador/admin";
			model.addAttribute("copropiedadlist", userService.getCopropiedadById(copId));
		}else {
			ruta="administrador/propiedad";
			model.addAttribute("copropiedadlist", userService.getCopropiedadUsuario(usuId));
		}
		
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		return ruta;
	}
	

	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm")Usuarios user, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
		}else {
			try {
				
				userService.createUser(user);
				model.addAttribute("userForm", user);
				model.addAttribute("listTab","active");
				
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("copropiedades", copropiedadRepository.findAll());
				model.addAttribute("perfiles", perfilRepository.findAll());
			}
		}
		
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("copropiedades", copropiedadRepository.findAll());
		model.addAttribute("perfiles", perfilRepository.findAll());
		
		return "user-form/user-view";
	}
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name="id")Long id)throws Exception{
		Usuarios userToEdit = userService.geUsuariosById(id);
		
		model.addAttribute("userForm", userToEdit);
		model.addAttribute("copropiedades", copropiedadRepository.findAll());
		model.addAttribute("perfiles", perfilRepository.findAll());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
		return "user-form/user-view";
	}
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm")Usuarios user, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getUsuId()));
		}else {
			try {
				
				userService.updateUser(user);
				model.addAttribute("userForm", user);
				model.addAttribute("listTab","active");
				
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", userService.getAllUsers());
				model.addAttribute("copropiedades", copropiedadRepository.findAll());
				model.addAttribute("perfiles", perfilRepository.findAll());
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getUsuId()));
			}
		}
		
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("copropiedades", copropiedadRepository.findAll());
		model.addAttribute("perfiles", perfilRepository.findAll());
		
		return "user-form/user-view";
		
	}
	
	@GetMapping("/editUser/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Long id) {
		
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return userForm(model);
	}
	
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			//If error, just return a 400 bad request, along with the error message
	        if (errors.hasErrors()) {
	            String result = errors.getAllErrors()
	                        .stream().map(x -> x.getDefaultMessage())
	                        .collect(Collectors.joining(""));

	            throw new Exception(result);
	        }
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("success");
	}
	
	
	@GetMapping("/residentes")
	public String residentes() {

		return "administrador/residentes";
	}
	
	@GetMapping("/documentacion")
	public String documentacion(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {

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
		
		//model.addAttribute("manualConvivenciaForm", new ManualConvivencia());
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		model.addAttribute("copIdEncryted", copIdEncryted);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		//Menu atras
		String menuAdmin = rutamenu+"admin";
		model.addAttribute("rutamenu", menuAdmin);
		
		
		if(userPanel.getPerId() == 1 || userPanel.getPerId()==6 || userPanel.getPerId()==7) {
			model.addAttribute("mostrarcargadocuemtos","active");
		}else {
			model.addAttribute("mostrarcargadocuemtos","false");
		}
				
		return "administrador/documentacion";
	}
	
	@GetMapping("/copropiedad")
	public String copropiedad() {

		return "administrador/copropiedad";
	}
	
	@GetMapping("/prueba")
	public String prueba() {

		return "administrador/prueba";
	}
	
	@PostMapping("/propietarios")
	public String propietarios(Authentication authenticationnn,ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		
		long longusuariId=userPanel.getUsuId();
		int usuId = (int) longusuariId;
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		
		model.addAttribute("actaslist", userService.getActasByNit(copNit));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		
		model.addAttribute("admin","active");
		model.addAttribute("consejo","active");
		
		return "administrador/propietarios";
	}
	

	@GetMapping("/reservas")
	public String reservas() {

		return "administrador/reservas";
	}

	
	@RequestMapping("/consultaUsuarioDatosGenerales")
	public @ResponseBody String consultaUsuarioDatosGenerales(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//Capturamos el usuario que se ingreso
		String varprousser= req.getParameter("prousser");
		Usuarios usuarios = userService.validarUsuarioDatosGenerales(varprousser);
		
		List<Usuarios> users = new ArrayList<Usuarios>();
		users.add(usuarios);
		ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(users);
        		
		return data;
	}
	
	
}
