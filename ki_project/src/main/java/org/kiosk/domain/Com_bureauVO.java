package org.kiosk.domain;

public class Com_bureauVO {

	private String bureau_cd;
	private String bureau_name;
	private String bureau_use;

	public String getBureau_cd() {
		return bureau_cd;
	}

	public void setBureau_cd(String bureau_cd) {
		this.bureau_cd = bureau_cd;
	}

	public String getBureau_name() {
		return bureau_name;
	}

	public void setBureau_name(String bureau_name) {
		this.bureau_name = bureau_name;
	}

	public String getBureau_use() {
		return bureau_use;
	}

	public void setBureau_use(String bureau_use) {
		this.bureau_use = bureau_use;
	}

	@Override
	public String toString() {
		return "Com_bureauVO [bureau_cd=" + bureau_cd + ", bureau_name=" + bureau_name + ", bureau_use=" + bureau_use
				+ "]";
	}

}
