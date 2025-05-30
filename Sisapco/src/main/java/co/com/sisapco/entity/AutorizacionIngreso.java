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
	private int autoriId;
			
	@Column
	private int copNit;		
	
	@Column
	private int proNumeroResidencia; 
	
	@Column
	private int proCc; 	
	
	@Column
	private int autoriNumeroDocumento; 	
	
	@Column
	private String autoriNombres; 	
	
	@Column
	private String autoriApellidos; 
	
	@Column
	private int autoriNumeroTelefonico; 
	
	@Column
	private String autoriParentesco; 
	
	@Column
	private int autoriEstado;
	
	@Column
	private int autoriPerfil;
	
	@Column
	private String autoriFechaIngreso;
	
	@Column
	private String autoriFechaSalida;
	
	@Column
	private String autoriPlacaVehiculo;
	
	

	public int getAutoriId() {
		return autoriId;
	}

	public void setAutoriId(int autoriId) {
		this.autoriId = autoriId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public int getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(int proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public int getProCc() {
		return proCc;
	}

	public void setProCc(int proCc) {
		this.proCc = proCc;
	}

	public int getAutoriNumeroDocumento() {
		return autoriNumeroDocumento;
	}

	public void setAutoriNumeroDocumento(int autoriNumeroDocumento) {
		this.autoriNumeroDocumento = autoriNumeroDocumento;
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

	public int getAutoriNumeroTelefonico() {
		return autoriNumeroTelefonico;
	}

	public void setAutoriNumeroTelefonico(int autoriNumeroTelefonico) {
		this.autoriNumeroTelefonico = autoriNumeroTelefonico;
	}

	public String getAutoriParentesco() {
		return autoriParentesco;
	}

	public void setAutoriParentesco(String autoriParentesco) {
		this.autoriParentesco = autoriParentesco;
	}

	public int getAutoriEstado() {
		return autoriEstado;
	}

	public void setAutoriEstado(int autoriEstado) {
		this.autoriEstado = autoriEstado;
	}

	public int getAutoriPerfil() {
		return autoriPerfil;
	}

	public void setAutoriPerfil(int autoriPerfil) {
		this.autoriPerfil = autoriPerfil;
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

	public String getAutoriPlacaVehiculo() {
		return autoriPlacaVehiculo;
	}

	public void setAutoriPlacaVehiculo(String autoriPlacaVehiculo) {
		this.autoriPlacaVehiculo = autoriPlacaVehiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoriApellidos == null) ? 0 : autoriApellidos.hashCode());
		result = prime * result + autoriEstado;
		result = prime * result + ((autoriFechaIngreso == null) ? 0 : autoriFechaIngreso.hashCode());
		result = prime * result + ((autoriFechaSalida == null) ? 0 : autoriFechaSalida.hashCode());
		result = prime * result + autoriId;
		result = prime * result + ((autoriNombres == null) ? 0 : autoriNombres.hashCode());
		result = prime * result + autoriNumeroDocumento;
		result = prime * result + autoriNumeroTelefonico;
		result = prime * result + ((autoriParentesco == null) ? 0 : autoriParentesco.hashCode());
		result = prime * result + autoriPerfil;
		result = prime * result + ((autoriPlacaVehiculo == null) ? 0 : autoriPlacaVehiculo.hashCode());
		result = prime * result + copNit;
		result = prime * result + proCc;
		result = prime * result + proNumeroResidencia;
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
		if (autoriId != other.autoriId)
			return false;
		if (autoriNombres == null) {
			if (other.autoriNombres != null)
				return false;
		} else if (!autoriNombres.equals(other.autoriNombres))
			return false;
		if (autoriNumeroDocumento != other.autoriNumeroDocumento)
			return false;
		if (autoriNumeroTelefonico != other.autoriNumeroTelefonico)
			return false;
		if (autoriParentesco == null) {
			if (other.autoriParentesco != null)
				return false;
		} else if (!autoriParentesco.equals(other.autoriParentesco))
			return false;
		if (autoriPerfil != other.autoriPerfil)
			return false;
		if (autoriPlacaVehiculo == null) {
			if (other.autoriPlacaVehiculo != null)
				return false;
		} else if (!autoriPlacaVehiculo.equals(other.autoriPlacaVehiculo))
			return false;
		if (copNit != other.copNit)
			return false;
		if (proCc != other.proCc)
			return false;
		if (proNumeroResidencia != other.proNumeroResidencia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AutorizacionIngreso [autoriId=" + autoriId + ", copNit=" + copNit + ", proNumeroResidencia="
				+ proNumeroResidencia + ", proCc=" + proCc + ", autoriNumeroDocumento=" + autoriNumeroDocumento
				+ ", autoriNombres=" + autoriNombres + ", autoriApellidos=" + autoriApellidos
				+ ", autoriNumeroTelefonico=" + autoriNumeroTelefonico + ", autoriParentesco=" + autoriParentesco
				+ ", autoriEstado=" + autoriEstado + ", autoriPerfil=" + autoriPerfil + ", autoriFechaIngreso="
				+ autoriFechaIngreso + ", autoriFechaSalida=" + autoriFechaSalida + ", autoriPlacaVehiculo="
				+ autoriPlacaVehiculo + "]";
	}
}
