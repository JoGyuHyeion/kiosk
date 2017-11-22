package org.kiosk.dto;

public class LoginDTO {

	private String id;
	private String password;
	private String oldPassword;
	private String section_fullcode;
	private boolean useCookie;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getSection_fullcode() {
		return section_fullcode;
	}

	public void setSection_fullcode(String section_fullcode) {
		this.section_fullcode = section_fullcode;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", password=" + password + ", oldPassword=" + oldPassword + ", section_fullcode="
				+ section_fullcode + ", useCookie=" + useCookie + "]";
	}

}
