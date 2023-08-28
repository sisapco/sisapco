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
public class Comunicados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8598405990535435601L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int comuId;
	
	@Column
	private int copNit;
	
	@Column
	private String comuNombre;
	
	@Column
	private String comuFecha;
	
	@Column
	private String comuEstado;
	
	@Column
	private String comuDescripcion;
	
	@Column
	private String comuArchivo;
	
	@Column
	private String comuLog;
	
	@Column
	private String comuVisualizacion;

	public int getComuId() {
		return comuId;
	}

	public void setComuId(int comuId) {
		this.comuId = comuId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getComuNombre() {
		return comuNombre;
	}

	public void setComuNombre(String comuNombre) {
		this.comuNombre = comuNombre;
	}

	public String getComuFecha() {
		return comuFecha;
	}

	public void setComuFecha(String comuFecha) {
		this.comuFecha = comuFecha;
	}

	public String getComuEstado() {
		return comuEstado;
	}

	public void setComuEstado(String comuEstado) {
		this.comuEstado = comuEstado;
	}

	public String getComuDescripcion() {
		return comuDescripcion;
	}

	public void setComuDescripcion(String comuDescripcion) {
		this.comuDescripcion = comuDescripcion;
	}

	public String getComuArchivo() {
		return comuArchivo;
	}

	public void setComuArchivo(String comuArchivo) {
		this.comuArchivo = comuArchivo;
	}

	public String getComuLog() {
		return comuLog;
	}

	public void setComuLog(String comuLog) {
		this.comuLog = comuLog;
	}

	public String getComuVisualizacion() {
		return comuVisualizacion;
	}

	public void setComuVisualizacion(String comuVisualizacion) {
		this.comuVisualizacion = comuVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comuArchivo == null) ? 0 : comuArchivo.hashCode());
		result = prime * result + ((comuDescripcion == null) ? 0 : comuDescripcion.hashCode());
		result = prime * result + ((comuEstado == null) ? 0 : comuEstado.hashCode());
		result = prime * result + ((comuFecha == null) ? 0 : comuFecha.hashCode());
		result = prime * result + comuId;
		result = prime * result + ((comuLog == null) ? 0 : comuLog.hashCode());
		result = prime * result + ((comuNombre == null) ? 0 : comuNombre.hashCode());
		result = prime * result + ((comuVisualizacion == null) ? 0 : comuVisualizacion.hashCode());
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
		Comunicados other = (Comunicados) obj;
		if (comuArchivo == null) {
			if (other.comuArchivo != null)
				return false;
		} else if (!comuArchivo.equals(other.comuArchivo))
			return false;
		if (comuDescripcion == null) {
			if (other.comuDescripcion != null)
				return false;
		} else if (!comuDescripcion.equals(other.comuDescripcion))
			return false;
		if (comuEstado == null) {
			if (other.comuEstado != null)
				return false;
		} else if (!comuEstado.equals(other.comuEstado))
			return false;
		if (comuFecha == null) {
			if (other.comuFecha != null)
				return false;
		} else if (!comuFecha.equals(other.comuFecha))
			return false;
		if (comuId != other.comuId)
			return false;
		if (comuLog == null) {
			if (other.comuLog != null)
				return false;
		} else if (!comuLog.equals(other.comuLog))
			return false;
		if (comuNombre == null) {
			if (other.comuNombre != null)
				return false;
		} else if (!comuNombre.equals(other.comuNombre))
			return false;
		if (comuVisualizacion == null) {
			if (other.comuVisualizacion != null)
				return false;
		} else if (!comuVisualizacion.equals(other.comuVisualizacion))
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comunicados [comuId=" + comuId + ", copNit=" + copNit + ", comuNombre=" + comuNombre + ", comuFecha="
				+ comuFecha + ", comuEstado=" + comuEstado + ", comuDescripcion=" + comuDescripcion + ", comuArchivo="
				+ comuArchivo + ", comuLog=" + comuLog + ", comuVisualizacion=" + comuVisualizacion + "]";
	}

	

}
