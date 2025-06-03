package co.com.sisapco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9221840126136244758L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int estId;
	
	@Column
	private int estIdCodigo;
	
	@Column
	private String estValorEstado;

	public int getEstId() {
		return estId;
	}

	public void setEstId(int estId) {
		this.estId = estId;
	}

	public int getEstIdCodigo() {
		return estIdCodigo;
	}

	public void setEstIdCodigo(int estIdCodigo) {
		this.estIdCodigo = estIdCodigo;
	}

	public String getEstValorEstado() {
		return estValorEstado;
	}

	public void setEstValorEstado(String estValorEstado) {
		this.estValorEstado = estValorEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + estId;
		result = prime * result + estIdCodigo;
		result = prime * result + ((estValorEstado == null) ? 0 : estValorEstado.hashCode());
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
		Estados other = (Estados) obj;
		if (estId != other.estId)
			return false;
		if (estIdCodigo != other.estIdCodigo)
			return false;
		if (estValorEstado == null) {
			if (other.estValorEstado != null)
				return false;
		} else if (!estValorEstado.equals(other.estValorEstado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estados [estId=" + estId + ", estIdCodigo=" + estIdCodigo + ", estValorEstado=" + estValorEstado + "]";
	}

}
