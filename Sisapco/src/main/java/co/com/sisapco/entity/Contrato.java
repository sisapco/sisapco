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
public class Contrato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3835186690019147053L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int contraId;
	
	@Column
	private String contraNumContrato;
	
	@Column
	private int copNit;
	
	@Column
	private String contraNombreContratista;
	
	@Column
	private String contraDescripcion;
	
	@Column
	private Date contraFechaInicio;
	
	@Column
	private Date contraFechaFin;
	
	@Column
	private int contraPlazo;
	
	@Column
	private String contraTiempo;
	
	@Column
	private double contraValor;
	
	@Column
	private String contraInterventor;
	
	@Column
	private String contraDocumentoAdjunto;
	
	@Column
	private String contraEstado;
	
	@Column
	private String contraObservaciones;
	
	@Column
	private String contraLog;
	
	@Column
	private String contraVisualizacion;

	public int getContraId() {
		return contraId;
	}

	public void setContraId(int contraId) {
		this.contraId = contraId;
	}

	public String getContraNumContrato() {
		return contraNumContrato;
	}

	public void setContraNumContrato(String contraNumContrato) {
		this.contraNumContrato = contraNumContrato;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getContraNombreContratista() {
		return contraNombreContratista;
	}

	public void setContraNombreContratista(String contraNombreContratista) {
		this.contraNombreContratista = contraNombreContratista;
	}

	public String getContraDescripcion() {
		return contraDescripcion;
	}

	public void setContraDescripcion(String contraDescripcion) {
		this.contraDescripcion = contraDescripcion;
	}

	public Date getContraFechaInicio() {
		return contraFechaInicio;
	}

	public void setContraFechaInicio(Date contraFechaInicio) {
		this.contraFechaInicio = contraFechaInicio;
	}

	public Date getContraFechaFin() {
		return contraFechaFin;
	}

	public void setContraFechaFin(Date contraFechaFin) {
		this.contraFechaFin = contraFechaFin;
	}

	public int getContraPlazo() {
		return contraPlazo;
	}

	public void setContraPlazo(int contraPlazo) {
		this.contraPlazo = contraPlazo;
	}

	public String getContraTiempo() {
		return contraTiempo;
	}

	public void setContraTiempo(String contraTiempo) {
		this.contraTiempo = contraTiempo;
	}

	public double getContraValor() {
		return contraValor;
	}

	public void setContraValor(double contraValor) {
		this.contraValor = contraValor;
	}

	public String getContraInterventor() {
		return contraInterventor;
	}

	public void setContraInterventor(String contraInterventor) {
		this.contraInterventor = contraInterventor;
	}

	public String getContraDocumentoAdjunto() {
		return contraDocumentoAdjunto;
	}

	public void setContraDocumentoAdjunto(String contraDocumentoAdjunto) {
		this.contraDocumentoAdjunto = contraDocumentoAdjunto;
	}

	public String getContraEstado() {
		return contraEstado;
	}

	public void setContraEstado(String contraEstado) {
		this.contraEstado = contraEstado;
	}

	public String getContraObservaciones() {
		return contraObservaciones;
	}

	public void setContraObservaciones(String contraObservaciones) {
		this.contraObservaciones = contraObservaciones;
	}

	public String getContraLog() {
		return contraLog;
	}

	public void setContraLog(String contraLog) {
		this.contraLog = contraLog;
	}

	public String getContraVisualizacion() {
		return contraVisualizacion;
	}

	public void setContraVisualizacion(String contraVisualizacion) {
		this.contraVisualizacion = contraVisualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contraDescripcion == null) ? 0 : contraDescripcion.hashCode());
		result = prime * result + ((contraDocumentoAdjunto == null) ? 0 : contraDocumentoAdjunto.hashCode());
		result = prime * result + ((contraEstado == null) ? 0 : contraEstado.hashCode());
		result = prime * result + ((contraFechaFin == null) ? 0 : contraFechaFin.hashCode());
		result = prime * result + ((contraFechaInicio == null) ? 0 : contraFechaInicio.hashCode());
		result = prime * result + contraId;
		result = prime * result + ((contraInterventor == null) ? 0 : contraInterventor.hashCode());
		result = prime * result + ((contraLog == null) ? 0 : contraLog.hashCode());
		result = prime * result + ((contraNombreContratista == null) ? 0 : contraNombreContratista.hashCode());
		result = prime * result + ((contraNumContrato == null) ? 0 : contraNumContrato.hashCode());
		result = prime * result + ((contraObservaciones == null) ? 0 : contraObservaciones.hashCode());
		result = prime * result + contraPlazo;
		result = prime * result + ((contraTiempo == null) ? 0 : contraTiempo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(contraValor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((contraVisualizacion == null) ? 0 : contraVisualizacion.hashCode());
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
		Contrato other = (Contrato) obj;
		if (contraDescripcion == null) {
			if (other.contraDescripcion != null)
				return false;
		} else if (!contraDescripcion.equals(other.contraDescripcion))
			return false;
		if (contraDocumentoAdjunto == null) {
			if (other.contraDocumentoAdjunto != null)
				return false;
		} else if (!contraDocumentoAdjunto.equals(other.contraDocumentoAdjunto))
			return false;
		if (contraEstado == null) {
			if (other.contraEstado != null)
				return false;
		} else if (!contraEstado.equals(other.contraEstado))
			return false;
		if (contraFechaFin == null) {
			if (other.contraFechaFin != null)
				return false;
		} else if (!contraFechaFin.equals(other.contraFechaFin))
			return false;
		if (contraFechaInicio == null) {
			if (other.contraFechaInicio != null)
				return false;
		} else if (!contraFechaInicio.equals(other.contraFechaInicio))
			return false;
		if (contraId != other.contraId)
			return false;
		if (contraInterventor == null) {
			if (other.contraInterventor != null)
				return false;
		} else if (!contraInterventor.equals(other.contraInterventor))
			return false;
		if (contraLog == null) {
			if (other.contraLog != null)
				return false;
		} else if (!contraLog.equals(other.contraLog))
			return false;
		if (contraNombreContratista == null) {
			if (other.contraNombreContratista != null)
				return false;
		} else if (!contraNombreContratista.equals(other.contraNombreContratista))
			return false;
		if (contraNumContrato == null) {
			if (other.contraNumContrato != null)
				return false;
		} else if (!contraNumContrato.equals(other.contraNumContrato))
			return false;
		if (contraObservaciones == null) {
			if (other.contraObservaciones != null)
				return false;
		} else if (!contraObservaciones.equals(other.contraObservaciones))
			return false;
		if (contraPlazo != other.contraPlazo)
			return false;
		if (contraTiempo == null) {
			if (other.contraTiempo != null)
				return false;
		} else if (!contraTiempo.equals(other.contraTiempo))
			return false;
		if (Double.doubleToLongBits(contraValor) != Double.doubleToLongBits(other.contraValor))
			return false;
		if (contraVisualizacion == null) {
			if (other.contraVisualizacion != null)
				return false;
		} else if (!contraVisualizacion.equals(other.contraVisualizacion))
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [contraId=" + contraId + ", contraNumContrato=" + contraNumContrato + ", copNit=" + copNit
				+ ", contraNombreContratista=" + contraNombreContratista + ", contraDescripcion=" + contraDescripcion
				+ ", contraFechaInicio=" + contraFechaInicio + ", contraFechaFin=" + contraFechaFin + ", contraPlazo="
				+ contraPlazo + ", contraTiempo=" + contraTiempo + ", contraValor=" + contraValor
				+ ", contraInterventor=" + contraInterventor + ", contraDocumentoAdjunto=" + contraDocumentoAdjunto
				+ ", contraEstado=" + contraEstado + ", contraObservaciones=" + contraObservaciones + ", contraLog="
				+ contraLog + ", contraVisualizacion=" + contraVisualizacion + "]";
	}
	
}
