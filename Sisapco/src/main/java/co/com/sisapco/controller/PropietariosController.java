package co.com.sisapco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.Contrato;
import co.com.sisapco.entity.Propietarios;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.MD5DatosGet;

@Controller
public class PropietariosController {
	
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
	
	@RequestMapping("/consultaPropietario")
	public @ResponseBody String consultaPropietario(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		//Capturamos el número de cedula a consultar
		String varCedula = req.getParameter("cedula");
		int cedula=0;
		if(varCedula.equals("")) {
			cedula = 0;
		}else {
			cedula = Integer.parseInt(varCedula);
		}
		
		Propietarios propietarios = userService.getPropietariosByIdCedula(cedula);
		
		List<Propietarios> users = new ArrayList<Propietarios>();
		users.add(propietarios);
		ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(users);
        
		
		return data;
	}

}
