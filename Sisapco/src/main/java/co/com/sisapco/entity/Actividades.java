package co.com.sisapco.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

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
		return Objects.hash(actActividades, actCosto, actDescripcion, actDesviacion, actEstado, actFechaEntregaReal,
				actFechaFinal, actFechaInicio, actId, actLog, actNombreActividad, actNumeroActividades,
				actObservaciones, actObservacionesAdministrador, actPorcentajeEjecucion, actResponsable, copNit);
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
		return Objects.equals(actActividades, other.actActividades)
				&& Double.doubleToLongBits(actCosto) == Double.doubleToLongBits(other.actCosto)
				&& Objects.equals(actDescripcion, other.actDescripcion) && actDesviacion == other.actDesviacion
				&& Objects.equals(actEstado, other.actEstado)
				&& Objects.equals(actFechaEntregaReal, other.actFechaEntregaReal)
				&& Objects.equals(actFechaFinal, other.actFechaFinal)
				&& Objects.equals(actFechaInicio, other.actFechaInicio) && actId == other.actId
				&& Objects.equals(actLog, other.actLog) && Objects.equals(actNombreActividad, other.actNombreActividad)
				&& actNumeroActividades == other.actNumeroActividades
				&& Objects.equals(actObservaciones, other.actObservaciones)
				&& Objects.equals(actObservacionesAdministrador, other.actObservacionesAdministrador)
				&& Objects.equals(actPorcentajeEjecucion, other.actPorcentajeEjecucion)
				&& Objects.equals(actResponsable, other.actResponsable) && copNit == other.copNit;
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
