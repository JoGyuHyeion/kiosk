package org.kiosk.domain;

import java.sql.Timestamp;

public class UserVO {

	private String id;
	private String name;
	private String password;
	private int auth;
	private String sessionkey;
	private String sessionlimit;

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

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", auth=" + auth + ", sessionkey="
				+ sessionkey + ", sessionlimit=" + sessionlimit + "]";
	}

}
