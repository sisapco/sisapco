package co.com.sisapco.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

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
	private int actId;
	
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

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actAdjuntoRespuestaCompromisos == null) ? 0 : actAdjuntoRespuestaCompromisos.hashCode());
		result = prime * result + ((actAsistentes == null) ? 0 : actAsistentes.hashCode());
		result = prime * result + ((actCompromisos == null) ? 0 : actCompromisos.hashCode());
		result = prime * result + ((actConvoca == null) ? 0 : actConvoca.hashCode());
		result = prime * result + ((actDesarrolloDia == null) ? 0 : actDesarrolloDia.hashCode());
		result = prime * result + ((actEstadoAprobacion == null) ? 0 : actEstadoAprobacion.hashCode());
		result = prime * result + ((actFecha == null) ? 0 : actFecha.hashCode());
		result = prime * result + ((actFirmaSecretario == null) ? 0 : actFirmaSecretario.hashCode());
		result = prime * result + ((actFirmas == null) ? 0 : actFirmas.hashCode());
		result = prime * result + ((actHoraFin == null) ? 0 : actHoraFin.hashCode());
		result = prime * result + ((actHoraInicio == null) ? 0 : actHoraInicio.hashCode());
		result = prime * result + actId;
		result = prime * result + ((actIdArchivoGoogle == null) ? 0 : actIdArchivoGoogle.hashCode());
		result = prime * result + ((actLugar == null) ? 0 : actLugar.hashCode());
		result = prime * result + ((actMunicipio == null) ? 0 : actMunicipio.hashCode());
		result = prime * result + actNumero;
		result = prime * result + ((actOrdenDia == null) ? 0 : actOrdenDia.hashCode());
		result = prime * result + ((actRespuestaCompromisos == null) ? 0 : actRespuestaCompromisos.hashCode());
		result = prime * result + ((actReunion == null) ? 0 : actReunion.hashCode());
		result = prime * result + copNit;
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
		Actas other = (Actas) obj;
		if (actAdjuntoRespuestaCompromisos == null) {
			if (other.actAdjuntoRespuestaCompromisos != null)
				return false;
		} else if (!actAdjuntoRespuestaCompromisos.equals(other.actAdjuntoRespuestaCompromisos))
			return false;
		if (actAsistentes == null) {
			if (other.actAsistentes != null)
				return false;
		} else if (!actAsistentes.equals(other.actAsistentes))
			return false;
		if (actCompromisos == null) {
			if (other.actCompromisos != null)
				return false;
		} else if (!actCompromisos.equals(other.actCompromisos))
			return false;
		if (actConvoca == null) {
			if (other.actConvoca != null)
				return false;
		} else if (!actConvoca.equals(other.actConvoca))
			return false;
		if (actDesarrolloDia == null) {
			if (other.actDesarrolloDia != null)
				return false;
		} else if (!actDesarrolloDia.equals(other.actDesarrolloDia))
			return false;
		if (actEstadoAprobacion == null) {
			if (other.actEstadoAprobacion != null)
				return false;
		} else if (!actEstadoAprobacion.equals(other.actEstadoAprobacion))
			return false;
		if (actFecha == null) {
			if (other.actFecha != null)
				return false;
		} else if (!actFecha.equals(other.actFecha))
			return false;
		if (actFirmaSecretario == null) {
			if (other.actFirmaSecretario != null)
				return false;
		} else if (!actFirmaSecretario.equals(other.actFirmaSecretario))
			return false;
		if (actFirmas == null) {
			if (other.actFirmas != null)
				return false;
		} else if (!actFirmas.equals(other.actFirmas))
			return false;
		if (actHoraFin == null) {
			if (other.actHoraFin != null)
				return false;
		} else if (!actHoraFin.equals(other.actHoraFin))
			return false;
		if (actHoraInicio == null) {
			if (other.actHoraInicio != null)
				return false;
		} else if (!actHoraInicio.equals(other.actHoraInicio))
			return false;
		if (actId != other.actId)
			return false;
		if (actIdArchivoGoogle == null) {
			if (other.actIdArchivoGoogle != null)
				return false;
		} else if (!actIdArchivoGoogle.equals(other.actIdArchivoGoogle))
			return false;
		if (actLugar == null) {
			if (other.actLugar != null)
				return false;
		} else if (!actLugar.equals(other.actLugar))
			return false;
		if (actMunicipio == null) {
			if (other.actMunicipio != null)
				return false;
		} else if (!actMunicipio.equals(other.actMunicipio))
			return false;
		if (actNumero != other.actNumero)
			return false;
		if (actOrdenDia == null) {
			if (other.actOrdenDia != null)
				return false;
		} else if (!actOrdenDia.equals(other.actOrdenDia))
			return false;
		if (actRespuestaCompromisos == null) {
			if (other.actRespuestaCompromisos != null)
				return false;
		} else if (!actRespuestaCompromisos.equals(other.actRespuestaCompromisos))
			return false;
		if (actReunion == null) {
			if (other.actReunion != null)
				return false;
		} else if (!actReunion.equals(other.actReunion))
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
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
	