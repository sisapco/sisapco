package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.util.Value;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;

@Controller
public class SancionesMultaController {
	
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
    
	@RequestMapping("/sanciones")
	public String sanciones(Authentication authenticationnn,ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
 
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

		 //Fecha Actual del sistema
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        model.addAttribute("mulFecha", timeStamp);
        
		return "administrador/sanciones_multas";
	}
}
