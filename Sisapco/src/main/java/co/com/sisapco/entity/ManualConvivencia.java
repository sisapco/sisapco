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
public class ManualConvivencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8598405990535435601L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int conviId;
	
	@Column
	private int copNit;
	
	@Column
	private String conviNombre;
	
	@Column
	private String conviArchivo;
	
	@Column
	private String conviAnoPublicacion;
	
	@Column
	private String conviEstado;
	
	@Column
	private String conviLog;
	
	@Column
	private double conviVisualizacion;

	public int getConviId() {
		return conviId;
	}

	public void setConviId(int conviId) {
		this.conviId = conviId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getConviNombre() {
		return conviNombre;
	}

	public void setConviNombre(String conviNombre) {
		this.conviNombre = conviNombre;
	}

	public String getConviArchivo() {
		return conviArchivo;
	}

	public void setConviArchivo(String conviArchivo) {
		this.conviArchivo = conviArchivo;
	}

	public String getConviAnoPublicacion() {
		return conviAnoPublicacion;
	}

	public void setConviAnoPublicacion(String conviAnoPublicacion) {
		this.conviAnoPublicacion = conviAnoPublicacion;
	}

	public String getConviEstado() {
		return conviEstado;
	}

	public void setConviEstado(String conviEstado) {
		this.conviEstado = conviEstado;
	}

	public String getConviLog() {
		return conviLog;
	}

	public void setConviLog(String conviLog) {
		this.conviLog = conviLog;
	}

	public double getConviVisualizacion() {
		return conviVisualizacion;
	}

	public void setConviVisualizacion(double conviVisualizacion) {
		this.conviVisualizacion = conviVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conviAnoPublicacion == null) ? 0 : conviAnoPublicacion.hashCode());
		result = prime * result + ((conviArchivo == null) ? 0 : conviArchivo.hashCode());
		result = prime * result + ((conviEstado == null) ? 0 : conviEstado.hashCode());
		result = prime * result + conviId;
		result = prime * result + ((conviLog == null) ? 0 : conviLog.hashCode());
		result = prime * result + ((conviNombre == null) ? 0 : conviNombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(conviVisualizacion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + copNit;
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
		ManualConvivencia other = (ManualConvivencia) obj;
		if (conviAnoPublicacion == null) {
			if (other.conviAnoPublicacion != null)
				return false;
		} else if (!conviAnoPublicacion.equals(other.conviAnoPublicacion))
			return false;
		if (conviArchivo == null) {
			if (other.conviArchivo != null)
				return false;
		} else if (!conviArchivo.equals(other.conviArchivo))
			return false;
		if (conviEstado == null) {
			if (other.conviEstado != null)
				return false;
		} else if (!conviEstado.equals(other.conviEstado))
			return false;
		if (conviId != other.conviId)
			return false;
		if (conviLog == null) {
			if (other.conviLog != null)
				return false;
		} else if (!conviLog.equals(other.conviLog))
			return false;
		if (conviNombre == null) {
			if (other.conviNombre != null)
				return false;
		} else if (!conviNombre.equals(other.conviNombre))
			return false;
		if (Double.doubleToLongBits(conviVisualizacion) != Double.doubleToLongBits(other.conviVisualizacion))
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManualConvivencia [conviId=" + conviId + ", copNit=" + copNit + ", conviNombre=" + conviNombre
				+ ", conviArchivo=" + conviArchivo + ", conviAnoPublicacion=" + conviAnoPublicacion + ", conviEstado="
				+ conviEstado + ", conviLog=" + conviLog + ", conviVisualizacion=" + conviVisualizacion + "]";
	}
	
	

	

}
