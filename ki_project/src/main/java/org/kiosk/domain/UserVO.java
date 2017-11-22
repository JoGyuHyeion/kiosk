package org.kiosk.domain;

public class UserVO {

	private String id;
	private String name;
	private String password;
	private int auth;
	private String sessionkey;
	private String sessionlimit;
	private String section_fullcode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getSessionkey() {
		return sessionkey;
	}

	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}

	public String getSessionlimit() {
		return sessionlimit;
	}

	public void setSessionlimit(String sessionlimit) {
		this.sessionlimit = sessionlimit;
	}

	public String getSection_fullcode() {
		return section_fullcode;
	}

	public void setSection_fullcode(String section_fullcode) {
		this.section_fullcode = section_fullcode;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", auth=" + auth + ", sessionkey="
				+ sessionkey + ", sessionlimit=" + sessionlimit + ", section_fullcode=" + section_fullcode + "]";
	}

}
