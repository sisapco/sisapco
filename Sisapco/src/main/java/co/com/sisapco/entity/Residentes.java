package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Residentes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1309101484054971177L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int residenteId;
	
	@Column
	private int copNit;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private int residenteNumeroDocumento;
	
	@Column
	private String residenteNombres;
	
	@Column
	private String residenteApellidos;
	
	@Column
	private String residenteNumeroTelefonico;
	
	@Column
	private String residenteParentesco;
	
	@Column
	private String residenteEstado;
	
	@Column
	private int residentePerfil;

	public int getResidenteId() {
		return residenteId;
	}

	public void setResidenteId(int residenteId) {
		this.residenteId = residenteId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public int getResidenteNumeroDocumento() {
		return residenteNumeroDocumento;
	}

	public void setResidenteNumeroDocumento(int residenteNumeroDocumento) {
		this.residenteNumeroDocumento = residenteNumeroDocumento;
	}

	public String getResidenteNombres() {
		return residenteNombres;
	}

	public void setResidenteNombres(String residenteNombres) {
		this.residenteNombres = residenteNombres;
	}

	public String getResidenteApellidos() {
		return residenteApellidos;
	}

	public void setResidenteApellidos(String residenteApellidos) {
		this.residenteApellidos = residenteApellidos;
	}

	public String getResidenteNumeroTelefonico() {
		return residenteNumeroTelefonico;
	}

	public void setResidenteNumeroTelefonico(String residenteNumeroTelefonico) {
		this.residenteNumeroTelefonico = residenteNumeroTelefonico;
	}

	public String getResidenteParentesco() {
		return residenteParentesco;
	}

	public void setResidenteParentesco(String residenteParentesco) {
		this.residenteParentesco = residenteParentesco;
	}

	public String getResidenteEstado() {
		return residenteEstado;
	}

	public void setResidenteEstado(String residenteEstado) {
		this.residenteEstado = residenteEstado;
	}

	public int getResidentePerfil() {
		return residentePerfil;
	}

	public void setResidentePerfil(int residentePerfil) {
		this.residentePerfil = residentePerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((proNumeroResidencia == null) ? 0 : proNumeroResidencia.hashCode());
		result = prime * result + ((residenteApellidos == null) ? 0 : residenteApellidos.hashCode());
		result = prime * result + ((residenteEstado == null) ? 0 : residenteEstado.hashCode());
		result = prime * result + residenteId;
		result = prime * result + ((residenteNombres == null) ? 0 : residenteNombres.hashCode());
		result = prime * result + residenteNumeroDocumento;
		result = prime * result + ((residenteNumeroTelefonico == null) ? 0 : residenteNumeroTelefonico.hashCode());
		result = prime * result + ((residenteParentesco == null) ? 0 : residenteParentesco.hashCode());
		result = prime * result + residentePerfil;
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
		Residentes other = (Residentes) obj;
		if (copNit != other.copNit)
			return false;
		if (proNumeroResidencia == null) {
			if (other.proNumeroResidencia != null)
				return false;
		} else if (!proNumeroResidencia.equals(other.proNumeroResidencia))
			return false;
		if (residenteApellidos == null) {
			if (other.residenteApellidos != null)
				return false;
		} else if (!residenteApellidos.equals(other.residenteApellidos))
			return false;
		if (residenteEstado == null) {
			if (other.residenteEstado != null)
				return false;
		} else if (!residenteEstado.equals(other.residenteEstado))
			return false;
		if (residenteId != other.residenteId)
			return false;
		if (residenteNombres == null) {
			if (other.residenteNombres != null)
				return false;
		} else if (!residenteNombres.equals(other.residenteNombres))
			return false;
		if (residenteNumeroDocumento != other.residenteNumeroDocumento)
			return false;
		if (residenteNumeroTelefonico == null) {
			if (other.residenteNumeroTelefonico != null)
				return false;
		} else if (!residenteNumeroTelefonico.equals(other.residenteNumeroTelefonico))
			return false;
		if (residenteParentesco == null) {
			if (other.residenteParentesco != null)
				return false;
		} else if (!residenteParentesco.equals(other.residenteParentesco))
			return false;
		if (residentePerfil != other.residentePerfil)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Residentes [residenteId=" + residenteId + ", copNit=" + copNit + ", proNumeroResidencia="
				+ proNumeroResidencia + ", residenteNumeroDocumento=" + residenteNumeroDocumento + ", residenteNombres="
				+ residenteNombres + ", residenteApellidos=" + residenteApellidos + ", residenteNumeroTelefonico="
				+ residenteNumeroTelefonico + ", residenteParentesco=" + residenteParentesco + ", residenteEstado="
				+ residenteEstado + ", residentePerfil=" + residentePerfil + "]";
	}	
}
