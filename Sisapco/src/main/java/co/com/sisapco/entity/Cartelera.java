<<<<<<< HEAD
package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Cartelera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3835186690019147053L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int carteleraId;
	
	@Column
	private int copNit;
	
	@Column
	private String carteleraNombrePublicacion;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String carteleraDescripcion;
	
	@Column
	private String carteleraFechaInicio;
	
	@Column
	private String carteleraFechaFin;
			
	@Column
	private String carteleraDocumentoAdjunto;
	
	@Column
	private String carteleraEstado;
	
	@Column
	private String carteleraLog;

	public int getCarteleraId() {
		return carteleraId;
	}

	public void setCarteleraId(int carteleraId) {
		this.carteleraId = carteleraId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getCarteleraNombrePublicacion() {
		return carteleraNombrePublicacion;
	}

	public void setCarteleraNombrePublicacion(String carteleraNombrePublicacion) {
		this.carteleraNombrePublicacion = carteleraNombrePublicacion;
	}

	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public String getCarteleraDescripcion() {
		return carteleraDescripcion;
	}

	public void setCarteleraDescripcion(String carteleraDescripcion) {
		this.carteleraDescripcion = carteleraDescripcion;
	}

	public String getCarteleraFechaInicio() {
		return carteleraFechaInicio;
	}

	public void setCarteleraFechaInicio(String carteleraFechaInicio) {
		this.carteleraFechaInicio = carteleraFechaInicio;
	}

	public String getCarteleraFechaFin() {
		return carteleraFechaFin;
	}

	public void setCarteleraFechaFin(String carteleraFechaFin) {
		this.carteleraFechaFin = carteleraFechaFin;
	}

	public String getCarteleraDocumentoAdjunto() {
		return carteleraDocumentoAdjunto;
	}

	public void setCarteleraDocumentoAdjunto(String carteleraDocumentoAdjunto) {
		this.carteleraDocumentoAdjunto = carteleraDocumentoAdjunto;
	}

	public String getCarteleraEstado() {
		return carteleraEstado;
	}

	public void setCarteleraEstado(String carteleraEstado) {
		this.carteleraEstado = carteleraEstado;
	}

	public String getCarteleraLog() {
		return carteleraLog;
	}

	public void setCarteleraLog(String carteleraLog) {
		this.carteleraLog = carteleraLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carteleraDescripcion == null) ? 0 : carteleraDescripcion.hashCode());
		result = prime * result + ((carteleraDocumentoAdjunto == null) ? 0 : carteleraDocumentoAdjunto.hashCode());
		result = prime * result + ((carteleraEstado == null) ? 0 : carteleraEstado.hashCode());
		result = prime * result + ((carteleraFechaFin == null) ? 0 : carteleraFechaFin.hashCode());
		result = prime * result + ((carteleraFechaInicio == null) ? 0 : carteleraFechaInicio.hashCode());
		result = prime * result + carteleraId;
		result = prime * result + ((carteleraLog == null) ? 0 : carteleraLog.hashCode());
		result = prime * result + ((carteleraNombrePublicacion == null) ? 0 : carteleraNombrePublicacion.hashCode());
		result = prime * result + copNit;
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
		Cartelera other = (Cartelera) obj;
		if (carteleraDescripcion == null) {
			if (other.carteleraDescripcion != null)
				return false;
		} else if (!carteleraDescripcion.equals(other.carteleraDescripcion))
			return false;
		if (carteleraDocumentoAdjunto == null) {
			if (other.carteleraDocumentoAdjunto != null)
				return false;
		} else if (!carteleraDocumentoAdjunto.equals(other.carteleraDocumentoAdjunto))
			return false;
		if (carteleraEstado == null) {
			if (other.carteleraEstado != null)
				return false;
		} else if (!carteleraEstado.equals(other.carteleraEstado))
			return false;
		if (carteleraFechaFin == null) {
			if (other.carteleraFechaFin != null)
				return false;
		} else if (!carteleraFechaFin.equals(other.carteleraFechaFin))
			return false;
		if (carteleraFechaInicio == null) {
			if (other.carteleraFechaInicio != null)
				return false;
		} else if (!carteleraFechaInicio.equals(other.carteleraFechaInicio))
			return false;
		if (carteleraId != other.carteleraId)
			return false;
		if (carteleraLog == null) {
			if (other.carteleraLog != null)
				return false;
		} else if (!carteleraLog.equals(other.carteleraLog))
			return false;
		if (carteleraNombrePublicacion == null) {
			if (other.carteleraNombrePublicacion != null)
				return false;
		} else if (!carteleraNombrePublicacion.equals(other.carteleraNombrePublicacion))
			return false;
		if (copNit != other.copNit)
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
		return "CargaInfoCartelera [carteleraId=" + carteleraId + ", copNit=" + copNit + ", carteleraNombrePublicacion="
				+ carteleraNombrePublicacion + ", proNumeroResidencia=" + proNumeroResidencia
				+ ", carteleraDescripcion=" + carteleraDescripcion + ", carteleraFechaInicio=" + carteleraFechaInicio
				+ ", carteleraFechaFin=" + carteleraFechaFin + ", carteleraDocumentoAdjunto="
				+ carteleraDocumentoAdjunto + ", carteleraEstado=" + carteleraEstado + ", carteleraLog=" + carteleraLog
				+ "]";
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
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Cartelera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3835186690019147053L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int carteleraId;
	
	@Column
	private int copNit;
	
	@Column
	private String carteleraNombrePublicacion;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String carteleraDescripcion;
	
	@Column
	private String carteleraFechaInicio;
	
	@Column
	private String carteleraFechaFin;
			
	@Column
	private String carteleraDocumentoAdjunto;
	
	@Column
	private String carteleraEstado;
	
	@Column
	private String carteleraLog;

	public int getCarteleraId() {
		return carteleraId;
	}

	public void setCarteleraId(int carteleraId) {
		this.carteleraId = carteleraId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getCarteleraNombrePublicacion() {
		return carteleraNombrePublicacion;
	}

	public void setCarteleraNombrePublicacion(String carteleraNombrePublicacion) {
		this.carteleraNombrePublicacion = carteleraNombrePublicacion;
	}

	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public String getCarteleraDescripcion() {
		return carteleraDescripcion;
	}

	public void setCarteleraDescripcion(String carteleraDescripcion) {
		this.carteleraDescripcion = carteleraDescripcion;
	}

	public String getCarteleraFechaInicio() {
		return carteleraFechaInicio;
	}

	public void setCarteleraFechaInicio(String carteleraFechaInicio) {
		this.carteleraFechaInicio = carteleraFechaInicio;
	}

	public String getCarteleraFechaFin() {
		return carteleraFechaFin;
	}

	public void setCarteleraFechaFin(String carteleraFechaFin) {
		this.carteleraFechaFin = carteleraFechaFin;
	}

	public String getCarteleraDocumentoAdjunto() {
		return carteleraDocumentoAdjunto;
	}

	public void setCarteleraDocumentoAdjunto(String carteleraDocumentoAdjunto) {
		this.carteleraDocumentoAdjunto = carteleraDocumentoAdjunto;
	}

	public String getCarteleraEstado() {
		return carteleraEstado;
	}

	public void setCarteleraEstado(String carteleraEstado) {
		this.carteleraEstado = carteleraEstado;
	}

	public String getCarteleraLog() {
		return carteleraLog;
	}

	public void setCarteleraLog(String carteleraLog) {
		this.carteleraLog = carteleraLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carteleraDescripcion == null) ? 0 : carteleraDescripcion.hashCode());
		result = prime * result + ((carteleraDocumentoAdjunto == null) ? 0 : carteleraDocumentoAdjunto.hashCode());
		result = prime * result + ((carteleraEstado == null) ? 0 : carteleraEstado.hashCode());
		result = prime * result + ((carteleraFechaFin == null) ? 0 : carteleraFechaFin.hashCode());
		result = prime * result + ((carteleraFechaInicio == null) ? 0 : carteleraFechaInicio.hashCode());
		result = prime * result + carteleraId;
		result = prime * result + ((carteleraLog == null) ? 0 : carteleraLog.hashCode());
		result = prime * result + ((carteleraNombrePublicacion == null) ? 0 : carteleraNombrePublicacion.hashCode());
		result = prime * result + copNit;
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
		Cartelera other = (Cartelera) obj;
		if (carteleraDescripcion == null) {
			if (other.carteleraDescripcion != null)
				return false;
		} else if (!carteleraDescripcion.equals(other.carteleraDescripcion))
			return false;
		if (carteleraDocumentoAdjunto == null) {
			if (other.carteleraDocumentoAdjunto != null)
				return false;
		} else if (!carteleraDocumentoAdjunto.equals(other.carteleraDocumentoAdjunto))
			return false;
		if (carteleraEstado == null) {
			if (other.carteleraEstado != null)
				return false;
		} else if (!carteleraEstado.equals(other.carteleraEstado))
			return false;
		if (carteleraFechaFin == null) {
			if (other.carteleraFechaFin != null)
				return false;
		} else if (!carteleraFechaFin.equals(other.carteleraFechaFin))
			return false;
		if (carteleraFechaInicio == null) {
			if (other.carteleraFechaInicio != null)
				return false;
		} else if (!carteleraFechaInicio.equals(other.carteleraFechaInicio))
			return false;
		if (carteleraId != other.carteleraId)
			return false;
		if (carteleraLog == null) {
			if (other.carteleraLog != null)
				return false;
		} else if (!carteleraLog.equals(other.carteleraLog))
			return false;
		if (carteleraNombrePublicacion == null) {
			if (other.carteleraNombrePublicacion != null)
				return false;
		} else if (!carteleraNombrePublicacion.equals(other.carteleraNombrePublicacion))
			return false;
		if (copNit != other.copNit)
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
		return "CargaInfoCartelera [carteleraId=" + carteleraId + ", copNit=" + copNit + ", carteleraNombrePublicacion="
				+ carteleraNombrePublicacion + ", proNumeroResidencia=" + proNumeroResidencia
				+ ", carteleraDescripcion=" + carteleraDescripcion + ", carteleraFechaInicio=" + carteleraFechaInicio
				+ ", carteleraFechaFin=" + carteleraFechaFin + ", carteleraDocumentoAdjunto="
				+ carteleraDocumentoAdjunto + ", carteleraEstado=" + carteleraEstado + ", carteleraLog=" + carteleraLog
				+ "]";
	}

	

	
	

	
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
