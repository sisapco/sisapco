package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Inquilino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1848482663231293807L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int inquilinoId;
	
	@Column
	private int copNit;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String inquilinoNumeroDocumento;
	
	@Column
	private String inquilinoNombres;
	
	@Column
	private String inquilinoNumeroCelular;
	
	@Column
	private String inquilinoTelefono;
	
	@Column
	private String inquilinoEmail;
	
	@Column
	private String inquilinoDireccionCorrespondencia;
	
	@Column
	private String inquilinoPerfil;
	
	@Column
	private String inquilinoEstado;

	public int getInquilinoId() {
		return inquilinoId;
	}

	public void setInquilinoId(int inquilinoId) {
		this.inquilinoId = inquilinoId;
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

	public String getInquilinoNumeroDocumento() {
		return inquilinoNumeroDocumento;
	}

	public void setInquilinoNumeroDocumento(String inquilinoNumeroDocumento) {
		this.inquilinoNumeroDocumento = inquilinoNumeroDocumento;
	}

	public String getInquilinoNombres() {
		return inquilinoNombres;
	}

	public void setInquilinoNombres(String inquilinoNombres) {
		this.inquilinoNombres = inquilinoNombres;
	}

	public String getInquilinoNumeroCelular() {
		return inquilinoNumeroCelular;
	}

	public void setInquilinoNumeroCelular(String inquilinoNumeroCelular) {
		this.inquilinoNumeroCelular = inquilinoNumeroCelular;
	}

	public String getInquilinoTelefono() {
		return inquilinoTelefono;
	}

	public void setInquilinoTelefono(String inquilinoTelefono) {
		this.inquilinoTelefono = inquilinoTelefono;
	}

	public String getInquilinoEmail() {
		return inquilinoEmail;
	}

	public void setInquilinoEmail(String inquilinoEmail) {
		this.inquilinoEmail = inquilinoEmail;
	}

	public String getInquilinoDireccionCorrespondencia() {
		return inquilinoDireccionCorrespondencia;
	}

	public void setInquilinoDireccionCorrespondencia(String inquilinoDireccionCorrespondencia) {
		this.inquilinoDireccionCorrespondencia = inquilinoDireccionCorrespondencia;
	}

	public String getInquilinoPerfil() {
		return inquilinoPerfil;
	}

	public void setInquilinoPerfil(String inquilinoPerfil) {
		this.inquilinoPerfil = inquilinoPerfil;
	}

	public String getInquilinoEstado() {
		return inquilinoEstado;
	}

	public void setInquilinoEstado(String inquilinoEstado) {
		this.inquilinoEstado = inquilinoEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result
				+ ((inquilinoDireccionCorrespondencia == null) ? 0 : inquilinoDireccionCorrespondencia.hashCode());
		result = prime * result + ((inquilinoEmail == null) ? 0 : inquilinoEmail.hashCode());
		result = prime * result + ((inquilinoEstado == null) ? 0 : inquilinoEstado.hashCode());
		result = prime * result + inquilinoId;
		result = prime * result + ((inquilinoNombres == null) ? 0 : inquilinoNombres.hashCode());
		result = prime * result + ((inquilinoNumeroCelular == null) ? 0 : inquilinoNumeroCelular.hashCode());
		result = prime * result + ((inquilinoNumeroDocumento == null) ? 0 : inquilinoNumeroDocumento.hashCode());
		result = prime * result + ((inquilinoPerfil == null) ? 0 : inquilinoPerfil.hashCode());
		result = prime * result + ((inquilinoTelefono == null) ? 0 : inquilinoTelefono.hashCode());
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
		Inquilino other = (Inquilino) obj;
		if (copNit != other.copNit)
			return false;
		if (inquilinoDireccionCorrespondencia == null) {
			if (other.inquilinoDireccionCorrespondencia != null)
				return false;
		} else if (!inquilinoDireccionCorrespondencia.equals(other.inquilinoDireccionCorrespondencia))
			return false;
		if (inquilinoEmail == null) {
			if (other.inquilinoEmail != null)
				return false;
		} else if (!inquilinoEmail.equals(other.inquilinoEmail))
			return false;
		if (inquilinoEstado == null) {
			if (other.inquilinoEstado != null)
				return false;
		} else if (!inquilinoEstado.equals(other.inquilinoEstado))
			return false;
		if (inquilinoId != other.inquilinoId)
			return false;
		if (inquilinoNombres == null) {
			if (other.inquilinoNombres != null)
				return false;
		} else if (!inquilinoNombres.equals(other.inquilinoNombres))
			return false;
		if (inquilinoNumeroCelular == null) {
			if (other.inquilinoNumeroCelular != null)
				return false;
		} else if (!inquilinoNumeroCelular.equals(other.inquilinoNumeroCelular))
			return false;
		if (inquilinoNumeroDocumento == null) {
			if (other.inquilinoNumeroDocumento != null)
				return false;
		} else if (!inquilinoNumeroDocumento.equals(other.inquilinoNumeroDocumento))
			return false;
		if (inquilinoPerfil == null) {
			if (other.inquilinoPerfil != null)
				return false;
		} else if (!inquilinoPerfil.equals(other.inquilinoPerfil))
			return false;
		if (inquilinoTelefono == null) {
			if (other.inquilinoTelefono != null)
				return false;
		} else if (!inquilinoTelefono.equals(other.inquilinoTelefono))
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
		return "Inquilino [inquilinoId=" + inquilinoId + ", copNit=" + copNit + ", proNumeroResidencia="
				+ proNumeroResidencia + ", inquilinoNumeroDocumento=" + inquilinoNumeroDocumento + ", inquilinoNombres="
				+ inquilinoNombres + ", inquilinoNumeroCelular=" + inquilinoNumeroCelular + ", inquilinoTelefono="
				+ inquilinoTelefono + ", inquilinoEmail=" + inquilinoEmail + ", inquilinoDireccionCorrespondencia="
				+ inquilinoDireccionCorrespondencia + ", inquilinoPerfil=" + inquilinoPerfil + ", inquilinoEstado="
				+ inquilinoEstado + "]";
	}
}
