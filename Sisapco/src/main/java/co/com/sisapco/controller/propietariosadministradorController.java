<<<<<<< HEAD
package co.com.sisapco.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.PropietariosAdministrador;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class propietariosadministradorController {
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

	@RequestMapping("/propietariosadministrador")
	public String propietariosadministrador(Authentication authenticationnn, ModelMap model, HttpServletRequest req,
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

		model.addAttribute("propietariosadministradorForm", new PropietariosAdministrador());
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

		return "administrador/propietariosadministrador";
	}
=======
package co.com.sisapco.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.PropietariosAdministrador;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class propietariosadministradorController {
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

	@RequestMapping("/propietariosadministrador")
	public String propietariosadministrador(Authentication authenticationnn, ModelMap model, HttpServletRequest req,
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

		model.addAttribute("propietariosadministradorForm", new PropietariosAdministrador());
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

		return "administrador/propietariosadministrador";
	}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
}