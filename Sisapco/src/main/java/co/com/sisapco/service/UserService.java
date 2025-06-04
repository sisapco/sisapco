package co.com.sisapco.service;

import co.com.sisapco.dto.ChangePasswordForm;
import co.com.sisapco.entity.Actas;
import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.AlmacenamientoGoogle;
import co.com.sisapco.entity.AutorizacionIngreso;
import co.com.sisapco.entity.Cartelera;
import co.com.sisapco.entity.Comunicados;
import co.com.sisapco.entity.ContactoEmergencia;
import co.com.sisapco.entity.Contrato;
import co.com.sisapco.entity.ControlPagos;
import co.com.sisapco.entity.Copropiedad;
import co.com.sisapco.entity.Cotizaciones;
import co.com.sisapco.entity.Dane;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.DatosGenerales;
import co.com.sisapco.entity.EvidenciaActividades;
import co.com.sisapco.entity.Inquilino;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Mascota;
import co.com.sisapco.entity.Modulo;
import co.com.sisapco.entity.Perfil;
import co.com.sisapco.entity.Pqrs;
import co.com.sisapco.entity.Propiedad;
import co.com.sisapco.entity.Propietarios;
import co.com.sisapco.entity.Proyectos;
import co.com.sisapco.entity.Residentes;
import co.com.sisapco.entity.SancionesMulta;
import co.com.sisapco.entity.Terceros;
import co.com.sisapco.entity.Usuarios;
import co.com.sisapco.entity.Vehiculo;

public interface UserService {
	
	public Iterable<Usuarios> getAllUsers();

	public Usuarios createUser(Usuarios user) throws Exception;
	
	public Usuarios geUsuariosById(Long id) throws Exception;
	
	public Perfil getPefilById(int id) throws Exception;
	
	public Usuarios geUsuariosByUsername(String user) throws Exception;
	
	public Iterable<Modulo> getModulosById(int perfilId) throws Exception;
	
	public Iterable<Modulo> getModulosByAll() throws Exception;
	
	public Iterable<Copropiedad> getCopropiedadUsuario(int usuId) throws Exception;
	
	public Copropiedad getCopropiedadById(int id) throws Exception;
	
	public Iterable<Copropiedad> getCopropiedadByNit(int nit) throws Exception;
	
	public Usuarios updateUser(Usuarios user)throws Exception;
	
	public void deleteUser(Long id) throws Exception;
	
	public Usuarios changePassword(ChangePasswordForm form) throws Exception;
	
	public Iterable<Actividades> getActividadesByNit(int codNit) throws Exception;
	
	public Iterable<Actividades> getActividadesById(int actId) throws Exception;
	
	public Actividades getActividadesByIdForm(int actId) throws Exception;
	
	public Actividades createActividad(Actividades actividad) throws Exception;
	
	public EvidenciaActividades createEvidenciaActividad(EvidenciaActividades evidenciaActividades) throws Exception;
	
	public Iterable<EvidenciaActividades> getEvidenciaActividadesByActId(int actId) throws Exception;
	
	public Actas createActa(Actas actas) throws Exception;
	
	public Iterable<Actas> getActasByNit(int codNit) throws Exception;
	
	public Actas getActaByIdForm(int actId) throws Exception;
	
	public Actas getActasByIdConsecutivoForm(int copNit) throws Exception;
	
	public AlmacenamientoGoogle getAlmacenamientoGoogleByIdForm(int codNit, String carpeta) throws Exception;
	
	public Contrato createContrato(Contrato contrato) throws Exception;
	
	public Iterable<Contrato> getContratoByNit(int codNit) throws Exception;
	
	public Cotizaciones createCorizaciones(Cotizaciones cotizaciones) throws Exception;
	
	public Iterable<Cotizaciones> getCotizacionesByNit(int codNit) throws Exception;
	
	public Iterable<Proyectos> getProyectosByNit(int codNit) throws Exception;
	
	public Iterable<Pqrs> getPqrsByNit(int codNit) throws Exception;
	
	public Pqrs createPqrs(Pqrs pqrs) throws Exception;
	
	public Pqrs getPqrsByIdConsecutivoForm(int copNit) throws Exception;
	
	public Propietarios getPropietariosByIdCedula(int proCc) throws Exception;
	
	public Pqrs getPqrsByIdForm(int idPqrs) throws Exception;
	
	public ControlPagos createControlPagos(ControlPagos controlPagos) throws Exception;
	
	public SancionesMulta findBySancionesMultaNitConsecutivoForm(int copNit) throws Exception;
	
	public SancionesMulta createSancionesMulta(SancionesMulta sancionesMulta) throws Exception;
	
	public Iterable<SancionesMulta> getSancionesMultaByNit(int copNit) throws Exception;
	
	public Iterable<Dane> getDaneDepartamentos() throws Exception;
	
	public Iterable<Dane> getMunicipioCodigoDepartamento(String codigoDepartamento) throws Exception;
	
	public EstadosFinancieros createEstadosFinancieros(EstadosFinancieros estadosFinancieros) throws Exception;
	
	public ManualConvivencia createManualConvivencia(ManualConvivencia manualConvivencia) throws Exception;
	
	public Comunicados createComunicados(Comunicados comunicados) throws Exception;
	
	public Iterable<Comunicados> getComunicadosByNit(int codNit) throws Exception;
	
	public Iterable<ManualConvivencia> getManualConvivenciaByNit(int codNit) throws Exception;
	
	public Iterable<EstadosFinancieros> getEstadosFinancierosByNit(int codNit) throws Exception;
	
	public DatosGenerales createDatosGenerales(DatosGenerales datosGenerales) throws Exception;
	
	public Cartelera createCartelera(Cartelera cartelera) throws Exception;
	
	public Iterable<Cartelera> getCarteleraByNit(int codNit) throws Exception;

	public EstadosFinancieros getEstadosFinancierosByIdForm(int estId) throws Exception;
	
	public ManualConvivencia getManualConvivenciaByIdForm(int conviId) throws Exception;
	
	public Comunicados getComunicadosByIdForm(int comuId) throws Exception;

	public Copropiedad createCopropiedad(Copropiedad copropiedad) throws Exception;
	
	public AutorizacionIngreso createAutorizacion(AutorizacionIngreso autorizacionIngreso) throws Exception;
	
	public Propiedad createPropiedad(Propiedad propiedad) throws Exception;
	
	public Inquilino createInquilino(Inquilino inquilino) throws Exception;
	
	public Vehiculo createVehiculo(Vehiculo vehiculo) throws Exception;
	
	public Mascota createMascota(Mascota mascota) throws Exception;
	
	public Usuarios createUsuario(Usuarios user) throws Exception;
	
	public ContactoEmergencia createContactoEmergencia(ContactoEmergencia contactoEmergencia) throws Exception;
	
	public Usuarios validarUsuarioDatosGenerales(String user) throws Exception;
	
	public Residentes createResidentes(Residentes residentes) throws Exception;
	
	public Propietarios createPropietario(Propietarios propietarios) throws Exception;
	
	public Terceros createTerceros(Terceros terceros) throws Exception;
}
