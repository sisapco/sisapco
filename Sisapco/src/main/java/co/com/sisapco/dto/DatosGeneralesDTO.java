package co.com.sisapco.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class DatosGeneralesDTO {
	
	private int copId;
	private int copNit;
	private String datosperTipoResidente;
	private int datosperNumeroDocumento;
	private String proNumeroResidencia;
	private String datosperNombres;
	private String datosperApellidos;
	private String datosperCelular;
	private String datosperTelefono;
	private String datosperEmail;
	private String datosperUser;
	private String datosperPassword;
	private String datosperDireccionCorrespondencia;
	private String datosperEstado;
	private String proResidente;
	private String proEstado;
	
	private String datosperPropietario;
	private String datosperMastoca;
	private String proObservaciones;
	private String proEmergenciaNombres;
	private String proEmergenciaCelular;
	private String proEmergenciaEmail;
	
	private String proVehciuloEstado;
	private String proResidenteEstado;
	private String proEmergenciaNumeroDocumento;
	private String proNumeroMatricula;
	private String proEmergenciaApellidos;
	private String proAutoriza;
	private String proMastoca;
	private String proVehiculo;
	private String proEmergenciaEstado;
	
	private String proClaseVehciulo;
	private String proPlaca;
	private String proMarcaVehiculo;
	private String proColorVehiculo;
	private String proVehiculoObservacion;
	
	private String proNombreMascota;
	private String proRaza;
	private String proEdad;
	private String proMascotaObservacion;
	private String proMascotaEstado;
	
	private String proResidenteNumeroDocumento;
	private String proResidenteNombres;
	private String proResidenteApellidos;
	private String proResidenteNumeroTelefono;
	private String proResidenteParentesco;
		
	private String proAutorizaNumeroDocumento;
	private String proAutorizaNombres;
	private String proAutorizaApellidos;
	private String proAutorizaNumeroTelefono;
	private String proAutorizaParentesco;
	private String proAutoriFechaIngreso;
	private String proAutoriFechaSalida;
	private String proAutoriPlacaVehiculo;
	private String proAutorizaEstado;
	
	private String inquilinoObservaciones;
	private String inquilinoNumeroDocumento;
	private String inquiloNumeroResidencia;
	private String inquilinoNombres;
	private String inquilinoUsser;
	private String inquilinoPass;
	private String inquilinoApellidos;
	private String inquilinoDireccionCorrespondencia;
	private String inquilinoEstado;
	private String inquilinoAutorizaEstado;
	private String inquilinoCelular;
	private String inquilinoTelefono;
	private String inquilinoEmail;
	private String inquiloEstado;
	
	private String inquilinoResidenteNombres;
	private String inquilinoResidenteApellidos;
	private String inquilinoResidenteNumeroDocumento;
	private String inquilinoResidenteNumeroTelefono;
	private String inquilinoResidenteParentesco;
	private String inquilinoResidenteEstado;
	
	private String inquilinoAutoriza;
	private String inquilinoAutorizaNumeroDocumento;
	private String inquilinoAutorizaNombres;
	private String inquilinoAutorizaApellidos;
	private String inquilinoAutorizaNumeroTelefono;
	private String inquilinoAutorizaParentesco;
	
	private String inquilinoMastoca;
	private String inquilinoNombreMascota;
	private String inquilinoRaza;
	private String inquilinoEdad;
	private String inquilinoMascotaObservacion;
	private String inquilinoMascotaEstado;
	
	private String inquilinoVehiculo;
	private String inquilinoClaseVehiculo;
	private String inquilinoPlaca;
	private String inquilinoMarcaVehiculo;
	private String inquilinoColorVehiculo;
	private String inquilinoVehiculoObservacion;
	private String inquilinoVehiculoEstado;
	
	private String inquilinoEmergenciaNumeroDocumento;
	private String inquilinoEmergenciaNombres;
	private String inquilinoEmergenciaApellidos;
	private String inquilinoEmergenciaCelular;
	private String inquilinoEmergenciaEmail;
	private String inquilinoEmergenciaEstado;
	
	private String InquilinoAutoriFechaIngreso;
	private String InquilinoAutoriFechaSalida;
	private String InquilinoAutoriPlacaVehiculo;
		
	private String administradorNumeroDocumento;
	private String administradorObservaciones;
	private String administradorNombres;
	private String administradorUsser;
	private String administradorPass;
	private String administradorApellidos;
	private String administradorDireccionCorrespondencia;
	private String administradorCelular;
	private String administradorTelefono;
	private String administradorEmail;
	private String administradorEstado;
	
	private String guardaNombres;
	private String guardaUsser;
	private String guardaPass;
	private String guardaApellidos;
	private String guardaDireccionCorrespondencia;
	private String guardaNumeroDocumento;
	private String guardaCelular;
	private String guardaObservaciones;
	private String guardaTelefono;
	private String guardaEmail;
	private String guardaEstado;
	
	private String contadorUsser;
	private String contadorPass;
	private String contadorApellidos;
	private String contadorDireccionCorrespondencia;
	private String contadorNombres;
	private String contadorNumeroDocumento;
	private String contadorCelular;
	private String contadorTelefono;
	private String contadorEmail;
	private String contadorObservaciones;
	private String contadorEstado;
	
	private String revisorNombres;
	private String revisorUsser;
	private String revisorPass;
	private String revisorApellidos;
	private String revisorDireccionCorrespondencia;
	private String revisorNumeroDocumento;
	private String revisorCelular;
	private String revisorTelefono;
	private String revisorEmail;
	private String revisorObservaciones;
	private String revisorEstado;
	public int getCopId() {
		return copId;
	}
	public void setCopId(int copId) {
		this.copId = copId;
	}
	public int getCopNit() {
		return copNit;
	}
	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}
	public String getDatosperTipoResidente() {
		return datosperTipoResidente;
	}
	public void setDatosperTipoResidente(String datosperTipoResidente) {
		this.datosperTipoResidente = datosperTipoResidente;
	}
	public int getDatosperNumeroDocumento() {
		return datosperNumeroDocumento;
	}
	public void setDatosperNumeroDocumento(int datosperNumeroDocumento) {
		this.datosperNumeroDocumento = datosperNumeroDocumento;
	}
	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}
	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}
	public String getDatosperNombres() {
		return datosperNombres;
	}
	public void setDatosperNombres(String datosperNombres) {
		this.datosperNombres = datosperNombres;
	}
	public String getDatosperApellidos() {
		return datosperApellidos;
	}
	public void setDatosperApellidos(String datosperApellidos) {
		this.datosperApellidos = datosperApellidos;
	}
	public String getDatosperCelular() {
		return datosperCelular;
	}
	public void setDatosperCelular(String datosperCelular) {
		this.datosperCelular = datosperCelular;
	}
	public String getDatosperTelefono() {
		return datosperTelefono;
	}
	public void setDatosperTelefono(String datosperTelefono) {
		this.datosperTelefono = datosperTelefono;
	}
	public String getDatosperEmail() {
		return datosperEmail;
	}
	public void setDatosperEmail(String datosperEmail) {
		this.datosperEmail = datosperEmail;
	}
	public String getDatosperUser() {
		return datosperUser;
	}
	public void setDatosperUser(String datosperUser) {
		this.datosperUser = datosperUser;
	}
	public String getDatosperPassword() {
		return datosperPassword;
	}
	public void setDatosperPassword(String datosperPassword) {
		this.datosperPassword = datosperPassword;
	}
	public String getDatosperDireccionCorrespondencia() {
		return datosperDireccionCorrespondencia;
	}
	public void setDatosperDireccionCorrespondencia(String datosperDireccionCorrespondencia) {
		this.datosperDireccionCorrespondencia = datosperDireccionCorrespondencia;
	}
	public String getDatosperEstado() {
		return datosperEstado;
	}
	public void setDatosperEstado(String datosperEstado) {
		this.datosperEstado = datosperEstado;
	}
	public String getProResidente() {
		return proResidente;
	}
	public void setProResidente(String proResidente) {
		this.proResidente = proResidente;
	}
	public String getProEstado() {
		return proEstado;
	}
	public void setProEstado(String proEstado) {
		this.proEstado = proEstado;
	}
	public String getDatosperPropietario() {
		return datosperPropietario;
	}
	public void setDatosperPropietario(String datosperPropietario) {
		this.datosperPropietario = datosperPropietario;
	}
	public String getDatosperMastoca() {
		return datosperMastoca;
	}
	public void setDatosperMastoca(String datosperMastoca) {
		this.datosperMastoca = datosperMastoca;
	}
	public String getProObservaciones() {
		return proObservaciones;
	}
	public void setProObservaciones(String proObservaciones) {
		this.proObservaciones = proObservaciones;
	}
	public String getProEmergenciaNombres() {
		return proEmergenciaNombres;
	}
	public void setProEmergenciaNombres(String proEmergenciaNombres) {
		this.proEmergenciaNombres = proEmergenciaNombres;
	}
	public String getProEmergenciaCelular() {
		return proEmergenciaCelular;
	}
	public void setProEmergenciaCelular(String proEmergenciaCelular) {
		this.proEmergenciaCelular = proEmergenciaCelular;
	}
	public String getProEmergenciaEmail() {
		return proEmergenciaEmail;
	}
	public void setProEmergenciaEmail(String proEmergenciaEmail) {
		this.proEmergenciaEmail = proEmergenciaEmail;
	}
	public String getProVehciuloEstado() {
		return proVehciuloEstado;
	}
	public void setProVehciuloEstado(String proVehciuloEstado) {
		this.proVehciuloEstado = proVehciuloEstado;
	}
	public String getProResidenteEstado() {
		return proResidenteEstado;
	}
	public void setProResidenteEstado(String proResidenteEstado) {
		this.proResidenteEstado = proResidenteEstado;
	}
	public String getProEmergenciaNumeroDocumento() {
		return proEmergenciaNumeroDocumento;
	}
	public void setProEmergenciaNumeroDocumento(String proEmergenciaNumeroDocumento) {
		this.proEmergenciaNumeroDocumento = proEmergenciaNumeroDocumento;
	}
	public String getProNumeroMatricula() {
		return proNumeroMatricula;
	}
	public void setProNumeroMatricula(String proNumeroMatricula) {
		this.proNumeroMatricula = proNumeroMatricula;
	}
	public String getProEmergenciaApellidos() {
		return proEmergenciaApellidos;
	}
	public void setProEmergenciaApellidos(String proEmergenciaApellidos) {
		this.proEmergenciaApellidos = proEmergenciaApellidos;
	}
	public String getProAutoriza() {
		return proAutoriza;
	}
	public void setProAutoriza(String proAutoriza) {
		this.proAutoriza = proAutoriza;
	}
	public String getProMastoca() {
		return proMastoca;
	}
	public void setProMastoca(String proMastoca) {
		this.proMastoca = proMastoca;
	}
	public String getProVehiculo() {
		return proVehiculo;
	}
	public void setProVehiculo(String proVehiculo) {
		this.proVehiculo = proVehiculo;
	}
	public String getProEmergenciaEstado() {
		return proEmergenciaEstado;
	}
	public void setProEmergenciaEstado(String proEmergenciaEstado) {
		this.proEmergenciaEstado = proEmergenciaEstado;
	}
	public String getProClaseVehciulo() {
		return proClaseVehciulo;
	}
	public void setProClaseVehciulo(String proClaseVehciulo) {
		this.proClaseVehciulo = proClaseVehciulo;
	}
	public String getProPlaca() {
		return proPlaca;
	}
	public void setProPlaca(String proPlaca) {
		this.proPlaca = proPlaca;
	}
	public String getProMarcaVehiculo() {
		return proMarcaVehiculo;
	}
	public void setProMarcaVehiculo(String proMarcaVehiculo) {
		this.proMarcaVehiculo = proMarcaVehiculo;
	}
	public String getProColorVehiculo() {
		return proColorVehiculo;
	}
	public void setProColorVehiculo(String proColorVehiculo) {
		this.proColorVehiculo = proColorVehiculo;
	}
	public String getProVehiculoObservacion() {
		return proVehiculoObservacion;
	}
	public void setProVehiculoObservacion(String proVehiculoObservacion) {
		this.proVehiculoObservacion = proVehiculoObservacion;
	}
	public String getProNombreMascota() {
		return proNombreMascota;
	}
	public void setProNombreMascota(String proNombreMascota) {
		this.proNombreMascota = proNombreMascota;
	}
	public String getProRaza() {
		return proRaza;
	}
	public void setProRaza(String proRaza) {
		this.proRaza = proRaza;
	}
	public String getProEdad() {
		return proEdad;
	}
	public void setProEdad(String proEdad) {
		this.proEdad = proEdad;
	}
	public String getProMascotaObservacion() {
		return proMascotaObservacion;
	}
	public void setProMascotaObservacion(String proMascotaObservacion) {
		this.proMascotaObservacion = proMascotaObservacion;
	}
	public String getProMascotaEstado() {
		return proMascotaEstado;
	}
	public void setProMascotaEstado(String proMascotaEstado) {
		this.proMascotaEstado = proMascotaEstado;
	}
	public String getProResidenteNumeroDocumento() {
		return proResidenteNumeroDocumento;
	}
	public void setProResidenteNumeroDocumento(String proResidenteNumeroDocumento) {
		this.proResidenteNumeroDocumento = proResidenteNumeroDocumento;
	}
	public String getProResidenteNombres() {
		return proResidenteNombres;
	}
	public void setProResidenteNombres(String proResidenteNombres) {
		this.proResidenteNombres = proResidenteNombres;
	}
	public String getProResidenteApellidos() {
		return proResidenteApellidos;
	}
	public void setProResidenteApellidos(String proResidenteApellidos) {
		this.proResidenteApellidos = proResidenteApellidos;
	}
	public String getProResidenteNumeroTelefono() {
		return proResidenteNumeroTelefono;
	}
	public void setProResidenteNumeroTelefono(String proResidenteNumeroTelefono) {
		this.proResidenteNumeroTelefono = proResidenteNumeroTelefono;
	}
	public String getProResidenteParentesco() {
		return proResidenteParentesco;
	}
	public void setProResidenteParentesco(String proResidenteParentesco) {
		this.proResidenteParentesco = proResidenteParentesco;
	}
	public String getProAutorizaNumeroDocumento() {
		return proAutorizaNumeroDocumento;
	}
	public void setProAutorizaNumeroDocumento(String proAutorizaNumeroDocumento) {
		this.proAutorizaNumeroDocumento = proAutorizaNumeroDocumento;
	}
	public String getProAutorizaNombres() {
		return proAutorizaNombres;
	}
	public void setProAutorizaNombres(String proAutorizaNombres) {
		this.proAutorizaNombres = proAutorizaNombres;
	}
	public String getProAutorizaApellidos() {
		return proAutorizaApellidos;
	}
	public void setProAutorizaApellidos(String proAutorizaApellidos) {
		this.proAutorizaApellidos = proAutorizaApellidos;
	}
	public String getProAutorizaNumeroTelefono() {
		return proAutorizaNumeroTelefono;
	}
	public void setProAutorizaNumeroTelefono(String proAutorizaNumeroTelefono) {
		this.proAutorizaNumeroTelefono = proAutorizaNumeroTelefono;
	}
	public String getProAutorizaParentesco() {
		return proAutorizaParentesco;
	}
	public void setProAutorizaParentesco(String proAutorizaParentesco) {
		this.proAutorizaParentesco = proAutorizaParentesco;
	}
	public String getProAutoriFechaIngreso() {
		return proAutoriFechaIngreso;
	}
	public void setProAutoriFechaIngreso(String proAutoriFechaIngreso) {
		this.proAutoriFechaIngreso = proAutoriFechaIngreso;
	}
	public String getProAutoriFechaSalida() {
		return proAutoriFechaSalida;
	}
	public void setProAutoriFechaSalida(String proAutoriFechaSalida) {
		this.proAutoriFechaSalida = proAutoriFechaSalida;
	}
	public String getProAutoriPlacaVehiculo() {
		return proAutoriPlacaVehiculo;
	}
	public void setProAutoriPlacaVehiculo(String proAutoriPlacaVehiculo) {
		this.proAutoriPlacaVehiculo = proAutoriPlacaVehiculo;
	}
	public String getProAutorizaEstado() {
		return proAutorizaEstado;
	}
	public void setProAutorizaEstado(String proAutorizaEstado) {
		this.proAutorizaEstado = proAutorizaEstado;
	}
	public String getInquilinoObservaciones() {
		return inquilinoObservaciones;
	}
	public void setInquilinoObservaciones(String inquilinoObservaciones) {
		this.inquilinoObservaciones = inquilinoObservaciones;
	}
	public String getInquilinoNumeroDocumento() {
		return inquilinoNumeroDocumento;
	}
	public void setInquilinoNumeroDocumento(String inquilinoNumeroDocumento) {
		this.inquilinoNumeroDocumento = inquilinoNumeroDocumento;
	}
	public String getInquiloNumeroResidencia() {
		return inquiloNumeroResidencia;
	}
	public void setInquiloNumeroResidencia(String inquiloNumeroResidencia) {
		this.inquiloNumeroResidencia = inquiloNumeroResidencia;
	}
	public String getInquilinoNombres() {
		return inquilinoNombres;
	}
	public void setInquilinoNombres(String inquilinoNombres) {
		this.inquilinoNombres = inquilinoNombres;
	}
	public String getInquilinoUsser() {
		return inquilinoUsser;
	}
	public void setInquilinoUsser(String inquilinoUsser) {
		this.inquilinoUsser = inquilinoUsser;
	}
	public String getInquilinoPass() {
		return inquilinoPass;
	}
	public void setInquilinoPass(String inquilinoPass) {
		this.inquilinoPass = inquilinoPass;
	}
	public String getInquilinoApellidos() {
		return inquilinoApellidos;
	}
	public void setInquilinoApellidos(String inquilinoApellidos) {
		this.inquilinoApellidos = inquilinoApellidos;
	}
	public String getInquilinoDireccionCorrespondencia() {
		return inquilinoDireccionCorrespondencia;
	}
	public void setInquilinoDireccionCorrespondencia(String inquilinoDireccionCorrespondencia) {
		this.inquilinoDireccionCorrespondencia = inquilinoDireccionCorrespondencia;
	}
	public String getInquilinoEstado() {
		return inquilinoEstado;
	}
	public void setInquilinoEstado(String inquilinoEstado) {
		this.inquilinoEstado = inquilinoEstado;
	}
	public String getInquilinoAutorizaEstado() {
		return inquilinoAutorizaEstado;
	}
	public void setInquilinoAutorizaEstado(String inquilinoAutorizaEstado) {
		this.inquilinoAutorizaEstado = inquilinoAutorizaEstado;
	}
	public String getInquilinoCelular() {
		return inquilinoCelular;
	}
	public void setInquilinoCelular(String inquilinoCelular) {
		this.inquilinoCelular = inquilinoCelular;
	}
	public String getInquilinoTelefono() {
		return inquilinoTelefono;
	}
	public void setInquilinoTelefono(String inquilinoTelefono) {
		this.inquilinoTelefono = inquilinoTelefono;
	}
	public String getInquilinoEmail() {
		return inquilinoEmail;
	}
	public void setInquilinoEmail(String inquilinoEmail) {
		this.inquilinoEmail = inquilinoEmail;
	}
	public String getInquiloEstado() {
		return inquiloEstado;
	}
	public void setInquiloEstado(String inquiloEstado) {
		this.inquiloEstado = inquiloEstado;
	}
	public String getInquilinoResidenteNombres() {
		return inquilinoResidenteNombres;
	}
	public void setInquilinoResidenteNombres(String inquilinoResidenteNombres) {
		this.inquilinoResidenteNombres = inquilinoResidenteNombres;
	}
	public String getInquilinoResidenteApellidos() {
		return inquilinoResidenteApellidos;
	}
	public void setInquilinoResidenteApellidos(String inquilinoResidenteApellidos) {
		this.inquilinoResidenteApellidos = inquilinoResidenteApellidos;
	}
	public String getInquilinoResidenteNumeroDocumento() {
		return inquilinoResidenteNumeroDocumento;
	}
	public void setInquilinoResidenteNumeroDocumento(String inquilinoResidenteNumeroDocumento) {
		this.inquilinoResidenteNumeroDocumento = inquilinoResidenteNumeroDocumento;
	}
	public String getInquilinoResidenteNumeroTelefono() {
		return inquilinoResidenteNumeroTelefono;
	}
	public void setInquilinoResidenteNumeroTelefono(String inquilinoResidenteNumeroTelefono) {
		this.inquilinoResidenteNumeroTelefono = inquilinoResidenteNumeroTelefono;
	}
	public String getInquilinoResidenteParentesco() {
		return inquilinoResidenteParentesco;
	}
	public void setInquilinoResidenteParentesco(String inquilinoResidenteParentesco) {
		this.inquilinoResidenteParentesco = inquilinoResidenteParentesco;
	}
	public String getInquilinoResidenteEstado() {
		return inquilinoResidenteEstado;
	}
	public void setInquilinoResidenteEstado(String inquilinoResidenteEstado) {
		this.inquilinoResidenteEstado = inquilinoResidenteEstado;
	}
	public String getInquilinoAutoriza() {
		return inquilinoAutoriza;
	}
	public void setInquilinoAutoriza(String inquilinoAutoriza) {
		this.inquilinoAutoriza = inquilinoAutoriza;
	}
	public String getInquilinoAutorizaNumeroDocumento() {
		return inquilinoAutorizaNumeroDocumento;
	}
	public void setInquilinoAutorizaNumeroDocumento(String inquilinoAutorizaNumeroDocumento) {
		this.inquilinoAutorizaNumeroDocumento = inquilinoAutorizaNumeroDocumento;
	}
	public String getInquilinoAutorizaNombres() {
		return inquilinoAutorizaNombres;
	}
	public void setInquilinoAutorizaNombres(String inquilinoAutorizaNombres) {
		this.inquilinoAutorizaNombres = inquilinoAutorizaNombres;
	}
	public String getInquilinoAutorizaApellidos() {
		return inquilinoAutorizaApellidos;
	}
	public void setInquilinoAutorizaApellidos(String inquilinoAutorizaApellidos) {
		this.inquilinoAutorizaApellidos = inquilinoAutorizaApellidos;
	}
	public String getInquilinoAutorizaNumeroTelefono() {
		return inquilinoAutorizaNumeroTelefono;
	}
	public void setInquilinoAutorizaNumeroTelefono(String inquilinoAutorizaNumeroTelefono) {
		this.inquilinoAutorizaNumeroTelefono = inquilinoAutorizaNumeroTelefono;
	}
	public String getInquilinoAutorizaParentesco() {
		return inquilinoAutorizaParentesco;
	}
	public void setInquilinoAutorizaParentesco(String inquilinoAutorizaParentesco) {
		this.inquilinoAutorizaParentesco = inquilinoAutorizaParentesco;
	}
	public String getInquilinoMastoca() {
		return inquilinoMastoca;
	}
	public void setInquilinoMastoca(String inquilinoMastoca) {
		this.inquilinoMastoca = inquilinoMastoca;
	}
	public String getInquilinoNombreMascota() {
		return inquilinoNombreMascota;
	}
	public void setInquilinoNombreMascota(String inquilinoNombreMascota) {
		this.inquilinoNombreMascota = inquilinoNombreMascota;
	}
	public String getInquilinoRaza() {
		return inquilinoRaza;
	}
	public void setInquilinoRaza(String inquilinoRaza) {
		this.inquilinoRaza = inquilinoRaza;
	}
	public String getInquilinoEdad() {
		return inquilinoEdad;
	}
	public void setInquilinoEdad(String inquilinoEdad) {
		this.inquilinoEdad = inquilinoEdad;
	}
	public String getInquilinoMascotaObservacion() {
		return inquilinoMascotaObservacion;
	}
	public void setInquilinoMascotaObservacion(String inquilinoMascotaObservacion) {
		this.inquilinoMascotaObservacion = inquilinoMascotaObservacion;
	}
	public String getInquilinoMascotaEstado() {
		return inquilinoMascotaEstado;
	}
	public void setInquilinoMascotaEstado(String inquilinoMascotaEstado) {
		this.inquilinoMascotaEstado = inquilinoMascotaEstado;
	}
	public String getInquilinoVehiculo() {
		return inquilinoVehiculo;
	}
	public void setInquilinoVehiculo(String inquilinoVehiculo) {
		this.inquilinoVehiculo = inquilinoVehiculo;
	}
	public String getInquilinoClaseVehiculo() {
		return inquilinoClaseVehiculo;
	}
	public void setInquilinoClaseVehiculo(String inquilinoClaseVehiculo) {
		this.inquilinoClaseVehiculo = inquilinoClaseVehiculo;
	}
	public String getInquilinoPlaca() {
		return inquilinoPlaca;
	}
	public void setInquilinoPlaca(String inquilinoPlaca) {
		this.inquilinoPlaca = inquilinoPlaca;
	}
	public String getInquilinoMarcaVehiculo() {
		return inquilinoMarcaVehiculo;
	}
	public void setInquilinoMarcaVehiculo(String inquilinoMarcaVehiculo) {
		this.inquilinoMarcaVehiculo = inquilinoMarcaVehiculo;
	}
	public String getInquilinoColorVehiculo() {
		return inquilinoColorVehiculo;
	}
	public void setInquilinoColorVehiculo(String inquilinoColorVehiculo) {
		this.inquilinoColorVehiculo = inquilinoColorVehiculo;
	}
	public String getInquilinoVehiculoObservacion() {
		return inquilinoVehiculoObservacion;
	}
	public void setInquilinoVehiculoObservacion(String inquilinoVehiculoObservacion) {
		this.inquilinoVehiculoObservacion = inquilinoVehiculoObservacion;
	}
	public String getInquilinoVehiculoEstado() {
		return inquilinoVehiculoEstado;
	}
	public void setInquilinoVehiculoEstado(String inquilinoVehiculoEstado) {
		this.inquilinoVehiculoEstado = inquilinoVehiculoEstado;
	}
	public String getInquilinoEmergenciaNumeroDocumento() {
		return inquilinoEmergenciaNumeroDocumento;
	}
	public void setInquilinoEmergenciaNumeroDocumento(String inquilinoEmergenciaNumeroDocumento) {
		this.inquilinoEmergenciaNumeroDocumento = inquilinoEmergenciaNumeroDocumento;
	}
	public String getInquilinoEmergenciaNombres() {
		return inquilinoEmergenciaNombres;
	}
	public void setInquilinoEmergenciaNombres(String inquilinoEmergenciaNombres) {
		this.inquilinoEmergenciaNombres = inquilinoEmergenciaNombres;
	}
	public String getInquilinoEmergenciaApellidos() {
		return inquilinoEmergenciaApellidos;
	}
	public void setInquilinoEmergenciaApellidos(String inquilinoEmergenciaApellidos) {
		this.inquilinoEmergenciaApellidos = inquilinoEmergenciaApellidos;
	}
	public String getInquilinoEmergenciaCelular() {
		return inquilinoEmergenciaCelular;
	}
	public void setInquilinoEmergenciaCelular(String inquilinoEmergenciaCelular) {
		this.inquilinoEmergenciaCelular = inquilinoEmergenciaCelular;
	}
	public String getInquilinoEmergenciaEmail() {
		return inquilinoEmergenciaEmail;
	}
	public void setInquilinoEmergenciaEmail(String inquilinoEmergenciaEmail) {
		this.inquilinoEmergenciaEmail = inquilinoEmergenciaEmail;
	}
	public String getInquilinoEmergenciaEstado() {
		return inquilinoEmergenciaEstado;
	}
	public void setInquilinoEmergenciaEstado(String inquilinoEmergenciaEstado) {
		this.inquilinoEmergenciaEstado = inquilinoEmergenciaEstado;
	}
	public String getInquilinoAutoriFechaIngreso() {
		return InquilinoAutoriFechaIngreso;
	}
	public void setInquilinoAutoriFechaIngreso(String inquilinoAutoriFechaIngreso) {
		InquilinoAutoriFechaIngreso = inquilinoAutoriFechaIngreso;
	}
	public String getInquilinoAutoriFechaSalida() {
		return InquilinoAutoriFechaSalida;
	}
	public void setInquilinoAutoriFechaSalida(String inquilinoAutoriFechaSalida) {
		InquilinoAutoriFechaSalida = inquilinoAutoriFechaSalida;
	}
	public String getInquilinoAutoriPlacaVehiculo() {
		return InquilinoAutoriPlacaVehiculo;
	}
	public void setInquilinoAutoriPlacaVehiculo(String inquilinoAutoriPlacaVehiculo) {
		InquilinoAutoriPlacaVehiculo = inquilinoAutoriPlacaVehiculo;
	}
	public String getAdministradorNumeroDocumento() {
		return administradorNumeroDocumento;
	}
	public void setAdministradorNumeroDocumento(String administradorNumeroDocumento) {
		this.administradorNumeroDocumento = administradorNumeroDocumento;
	}
	public String getAdministradorObservaciones() {
		return administradorObservaciones;
	}
	public void setAdministradorObservaciones(String administradorObservaciones) {
		this.administradorObservaciones = administradorObservaciones;
	}
	public String getAdministradorNombres() {
		return administradorNombres;
	}
	public void setAdministradorNombres(String administradorNombres) {
		this.administradorNombres = administradorNombres;
	}
	public String getAdministradorUsser() {
		return administradorUsser;
	}
	public void setAdministradorUsser(String administradorUsser) {
		this.administradorUsser = administradorUsser;
	}
	public String getAdministradorPass() {
		return administradorPass;
	}
	public void setAdministradorPass(String administradorPass) {
		this.administradorPass = administradorPass;
	}
	public String getAdministradorApellidos() {
		return administradorApellidos;
	}
	public void setAdministradorApellidos(String administradorApellidos) {
		this.administradorApellidos = administradorApellidos;
	}
	public String getAdministradorDireccionCorrespondencia() {
		return administradorDireccionCorrespondencia;
	}
	public void setAdministradorDireccionCorrespondencia(String administradorDireccionCorrespondencia) {
		this.administradorDireccionCorrespondencia = administradorDireccionCorrespondencia;
	}
	public String getAdministradorCelular() {
		return administradorCelular;
	}
	public void setAdministradorCelular(String administradorCelular) {
		this.administradorCelular = administradorCelular;
	}
	public String getAdministradorTelefono() {
		return administradorTelefono;
	}
	public void setAdministradorTelefono(String administradorTelefono) {
		this.administradorTelefono = administradorTelefono;
	}
	public String getAdministradorEmail() {
		return administradorEmail;
	}
	public void setAdministradorEmail(String administradorEmail) {
		this.administradorEmail = administradorEmail;
	}
	public String getAdministradorEstado() {
		return administradorEstado;
	}
	public void setAdministradorEstado(String administradorEstado) {
		this.administradorEstado = administradorEstado;
	}
	public String getGuardaNombres() {
		return guardaNombres;
	}
	public void setGuardaNombres(String guardaNombres) {
		this.guardaNombres = guardaNombres;
	}
	public String getGuardaUsser() {
		return guardaUsser;
	}
	public void setGuardaUsser(String guardaUsser) {
		this.guardaUsser = guardaUsser;
	}
	public String getGuardaPass() {
		return guardaPass;
	}
	public void setGuardaPass(String guardaPass) {
		this.guardaPass = guardaPass;
	}
	public String getGuardaApellidos() {
		return guardaApellidos;
	}
	public void setGuardaApellidos(String guardaApellidos) {
		this.guardaApellidos = guardaApellidos;
	}
	public String getGuardaDireccionCorrespondencia() {
		return guardaDireccionCorrespondencia;
	}
	public void setGuardaDireccionCorrespondencia(String guardaDireccionCorrespondencia) {
		this.guardaDireccionCorrespondencia = guardaDireccionCorrespondencia;
	}
	public String getGuardaNumeroDocumento() {
		return guardaNumeroDocumento;
	}
	public void setGuardaNumeroDocumento(String guardaNumeroDocumento) {
		this.guardaNumeroDocumento = guardaNumeroDocumento;
	}
	public String getGuardaCelular() {
		return guardaCelular;
	}
	public void setGuardaCelular(String guardaCelular) {
		this.guardaCelular = guardaCelular;
	}
	public String getGuardaObservaciones() {
		return guardaObservaciones;
	}
	public void setGuardaObservaciones(String guardaObservaciones) {
		this.guardaObservaciones = guardaObservaciones;
	}
	public String getGuardaTelefono() {
		return guardaTelefono;
	}
	public void setGuardaTelefono(String guardaTelefono) {
		this.guardaTelefono = guardaTelefono;
	}
	public String getGuardaEmail() {
		return guardaEmail;
	}
	public void setGuardaEmail(String guardaEmail) {
		this.guardaEmail = guardaEmail;
	}
	public String getGuardaEstado() {
		return guardaEstado;
	}
	public void setGuardaEstado(String guardaEstado) {
		this.guardaEstado = guardaEstado;
	}
	public String getContadorUsser() {
		return contadorUsser;
	}
	public void setContadorUsser(String contadorUsser) {
		this.contadorUsser = contadorUsser;
	}
	public String getContadorPass() {
		return contadorPass;
	}
	public void setContadorPass(String contadorPass) {
		this.contadorPass = contadorPass;
	}
	public String getContadorApellidos() {
		return contadorApellidos;
	}
	public void setContadorApellidos(String contadorApellidos) {
		this.contadorApellidos = contadorApellidos;
	}
	public String getContadorDireccionCorrespondencia() {
		return contadorDireccionCorrespondencia;
	}
	public void setContadorDireccionCorrespondencia(String contadorDireccionCorrespondencia) {
		this.contadorDireccionCorrespondencia = contadorDireccionCorrespondencia;
	}
	public String getContadorNombres() {
		return contadorNombres;
	}
	public void setContadorNombres(String contadorNombres) {
		this.contadorNombres = contadorNombres;
	}
	public String getContadorNumeroDocumento() {
		return contadorNumeroDocumento;
	}
	public void setContadorNumeroDocumento(String contadorNumeroDocumento) {
		this.contadorNumeroDocumento = contadorNumeroDocumento;
	}
	public String getContadorCelular() {
		return contadorCelular;
	}
	public void setContadorCelular(String contadorCelular) {
		this.contadorCelular = contadorCelular;
	}
	public String getContadorTelefono() {
		return contadorTelefono;
	}
	public void setContadorTelefono(String contadorTelefono) {
		this.contadorTelefono = contadorTelefono;
	}
	public String getContadorEmail() {
		return contadorEmail;
	}
	public void setContadorEmail(String contadorEmail) {
		this.contadorEmail = contadorEmail;
	}
	public String getContadorObservaciones() {
		return contadorObservaciones;
	}
	public void setContadorObservaciones(String contadorObservaciones) {
		this.contadorObservaciones = contadorObservaciones;
	}
	public String getContadorEstado() {
		return contadorEstado;
	}
	public void setContadorEstado(String contadorEstado) {
		this.contadorEstado = contadorEstado;
	}
	public String getRevisorNombres() {
		return revisorNombres;
	}
	public void setRevisorNombres(String revisorNombres) {
		this.revisorNombres = revisorNombres;
	}
	public String getRevisorUsser() {
		return revisorUsser;
	}
	public void setRevisorUsser(String revisorUsser) {
		this.revisorUsser = revisorUsser;
	}
	public String getRevisorPass() {
		return revisorPass;
	}
	public void setRevisorPass(String revisorPass) {
		this.revisorPass = revisorPass;
	}
	public String getRevisorApellidos() {
		return revisorApellidos;
	}
	public void setRevisorApellidos(String revisorApellidos) {
		this.revisorApellidos = revisorApellidos;
	}
	public String getRevisorDireccionCorrespondencia() {
		return revisorDireccionCorrespondencia;
	}
	public void setRevisorDireccionCorrespondencia(String revisorDireccionCorrespondencia) {
		this.revisorDireccionCorrespondencia = revisorDireccionCorrespondencia;
	}
	public String getRevisorNumeroDocumento() {
		return revisorNumeroDocumento;
	}
	public void setRevisorNumeroDocumento(String revisorNumeroDocumento) {
		this.revisorNumeroDocumento = revisorNumeroDocumento;
	}
	public String getRevisorCelular() {
		return revisorCelular;
	}
	public void setRevisorCelular(String revisorCelular) {
		this.revisorCelular = revisorCelular;
	}
	public String getRevisorTelefono() {
		return revisorTelefono;
	}
	public void setRevisorTelefono(String revisorTelefono) {
		this.revisorTelefono = revisorTelefono;
	}
	public String getRevisorEmail() {
		return revisorEmail;
	}
	public void setRevisorEmail(String revisorEmail) {
		this.revisorEmail = revisorEmail;
	}
	public String getRevisorObservaciones() {
		return revisorObservaciones;
	}
	public void setRevisorObservaciones(String revisorObservaciones) {
		this.revisorObservaciones = revisorObservaciones;
	}
	public String getRevisorEstado() {
		return revisorEstado;
	}
	public void setRevisorEstado(String revisorEstado) {
		this.revisorEstado = revisorEstado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((InquilinoAutoriFechaIngreso == null) ? 0 : InquilinoAutoriFechaIngreso.hashCode());
		result = prime * result + ((InquilinoAutoriFechaSalida == null) ? 0 : InquilinoAutoriFechaSalida.hashCode());
		result = prime * result
				+ ((InquilinoAutoriPlacaVehiculo == null) ? 0 : InquilinoAutoriPlacaVehiculo.hashCode());
		result = prime * result + ((administradorApellidos == null) ? 0 : administradorApellidos.hashCode());
		result = prime * result + ((administradorCelular == null) ? 0 : administradorCelular.hashCode());
		result = prime * result + ((administradorDireccionCorrespondencia == null) ? 0
				: administradorDireccionCorrespondencia.hashCode());
		result = prime * result + ((administradorEmail == null) ? 0 : administradorEmail.hashCode());
		result = prime * result + ((administradorEstado == null) ? 0 : administradorEstado.hashCode());
		result = prime * result + ((administradorNombres == null) ? 0 : administradorNombres.hashCode());
		result = prime * result
				+ ((administradorNumeroDocumento == null) ? 0 : administradorNumeroDocumento.hashCode());
		result = prime * result + ((administradorObservaciones == null) ? 0 : administradorObservaciones.hashCode());
		result = prime * result + ((administradorPass == null) ? 0 : administradorPass.hashCode());
		result = prime * result + ((administradorTelefono == null) ? 0 : administradorTelefono.hashCode());
		result = prime * result + ((administradorUsser == null) ? 0 : administradorUsser.hashCode());
		result = prime * result + ((contadorApellidos == null) ? 0 : contadorApellidos.hashCode());
		result = prime * result + ((contadorCelular == null) ? 0 : contadorCelular.hashCode());
		result = prime * result
				+ ((contadorDireccionCorrespondencia == null) ? 0 : contadorDireccionCorrespondencia.hashCode());
		result = prime * result + ((contadorEmail == null) ? 0 : contadorEmail.hashCode());
		result = prime * result + ((contadorEstado == null) ? 0 : contadorEstado.hashCode());
		result = prime * result + ((contadorNombres == null) ? 0 : contadorNombres.hashCode());
		result = prime * result + ((contadorNumeroDocumento == null) ? 0 : contadorNumeroDocumento.hashCode());
		result = prime * result + ((contadorObservaciones == null) ? 0 : contadorObservaciones.hashCode());
		result = prime * result + ((contadorPass == null) ? 0 : contadorPass.hashCode());
		result = prime * result + ((contadorTelefono == null) ? 0 : contadorTelefono.hashCode());
		result = prime * result + ((contadorUsser == null) ? 0 : contadorUsser.hashCode());
		result = prime * result + copId;
		result = prime * result + copNit;
		result = prime * result + ((datosperApellidos == null) ? 0 : datosperApellidos.hashCode());
		result = prime * result + ((datosperCelular == null) ? 0 : datosperCelular.hashCode());
		result = prime * result
				+ ((datosperDireccionCorrespondencia == null) ? 0 : datosperDireccionCorrespondencia.hashCode());
		result = prime * result + ((datosperEmail == null) ? 0 : datosperEmail.hashCode());
		result = prime * result + ((datosperEstado == null) ? 0 : datosperEstado.hashCode());
		result = prime * result + ((datosperMastoca == null) ? 0 : datosperMastoca.hashCode());
		result = prime * result + ((datosperNombres == null) ? 0 : datosperNombres.hashCode());
		result = prime * result + datosperNumeroDocumento;
		result = prime * result + ((datosperPassword == null) ? 0 : datosperPassword.hashCode());
		result = prime * result + ((datosperPropietario == null) ? 0 : datosperPropietario.hashCode());
		result = prime * result + ((datosperTelefono == null) ? 0 : datosperTelefono.hashCode());
		result = prime * result + ((datosperTipoResidente == null) ? 0 : datosperTipoResidente.hashCode());
		result = prime * result + ((datosperUser == null) ? 0 : datosperUser.hashCode());
		result = prime * result + ((guardaApellidos == null) ? 0 : guardaApellidos.hashCode());
		result = prime * result + ((guardaCelular == null) ? 0 : guardaCelular.hashCode());
		result = prime * result
				+ ((guardaDireccionCorrespondencia == null) ? 0 : guardaDireccionCorrespondencia.hashCode());
		result = prime * result + ((guardaEmail == null) ? 0 : guardaEmail.hashCode());
		result = prime * result + ((guardaEstado == null) ? 0 : guardaEstado.hashCode());
		result = prime * result + ((guardaNombres == null) ? 0 : guardaNombres.hashCode());
		result = prime * result + ((guardaNumeroDocumento == null) ? 0 : guardaNumeroDocumento.hashCode());
		result = prime * result + ((guardaObservaciones == null) ? 0 : guardaObservaciones.hashCode());
		result = prime * result + ((guardaPass == null) ? 0 : guardaPass.hashCode());
		result = prime * result + ((guardaTelefono == null) ? 0 : guardaTelefono.hashCode());
		result = prime * result + ((guardaUsser == null) ? 0 : guardaUsser.hashCode());
		result = prime * result + ((inquilinoApellidos == null) ? 0 : inquilinoApellidos.hashCode());
		result = prime * result + ((inquilinoAutoriza == null) ? 0 : inquilinoAutoriza.hashCode());
		result = prime * result + ((inquilinoAutorizaApellidos == null) ? 0 : inquilinoAutorizaApellidos.hashCode());
		result = prime * result + ((inquilinoAutorizaEstado == null) ? 0 : inquilinoAutorizaEstado.hashCode());
		result = prime * result + ((inquilinoAutorizaNombres == null) ? 0 : inquilinoAutorizaNombres.hashCode());
		result = prime * result
				+ ((inquilinoAutorizaNumeroDocumento == null) ? 0 : inquilinoAutorizaNumeroDocumento.hashCode());
		result = prime * result
				+ ((inquilinoAutorizaNumeroTelefono == null) ? 0 : inquilinoAutorizaNumeroTelefono.hashCode());
		result = prime * result + ((inquilinoAutorizaParentesco == null) ? 0 : inquilinoAutorizaParentesco.hashCode());
		result = prime * result + ((inquilinoCelular == null) ? 0 : inquilinoCelular.hashCode());
		result = prime * result + ((inquilinoClaseVehiculo == null) ? 0 : inquilinoClaseVehiculo.hashCode());
		result = prime * result + ((inquilinoColorVehiculo == null) ? 0 : inquilinoColorVehiculo.hashCode());
		result = prime * result
				+ ((inquilinoDireccionCorrespondencia == null) ? 0 : inquilinoDireccionCorrespondencia.hashCode());
		result = prime * result + ((inquilinoEdad == null) ? 0 : inquilinoEdad.hashCode());
		result = prime * result + ((inquilinoEmail == null) ? 0 : inquilinoEmail.hashCode());
		result = prime * result
				+ ((inquilinoEmergenciaApellidos == null) ? 0 : inquilinoEmergenciaApellidos.hashCode());
		result = prime * result + ((inquilinoEmergenciaCelular == null) ? 0 : inquilinoEmergenciaCelular.hashCode());
		result = prime * result + ((inquilinoEmergenciaEmail == null) ? 0 : inquilinoEmergenciaEmail.hashCode());
		result = prime * result + ((inquilinoEmergenciaEstado == null) ? 0 : inquilinoEmergenciaEstado.hashCode());
		result = prime * result + ((inquilinoEmergenciaNombres == null) ? 0 : inquilinoEmergenciaNombres.hashCode());
		result = prime * result
				+ ((inquilinoEmergenciaNumeroDocumento == null) ? 0 : inquilinoEmergenciaNumeroDocumento.hashCode());
		result = prime * result + ((inquilinoEstado == null) ? 0 : inquilinoEstado.hashCode());
		result = prime * result + ((inquilinoMarcaVehiculo == null) ? 0 : inquilinoMarcaVehiculo.hashCode());
		result = prime * result + ((inquilinoMascotaEstado == null) ? 0 : inquilinoMascotaEstado.hashCode());
		result = prime * result + ((inquilinoMascotaObservacion == null) ? 0 : inquilinoMascotaObservacion.hashCode());
		result = prime * result + ((inquilinoMastoca == null) ? 0 : inquilinoMastoca.hashCode());
		result = prime * result + ((inquilinoNombreMascota == null) ? 0 : inquilinoNombreMascota.hashCode());
		result = prime * result + ((inquilinoNombres == null) ? 0 : inquilinoNombres.hashCode());
		result = prime * result + ((inquilinoNumeroDocumento == null) ? 0 : inquilinoNumeroDocumento.hashCode());
		result = prime * result + ((inquilinoObservaciones == null) ? 0 : inquilinoObservaciones.hashCode());
		result = prime * result + ((inquilinoPass == null) ? 0 : inquilinoPass.hashCode());
		result = prime * result + ((inquilinoPlaca == null) ? 0 : inquilinoPlaca.hashCode());
		result = prime * result + ((inquilinoRaza == null) ? 0 : inquilinoRaza.hashCode());
		result = prime * result + ((inquilinoResidenteApellidos == null) ? 0 : inquilinoResidenteApellidos.hashCode());
		result = prime * result + ((inquilinoResidenteEstado == null) ? 0 : inquilinoResidenteEstado.hashCode());
		result = prime * result + ((inquilinoResidenteNombres == null) ? 0 : inquilinoResidenteNombres.hashCode());
		result = prime * result
				+ ((inquilinoResidenteNumeroDocumento == null) ? 0 : inquilinoResidenteNumeroDocumento.hashCode());
		result = prime * result
				+ ((inquilinoResidenteNumeroTelefono == null) ? 0 : inquilinoResidenteNumeroTelefono.hashCode());
		result = prime * result
				+ ((inquilinoResidenteParentesco == null) ? 0 : inquilinoResidenteParentesco.hashCode());
		result = prime * result + ((inquilinoTelefono == null) ? 0 : inquilinoTelefono.hashCode());
		result = prime * result + ((inquilinoUsser == null) ? 0 : inquilinoUsser.hashCode());
		result = prime * result + ((inquilinoVehiculo == null) ? 0 : inquilinoVehiculo.hashCode());
		result = prime * result + ((inquilinoVehiculoEstado == null) ? 0 : inquilinoVehiculoEstado.hashCode());
		result = prime * result
				+ ((inquilinoVehiculoObservacion == null) ? 0 : inquilinoVehiculoObservacion.hashCode());
		result = prime * result + ((inquiloEstado == null) ? 0 : inquiloEstado.hashCode());
		result = prime * result + ((inquiloNumeroResidencia == null) ? 0 : inquiloNumeroResidencia.hashCode());
		result = prime * result + ((proAutoriFechaIngreso == null) ? 0 : proAutoriFechaIngreso.hashCode());
		result = prime * result + ((proAutoriFechaSalida == null) ? 0 : proAutoriFechaSalida.hashCode());
		result = prime * result + ((proAutoriPlacaVehiculo == null) ? 0 : proAutoriPlacaVehiculo.hashCode());
		result = prime * result + ((proAutoriza == null) ? 0 : proAutoriza.hashCode());
		result = prime * result + ((proAutorizaApellidos == null) ? 0 : proAutorizaApellidos.hashCode());
		result = prime * result + ((proAutorizaEstado == null) ? 0 : proAutorizaEstado.hashCode());
		result = prime * result + ((proAutorizaNombres == null) ? 0 : proAutorizaNombres.hashCode());
		result = prime * result + ((proAutorizaNumeroDocumento == null) ? 0 : proAutorizaNumeroDocumento.hashCode());
		result = prime * result + ((proAutorizaNumeroTelefono == null) ? 0 : proAutorizaNumeroTelefono.hashCode());
		result = prime * result + ((proAutorizaParentesco == null) ? 0 : proAutorizaParentesco.hashCode());
		result = prime * result + ((proClaseVehciulo == null) ? 0 : proClaseVehciulo.hashCode());
		result = prime * result + ((proColorVehiculo == null) ? 0 : proColorVehiculo.hashCode());
		result = prime * result + ((proEdad == null) ? 0 : proEdad.hashCode());
		result = prime * result + ((proEmergenciaApellidos == null) ? 0 : proEmergenciaApellidos.hashCode());
		result = prime * result + ((proEmergenciaCelular == null) ? 0 : proEmergenciaCelular.hashCode());
		result = prime * result + ((proEmergenciaEmail == null) ? 0 : proEmergenciaEmail.hashCode());
		result = prime * result + ((proEmergenciaEstado == null) ? 0 : proEmergenciaEstado.hashCode());
		result = prime * result + ((proEmergenciaNombres == null) ? 0 : proEmergenciaNombres.hashCode());
		result = prime * result
				+ ((proEmergenciaNumeroDocumento == null) ? 0 : proEmergenciaNumeroDocumento.hashCode());
		result = prime * result + ((proEstado == null) ? 0 : proEstado.hashCode());
		result = prime * result + ((proMarcaVehiculo == null) ? 0 : proMarcaVehiculo.hashCode());
		result = prime * result + ((proMascotaEstado == null) ? 0 : proMascotaEstado.hashCode());
		result = prime * result + ((proMascotaObservacion == null) ? 0 : proMascotaObservacion.hashCode());
		result = prime * result + ((proMastoca == null) ? 0 : proMastoca.hashCode());
		result = prime * result + ((proNombreMascota == null) ? 0 : proNombreMascota.hashCode());
		result = prime * result + ((proNumeroMatricula == null) ? 0 : proNumeroMatricula.hashCode());
		result = prime * result + ((proNumeroResidencia == null) ? 0 : proNumeroResidencia.hashCode());
		result = prime * result + ((proObservaciones == null) ? 0 : proObservaciones.hashCode());
		result = prime * result + ((proPlaca == null) ? 0 : proPlaca.hashCode());
		result = prime * result + ((proRaza == null) ? 0 : proRaza.hashCode());
		result = prime * result + ((proResidente == null) ? 0 : proResidente.hashCode());
		result = prime * result + ((proResidenteApellidos == null) ? 0 : proResidenteApellidos.hashCode());
		result = prime * result + ((proResidenteEstado == null) ? 0 : proResidenteEstado.hashCode());
		result = prime * result + ((proResidenteNombres == null) ? 0 : proResidenteNombres.hashCode());
		result = prime * result + ((proResidenteNumeroDocumento == null) ? 0 : proResidenteNumeroDocumento.hashCode());
		result = prime * result + ((proResidenteNumeroTelefono == null) ? 0 : proResidenteNumeroTelefono.hashCode());
		result = prime * result + ((proResidenteParentesco == null) ? 0 : proResidenteParentesco.hashCode());
		result = prime * result + ((proVehciuloEstado == null) ? 0 : proVehciuloEstado.hashCode());
		result = prime * result + ((proVehiculo == null) ? 0 : proVehiculo.hashCode());
		result = prime * result + ((proVehiculoObservacion == null) ? 0 : proVehiculoObservacion.hashCode());
		result = prime * result + ((revisorApellidos == null) ? 0 : revisorApellidos.hashCode());
		result = prime * result + ((revisorCelular == null) ? 0 : revisorCelular.hashCode());
		result = prime * result
				+ ((revisorDireccionCorrespondencia == null) ? 0 : revisorDireccionCorrespondencia.hashCode());
		result = prime * result + ((revisorEmail == null) ? 0 : revisorEmail.hashCode());
		result = prime * result + ((revisorEstado == null) ? 0 : revisorEstado.hashCode());
		result = prime * result + ((revisorNombres == null) ? 0 : revisorNombres.hashCode());
		result = prime * result + ((revisorNumeroDocumento == null) ? 0 : revisorNumeroDocumento.hashCode());
		result = prime * result + ((revisorObservaciones == null) ? 0 : revisorObservaciones.hashCode());
		result = prime * result + ((revisorPass == null) ? 0 : revisorPass.hashCode());
		result = prime * result + ((revisorTelefono == null) ? 0 : revisorTelefono.hashCode());
		result = prime * result + ((revisorUsser == null) ? 0 : revisorUsser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatosGeneralesDTO other = (DatosGeneralesDTO) obj;
		if (InquilinoAutoriFechaIngreso == null) {
			if (other.InquilinoAutoriFechaIngreso != null)
				return false;
		} else if (!InquilinoAutoriFechaIngreso.equals(other.InquilinoAutoriFechaIngreso))
			return false;
		if (InquilinoAutoriFechaSalida == null) {
			if (other.InquilinoAutoriFechaSalida != null)
				return false;
		} else if (!InquilinoAutoriFechaSalida.equals(other.InquilinoAutoriFechaSalida))
			return false;
		if (InquilinoAutoriPlacaVehiculo == null) {
			if (other.InquilinoAutoriPlacaVehiculo != null)
				return false;
		} else if (!InquilinoAutoriPlacaVehiculo.equals(other.InquilinoAutoriPlacaVehiculo))
			return false;
		if (administradorApellidos == null) {
			if (other.administradorApellidos != null)
				return false;
		} else if (!administradorApellidos.equals(other.administradorApellidos))
			return false;
		if (administradorCelular == null) {
			if (other.administradorCelular != null)
				return false;
		} else if (!administradorCelular.equals(other.administradorCelular))
			return false;
		if (administradorDireccionCorrespondencia == null) {
			if (other.administradorDireccionCorrespondencia != null)
				return false;
		} else if (!administradorDireccionCorrespondencia.equals(other.administradorDireccionCorrespondencia))
			return false;
		if (administradorEmail == null) {
			if (other.administradorEmail != null)
				return false;
		} else if (!administradorEmail.equals(other.administradorEmail))
			return false;
		if (administradorEstado == null) {
			if (other.administradorEstado != null)
				return false;
		} else if (!administradorEstado.equals(other.administradorEstado))
			return false;
		if (administradorNombres == null) {
			if (other.administradorNombres != null)
				return false;
		} else if (!administradorNombres.equals(other.administradorNombres))
			return false;
		if (administradorNumeroDocumento == null) {
			if (other.administradorNumeroDocumento != null)
				return false;
		} else if (!administradorNumeroDocumento.equals(other.administradorNumeroDocumento))
			return false;
		if (administradorObservaciones == null) {
			if (other.administradorObservaciones != null)
				return false;
		} else if (!administradorObservaciones.equals(other.administradorObservaciones))
			return false;
		if (administradorPass == null) {
			if (other.administradorPass != null)
				return false;
		} else if (!administradorPass.equals(other.administradorPass))
			return false;
		if (administradorTelefono == null) {
			if (other.administradorTelefono != null)
				return false;
		} else if (!administradorTelefono.equals(other.administradorTelefono))
			return false;
		if (administradorUsser == null) {
			if (other.administradorUsser != null)
				return false;
		} else if (!administradorUsser.equals(other.administradorUsser))
			return false;
		if (contadorApellidos == null) {
			if (other.contadorApellidos != null)
				return false;
		} else if (!contadorApellidos.equals(other.contadorApellidos))
			return false;
		if (contadorCelular == null) {
			if (other.contadorCelular != null)
				return false;
		} else if (!contadorCelular.equals(other.contadorCelular))
			return false;
		if (contadorDireccionCorrespondencia == null) {
			if (other.contadorDireccionCorrespondencia != null)
				return false;
		} else if (!contadorDireccionCorrespondencia.equals(other.contadorDireccionCorrespondencia))
			return false;
		if (contadorEmail == null) {
			if (other.contadorEmail != null)
				return false;
		} else if (!contadorEmail.equals(other.contadorEmail))
			return false;
		if (contadorEstado == null) {
			if (other.contadorEstado != null)
				return false;
		} else if (!contadorEstado.equals(other.contadorEstado))
			return false;
		if (contadorNombres == null) {
			if (other.contadorNombres != null)
				return false;
		} else if (!contadorNombres.equals(other.contadorNombres))
			return false;
		if (contadorNumeroDocumento == null) {
			if (other.contadorNumeroDocumento != null)
				return false;
		} else if (!contadorNumeroDocumento.equals(other.contadorNumeroDocumento))
			return false;
		if (contadorObservaciones == null) {
			if (other.contadorObservaciones != null)
				return false;
		} else if (!contadorObservaciones.equals(other.contadorObservaciones))
			return false;
		if (contadorPass == null) {
			if (other.contadorPass != null)
				return false;
		} else if (!contadorPass.equals(other.contadorPass))
			return false;
		if (contadorTelefono == null) {
			if (other.contadorTelefono != null)
				return false;
		} else if (!contadorTelefono.equals(other.contadorTelefono))
			return false;
		if (contadorUsser == null) {
			if (other.contadorUsser != null)
				return false;
		} else if (!contadorUsser.equals(other.contadorUsser))
			return false;
		if (copId != other.copId)
			return false;
		if (copNit != other.copNit)
			return false;
		if (datosperApellidos == null) {
			if (other.datosperApellidos != null)
				return false;
		} else if (!datosperApellidos.equals(other.datosperApellidos))
			return false;
		if (datosperCelular == null) {
			if (other.datosperCelular != null)
				return false;
		} else if (!datosperCelular.equals(other.datosperCelular))
			return false;
		if (datosperDireccionCorrespondencia == null) {
			if (other.datosperDireccionCorrespondencia != null)
				return false;
		} else if (!datosperDireccionCorrespondencia.equals(other.datosperDireccionCorrespondencia))
			return false;
		if (datosperEmail == null) {
			if (other.datosperEmail != null)
				return false;
		} else if (!datosperEmail.equals(other.datosperEmail))
			return false;
		if (datosperEstado == null) {
			if (other.datosperEstado != null)
				return false;
		} else if (!datosperEstado.equals(other.datosperEstado))
			return false;
		if (datosperMastoca == null) {
			if (other.datosperMastoca != null)
				return false;
		} else if (!datosperMastoca.equals(other.datosperMastoca))
			return false;
		if (datosperNombres == null) {
			if (other.datosperNombres != null)
				return false;
		} else if (!datosperNombres.equals(other.datosperNombres))
			return false;
		if (datosperNumeroDocumento != other.datosperNumeroDocumento)
			return false;
		if (datosperPassword == null) {
			if (other.datosperPassword != null)
				return false;
		} else if (!datosperPassword.equals(other.datosperPassword))
			return false;
		if (datosperPropietario == null) {
			if (other.datosperPropietario != null)
				return false;
		} else if (!datosperPropietario.equals(other.datosperPropietario))
			return false;
		if (datosperTelefono == null) {
			if (other.datosperTelefono != null)
				return false;
		} else if (!datosperTelefono.equals(other.datosperTelefono))
			return false;
		if (datosperTipoResidente == null) {
			if (other.datosperTipoResidente != null)
				return false;
		} else if (!datosperTipoResidente.equals(other.datosperTipoResidente))
			return false;
		if (datosperUser == null) {
			if (other.datosperUser != null)
				return false;
		} else if (!datosperUser.equals(other.datosperUser))
			return false;
		if (guardaApellidos == null) {
			if (other.guardaApellidos != null)
				return false;
		} else if (!guardaApellidos.equals(other.guardaApellidos))
			return false;
		if (guardaCelular == null) {
			if (other.guardaCelular != null)
				return false;
		} else if (!guardaCelular.equals(other.guardaCelular))
			return false;
		if (guardaDireccionCorrespondencia == null) {
			if (other.guardaDireccionCorrespondencia != null)
				return false;
		} else if (!guardaDireccionCorrespondencia.equals(other.guardaDireccionCorrespondencia))
			return false;
		if (guardaEmail == null) {
			if (other.guardaEmail != null)
				return false;
		} else if (!guardaEmail.equals(other.guardaEmail))
			return false;
		if (guardaEstado == null) {
			if (other.guardaEstado != null)
				return false;
		} else if (!guardaEstado.equals(other.guardaEstado))
			return false;
		if (guardaNombres == null) {
			if (other.guardaNombres != null)
				return false;
		} else if (!guardaNombres.equals(other.guardaNombres))
			return false;
		if (guardaNumeroDocumento == null) {
			if (other.guardaNumeroDocumento != null)
				return false;
		} else if (!guardaNumeroDocumento.equals(other.guardaNumeroDocumento))
			return false;
		if (guardaObservaciones == null) {
			if (other.guardaObservaciones != null)
				return false;
		} else if (!guardaObservaciones.equals(other.guardaObservaciones))
			return false;
		if (guardaPass == null) {
			if (other.guardaPass != null)
				return false;
		} else if (!guardaPass.equals(other.guardaPass))
			return false;
		if (guardaTelefono == null) {
			if (other.guardaTelefono != null)
				return false;
		} else if (!guardaTelefono.equals(other.guardaTelefono))
			return false;
		if (guardaUsser == null) {
			if (other.guardaUsser != null)
				return false;
		} else if (!guardaUsser.equals(other.guardaUsser))
			return false;
		if (inquilinoApellidos == null) {
			if (other.inquilinoApellidos != null)
				return false;
		} else if (!inquilinoApellidos.equals(other.inquilinoApellidos))
			return false;
		if (inquilinoAutoriza == null) {
			if (other.inquilinoAutoriza != null)
				return false;
		} else if (!inquilinoAutoriza.equals(other.inquilinoAutoriza))
			return false;
		if (inquilinoAutorizaApellidos == null) {
			if (other.inquilinoAutorizaApellidos != null)
				return false;
		} else if (!inquilinoAutorizaApellidos.equals(other.inquilinoAutorizaApellidos))
			return false;
		if (inquilinoAutorizaEstado == null) {
			if (other.inquilinoAutorizaEstado != null)
				return false;
		} else if (!inquilinoAutorizaEstado.equals(other.inquilinoAutorizaEstado))
			return false;
		if (inquilinoAutorizaNombres == null) {
			if (other.inquilinoAutorizaNombres != null)
				return false;
		} else if (!inquilinoAutorizaNombres.equals(other.inquilinoAutorizaNombres))
			return false;
		if (inquilinoAutorizaNumeroDocumento == null) {
			if (other.inquilinoAutorizaNumeroDocumento != null)
				return false;
		} else if (!inquilinoAutorizaNumeroDocumento.equals(other.inquilinoAutorizaNumeroDocumento))
			return false;
		if (inquilinoAutorizaNumeroTelefono == null) {
			if (other.inquilinoAutorizaNumeroTelefono != null)
				return false;
		} else if (!inquilinoAutorizaNumeroTelefono.equals(other.inquilinoAutorizaNumeroTelefono))
			return false;
		if (inquilinoAutorizaParentesco == null) {
			if (other.inquilinoAutorizaParentesco != null)
				return false;
		} else if (!inquilinoAutorizaParentesco.equals(other.inquilinoAutorizaParentesco))
			return false;
		if (inquilinoCelular == null) {
			if (other.inquilinoCelular != null)
				return false;
		} else if (!inquilinoCelular.equals(other.inquilinoCelular))
			return false;
		if (inquilinoClaseVehiculo == null) {
			if (other.inquilinoClaseVehiculo != null)
				return false;
		} else if (!inquilinoClaseVehiculo.equals(other.inquilinoClaseVehiculo))
			return false;
		if (inquilinoColorVehiculo == null) {
			if (other.inquilinoColorVehiculo != null)
				return false;
		} else if (!inquilinoColorVehiculo.equals(other.inquilinoColorVehiculo))
			return false;
		if (inquilinoDireccionCorrespondencia == null) {
			if (other.inquilinoDireccionCorrespondencia != null)
				return false;
		} else if (!inquilinoDireccionCorrespondencia.equals(other.inquilinoDireccionCorrespondencia))
			return false;
		if (inquilinoEdad == null) {
			if (other.inquilinoEdad != null)
				return false;
		} else if (!inquilinoEdad.equals(other.inquilinoEdad))
			return false;
		if (inquilinoEmail == null) {
			if (other.inquilinoEmail != null)
				return false;
		} else if (!inquilinoEmail.equals(other.inquilinoEmail))
			return false;
		if (inquilinoEmergenciaApellidos == null) {
			if (other.inquilinoEmergenciaApellidos != null)
				return false;
		} else if (!inquilinoEmergenciaApellidos.equals(other.inquilinoEmergenciaApellidos))
			return false;
		if (inquilinoEmergenciaCelular == null) {
			if (other.inquilinoEmergenciaCelular != null)
				return false;
		} else if (!inquilinoEmergenciaCelular.equals(other.inquilinoEmergenciaCelular))
			return false;
		if (inquilinoEmergenciaEmail == null) {
			if (other.inquilinoEmergenciaEmail != null)
				return false;
		} else if (!inquilinoEmergenciaEmail.equals(other.inquilinoEmergenciaEmail))
			return false;
		if (inquilinoEmergenciaEstado == null) {
			if (other.inquilinoEmergenciaEstado != null)
				return false;
		} else if (!inquilinoEmergenciaEstado.equals(other.inquilinoEmergenciaEstado))
			return false;
		if (inquilinoEmergenciaNombres == null) {
			if (other.inquilinoEmergenciaNombres != null)
				return false;
		} else if (!inquilinoEmergenciaNombres.equals(other.inquilinoEmergenciaNombres))
			return false;
		if (inquilinoEmergenciaNumeroDocumento == null) {
			if (other.inquilinoEmergenciaNumeroDocumento != null)
				return false;
		} else if (!inquilinoEmergenciaNumeroDocumento.equals(other.inquilinoEmergenciaNumeroDocumento))
			return false;
		if (inquilinoEstado == null) {
			if (other.inquilinoEstado != null)
				return false;
		} else if (!inquilinoEstado.equals(other.inquilinoEstado))
			return false;
		if (inquilinoMarcaVehiculo == null) {
			if (other.inquilinoMarcaVehiculo != null)
				return false;
		} else if (!inquilinoMarcaVehiculo.equals(other.inquilinoMarcaVehiculo))
			return false;
		if (inquilinoMascotaEstado == null) {
			if (other.inquilinoMascotaEstado != null)
				return false;
		} else if (!inquilinoMascotaEstado.equals(other.inquilinoMascotaEstado))
			return false;
		if (inquilinoMascotaObservacion == null) {
			if (other.inquilinoMascotaObservacion != null)
				return false;
		} else if (!inquilinoMascotaObservacion.equals(other.inquilinoMascotaObservacion))
			return false;
		if (inquilinoMastoca == null) {
			if (other.inquilinoMastoca != null)
				return false;
		} else if (!inquilinoMastoca.equals(other.inquilinoMastoca))
			return false;
		if (inquilinoNombreMascota == null) {
			if (other.inquilinoNombreMascota != null)
				return false;
		} else if (!inquilinoNombreMascota.equals(other.inquilinoNombreMascota))
			return false;
		if (inquilinoNombres == null) {
			if (other.inquilinoNombres != null)
				return false;
		} else if (!inquilinoNombres.equals(other.inquilinoNombres))
			return false;
		if (inquilinoNumeroDocumento == null) {
			if (other.inquilinoNumeroDocumento != null)
				return false;
		} else if (!inquilinoNumeroDocumento.equals(other.inquilinoNumeroDocumento))
			return false;
		if (inquilinoObservaciones == null) {
			if (other.inquilinoObservaciones != null)
				return false;
		} else if (!inquilinoObservaciones.equals(other.inquilinoObservaciones))
			return false;
		if (inquilinoPass == null) {
			if (other.inquilinoPass != null)
				return false;
		} else if (!inquilinoPass.equals(other.inquilinoPass))
			return false;
		if (inquilinoPlaca == null) {
			if (other.inquilinoPlaca != null)
				return false;
		} else if (!inquilinoPlaca.equals(other.inquilinoPlaca))
			return false;
		if (inquilinoRaza == null) {
			if (other.inquilinoRaza != null)
				return false;
		} else if (!inquilinoRaza.equals(other.inquilinoRaza))
			return false;
		if (inquilinoResidenteApellidos == null) {
			if (other.inquilinoResidenteApellidos != null)
				return false;
		} else if (!inquilinoResidenteApellidos.equals(other.inquilinoResidenteApellidos))
			return false;
		if (inquilinoResidenteEstado == null) {
			if (other.inquilinoResidenteEstado != null)
				return false;
		} else if (!inquilinoResidenteEstado.equals(other.inquilinoResidenteEstado))
			return false;
		if (inquilinoResidenteNombres == null) {
			if (other.inquilinoResidenteNombres != null)
				return false;
		} else if (!inquilinoResidenteNombres.equals(other.inquilinoResidenteNombres))
			return false;
		if (inquilinoResidenteNumeroDocumento == null) {
			if (other.inquilinoResidenteNumeroDocumento != null)
				return false;
		} else if (!inquilinoResidenteNumeroDocumento.equals(other.inquilinoResidenteNumeroDocumento))
			return false;
		if (inquilinoResidenteNumeroTelefono == null) {
			if (other.inquilinoResidenteNumeroTelefono != null)
				return false;
		} else if (!inquilinoResidenteNumeroTelefono.equals(other.inquilinoResidenteNumeroTelefono))
			return false;
		if (inquilinoResidenteParentesco == null) {
			if (other.inquilinoResidenteParentesco != null)
				return false;
		} else if (!inquilinoResidenteParentesco.equals(other.inquilinoResidenteParentesco))
			return false;
		if (inquilinoTelefono == null) {
			if (other.inquilinoTelefono != null)
				return false;
		} else if (!inquilinoTelefono.equals(other.inquilinoTelefono))
			return false;
		if (inquilinoUsser == null) {
			if (other.inquilinoUsser != null)
				return false;
		} else if (!inquilinoUsser.equals(other.inquilinoUsser))
			return false;
		if (inquilinoVehiculo == null) {
			if (other.inquilinoVehiculo != null)
				return false;
		} else if (!inquilinoVehiculo.equals(other.inquilinoVehiculo))
			return false;
		if (inquilinoVehiculoEstado == null) {
			if (other.inquilinoVehiculoEstado != null)
				return false;
		} else if (!inquilinoVehiculoEstado.equals(other.inquilinoVehiculoEstado))
			return false;
		if (inquilinoVehiculoObservacion == null) {
			if (other.inquilinoVehiculoObservacion != null)
				return false;
		} else if (!inquilinoVehiculoObservacion.equals(other.inquilinoVehiculoObservacion))
			return false;
		if (inquiloEstado == null) {
			if (other.inquiloEstado != null)
				return false;
		} else if (!inquiloEstado.equals(other.inquiloEstado))
			return false;
		if (inquiloNumeroResidencia == null) {
			if (other.inquiloNumeroResidencia != null)
				return false;
		} else if (!inquiloNumeroResidencia.equals(other.inquiloNumeroResidencia))
			return false;
		if (proAutoriFechaIngreso == null) {
			if (other.proAutoriFechaIngreso != null)
				return false;
		} else if (!proAutoriFechaIngreso.equals(other.proAutoriFechaIngreso))
			return false;
		if (proAutoriFechaSalida == null) {
			if (other.proAutoriFechaSalida != null)
				return false;
		} else if (!proAutoriFechaSalida.equals(other.proAutoriFechaSalida))
			return false;
		if (proAutoriPlacaVehiculo == null) {
			if (other.proAutoriPlacaVehiculo != null)
				return false;
		} else if (!proAutoriPlacaVehiculo.equals(other.proAutoriPlacaVehiculo))
			return false;
		if (proAutoriza == null) {
			if (other.proAutoriza != null)
				return false;
		} else if (!proAutoriza.equals(other.proAutoriza))
			return false;
		if (proAutorizaApellidos == null) {
			if (other.proAutorizaApellidos != null)
				return false;
		} else if (!proAutorizaApellidos.equals(other.proAutorizaApellidos))
			return false;
		if (proAutorizaEstado == null) {
			if (other.proAutorizaEstado != null)
				return false;
		} else if (!proAutorizaEstado.equals(other.proAutorizaEstado))
			return false;
		if (proAutorizaNombres == null) {
			if (other.proAutorizaNombres != null)
				return false;
		} else if (!proAutorizaNombres.equals(other.proAutorizaNombres))
			return false;
		if (proAutorizaNumeroDocumento == null) {
			if (other.proAutorizaNumeroDocumento != null)
				return false;
		} else if (!proAutorizaNumeroDocumento.equals(other.proAutorizaNumeroDocumento))
			return false;
		if (proAutorizaNumeroTelefono == null) {
			if (other.proAutorizaNumeroTelefono != null)
				return false;
		} else if (!proAutorizaNumeroTelefono.equals(other.proAutorizaNumeroTelefono))
			return false;
		if (proAutorizaParentesco == null) {
			if (other.proAutorizaParentesco != null)
				return false;
		} else if (!proAutorizaParentesco.equals(other.proAutorizaParentesco))
			return false;
		if (proClaseVehciulo == null) {
			if (other.proClaseVehciulo != null)
				return false;
		} else if (!proClaseVehciulo.equals(other.proClaseVehciulo))
			return false;
		if (proColorVehiculo == null) {
			if (other.proColorVehiculo != null)
				return false;
		} else if (!proColorVehiculo.equals(other.proColorVehiculo))
			return false;
		if (proEdad == null) {
			if (other.proEdad != null)
				return false;
		} else if (!proEdad.equals(other.proEdad))
			return false;
		if (proEmergenciaApellidos == null) {
			if (other.proEmergenciaApellidos != null)
				return false;
		} else if (!proEmergenciaApellidos.equals(other.proEmergenciaApellidos))
			return false;
		if (proEmergenciaCelular == null) {
			if (other.proEmergenciaCelular != null)
				return false;
		} else if (!proEmergenciaCelular.equals(other.proEmergenciaCelular))
			return false;
		if (proEmergenciaEmail == null) {
			if (other.proEmergenciaEmail != null)
				return false;
		} else if (!proEmergenciaEmail.equals(other.proEmergenciaEmail))
			return false;
		if (proEmergenciaEstado == null) {
			if (other.proEmergenciaEstado != null)
				return false;
		} else if (!proEmergenciaEstado.equals(other.proEmergenciaEstado))
			return false;
		if (proEmergenciaNombres == null) {
			if (other.proEmergenciaNombres != null)
				return false;
		} else if (!proEmergenciaNombres.equals(other.proEmergenciaNombres))
			return false;
		if (proEmergenciaNumeroDocumento == null) {
			if (other.proEmergenciaNumeroDocumento != null)
				return false;
		} else if (!proEmergenciaNumeroDocumento.equals(other.proEmergenciaNumeroDocumento))
			return false;
		if (proEstado == null) {
			if (other.proEstado != null)
				return false;
		} else if (!proEstado.equals(other.proEstado))
			return false;
		if (proMarcaVehiculo == null) {
			if (other.proMarcaVehiculo != null)
				return false;
		} else if (!proMarcaVehiculo.equals(other.proMarcaVehiculo))
			return false;
		if (proMascotaEstado == null) {
			if (other.proMascotaEstado != null)
				return false;
		} else if (!proMascotaEstado.equals(other.proMascotaEstado))
			return false;
		if (proMascotaObservacion == null) {
			if (other.proMascotaObservacion != null)
				return false;
		} else if (!proMascotaObservacion.equals(other.proMascotaObservacion))
			return false;
		if (proMastoca == null) {
			if (other.proMastoca != null)
				return false;
		} else if (!proMastoca.equals(other.proMastoca))
			return false;
		if (proNombreMascota == null) {
			if (other.proNombreMascota != null)
				return false;
		} else if (!proNombreMascota.equals(other.proNombreMascota))
			return false;
		if (proNumeroMatricula == null) {
			if (other.proNumeroMatricula != null)
				return false;
		} else if (!proNumeroMatricula.equals(other.proNumeroMatricula))
			return false;
		if (proNumeroResidencia == null) {
			if (other.proNumeroResidencia != null)
				return false;
		} else if (!proNumeroResidencia.equals(other.proNumeroResidencia))
			return false;
		if (proObservaciones == null) {
			if (other.proObservaciones != null)
				return false;
		} else if (!proObservaciones.equals(other.proObservaciones))
			return false;
		if (proPlaca == null) {
			if (other.proPlaca != null)
				return false;
		} else if (!proPlaca.equals(other.proPlaca))
			return false;
		if (proRaza == null) {
			if (other.proRaza != null)
				return false;
		} else if (!proRaza.equals(other.proRaza))
			return false;
		if (proResidente == null) {
			if (other.proResidente != null)
				return false;
		} else if (!proResidente.equals(other.proResidente))
			return false;
		if (proResidenteApellidos == null) {
			if (other.proResidenteApellidos != null)
				return false;
		} else if (!proResidenteApellidos.equals(other.proResidenteApellidos))
			return false;
		if (proResidenteEstado == null) {
			if (other.proResidenteEstado != null)
				return false;
		} else if (!proResidenteEstado.equals(other.proResidenteEstado))
			return false;
		if (proResidenteNombres == null) {
			if (other.proResidenteNombres != null)
				return false;
		} else if (!proResidenteNombres.equals(other.proResidenteNombres))
			return false;
		if (proResidenteNumeroDocumento == null) {
			if (other.proResidenteNumeroDocumento != null)
				return false;
		} else if (!proResidenteNumeroDocumento.equals(other.proResidenteNumeroDocumento))
			return false;
		if (proResidenteNumeroTelefono == null) {
			if (other.proResidenteNumeroTelefono != null)
				return false;
		} else if (!proResidenteNumeroTelefono.equals(other.proResidenteNumeroTelefono))
			return false;
		if (proResidenteParentesco == null) {
			if (other.proResidenteParentesco != null)
				return false;
		} else if (!proResidenteParentesco.equals(other.proResidenteParentesco))
			return false;
		if (proVehciuloEstado == null) {
			if (other.proVehciuloEstado != null)
				return false;
		} else if (!proVehciuloEstado.equals(other.proVehciuloEstado))
			return false;
		if (proVehiculo == null) {
			if (other.proVehiculo != null)
				return false;
		} else if (!proVehiculo.equals(other.proVehiculo))
			return false;
		if (proVehiculoObservacion == null) {
			if (other.proVehiculoObservacion != null)
				return false;
		} else if (!proVehiculoObservacion.equals(other.proVehiculoObservacion))
			return false;
		if (revisorApellidos == null) {
			if (other.revisorApellidos != null)
				return false;
		} else if (!revisorApellidos.equals(other.revisorApellidos))
			return false;
		if (revisorCelular == null) {
			if (other.revisorCelular != null)
				return false;
		} else if (!revisorCelular.equals(other.revisorCelular))
			return false;
		if (revisorDireccionCorrespondencia == null) {
			if (other.revisorDireccionCorrespondencia != null)
				return false;
		} else if (!revisorDireccionCorrespondencia.equals(other.revisorDireccionCorrespondencia))
			return false;
		if (revisorEmail == null) {
			if (other.revisorEmail != null)
				return false;
		} else if (!revisorEmail.equals(other.revisorEmail))
			return false;
		if (revisorEstado == null) {
			if (other.revisorEstado != null)
				return false;
		} else if (!revisorEstado.equals(other.revisorEstado))
			return false;
		if (revisorNombres == null) {
			if (other.revisorNombres != null)
				return false;
		} else if (!revisorNombres.equals(other.revisorNombres))
			return false;
		if (revisorNumeroDocumento == null) {
			if (other.revisorNumeroDocumento != null)
				return false;
		} else if (!revisorNumeroDocumento.equals(other.revisorNumeroDocumento))
			return false;
		if (revisorObservaciones == null) {
			if (other.revisorObservaciones != null)
				return false;
		} else if (!revisorObservaciones.equals(other.revisorObservaciones))
			return false;
		if (revisorPass == null) {
			if (other.revisorPass != null)
				return false;
		} else if (!revisorPass.equals(other.revisorPass))
			return false;
		if (revisorTelefono == null) {
			if (other.revisorTelefono != null)
				return false;
		} else if (!revisorTelefono.equals(other.revisorTelefono))
			return false;
		if (revisorUsser == null) {
			if (other.revisorUsser != null)
				return false;
		} else if (!revisorUsser.equals(other.revisorUsser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DatosGeneralesDTO [copId=" + copId + ", copNit=" + copNit + ", datosperTipoResidente="
				+ datosperTipoResidente + ", datosperNumeroDocumento=" + datosperNumeroDocumento
				+ ", proNumeroResidencia=" + proNumeroResidencia + ", datosperNombres=" + datosperNombres
				+ ", datosperApellidos=" + datosperApellidos + ", datosperCelular=" + datosperCelular
				+ ", datosperTelefono=" + datosperTelefono + ", datosperEmail=" + datosperEmail + ", datosperUser="
				+ datosperUser + ", datosperPassword=" + datosperPassword + ", datosperDireccionCorrespondencia="
				+ datosperDireccionCorrespondencia + ", datosperEstado=" + datosperEstado + ", proResidente="
				+ proResidente + ", proEstado=" + proEstado + ", datosperPropietario=" + datosperPropietario
				+ ", datosperMastoca=" + datosperMastoca + ", proObservaciones=" + proObservaciones
				+ ", proEmergenciaNombres=" + proEmergenciaNombres + ", proEmergenciaCelular=" + proEmergenciaCelular
				+ ", proEmergenciaEmail=" + proEmergenciaEmail + ", proVehciuloEstado=" + proVehciuloEstado
				+ ", proResidenteEstado=" + proResidenteEstado + ", proEmergenciaNumeroDocumento="
				+ proEmergenciaNumeroDocumento + ", proNumeroMatricula=" + proNumeroMatricula
				+ ", proEmergenciaApellidos=" + proEmergenciaApellidos + ", proAutoriza=" + proAutoriza
				+ ", proMastoca=" + proMastoca + ", proVehiculo=" + proVehiculo + ", proEmergenciaEstado="
				+ proEmergenciaEstado + ", proClaseVehciulo=" + proClaseVehciulo + ", proPlaca=" + proPlaca
				+ ", proMarcaVehiculo=" + proMarcaVehiculo + ", proColorVehiculo=" + proColorVehiculo
				+ ", proVehiculoObservacion=" + proVehiculoObservacion + ", proNombreMascota=" + proNombreMascota
				+ ", proRaza=" + proRaza + ", proEdad=" + proEdad + ", proMascotaObservacion=" + proMascotaObservacion
				+ ", proMascotaEstado=" + proMascotaEstado + ", proResidenteNumeroDocumento="
				+ proResidenteNumeroDocumento + ", proResidenteNombres=" + proResidenteNombres
				+ ", proResidenteApellidos=" + proResidenteApellidos + ", proResidenteNumeroTelefono="
				+ proResidenteNumeroTelefono + ", proResidenteParentesco=" + proResidenteParentesco
				+ ", proAutorizaNumeroDocumento=" + proAutorizaNumeroDocumento + ", proAutorizaNombres="
				+ proAutorizaNombres + ", proAutorizaApellidos=" + proAutorizaApellidos + ", proAutorizaNumeroTelefono="
				+ proAutorizaNumeroTelefono + ", proAutorizaParentesco=" + proAutorizaParentesco
				+ ", proAutoriFechaIngreso=" + proAutoriFechaIngreso + ", proAutoriFechaSalida=" + proAutoriFechaSalida
				+ ", proAutoriPlacaVehiculo=" + proAutoriPlacaVehiculo + ", proAutorizaEstado=" + proAutorizaEstado
				+ ", inquilinoObservaciones=" + inquilinoObservaciones + ", inquilinoNumeroDocumento="
				+ inquilinoNumeroDocumento + ", inquiloNumeroResidencia=" + inquiloNumeroResidencia
				+ ", inquilinoNombres=" + inquilinoNombres + ", inquilinoUsser=" + inquilinoUsser + ", inquilinoPass="
				+ inquilinoPass + ", inquilinoApellidos=" + inquilinoApellidos + ", inquilinoDireccionCorrespondencia="
				+ inquilinoDireccionCorrespondencia + ", inquilinoEstado=" + inquilinoEstado
				+ ", inquilinoAutorizaEstado=" + inquilinoAutorizaEstado + ", inquilinoCelular=" + inquilinoCelular
				+ ", inquilinoTelefono=" + inquilinoTelefono + ", inquilinoEmail=" + inquilinoEmail + ", inquiloEstado="
				+ inquiloEstado + ", inquilinoResidenteNombres=" + inquilinoResidenteNombres
				+ ", inquilinoResidenteApellidos=" + inquilinoResidenteApellidos
				+ ", inquilinoResidenteNumeroDocumento=" + inquilinoResidenteNumeroDocumento
				+ ", inquilinoResidenteNumeroTelefono=" + inquilinoResidenteNumeroTelefono
				+ ", inquilinoResidenteParentesco=" + inquilinoResidenteParentesco + ", inquilinoResidenteEstado="
				+ inquilinoResidenteEstado + ", inquilinoAutoriza=" + inquilinoAutoriza
				+ ", inquilinoAutorizaNumeroDocumento=" + inquilinoAutorizaNumeroDocumento
				+ ", inquilinoAutorizaNombres=" + inquilinoAutorizaNombres + ", inquilinoAutorizaApellidos="
				+ inquilinoAutorizaApellidos + ", inquilinoAutorizaNumeroTelefono=" + inquilinoAutorizaNumeroTelefono
				+ ", inquilinoAutorizaParentesco=" + inquilinoAutorizaParentesco + ", inquilinoMastoca="
				+ inquilinoMastoca + ", inquilinoNombreMascota=" + inquilinoNombreMascota + ", inquilinoRaza="
				+ inquilinoRaza + ", inquilinoEdad=" + inquilinoEdad + ", inquilinoMascotaObservacion="
				+ inquilinoMascotaObservacion + ", inquilinoMascotaEstado=" + inquilinoMascotaEstado
				+ ", inquilinoVehiculo=" + inquilinoVehiculo + ", inquilinoClaseVehiculo=" + inquilinoClaseVehiculo
				+ ", inquilinoPlaca=" + inquilinoPlaca + ", inquilinoMarcaVehiculo=" + inquilinoMarcaVehiculo
				+ ", inquilinoColorVehiculo=" + inquilinoColorVehiculo + ", inquilinoVehiculoObservacion="
				+ inquilinoVehiculoObservacion + ", inquilinoVehiculoEstado=" + inquilinoVehiculoEstado
				+ ", inquilinoEmergenciaNumeroDocumento=" + inquilinoEmergenciaNumeroDocumento
				+ ", inquilinoEmergenciaNombres=" + inquilinoEmergenciaNombres + ", inquilinoEmergenciaApellidos="
				+ inquilinoEmergenciaApellidos + ", inquilinoEmergenciaCelular=" + inquilinoEmergenciaCelular
				+ ", inquilinoEmergenciaEmail=" + inquilinoEmergenciaEmail + ", inquilinoEmergenciaEstado="
				+ inquilinoEmergenciaEstado + ", InquilinoAutoriFechaIngreso=" + InquilinoAutoriFechaIngreso
				+ ", InquilinoAutoriFechaSalida=" + InquilinoAutoriFechaSalida + ", InquilinoAutoriPlacaVehiculo="
				+ InquilinoAutoriPlacaVehiculo + ", administradorNumeroDocumento=" + administradorNumeroDocumento
				+ ", administradorObservaciones=" + administradorObservaciones + ", administradorNombres="
				+ administradorNombres + ", administradorUsser=" + administradorUsser + ", administradorPass="
				+ administradorPass + ", administradorApellidos=" + administradorApellidos
				+ ", administradorDireccionCorrespondencia=" + administradorDireccionCorrespondencia
				+ ", administradorCelular=" + administradorCelular + ", administradorTelefono=" + administradorTelefono
				+ ", administradorEmail=" + administradorEmail + ", administradorEstado=" + administradorEstado
				+ ", guardaNombres=" + guardaNombres + ", guardaUsser=" + guardaUsser + ", guardaPass=" + guardaPass
				+ ", guardaApellidos=" + guardaApellidos + ", guardaDireccionCorrespondencia="
				+ guardaDireccionCorrespondencia + ", guardaNumeroDocumento=" + guardaNumeroDocumento
				+ ", guardaCelular=" + guardaCelular + ", guardaObservaciones=" + guardaObservaciones
				+ ", guardaTelefono=" + guardaTelefono + ", guardaEmail=" + guardaEmail + ", guardaEstado="
				+ guardaEstado + ", contadorUsser=" + contadorUsser + ", contadorPass=" + contadorPass
				+ ", contadorApellidos=" + contadorApellidos + ", contadorDireccionCorrespondencia="
				+ contadorDireccionCorrespondencia + ", contadorNombres=" + contadorNombres
				+ ", contadorNumeroDocumento=" + contadorNumeroDocumento + ", contadorCelular=" + contadorCelular
				+ ", contadorTelefono=" + contadorTelefono + ", contadorEmail=" + contadorEmail
				+ ", contadorObservaciones=" + contadorObservaciones + ", contadorEstado=" + contadorEstado
				+ ", revisorNombres=" + revisorNombres + ", revisorUsser=" + revisorUsser + ", revisorPass="
				+ revisorPass + ", revisorApellidos=" + revisorApellidos + ", revisorDireccionCorrespondencia="
				+ revisorDireccionCorrespondencia + ", revisorNumeroDocumento=" + revisorNumeroDocumento
				+ ", revisorCelular=" + revisorCelular + ", revisorTelefono=" + revisorTelefono + ", revisorEmail="
				+ revisorEmail + ", revisorObservaciones=" + revisorObservaciones + ", revisorEstado=" + revisorEstado
				+ "]";
	}
	
}