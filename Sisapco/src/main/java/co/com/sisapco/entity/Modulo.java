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
public class Modulo implements Serializable{

	/**
	 * 
	 */
   private static final long serialVersionUID = -7622333870312185314L;
	
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
   @GenericGenerator(name="native",strategy="native")
   private Long modId;
   
   @Column
   @NotBlank
   private String modNombre;
   
   @Column
   @NotBlank
   private int modEstado;

   @Column
   @NotBlank
   private int perId;
   
   @Column
   @NotBlank
   private int modOrdenamiento;
   
   @Column
   @NotBlank
   private String modRutaPlantilla;
   
   @Column
   @NotBlank
   private String modLog;
   
   @Column
   @NotBlank
   private String modLogo;

public Long getModId() {
	return modId;
}

public void setModId(Long modId) {
	this.modId = modId;
}

public String getModNombre() {
	return modNombre;
}

public void setModNombre(String modNombre) {
	this.modNombre = modNombre;
}

public int getModEstado() {
	return modEstado;
}

public void setModEstado(int modEstado) {
	this.modEstado = modEstado;
}

public int getPerId() {
	return perId;
}

public void setPerId(int perId) {
	this.perId = perId;
}

public int getModOrdenamiento() {
	return modOrdenamiento;
}

public void setModOrdenamiento(int modOrdenamiento) {
	this.modOrdenamiento = modOrdenamiento;
}

public String getModRutaPlantilla() {
	return modRutaPlantilla;
}

public void setModRutaPlantilla(String modRutaPlantilla) {
	this.modRutaPlantilla = modRutaPlantilla;
}

public String getModLog() {
	return modLog;
}

public void setModLog(String modLog) {
	this.modLog = modLog;
}

public String getModLogo() {
	return modLogo;
}

public void setModLogo(String modLogo) {
	this.modLogo = modLogo;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + modEstado;
	result = prime * result + ((modId == null) ? 0 : modId.hashCode());
	result = prime * result + ((modLog == null) ? 0 : modLog.hashCode());
	result = prime * result + ((modLogo == null) ? 0 : modLogo.hashCode());
	result = prime * result + ((modNombre == null) ? 0 : modNombre.hashCode());
	result = prime * result + modOrdenamiento;
	result = prime * result + ((modRutaPlantilla == null) ? 0 : modRutaPlantilla.hashCode());
	result = prime * result + perId;
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
	Modulo other = (Modulo) obj;
	if (modEstado != other.modEstado)
		return false;
	if (modId == null) {
		if (other.modId != null)
			return false;
	} else if (!modId.equals(other.modId))
		return false;
	if (modLog == null) {
		if (other.modLog != null)
			return false;
	} else if (!modLog.equals(other.modLog))
		return false;
	if (modLogo == null) {
		if (other.modLogo != null)
			return false;
	} else if (!modLogo.equals(other.modLogo))
		return false;
	if (modNombre == null) {
		if (other.modNombre != null)
			return false;
	} else if (!modNombre.equals(other.modNombre))
		return false;
	if (modOrdenamiento != other.modOrdenamiento)
		return false;
	if (modRutaPlantilla == null) {
		if (other.modRutaPlantilla != null)
			return false;
	} else if (!modRutaPlantilla.equals(other.modRutaPlantilla))
		return false;
	if (perId != other.perId)
		return false;
	return true;
}

@Override
public String toString() {
	return "Modulo [modId=" + modId + ", modNombre=" + modNombre + ", modEstado=" + modEstado + ", perId=" + perId
			+ ", modOrdenamiento=" + modOrdenamiento + ", modRutaPlantilla=" + modRutaPlantilla + ", modLog=" + modLog
			+ ", modLogo=" + modLogo + "]";
}



	
   
}
