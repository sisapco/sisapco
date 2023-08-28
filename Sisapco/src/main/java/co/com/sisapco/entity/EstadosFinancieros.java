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
public class EstadosFinancieros implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8598405990535435601L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int estId;
	
	@Column
	private int copNit;
	
	@Column
	private String estNombreEstado;
	
	@Column
	private String estDescripcion;
	
	@Column
	private String estMes;
	
	@Column
	private String estAno;
	
	@Column
	private String estArchivo;
	
	@Column
	private String estEstado;
	
	@Column
	private String estLog;
	
	@Column
	private String estVisualizacion;

	public int getEstId() {
		return estId;
	}

	public void setEstId(int estId) {
		this.estId = estId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getEstNombreEstado() {
		return estNombreEstado;
	}

	public void setEstNombreEstado(String estNombreEstado) {
		this.estNombreEstado = estNombreEstado;
	}

	public String getEstDescripcion() {
		return estDescripcion;
	}

	public void setEstDescripcion(String estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

	public String getEstMes() {
		return estMes;
	}

	public void setEstMes(String estMes) {
		this.estMes = estMes;
	}

	public String getEstAno() {
		return estAno;
	}

	public void setEstAno(String estAno) {
		this.estAno = estAno;
	}

	public String getEstArchivo() {
		return estArchivo;
	}

	public void setEstArchivo(String estArchivo) {
		this.estArchivo = estArchivo;
	}

	public String getEstEstado() {
		return estEstado;
	}

	public void setEstEstado(String estEstado) {
		this.estEstado = estEstado;
	}

	public String getEstLog() {
		return estLog;
	}

	public void setEstLog(String estLog) {
		this.estLog = estLog;
	}

	public String getEstVisualizacion() {
		return estVisualizacion;
	}

	public void setEstVisualizacion(String estVisualizacion) {
		this.estVisualizacion = estVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((estAno == null) ? 0 : estAno.hashCode());
		result = prime * result + ((estArchivo == null) ? 0 : estArchivo.hashCode());
		result = prime * result + ((estDescripcion == null) ? 0 : estDescripcion.hashCode());
		result = prime * result + ((estEstado == null) ? 0 : estEstado.hashCode());
		result = prime * result + estId;
		result = prime * result + ((estLog == null) ? 0 : estLog.hashCode());
		result = prime * result + ((estMes == null) ? 0 : estMes.hashCode());
		result = prime * result + ((estNombreEstado == null) ? 0 : estNombreEstado.hashCode());
		result = prime * result + ((estVisualizacion == null) ? 0 : estVisualizacion.hashCode());
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
		EstadosFinancieros other = (EstadosFinancieros) obj;
		if (copNit != other.copNit)
			return false;
		if (estAno == null) {
			if (other.estAno != null)
				return false;
		} else if (!estAno.equals(other.estAno))
			return false;
		if (estArchivo == null) {
			if (other.estArchivo != null)
				return false;
		} else if (!estArchivo.equals(other.estArchivo))
			return false;
		if (estDescripcion == null) {
			if (other.estDescripcion != null)
				return false;
		} else if (!estDescripcion.equals(other.estDescripcion))
			return false;
		if (estEstado == null) {
			if (other.estEstado != null)
				return false;
		} else if (!estEstado.equals(other.estEstado))
			return false;
		if (estId != other.estId)
			return false;
		if (estLog == null) {
			if (other.estLog != null)
				return false;
		} else if (!estLog.equals(other.estLog))
			return false;
		if (estMes == null) {
			if (other.estMes != null)
				return false;
		} else if (!estMes.equals(other.estMes))
			return false;
		if (estNombreEstado == null) {
			if (other.estNombreEstado != null)
				return false;
		} else if (!estNombreEstado.equals(other.estNombreEstado))
			return false;
		if (estVisualizacion == null) {
			if (other.estVisualizacion != null)
				return false;
		} else if (!estVisualizacion.equals(other.estVisualizacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadosFinancieros [estId=" + estId + ", copNit=" + copNit + ", estNombreEstado=" + estNombreEstado
				+ ", estDescripcion=" + estDescripcion + ", estMes=" + estMes + ", estAno=" + estAno + ", estArchivo="
				+ estArchivo + ", estEstado=" + estEstado + ", estLog=" + estLog + ", estVisualizacion="
				+ estVisualizacion + "]";
	}

	
	

}
