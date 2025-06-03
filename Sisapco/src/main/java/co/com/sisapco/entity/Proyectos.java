<<<<<<< HEAD
package co.com.sisapco.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.soap.Text;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proyectos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210009986518507006L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int proId;
	
	@Column
	private int copNit;
	
	@Column
	private String proNombre;
	
	@Column
	private String proDescripcion;
	
	@Column
	private String proResponsable;
	
	@Column
	private Date proFechaInicio;
	
	@Column
	private Date proFechaFinal;
	
	@Column
	private String proEstado;
	
	@Column
	private String proAvances;

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getProNombre() {
		return proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public String getProDescripcion() {
		return proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public String getProResponsable() {
		return proResponsable;
	}

	public void setProResponsable(String proResponsable) {
		this.proResponsable = proResponsable;
	}

	public Date getProFechaInicio() {
		return proFechaInicio;
	}

	public void setProFechaInicio(Date proFechaInicio) {
		this.proFechaInicio = proFechaInicio;
	}

	public Date getProFechaFinal() {
		return proFechaFinal;
	}

	public void setProFechaFinal(Date proFechaFinal) {
		this.proFechaFinal = proFechaFinal;
	}

	public String getProEstado() {
		return proEstado;
	}

	public void setProEstado(String proEstado) {
		this.proEstado = proEstado;
	}

	public String getProAvances() {
		return proAvances;
	}

	public void setProAvances(String proAvances) {
		this.proAvances = proAvances;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((proAvances == null) ? 0 : proAvances.hashCode());
		result = prime * result + ((proDescripcion == null) ? 0 : proDescripcion.hashCode());
		result = prime * result + ((proEstado == null) ? 0 : proEstado.hashCode());
		result = prime * result + ((proFechaFinal == null) ? 0 : proFechaFinal.hashCode());
		result = prime * result + ((proFechaInicio == null) ? 0 : proFechaInicio.hashCode());
		result = prime * result + proId;
		result = prime * result + ((proNombre == null) ? 0 : proNombre.hashCode());
		result = prime * result + ((proResponsable == null) ? 0 : proResponsable.hashCode());
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
		Proyectos other = (Proyectos) obj;
		if (copNit != other.copNit)
			return false;
		if (proAvances == null) {
			if (other.proAvances != null)
				return false;
		} else if (!proAvances.equals(other.proAvances))
			return false;
		if (proDescripcion == null) {
			if (other.proDescripcion != null)
				return false;
		} else if (!proDescripcion.equals(other.proDescripcion))
			return false;
		if (proEstado == null) {
			if (other.proEstado != null)
				return false;
		} else if (!proEstado.equals(other.proEstado))
			return false;
		if (proFechaFinal == null) {
			if (other.proFechaFinal != null)
				return false;
		} else if (!proFechaFinal.equals(other.proFechaFinal))
			return false;
		if (proFechaInicio == null) {
			if (other.proFechaInicio != null)
				return false;
		} else if (!proFechaInicio.equals(other.proFechaInicio))
			return false;
		if (proId != other.proId)
			return false;
		if (proNombre == null) {
			if (other.proNombre != null)
				return false;
		} else if (!proNombre.equals(other.proNombre))
			return false;
		if (proResponsable == null) {
			if (other.proResponsable != null)
				return false;
		} else if (!proResponsable.equals(other.proResponsable))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proyectos [proId=" + proId + ", copNit=" + copNit + ", proNombre=" + proNombre + ", proDescripcion="
				+ proDescripcion + ", proResponsable=" + proResponsable + ", proFechaInicio=" + proFechaInicio
				+ ", proFechaFinal=" + proFechaFinal + ", proEstado=" + proEstado + ", proAvances=" + proAvances + "]";
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
import javax.xml.soap.Text;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proyectos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210009986518507006L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int proId;
	
	@Column
	private int copNit;
	
	@Column
	private String proNombre;
	
	@Column
	private String proDescripcion;
	
	@Column
	private String proResponsable;
	
	@Column
	private Date proFechaInicio;
	
	@Column
	private Date proFechaFinal;
	
	@Column
	private String proEstado;
	
	@Column
	private String proAvances;

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	public String getProNombre() {
		return proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public String getProDescripcion() {
		return proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public String getProResponsable() {
		return proResponsable;
	}

	public void setProResponsable(String proResponsable) {
		this.proResponsable = proResponsable;
	}

	public Date getProFechaInicio() {
		return proFechaInicio;
	}

	public void setProFechaInicio(Date proFechaInicio) {
		this.proFechaInicio = proFechaInicio;
	}

	public Date getProFechaFinal() {
		return proFechaFinal;
	}

	public void setProFechaFinal(Date proFechaFinal) {
		this.proFechaFinal = proFechaFinal;
	}

	public String getProEstado() {
		return proEstado;
	}

	public void setProEstado(String proEstado) {
		this.proEstado = proEstado;
	}

	public String getProAvances() {
		return proAvances;
	}

	public void setProAvances(String proAvances) {
		this.proAvances = proAvances;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((proAvances == null) ? 0 : proAvances.hashCode());
		result = prime * result + ((proDescripcion == null) ? 0 : proDescripcion.hashCode());
		result = prime * result + ((proEstado == null) ? 0 : proEstado.hashCode());
		result = prime * result + ((proFechaFinal == null) ? 0 : proFechaFinal.hashCode());
		result = prime * result + ((proFechaInicio == null) ? 0 : proFechaInicio.hashCode());
		result = prime * result + proId;
		result = prime * result + ((proNombre == null) ? 0 : proNombre.hashCode());
		result = prime * result + ((proResponsable == null) ? 0 : proResponsable.hashCode());
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
		Proyectos other = (Proyectos) obj;
		if (copNit != other.copNit)
			return false;
		if (proAvances == null) {
			if (other.proAvances != null)
				return false;
		} else if (!proAvances.equals(other.proAvances))
			return false;
		if (proDescripcion == null) {
			if (other.proDescripcion != null)
				return false;
		} else if (!proDescripcion.equals(other.proDescripcion))
			return false;
		if (proEstado == null) {
			if (other.proEstado != null)
				return false;
		} else if (!proEstado.equals(other.proEstado))
			return false;
		if (proFechaFinal == null) {
			if (other.proFechaFinal != null)
				return false;
		} else if (!proFechaFinal.equals(other.proFechaFinal))
			return false;
		if (proFechaInicio == null) {
			if (other.proFechaInicio != null)
				return false;
		} else if (!proFechaInicio.equals(other.proFechaInicio))
			return false;
		if (proId != other.proId)
			return false;
		if (proNombre == null) {
			if (other.proNombre != null)
				return false;
		} else if (!proNombre.equals(other.proNombre))
			return false;
		if (proResponsable == null) {
			if (other.proResponsable != null)
				return false;
		} else if (!proResponsable.equals(other.proResponsable))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proyectos [proId=" + proId + ", copNit=" + copNit + ", proNombre=" + proNombre + ", proDescripcion="
				+ proDescripcion + ", proResponsable=" + proResponsable + ", proFechaInicio=" + proFechaInicio
				+ ", proFechaFinal=" + proFechaFinal + ", proEstado=" + proEstado + ", proAvances=" + proAvances + "]";
	}

}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
