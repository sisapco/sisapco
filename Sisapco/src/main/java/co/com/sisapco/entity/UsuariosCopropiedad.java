<<<<<<< HEAD
package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UsuariosCopropiedad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2779261648921071204L;

	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	   @GenericGenerator(name="native",strategy="native")
	   private Long idUsuarioCopropiedad;
	   
	   @Column
	   @NotBlank
	   private int usuId;
	   
	   @Column
	   @NotBlank
	   private int copNit;

	public Long getIdUsuarioCopropiedad() {
		return idUsuarioCopropiedad;
	}

	public void setIdUsuarioCopropiedad(Long idUsuarioCopropiedad) {
		this.idUsuarioCopropiedad = idUsuarioCopropiedad;
	}

	public int getUsuId() {
		return usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((idUsuarioCopropiedad == null) ? 0 : idUsuarioCopropiedad.hashCode());
		result = prime * result + usuId;
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
		UsuariosCopropiedad other = (UsuariosCopropiedad) obj;
		if (copNit != other.copNit)
			return false;
		if (idUsuarioCopropiedad == null) {
			if (other.idUsuarioCopropiedad != null)
				return false;
		} else if (!idUsuarioCopropiedad.equals(other.idUsuarioCopropiedad))
			return false;
		if (usuId != other.usuId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuariosCopropiedad [idUsuarioCopropiedad=" + idUsuarioCopropiedad + ", usuId=" + usuId + ", copNit="
				+ copNit + "]";
	}

	
	
}
=======
package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UsuariosCopropiedad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2779261648921071204L;

	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	   @GenericGenerator(name="native",strategy="native")
	   private Long idUsuarioCopropiedad;
	   
	   @Column
	   @NotBlank
	   private int usuId;
	   
	   @Column
	   @NotBlank
	   private int copNit;

	public Long getIdUsuarioCopropiedad() {
		return idUsuarioCopropiedad;
	}

	public void setIdUsuarioCopropiedad(Long idUsuarioCopropiedad) {
		this.idUsuarioCopropiedad = idUsuarioCopropiedad;
	}

	public int getUsuId() {
		return usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public int getCopNit() {
		return copNit;
	}

	public void setCopNit(int copNit) {
		this.copNit = copNit;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + copNit;
		result = prime * result + ((idUsuarioCopropiedad == null) ? 0 : idUsuarioCopropiedad.hashCode());
		result = prime * result + usuId;
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
		UsuariosCopropiedad other = (UsuariosCopropiedad) obj;
		if (copNit != other.copNit)
			return false;
		if (idUsuarioCopropiedad == null) {
			if (other.idUsuarioCopropiedad != null)
				return false;
		} else if (!idUsuarioCopropiedad.equals(other.idUsuarioCopropiedad))
			return false;
		if (usuId != other.usuId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuariosCopropiedad [idUsuarioCopropiedad=" + idUsuarioCopropiedad + ", usuId=" + usuId + ", copNit="
				+ copNit + "]";
	}

	
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
