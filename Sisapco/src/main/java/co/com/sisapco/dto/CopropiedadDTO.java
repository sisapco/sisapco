<<<<<<< HEAD
package co.com.sisapco.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class CopropiedadDTO {
	
	private int copId;
	private int copNit;
	private String copNombreCopropiedad;
	private String copEstado;
	private String copDireccion;
	private String copTelefono;
	private String copUbicacion;
	private String copBarrio;
	private String copEmail;
	private String copCarpeta;
	private Date copFechaCreacion;
	private Date copFechaFin;
	private String codLogo;
	private String codLog;
	private String copIdEncryted;
	
	public CopropiedadDTO() {
		super();
		this.copId = copId;
		this.copNit = copNit;
		this.copNombreCopropiedad = copNombreCopropiedad;
		this.copEstado = copEstado;
		this.copDireccion = copDireccion;
		this.copTelefono = copTelefono;
		this.copUbicacion = copUbicacion;
		this.copBarrio = copBarrio;
		this.copEmail = copEmail;
		this.copCarpeta = copCarpeta;
		this.copFechaCreacion = copFechaCreacion;
		this.copFechaFin = copFechaFin;
		this.codLogo = codLogo;
		this.codLog = codLog;
		this.copIdEncryted= copIdEncryted;
	}

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

	public Date getCopFechaCreacion() {
		return copFechaCreacion;
	}

	public void setCopFechaCreacion(Date copFechaCreacion) {
		this.copFechaCreacion = copFechaCreacion;
	}

	public Date getCopFechaFin() {
		return copFechaFin;
	}

	public void setCopFechaFin(Date copFechaFin) {
		this.copFechaFin = copFechaFin;
	}

	public String getCodLogo() {
		return codLogo;
	}

	public void setCodLogo(String codLogo) {
		this.codLogo = codLogo;
	}

	public String getCodLog() {
		return codLog;
	}

	public void setCodLog(String codLog) {
		this.codLog = codLog;
	}

	public String getCopIdEncryted() {
		return copIdEncryted;
	}

	public void setCopIdEncryted(String copIdEncryted) {
		this.copIdEncryted = copIdEncryted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLog == null) ? 0 : codLog.hashCode());
		result = prime * result + ((codLogo == null) ? 0 : codLogo.hashCode());
		result = prime * result + ((copBarrio == null) ? 0 : copBarrio.hashCode());
		result = prime * result + ((copCarpeta == null) ? 0 : copCarpeta.hashCode());
		result = prime * result + ((copDireccion == null) ? 0 : copDireccion.hashCode());
		result = prime * result + ((copEmail == null) ? 0 : copEmail.hashCode());
		result = prime * result + ((copEstado == null) ? 0 : copEstado.hashCode());
		result = prime * result + ((copFechaCreacion == null) ? 0 : copFechaCreacion.hashCode());
		result = prime * result + ((copFechaFin == null) ? 0 : copFechaFin.hashCode());
		result = prime * result + copId;
		result = prime * result + ((copIdEncryted == null) ? 0 : copIdEncryted.hashCode());
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
		CopropiedadDTO other = (CopropiedadDTO) obj;
		if (codLog == null) {
			if (other.codLog != null)
				return false;
		} else if (!codLog.equals(other.codLog))
			return false;
		if (codLogo == null) {
			if (other.codLogo != null)
				return false;
		} else if (!codLogo.equals(other.codLogo))
			return false;
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
		if (copIdEncryted == null) {
			if (other.copIdEncryted != null)
				return false;
		} else if (!copIdEncryted.equals(other.copIdEncryted))
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
		return "CopropiedadDTO [copId=" + copId + ", copNit=" + copNit + ", copNombreCopropiedad="
				+ copNombreCopropiedad + ", copEstado=" + copEstado + ", copDireccion=" + copDireccion
				+ ", copTelefono=" + copTelefono + ", copUbicacion=" + copUbicacion + ", copBarrio=" + copBarrio
				+ ", copEmail=" + copEmail + ", copCarpeta=" + copCarpeta + ", copFechaCreacion=" + copFechaCreacion
				+ ", copFechaFin=" + copFechaFin + ", codLogo=" + codLogo + ", codLog=" + codLog + ", copIdEncryted="
				+ copIdEncryted + "]";
	}



	
}
=======
package co.com.sisapco.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class CopropiedadDTO {
	
	private int copId;
	private int copNit;
	private String copNombreCopropiedad;
	private String copEstado;
	private String copDireccion;
	private String copTelefono;
	private String copUbicacion;
	private String copBarrio;
	private String copEmail;
	private String copCarpeta;
	private Date copFechaCreacion;
	private Date copFechaFin;
	private String codLogo;
	private String codLog;
	private String copIdEncryted;
	
	public CopropiedadDTO() {
		super();
		this.copId = copId;
		this.copNit = copNit;
		this.copNombreCopropiedad = copNombreCopropiedad;
		this.copEstado = copEstado;
		this.copDireccion = copDireccion;
		this.copTelefono = copTelefono;
		this.copUbicacion = copUbicacion;
		this.copBarrio = copBarrio;
		this.copEmail = copEmail;
		this.copCarpeta = copCarpeta;
		this.copFechaCreacion = copFechaCreacion;
		this.copFechaFin = copFechaFin;
		this.codLogo = codLogo;
		this.codLog = codLog;
		this.copIdEncryted= copIdEncryted;
	}

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

	public Date getCopFechaCreacion() {
		return copFechaCreacion;
	}

	public void setCopFechaCreacion(Date copFechaCreacion) {
		this.copFechaCreacion = copFechaCreacion;
	}

	public Date getCopFechaFin() {
		return copFechaFin;
	}

	public void setCopFechaFin(Date copFechaFin) {
		this.copFechaFin = copFechaFin;
	}

	public String getCodLogo() {
		return codLogo;
	}

	public void setCodLogo(String codLogo) {
		this.codLogo = codLogo;
	}

	public String getCodLog() {
		return codLog;
	}

	public void setCodLog(String codLog) {
		this.codLog = codLog;
	}

	public String getCopIdEncryted() {
		return copIdEncryted;
	}

	public void setCopIdEncryted(String copIdEncryted) {
		this.copIdEncryted = copIdEncryted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLog == null) ? 0 : codLog.hashCode());
		result = prime * result + ((codLogo == null) ? 0 : codLogo.hashCode());
		result = prime * result + ((copBarrio == null) ? 0 : copBarrio.hashCode());
		result = prime * result + ((copCarpeta == null) ? 0 : copCarpeta.hashCode());
		result = prime * result + ((copDireccion == null) ? 0 : copDireccion.hashCode());
		result = prime * result + ((copEmail == null) ? 0 : copEmail.hashCode());
		result = prime * result + ((copEstado == null) ? 0 : copEstado.hashCode());
		result = prime * result + ((copFechaCreacion == null) ? 0 : copFechaCreacion.hashCode());
		result = prime * result + ((copFechaFin == null) ? 0 : copFechaFin.hashCode());
		result = prime * result + copId;
		result = prime * result + ((copIdEncryted == null) ? 0 : copIdEncryted.hashCode());
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
		CopropiedadDTO other = (CopropiedadDTO) obj;
		if (codLog == null) {
			if (other.codLog != null)
				return false;
		} else if (!codLog.equals(other.codLog))
			return false;
		if (codLogo == null) {
			if (other.codLogo != null)
				return false;
		} else if (!codLogo.equals(other.codLogo))
			return false;
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
		if (copIdEncryted == null) {
			if (other.copIdEncryted != null)
				return false;
		} else if (!copIdEncryted.equals(other.copIdEncryted))
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
		return "CopropiedadDTO [copId=" + copId + ", copNit=" + copNit + ", copNombreCopropiedad="
				+ copNombreCopropiedad + ", copEstado=" + copEstado + ", copDireccion=" + copDireccion
				+ ", copTelefono=" + copTelefono + ", copUbicacion=" + copUbicacion + ", copBarrio=" + copBarrio
				+ ", copEmail=" + copEmail + ", copCarpeta=" + copCarpeta + ", copFechaCreacion=" + copFechaCreacion
				+ ", copFechaFin=" + copFechaFin + ", codLogo=" + codLogo + ", codLog=" + codLog + ", copIdEncryted="
				+ copIdEncryted + "]";
	}



	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
