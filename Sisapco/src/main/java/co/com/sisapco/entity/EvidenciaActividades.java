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
public class EvidenciaActividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3357537301382431830L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int eviId;
	
	@Column
	private int actId;
	
	@Column
	private String eviNombreImagen;
	
	@Column
	private String eviRutaImagen;
	
	@Column
	private String eviFormatoImagen;
	
	@Column
	private String eviEstadoImagen;
	
	@Column
	private String eviAntesDespues;
	
	@Column
	private String eviVisualizacion;

	public int getEviId() {
		return eviId;
	}

	public void setEviId(int eviId) {
		this.eviId = eviId;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getEviNombreImagen() {
		return eviNombreImagen;
	}

	public void setEviNombreImagen(String eviNombreImagen) {
		this.eviNombreImagen = eviNombreImagen;
	}

	public String getEviRutaImagen() {
		return eviRutaImagen;
	}

	public void setEviRutaImagen(String eviRutaImagen) {
		this.eviRutaImagen = eviRutaImagen;
	}

	public String getEviFormatoImagen() {
		return eviFormatoImagen;
	}

	public void setEviFormatoImagen(String eviFormatoImagen) {
		this.eviFormatoImagen = eviFormatoImagen;
	}

	public String getEviEstadoImagen() {
		return eviEstadoImagen;
	}

	public void setEviEstadoImagen(String eviEstadoImagen) {
		this.eviEstadoImagen = eviEstadoImagen;
	}

	public String getEviAntesDespues() {
		return eviAntesDespues;
	}

	public void setEviAntesDespues(String eviAntesDespues) {
		this.eviAntesDespues = eviAntesDespues;
	}

	public String getEviVisualizacion() {
		return eviVisualizacion;
	}

	public void setEviVisualizacion(String eviVisualizacion) {
		this.eviVisualizacion = eviVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actId;
		result = prime * result + ((eviAntesDespues == null) ? 0 : eviAntesDespues.hashCode());
		result = prime * result + ((eviEstadoImagen == null) ? 0 : eviEstadoImagen.hashCode());
		result = prime * result + ((eviFormatoImagen == null) ? 0 : eviFormatoImagen.hashCode());
		result = prime * result + eviId;
		result = prime * result + ((eviNombreImagen == null) ? 0 : eviNombreImagen.hashCode());
		result = prime * result + ((eviRutaImagen == null) ? 0 : eviRutaImagen.hashCode());
		result = prime * result + ((eviVisualizacion == null) ? 0 : eviVisualizacion.hashCode());
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
		EvidenciaActividades other = (EvidenciaActividades) obj;
		if (actId != other.actId)
			return false;
		if (eviAntesDespues == null) {
			if (other.eviAntesDespues != null)
				return false;
		} else if (!eviAntesDespues.equals(other.eviAntesDespues))
			return false;
		if (eviEstadoImagen == null) {
			if (other.eviEstadoImagen != null)
				return false;
		} else if (!eviEstadoImagen.equals(other.eviEstadoImagen))
			return false;
		if (eviFormatoImagen == null) {
			if (other.eviFormatoImagen != null)
				return false;
		} else if (!eviFormatoImagen.equals(other.eviFormatoImagen))
			return false;
		if (eviId != other.eviId)
			return false;
		if (eviNombreImagen == null) {
			if (other.eviNombreImagen != null)
				return false;
		} else if (!eviNombreImagen.equals(other.eviNombreImagen))
			return false;
		if (eviRutaImagen == null) {
			if (other.eviRutaImagen != null)
				return false;
		} else if (!eviRutaImagen.equals(other.eviRutaImagen))
			return false;
		if (eviVisualizacion == null) {
			if (other.eviVisualizacion != null)
				return false;
		} else if (!eviVisualizacion.equals(other.eviVisualizacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EvidenciaActividades [eviId=" + eviId + ", actId=" + actId + ", eviNombreImagen=" + eviNombreImagen
				+ ", eviRutaImagen=" + eviRutaImagen + ", eviFormatoImagen=" + eviFormatoImagen + ", eviEstadoImagen="
				+ eviEstadoImagen + ", eviAntesDespues=" + eviAntesDespues + ", eviVisualizacion=" + eviVisualizacion
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

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EvidenciaActividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3357537301382431830L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int eviId;
	
	@Column
	private int actId;
	
	@Column
	private String eviNombreImagen;
	
	@Column
	private String eviRutaImagen;
	
	@Column
	private String eviFormatoImagen;
	
	@Column
	private String eviEstadoImagen;
	
	@Column
	private String eviAntesDespues;
	
	@Column
	private String eviVisualizacion;

	public int getEviId() {
		return eviId;
	}

	public void setEviId(int eviId) {
		this.eviId = eviId;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getEviNombreImagen() {
		return eviNombreImagen;
	}

	public void setEviNombreImagen(String eviNombreImagen) {
		this.eviNombreImagen = eviNombreImagen;
	}

	public String getEviRutaImagen() {
		return eviRutaImagen;
	}

	public void setEviRutaImagen(String eviRutaImagen) {
		this.eviRutaImagen = eviRutaImagen;
	}

	public String getEviFormatoImagen() {
		return eviFormatoImagen;
	}

	public void setEviFormatoImagen(String eviFormatoImagen) {
		this.eviFormatoImagen = eviFormatoImagen;
	}

	public String getEviEstadoImagen() {
		return eviEstadoImagen;
	}

	public void setEviEstadoImagen(String eviEstadoImagen) {
		this.eviEstadoImagen = eviEstadoImagen;
	}

	public String getEviAntesDespues() {
		return eviAntesDespues;
	}

	public void setEviAntesDespues(String eviAntesDespues) {
		this.eviAntesDespues = eviAntesDespues;
	}

	public String getEviVisualizacion() {
		return eviVisualizacion;
	}

	public void setEviVisualizacion(String eviVisualizacion) {
		this.eviVisualizacion = eviVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actId;
		result = prime * result + ((eviAntesDespues == null) ? 0 : eviAntesDespues.hashCode());
		result = prime * result + ((eviEstadoImagen == null) ? 0 : eviEstadoImagen.hashCode());
		result = prime * result + ((eviFormatoImagen == null) ? 0 : eviFormatoImagen.hashCode());
		result = prime * result + eviId;
		result = prime * result + ((eviNombreImagen == null) ? 0 : eviNombreImagen.hashCode());
		result = prime * result + ((eviRutaImagen == null) ? 0 : eviRutaImagen.hashCode());
		result = prime * result + ((eviVisualizacion == null) ? 0 : eviVisualizacion.hashCode());
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
		EvidenciaActividades other = (EvidenciaActividades) obj;
		if (actId != other.actId)
			return false;
		if (eviAntesDespues == null) {
			if (other.eviAntesDespues != null)
				return false;
		} else if (!eviAntesDespues.equals(other.eviAntesDespues))
			return false;
		if (eviEstadoImagen == null) {
			if (other.eviEstadoImagen != null)
				return false;
		} else if (!eviEstadoImagen.equals(other.eviEstadoImagen))
			return false;
		if (eviFormatoImagen == null) {
			if (other.eviFormatoImagen != null)
				return false;
		} else if (!eviFormatoImagen.equals(other.eviFormatoImagen))
			return false;
		if (eviId != other.eviId)
			return false;
		if (eviNombreImagen == null) {
			if (other.eviNombreImagen != null)
				return false;
		} else if (!eviNombreImagen.equals(other.eviNombreImagen))
			return false;
		if (eviRutaImagen == null) {
			if (other.eviRutaImagen != null)
				return false;
		} else if (!eviRutaImagen.equals(other.eviRutaImagen))
			return false;
		if (eviVisualizacion == null) {
			if (other.eviVisualizacion != null)
				return false;
		} else if (!eviVisualizacion.equals(other.eviVisualizacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EvidenciaActividades [eviId=" + eviId + ", actId=" + actId + ", eviNombreImagen=" + eviNombreImagen
				+ ", eviRutaImagen=" + eviRutaImagen + ", eviFormatoImagen=" + eviFormatoImagen + ", eviEstadoImagen="
				+ eviEstadoImagen + ", eviAntesDespues=" + eviAntesDespues + ", eviVisualizacion=" + eviVisualizacion
				+ "]";
	}

}

>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
