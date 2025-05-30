package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4093063241665374769L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private int vehiculoId;
    
	@Column
	private int copNit;
	
	@Column
	private String proNumResidencia;
	
	@Column
	private String vehiculoPlaca;
	
	@Column
	private String vehiculoClaseVehiculo;
	
	@Column
	private String vehiculoMarca;
	
	@Column
	private String vehiculoColor;
	
	@Column
	private String vehiculoObservacion;
	
	@Column
	private String vehiculoEstado;
	
	@Column
	private String vehiculoPerfil;

	public int getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(int vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getProNumResidencia() {
		return proNumResidencia;
	}

	public void setProNumResidencia(String proNumResidencia) {
		this.proNumResidencia = proNumResidencia;
	}

	public String getVehiculoPlaca() {
		return vehiculoPlaca;
	}

	public void setVehiculoPlaca(String vehiculoPlaca) {
		this.vehiculoPlaca = vehiculoPlaca;
	}

	public String getVehiculoClaseVehiculo() {
		return vehiculoClaseVehiculo;
	}

	public void setVehiculoClaseVehiculo(String vehiculoClaseVehiculo) {
		this.vehiculoClaseVehiculo = vehiculoClaseVehiculo;
	}

	public String getVehiculoMarca() {
		return vehiculoMarca;
	}

	public void setVehiculoMarca(String vehiculoMarca) {
		this.vehiculoMarca = vehiculoMarca;
	}

	public String getVehiculoColor() {
		return vehiculoColor;
	}

	public void setVehiculoColor(String vehiculoColor) {
		this.vehiculoColor = vehiculoColor;
	}

	public String getVehiculoObservacion() {
		return vehiculoObservacion;
	}

	public void setVehiculoObservacion(String vehiculoObservacion) {
		this.vehiculoObservacion = vehiculoObservacion;
	}

	public String getVehiculoEstado() {
		return vehiculoEstado;
	}

	public void setVehiculoEstado(String vehiculoEstado) {
		this.vehiculoEstado = vehiculoEstado;
	}

	public String getVehiculoPerfil() {
		return vehiculoPerfil;
	}

	public void setVehiculoPerfil(String vehiculoPerfil) {
		this.vehiculoPerfil = vehiculoPerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((proNumResidencia == null) ? 0 : proNumResidencia.hashCode());
		result = prime * result + ((vehiculoClaseVehiculo == null) ? 0 : vehiculoClaseVehiculo.hashCode());
		result = prime * result + ((vehiculoColor == null) ? 0 : vehiculoColor.hashCode());
		result = prime * result + ((vehiculoEstado == null) ? 0 : vehiculoEstado.hashCode());
		result = prime * result + vehiculoId;
		result = prime * result + ((vehiculoMarca == null) ? 0 : vehiculoMarca.hashCode());
		result = prime * result + ((vehiculoObservacion == null) ? 0 : vehiculoObservacion.hashCode());
		result = prime * result + ((vehiculoPerfil == null) ? 0 : vehiculoPerfil.hashCode());
		result = prime * result + ((vehiculoPlaca == null) ? 0 : vehiculoPlaca.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (copNit != other.copNit)
			return false;
		if (proNumResidencia == null) {
			if (other.proNumResidencia != null)
				return false;
		} else if (!proNumResidencia.equals(other.proNumResidencia))
			return false;
		if (vehiculoClaseVehiculo == null) {
			if (other.vehiculoClaseVehiculo != null)
				return false;
		} else if (!vehiculoClaseVehiculo.equals(other.vehiculoClaseVehiculo))
			return false;
		if (vehiculoColor == null) {
			if (other.vehiculoColor != null)
				return false;
		} else if (!vehiculoColor.equals(other.vehiculoColor))
			return false;
		if (vehiculoEstado == null) {
			if (other.vehiculoEstado != null)
				return false;
		} else if (!vehiculoEstado.equals(other.vehiculoEstado))
			return false;
		if (vehiculoId != other.vehiculoId)
			return false;
		if (vehiculoMarca == null) {
			if (other.vehiculoMarca != null)
				return false;
		} else if (!vehiculoMarca.equals(other.vehiculoMarca))
			return false;
		if (vehiculoObservacion == null) {
			if (other.vehiculoObservacion != null)
				return false;
		} else if (!vehiculoObservacion.equals(other.vehiculoObservacion))
			return false;
		if (vehiculoPerfil == null) {
			if (other.vehiculoPerfil != null)
				return false;
		} else if (!vehiculoPerfil.equals(other.vehiculoPerfil))
			return false;
		if (vehiculoPlaca == null) {
			if (other.vehiculoPlaca != null)
				return false;
		} else if (!vehiculoPlaca.equals(other.vehiculoPlaca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehiculo [vehiculoId=" + vehiculoId + ", copNit=" + copNit + ", proNumResidencia=" + proNumResidencia
				+ ", vehiculoPlaca=" + vehiculoPlaca + ", vehiculoClaseVehiculo=" + vehiculoClaseVehiculo
				+ ", vehiculoMarca=" + vehiculoMarca + ", vehiculoColor=" + vehiculoColor + ", vehiculoObservacion="
				+ vehiculoObservacion + ", vehiculoEstado=" + vehiculoEstado + ", vehiculoPerfil=" + vehiculoPerfil
				+ "]";
	}
	
}
