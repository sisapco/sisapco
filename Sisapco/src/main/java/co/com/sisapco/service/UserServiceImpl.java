package co.com.sisapco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sisapco.dto.ChangePasswordForm;
import co.com.sisapco.entity.Actas;
import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.Cartelera;
import co.com.sisapco.entity.Comunicados;
import co.com.sisapco.entity.Contrato;
import co.com.sisapco.entity.ControlPagos;
import co.com.sisapco.entity.Copropiedad;
import co.com.sisapco.entity.Cotizaciones;

import co.com.sisapco.entity.Dane;
import co.com.sisapco.entity.EstadosFinancieros;

import co.com.sisapco.entity.DatosGenerales;
import co.com.sisapco.entity.EvidenciaActividades;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Modulo;
import co.com.sisapco.entity.Perfil;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Propietarios;
import co.com.sisapco.entity.Proyectos;
import co.com.sisapco.entity.SancionesMulta;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.repository.ActasRepository;
import co.com.sisapco.repository.ActividadesRepository;
import co.com.sisapco.repository.AlmacenamientoGoogleRepository;
import co.com.sisapco.repository.CargaInfoCarteleraRepository;
import co.com.sisapco.repository.ComunicadosRepository;
import co.com.sisapco.repository.ContratoRepository;
import co.com.sisapco.repository.ControlPagosRepository;
import co.com.sisapco.repository.CopropiedadRepository;
import co.com.sisapco.repository.CotizacionesRepository;
import co.com.sisapco.repository.DaneRepository;
import co.com.sisapco.repository.EstadosFinancierosRepository;
import co.com.sisapco.repository.DatosGeneralesRepository;
import co.com.sisapco.repository.EvidenciaActividadesRepository;
import co.com.sisapco.repository.ManualConvivenciaRepository;
import co.com.sisapco.repository.ModuloRepository;
import co.com.sisapco.repository.PerfilRepository;
import co.com.sisapco.repository.PqrsRepository;
import co.com.sisapco.repository.PropietariosRepository;
import co.com.sisapco.repository.ProyectosRepository;
import co.com.sisapco.repository.SancionesMultaRepository;
import co.com.sisapco.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	ModuloRepository repositoryModulo;
	
	@Autowired
	PerfilRepository repositoryPerfil;
	
	@Autowired
	CopropiedadRepository repositoryCopropiedad;
	
	@Autowired
	ActividadesRepository repositoryActividades;
	
	@Autowired
	EvidenciaActividadesRepository repositoryEvidenciaActividades;
	
	@Autowired
	ActasRepository repositoryActas;
	
	@Autowired
	AlmacenamientoGoogleRepository repositoryAlmacenamientoGoogle;
	
	@Autowired
	ContratoRepository repositoryContrato;
	
	@Autowired
	CotizacionesRepository repositoryCotizaciones;
	
	@Autowired
	ProyectosRepository repositoryProyectos;
	
	@Autowired
	PqrsRepository repositoryPqrs;
	
	@Autowired
	PropietariosRepository repositoryPropietarios;
	
	@Autowired
	ControlPagosRepository repositoryControlPagos;
	
	@Autowired
    SancionesMultaRepository repositorySancionesMulta;
	
	@Autowired
    DaneRepository repositoryDane;
	
	@Autowired
	EstadosFinancierosRepository repositoryEstadosFinancieros;
	
	@Autowired
	ManualConvivenciaRepository repositoryManualConvivencia;
	
	@Autowired
	ComunicadosRepository repositoryComunicados;

	@Autowired
    DatosGeneralesRepository repositoryDatosGenerales;
    
	@Autowired
    CargaInfoCarteleraRepository repositoryCargaInfoCartelera;
	
	@Override
	public Iterable<Usuarios> getAllUsers(){
		return repository.findAll();
	}
	
	private boolean checkusernameVailable(Usuarios user) throws Exception {
		
		Optional<Usuarios> userFound = repository.findByUsername(user.getUsername());
		
		if(userFound.isPresent()) {
			throw new Exception("Usuario no disponible");
			
		}
		return true;
		
	}
	
	private boolean checkPasswordValid(Usuarios user) throws Exception {
		
		if(user.getConfirmPassword()==null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirmar Password es obligatorio");
		}
		
		if(!user.getUsuClave().equals(user.getConfirmPassword())) {
			
			throw new Exception("Password y Confirmar password no son iguales");
			
		}
		return true;
	
	}

	@Override
	public Usuarios createUser(Usuarios user) throws Exception {
		if(checkusernameVailable(user) && checkPasswordValid(user)) {
			user=repository.save(user);
		}
		return user;
	}

	@Override
	public Usuarios geUsuariosById(Long id) throws Exception {

	    return repository.findById(id).orElseThrow(() -> new Exception("El usuario no existe."));
	}
	
	
	@Override
	public Usuarios geUsuariosByUsername(String user) throws Exception {

	    return repository.findByUsername(user).orElseThrow(() -> new Exception("El usuario no existe."));
	}

	@Override
	public Usuarios updateUser(Usuarios user) throws Exception {

		Usuarios toUser = geUsuariosById(user.getUsuId());
		mapUser(user, toUser);
		return repository.save(toUser);
	}
	
	protected void mapUser(Usuarios from, Usuarios to) {
		
		to.setPerId(from.getPerId());
		to.setProCc(from.getProCc());
		to.setUsername(from.getUsername());
		to.setUsuEstado(from.getUsuEstado());
		
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		
		Usuarios user = geUsuariosById(id);
		repository.delete(user);
	}

	@Override
	public Usuarios changePassword(ChangePasswordForm form) throws Exception {
		
        Usuarios user = geUsuariosById(form.getUsuId());
		
        
        if(!user.getUsuClave().equals(form.getCurrentPassword())) {
        	throw new Exception("Current password invalido");
        }
        
		
		if(user.getUsuClave().equals(form.getNewPassword())) {
			throw new Exception ("Nuevo debe ser diferente al password actual.");
		}
		
		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
		}
		
		//String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		user.setUsuClave(form.getNewPassword());
		return repository.save(user);
		
	}

	
	@Override
	public Iterable<Modulo> getModulosByAll() throws Exception {
		
	    return repositoryModulo.findByModulos();
	}
	
	@Override
	public Iterable<Modulo> getModulosById(int perfilId) throws Exception {
		// TODO Auto-generated method stub
		return repositoryModulo.findByModulosId(perfilId);
	}

	@Override
	public Perfil getPefilById(int perfilId) throws Exception {

	    return repositoryPerfil.findByPerfilId(perfilId).orElseThrow(() -> new Exception("El usuario no existe."));
	}

	@Override
	public Iterable<Copropiedad> getCopropiedadUsuario(int usuId) throws Exception {
		return repositoryCopropiedad.findByCopropiedadUsuario(usuId);
	}
	
	@Override
	public Iterable<Copropiedad> getCopropiedadByNit(int nit) throws Exception {
		return repositoryCopropiedad.findByCopropiedadNit(nit);
	}

	@Override
	public Iterable<Actividades> getActividadesByNit(int codNit) throws Exception {
		return repositoryActividades.findByActividadesNit(codNit);
	}

	@Override
	public Iterable<Actividades> getActividadesById(int actId) throws Exception {
		return repositoryActividades.findByActividadesId(actId);
	}

	@Override
	public Copropiedad getCopropiedadById(int id) throws Exception {
		
		return repositoryCopropiedad.findByCopropiedadId(id).orElseThrow(() -> new Exception("El usuario no existe."));
	
	}

	@Override
	public Actividades createActividad(Actividades actividad) throws Exception {

		actividad=repositoryActividades.save(actividad);
		
		return actividad;
	}

	@Override
	public EvidenciaActividades createEvidenciaActividad(EvidenciaActividades evidenciaActividades) throws Exception {
		// TODO Auto-generated method stub
		
		evidenciaActividades=repositoryEvidenciaActividades.save(evidenciaActividades);
		
		return evidenciaActividades;
	}
	


	@Override
	public Iterable<EvidenciaActividades> getEvidenciaActividadesByActId(int actId) throws Exception {
		return repositoryEvidenciaActividades.findByEvidenciaActividadesActId(actId);
	}

	@Override
	public Actividades getActividadesByIdForm(int actId) throws Exception {
		return repositoryActividades.findByActividadesIdForm(actId);
	}

	@Override
	public Actas createActa(Actas actas) throws Exception {
		actas=repositoryActas.save(actas);
		
		return actas;
	}

	@Override
	public Iterable<Actas> getActasByNit(int codNit) throws Exception {
		return repositoryActas.findByActasNit(codNit);
	}

	@Override
	public Actas getActaByIdForm(int actId) throws Exception {
		return repositoryActas.findByActaIdForm(actId);
	}
	
	@Override
	public Actas getActasByIdConsecutivoForm(int copNit) throws Exception {
		return repositoryActas.findByActasNitConsecutivo(copNit);
	}

	@Override
	public AlmacenamientoGoogle getAlmacenamientoGoogleByIdForm(int codNit, String carpeta) throws Exception {
		return repositoryAlmacenamientoGoogle.findByAlmacenamientoGoogleNit(codNit, carpeta);
		
	}

	@Override
	public Contrato createContrato(Contrato contrato) throws Exception {
		// TODO Auto-generated method stub
         contrato=repositoryContrato.save(contrato);
		return contrato;
		
	}

	@Override
	public Iterable<Contrato> getContratoByNit(int copNit) throws Exception {
		return repositoryContrato.findByContratoNit(copNit);
	}

	@Override
	public Cotizaciones createCorizaciones(Cotizaciones cotizaciones) throws Exception {
		// TODO Auto-generated method stub
		cotizaciones=repositoryCotizaciones.save(cotizaciones);
	    return cotizaciones;
	}

	@Override
	public Iterable<Cotizaciones> getCotizacionesByNit(int copNit) throws Exception {
		// TODO Auto-generated method stub
		return repositoryCotizaciones.findByCotizacionesNit(copNit);
	}

	@Override
	public Iterable<Proyectos> getProyectosByNit(int copNit) throws Exception {
		// TODO Auto-generated method stub
		return repositoryProyectos.findByProyectosNit(copNit);
	}

	@Override
	public Iterable<Pqrs> getPqrsByNit(int codNit) throws Exception {
		// TODO Auto-generated method stub
		return repositoryPqrs.findByPqrsNit(codNit);
	}
	

	@Override
	public Pqrs createPqrs(Pqrs pqrs) throws Exception {
		// TODO Auto-generated method stub
		pqrs=repositoryPqrs.save(pqrs);
	    return pqrs;
	}

	@Override
	public Pqrs getPqrsByIdConsecutivoForm(int copNit) throws Exception {
		// TODO Auto-generated method stub
		return repositoryPqrs.findByPqrsNitConsecutivo(copNit);
	}

	@Override
	public Propietarios getPropietariosByIdCedula(int proCc) throws Exception {
		return repositoryPropietarios.findByPropietariosCc(proCc);
	}

	@Override
	public Pqrs getPqrsByIdForm(int idPqrs) throws Exception {
		return repositoryPqrs.findByPqrsIdForm(idPqrs);
	}

	@Override
	public ControlPagos createControlPagos(ControlPagos controlPagos) throws Exception {
		controlPagos=repositoryControlPagos.save(controlPagos);
		return controlPagos;
	}

	@Override
	public SancionesMulta findBySancionesMultaNitConsecutivoForm(int copNit) throws Exception {
		// TODO Auto-generated method stub
		return repositorySancionesMulta.findBySancionesMultaNitConsecutivo(copNit);
	}

	@Override
	public SancionesMulta createSancionesMulta(SancionesMulta sancionesMulta) throws Exception {
		sancionesMulta = repositorySancionesMulta.save(sancionesMulta);
		return sancionesMulta;
	}

	@Override
	public Iterable<SancionesMulta> getSancionesMultaByNit(int copNit) throws Exception {		
		return repositorySancionesMulta.findBySancionesMultaNit(copNit);		
	}

	@Override
	public Iterable<Dane> getDaneDepartamentos() throws Exception {
		return repositoryDane.findByDaneDepartamentos();
	}

	@Override
	public Iterable<Dane> getMunicipioCodigoDepartamento(String codigoDepartamento) throws Exception {
		return repositoryDane.findByMunicipioCodigoDepartamento(codigoDepartamento);
	}

	@Override
	public EstadosFinancieros createEstadosFinancieros(EstadosFinancieros estadosFinancieros) throws Exception {
		estadosFinancieros = repositoryEstadosFinancieros.save(estadosFinancieros);
		return estadosFinancieros;
	}

	@Override
	public ManualConvivencia createManualConvivencia(ManualConvivencia manualConvivencia) throws Exception {		
		manualConvivencia = repositoryManualConvivencia.save(manualConvivencia);		
		return manualConvivencia;
	}

	@Override
	public Comunicados createComunicados(Comunicados comunicados) throws Exception {
		comunicados = repositoryComunicados.save(comunicados);		
		return comunicados;
	}

	@Override
	public Iterable<Comunicados> getComunicadosByNit(int codNit) throws Exception {
		return repositoryComunicados.findByComunicadosNit(codNit);
	}

	@Override
	public Iterable<ManualConvivencia> getManualConvivenciaByNit(int codNit) throws Exception {
		return repositoryManualConvivencia.findByManualConvivenciaNit(codNit);
	}

	@Override
	public Iterable<EstadosFinancieros> getEstadosFinancierosByNit(int codNit) throws Exception {
		return repositoryEstadosFinancieros.findByEstadosFinancierosNit(codNit);
	}

	@Override
	public DatosGenerales createDatosGenerales(DatosGenerales datosGenerales) throws Exception {
	    datosGenerales = repositoryDatosGenerales.save(datosGenerales);
		return null;
	}

	@Override
	public Cartelera createCartelera(Cartelera cartelera) throws Exception {
		// TODO Auto-generated method stub
		return repositoryCargaInfoCartelera.save(cartelera);
	}

	@Override
	public Copropiedad createCopropiedad(Copropiedad copropiedad) throws Exception {
		// TODO Auto-generated method stub
		return repositoryCopropiedad.save(copropiedad);
	}
	
	
}
