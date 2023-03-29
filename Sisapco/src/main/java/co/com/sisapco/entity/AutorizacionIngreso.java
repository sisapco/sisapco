package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class AutorizacionIngreso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1393030940485135478L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int idAutorizacionIngreso;
	
		
	@Column
	private int copNit;
	
	@Column
	private int proCc; 
	@Column
	private String proNumeroResidencia; 
	@Column
	private String autoriNombres; 
	@Column
	private String autoriApellidos; 
	@Column
	private int autoriCcVisitante;  
	@Column
	private String autoriPlacaVehiculo; 
	@Column
	private int autoriCantidadPersonas; 
	@Column
	private int autoriCantidadVehiculos; 
	@Column
	private String autoriFechaIngreso; 
	@Column
	private String autoriFechaSalida; 
	@Column
	private String autoriObservaciones;
	@Column
	private int autoriEstado;
	public int getIdAutorizacionIngreso() {
		return idAutorizacionIngreso;
	}
	public void setIdAutorizacionIngreso(int idAutorizacionIngreso) {
		this.idAutorizacionIngreso = idAutorizacionIngreso;
	}
	public int getCopNit() {
		return copNit;
	}
	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}
	public int getProCc() {
		return proCc;
	}
	public void setProCc(int proCc) {
		this.proCc = proCc;
	}
	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}
	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}
	public String getAutoriNombres() {
		return autoriNombres;
	}
	public void setAutoriNombres(String autoriNombres) {
		this.autoriNombres = autoriNombres;
	}
	public String getAutoriApellidos() {
		return autoriApellidos;
	}
	public void setAutoriApellidos(String autoriApellidos) {
		this.autoriApellidos = autoriApellidos;
	}
	public int getAutoriCcVisitante() {
		return autoriCcVisitante;
	}
	public void setAutoriCcVisitante(int autoriCcVisitante) {
		this.autoriCcVisitante = autoriCcVisitante;
	}
	public String getAutoriPlacaVehiculo() {
		return autoriPlacaVehiculo;
	}
	public void setAutoriPlacaVehiculo(String autoriPlacaVehiculo) {
		this.autoriPlacaVehiculo = autoriPlacaVehiculo;
	}
	public int getAutoriCantidadPersonas() {
		return autoriCantidadPersonas;
	}
	public void setAutoriCantidadPersonas(int autoriCantidadPersonas) {
		this.autoriCantidadPersonas = autoriCantidadPersonas;
	}
	public int getAutoriCantidadVehiculos() {
		return autoriCantidadVehiculos;
	}
	public void setAutoriCantidadVehiculos(int autoriCantidadVehiculos) {
		this.autoriCantidadVehiculos = autoriCantidadVehiculos;
	}
	public String getAutoriFechaIngreso() {
		return autoriFechaIngreso;
	}
	public void setAutoriFechaIngreso(String autoriFechaIngreso) {
		this.autoriFechaIngreso = autoriFechaIngreso;
	}
	public String getAutoriFechaSalida() {
		return autoriFechaSalida;
	}
	public void setAutoriFechaSalida(String autoriFechaSalida) {
		this.autoriFechaSalida = autoriFechaSalida;
	}
	public String getAutoriObservaciones() {
		return autoriObservaciones;
	}
	public void setAutoriObservaciones(String autoriObservaciones) {
		this.autoriObservaciones = autoriObservaciones;
	}
	public int getAutoriEstado() {
		return autoriEstado;
	}
	public void setAutoriEstado(int autoriEstado) {
		this.autoriEstado = autoriEstado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoriApellidos == null) ? 0 : autoriApellidos.hashCode());
		result = prime * result + autoriCantidadPersonas;
		result = prime * result + autoriCantidadVehiculos;
		result = prime * result + autoriCcVisitante;
		result = prime * result + autoriEstado;
		result = prime * result + ((autoriFechaIngreso == null) ? 0 : autoriFechaIngreso.hashCode());
		result = prime * result + ((autoriFechaSalida == null) ? 0 : autoriFechaSalida.hashCode());
		result = prime * result + ((autoriNombres == null) ? 0 : autoriNombres.hashCode());
		result = prime * result + ((autoriObservaciones == null) ? 0 : autoriObservaciones.hashCode());
		result = prime * result + ((autoriPlacaVehiculo == null) ? 0 : autoriPlacaVehiculo.hashCode());
		result = prime * result + copNit;
		result = prime * result + idAutorizacionIngreso;
		result = prime * result + proCc;
		result = prime * result + ((proNumeroResidencia == null) ? 0 : proNumeroResidencia.hashCode());
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
		AutorizacionIngreso other = (AutorizacionIngreso) obj;
		if (autoriApellidos == null) {
			if (other.autoriApellidos != null)
				return false;
		} else if (!autoriApellidos.equals(other.autoriApellidos))
			return false;
		if (autoriCantidadPersonas != other.autoriCantidadPersonas)
			return false;
		if (autoriCantidadVehiculos != other.autoriCantidadVehiculos)
			return false;
		if (autoriCcVisitante != other.autoriCcVisitante)
			return false;
		if (autoriEstado != other.autoriEstado)
			return false;
		if (autoriFechaIngreso == null) {
			if (other.autoriFechaIngreso != null)
				return false;
		} else if (!autoriFechaIngreso.equals(other.autoriFechaIngreso))
			return false;
		if (autoriFechaSalida == null) {
			if (other.autoriFechaSalida != null)
				return false;
		} else if (!autoriFechaSalida.equals(other.autoriFechaSalida))
			return false;
		if (autoriNombres == null) {
			if (other.autoriNombres != null)
				return false;
		} else if (!autoriNombres.equals(other.autoriNombres))
			return false;
		if (autoriObservaciones == null) {
			if (other.autoriObservaciones != null)
				return false;
		} else if (!autoriObservaciones.equals(other.autoriObservaciones))
			return false;
		if (autoriPlacaVehiculo == null) {
			if (other.autoriPlacaVehiculo != null)
				return false;
		} else if (!autoriPlacaVehiculo.equals(other.autoriPlacaVehiculo))
			return false;
		if (copNit != other.copNit)
			return false;
		if (idAutorizacionIngreso != other.idAutorizacionIngreso)
			return false;
		if (proCc != other.proCc)
			return false;
		if (proNumeroResidencia == null) {
			if (other.proNumeroResidencia != null)
				return false;
		} else if (!proNumeroResidencia.equals(other.proNumeroResidencia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AutorizacionIngreso [idAutorizacionIngreso=" + idAutorizacionIngreso + ", copNit=" + copNit + ", proCc="
				+ proCc + ", proNumeroResidencia=" + proNumeroResidencia + ", autoriNombres=" + autoriNombres
				+ ", autoriApellidos=" + autoriApellidos + ", autoriCcVisitante=" + autoriCcVisitante
				+ ", autoriPlacaVehiculo=" + autoriPlacaVehiculo + ", autoriCantidadPersonas=" + autoriCantidadPersonas
				+ ", autoriCantidadVehiculos=" + autoriCantidadVehiculos + ", autoriFechaIngreso=" + autoriFechaIngreso
				+ ", autoriFechaSalida=" + autoriFechaSalida + ", autoriObservaciones=" + autoriObservaciones
				+ ", autoriEstado=" + autoriEstado + "]";
	} 
	
	
}
