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
public class AlmacenamientoGoogle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 822137901360067266L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private int almaId;
	
	@Column
	private int copId;
	
	@Column
	private int copNit;
	
	@Column
	private String almaCarpeta;
	
	@Column
	private String almaIdcarpeta;

	public int getAlmaId() {
		return almaId;
	}

	public void setAlmaId(int almaId) {
		this.almaId = almaId;
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

	public String getAlmaCarpeta() {
		return almaCarpeta;
	}

	public void setAlmaCarpeta(String almaCarpeta) {
		this.almaCarpeta = almaCarpeta;
	}

	public String getAlmaIdcarpeta() {
		return almaIdcarpeta;
	}

	public void setAlmaIdcarpeta(String almaIdcarpeta) {
		this.almaIdcarpeta = almaIdcarpeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((almaCarpeta == null) ? 0 : almaCarpeta.hashCode());
		result = prime * result + almaId;
		result = prime * result + ((almaIdcarpeta == null) ? 0 : almaIdcarpeta.hashCode());
		result = prime * result + copId;
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
		AlmacenamientoGoogle other = (AlmacenamientoGoogle) obj;
		if (almaCarpeta == null) {
			if (other.almaCarpeta != null)
				return false;
		} else if (!almaCarpeta.equals(other.almaCarpeta))
			return false;
		if (almaId != other.almaId)
			return false;
		if (almaIdcarpeta == null) {
			if (other.almaIdcarpeta != null)
				return false;
		} else if (!almaIdcarpeta.equals(other.almaIdcarpeta))
			return false;
		if (copId != other.copId)
			return false;
		if (copNit != other.copNit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlmacenamientoGoogle [almaId=" + almaId + ", copId=" + copId + ", copNit=" + copNit + ", almaCarpeta="
				+ almaCarpeta + ", almaIdcarpeta=" + almaIdcarpeta + "]";
	}
	
	

}
