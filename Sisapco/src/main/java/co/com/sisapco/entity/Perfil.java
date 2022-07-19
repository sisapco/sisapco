package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Perfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2292530687640403433L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private int perId;
	
	@Column
	private String perNombrePerfil;
	
	@Column
	private String perModulo;
	
	@Column
	private int perEstado;

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPerNombrePerfil() {
		return perNombrePerfil;
	}

	public void setPerNombrePerfil(String perNombrePerfil) {
		this.perNombrePerfil = perNombrePerfil;
	}

	public String getPerModulo() {
		return perModulo;
	}

	public void setPerModulo(String perModulo) {
		this.perModulo = perModulo;
	}

	public int getPerEstado() {
		return perEstado;
	}

	public void setPerEstado(int perEstado) {
		this.perEstado = perEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + perEstado;
		result = prime * result + perId;
		result = prime * result + ((perModulo == null) ? 0 : perModulo.hashCode());
		result = prime * result + ((perNombrePerfil == null) ? 0 : perNombrePerfil.hashCode());
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
		Perfil other = (Perfil) obj;
		if (perEstado != other.perEstado)
			return false;
		if (perId != other.perId)
			return false;
		if (perModulo == null) {
			if (other.perModulo != null)
				return false;
		} else if (!perModulo.equals(other.perModulo))
			return false;
		if (perNombrePerfil == null) {
			if (other.perNombrePerfil != null)
				return false;
		} else if (!perNombrePerfil.equals(other.perNombrePerfil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfil [perId=" + perId + ", perNombrePerfil=" + perNombrePerfil + ", perModulo=" + perModulo
				+ ", perEstado=" + perEstado + "]";
	}
	
}
