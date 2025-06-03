package co.com.sisapco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.sisapco.entity.Dane;
import co.com.sisapco.entity.Propietarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;

@Controller
public class DaneController {
	
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
	
	@RequestMapping("/consultaDepartamentos")
	public @ResponseBody String consultaDepartamento(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
			
		Iterable<Dane> dane = userService.getDaneDepartamentos();
		
		List<Dane> users = new ArrayList<Dane>();
		//users.add((Dane) dane);
		ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(dane);
        
		
		return data;
	}
	
	@RequestMapping("/consultaMunicipios")
	public @ResponseBody String consultaMunicipios(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String idDepartamento = req.getParameter("iddepartamento");
		
		Iterable<Dane> dane = userService.getMunicipioCodigoDepartamento(idDepartamento);
	
		ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(dane);
        
		return data;
	}

}
