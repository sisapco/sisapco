package co.com.sisapco.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity	
public class ControlPagos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -170002685475211872L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int controlId;
	
	@Column
	private int copNit;
	
	@Column
	private String controlNombreProveedor;
		
	@Column
	private String controlDescripcion;
	
	@Column
	private Double controlValor;
	
	@Column
	private String controlFechaPago;
	
	@Column
	private String controlEstadoPago;
	
	@Column
	private String controlEstado;
	
	@Column
	private String controlObservacion;
	
	@Column
	private String controlAdjunto;

	public int getControlId() {
		return controlId;
	}

	public void setControlId(int controlId) {
		this.controlId = controlId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getControlNombreProveedor() {
		return controlNombreProveedor;
	}

	public void setControlNombreProveedor(String controlNombreProveedor) {
		this.controlNombreProveedor = controlNombreProveedor;
	}

	public String getControlDescripcion() {
		return controlDescripcion;
	}

	public void setControlDescripcion(String controlDescripcion) {
		this.controlDescripcion = controlDescripcion;
	}

	public Double getControlValor() {
		return controlValor;
	}

	public void setControlValor(Double controlValor) {
		this.controlValor = controlValor;
	}

	public String getControlFechaPago() {
		return controlFechaPago;
	}

	public void setControlFechaPago(String controlFechaPago) {
		this.controlFechaPago = controlFechaPago;
	}

	public String getControlEstadoPago() {
		return controlEstadoPago;
	}

	public void setControlEstadoPago(String controlEstadoPago) {
		this.controlEstadoPago = controlEstadoPago;
	}

	public String getControlEstado() {
		return controlEstado;
	}

	public void setControlEstado(String controlEstado) {
		this.controlEstado = controlEstado;
	}

	public String getControlObservacion() {
		return controlObservacion;
	}

	public void setControlObservacion(String controlObservacion) {
		this.controlObservacion = controlObservacion;
	}

	public String getControlAdjunto() {
		return controlAdjunto;
	}

	public void setControlAdjunto(String controlAdjunto) {
		this.controlAdjunto = controlAdjunto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controlAdjunto == null) ? 0 : controlAdjunto.hashCode());
		result = prime * result + ((controlDescripcion == null) ? 0 : controlDescripcion.hashCode());
		result = prime * result + ((controlEstado == null) ? 0 : controlEstado.hashCode());
		result = prime * result + ((controlEstadoPago == null) ? 0 : controlEstadoPago.hashCode());
		result = prime * result + ((controlFechaPago == null) ? 0 : controlFechaPago.hashCode());
		result = prime * result + controlId;
		result = prime * result + ((controlNombreProveedor == null) ? 0 : controlNombreProveedor.hashCode());
		result = prime * result + ((controlObservacion == null) ? 0 : controlObservacion.hashCode());
		result = prime * result + ((controlValor == null) ? 0 : controlValor.hashCode());
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
		ControlPagos other = (ControlPagos) obj;
		if (controlAdjunto == null) {
			if (other.controlAdjunto != null)
				return false;
		} else if (!controlAdjunto.equals(other.controlAdjunto))
			return false;
		if (controlDescripcion == null) {
			if (other.controlDescripcion != null)
				return false;
		} else if (!controlDescripcion.equals(other.controlDescripcion))
			return false;
		if (controlEstado == null) {
			if (other.controlEstado != null)
				return false;
		} else if (!controlEstado.equals(other.controlEstado))
			return false;
		if (controlEstadoPago == null) {
			if (other.controlEstadoPago != null)
				return false;
		} else if (!controlEstadoPago.equals(other.controlEstadoPago))
			return false;
		if (controlFechaPago == null) {
			if (other.controlFechaPago != null)
				return false;
		} else if (!controlFechaPago.equals(other.controlFechaPago))
			return false;
		if (controlId != other.controlId)
			return false;
		if (controlNombreProveedor == null) {
			if (other.controlNombreProveedor != null)
				return false;
		} else if (!controlNombreProveedor.equals(other.controlNombreProveedor))
			return false;
		if (controlObservacion == null) {
			if (other.controlObservacion != null)
				return false;
		} else if (!controlObservacion.equals(other.controlObservacion))
			return false;
		if (controlValor == null) {
			if (other.controlValor != null)
				return false;
		} else if (!controlValor.equals(other.controlValor))
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ControlPagos [controlId=" + controlId + ", copNit=" + copNit + ", controlNombreProveedor="
				+ controlNombreProveedor + ", controlDescripcion=" + controlDescripcion + ", controlValor="
				+ controlValor + ", controlFechaPago=" + controlFechaPago + ", controlEstadoPago=" + controlEstadoPago
				+ ", controlEstado=" + controlEstado + ", controlObservacion=" + controlObservacion
				+ ", controlAdjunto=" + controlAdjunto + "]";
	}

	

}