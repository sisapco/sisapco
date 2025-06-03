<<<<<<< HEAD
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
public class Cotizaciones implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8598405990535435601L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int cotId;
	
	@Column
	private int copNit;
	
	@Column
	private String cotFechaCarga;
	
	@Column
	private String cotNombreCotizacion;
	
	@Column
	private String cotDescripcion;
	
	@Column
	private String cotArchivo;
	
	@Column
	private String cotLog;
	
	@Column
	private double cotCosto;
	
	@Column
	private String cotTiempoEjecucion;
	
	@Column
	private String cotGarantia;
	
	@Column
	private String cotVigenciaCotizacion;
	
	@Column
	private String cotVisualizacion;

	public int getCotId() {
		return cotId;
	}

	public void setCotId(int cotId) {
		this.cotId = cotId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getCotFechaCarga() {
		return cotFechaCarga;
	}

	public void setCotFechaCarga(String cotFechaCarga) {
		this.cotFechaCarga = cotFechaCarga;
	}

	public String getCotNombreCotizacion() {
		return cotNombreCotizacion;
	}

	public void setCotNombreCotizacion(String cotNombreCotizacion) {
		this.cotNombreCotizacion = cotNombreCotizacion;
	}

	public String getCotDescripcion() {
		return cotDescripcion;
	}

	public void setCotDescripcion(String cotDescripcion) {
		this.cotDescripcion = cotDescripcion;
	}

	public String getCotArchivo() {
		return cotArchivo;
	}

	public void setCotArchivo(String cotArchivo) {
		this.cotArchivo = cotArchivo;
	}

	public String getCotLog() {
		return cotLog;
	}

	public void setCotLog(String cotLog) {
		this.cotLog = cotLog;
	}

	public double getCotCosto() {
		return cotCosto;
	}

	public void setCotCosto(double cotCosto) {
		this.cotCosto = cotCosto;
	}

	public String getCotTiempoEjecucion() {
		return cotTiempoEjecucion;
	}

	public void setCotTiempoEjecucion(String cotTiempoEjecucion) {
		this.cotTiempoEjecucion = cotTiempoEjecucion;
	}

	public String getCotGarantia() {
		return cotGarantia;
	}

	public void setCotGarantia(String cotGarantia) {
		this.cotGarantia = cotGarantia;
	}

	public String getCotVigenciaCotizacion() {
		return cotVigenciaCotizacion;
	}

	public void setCotVigenciaCotizacion(String cotVigenciaCotizacion) {
		this.cotVigenciaCotizacion = cotVigenciaCotizacion;
	}

	public String getCotVisualizacion() {
		return cotVisualizacion;
	}

	public void setCotVisualizacion(String cotVisualizacion) {
		this.cotVisualizacion = cotVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((cotArchivo == null) ? 0 : cotArchivo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cotCosto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cotDescripcion == null) ? 0 : cotDescripcion.hashCode());
		result = prime * result + ((cotFechaCarga == null) ? 0 : cotFechaCarga.hashCode());
		result = prime * result + ((cotGarantia == null) ? 0 : cotGarantia.hashCode());
		result = prime * result + cotId;
		result = prime * result + ((cotLog == null) ? 0 : cotLog.hashCode());
		result = prime * result + ((cotNombreCotizacion == null) ? 0 : cotNombreCotizacion.hashCode());
		result = prime * result + ((cotTiempoEjecucion == null) ? 0 : cotTiempoEjecucion.hashCode());
		result = prime * result + ((cotVigenciaCotizacion == null) ? 0 : cotVigenciaCotizacion.hashCode());
		result = prime * result + ((cotVisualizacion == null) ? 0 : cotVisualizacion.hashCode());
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
		Cotizaciones other = (Cotizaciones) obj;
		if (copNit != other.copNit)
			return false;
		if (cotArchivo == null) {
			if (other.cotArchivo != null)
				return false;
		} else if (!cotArchivo.equals(other.cotArchivo))
			return false;
		if (Double.doubleToLongBits(cotCosto) != Double.doubleToLongBits(other.cotCosto))
			return false;
		if (cotDescripcion == null) {
			if (other.cotDescripcion != null)
				return false;
		} else if (!cotDescripcion.equals(other.cotDescripcion))
			return false;
		if (cotFechaCarga == null) {
			if (other.cotFechaCarga != null)
				return false;
		} else if (!cotFechaCarga.equals(other.cotFechaCarga))
			return false;
		if (cotGarantia == null) {
			if (other.cotGarantia != null)
				return false;
		} else if (!cotGarantia.equals(other.cotGarantia))
			return false;
		if (cotId != other.cotId)
			return false;
		if (cotLog == null) {
			if (other.cotLog != null)
				return false;
		} else if (!cotLog.equals(other.cotLog))
			return false;
		if (cotNombreCotizacion == null) {
			if (other.cotNombreCotizacion != null)
				return false;
		} else if (!cotNombreCotizacion.equals(other.cotNombreCotizacion))
			return false;
		if (cotTiempoEjecucion == null) {
			if (other.cotTiempoEjecucion != null)
				return false;
		} else if (!cotTiempoEjecucion.equals(other.cotTiempoEjecucion))
			return false;
		if (cotVigenciaCotizacion == null) {
			if (other.cotVigenciaCotizacion != null)
				return false;
		} else if (!cotVigenciaCotizacion.equals(other.cotVigenciaCotizacion))
			return false;
		if (cotVisualizacion == null) {
			if (other.cotVisualizacion != null)
				return false;
		} else if (!cotVisualizacion.equals(other.cotVisualizacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cotizaciones [cotId=" + cotId + ", copNit=" + copNit + ", cotFechaCarga=" + cotFechaCarga
				+ ", cotNombreCotizacion=" + cotNombreCotizacion + ", cotDescripcion=" + cotDescripcion
				+ ", cotArchivo=" + cotArchivo + ", cotLog=" + cotLog + ", cotCosto=" + cotCosto
				+ ", cotTiempoEjecucion=" + cotTiempoEjecucion + ", cotGarantia=" + cotGarantia
				+ ", cotVigenciaCotizacion=" + cotVigenciaCotizacion + ", cotVisualizacion=" + cotVisualizacion + "]";
	}

	

}
=======
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
public class Cotizaciones implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8598405990535435601L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int cotId;
	
	@Column
	private int copNit;
	
	@Column
	private String cotFechaCarga;
	
	@Column
	private String cotNombreCotizacion;
	
	@Column
	private String cotDescripcion;
	
	@Column
	private String cotArchivo;
	
	@Column
	private String cotLog;
	
	@Column
	private double cotCosto;
	
	@Column
	private String cotTiempoEjecucion;
	
	@Column
	private String cotGarantia;
	
	@Column
	private String cotVigenciaCotizacion;
	
	@Column
	private String cotVisualizacion;

	public int getCotId() {
		return cotId;
	}

	public void setCotId(int cotId) {
		this.cotId = cotId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getCotFechaCarga() {
		return cotFechaCarga;
	}

	public void setCotFechaCarga(String cotFechaCarga) {
		this.cotFechaCarga = cotFechaCarga;
	}

	public String getCotNombreCotizacion() {
		return cotNombreCotizacion;
	}

	public void setCotNombreCotizacion(String cotNombreCotizacion) {
		this.cotNombreCotizacion = cotNombreCotizacion;
	}

	public String getCotDescripcion() {
		return cotDescripcion;
	}

	public void setCotDescripcion(String cotDescripcion) {
		this.cotDescripcion = cotDescripcion;
	}

	public String getCotArchivo() {
		return cotArchivo;
	}

	public void setCotArchivo(String cotArchivo) {
		this.cotArchivo = cotArchivo;
	}

	public String getCotLog() {
		return cotLog;
	}

	public void setCotLog(String cotLog) {
		this.cotLog = cotLog;
	}

	public double getCotCosto() {
		return cotCosto;
	}

	public void setCotCosto(double cotCosto) {
		this.cotCosto = cotCosto;
	}

	public String getCotTiempoEjecucion() {
		return cotTiempoEjecucion;
	}

	public void setCotTiempoEjecucion(String cotTiempoEjecucion) {
		this.cotTiempoEjecucion = cotTiempoEjecucion;
	}

	public String getCotGarantia() {
		return cotGarantia;
	}

	public void setCotGarantia(String cotGarantia) {
		this.cotGarantia = cotGarantia;
	}

	public String getCotVigenciaCotizacion() {
		return cotVigenciaCotizacion;
	}

	public void setCotVigenciaCotizacion(String cotVigenciaCotizacion) {
		this.cotVigenciaCotizacion = cotVigenciaCotizacion;
	}

	public String getCotVisualizacion() {
		return cotVisualizacion;
	}

	public void setCotVisualizacion(String cotVisualizacion) {
		this.cotVisualizacion = cotVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((cotArchivo == null) ? 0 : cotArchivo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cotCosto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cotDescripcion == null) ? 0 : cotDescripcion.hashCode());
		result = prime * result + ((cotFechaCarga == null) ? 0 : cotFechaCarga.hashCode());
		result = prime * result + ((cotGarantia == null) ? 0 : cotGarantia.hashCode());
		result = prime * result + cotId;
		result = prime * result + ((cotLog == null) ? 0 : cotLog.hashCode());
		result = prime * result + ((cotNombreCotizacion == null) ? 0 : cotNombreCotizacion.hashCode());
		result = prime * result + ((cotTiempoEjecucion == null) ? 0 : cotTiempoEjecucion.hashCode());
		result = prime * result + ((cotVigenciaCotizacion == null) ? 0 : cotVigenciaCotizacion.hashCode());
		result = prime * result + ((cotVisualizacion == null) ? 0 : cotVisualizacion.hashCode());
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
		Cotizaciones other = (Cotizaciones) obj;
		if (copNit != other.copNit)
			return false;
		if (cotArchivo == null) {
			if (other.cotArchivo != null)
				return false;
		} else if (!cotArchivo.equals(other.cotArchivo))
			return false;
		if (Double.doubleToLongBits(cotCosto) != Double.doubleToLongBits(other.cotCosto))
			return false;
		if (cotDescripcion == null) {
			if (other.cotDescripcion != null)
				return false;
		} else if (!cotDescripcion.equals(other.cotDescripcion))
			return false;
		if (cotFechaCarga == null) {
			if (other.cotFechaCarga != null)
				return false;
		} else if (!cotFechaCarga.equals(other.cotFechaCarga))
			return false;
		if (cotGarantia == null) {
			if (other.cotGarantia != null)
				return false;
		} else if (!cotGarantia.equals(other.cotGarantia))
			return false;
		if (cotId != other.cotId)
			return false;
		if (cotLog == null) {
			if (other.cotLog != null)
				return false;
		} else if (!cotLog.equals(other.cotLog))
			return false;
		if (cotNombreCotizacion == null) {
			if (other.cotNombreCotizacion != null)
				return false;
		} else if (!cotNombreCotizacion.equals(other.cotNombreCotizacion))
			return false;
		if (cotTiempoEjecucion == null) {
			if (other.cotTiempoEjecucion != null)
				return false;
		} else if (!cotTiempoEjecucion.equals(other.cotTiempoEjecucion))
			return false;
		if (cotVigenciaCotizacion == null) {
			if (other.cotVigenciaCotizacion != null)
				return false;
		} else if (!cotVigenciaCotizacion.equals(other.cotVigenciaCotizacion))
			return false;
		if (cotVisualizacion == null) {
			if (other.cotVisualizacion != null)
				return false;
		} else if (!cotVisualizacion.equals(other.cotVisualizacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cotizaciones [cotId=" + cotId + ", copNit=" + copNit + ", cotFechaCarga=" + cotFechaCarga
				+ ", cotNombreCotizacion=" + cotNombreCotizacion + ", cotDescripcion=" + cotDescripcion
				+ ", cotArchivo=" + cotArchivo + ", cotLog=" + cotLog + ", cotCosto=" + cotCosto
				+ ", cotTiempoEjecucion=" + cotTiempoEjecucion + ", cotGarantia=" + cotGarantia
				+ ", cotVigenciaCotizacion=" + cotVigenciaCotizacion + ", cotVisualizacion=" + cotVisualizacion + "]";
	}

	

}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
