package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mascota implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5390390290057852117L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private int mascotaId;
    
	@Column
	private int copNit;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String mascotaNombre;

	@Column
	private String mascotaRaza;

	@Column
	private String mascotaEdad;
	
	@Column
	private String mascotaObservacion;
	
	@Column
	private String mascotaEstado;
	
	@Column
	private String mascotaPerfil;

	public int getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(int mascotaId) {
		this.mascotaId = mascotaId;
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

	public String getMascotaNombre() {
		return mascotaNombre;
	}

	public void setMascotaNombre(String mascotaNombre) {
		this.mascotaNombre = mascotaNombre;
	}

	public String getMascotaRaza() {
		return mascotaRaza;
	}

	public void setMascotaRaza(String mascotaRaza) {
		this.mascotaRaza = mascotaRaza;
	}

	public String getMascotaEdad() {
		return mascotaEdad;
	}

	public void setMascotaEdad(String mascotaEdad) {
		this.mascotaEdad = mascotaEdad;
	}

	public String getMascotaObservacion() {
		return mascotaObservacion;
	}

	public void setMascotaObservacion(String mascotaObservacion) {
		this.mascotaObservacion = mascotaObservacion;
	}

	public String getMascotaEstado() {
		return mascotaEstado;
	}

	public void setMascotaEstado(String mascotaEstado) {
		this.mascotaEstado = mascotaEstado;
	}

	public String getMascotaPerfil() {
		return mascotaPerfil;
	}

	public void setMascotaPerfil(String mascotaPerfil) {
		this.mascotaPerfil = mascotaPerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((mascotaEdad == null) ? 0 : mascotaEdad.hashCode());
		result = prime * result + ((mascotaEstado == null) ? 0 : mascotaEstado.hashCode());
		result = prime * result + mascotaId;
		result = prime * result + ((mascotaNombre == null) ? 0 : mascotaNombre.hashCode());
		result = prime * result + ((mascotaObservacion == null) ? 0 : mascotaObservacion.hashCode());
		result = prime * result + ((mascotaPerfil == null) ? 0 : mascotaPerfil.hashCode());
		result = prime * result + ((mascotaRaza == null) ? 0 : mascotaRaza.hashCode());
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
		Mascota other = (Mascota) obj;
		if (copNit != other.copNit)
			return false;
		if (mascotaEdad == null) {
			if (other.mascotaEdad != null)
				return false;
		} else if (!mascotaEdad.equals(other.mascotaEdad))
			return false;
		if (mascotaEstado == null) {
			if (other.mascotaEstado != null)
				return false;
		} else if (!mascotaEstado.equals(other.mascotaEstado))
			return false;
		if (mascotaId != other.mascotaId)
			return false;
		if (mascotaNombre == null) {
			if (other.mascotaNombre != null)
				return false;
		} else if (!mascotaNombre.equals(other.mascotaNombre))
			return false;
		if (mascotaObservacion == null) {
			if (other.mascotaObservacion != null)
				return false;
		} else if (!mascotaObservacion.equals(other.mascotaObservacion))
			return false;
		if (mascotaPerfil == null) {
			if (other.mascotaPerfil != null)
				return false;
		} else if (!mascotaPerfil.equals(other.mascotaPerfil))
			return false;
		if (mascotaRaza == null) {
			if (other.mascotaRaza != null)
				return false;
		} else if (!mascotaRaza.equals(other.mascotaRaza))
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
		return "Mascota [mascotaId=" + mascotaId + ", copNit=" + copNit + ", proNumeroResidencia=" + proNumeroResidencia
				+ ", mascotaNombre=" + mascotaNombre + ", mascotaRaza=" + mascotaRaza + ", mascotaEdad=" + mascotaEdad
				+ ", mascotaObservacion=" + mascotaObservacion + ", mascotaEstado=" + mascotaEstado + ", mascotaPerfil="
				+ mascotaPerfil + "]";
	}

	
}
