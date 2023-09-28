package co.com.sisapco.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class DatosGenerales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8598405990535435601L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int datosperId;
	
	@Column
	private int copNit;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String datosperNumeroDocumento;
	
	@Column
	private String datosperNombres;
	
	@Column
	private String datosperApellidos;
	
	@Column
	private String datosperTelefono;
	
	@Column
	private String datosperCelular;
	
	@Column
	private String datosperEmail;
	
	@Column
	private String datosperDireccionCorrespondencia;
	
	@Column
	private String datosperEstado;
	
	@Column
	private String datosperPropietario;
	
	@Column
	private String datosperObservaciones;
	
	@Column
	private String datosperTipoResidente;
	
	@Column
	private String datosperHabitante;
	
	@Column
	private String datosperVehiculo;
	
	@Column
	private String datosperMastoca;
	
	@Column
	private String datosperLog;

	public int getDatosperId() {
		return datosperId;
	}

	public void setDatosperId(int datosperId) {
		this.datosperId = datosperId;
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

	public String getDatosperNumeroDocumento() {
		return datosperNumeroDocumento;
	}

	public void setDatosperNumeroDocumento(String datosperNumeroDocumento) {
		this.datosperNumeroDocumento = datosperNumeroDocumento;
	}

	public String getDatosperNombres() {
		return datosperNombres;
	}

	public void setDatosperNombres(String datosperNombres) {
		this.datosperNombres = datosperNombres;
	}

	public String getDatosperApellidos() {
		return datosperApellidos;
	}

	public void setDatosperApellidos(String datosperApellidos) {
		this.datosperApellidos = datosperApellidos;
	}

	public String getDatosperTelefono() {
		return datosperTelefono;
	}

	public void setDatosperTelefono(String datosperTelefono) {
		this.datosperTelefono = datosperTelefono;
	}

	public String getDatosperCelular() {
		return datosperCelular;
	}

	public void setDatosperCelular(String datosperCelular) {
		this.datosperCelular = datosperCelular;
	}

	public String getDatosperEmail() {
		return datosperEmail;
	}

	public void setDatosperEmail(String datosperEmail) {
		this.datosperEmail = datosperEmail;
	}

	public String getDatosperDireccionCorrespondencia() {
		return datosperDireccionCorrespondencia;
	}

	public void setDatosperDireccionCorrespondencia(String datosperDireccionCorrespondencia) {
		this.datosperDireccionCorrespondencia = datosperDireccionCorrespondencia;
	}

	public String getDatosperEstado() {
		return datosperEstado;
	}

	public void setDatosperEstado(String datosperEstado) {
		this.datosperEstado = datosperEstado;
	}

	public String getDatosperPropietario() {
		return datosperPropietario;
	}

	public void setDatosperPropietario(String datosperPropietario) {
		this.datosperPropietario = datosperPropietario;
	}

	public String getDatosperObservaciones() {
		return datosperObservaciones;
	}

	public void setDatosperObservaciones(String datosperObservaciones) {
		this.datosperObservaciones = datosperObservaciones;
	}

	public String getDatosperTipoResidente() {
		return datosperTipoResidente;
	}

	public void setDatosperTipoResidente(String datosperTipoResidente) {
		this.datosperTipoResidente = datosperTipoResidente;
	}

	public String getDatosperHabitante() {
		return datosperHabitante;
	}

	public void setDatosperHabitante(String datosperHabitante) {
		this.datosperHabitante = datosperHabitante;
	}

	public String getDatosperVehiculo() {
		return datosperVehiculo;
	}

	public void setDatosperVehiculo(String datosperVehiculo) {
		this.datosperVehiculo = datosperVehiculo;
	}

	public String getDatosperMastoca() {
		return datosperMastoca;
	}

	public void setDatosperMastoca(String datosperMastoca) {
		this.datosperMastoca = datosperMastoca;
	}

	public String getDatosperLog() {
		return datosperLog;
	}

	public void setDatosperLog(String datosperLog) {
		this.datosperLog = datosperLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((datosperApellidos == null) ? 0 : datosperApellidos.hashCode());
		result = prime * result + ((datosperCelular == null) ? 0 : datosperCelular.hashCode());
		result = prime * result
				+ ((datosperDireccionCorrespondencia == null) ? 0 : datosperDireccionCorrespondencia.hashCode());
		result = prime * result + ((datosperEmail == null) ? 0 : datosperEmail.hashCode());
		result = prime * result + ((datosperEstado == null) ? 0 : datosperEstado.hashCode());
		result = prime * result + ((datosperHabitante == null) ? 0 : datosperHabitante.hashCode());
		result = prime * result + datosperId;
		result = prime * result + ((datosperLog == null) ? 0 : datosperLog.hashCode());
		result = prime * result + ((datosperMastoca == null) ? 0 : datosperMastoca.hashCode());
		result = prime * result + ((datosperNombres == null) ? 0 : datosperNombres.hashCode());
		result = prime * result + ((datosperNumeroDocumento == null) ? 0 : datosperNumeroDocumento.hashCode());
		result = prime * result + ((datosperObservaciones == null) ? 0 : datosperObservaciones.hashCode());
		result = prime * result + ((datosperPropietario == null) ? 0 : datosperPropietario.hashCode());
		result = prime * result + ((datosperTelefono == null) ? 0 : datosperTelefono.hashCode());
		result = prime * result + ((datosperTipoResidente == null) ? 0 : datosperTipoResidente.hashCode());
		result = prime * result + ((datosperVehiculo == null) ? 0 : datosperVehiculo.hashCode());
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
		DatosGenerales other = (DatosGenerales) obj;
		if (copNit != other.copNit)
			return false;
		if (datosperApellidos == null) {
			if (other.datosperApellidos != null)
				return false;
		} else if (!datosperApellidos.equals(other.datosperApellidos))
			return false;
		if (datosperCelular == null) {
			if (other.datosperCelular != null)
				return false;
		} else if (!datosperCelular.equals(other.datosperCelular))
			return false;
		if (datosperDireccionCorrespondencia == null) {
			if (other.datosperDireccionCorrespondencia != null)
				return false;
		} else if (!datosperDireccionCorrespondencia.equals(other.datosperDireccionCorrespondencia))
			return false;
		if (datosperEmail == null) {
			if (other.datosperEmail != null)
				return false;
		} else if (!datosperEmail.equals(other.datosperEmail))
			return false;
		if (datosperEstado == null) {
			if (other.datosperEstado != null)
				return false;
		} else if (!datosperEstado.equals(other.datosperEstado))
			return false;
		if (datosperHabitante == null) {
			if (other.datosperHabitante != null)
				return false;
		} else if (!datosperHabitante.equals(other.datosperHabitante))
			return false;
		if (datosperId != other.datosperId)
			return false;
		if (datosperLog == null) {
			if (other.datosperLog != null)
				return false;
		} else if (!datosperLog.equals(other.datosperLog))
			return false;
		if (datosperMastoca == null) {
			if (other.datosperMastoca != null)
				return false;
		} else if (!datosperMastoca.equals(other.datosperMastoca))
			return false;
		if (datosperNombres == null) {
			if (other.datosperNombres != null)
				return false;
		} else if (!datosperNombres.equals(other.datosperNombres))
			return false;
		if (datosperNumeroDocumento == null) {
			if (other.datosperNumeroDocumento != null)
				return false;
		} else if (!datosperNumeroDocumento.equals(other.datosperNumeroDocumento))
			return false;
		if (datosperObservaciones == null) {
			if (other.datosperObservaciones != null)
				return false;
		} else if (!datosperObservaciones.equals(other.datosperObservaciones))
			return false;
		if (datosperPropietario == null) {
			if (other.datosperPropietario != null)
				return false;
		} else if (!datosperPropietario.equals(other.datosperPropietario))
			return false;
		if (datosperTelefono == null) {
			if (other.datosperTelefono != null)
				return false;
		} else if (!datosperTelefono.equals(other.datosperTelefono))
			return false;
		if (datosperTipoResidente == null) {
			if (other.datosperTipoResidente != null)
				return false;
		} else if (!datosperTipoResidente.equals(other.datosperTipoResidente))
			return false;
		if (datosperVehiculo == null) {
			if (other.datosperVehiculo != null)
				return false;
		} else if (!datosperVehiculo.equals(other.datosperVehiculo))
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
		return "DatosGenerales [datosperId=" + datosperId + ", copNit=" + copNit + ", proNumeroResidencia="
				+ proNumeroResidencia + ", datosperNumeroDocumento=" + datosperNumeroDocumento + ", datosperNombres="
				+ datosperNombres + ", datosperApellidos=" + datosperApellidos + ", datosperTelefono="
				+ datosperTelefono + ", datosperCelular=" + datosperCelular + ", datosperEmail=" + datosperEmail
				+ ", datosperDireccionCorrespondencia=" + datosperDireccionCorrespondencia + ", datosperEstado="
				+ datosperEstado + ", datosperPropietario=" + datosperPropietario + ", datosperObservaciones="
				+ datosperObservaciones + ", datosperTipoResidente=" + datosperTipoResidente + ", datosperHabitante="
				+ datosperHabitante + ", datosperVehiculo=" + datosperVehiculo + ", datosperMastoca=" + datosperMastoca
				+ ", datosperLog=" + datosperLog + "]";
	}

	
	
	

	

}
