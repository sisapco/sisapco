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
public class Pqrs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5089968683378695350L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int idPqrs;
	
	@Column
	private int copNit;
	
	@Column
	private int proCc;
	
	@Column
	private String proNombres;
	
	@Column
	private String proApellidos;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String pqrsEmail;
	
	@Column
	private String pqrsTelefono;
	
	@Column
	private String pqrsDireccionCorrespondecia;
	
	@Column
	private String pqrsDescripcionPqrs;
	
	@Column
	private String pqrsEstado;
	
	@Column
	private String pqrsAdjunto;
	
	@Column
	private String pqrsFechaCreacion;
	
	@Column
	private String pqrsFechaRespuesta;
	
	@Column
	private String pqrsLogs;
	
	@Column
	private String pqrsVisualizacion;
	
	@Column
	private String pqrsRespuestaPqrs;
	
	@Column
	private String pqrsAdjuntoRespuesta;

	public int getIdPqrs() {
		return idPqrs;
	}

	public void setIdPqrs(int idPqrs) {
		this.idPqrs = idPqrs;
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

	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public String getPqrsEmail() {
		return pqrsEmail;
	}

	public void setPqrsEmail(String pqrsEmail) {
		this.pqrsEmail = pqrsEmail;
	}

	public String getPqrsTelefono() {
		return pqrsTelefono;
	}

	public void setPqrsTelefono(String pqrsTelefono) {
		this.pqrsTelefono = pqrsTelefono;
	}

	public String getPqrsDireccionCorrespondecia() {
		return pqrsDireccionCorrespondecia;
	}

	public void setPqrsDireccionCorrespondecia(String pqrsDireccionCorrespondecia) {
		this.pqrsDireccionCorrespondecia = pqrsDireccionCorrespondecia;
	}

	public String getPqrsDescripcionPqrs() {
		return pqrsDescripcionPqrs;
	}

	public void setPqrsDescripcionPqrs(String pqrsDescripcionPqrs) {
		this.pqrsDescripcionPqrs = pqrsDescripcionPqrs;
	}

	public String getPqrsEstado() {
		return pqrsEstado;
	}

	public void setPqrsEstado(String pqrsEstado) {
		this.pqrsEstado = pqrsEstado;
	}

	public String getPqrsAdjunto() {
		return pqrsAdjunto;
	}

	public void setPqrsAdjunto(String pqrsAdjunto) {
		this.pqrsAdjunto = pqrsAdjunto;
	}

	public String getPqrsFechaCreacion() {
		return pqrsFechaCreacion;
	}

	public void setPqrsFechaCreacion(String pqrsFechaCreacion) {
		this.pqrsFechaCreacion = pqrsFechaCreacion;
	}

	public String getPqrsFechaRespuesta() {
		return pqrsFechaRespuesta;
	}

	public void setPqrsFechaRespuesta(String pqrsFechaRespuesta) {
		this.pqrsFechaRespuesta = pqrsFechaRespuesta;
	}

	public String getPqrsLogs() {
		return pqrsLogs;
	}

	public void setPqrsLogs(String pqrsLogs) {
		this.pqrsLogs = pqrsLogs;
	}

	public String getPqrsVisualizacion() {
		return pqrsVisualizacion;
	}

	public void setPqrsVisualizacion(String pqrsVisualizacion) {
		this.pqrsVisualizacion = pqrsVisualizacion;
	}

	public String getPqrsRespuestaPqrs() {
		return pqrsRespuestaPqrs;
	}

	public void setPqrsRespuestaPqrs(String pqrsRespuestaPqrs) {
		this.pqrsRespuestaPqrs = pqrsRespuestaPqrs;
	}

	public String getPqrsAdjuntoRespuesta() {
		return pqrsAdjuntoRespuesta;
	}

	public void setPqrsAdjuntoRespuesta(String pqrsAdjuntoRespuesta) {
		this.pqrsAdjuntoRespuesta = pqrsAdjuntoRespuesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + idPqrs;
		result = prime * result + ((pqrsAdjunto == null) ? 0 : pqrsAdjunto.hashCode());
		result = prime * result + ((pqrsAdjuntoRespuesta == null) ? 0 : pqrsAdjuntoRespuesta.hashCode());
		result = prime * result + ((pqrsDescripcionPqrs == null) ? 0 : pqrsDescripcionPqrs.hashCode());
		result = prime * result + ((pqrsDireccionCorrespondecia == null) ? 0 : pqrsDireccionCorrespondecia.hashCode());
		result = prime * result + ((pqrsEmail == null) ? 0 : pqrsEmail.hashCode());
		result = prime * result + ((pqrsEstado == null) ? 0 : pqrsEstado.hashCode());
		result = prime * result + ((pqrsFechaCreacion == null) ? 0 : pqrsFechaCreacion.hashCode());
		result = prime * result + ((pqrsFechaRespuesta == null) ? 0 : pqrsFechaRespuesta.hashCode());
		result = prime * result + ((pqrsLogs == null) ? 0 : pqrsLogs.hashCode());
		result = prime * result + ((pqrsRespuestaPqrs == null) ? 0 : pqrsRespuestaPqrs.hashCode());
		result = prime * result + ((pqrsTelefono == null) ? 0 : pqrsTelefono.hashCode());
		result = prime * result + ((pqrsVisualizacion == null) ? 0 : pqrsVisualizacion.hashCode());
		result = prime * result + ((proApellidos == null) ? 0 : proApellidos.hashCode());
		result = prime * result + proCc;
		result = prime * result + ((proNombres == null) ? 0 : proNombres.hashCode());
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
		Pqrs other = (Pqrs) obj;
		if (copNit != other.copNit)
			return false;
		if (idPqrs != other.idPqrs)
			return false;
		if (pqrsAdjunto == null) {
			if (other.pqrsAdjunto != null)
				return false;
		} else if (!pqrsAdjunto.equals(other.pqrsAdjunto))
			return false;
		if (pqrsAdjuntoRespuesta == null) {
			if (other.pqrsAdjuntoRespuesta != null)
				return false;
		} else if (!pqrsAdjuntoRespuesta.equals(other.pqrsAdjuntoRespuesta))
			return false;
		if (pqrsDescripcionPqrs == null) {
			if (other.pqrsDescripcionPqrs != null)
				return false;
		} else if (!pqrsDescripcionPqrs.equals(other.pqrsDescripcionPqrs))
			return false;
		if (pqrsDireccionCorrespondecia == null) {
			if (other.pqrsDireccionCorrespondecia != null)
				return false;
		} else if (!pqrsDireccionCorrespondecia.equals(other.pqrsDireccionCorrespondecia))
			return false;
		if (pqrsEmail == null) {
			if (other.pqrsEmail != null)
				return false;
		} else if (!pqrsEmail.equals(other.pqrsEmail))
			return false;
		if (pqrsEstado == null) {
			if (other.pqrsEstado != null)
				return false;
		} else if (!pqrsEstado.equals(other.pqrsEstado))
			return false;
		if (pqrsFechaCreacion == null) {
			if (other.pqrsFechaCreacion != null)
				return false;
		} else if (!pqrsFechaCreacion.equals(other.pqrsFechaCreacion))
			return false;
		if (pqrsFechaRespuesta == null) {
			if (other.pqrsFechaRespuesta != null)
				return false;
		} else if (!pqrsFechaRespuesta.equals(other.pqrsFechaRespuesta))
			return false;
		if (pqrsLogs == null) {
			if (other.pqrsLogs != null)
				return false;
		} else if (!pqrsLogs.equals(other.pqrsLogs))
			return false;
		if (pqrsRespuestaPqrs == null) {
			if (other.pqrsRespuestaPqrs != null)
				return false;
		} else if (!pqrsRespuestaPqrs.equals(other.pqrsRespuestaPqrs))
			return false;
		if (pqrsTelefono == null) {
			if (other.pqrsTelefono != null)
				return false;
		} else if (!pqrsTelefono.equals(other.pqrsTelefono))
			return false;
		if (pqrsVisualizacion == null) {
			if (other.pqrsVisualizacion != null)
				return false;
		} else if (!pqrsVisualizacion.equals(other.pqrsVisualizacion))
			return false;
		if (proApellidos == null) {
			if (other.proApellidos != null)
				return false;
		} else if (!proApellidos.equals(other.proApellidos))
			return false;
		if (proCc != other.proCc)
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
		return true;
	}

	@Override
	public String toString() {
		return "Pqrs [idPqrs=" + idPqrs + ", copNit=" + copNit + ", proCc=" + proCc + ", proNombres=" + proNombres
				+ ", proApellidos=" + proApellidos + ", proNumeroResidencia=" + proNumeroResidencia + ", pqrsEmail="
				+ pqrsEmail + ", pqrsTelefono=" + pqrsTelefono + ", pqrsDireccionCorrespondecia="
				+ pqrsDireccionCorrespondecia + ", pqrsDescripcionPqrs=" + pqrsDescripcionPqrs + ", pqrsEstado="
				+ pqrsEstado + ", pqrsAdjunto=" + pqrsAdjunto + ", pqrsFechaCreacion=" + pqrsFechaCreacion
				+ ", pqrsFechaRespuesta=" + pqrsFechaRespuesta + ", pqrsLogs=" + pqrsLogs + ", pqrsVisualizacion="
				+ pqrsVisualizacion + ", pqrsRespuestaPqrs=" + pqrsRespuestaPqrs + ", pqrsAdjuntoRespuesta="
				+ pqrsAdjuntoRespuesta + "]";
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
public class Pqrs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5089968683378695350L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int idPqrs;
	
	@Column
	private int copNit;
	
	@Column
	private int proCc;
	
	@Column
	private String proNombres;
	
	@Column
	private String proApellidos;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String pqrsEmail;
	
	@Column
	private String pqrsTelefono;
	
	@Column
	private String pqrsDireccionCorrespondecia;
	
	@Column
	private String pqrsDescripcionPqrs;
	
	@Column
	private String pqrsEstado;
	
	@Column
	private String pqrsAdjunto;
	
	@Column
	private String pqrsFechaCreacion;
	
	@Column
	private String pqrsFechaRespuesta;
	
	@Column
	private String pqrsLogs;
	
	@Column
	private String pqrsVisualizacion;
	
	@Column
	private String pqrsRespuestaPqrs;
	
	@Column
	private String pqrsAdjuntoRespuesta;

	public int getIdPqrs() {
		return idPqrs;
	}

	public void setIdPqrs(int idPqrs) {
		this.idPqrs = idPqrs;
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

	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public String getPqrsEmail() {
		return pqrsEmail;
	}

	public void setPqrsEmail(String pqrsEmail) {
		this.pqrsEmail = pqrsEmail;
	}

	public String getPqrsTelefono() {
		return pqrsTelefono;
	}

	public void setPqrsTelefono(String pqrsTelefono) {
		this.pqrsTelefono = pqrsTelefono;
	}

	public String getPqrsDireccionCorrespondecia() {
		return pqrsDireccionCorrespondecia;
	}

	public void setPqrsDireccionCorrespondecia(String pqrsDireccionCorrespondecia) {
		this.pqrsDireccionCorrespondecia = pqrsDireccionCorrespondecia;
	}

	public String getPqrsDescripcionPqrs() {
		return pqrsDescripcionPqrs;
	}

	public void setPqrsDescripcionPqrs(String pqrsDescripcionPqrs) {
		this.pqrsDescripcionPqrs = pqrsDescripcionPqrs;
	}

	public String getPqrsEstado() {
		return pqrsEstado;
	}

	public void setPqrsEstado(String pqrsEstado) {
		this.pqrsEstado = pqrsEstado;
	}

	public String getPqrsAdjunto() {
		return pqrsAdjunto;
	}

	public void setPqrsAdjunto(String pqrsAdjunto) {
		this.pqrsAdjunto = pqrsAdjunto;
	}

	public String getPqrsFechaCreacion() {
		return pqrsFechaCreacion;
	}

	public void setPqrsFechaCreacion(String pqrsFechaCreacion) {
		this.pqrsFechaCreacion = pqrsFechaCreacion;
	}

	public String getPqrsFechaRespuesta() {
		return pqrsFechaRespuesta;
	}

	public void setPqrsFechaRespuesta(String pqrsFechaRespuesta) {
		this.pqrsFechaRespuesta = pqrsFechaRespuesta;
	}

	public String getPqrsLogs() {
		return pqrsLogs;
	}

	public void setPqrsLogs(String pqrsLogs) {
		this.pqrsLogs = pqrsLogs;
	}

	public String getPqrsVisualizacion() {
		return pqrsVisualizacion;
	}

	public void setPqrsVisualizacion(String pqrsVisualizacion) {
		this.pqrsVisualizacion = pqrsVisualizacion;
	}

	public String getPqrsRespuestaPqrs() {
		return pqrsRespuestaPqrs;
	}

	public void setPqrsRespuestaPqrs(String pqrsRespuestaPqrs) {
		this.pqrsRespuestaPqrs = pqrsRespuestaPqrs;
	}

	public String getPqrsAdjuntoRespuesta() {
		return pqrsAdjuntoRespuesta;
	}

	public void setPqrsAdjuntoRespuesta(String pqrsAdjuntoRespuesta) {
		this.pqrsAdjuntoRespuesta = pqrsAdjuntoRespuesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + idPqrs;
		result = prime * result + ((pqrsAdjunto == null) ? 0 : pqrsAdjunto.hashCode());
		result = prime * result + ((pqrsAdjuntoRespuesta == null) ? 0 : pqrsAdjuntoRespuesta.hashCode());
		result = prime * result + ((pqrsDescripcionPqrs == null) ? 0 : pqrsDescripcionPqrs.hashCode());
		result = prime * result + ((pqrsDireccionCorrespondecia == null) ? 0 : pqrsDireccionCorrespondecia.hashCode());
		result = prime * result + ((pqrsEmail == null) ? 0 : pqrsEmail.hashCode());
		result = prime * result + ((pqrsEstado == null) ? 0 : pqrsEstado.hashCode());
		result = prime * result + ((pqrsFechaCreacion == null) ? 0 : pqrsFechaCreacion.hashCode());
		result = prime * result + ((pqrsFechaRespuesta == null) ? 0 : pqrsFechaRespuesta.hashCode());
		result = prime * result + ((pqrsLogs == null) ? 0 : pqrsLogs.hashCode());
		result = prime * result + ((pqrsRespuestaPqrs == null) ? 0 : pqrsRespuestaPqrs.hashCode());
		result = prime * result + ((pqrsTelefono == null) ? 0 : pqrsTelefono.hashCode());
		result = prime * result + ((pqrsVisualizacion == null) ? 0 : pqrsVisualizacion.hashCode());
		result = prime * result + ((proApellidos == null) ? 0 : proApellidos.hashCode());
		result = prime * result + proCc;
		result = prime * result + ((proNombres == null) ? 0 : proNombres.hashCode());
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
		Pqrs other = (Pqrs) obj;
		if (copNit != other.copNit)
			return false;
		if (idPqrs != other.idPqrs)
			return false;
		if (pqrsAdjunto == null) {
			if (other.pqrsAdjunto != null)
				return false;
		} else if (!pqrsAdjunto.equals(other.pqrsAdjunto))
			return false;
		if (pqrsAdjuntoRespuesta == null) {
			if (other.pqrsAdjuntoRespuesta != null)
				return false;
		} else if (!pqrsAdjuntoRespuesta.equals(other.pqrsAdjuntoRespuesta))
			return false;
		if (pqrsDescripcionPqrs == null) {
			if (other.pqrsDescripcionPqrs != null)
				return false;
		} else if (!pqrsDescripcionPqrs.equals(other.pqrsDescripcionPqrs))
			return false;
		if (pqrsDireccionCorrespondecia == null) {
			if (other.pqrsDireccionCorrespondecia != null)
				return false;
		} else if (!pqrsDireccionCorrespondecia.equals(other.pqrsDireccionCorrespondecia))
			return false;
		if (pqrsEmail == null) {
			if (other.pqrsEmail != null)
				return false;
		} else if (!pqrsEmail.equals(other.pqrsEmail))
			return false;
		if (pqrsEstado == null) {
			if (other.pqrsEstado != null)
				return false;
		} else if (!pqrsEstado.equals(other.pqrsEstado))
			return false;
		if (pqrsFechaCreacion == null) {
			if (other.pqrsFechaCreacion != null)
				return false;
		} else if (!pqrsFechaCreacion.equals(other.pqrsFechaCreacion))
			return false;
		if (pqrsFechaRespuesta == null) {
			if (other.pqrsFechaRespuesta != null)
				return false;
		} else if (!pqrsFechaRespuesta.equals(other.pqrsFechaRespuesta))
			return false;
		if (pqrsLogs == null) {
			if (other.pqrsLogs != null)
				return false;
		} else if (!pqrsLogs.equals(other.pqrsLogs))
			return false;
		if (pqrsRespuestaPqrs == null) {
			if (other.pqrsRespuestaPqrs != null)
				return false;
		} else if (!pqrsRespuestaPqrs.equals(other.pqrsRespuestaPqrs))
			return false;
		if (pqrsTelefono == null) {
			if (other.pqrsTelefono != null)
				return false;
		} else if (!pqrsTelefono.equals(other.pqrsTelefono))
			return false;
		if (pqrsVisualizacion == null) {
			if (other.pqrsVisualizacion != null)
				return false;
		} else if (!pqrsVisualizacion.equals(other.pqrsVisualizacion))
			return false;
		if (proApellidos == null) {
			if (other.proApellidos != null)
				return false;
		} else if (!proApellidos.equals(other.proApellidos))
			return false;
		if (proCc != other.proCc)
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
		return true;
	}

	@Override
	public String toString() {
		return "Pqrs [idPqrs=" + idPqrs + ", copNit=" + copNit + ", proCc=" + proCc + ", proNombres=" + proNombres
				+ ", proApellidos=" + proApellidos + ", proNumeroResidencia=" + proNumeroResidencia + ", pqrsEmail="
				+ pqrsEmail + ", pqrsTelefono=" + pqrsTelefono + ", pqrsDireccionCorrespondecia="
				+ pqrsDireccionCorrespondecia + ", pqrsDescripcionPqrs=" + pqrsDescripcionPqrs + ", pqrsEstado="
				+ pqrsEstado + ", pqrsAdjunto=" + pqrsAdjunto + ", pqrsFechaCreacion=" + pqrsFechaCreacion
				+ ", pqrsFechaRespuesta=" + pqrsFechaRespuesta + ", pqrsLogs=" + pqrsLogs + ", pqrsVisualizacion="
				+ pqrsVisualizacion + ", pqrsRespuestaPqrs=" + pqrsRespuestaPqrs + ", pqrsAdjuntoRespuesta="
				+ pqrsAdjuntoRespuesta + "]";
	}
	

	
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
