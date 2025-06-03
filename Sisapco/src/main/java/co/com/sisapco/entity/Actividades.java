<<<<<<< HEAD
package co.com.sisapco.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.poi.hpsf.Decimal;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Actividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4549669692591662922L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int actId;
	
	@Column
	private int copNit;
	
	@Column
    private String actFechaInicio;
	
	@Column
	private String actFechaFinal;
	
	@Column
	private String actNombreActividad;
	
	@Column
	private String actEstado;
	
	@Column
	private String actDescripcion;
	
	@Column
	private double actCosto;
	
	@Column
	private String actResponsable;
	
	@Column
	private int actDesviacion;
	
	@Column
	private String actFechaEntregaReal;
	
	@Column
	private String actActividades;
	
	@Column
	private int actNumeroActividades;
	
	@Column
	private String actPorcentajeEjecucion;
	
	@Column
	private String actObservaciones;
	
	@Column
	private String actObservacionesAdministrador;
	
	@Column
	private String actLog;

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

	public String getActFechaInicio() {
		return actFechaInicio;
	}

	public void setActFechaInicio(String actFechaInicio) {
		this.actFechaInicio = actFechaInicio;
	}

	public String getActFechaFinal() {
		return actFechaFinal;
	}

	public void setActFechaFinal(String actFechaFinal) {
		this.actFechaFinal = actFechaFinal;
	}

	public String getActNombreActividad() {
		return actNombreActividad;
	}

	public void setActNombreActividad(String actNombreActividad) {
		this.actNombreActividad = actNombreActividad;
	}

	public String getActEstado() {
		return actEstado;
	}

	public void setActEstado(String actEstado) {
		this.actEstado = actEstado;
	}

	public String getActDescripcion() {
		return actDescripcion;
	}

	public void setActDescripcion(String actDescripcion) {
		this.actDescripcion = actDescripcion;
	}

	public double getActCosto() {
		return actCosto;
	}

	public void setActCosto(double actCosto) {
		this.actCosto = actCosto;
	}

	public String getActResponsable() {
		return actResponsable;
	}

	public void setActResponsable(String actResponsable) {
		this.actResponsable = actResponsable;
	}

	public int getActDesviacion() {
		return actDesviacion;
	}

	public void setActDesviacion(int actDesviacion) {
		this.actDesviacion = actDesviacion;
	}

	public String getActFechaEntregaReal() {
		return actFechaEntregaReal;
	}

	public void setActFechaEntregaReal(String actFechaEntregaReal) {
		this.actFechaEntregaReal = actFechaEntregaReal;
	}

	public String getActActividades() {
		return actActividades;
	}

	public void setActActividades(String actActividades) {
		this.actActividades = actActividades;
	}

	public int getActNumeroActividades() {
		return actNumeroActividades;
	}

	public void setActNumeroActividades(int actNumeroActividades) {
		this.actNumeroActividades = actNumeroActividades;
	}

	public String getActPorcentajeEjecucion() {
		return actPorcentajeEjecucion;
	}

	public void setActPorcentajeEjecucion(String actPorcentajeEjecucion) {
		this.actPorcentajeEjecucion = actPorcentajeEjecucion;
	}

	public String getActObservaciones() {
		return actObservaciones;
	}

	public void setActObservaciones(String actObservaciones) {
		this.actObservaciones = actObservaciones;
	}

	public String getActObservacionesAdministrador() {
		return actObservacionesAdministrador;
	}

	public void setActObservacionesAdministrador(String actObservacionesAdministrador) {
		this.actObservacionesAdministrador = actObservacionesAdministrador;
	}

	public String getActLog() {
		return actLog;
	}

	public void setActLog(String actLog) {
		this.actLog = actLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actActividades == null) ? 0 : actActividades.hashCode());
		long temp;
		temp = Double.doubleToLongBits(actCosto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((actDescripcion == null) ? 0 : actDescripcion.hashCode());
		result = prime * result + actDesviacion;
		result = prime * result + ((actEstado == null) ? 0 : actEstado.hashCode());
		result = prime * result + ((actFechaEntregaReal == null) ? 0 : actFechaEntregaReal.hashCode());
		result = prime * result + ((actFechaFinal == null) ? 0 : actFechaFinal.hashCode());
		result = prime * result + ((actFechaInicio == null) ? 0 : actFechaInicio.hashCode());
		result = prime * result + actId;
		result = prime * result + ((actLog == null) ? 0 : actLog.hashCode());
		result = prime * result + ((actNombreActividad == null) ? 0 : actNombreActividad.hashCode());
		result = prime * result + actNumeroActividades;
		result = prime * result + ((actObservaciones == null) ? 0 : actObservaciones.hashCode());
		result = prime * result
				+ ((actObservacionesAdministrador == null) ? 0 : actObservacionesAdministrador.hashCode());
		result = prime * result + ((actPorcentajeEjecucion == null) ? 0 : actPorcentajeEjecucion.hashCode());
		result = prime * result + ((actResponsable == null) ? 0 : actResponsable.hashCode());
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
		Actividades other = (Actividades) obj;
		if (actActividades == null) {
			if (other.actActividades != null)
				return false;
		} else if (!actActividades.equals(other.actActividades))
			return false;
		if (Double.doubleToLongBits(actCosto) != Double.doubleToLongBits(other.actCosto))
			return false;
		if (actDescripcion == null) {
			if (other.actDescripcion != null)
				return false;
		} else if (!actDescripcion.equals(other.actDescripcion))
			return false;
		if (actDesviacion != other.actDesviacion)
			return false;
		if (actEstado == null) {
			if (other.actEstado != null)
				return false;
		} else if (!actEstado.equals(other.actEstado))
			return false;
		if (actFechaEntregaReal == null) {
			if (other.actFechaEntregaReal != null)
				return false;
		} else if (!actFechaEntregaReal.equals(other.actFechaEntregaReal))
			return false;
		if (actFechaFinal == null) {
			if (other.actFechaFinal != null)
				return false;
		} else if (!actFechaFinal.equals(other.actFechaFinal))
			return false;
		if (actFechaInicio == null) {
			if (other.actFechaInicio != null)
				return false;
		} else if (!actFechaInicio.equals(other.actFechaInicio))
			return false;
		if (actId != other.actId)
			return false;
		if (actLog == null) {
			if (other.actLog != null)
				return false;
		} else if (!actLog.equals(other.actLog))
			return false;
		if (actNombreActividad == null) {
			if (other.actNombreActividad != null)
				return false;
		} else if (!actNombreActividad.equals(other.actNombreActividad))
			return false;
		if (actNumeroActividades != other.actNumeroActividades)
			return false;
		if (actObservaciones == null) {
			if (other.actObservaciones != null)
				return false;
		} else if (!actObservaciones.equals(other.actObservaciones))
			return false;
		if (actObservacionesAdministrador == null) {
			if (other.actObservacionesAdministrador != null)
				return false;
		} else if (!actObservacionesAdministrador.equals(other.actObservacionesAdministrador))
			return false;
		if (actPorcentajeEjecucion == null) {
			if (other.actPorcentajeEjecucion != null)
				return false;
		} else if (!actPorcentajeEjecucion.equals(other.actPorcentajeEjecucion))
			return false;
		if (actResponsable == null) {
			if (other.actResponsable != null)
				return false;
		} else if (!actResponsable.equals(other.actResponsable))
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actividades [actId=" + actId + ", copNit=" + copNit + ", actFechaInicio=" + actFechaInicio
				+ ", actFechaFinal=" + actFechaFinal + ", actNombreActividad=" + actNombreActividad + ", actEstado="
				+ actEstado + ", actDescripcion=" + actDescripcion + ", actCosto=" + actCosto + ", actResponsable="
				+ actResponsable + ", actDesviacion=" + actDesviacion + ", actFechaEntregaReal=" + actFechaEntregaReal
				+ ", actActividades=" + actActividades + ", actNumeroActividades=" + actNumeroActividades
				+ ", actPorcentajeEjecucion=" + actPorcentajeEjecucion + ", actObservaciones=" + actObservaciones
				+ ", actObservacionesAdministrador=" + actObservacionesAdministrador + ", actLog=" + actLog + "]";
	}
}
=======
package co.com.sisapco.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.poi.hpsf.Decimal;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Actividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4549669692591662922L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int actId;
	
	@Column
	private int copNit;
	
	@Column
    private String actFechaInicio;
	
	@Column
	private String actFechaFinal;
	
	@Column
	private String actNombreActividad;
	
	@Column
	private String actEstado;
	
	@Column
	private String actDescripcion;
	
	@Column
	private double actCosto;
	
	@Column
	private String actResponsable;
	
	@Column
	private int actDesviacion;
	
	@Column
	private String actFechaEntregaReal;
	
	@Column
	private String actActividades;
	
	@Column
	private int actNumeroActividades;
	
	@Column
	private String actPorcentajeEjecucion;
	
	@Column
	private String actObservaciones;
	
	@Column
	private String actObservacionesAdministrador;
	
	@Column
	private String actLog;

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

	public String getActFechaInicio() {
		return actFechaInicio;
	}

	public void setActFechaInicio(String actFechaInicio) {
		this.actFechaInicio = actFechaInicio;
	}

	public String getActFechaFinal() {
		return actFechaFinal;
	}

	public void setActFechaFinal(String actFechaFinal) {
		this.actFechaFinal = actFechaFinal;
	}

	public String getActNombreActividad() {
		return actNombreActividad;
	}

	public void setActNombreActividad(String actNombreActividad) {
		this.actNombreActividad = actNombreActividad;
	}

	public String getActEstado() {
		return actEstado;
	}

	public void setActEstado(String actEstado) {
		this.actEstado = actEstado;
	}

	public String getActDescripcion() {
		return actDescripcion;
	}

	public void setActDescripcion(String actDescripcion) {
		this.actDescripcion = actDescripcion;
	}

	public double getActCosto() {
		return actCosto;
	}

	public void setActCosto(double actCosto) {
		this.actCosto = actCosto;
	}

	public String getActResponsable() {
		return actResponsable;
	}

	public void setActResponsable(String actResponsable) {
		this.actResponsable = actResponsable;
	}

	public int getActDesviacion() {
		return actDesviacion;
	}

	public void setActDesviacion(int actDesviacion) {
		this.actDesviacion = actDesviacion;
	}

	public String getActFechaEntregaReal() {
		return actFechaEntregaReal;
	}

	public void setActFechaEntregaReal(String actFechaEntregaReal) {
		this.actFechaEntregaReal = actFechaEntregaReal;
	}

	public String getActActividades() {
		return actActividades;
	}

	public void setActActividades(String actActividades) {
		this.actActividades = actActividades;
	}

	public int getActNumeroActividades() {
		return actNumeroActividades;
	}

	public void setActNumeroActividades(int actNumeroActividades) {
		this.actNumeroActividades = actNumeroActividades;
	}

	public String getActPorcentajeEjecucion() {
		return actPorcentajeEjecucion;
	}

	public void setActPorcentajeEjecucion(String actPorcentajeEjecucion) {
		this.actPorcentajeEjecucion = actPorcentajeEjecucion;
	}

	public String getActObservaciones() {
		return actObservaciones;
	}

	public void setActObservaciones(String actObservaciones) {
		this.actObservaciones = actObservaciones;
	}

	public String getActObservacionesAdministrador() {
		return actObservacionesAdministrador;
	}

	public void setActObservacionesAdministrador(String actObservacionesAdministrador) {
		this.actObservacionesAdministrador = actObservacionesAdministrador;
	}

	public String getActLog() {
		return actLog;
	}

	public void setActLog(String actLog) {
		this.actLog = actLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actActividades == null) ? 0 : actActividades.hashCode());
		long temp;
		temp = Double.doubleToLongBits(actCosto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((actDescripcion == null) ? 0 : actDescripcion.hashCode());
		result = prime * result + actDesviacion;
		result = prime * result + ((actEstado == null) ? 0 : actEstado.hashCode());
		result = prime * result + ((actFechaEntregaReal == null) ? 0 : actFechaEntregaReal.hashCode());
		result = prime * result + ((actFechaFinal == null) ? 0 : actFechaFinal.hashCode());
		result = prime * result + ((actFechaInicio == null) ? 0 : actFechaInicio.hashCode());
		result = prime * result + actId;
		result = prime * result + ((actLog == null) ? 0 : actLog.hashCode());
		result = prime * result + ((actNombreActividad == null) ? 0 : actNombreActividad.hashCode());
		result = prime * result + actNumeroActividades;
		result = prime * result + ((actObservaciones == null) ? 0 : actObservaciones.hashCode());
		result = prime * result
				+ ((actObservacionesAdministrador == null) ? 0 : actObservacionesAdministrador.hashCode());
		result = prime * result + ((actPorcentajeEjecucion == null) ? 0 : actPorcentajeEjecucion.hashCode());
		result = prime * result + ((actResponsable == null) ? 0 : actResponsable.hashCode());
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
		Actividades other = (Actividades) obj;
		if (actActividades == null) {
			if (other.actActividades != null)
				return false;
		} else if (!actActividades.equals(other.actActividades))
			return false;
		if (Double.doubleToLongBits(actCosto) != Double.doubleToLongBits(other.actCosto))
			return false;
		if (actDescripcion == null) {
			if (other.actDescripcion != null)
				return false;
		} else if (!actDescripcion.equals(other.actDescripcion))
			return false;
		if (actDesviacion != other.actDesviacion)
			return false;
		if (actEstado == null) {
			if (other.actEstado != null)
				return false;
		} else if (!actEstado.equals(other.actEstado))
			return false;
		if (actFechaEntregaReal == null) {
			if (other.actFechaEntregaReal != null)
				return false;
		} else if (!actFechaEntregaReal.equals(other.actFechaEntregaReal))
			return false;
		if (actFechaFinal == null) {
			if (other.actFechaFinal != null)
				return false;
		} else if (!actFechaFinal.equals(other.actFechaFinal))
			return false;
		if (actFechaInicio == null) {
			if (other.actFechaInicio != null)
				return false;
		} else if (!actFechaInicio.equals(other.actFechaInicio))
			return false;
		if (actId != other.actId)
			return false;
		if (actLog == null) {
			if (other.actLog != null)
				return false;
		} else if (!actLog.equals(other.actLog))
			return false;
		if (actNombreActividad == null) {
			if (other.actNombreActividad != null)
				return false;
		} else if (!actNombreActividad.equals(other.actNombreActividad))
			return false;
		if (actNumeroActividades != other.actNumeroActividades)
			return false;
		if (actObservaciones == null) {
			if (other.actObservaciones != null)
				return false;
		} else if (!actObservaciones.equals(other.actObservaciones))
			return false;
		if (actObservacionesAdministrador == null) {
			if (other.actObservacionesAdministrador != null)
				return false;
		} else if (!actObservacionesAdministrador.equals(other.actObservacionesAdministrador))
			return false;
		if (actPorcentajeEjecucion == null) {
			if (other.actPorcentajeEjecucion != null)
				return false;
		} else if (!actPorcentajeEjecucion.equals(other.actPorcentajeEjecucion))
			return false;
		if (actResponsable == null) {
			if (other.actResponsable != null)
				return false;
		} else if (!actResponsable.equals(other.actResponsable))
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actividades [actId=" + actId + ", copNit=" + copNit + ", actFechaInicio=" + actFechaInicio
				+ ", actFechaFinal=" + actFechaFinal + ", actNombreActividad=" + actNombreActividad + ", actEstado="
				+ actEstado + ", actDescripcion=" + actDescripcion + ", actCosto=" + actCosto + ", actResponsable="
				+ actResponsable + ", actDesviacion=" + actDesviacion + ", actFechaEntregaReal=" + actFechaEntregaReal
				+ ", actActividades=" + actActividades + ", actNumeroActividades=" + actNumeroActividades
				+ ", actPorcentajeEjecucion=" + actPorcentajeEjecucion + ", actObservaciones=" + actObservaciones
				+ ", actObservacionesAdministrador=" + actObservacionesAdministrador + ", actLog=" + actLog + "]";
	}
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
