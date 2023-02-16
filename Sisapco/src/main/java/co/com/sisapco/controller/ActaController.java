package co.com.sisapco.controller;



import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.entity.Actas;
import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.EvidenciaActividades;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;

import java.io.FileOutputStream; 
import java.io.StringReader; 
import com.lowagie.text.Document; 
import com.lowagie.text.PageSize; 
import com.lowagie.text.html.simpleparser.HTMLWorker; 
import com.lowagie.text.pdf.PdfWriter;

@Controller
public class ActaController {
	
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
	
	@RequestMapping("/formcrearacta")
	public String formCrearActaAdmin(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		int copId = copropiedadDTO.getCopId();
		
		//consultamos el ultimo consecutivo del acta
		Actas actaconsecutivo = userService.getActasByIdConsecutivoForm(copNit);
		int consecutivo = actaconsecutivo.getActId();
		consecutivo = consecutivo+1;
		model.addAttribute("consecutivoactas", consecutivo);
		
		model.addAttribute("actasForm", new Actas());
        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
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

		return "administrador/formcrearacta";
	}
	
	@PostMapping("/crearacta")
	public String crearActasAdmin(@Valid @ModelAttribute("actasForm")Actas actas,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp,
			@RequestParam("actFirmasAdjunto") MultipartFile[] filesPresidente, @RequestParam("actFirmasSecretarioAdjunto") MultipartFile[] filesSecretario) throws Exception {
					
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		String actNumero = req.getParameter("actNumeroConsecutivo");
		int actNumeroCon = Integer.parseInt(actNumero);		
		actas.setActNumero(actNumeroCon);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		int copId = copropiedadDTO.getCopId();
		
		String seguimiento="";
		
		if(result.hasErrors()) {
			model.addAttribute("actasForm", actas);
			model.addAttribute("errorcampos","active");
			seguimiento+="1.hasErrors";
		}else {
			try {
				
				//Consultamos el ID de Google para guardar las imagenenes de Evidencia Antes y despues
				AlmacenamientoGoogle almacenamientoGooglePresidente = userService.getAlmacenamientoGoogleByIdForm(copNit, "firma_presidente");
				AlmacenamientoGoogle almacenamientoGoogleSecretario = userService.getAlmacenamientoGoogleByIdForm(copNit, "firma_secretario");
				String codigoGooglePresidente = almacenamientoGooglePresidente.getAlmaIdcarpeta();
				String codigoGoogleSecretario = almacenamientoGoogleSecretario.getAlmaIdcarpeta();
				
				//Instanciar la clase de google para guardar la imagen
				CreateGoogleFile createGoogleFile = new CreateGoogleFile();
				
				seguimiento+="2.AlmacenamientoGoogle";
				
				//Guardar Firma presidente
				for (int i = 0; i < filesPresidente.length; i++) {
				  
					  MultipartFile file = filesPresidente[i];
					  String name = filesPresidente[i].getOriginalFilename();					  
					  String formato = filesPresidente[i].getContentType();					 
					  byte[] bytes = file.getBytes();

					    if(!file.isEmpty()) {						         
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGooglePresidente, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    actas.setActFirmas(codigoDescarga);						   						
					    }			   
				 }
				
				//Guardar Firma Secretario
				for (int i = 0; i < filesSecretario.length; i++) {
				  
					  MultipartFile file = filesSecretario[i];
					  String name = filesSecretario[i].getOriginalFilename();
					  String formato = filesSecretario[i].getContentType();					  
					  byte[] bytes = file.getBytes();
					  
					    if(!file.isEmpty()) {					    	 						    
						    //llamamos la funcion cargarArchivoGoogle para guardar el archivo en google drive 
					        com.google.api.services.drive.model.File googleFile = createGoogleFile.cargarArchivoGoogle(codigoGoogleSecretario, formato, name, bytes);						    
						    String codigoDescarga = googleFile.getWebContentLink();
						    String codigoVista = googleFile.getWebViewLink();
						    actas.setActFirmaSecretario(codigoDescarga);
						    
					    }			   
				  }
				
				  actas = userService.createActa(actas);
				  model.addAttribute("actasForm", actas);
				  model.addAttribute("bien","active");
				
				  seguimiento+="3.createActa";
				  
			} catch (Exception e) {
				model.addAttribute("error","active");
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("actasForm", actas);
		        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
				model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
				model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
				model.addAttribute("copNombre", copNombre);
				model.addAttribute("copNit", copNit);
				
				 seguimiento+="3.catch="+e.getMessage();
			}
		}
		
        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("copId", copId);
		
		//Consultamos el ultimo consecutivo del acta
		Actas actaconsecutivo = userService.getActasByIdConsecutivoForm(copNit);
		int consecutivo = actaconsecutivo.getActId();
		consecutivo = consecutivo+1;
		model.addAttribute("consecutivoactas", consecutivo);
		
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
		model.addAttribute("seguimientoerror", seguimiento);

		return "administrador/formcrearacta";
	}
	
	@RequestMapping("/seguimientoactas")
	public String seguimientoTareasAdmin(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		model.addAttribute("actaslist", userService.getActasByNit(copNit));
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
		
		return "administrador/seguimientoactas";
	}
	
	
	@RequestMapping("/visualizaracta")
	public String visualizaracta(@Valid @ModelAttribute("actaForm")Actas actas,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String actIdString = req.getParameter("actId");
		int actId = Integer.parseInt(actIdString);
		String directoryName = System.getProperty("user.home");
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit =copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		String logoCopropiedad = copropiedadDTO.getCodLogo();
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("actaForm", userService.getActaByIdForm(actId));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("rutaroot", directoryName);
		model.addAttribute("logoCopropiedad", logoCopropiedad);
	
		return "administrador/visualizaracta";
	}
	
	
	@WebServlet("/files/*")
	public class FileServlet extends HttpServlet {

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException
	    {
	        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
	        File file = new File("/images", filename);
	        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
	        response.setHeader("Content-Length", String.valueOf(file.length()));
	        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
	        Files.copy(file.toPath(), response.getOutputStream());
	    }

	}
	
	@PostMapping("/descargarPDF")
	public void descargarPDF(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp, String inputHtmlPath, String outputPdfPath) throws Exception {
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit = copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		
		model.addAttribute("actasForm", new Actas());
        model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		
		//..............
		
		 try { 
		      /*Document document = new Document(PageSize.A4); 
		      PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("plantilla.pdf")); 
		      document.open(); 
		      document.addAuthor("Persona creadora"); 
		      document.addCreator("Software generador"); 
		      document.addCreationDate(); 
		      document.addTitle("Titulo del documento"); 
		      HTMLWorker htmlWorker = new HTMLWorker(document); 
		      String str = "Este es el contenido HTML, bien en String o reemplazalo por el contenido del fichero del ejemplo anterior"; 
		      htmlWorker.parse(new StringReader(str)); 
		      document.close(); 
		      */
			 

		      
		      
		    } catch (Exception e) { 
		      e.printStackTrace(); 
		    } 
		
		//..............
		

		//-return "administrador/formcrearacta";
	}
	

	//impresion Acta
	@RequestMapping("/impresionactas")
	public String impresionActas(@Valid @ModelAttribute("actaForm")Actas actas,BindingResult result, Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String actIdString = req.getParameter("actId");
		int actId = Integer.parseInt(actIdString);
		String directoryName = System.getProperty("user.home");
		
		String usuariologin = authenticationnn.getName();
		Usuarios userPanel = userService.geUsuariosByUsername(usuariologin);
		
		HttpSession session = request.getSession();
		CopropiedadDTO copropiedadDTO = (CopropiedadDTO) session.getAttribute("copropiedadDTO");
		
		int copNit =copropiedadDTO.getCopNit();
		String copNombre = copropiedadDTO.getCopNombreCopropiedad();
		String logoCopropiedad = copropiedadDTO.getCodLogo();
		
		model.addAttribute("userList", userService.geUsuariosByUsername(usuariologin));
		model.addAttribute("moduloslist", userService.getModulosById(userPanel.getPerId()));
		model.addAttribute("perfillist", userService.getPefilById(userPanel.getPerId()));
		model.addAttribute("actaForm", userService.getActaByIdForm(actId));
		
		model.addAttribute("copNombre", copNombre);
		model.addAttribute("copNit", copNit);
		model.addAttribute("rutaroot", directoryName);
		model.addAttribute("logoCopropiedad", logoCopropiedad);
	
		return "administrador/impresionActas";
	}
	
}
