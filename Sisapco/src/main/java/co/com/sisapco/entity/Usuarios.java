<<<<<<< HEAD
package co.com.sisapco.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuarios implements Serializable{

	/**
	 * 
	 */
   private static final long serialVersionUID = -7823386239383854429L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
   @GenericGenerator(name="native",strategy="native")
   private Long usuId;
   
  /*@NotBlank  
  @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name="usuarios_copropiedad",
            joinColumns = @JoinColumn(name="usuId"),
            inverseJoinColumns = @JoinColumn(name="copId"))
   private Set<Copropiedad> copropiedades;
      */
   
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name="usuarios_perfil",
            joinColumns = @JoinColumn(name="usuId"),
            inverseJoinColumns = @JoinColumn(name="perId"))
   private Set<Perfil> perfiles;

   
   @Column
   @NotBlank
   private int perId;
   
   @Column
   @NotBlank
   private int proCc;
   
   
   @Column
   @NotBlank
   @Size(min=5,max=8, message="No se cumple las reglas de tamaño")
   private String username;
   
   @Column
   @NotBlank
   private String usuClave;
   
   @Transient
   @NotBlank
   private String confirmPassword;

   @Column
   @NotBlank
   private String usuEstado;

public Long getUsuId() {
	return usuId;
}

public void setUsuId(Long usuId) {
	this.usuId = usuId;
}

public int getPerId() {
	return perId;
}

public void setPerId(int perId) {
	this.perId = perId;
}

public int getProCc() {
	return proCc;
}

public void setProCc(int proCc) {
	this.proCc = proCc;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getUsuClave() {
	return usuClave;
}

public void setUsuClave(String usuClave) {
	this.usuClave = usuClave;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public String getUsuEstado() {
	return usuEstado;
}

public void setUsuEstado(String usuEstado) {
	this.usuEstado = usuEstado;
}




public Set<Perfil> getPerfiles() {
	return perfiles;
}

public void setPerfiles(Set<Perfil> perfiles) {
	this.perfiles = perfiles;
}





@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
	result = prime * result + perId;
	result = prime * result + ((perfiles == null) ? 0 : perfiles.hashCode());
	result = prime * result + proCc;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	result = prime * result + ((usuClave == null) ? 0 : usuClave.hashCode());
	result = prime * result + ((usuEstado == null) ? 0 : usuEstado.hashCode());
	result = prime * result + ((usuId == null) ? 0 : usuId.hashCode());
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
	Usuarios other = (Usuarios) obj;
	if (confirmPassword == null) {
		if (other.confirmPassword != null)
			return false;
	} else if (!confirmPassword.equals(other.confirmPassword))
		return false;
	if (perId != other.perId)
		return false;
	if (perfiles == null) {
		if (other.perfiles != null)
			return false;
	} else if (!perfiles.equals(other.perfiles))
		return false;
	if (proCc != other.proCc)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	if (usuClave == null) {
		if (other.usuClave != null)
			return false;
	} else if (!usuClave.equals(other.usuClave))
		return false;
	if (usuEstado == null) {
		if (other.usuEstado != null)
			return false;
	} else if (!usuEstado.equals(other.usuEstado))
		return false;
	if (usuId == null) {
		if (other.usuId != null)
			return false;
	} else if (!usuId.equals(other.usuId))
		return false;
	return true;
}

@Override
public String toString() {
	return "Usuarios [usuId=" + usuId + ", perfiles=" + perfiles + ", perId=" + perId + ", proCc=" + proCc
			+ ", username=" + username + ", usuClave=" + usuClave + ", confirmPassword=" + confirmPassword
			+ ", usuEstado=" + usuEstado + "]";
}


}
=======
package co.com.sisapco.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuarios implements Serializable{

	/**
	 * 
	 */
   private static final long serialVersionUID = -7823386239383854429L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
   @GenericGenerator(name="native",strategy="native")
   private Long usuId;
   
  /*@NotBlank  
  @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name="usuarios_copropiedad",
            joinColumns = @JoinColumn(name="usuId"),
            inverseJoinColumns = @JoinColumn(name="copId"))
   private Set<Copropiedad> copropiedades;
      */
   
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name="usuarios_perfil",
            joinColumns = @JoinColumn(name="usuId"),
            inverseJoinColumns = @JoinColumn(name="perId"))
   private Set<Perfil> perfiles;

   
   @Column
   @NotBlank
   private int perId;
   
   @Column
   @NotBlank
   private int proCc;
   
   
   @Column
   @NotBlank
   @Size(min=5,max=8, message="No se cumple las reglas de tamaño")
   private String username;
   
   @Column
   @NotBlank
   private String usuClave;
   
   @Transient
   @NotBlank
   private String confirmPassword;

   @Column
   @NotBlank
   private String usuEstado;

public Long getUsuId() {
	return usuId;
}

public void setUsuId(Long usuId) {
	this.usuId = usuId;
}

public int getPerId() {
	return perId;
}

public void setPerId(int perId) {
	this.perId = perId;
}

public int getProCc() {
	return proCc;
}

public void setProCc(int proCc) {
	this.proCc = proCc;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getUsuClave() {
	return usuClave;
}

public void setUsuClave(String usuClave) {
	this.usuClave = usuClave;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public String getUsuEstado() {
	return usuEstado;
}

public void setUsuEstado(String usuEstado) {
	this.usuEstado = usuEstado;
}




public Set<Perfil> getPerfiles() {
	return perfiles;
}

public void setPerfiles(Set<Perfil> perfiles) {
	this.perfiles = perfiles;
}





@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
	result = prime * result + perId;
	result = prime * result + ((perfiles == null) ? 0 : perfiles.hashCode());
	result = prime * result + proCc;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	result = prime * result + ((usuClave == null) ? 0 : usuClave.hashCode());
	result = prime * result + ((usuEstado == null) ? 0 : usuEstado.hashCode());
	result = prime * result + ((usuId == null) ? 0 : usuId.hashCode());
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
	Usuarios other = (Usuarios) obj;
	if (confirmPassword == null) {
		if (other.confirmPassword != null)
			return false;
	} else if (!confirmPassword.equals(other.confirmPassword))
		return false;
	if (perId != other.perId)
		return false;
	if (perfiles == null) {
		if (other.perfiles != null)
			return false;
	} else if (!perfiles.equals(other.perfiles))
		return false;
	if (proCc != other.proCc)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	if (usuClave == null) {
		if (other.usuClave != null)
			return false;
	} else if (!usuClave.equals(other.usuClave))
		return false;
	if (usuEstado == null) {
		if (other.usuEstado != null)
			return false;
	} else if (!usuEstado.equals(other.usuEstado))
		return false;
	if (usuId == null) {
		if (other.usuId != null)
			return false;
	} else if (!usuId.equals(other.usuId))
		return false;
	return true;
}

@Override
public String toString() {
	return "Usuarios [usuId=" + usuId + ", perfiles=" + perfiles + ", perId=" + perId + ", proCc=" + proCc
			+ ", username=" + username + ", usuClave=" + usuClave + ", confirmPassword=" + confirmPassword
			+ ", usuEstado=" + usuEstado + "]";
}


}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
