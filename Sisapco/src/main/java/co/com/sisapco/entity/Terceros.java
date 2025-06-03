package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Terceros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 871130814598227945L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int terceId;
	
	@Column
	private int copNit;
	
	@Column
	private int tercePerfil;
	
	@Column
	private String terceNumeroDocumento;
	
	@Column
	private String terceNombres;
	
	@Column
	private String terceApellidos;
	
	@Column
	private String terceNumeroCelular;
	
	@Column
	private String terceTelefono;
	
	@Column
	private String terceEmail;
	
	@Column
	private String terceDireccionCorrespondencia;
	
	@Column
	private String terceObservaciones;

	public int getTerceId() {
		return terceId;
	}

	public void setTerceId(int terceId) {
		this.terceId = terceId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public int getTercePerfil() {
		return tercePerfil;
	}

	public void setTercePerfil(int tercePerfil) {
		this.tercePerfil = tercePerfil;
	}

	public String getTerceNumeroDocumento() {
		return terceNumeroDocumento;
	}

	public void setTerceNumeroDocumento(String terceNumeroDocumento) {
		this.terceNumeroDocumento = terceNumeroDocumento;
	}

	public String getTerceNombres() {
		return terceNombres;
	}

	public void setTerceNombres(String terceNombres) {
		this.terceNombres = terceNombres;
	}

	public String getTerceApellidos() {
		return terceApellidos;
	}

	public void setTerceApellidos(String terceApellidos) {
		this.terceApellidos = terceApellidos;
	}

	public String getTerceNumeroCelular() {
		return terceNumeroCelular;
	}

	public void setTerceNumeroCelular(String terceNumeroCelular) {
		this.terceNumeroCelular = terceNumeroCelular;
	}

	public String getTerceTelefono() {
		return terceTelefono;
	}

	public void setTerceTelefono(String terceTelefono) {
		this.terceTelefono = terceTelefono;
	}

	public String getTerceEmail() {
		return terceEmail;
	}

	public void setTerceEmail(String terceEmail) {
		this.terceEmail = terceEmail;
	}

	public String getTerceDireccionCorrespondencia() {
		return terceDireccionCorrespondencia;
	}

	public void setTerceDireccionCorrespondencia(String terceDireccionCorrespondencia) {
		this.terceDireccionCorrespondencia = terceDireccionCorrespondencia;
	}

	public String getTerceObservaciones() {
		return terceObservaciones;
	}

	public void setTerceObservaciones(String terceObservaciones) {
		this.terceObservaciones = terceObservaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((terceApellidos == null) ? 0 : terceApellidos.hashCode());
		result = prime * result
				+ ((terceDireccionCorrespondencia == null) ? 0 : terceDireccionCorrespondencia.hashCode());
		result = prime * result + ((terceEmail == null) ? 0 : terceEmail.hashCode());
		result = prime * result + terceId;
		result = prime * result + ((terceNombres == null) ? 0 : terceNombres.hashCode());
		result = prime * result + ((terceNumeroCelular == null) ? 0 : terceNumeroCelular.hashCode());
		result = prime * result + ((terceNumeroDocumento == null) ? 0 : terceNumeroDocumento.hashCode());
		result = prime * result + ((terceObservaciones == null) ? 0 : terceObservaciones.hashCode());
		result = prime * result + tercePerfil;
		result = prime * result + ((terceTelefono == null) ? 0 : terceTelefono.hashCode());
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
		Terceros other = (Terceros) obj;
		if (copNit != other.copNit)
			return false;
		if (terceApellidos == null) {
			if (other.terceApellidos != null)
				return false;
		} else if (!terceApellidos.equals(other.terceApellidos))
			return false;
		if (terceDireccionCorrespondencia == null) {
			if (other.terceDireccionCorrespondencia != null)
				return false;
		} else if (!terceDireccionCorrespondencia.equals(other.terceDireccionCorrespondencia))
			return false;
		if (terceEmail == null) {
			if (other.terceEmail != null)
				return false;
		} else if (!terceEmail.equals(other.terceEmail))
			return false;
		if (terceId != other.terceId)
			return false;
		if (terceNombres == null) {
			if (other.terceNombres != null)
				return false;
		} else if (!terceNombres.equals(other.terceNombres))
			return false;
		if (terceNumeroCelular == null) {
			if (other.terceNumeroCelular != null)
				return false;
		} else if (!terceNumeroCelular.equals(other.terceNumeroCelular))
			return false;
		if (terceNumeroDocumento == null) {
			if (other.terceNumeroDocumento != null)
				return false;
		} else if (!terceNumeroDocumento.equals(other.terceNumeroDocumento))
			return false;
		if (terceObservaciones == null) {
			if (other.terceObservaciones != null)
				return false;
		} else if (!terceObservaciones.equals(other.terceObservaciones))
			return false;
		if (tercePerfil != other.tercePerfil)
			return false;
		if (terceTelefono == null) {
			if (other.terceTelefono != null)
				return false;
		} else if (!terceTelefono.equals(other.terceTelefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Terceros [terceId=" + terceId + ", copNit=" + copNit + ", tercePerfil=" + tercePerfil
				+ ", terceNumeroDocumento=" + terceNumeroDocumento + ", terceNombres=" + terceNombres
				+ ", terceApellidos=" + terceApellidos + ", terceNumeroCelular=" + terceNumeroCelular
				+ ", terceTelefono=" + terceTelefono + ", terceEmail=" + terceEmail + ", terceDireccionCorrespondencia="
				+ terceDireccionCorrespondencia + ", terceObservaciones=" + terceObservaciones + "]";
	}
}
