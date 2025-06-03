<<<<<<< HEAD
package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class PropietariosAdministrador implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 7513840656102770287L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int proId;
	@Column
	private int copNit;
	
	@Column
	private int proCc;
	@Column
	private String proNumeroResidencia;
	@Column
	private String proNombres;
	@Column
	private String proApellidos;
	@Column
	private String proTelefono;
	@Column
	private String proEmail;
	@Column
	private String proMatricula;
	@Column
	private String proCelular;
	@Column
	private String proArea;
	@Column
	private String proCoeficiente;
	@Column
	private int proNumeroResidentes; 
	@Column
	private int proNumeroVehiculos; 
	@Column
	private int proEstado;
	@Column
	private String proDireccionCorrespondencia;
	@Column
	private String proResidente;
	@Column
	private String proObservaciones;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
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
	public String getProNombres() {
		return proNombres;
	}
	public void setProNombres(String proNombres) {
		this.proNombres = proNombres;
	}
	public String getProApellidos() {
		return proApellidos;
	}
	public void setProApellidos(String proApellidos) {
		this.proApellidos = proApellidos;
	}
	public String getProTelefono() {
		return proTelefono;
	}
	public void setProTelefono(String proTelefono) {
		this.proTelefono = proTelefono;
	}
	public String getProEmail() {
		return proEmail;
	}
	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}
	public String getProMatricula() {
		return proMatricula;
	}
	public void setProMatricula(String proMatricula) {
		this.proMatricula = proMatricula;
	}
	public String getProCelular() {
		return proCelular;
	}
	public void setProCelular(String proCelular) {
		this.proCelular = proCelular;
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
	public int getProNumeroResidentes() {
		return proNumeroResidentes;
	}
	public void setProNumeroResidentes(int proNumeroResidentes) {
		this.proNumeroResidentes = proNumeroResidentes;
	}
	public int getProNumeroVehiculos() {
		return proNumeroVehiculos;
	}
	public void setProNumeroVehiculos(int proNumeroVehiculos) {
		this.proNumeroVehiculos = proNumeroVehiculos;
	}
	public int getProEstado() {
		return proEstado;
	}
	public void setProEstado(int proEstado) {
		this.proEstado = proEstado;
	}
	public String getProDireccionCorrespondencia() {
		return proDireccionCorrespondencia;
	}
	public void setProDireccionCorrespondencia(String proDireccionCorrespondencia) {
		this.proDireccionCorrespondencia = proDireccionCorrespondencia;
	}
	public String getProResidente() {
		return proResidente;
	}
	public void setProResidente(String proResidente) {
		this.proResidente = proResidente;
	}
	public String getProObservaciones() {
		return proObservaciones;
	}
	public void setProObservaciones(String proObservaciones) {
		this.proObservaciones = proObservaciones;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((proApellidos == null) ? 0 : proApellidos.hashCode());
		result = prime * result + ((proArea == null) ? 0 : proArea.hashCode());
		result = prime * result + proCc;
		result = prime * result + ((proCelular == null) ? 0 : proCelular.hashCode());
		result = prime * result + ((proCoeficiente == null) ? 0 : proCoeficiente.hashCode());
		result = prime * result + ((proDireccionCorrespondencia == null) ? 0 : proDireccionCorrespondencia.hashCode());
		result = prime * result + ((proEmail == null) ? 0 : proEmail.hashCode());
		result = prime * result + proEstado;
		result = prime * result + proId;
		result = prime * result + ((proMatricula == null) ? 0 : proMatricula.hashCode());
		result = prime * result + ((proNombres == null) ? 0 : proNombres.hashCode());
		result = prime * result + ((proNumeroResidencia == null) ? 0 : proNumeroResidencia.hashCode());
		result = prime * result + proNumeroResidentes;
		result = prime * result + proNumeroVehiculos;
		result = prime * result + ((proObservaciones == null) ? 0 : proObservaciones.hashCode());
		result = prime * result + ((proResidente == null) ? 0 : proResidente.hashCode());
		result = prime * result + ((proTelefono == null) ? 0 : proTelefono.hashCode());
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
		PropietariosAdministrador other = (PropietariosAdministrador) obj;
		if (copNit != other.copNit)
			return false;
		if (proApellidos == null) {
			if (other.proApellidos != null)
				return false;
		} else if (!proApellidos.equals(other.proApellidos))
			return false;
		if (proArea == null) {
			if (other.proArea != null)
				return false;
		} else if (!proArea.equals(other.proArea))
			return false;
		if (proCc != other.proCc)
			return false;
		if (proCelular == null) {
			if (other.proCelular != null)
				return false;
		} else if (!proCelular.equals(other.proCelular))
			return false;
		if (proCoeficiente == null) {
			if (other.proCoeficiente != null)
				return false;
		} else if (!proCoeficiente.equals(other.proCoeficiente))
			return false;
		if (proDireccionCorrespondencia == null) {
			if (other.proDireccionCorrespondencia != null)
				return false;
		} else if (!proDireccionCorrespondencia.equals(other.proDireccionCorrespondencia))
			return false;
		if (proEmail == null) {
			if (other.proEmail != null)
				return false;
		} else if (!proEmail.equals(other.proEmail))
			return false;
		if (proEstado != other.proEstado)
			return false;
		if (proId != other.proId)
			return false;
		if (proMatricula == null) {
			if (other.proMatricula != null)
				return false;
		} else if (!proMatricula.equals(other.proMatricula))
			return false;
		if (proNombres == null) {
			if (other.proNombres != null)
				return false;
		} else if (!proNombres.equals(other.proNombres))
			return false;
		if (proNumeroResidencia == null) {
			if (other.proNumeroResidencia != null)
				return false;
		} else if (!proNumeroResidencia.equals(other.proNumeroResidencia))
			return false;
		if (proNumeroResidentes != other.proNumeroResidentes)
			return false;
		if (proNumeroVehiculos != other.proNumeroVehiculos)
			return false;
		if (proObservaciones == null) {
			if (other.proObservaciones != null)
				return false;
		} else if (!proObservaciones.equals(other.proObservaciones))
			return false;
		if (proResidente == null) {
			if (other.proResidente != null)
				return false;
		} else if (!proResidente.equals(other.proResidente))
			return false;
		if (proTelefono == null) {
			if (other.proTelefono != null)
				return false;
		} else if (!proTelefono.equals(other.proTelefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PropietariosAdministrador [proId=" + proId + ", copNit=" + copNit + ", proCc=" + proCc
				+ ", proNumeroResidencia=" + proNumeroResidencia + ", proNombres=" + proNombres + ", proApellidos="
				+ proApellidos + ", proTelefono=" + proTelefono + ", proEmail=" + proEmail + ", proMatricula="
				+ proMatricula + ", proCelular=" + proCelular + ", proArea=" + proArea + ", proCoeficiente="
				+ proCoeficiente + ", proNumeroResidentes=" + proNumeroResidentes + ", proNumeroVehiculos="
				+ proNumeroVehiculos + ", proEstado=" + proEstado + ", proDireccionCorrespondencia="
				+ proDireccionCorrespondencia + ", proResidente=" + proResidente + ", proObservaciones="
				+ proObservaciones + "]";
	}
	

}
=======
package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class PropietariosAdministrador implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 7513840656102770287L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int proId;
	@Column
	private int copNit;
	
	@Column
	private int proCc;
	@Column
	private String proNumeroResidencia;
	@Column
	private String proNombres;
	@Column
	private String proApellidos;
	@Column
	private String proTelefono;
	@Column
	private String proEmail;
	@Column
	private String proMatricula;
	@Column
	private String proCelular;
	@Column
	private String proArea;
	@Column
	private String proCoeficiente;
	@Column
	private int proNumeroResidentes; 
	@Column
	private int proNumeroVehiculos; 
	@Column
	private int proEstado;
	@Column
	private String proDireccionCorrespondencia;
	@Column
	private String proResidente;
	@Column
	private String proObservaciones;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
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
	public String getProNombres() {
		return proNombres;
	}
	public void setProNombres(String proNombres) {
		this.proNombres = proNombres;
	}
	public String getProApellidos() {
		return proApellidos;
	}
	public void setProApellidos(String proApellidos) {
		this.proApellidos = proApellidos;
	}
	public String getProTelefono() {
		return proTelefono;
	}
	public void setProTelefono(String proTelefono) {
		this.proTelefono = proTelefono;
	}
	public String getProEmail() {
		return proEmail;
	}
	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}
	public String getProMatricula() {
		return proMatricula;
	}
	public void setProMatricula(String proMatricula) {
		this.proMatricula = proMatricula;
	}
	public String getProCelular() {
		return proCelular;
	}
	public void setProCelular(String proCelular) {
		this.proCelular = proCelular;
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
	public int getProNumeroResidentes() {
		return proNumeroResidentes;
	}
	public void setProNumeroResidentes(int proNumeroResidentes) {
		this.proNumeroResidentes = proNumeroResidentes;
	}
	public int getProNumeroVehiculos() {
		return proNumeroVehiculos;
	}
	public void setProNumeroVehiculos(int proNumeroVehiculos) {
		this.proNumeroVehiculos = proNumeroVehiculos;
	}
	public int getProEstado() {
		return proEstado;
	}
	public void setProEstado(int proEstado) {
		this.proEstado = proEstado;
	}
	public String getProDireccionCorrespondencia() {
		return proDireccionCorrespondencia;
	}
	public void setProDireccionCorrespondencia(String proDireccionCorrespondencia) {
		this.proDireccionCorrespondencia = proDireccionCorrespondencia;
	}
	public String getProResidente() {
		return proResidente;
	}
	public void setProResidente(String proResidente) {
		this.proResidente = proResidente;
	}
	public String getProObservaciones() {
		return proObservaciones;
	}
	public void setProObservaciones(String proObservaciones) {
		this.proObservaciones = proObservaciones;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((proApellidos == null) ? 0 : proApellidos.hashCode());
		result = prime * result + ((proArea == null) ? 0 : proArea.hashCode());
		result = prime * result + proCc;
		result = prime * result + ((proCelular == null) ? 0 : proCelular.hashCode());
		result = prime * result + ((proCoeficiente == null) ? 0 : proCoeficiente.hashCode());
		result = prime * result + ((proDireccionCorrespondencia == null) ? 0 : proDireccionCorrespondencia.hashCode());
		result = prime * result + ((proEmail == null) ? 0 : proEmail.hashCode());
		result = prime * result + proEstado;
		result = prime * result + proId;
		result = prime * result + ((proMatricula == null) ? 0 : proMatricula.hashCode());
		result = prime * result + ((proNombres == null) ? 0 : proNombres.hashCode());
		result = prime * result + ((proNumeroResidencia == null) ? 0 : proNumeroResidencia.hashCode());
		result = prime * result + proNumeroResidentes;
		result = prime * result + proNumeroVehiculos;
		result = prime * result + ((proObservaciones == null) ? 0 : proObservaciones.hashCode());
		result = prime * result + ((proResidente == null) ? 0 : proResidente.hashCode());
		result = prime * result + ((proTelefono == null) ? 0 : proTelefono.hashCode());
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
		PropietariosAdministrador other = (PropietariosAdministrador) obj;
		if (copNit != other.copNit)
			return false;
		if (proApellidos == null) {
			if (other.proApellidos != null)
				return false;
		} else if (!proApellidos.equals(other.proApellidos))
			return false;
		if (proArea == null) {
			if (other.proArea != null)
				return false;
		} else if (!proArea.equals(other.proArea))
			return false;
		if (proCc != other.proCc)
			return false;
		if (proCelular == null) {
			if (other.proCelular != null)
				return false;
		} else if (!proCelular.equals(other.proCelular))
			return false;
		if (proCoeficiente == null) {
			if (other.proCoeficiente != null)
				return false;
		} else if (!proCoeficiente.equals(other.proCoeficiente))
			return false;
		if (proDireccionCorrespondencia == null) {
			if (other.proDireccionCorrespondencia != null)
				return false;
		} else if (!proDireccionCorrespondencia.equals(other.proDireccionCorrespondencia))
			return false;
		if (proEmail == null) {
			if (other.proEmail != null)
				return false;
		} else if (!proEmail.equals(other.proEmail))
			return false;
		if (proEstado != other.proEstado)
			return false;
		if (proId != other.proId)
			return false;
		if (proMatricula == null) {
			if (other.proMatricula != null)
				return false;
		} else if (!proMatricula.equals(other.proMatricula))
			return false;
		if (proNombres == null) {
			if (other.proNombres != null)
				return false;
		} else if (!proNombres.equals(other.proNombres))
			return false;
		if (proNumeroResidencia == null) {
			if (other.proNumeroResidencia != null)
				return false;
		} else if (!proNumeroResidencia.equals(other.proNumeroResidencia))
			return false;
		if (proNumeroResidentes != other.proNumeroResidentes)
			return false;
		if (proNumeroVehiculos != other.proNumeroVehiculos)
			return false;
		if (proObservaciones == null) {
			if (other.proObservaciones != null)
				return false;
		} else if (!proObservaciones.equals(other.proObservaciones))
			return false;
		if (proResidente == null) {
			if (other.proResidente != null)
				return false;
		} else if (!proResidente.equals(other.proResidente))
			return false;
		if (proTelefono == null) {
			if (other.proTelefono != null)
				return false;
		} else if (!proTelefono.equals(other.proTelefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PropietariosAdministrador [proId=" + proId + ", copNit=" + copNit + ", proCc=" + proCc
				+ ", proNumeroResidencia=" + proNumeroResidencia + ", proNombres=" + proNombres + ", proApellidos="
				+ proApellidos + ", proTelefono=" + proTelefono + ", proEmail=" + proEmail + ", proMatricula="
				+ proMatricula + ", proCelular=" + proCelular + ", proArea=" + proArea + ", proCoeficiente="
				+ proCoeficiente + ", proNumeroResidentes=" + proNumeroResidentes + ", proNumeroVehiculos="
				+ proNumeroVehiculos + ", proEstado=" + proEstado + ", proDireccionCorrespondencia="
				+ proDireccionCorrespondencia + ", proResidente=" + proResidente + ", proObservaciones="
				+ proObservaciones + "]";
	}
	

}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
