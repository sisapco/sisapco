package co.com.sisapco.controller;

import java.text.SimpleDateFormat;
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
import co.com.sisapco.dto.DatosGeneralesDTO;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.AutorizacionIngreso;
import co.com.sisapco.entity.ContactoEmergencia;
import co.com.sisapco.entity.Contrato;
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.DatosGenerales;
import co.com.sisapco.entity.Inquilino;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Mascota;
import co.com.sisapco.entity.Propiedad;
import co.com.sisapco.entity.Propietarios;
import co.com.sisapco.entity.Residentes;
import co.com.sisapco.entity.Terceros;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.entity.Vehiculo;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.service.UserService;
import co.com.sisapco.util.CreateGoogleFile;
import co.com.sisapco.util.MD5DatosGet;
import co.com.sisapco.util.PassCryptFormulario;

@Controller
public class DatosGeneralesController {
	
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
	
	@RequestMapping("/datosgenerales")
	public String datosGenerales(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
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
		
		//model.addAttribute("datosgeneralesForm", new DatosGenerales());
		model.addAttribute("datosgeneralesForm", new DatosGeneralesDTO());
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
		
		return "administrador/datosgenerales";
	}
	
	
	//Crear datos generales
		@PostMapping("/creardatosgenerales")
		public String crearDatosGenerales(@Valid @ModelAttribute("datosgeneralesForm")DatosGeneralesDTO datosGenerales,BindingResult result, Authentication authenticationnn, 
				ModelMap model, HttpServletRequest req, HttpServletResponse resp, 
				@RequestParam("proClaseVehciulo") MultipartFile[] proClaseVehciulo,
				@RequestParam("proPlaca") MultipartFile[] proPlaca,
				@RequestParam("proMarcaVehiculo") MultipartFile[] proMarcaVehiculo) throws Exception {
			
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
				model.addAttribute("datosgeneralesForm", datosGenerales);
				model.addAttribute("errorcampos","active");
			}else {
				try {
					 
						    //Validamos el perfil del usuario
						    Usuarios guardarUsuario = new Usuarios();
				            PassCryptFormulario passCryptFormulario = new PassCryptFormulario();
				            int tipoPerfil=0;
				            
				            if(datosGenerales.getDatosperTipoResidente().equals("15")) {tipoPerfil=3;}
				            if(datosGenerales.getDatosperTipoResidente().equals("12")) {tipoPerfil=4;}
				            if(datosGenerales.getDatosperTipoResidente().equals("16")) {tipoPerfil=1;}
				            //Falta el guarda de seguridad
				            if(datosGenerales.getDatosperTipoResidente().equals("17")) {tipoPerfil=4;}
				            if(datosGenerales.getDatosperTipoResidente().equals("18")) {tipoPerfil=6;}
				            if(datosGenerales.getDatosperTipoResidente().equals("19")) {tipoPerfil=7;}
				            
						    /////Validamos si es un propietario y registramos todos sus datos
				            if(datosGenerales.getDatosperTipoResidente().equals("15")) {
				        	   
				        	    //GUARDAMOS LA PROPIEDAD
					            Propiedad guardarPropiedad = new Propiedad();
					            guardarPropiedad.setCopNit(copNit);
					            guardarPropiedad.setProMatricula(datosGenerales.getProNumeroMatricula());
					            guardarPropiedad.setProArea("");
					            guardarPropiedad.setProNumeroResidencia(datosGenerales.getProNumeroResidencia());
					            guardarPropiedad.setProEstado(datosGenerales.getDatosperEstado());
					            guardarPropiedad.setProCoeficiente("");
					            userService.createPropiedad(guardarPropiedad);
					            
					            //Guardamos la informacion del propietario
					            Propietarios guardarPropietarios = new Propietarios();
					            guardarPropietarios.setCopNit(copNit);
					            guardarPropietarios.setProNumeroResidencia(datosGenerales.getProNumeroResidencia());
					            guardarPropietarios.setProCc(datosGenerales.getDatosperNumeroDocumento());
					            guardarPropietarios.setProNombres(datosGenerales.getDatosperNombres());
					            guardarPropietarios.setProApellidos(datosGenerales.getDatosperApellidos());
					            guardarPropietarios.setProCelular(datosGenerales.getDatosperCelular());
					            guardarPropietarios.setProTelefono(datosGenerales.getDatosperTelefono());
					            guardarPropietarios.setProEmail(datosGenerales.getDatosperEmail());
					            guardarPropietarios.setProDireccionCorrespondencia(datosGenerales.getDatosperDireccionCorrespondencia());
					            guardarPropietarios.setProEstado(Integer.parseInt(datosGenerales.getDatosperEstado()));
					            userService.createPropietario(guardarPropietarios);
					                      
					            //Guardamos los datos del usuario					            
					            guardarUsuario.setPerId(tipoPerfil);
					            guardarUsuario.setProCc(datosGenerales.getDatosperNumeroDocumento());
					            guardarUsuario.setUsername(datosGenerales.getDatosperUser());					           
					            guardarUsuario.setUsuClave(passCryptFormulario.passwordEncoder(datosGenerales.getDatosperPassword()));
					            guardarUsuario.setUsuEstado(datosGenerales.getDatosperEstado());
					            userService.createUsuario(guardarUsuario);
					            					            					         					            
					            //GUARDAMOS LOS DATOS DEL RESIDENTE
					            String[] datosProResidenteNumeroDocumento = datosGenerales.getProResidenteNumeroDocumento().split(",");
					            String[] datosProResidenteNombres = datosGenerales.getProResidenteNombres().split(",");
					            String[] datosProResidenteApellidos = datosGenerales.getProResidenteApellidos().split(",");
					            String[] datosProResidenteNumeroTelefono = datosGenerales.getProResidenteNumeroTelefono().split(",");
					            String[] datosProResidenteParentesco = datosGenerales.getProResidenteParentesco().split(",");
					            
					            for (int i = 0; i < datosProResidenteNumeroDocumento.length; i++) {					          
					            	String getProResidenteNumeroDocumento = datosProResidenteNumeroDocumento[i];
					            	String getProResidenteNombres = datosProResidenteNombres[i];
					            	String getProResidenteApellidos = datosProResidenteApellidos[i];
					            	String getProResidenteNumeroTelefono = datosProResidenteNumeroTelefono[i];
					            	String getProResidenteParentesco = datosProResidenteParentesco[i];
					            	
					            	Residentes guardarResidentes = new Residentes();
					            	guardarResidentes.setCopNit(copNit);
					            	guardarResidentes.setProNumeroResidencia(datosGenerales.getProNumeroResidencia());
					            	guardarResidentes.setResidenteNumeroDocumento(Integer.parseInt(getProResidenteNumeroDocumento));
					            	guardarResidentes.setResidenteNombres(getProResidenteNombres);
					            	guardarResidentes.setResidenteApellidos(getProResidenteApellidos);
					            	guardarResidentes.setResidenteNumeroTelefonico(getProResidenteNumeroTelefono);
					            	guardarResidentes.setResidenteParentesco(getProResidenteParentesco);
					            	guardarResidentes.setResidenteEstado(datosGenerales.getDatosperEstado());
					            	guardarResidentes.setResidentePerfil(tipoPerfil);
					            	
					            	userService.createResidentes(guardarResidentes);
					            }
					            
					            
					            //PERSONAS AUTORIZADAS PARA INGRESAR SIN PREVIO AVISO :
					            String[] datosProAutorizaNumeroDocumento = datosGenerales.getProAutorizaNumeroDocumento().split(",");
					            String[] datosProAutorizaNombres = datosGenerales.getProAutorizaNombres().split(",");
					            String[] datosProAutorizaApellidos = datosGenerales.getProAutorizaApellidos().split(",");
					            String[] datosProAutorizaNumeroTelefono = datosGenerales.getProAutorizaNumeroTelefono().split(",");
					            String[] datosProAutorizaParentesco = datosGenerales.getProAutorizaParentesco().split(",");
					            String[] datosProAutoriFechaIngreso = datosGenerales.getProAutoriFechaIngreso().split(",");
					            String[] datosProAutoriFechaSalida = datosGenerales.getProAutoriFechaSalida().split(",");
					            String[] datosProAutoriPlacaVehiculo = datosGenerales.getProAutoriPlacaVehiculo().split(",");
					            String[] datosProAutorizaEstado = datosGenerales.getProAutorizaEstado().split(",");
					            
					            for (int i = 0; i < datosProAutorizaNumeroDocumento.length; i++) {
					            	
					            	String getProAutorizaNumeroDocumento = datosProAutorizaNumeroDocumento[i];
					            	String getProAutorizaNombres = datosProAutorizaNombres[i];
					            	String getProAutorizaApellidos = datosProAutorizaApellidos[i];
					            	String getProAutorizaNumeroTelefono = datosProAutorizaNumeroTelefono[i];
					            	String getProAutorizaParentesco = datosProAutorizaParentesco[i];
					            	String getProAutoriFechaIngreso = datosProAutoriFechaIngreso[i];
					            	String getProAutoriFechaSalida = datosProAutoriFechaSalida[i];
					            	String getProAutoriPlacaVehiculo = datosProAutoriPlacaVehiculo[i];
					            	String getProAutorizaEstado = datosProAutorizaEstado[i];
					            	
					            	AutorizacionIngreso guardarAutorizacionIngreso= new AutorizacionIngreso();				          	
					            	guardarAutorizacionIngreso.setCopNit(copNit);
					            	guardarAutorizacionIngreso.setAutoriNumeroDocumento(Integer.parseInt(getProAutorizaNumeroDocumento));
					           	    guardarAutorizacionIngreso.setProNumeroResidencia(Integer.parseInt(datosGenerales.getProNumeroResidencia()));
					           	    guardarAutorizacionIngreso.setProCc(datosGenerales.getDatosperNumeroDocumento());
					           	    guardarAutorizacionIngreso.setAutoriNombres(getProAutorizaNombres);
					           	    guardarAutorizacionIngreso.setAutoriApellidos(getProAutorizaApellidos);
					           	    guardarAutorizacionIngreso.setAutoriNumeroTelefonico(Integer.parseInt(getProAutorizaNumeroTelefono));
					           	    guardarAutorizacionIngreso.setAutoriParentesco(getProAutorizaParentesco);
					           	    guardarAutorizacionIngreso.setAutoriEstado(Integer.parseInt(getProAutorizaEstado));
					           	    guardarAutorizacionIngreso.setAutoriPerfil(tipoPerfil);
					           	    guardarAutorizacionIngreso.setAutoriFechaIngreso(getProAutoriFechaIngreso);
					            	guardarAutorizacionIngreso.setAutoriFechaSalida(getProAutoriFechaSalida);
					            	guardarAutorizacionIngreso.setAutoriPlacaVehiculo(getProAutoriPlacaVehiculo);
					            	
					            	userService.createAutorizacion(guardarAutorizacionIngreso);					          
					            }
					            					         		            					            
					            //Guardamos los datos del vehiculo
					            String[] datosProPlaca = datosGenerales.getProPlaca().split(",");
					            String[] datosProClaseVehciulo = datosGenerales.getProClaseVehciulo().split(",");
					            String[] datosProMarcaVehiculo = datosGenerales.getProMarcaVehiculo().split(",");
					            String[] datosProColorVehiculo = datosGenerales.getProColorVehiculo().split(",");
					            String[] datosProVehiculoObservacion = datosGenerales.getProVehiculoObservacion().split(",");
					            String[] datosProVehciuloEstado = datosGenerales.getProVehciuloEstado().split(",");
					            
					            for (int i = 0; i < datosProPlaca.length; i++) {					          
					            	String getProPlaca = datosProPlaca[i];
					            	String getProClaseVehciulo = datosProClaseVehciulo[i];
					            	String getProMarcaVehiculo = datosProMarcaVehiculo[i];
					            	String getProColorVehiculo = datosProColorVehiculo[i];
					            	String getProVehiculoObservacion = datosProVehiculoObservacion[i];
					            	String getProVehciuloEstado = datosProVehciuloEstado[i];
					            	
					            	Vehiculo guardarVehiculo= new Vehiculo();
						            guardarVehiculo.setCopNit(copNit);
						            guardarVehiculo.setProNumResidencia(datosGenerales.getProNumeroResidencia());
						            guardarVehiculo.setVehiculoPlaca(getProPlaca);
						            guardarVehiculo.setVehiculoClaseVehiculo(getProClaseVehciulo);
						            guardarVehiculo.setVehiculoMarca(getProMarcaVehiculo);
						            guardarVehiculo.setVehiculoColor(getProColorVehiculo);
						            guardarVehiculo.setVehiculoObservacion(getProVehiculoObservacion);
						            guardarVehiculo.setVehiculoEstado(getProVehciuloEstado);
						            userService.createVehiculo(guardarVehiculo);  
					            }
					                     
					            //Guardamos los datos de la mascota
					            String[] datosProNombreMascota = datosGenerales.getProNombreMascota().split(",");
					            String[] datosProRaza = datosGenerales.getProRaza().split(",");
					            String[] datosProEdad = datosGenerales.getProEdad().split(",");
					            String[] datosMascotaObservacion = datosGenerales.getProMascotaObservacion().split(",");
					            String[] datosProMascotaEstado = datosGenerales.getProMascotaEstado().split(",");
					            
					            for (int i = 0; i < datosProNombreMascota.length; i++) {					          
					            	String getProNombreMascota = datosProNombreMascota[i];
					            	String getProRaza = datosProRaza[i];
					            	String getProEdad = datosProEdad[i];
					            	String getMascotaObservacion = datosMascotaObservacion[i];
					            	String getProMascotaEstado = datosProMascotaEstado[i];
					            	
					            	Mascota guardarMascota= new Mascota();
					            	guardarMascota.setCopNit(copNit);
					            	guardarMascota.setProNumeroResidencia(datosGenerales.getProNumeroResidencia());
					            	guardarMascota.setMascotaNombre(getProNombreMascota);
					            	guardarMascota.setMascotaRaza(getProRaza);
					            	guardarMascota.setMascotaEdad(getProEdad);
					            	guardarMascota.setMascotaObservacion(getMascotaObservacion);
					            	guardarMascota.setMascotaEstado(getProMascotaEstado);					           
						            userService.createMascota(guardarMascota); 
					            }
					            
					            //EN CASO DE EMERGENCIA COMUNICARSE CON
					            ContactoEmergencia guardarcasoEmergencia= new ContactoEmergencia();
					            guardarcasoEmergencia.setCopNit(copNit);
					            guardarcasoEmergencia.setProNumeroResidencia(datosGenerales.getProNumeroResidencia());
					            guardarcasoEmergencia.setEmergenciaNumeroDocumento(Integer.parseInt(datosGenerales.getProEmergenciaNumeroDocumento()));
					            guardarcasoEmergencia.setEmergenciaNombres(datosGenerales.getProEmergenciaNombres());
					            guardarcasoEmergencia.setEmergenciaApellidos(datosGenerales.getProEmergenciaApellidos());
					            guardarcasoEmergencia.setEmergenciaNumeroCelular(datosGenerales.getProEmergenciaCelular());
					            guardarcasoEmergencia.setEmergenciaEmail(datosGenerales.getProEmergenciaEmail()); 
					            guardarcasoEmergencia.setEmergenciaEstado(datosGenerales.getProEmergenciaEstado());
					            guardarcasoEmergencia.setEmergenciaPerfil(String.valueOf(tipoPerfil));
					            guardarcasoEmergencia.setComuFecha("");				         
					            userService.createContactoEmergencia(guardarcasoEmergencia); 
					            
					            
				           }
					           
					       /////Validamos si es un inquilino y registramos todos sus datos
					       if(datosGenerales.getDatosperTipoResidente().equals("12")) {
					        	   
						            //Guardamos los datos del iquilino
						            Inquilino guardarInquilino = new Inquilino();
						            guardarInquilino.setCopNit(copNit);
						            guardarInquilino.setProNumeroResidencia(datosGenerales.getInquiloNumeroResidencia());
						            guardarInquilino.setInquilinoNumeroDocumento(datosGenerales.getInquilinoNumeroDocumento());
						            guardarInquilino.setInquilinoNombres(datosGenerales.getInquilinoNombres());
						            guardarInquilino.setInquilinoNumeroCelular(datosGenerales.getInquilinoCelular());
						            guardarInquilino.setInquilinoTelefono(datosGenerales.getInquilinoTelefono());
						            guardarInquilino.setInquilinoEmail(datosGenerales.getInquilinoDireccionCorrespondencia());
						            guardarInquilino.setInquilinoDireccionCorrespondencia(datosGenerales.getInquilinoDireccionCorrespondencia());
						            guardarInquilino.setInquilinoPerfil("");
						            guardarInquilino.setInquilinoEstado(datosGenerales.getInquilinoEstado());					            
						            userService.createInquilino(guardarInquilino);
						            
						            //GUARDAMOS LOS DATOS DEL RESIDENTE
						            String[] datosInquilinoResidenteNumeroDocumento = datosGenerales.getInquilinoResidenteNumeroDocumento().split(",");
						            String[] datosInquilinoResidenteNombres = datosGenerales.getInquilinoResidenteNombres().split(",");
						            String[] datosInquilinoResidenteApellidos = datosGenerales.getInquilinoResidenteApellidos().split(",");
						            String[] datosInquilinoResidenteNumeroTelefono = datosGenerales.getInquilinoResidenteNumeroTelefono().split(",");
						            String[] datosInquilinoResidenteParentesco = datosGenerales.getInquilinoResidenteParentesco().split(",");      
						            String[] datosInquilinoResidenteEstado = datosGenerales.getInquilinoResidenteEstado().split(",");
						            
						            for (int i = 0; i < datosInquilinoResidenteNumeroDocumento.length; i++) {					          
						            	String getInquilinoResidenteNumeroDocumento = datosInquilinoResidenteNumeroDocumento[i];
						            	String getInquilinoResidenteNombres = datosInquilinoResidenteNombres[i];
						            	String getInquilinoResidenteApellidos = datosInquilinoResidenteApellidos[i];
						            	String getInquilinoResidenteNumeroTelefono = datosInquilinoResidenteNumeroTelefono[i];
						            	String getInquilinoResidenteParentesco = datosInquilinoResidenteParentesco[i];
						            	String getInquilinoResidenteEstado = datosInquilinoResidenteEstado[i];
						            	
						            	Residentes guardarResidentes = new Residentes();
						            	guardarResidentes.setCopNit(copNit);
						            	guardarResidentes.setProNumeroResidencia(datosGenerales.getInquiloNumeroResidencia());
						            	guardarResidentes.setResidenteNumeroDocumento(Integer.parseInt(getInquilinoResidenteNumeroDocumento));
						            	guardarResidentes.setResidenteNombres(getInquilinoResidenteNombres);
						            	guardarResidentes.setResidenteApellidos(getInquilinoResidenteApellidos);
						            	guardarResidentes.setResidenteNumeroTelefonico(getInquilinoResidenteNumeroTelefono);
						            	guardarResidentes.setResidenteParentesco(getInquilinoResidenteParentesco);
						            	guardarResidentes.setResidenteEstado(getInquilinoResidenteEstado);
						            	guardarResidentes.setResidentePerfil(tipoPerfil);						            	
						            	userService.createResidentes(guardarResidentes);
						            }
						            				            
						            //PERSONAS AUTORIZADAS PARA INGRESAR SIN PREVIO AVISO PARA EL INQUILINO:
						            String[] datosInquilinoAutorizaNumeroDocumento = datosGenerales.getInquilinoAutorizaNumeroDocumento().split(",");
						            String[] datosInquilinoAutorizaNombres = datosGenerales.getInquilinoAutorizaNombres().split(",");
						            String[] datosInquilinoAutorizaApellidos = datosGenerales.getInquilinoAutorizaApellidos().split(",");
						            String[] datosInquilinoAutorizaNumeroTelefono = datosGenerales.getInquilinoAutorizaNumeroTelefono().split(",");
						            String[] datosInquilinoAutorizaParentesco = datosGenerales.getInquilinoAutorizaParentesco().split(",");
						            String[] datosInquilinoAutoriFechaIngreso = datosGenerales.getInquilinoAutoriFechaIngreso().split(",");
						            String[] datosInquilinoAutoriFechaSalida = datosGenerales.getInquilinoAutoriFechaSalida().split(",");
						            String[] datosInquilinoAutoriPlacaVehiculo = datosGenerales.getInquilinoAutoriPlacaVehiculo().split(",");
						            String[] datosInquilinoAutorizaEstado = datosGenerales.getInquilinoAutorizaEstado().split(",");
						            
						            for (int i = 0; i < datosInquilinoAutorizaNumeroDocumento.length; i++) {
						            	
						            	String getInquilinoAutorizaNumeroDocumento = datosInquilinoAutorizaNumeroDocumento[i];
						            	String getInquilinoAutorizaNombres = datosInquilinoAutorizaNombres[i];
						            	String getInquilinoAutorizaApellidos = datosInquilinoAutorizaApellidos[i];
						            	String getInquilinoAutorizaNumeroTelefono = datosInquilinoAutorizaNumeroTelefono[i];
						            	String getInquilinoAutorizaParentesco = datosInquilinoAutorizaParentesco[i];
						            	String getInquilinoAutoriFechaIngreso = datosInquilinoAutoriFechaIngreso[i];
						            	String getInquilinoAutoriFechaSalida = datosInquilinoAutoriFechaSalida[i];
						            	String getInquilinoAutoriPlacaVehiculo = datosInquilinoAutoriPlacaVehiculo[i];
						            	String getInquilinoAutorizaEstado = datosInquilinoAutorizaEstado[i];
						            	
						            	AutorizacionIngreso guardarAutorizacionIngreso= new AutorizacionIngreso();				          	
						            	guardarAutorizacionIngreso.setCopNit(copNit);
						            	guardarAutorizacionIngreso.setAutoriNumeroDocumento(Integer.parseInt(getInquilinoAutorizaNumeroDocumento));
						           	    guardarAutorizacionIngreso.setProNumeroResidencia(Integer.parseInt(datosGenerales.getInquiloNumeroResidencia()));
						           	    guardarAutorizacionIngreso.setProCc(datosGenerales.getDatosperNumeroDocumento());
						           	    guardarAutorizacionIngreso.setAutoriNombres(getInquilinoAutorizaNombres);
						           	    guardarAutorizacionIngreso.setAutoriApellidos(getInquilinoAutorizaApellidos);
						           	    guardarAutorizacionIngreso.setAutoriNumeroTelefonico(Integer.parseInt(getInquilinoAutorizaNumeroTelefono));
						           	    guardarAutorizacionIngreso.setAutoriParentesco(getInquilinoAutorizaParentesco);
						           	    guardarAutorizacionIngreso.setAutoriEstado(Integer.parseInt(getInquilinoAutorizaEstado));
						           	    guardarAutorizacionIngreso.setAutoriPerfil(tipoPerfil);
						           	    guardarAutorizacionIngreso.setAutoriFechaIngreso(getInquilinoAutoriFechaIngreso);
						            	guardarAutorizacionIngreso.setAutoriFechaSalida(getInquilinoAutoriFechaSalida);
						            	guardarAutorizacionIngreso.setAutoriPlacaVehiculo(getInquilinoAutoriPlacaVehiculo);						            	
						            	userService.createAutorizacion(guardarAutorizacionIngreso);					          
						            }
						            					         		            					            
						            //Guardamos los datos del vehiculo del inquilino
						            String[] datosInquilinoPlaca = datosGenerales.getInquilinoPlaca().split(",");
						            String[] datosInquilinoClaseVehiculo = datosGenerales.getInquilinoClaseVehiculo().split(",");
						            String[] datosInquilinoMarcaVehiculo = datosGenerales.getInquilinoMarcaVehiculo().split(",");
						            String[] datosInquilinoColorVehiculo = datosGenerales.getInquilinoColorVehiculo().split(",");
						            String[] datosInquilinoVehiculoObservacion = datosGenerales.getInquilinoVehiculoObservacion().split(",");
						            String[] datosInquilinoVehiculoEstado = datosGenerales.getInquilinoVehiculoEstado().split(",");
						            
						            for (int i = 0; i < datosInquilinoPlaca.length; i++) {					          
						            	String getInquilinoPlaca = datosInquilinoPlaca[i];
						            	String getInquilinoClaseVehiculo = datosInquilinoClaseVehiculo[i];
						            	String getInquilinoMarcaVehiculo = datosInquilinoMarcaVehiculo[i];
						            	String getInquilinoColorVehiculo = datosInquilinoColorVehiculo[i];
						            	String getInquilinoVehiculoObservacion = datosInquilinoVehiculoObservacion[i];
						            	String getInquilinoVehiculoEstado = datosInquilinoVehiculoEstado[i];
						            	
						            	Vehiculo guardarVehiculo= new Vehiculo();
							            guardarVehiculo.setCopNit(copNit);
							            guardarVehiculo.setProNumResidencia(datosGenerales.getInquiloNumeroResidencia());
							            guardarVehiculo.setVehiculoPlaca(getInquilinoPlaca);
							            guardarVehiculo.setVehiculoClaseVehiculo(getInquilinoClaseVehiculo);
							            guardarVehiculo.setVehiculoMarca(getInquilinoMarcaVehiculo);
							            guardarVehiculo.setVehiculoColor(getInquilinoColorVehiculo);
							            guardarVehiculo.setVehiculoObservacion(getInquilinoVehiculoObservacion);
							            guardarVehiculo.setVehiculoEstado(getInquilinoVehiculoEstado);
							            userService.createVehiculo(guardarVehiculo);  
						            }
						                     
						            //Guardamos los datos de la mascota
						            String[] datosInquilinoNombreMascota = datosGenerales.getInquilinoNombreMascota().split(",");
						            String[] datosInquilinoRaza = datosGenerales.getInquilinoRaza().split(",");
						            String[] datosInquilinoEdad = datosGenerales.getInquilinoEdad().split(",");
						            String[] datosInquilinoMascotaObservacion = datosGenerales.getInquilinoMascotaObservacion().split(",");
						            String[] datosInquilinoMascotaEstado = datosGenerales.getInquilinoMascotaEstado().split(",");
						            
						            for (int i = 0; i < datosInquilinoNombreMascota.length; i++) {					          
						            	String getInquilinoNombreMascota = datosInquilinoNombreMascota[i];
						            	String getInquilinoRaza = datosInquilinoRaza[i];
						            	String getInquilinoEdad = datosInquilinoEdad[i];
						            	String getInquilinoMascotaObservacion = datosInquilinoMascotaObservacion[i];
						            	String getInquilinoMascotaEstado = datosInquilinoMascotaEstado[i];
						            	
						            	Mascota guardarMascota= new Mascota();
						            	guardarMascota.setCopNit(copNit);
						            	guardarMascota.setProNumeroResidencia(datosGenerales.getInquiloNumeroResidencia());
						            	guardarMascota.setMascotaNombre(getInquilinoNombreMascota);
						            	guardarMascota.setMascotaRaza(getInquilinoRaza);
						            	guardarMascota.setMascotaEdad(getInquilinoEdad);
						            	guardarMascota.setMascotaObservacion(getInquilinoMascotaObservacion);
						            	guardarMascota.setMascotaEstado(getInquilinoMascotaEstado);					           
							            userService.createMascota(guardarMascota); 
						            }
						            
							           //EN CASO DE EMERGENCIA COMUNICARSE CON
							           ContactoEmergencia guardarcasoEmergenciaInquilino= new ContactoEmergencia();
							           guardarcasoEmergenciaInquilino.setCopNit(copNit);
							           guardarcasoEmergenciaInquilino.setProNumeroResidencia(datosGenerales.getProNumeroResidencia());
							           guardarcasoEmergenciaInquilino.setEmergenciaNumeroDocumento(Integer.parseInt(datosGenerales.getInquilinoEmergenciaNumeroDocumento()));
							           guardarcasoEmergenciaInquilino.setEmergenciaNombres(datosGenerales.getInquilinoEmergenciaNombres());
							           guardarcasoEmergenciaInquilino.setEmergenciaApellidos(datosGenerales.getInquilinoEmergenciaApellidos());
							           guardarcasoEmergenciaInquilino.setEmergenciaNumeroCelular(datosGenerales.getInquilinoEmergenciaCelular());
							           guardarcasoEmergenciaInquilino.setEmergenciaEmail(datosGenerales.getInquilinoEmergenciaEmail()); 
							           guardarcasoEmergenciaInquilino.setEmergenciaEstado(datosGenerales.getInquilinoEmergenciaEstado());
							           guardarcasoEmergenciaInquilino.setEmergenciaPerfil(String.valueOf(tipoPerfil));
							           guardarcasoEmergenciaInquilino.setComuFecha("");				         
							           userService.createContactoEmergencia(guardarcasoEmergenciaInquilino);                  
					           }
					           
					           /////Validamos si es un Administrador y registramos todos sus datos
					           if(datosGenerales.getDatosperTipoResidente().equals("16")) {
						            							            	
							            //Guardamos los datos del usuario
							            guardarUsuario.setPerId(tipoPerfil);
							            guardarUsuario.setProCc(Integer.parseInt(datosGenerales.getAdministradorNumeroDocumento()));
							            guardarUsuario.setUsername(datosGenerales.getAdministradorUsser());					           
							            guardarUsuario.setUsuClave(passCryptFormulario.passwordEncoder(datosGenerales.getAdministradorPass()));
							            guardarUsuario.setUsuEstado(datosGenerales.getAdministradorEstado());
							            userService.createUsuario(guardarUsuario); 
							            
							            Terceros guardarTeceros = new Terceros();
							        	guardarTeceros.setCopNit(copNit);
							        	guardarTeceros.setTercePerfil(tipoPerfil);
							        	guardarTeceros.setTerceNumeroDocumento(datosGenerales.getAdministradorNumeroDocumento());
							        	guardarTeceros.setTerceNombres(datosGenerales.getAdministradorNombres());
							        	guardarTeceros.setTerceApellidos(datosGenerales.getAdministradorApellidos());
							        	guardarTeceros.setTerceNumeroCelular(datosGenerales.getAdministradorCelular());
							        	guardarTeceros.setTerceTelefono(datosGenerales.getAdministradorTelefono());
							        	guardarTeceros.setTerceEmail(datosGenerales.getAdministradorEmail());
							        	guardarTeceros.setTerceDireccionCorrespondencia(datosGenerales.getAdministradorDireccionCorrespondencia());
							        	guardarTeceros.setTerceObservaciones(datosGenerales.getAdministradorObservaciones());
							        	userService.createTerceros(guardarTeceros);		
					           }
					           
					           /////Validamos si es un Guarda de seguridad y registramos todos sus datos
					           if(datosGenerales.getDatosperTipoResidente().equals("17")) {
					        	   					        				       	   
						        	    //Guardamos los datos del usuario
							            guardarUsuario.setPerId(tipoPerfil);
							            guardarUsuario.setProCc(Integer.parseInt(datosGenerales.getGuardaNumeroDocumento()));
							            guardarUsuario.setUsername(datosGenerales.getGuardaUsser());					           
							            guardarUsuario.setUsuClave(passCryptFormulario.passwordEncoder(datosGenerales.getGuardaPass()));
							            guardarUsuario.setUsuEstado(datosGenerales.getGuardaEstado());
							            userService.createUsuario(guardarUsuario);
							            
							            Terceros guardarTeceros = new Terceros();
							        	guardarTeceros.setCopNit(copNit);
							        	guardarTeceros.setTercePerfil(tipoPerfil);
							        	guardarTeceros.setTerceNumeroDocumento(datosGenerales.getGuardaNumeroDocumento());
							        	guardarTeceros.setTerceNombres(datosGenerales.getGuardaNombres());
							        	guardarTeceros.setTerceApellidos(datosGenerales.getGuardaApellidos());
							        	guardarTeceros.setTerceNumeroCelular(datosGenerales.getGuardaCelular());
							        	guardarTeceros.setTerceTelefono(datosGenerales.getGuardaTelefono());
							        	guardarTeceros.setTerceEmail(datosGenerales.getGuardaEmail());
							        	guardarTeceros.setTerceDireccionCorrespondencia(datosGenerales.getGuardaDireccionCorrespondencia());
							        	guardarTeceros.setTerceObservaciones(datosGenerales.getGuardaObservaciones());
							        	userService.createTerceros(guardarTeceros);		
					           }
					           
					           //Validamos si es un Contador y registramos todos sus datos
					           if(datosGenerales.getDatosperTipoResidente().equals("18")) {
					        	   
					        	    //Guardamos los datos del usuario
						            guardarUsuario.setPerId(tipoPerfil);
						            guardarUsuario.setProCc(Integer.parseInt(datosGenerales.getContadorNumeroDocumento()));
						            guardarUsuario.setUsername(datosGenerales.getContadorUsser());					           
						            guardarUsuario.setUsuClave(passCryptFormulario.passwordEncoder(datosGenerales.getContadorPass()));
						            guardarUsuario.setUsuEstado(datosGenerales.getContadorEstado());
						            userService.createUsuario(guardarUsuario);
						            
						            Terceros guardarTeceros = new Terceros();
						        	guardarTeceros.setCopNit(copNit);
						        	guardarTeceros.setTercePerfil(tipoPerfil);
						        	guardarTeceros.setTerceNumeroDocumento(datosGenerales.getContadorNumeroDocumento());
						        	guardarTeceros.setTerceNombres(datosGenerales.getContadorNombres());
						        	guardarTeceros.setTerceApellidos(datosGenerales.getContadorApellidos());
						        	guardarTeceros.setTerceNumeroCelular(datosGenerales.getContadorCelular());
						        	guardarTeceros.setTerceTelefono(datosGenerales.getContadorTelefono());
						        	guardarTeceros.setTerceEmail(datosGenerales.getContadorEmail());
						        	guardarTeceros.setTerceDireccionCorrespondencia(datosGenerales.getContadorDireccionCorrespondencia());
						        	guardarTeceros.setTerceObservaciones(datosGenerales.getContadorObservaciones());
						        	userService.createTerceros(guardarTeceros);		
					           }
					           
					           /////Validamos si es un un Revisor Fiscal y registramos todos sus datos
					           if(datosGenerales.getDatosperTipoResidente().equals("19")) {
					        	   
					        	    //Guardamos los datos del usuario
						            guardarUsuario.setPerId(tipoPerfil);
						            guardarUsuario.setProCc(Integer.parseInt(datosGenerales.getRevisorNumeroDocumento()));
						            guardarUsuario.setUsername(datosGenerales.getRevisorUsser());					           
						            guardarUsuario.setUsuClave(passCryptFormulario.passwordEncoder(datosGenerales.getRevisorPass()));
						            guardarUsuario.setUsuEstado(datosGenerales.getRevisorEstado());
						            userService.createUsuario(guardarUsuario);
						            
						        	Terceros guardarTeceros = new Terceros();
						        	guardarTeceros.setCopNit(copNit);
						        	guardarTeceros.setTercePerfil(tipoPerfil);
						        	guardarTeceros.setTerceNumeroDocumento(datosGenerales.getRevisorNumeroDocumento());
						        	guardarTeceros.setTerceNombres(datosGenerales.getRevisorNombres());
						        	guardarTeceros.setTerceApellidos(datosGenerales.getRevisorApellidos());
						        	guardarTeceros.setTerceNumeroCelular(datosGenerales.getRevisorCelular());
						        	guardarTeceros.setTerceTelefono(datosGenerales.getRevisorTelefono());
						        	guardarTeceros.setTerceEmail(datosGenerales.getRevisorEmail());
						        	guardarTeceros.setTerceDireccionCorrespondencia(datosGenerales.getRevisorDireccionCorrespondencia());
						        	guardarTeceros.setTerceObservaciones(datosGenerales.getRevisorObservaciones());
						        	userService.createTerceros(guardarTeceros);						            
					           }
					           
					            
							    DatosGenerales guardarDatosGenerales = new DatosGenerales();
							    guardarDatosGenerales.setCopNit(copNit);
							    guardarDatosGenerales.setDatosperApellidos(datosGenerales.getDatosperApellidos());
							    guardarDatosGenerales.setDatosperCelular(datosGenerales.getDatosperCelular());
							    guardarDatosGenerales.setDatosperDireccionCorrespondencia(datosGenerales.getDatosperDireccionCorrespondencia());
							    guardarDatosGenerales.setDatosperEmail(datosGenerales.getDatosperEmail());
							    guardarDatosGenerales.setDatosperEstado(datosGenerales.getDatosperEstado());
							    //guardarDatosGenerales.setDatosperHabitante(datosGenerales.getDatosperHabitante());
							    //guardarDatosGenerales.setDatosperMastoca(datosGenerales.getDatosperMastoca());
							   // guardarDatosGenerales.setDatosperNumeroDocumento(datosGenerales.getDatosperNumeroDocumento());
							    guardarDatosGenerales.setDatosperNombres(datosGenerales.getDatosperNombres());
							    //guardarDatosGenerales.setDatosperObservaciones(datosGenerales.getDatosperObservaciones());
							    //guardarDatosGenerales.setDatosperPropietario(datosGenerales.getDatosperPropietario());
							    guardarDatosGenerales.setDatosperTelefono(datosGenerales.getDatosperTelefono());
							    guardarDatosGenerales.setDatosperTipoResidente(datosGenerales.getDatosperTipoResidente());
							    //guardarDatosGenerales.setDatosperVehiculo(datosGenerales.getDatosperVehiculo());
							    guardarDatosGenerales.setProNumeroResidencia(datosGenerales.getProNumeroResidencia());
							    
							   
							    //userService.createPropiedad(guardarPropiedad);
							    userService.createDatosGenerales(guardarDatosGenerales);
							    
					  
					
					
					model.addAttribute("datosgeneralesForm", datosGenerales);
					model.addAttribute("bien","active");
					model.addAttribute("activarmodalactualizar", "A");
					
				} catch (Exception e) {
					model.addAttribute("error","active");
					model.addAttribute("formErrorMessage",e.getMessage());
					model.addAttribute("datosgeneralesForm", datosGenerales);
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
			
			return "administrador/datosGenerales";
		}


}
