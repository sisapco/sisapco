package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Dane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3890573317965271483L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int idDane;
	
	@Column
	private String codigoDepartamento;
	
	@Column
	private String nombreDepartamento;
	
	@Column
	private String cotNombreCotizacion;
	
	@Column
	private String codigoMunicipio;
	
	@Column
	private String nombreMunicipio;

	public int getIdDane() {
		return idDane;
	}

	public void setIdDane(int idDane) {
		this.idDane = idDane;
	}

	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getCotNombreCotizacion() {
		return cotNombreCotizacion;
	}

	public void setCotNombreCotizacion(String cotNombreCotizacion) {
		this.cotNombreCotizacion = cotNombreCotizacion;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDepartamento == null) ? 0 : codigoDepartamento.hashCode());
		result = prime * result + ((codigoMunicipio == null) ? 0 : codigoMunicipio.hashCode());
		result = prime * result + ((cotNombreCotizacion == null) ? 0 : cotNombreCotizacion.hashCode());
		result = prime * result + idDane;
		result = prime * result + ((nombreDepartamento == null) ? 0 : nombreDepartamento.hashCode());
		result = prime * result + ((nombreMunicipio == null) ? 0 : nombreMunicipio.hashCode());
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
		Dane other = (Dane) obj;
		if (codigoDepartamento == null) {
			if (other.codigoDepartamento != null)
				return false;
		} else if (!codigoDepartamento.equals(other.codigoDepartamento))
			return false;
		if (codigoMunicipio == null) {
			if (other.codigoMunicipio != null)
				return false;
		} else if (!codigoMunicipio.equals(other.codigoMunicipio))
			return false;
		if (cotNombreCotizacion == null) {
			if (other.cotNombreCotizacion != null)
				return false;
		} else if (!cotNombreCotizacion.equals(other.cotNombreCotizacion))
			return false;
		if (idDane != other.idDane)
			return false;
		if (nombreDepartamento == null) {
			if (other.nombreDepartamento != null)
				return false;
		} else if (!nombreDepartamento.equals(other.nombreDepartamento))
			return false;
		if (nombreMunicipio == null) {
			if (other.nombreMunicipio != null)
				return false;
		} else if (!nombreMunicipio.equals(other.nombreMunicipio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dane [idDane=" + idDane + ", codigoDepartamento=" + codigoDepartamento + ", nombreDepartamento="
				+ nombreDepartamento + ", cotNombreCotizacion=" + cotNombreCotizacion + ", codigoMunicipio="
				+ codigoMunicipio + ", nombreMunicipio=" + nombreMunicipio + "]";
	}


}
