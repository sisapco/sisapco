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
public class Copropiedad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2060041027426524493L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int copId;
	
	@Column
	private int copNit;
	
	@Column
	private String copNombreCopropiedad;
	
	@Column
	private String copEstado;
	
	@Column
	private String copDireccion;
	
	@Column
	private String copTelefono;
	
	@Column
	private String copUbicacion;
	
	@Column
	private String copBarrio;
	
	@Column
	private String copEmail;
	
	@Column
	private String copCarpeta;
	
	@Column
	private String copFechaCreacion;
	
	@Column 
	private String copFechaFin;
	
	@Column 
	private String copLogo;
	
	@Column 
	private String copLog;

	public int getCopId() {
		return copId;
	}

	public void setCopId(int copId) {
		this.copId = copId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getCopNombreCopropiedad() {
		return copNombreCopropiedad;
	}

	public void setCopNombreCopropiedad(String copNombreCopropiedad) {
		this.copNombreCopropiedad = copNombreCopropiedad;
	}

	public String getCopEstado() {
		return copEstado;
	}

	public void setCopEstado(String copEstado) {
		this.copEstado = copEstado;
	}

	public String getCopDireccion() {
		return copDireccion;
	}

	public void setCopDireccion(String copDireccion) {
		this.copDireccion = copDireccion;
	}

	public String getCopTelefono() {
		return copTelefono;
	}

	public void setCopTelefono(String copTelefono) {
		this.copTelefono = copTelefono;
	}

	public String getCopUbicacion() {
		return copUbicacion;
	}

	public void setCopUbicacion(String copUbicacion) {
		this.copUbicacion = copUbicacion;
	}

	public String getCopBarrio() {
		return copBarrio;
	}

	public void setCopBarrio(String copBarrio) {
		this.copBarrio = copBarrio;
	}

	public String getCopEmail() {
		return copEmail;
	}

	public void setCopEmail(String copEmail) {
		this.copEmail = copEmail;
	}

	public String getCopCarpeta() {
		return copCarpeta;
	}

	public void setCopCarpeta(String copCarpeta) {
		this.copCarpeta = copCarpeta;
	}

	public String getCopFechaCreacion() {
		return copFechaCreacion;
	}

	public void setCopFechaCreacion(String copFechaCreacion) {
		this.copFechaCreacion = copFechaCreacion;
	}

	public String getCopFechaFin() {
		return copFechaFin;
	}

	public void setCopFechaFin(String copFechaFin) {
		this.copFechaFin = copFechaFin;
	}

	public String getCopLogo() {
		return copLogo;
	}

	public void setCopLogo(String copLogo) {
		this.copLogo = copLogo;
	}

	public String getCopLog() {
		return copLog;
	}

	public void setCopLog(String copLog) {
		this.copLog = copLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copBarrio == null) ? 0 : copBarrio.hashCode());
		result = prime * result + ((copCarpeta == null) ? 0 : copCarpeta.hashCode());
		result = prime * result + ((copDireccion == null) ? 0 : copDireccion.hashCode());
		result = prime * result + ((copEmail == null) ? 0 : copEmail.hashCode());
		result = prime * result + ((copEstado == null) ? 0 : copEstado.hashCode());
		result = prime * result + ((copFechaCreacion == null) ? 0 : copFechaCreacion.hashCode());
		result = prime * result + ((copFechaFin == null) ? 0 : copFechaFin.hashCode());
		result = prime * result + copId;
		result = prime * result + ((copLog == null) ? 0 : copLog.hashCode());
		result = prime * result + ((copLogo == null) ? 0 : copLogo.hashCode());
		result = prime * result + copNit;
		result = prime * result + ((copNombreCopropiedad == null) ? 0 : copNombreCopropiedad.hashCode());
		result = prime * result + ((copTelefono == null) ? 0 : copTelefono.hashCode());
		result = prime * result + ((copUbicacion == null) ? 0 : copUbicacion.hashCode());
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
		Copropiedad other = (Copropiedad) obj;
		if (copBarrio == null) {
			if (other.copBarrio != null)
				return false;
		} else if (!copBarrio.equals(other.copBarrio))
			return false;
		if (copCarpeta == null) {
			if (other.copCarpeta != null)
				return false;
		} else if (!copCarpeta.equals(other.copCarpeta))
			return false;
		if (copDireccion == null) {
			if (other.copDireccion != null)
				return false;
		} else if (!copDireccion.equals(other.copDireccion))
			return false;
		if (copEmail == null) {
			if (other.copEmail != null)
				return false;
		} else if (!copEmail.equals(other.copEmail))
			return false;
		if (copEstado == null) {
			if (other.copEstado != null)
				return false;
		} else if (!copEstado.equals(other.copEstado))
			return false;
		if (copFechaCreacion == null) {
			if (other.copFechaCreacion != null)
				return false;
		} else if (!copFechaCreacion.equals(other.copFechaCreacion))
			return false;
		if (copFechaFin == null) {
			if (other.copFechaFin != null)
				return false;
		} else if (!copFechaFin.equals(other.copFechaFin))
			return false;
		if (copId != other.copId)
			return false;
		if (copLog == null) {
			if (other.copLog != null)
				return false;
		} else if (!copLog.equals(other.copLog))
			return false;
		if (copLogo == null) {
			if (other.copLogo != null)
				return false;
		} else if (!copLogo.equals(other.copLogo))
			return false;
		if (copNit != other.copNit)
			return false;
		if (copNombreCopropiedad == null) {
			if (other.copNombreCopropiedad != null)
				return false;
		} else if (!copNombreCopropiedad.equals(other.copNombreCopropiedad))
			return false;
		if (copTelefono == null) {
			if (other.copTelefono != null)
				return false;
		} else if (!copTelefono.equals(other.copTelefono))
			return false;
		if (copUbicacion == null) {
			if (other.copUbicacion != null)
				return false;
		} else if (!copUbicacion.equals(other.copUbicacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Copropiedad [copId=" + copId + ", copNit=" + copNit + ", copNombreCopropiedad=" + copNombreCopropiedad
				+ ", copEstado=" + copEstado + ", copDireccion=" + copDireccion + ", copTelefono=" + copTelefono
				+ ", copUbicacion=" + copUbicacion + ", copBarrio=" + copBarrio + ", copEmail=" + copEmail
				+ ", copCarpeta=" + copCarpeta + ", copFechaCreacion=" + copFechaCreacion + ", copFechaFin="
				+ copFechaFin + ", copLogo=" + copLogo + ", copLog=" + copLog + "]";
	}

	
}
