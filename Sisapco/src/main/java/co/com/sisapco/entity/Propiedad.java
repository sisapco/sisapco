package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Propiedad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7065940259927806126L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int proId;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private int copNit;
	
	@Column
	private String proMatricula;
	
	@Column
	private String proArea;
	
	@Column
	private String proCoeficiente;
	
	@Column
	private String proEstado;

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getProMatricula() {
		return proMatricula;
	}

	public void setProMatricula(String proMatricula) {
		this.proMatricula = proMatricula;
	}

	public String getProArea() {
		return proArea;
	}

	public void setProArea(String proArea) {
		this.proArea = proArea;
	}

	public String getProCoeficiente() {
		return proCoeficiente;
	}

	public void setProCoeficiente(String proCoeficiente) {
		this.proCoeficiente = proCoeficiente;
	}

	public String getProEstado() {
		return proEstado;
	}

	public void setProEstado(String proEstado) {
		this.proEstado = proEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((proArea == null) ? 0 : proArea.hashCode());
		result = prime * result + ((proCoeficiente == null) ? 0 : proCoeficiente.hashCode());
		result = prime * result + ((proEstado == null) ? 0 : proEstado.hashCode());
		result = prime * result + proId;
		result = prime * result + ((proMatricula == null) ? 0 : proMatricula.hashCode());
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
		Propiedad other = (Propiedad) obj;
		if (copNit != other.copNit)
			return false;
		if (proArea == null) {
			if (other.proArea != null)
				return false;
		} else if (!proArea.equals(other.proArea))
			return false;
		if (proCoeficiente == null) {
			if (other.proCoeficiente != null)
				return false;
		} else if (!proCoeficiente.equals(other.proCoeficiente))
			return false;
		if (proEstado == null) {
			if (other.proEstado != null)
				return false;
		} else if (!proEstado.equals(other.proEstado))
			return false;
		if (proId != other.proId)
			return false;
		if (proMatricula == null) {
			if (other.proMatricula != null)
				return false;
		} else if (!proMatricula.equals(other.proMatricula))
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
		return "Propiedad [proId=" + proId + ", proNumeroResidencia=" + proNumeroResidencia + ", copNit=" + copNit
				+ ", proMatricula=" + proMatricula + ", proArea=" + proArea + ", proCoeficiente=" + proCoeficiente
				+ ", proEstado=" + proEstado + "]";
	}
	
	
	

}
