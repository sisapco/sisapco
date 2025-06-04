package co.com.sisapco.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;

@Entity
public class Actas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6029159676827900299L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private Long actId;
	
	@Column
	private int copNit;
	
	@Column
	private int actNumero;
	
	@Column
	private String actReunion;
	
	@Column
	private String actConvoca;
	
	@Column
	private String actMunicipio;
	
	@Column
	private String actLugar;
	
	@Column
	private String actHoraInicio;
	
	@Column
	private String actAsistentes;
	
	@Column
	private String actOrdenDia;
	
	@Column
	private String actDesarrolloDia;
	
	@Column
	private String actFirmas;
	
	@Column
	private Time actHoraFin;
	
	@Column
	private String actFecha;
	
	@Column
	private String actFirmaSecretario;
	
	@Column
	private String actEstadoAprobacion;

	@Column
	private String actRespuestaCompromisos;
	
	@Column
	private String actAdjuntoRespuestaCompromisos;
	
	@Column
	private String actCompromisos;
	
	@Column
	private String actIdArchivoGoogle;

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public int getActNumero() {
		return actNumero;
	}

	public void setActNumero(int actNumero) {
		this.actNumero = actNumero;
	}

	public String getActReunion() {
		return actReunion;
	}

	public void setActReunion(String actReunion) {
		this.actReunion = actReunion;
	}

	public String getActConvoca() {
		return actConvoca;
	}

	public void setActConvoca(String actConvoca) {
		this.actConvoca = actConvoca;
	}

	public String getActMunicipio() {
		return actMunicipio;
	}

	public void setActMunicipio(String actMunicipio) {
		this.actMunicipio = actMunicipio;
	}

	public String getActLugar() {
		return actLugar;
	}

	public void setActLugar(String actLugar) {
		this.actLugar = actLugar;
	}

	public String getActHoraInicio() {
		return actHoraInicio;
	}

	public void setActHoraInicio(String actHoraInicio) {
		this.actHoraInicio = actHoraInicio;
	}

	public String getActAsistentes() {
		return actAsistentes;
	}

	public void setActAsistentes(String actAsistentes) {
		this.actAsistentes = actAsistentes;
	}

	public String getActOrdenDia() {
		return actOrdenDia;
	}

	public void setActOrdenDia(String actOrdenDia) {
		this.actOrdenDia = actOrdenDia;
	}

	public String getActDesarrolloDia() {
		return actDesarrolloDia;
	}

	public void setActDesarrolloDia(String actDesarrolloDia) {
		this.actDesarrolloDia = actDesarrolloDia;
	}

	public String getActFirmas() {
		return actFirmas;
	}

	public void setActFirmas(String actFirmas) {
		this.actFirmas = actFirmas;
	}

	public Time getActHoraFin() {
		return actHoraFin;
	}

	public void setActHoraFin(Time actHoraFin) {
		this.actHoraFin = actHoraFin;
	}

	public String getActFecha() {
		return actFecha;
	}

	public void setActFecha(String actFecha) {
		this.actFecha = actFecha;
	}

	public String getActFirmaSecretario() {
		return actFirmaSecretario;
	}

	public void setActFirmaSecretario(String actFirmaSecretario) {
		this.actFirmaSecretario = actFirmaSecretario;
	}

	public String getActEstadoAprobacion() {
		return actEstadoAprobacion;
	}

	public void setActEstadoAprobacion(String actEstadoAprobacion) {
		this.actEstadoAprobacion = actEstadoAprobacion;
	}

	public String getActRespuestaCompromisos() {
		return actRespuestaCompromisos;
	}

	public void setActRespuestaCompromisos(String actRespuestaCompromisos) {
		this.actRespuestaCompromisos = actRespuestaCompromisos;
	}

	public String getActAdjuntoRespuestaCompromisos() {
		return actAdjuntoRespuestaCompromisos;
	}

	public void setActAdjuntoRespuestaCompromisos(String actAdjuntoRespuestaCompromisos) {
		this.actAdjuntoRespuestaCompromisos = actAdjuntoRespuestaCompromisos;
	}

	public String getActCompromisos() {
		return actCompromisos;
	}

	public void setActCompromisos(String actCompromisos) {
		this.actCompromisos = actCompromisos;
	}

	public String getActIdArchivoGoogle() {
		return actIdArchivoGoogle;
	}

	public void setActIdArchivoGoogle(String actIdArchivoGoogle) {
		this.actIdArchivoGoogle = actIdArchivoGoogle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actAdjuntoRespuestaCompromisos, actAsistentes, actCompromisos, actConvoca, actDesarrolloDia,
				actEstadoAprobacion, actFecha, actFirmaSecretario, actFirmas, actHoraFin, actHoraInicio, actId,
				actIdArchivoGoogle, actLugar, actMunicipio, actNumero, actOrdenDia, actRespuestaCompromisos, actReunion,
				copNit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actas other = (Actas) obj;
		return Objects.equals(actAdjuntoRespuestaCompromisos, other.actAdjuntoRespuestaCompromisos)
				&& Objects.equals(actAsistentes, other.actAsistentes)
				&& Objects.equals(actCompromisos, other.actCompromisos) && Objects.equals(actConvoca, other.actConvoca)
				&& Objects.equals(actDesarrolloDia, other.actDesarrolloDia)
				&& Objects.equals(actEstadoAprobacion, other.actEstadoAprobacion)
				&& Objects.equals(actFecha, other.actFecha)
				&& Objects.equals(actFirmaSecretario, other.actFirmaSecretario)
				&& Objects.equals(actFirmas, other.actFirmas) && Objects.equals(actHoraFin, other.actHoraFin)
				&& Objects.equals(actHoraInicio, other.actHoraInicio) && Objects.equals(actId, other.actId)
				&& Objects.equals(actIdArchivoGoogle, other.actIdArchivoGoogle)
				&& Objects.equals(actLugar, other.actLugar) && Objects.equals(actMunicipio, other.actMunicipio)
				&& actNumero == other.actNumero && Objects.equals(actOrdenDia, other.actOrdenDia)
				&& Objects.equals(actRespuestaCompromisos, other.actRespuestaCompromisos)
				&& Objects.equals(actReunion, other.actReunion) && copNit == other.copNit;
	}

	@Override
	public String toString() {
		return "Actas [actId=" + actId + ", copNit=" + copNit + ", actNumero=" + actNumero + ", actReunion="
				+ actReunion + ", actConvoca=" + actConvoca + ", actMunicipio=" + actMunicipio + ", actLugar="
				+ actLugar + ", actHoraInicio=" + actHoraInicio + ", actAsistentes=" + actAsistentes + ", actOrdenDia="
				+ actOrdenDia + ", actDesarrolloDia=" + actDesarrolloDia + ", actFirmas=" + actFirmas + ", actHoraFin="
				+ actHoraFin + ", actFecha=" + actFecha + ", actFirmaSecretario=" + actFirmaSecretario
				+ ", actEstadoAprobacion=" + actEstadoAprobacion + ", actRespuestaCompromisos="
				+ actRespuestaCompromisos + ", actAdjuntoRespuestaCompromisos=" + actAdjuntoRespuestaCompromisos
				+ ", actCompromisos=" + actCompromisos + ", actIdArchivoGoogle=" + actIdArchivoGoogle + "]";
	}

	
}
	