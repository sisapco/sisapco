package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class SancionesMulta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6134147560777649054L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int mulId;
	
	@Column
	private int mulNumero;
	
	@Column
	private int proCc;
	
	@Column
	private int copNit;
	
	@Column
	private String proNombres;
	
	@Column
	private String proApellidos;
	
	@Column
	private String proNumeroResidencia;
	
	@Column
	private String mulDescripcion;

	@Column
	private String mulTipoSancion;

	@Column
	private String mulEstado;

	@Column
	private String mulFecha;
	
	@Column
	private String proDireccionCorrespondencia;
	
	@Column
	private String mulAdjuntoEvidencia;
	
	@Column
	private String proEmail;

	@Column
	private String mulValor;

	public int getMulId() {
		return mulId;
	}

	public void setMulId(int mulId) {
		this.mulId = mulId;
	}

	public int getMulNumero() {
		return mulNumero;
	}

	public void setMulNumero(int mulNumero) {
		this.mulNumero = mulNumero;
	}

	public int getProCc() {
		return proCc;
	}

	public void setProCc(int proCc) {
		this.proCc = proCc;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getProNombres() {
		return proNombres;
	}

	public void setProNombres(String proNombres) {
		this.proNombres = proNombres;
	}

	public String getProApellidos() {
		return proApellidos;
	}

	public void setProApellidos(String proApellidos) {
		this.proApellidos = proApellidos;
	}

	public String getProNumeroResidencia() {
		return proNumeroResidencia;
	}

	public void setProNumeroResidencia(String proNumeroResidencia) {
		this.proNumeroResidencia = proNumeroResidencia;
	}

	public String getMulDescripcion() {
		return mulDescripcion;
	}

	public void setMulDescripcion(String mulDescripcion) {
		this.mulDescripcion = mulDescripcion;
	}

	public String getMulTipoSancion() {
		return mulTipoSancion;
	}

	public void setMulTipoSancion(String mulTipoSancion) {
		this.mulTipoSancion = mulTipoSancion;
	}

	public String getMulEstado() {
		return mulEstado;
	}

	public void setMulEstado(String mulEstado) {
		this.mulEstado = mulEstado;
	}

	public String getMulFecha() {
		return mulFecha;
	}

	public void setMulFecha(String mulFecha) {
		this.mulFecha = mulFecha;
	}

	public String getProDireccionCorrespondencia() {
		return proDireccionCorrespondencia;
	}

	public void setProDireccionCorrespondencia(String proDireccionCorrespondencia) {
		this.proDireccionCorrespondencia = proDireccionCorrespondencia;
	}

	public String getMulAdjuntoEvidencia() {
		return mulAdjuntoEvidencia;
	}

	public void setMulAdjuntoEvidencia(String mulAdjuntoEvidencia) {
		this.mulAdjuntoEvidencia = mulAdjuntoEvidencia;
	}

	public String getProEmail() {
		return proEmail;
	}

	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}

	public String getMulValor() {
		return mulValor;
	}

	public void setMulValor(String mulValor) {
		this.mulValor = mulValor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((mulAdjuntoEvidencia == null) ? 0 : mulAdjuntoEvidencia.hashCode());
		result = prime * result + ((mulDescripcion == null) ? 0 : mulDescripcion.hashCode());
		result = prime * result + ((mulEstado == null) ? 0 : mulEstado.hashCode());
		result = prime * result + ((mulFecha == null) ? 0 : mulFecha.hashCode());
		result = prime * result + mulId;
		result = prime * result + mulNumero;
		result = prime * result + ((mulTipoSancion == null) ? 0 : mulTipoSancion.hashCode());
		result = prime * result + ((mulValor == null) ? 0 : mulValor.hashCode());
		result = prime * result + ((proApellidos == null) ? 0 : proApellidos.hashCode());
		result = prime * result + proCc;
		result = prime * result + ((proDireccionCorrespondencia == null) ? 0 : proDireccionCorrespondencia.hashCode());
		result = prime * result + ((proEmail == null) ? 0 : proEmail.hashCode());
		result = prime * result + ((proNombres == null) ? 0 : proNombres.hashCode());
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
		SancionesMulta other = (SancionesMulta) obj;
		if (copNit != other.copNit)
			return false;
		if (mulAdjuntoEvidencia == null) {
			if (other.mulAdjuntoEvidencia != null)
				return false;
		} else if (!mulAdjuntoEvidencia.equals(other.mulAdjuntoEvidencia))
			return false;
		if (mulDescripcion == null) {
			if (other.mulDescripcion != null)
				return false;
		} else if (!mulDescripcion.equals(other.mulDescripcion))
			return false;
		if (mulEstado == null) {
			if (other.mulEstado != null)
				return false;
		} else if (!mulEstado.equals(other.mulEstado))
			return false;
		if (mulFecha == null) {
			if (other.mulFecha != null)
				return false;
		} else if (!mulFecha.equals(other.mulFecha))
			return false;
		if (mulId != other.mulId)
			return false;
		if (mulNumero != other.mulNumero)
			return false;
		if (mulTipoSancion == null) {
			if (other.mulTipoSancion != null)
				return false;
		} else if (!mulTipoSancion.equals(other.mulTipoSancion))
			return false;
		if (mulValor == null) {
			if (other.mulValor != null)
				return false;
		} else if (!mulValor.equals(other.mulValor))
			return false;
		if (proApellidos == null) {
			if (other.proApellidos != null)
				return false;
		} else if (!proApellidos.equals(other.proApellidos))
			return false;
		if (proCc != other.proCc)
			return false;
		if (proDireccionCorrespondencia == null) {
			if (other.proDireccionCorrespondencia != null)
				return false;
		} else if (!proDireccionCorrespondencia.equals(other.proDireccionCorrespondencia))
			return false;
		if (proEmail == null) {
			if (other.proEmail != null)
				return false;
		} else if (!proEmail.equals(other.proEmail))
			return false;
		if (proNombres == null) {
			if (other.proNombres != null)
				return false;
		} else if (!proNombres.equals(other.proNombres))
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
		return "SancionesMulta [mulId=" + mulId + ", mulNumero=" + mulNumero + ", proCc=" + proCc + ", copNit=" + copNit
				+ ", proNombres=" + proNombres + ", proApellidos=" + proApellidos + ", proNumeroResidencia="
				+ proNumeroResidencia + ", mulDescripcion=" + mulDescripcion + ", mulTipoSancion=" + mulTipoSancion
				+ ", mulEstado=" + mulEstado + ", mulFecha=" + mulFecha + ", proDireccionCorrespondencia="
				+ proDireccionCorrespondencia + ", mulAdjuntoEvidencia=" + mulAdjuntoEvidencia + ", proEmail="
				+ proEmail + ", mulValor=" + mulValor + "]";
	}
	
	
	

}
