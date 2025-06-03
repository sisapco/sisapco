package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ContactoEmergencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6880416599677209594L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int emergenciaId;
	
	@Column
	private int copNit;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private int emergenciaNumeroDocumento;
	
	@Column
	private String emergenciaNombres;
	
	@Column
	private String emergenciaApellidos;
	
	@Column
	private String emergenciaNumeroCelular;
	
	@Column
	private String emergenciaEmail;
	
	@Column
	private String emergenciaEstado;
	
	@Column
	private String emergenciaPerfil;
	
	@Column
	private String comuFecha;

	public int getEmergenciaId() {
		return emergenciaId;
	}

	public void setEmergenciaId(int emergenciaId) {
		this.emergenciaId = emergenciaId;
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

	public int getEmergenciaNumeroDocumento() {
		return emergenciaNumeroDocumento;
	}

	public void setEmergenciaNumeroDocumento(int emergenciaNumeroDocumento) {
		this.emergenciaNumeroDocumento = emergenciaNumeroDocumento;
	}

	public String getEmergenciaNombres() {
		return emergenciaNombres;
	}

	public void setEmergenciaNombres(String emergenciaNombres) {
		this.emergenciaNombres = emergenciaNombres;
	}

	public String getEmergenciaApellidos() {
		return emergenciaApellidos;
	}

	public void setEmergenciaApellidos(String emergenciaApellidos) {
		this.emergenciaApellidos = emergenciaApellidos;
	}

	public String getEmergenciaNumeroCelular() {
		return emergenciaNumeroCelular;
	}

	public void setEmergenciaNumeroCelular(String emergenciaNumeroCelular) {
		this.emergenciaNumeroCelular = emergenciaNumeroCelular;
	}

	public String getEmergenciaEmail() {
		return emergenciaEmail;
	}

	public void setEmergenciaEmail(String emergenciaEmail) {
		this.emergenciaEmail = emergenciaEmail;
	}

	public String getEmergenciaEstado() {
		return emergenciaEstado;
	}

	public void setEmergenciaEstado(String emergenciaEstado) {
		this.emergenciaEstado = emergenciaEstado;
	}

	public String getEmergenciaPerfil() {
		return emergenciaPerfil;
	}

	public void setEmergenciaPerfil(String emergenciaPerfil) {
		this.emergenciaPerfil = emergenciaPerfil;
	}

	public String getComuFecha() {
		return comuFecha;
	}

	public void setComuFecha(String comuFecha) {
		this.comuFecha = comuFecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comuFecha == null) ? 0 : comuFecha.hashCode());
		result = prime * result + copNit;
		result = prime * result + ((emergenciaApellidos == null) ? 0 : emergenciaApellidos.hashCode());
		result = prime * result + ((emergenciaEmail == null) ? 0 : emergenciaEmail.hashCode());
		result = prime * result + ((emergenciaEstado == null) ? 0 : emergenciaEstado.hashCode());
		result = prime * result + emergenciaId;
		result = prime * result + ((emergenciaNombres == null) ? 0 : emergenciaNombres.hashCode());
		result = prime * result + ((emergenciaNumeroCelular == null) ? 0 : emergenciaNumeroCelular.hashCode());
		result = prime * result + emergenciaNumeroDocumento;
		result = prime * result + ((emergenciaPerfil == null) ? 0 : emergenciaPerfil.hashCode());
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
		ContactoEmergencia other = (ContactoEmergencia) obj;
		if (comuFecha == null) {
			if (other.comuFecha != null)
				return false;
		} else if (!comuFecha.equals(other.comuFecha))
			return false;
		if (copNit != other.copNit)
			return false;
		if (emergenciaApellidos == null) {
			if (other.emergenciaApellidos != null)
				return false;
		} else if (!emergenciaApellidos.equals(other.emergenciaApellidos))
			return false;
		if (emergenciaEmail == null) {
			if (other.emergenciaEmail != null)
				return false;
		} else if (!emergenciaEmail.equals(other.emergenciaEmail))
			return false;
		if (emergenciaEstado == null) {
			if (other.emergenciaEstado != null)
				return false;
		} else if (!emergenciaEstado.equals(other.emergenciaEstado))
			return false;
		if (emergenciaId != other.emergenciaId)
			return false;
		if (emergenciaNombres == null) {
			if (other.emergenciaNombres != null)
				return false;
		} else if (!emergenciaNombres.equals(other.emergenciaNombres))
			return false;
		if (emergenciaNumeroCelular == null) {
			if (other.emergenciaNumeroCelular != null)
				return false;
		} else if (!emergenciaNumeroCelular.equals(other.emergenciaNumeroCelular))
			return false;
		if (emergenciaNumeroDocumento != other.emergenciaNumeroDocumento)
			return false;
		if (emergenciaPerfil == null) {
			if (other.emergenciaPerfil != null)
				return false;
		} else if (!emergenciaPerfil.equals(other.emergenciaPerfil))
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
		return "ContactoEmergencia [emergenciaId=" + emergenciaId + ", copNit=" + copNit + ", proNumeroResidencia="
				+ proNumeroResidencia + ", emergenciaNumeroDocumento=" + emergenciaNumeroDocumento
				+ ", emergenciaNombres=" + emergenciaNombres + ", emergenciaApellidos=" + emergenciaApellidos
				+ ", emergenciaNumeroCelular=" + emergenciaNumeroCelular + ", emergenciaEmail=" + emergenciaEmail
				+ ", emergenciaEstado=" + emergenciaEstado + ", emergenciaPerfil=" + emergenciaPerfil + ", comuFecha="
				+ comuFecha + "]";
	}
}
