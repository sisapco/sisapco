package co.com.sisapco.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ChangePasswordForm {
	
	    @NotNull
		private Long usuId;
		
		@NotBlank(message="Current Password must not be blank")
		private String currentPassword;

		@NotBlank(message="New Password must not be blank")
		private String newPassword;

		@NotBlank(message="Confirm Password must not be blank")
		private String confirmPassword;
		
		public ChangePasswordForm() { }
		public ChangePasswordForm(Long usuId) {this.usuId = usuId;}
		
		
		public Long getUsuId() {
			return usuId;
		}
		public void setUsuId(Long usuId) {
			this.usuId = usuId;
		}
		public String getCurrentPassword() {
			return currentPassword;
		}
		public void setCurrentPassword(String currentPassword) {
			this.currentPassword = currentPassword;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
			result = prime * result + ((currentPassword == null) ? 0 : currentPassword.hashCode());
			result = prime * result + ((usuId == null) ? 0 : usuId.hashCode());
			result = prime * result + ((newPassword == null) ? 0 : newPassword.hashCode());
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
			ChangePasswordForm other = (ChangePasswordForm) obj;
			if (confirmPassword == null) {
				if (other.confirmPassword != null)
					return false;
			} else if (!confirmPassword.equals(other.confirmPassword))
				return false;
			if (currentPassword == null) {
				if (other.currentPassword != null)
					return false;
			} else if (!currentPassword.equals(other.currentPassword))
				return false;
			if (usuId == null) {
				if (other.usuId != null)
					return false;
			} else if (!usuId.equals(other.usuId))
				return false;
			if (newPassword == null) {
				if (other.newPassword != null)
					return false;
			} else if (!newPassword.equals(other.newPassword))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "ChangePasswordForm [usuId=" + usuId + ", currentPassword=" + currentPassword + ", newPassword=" + newPassword
					+ ", confirmPassword=" + confirmPassword + "]";
		}

}
