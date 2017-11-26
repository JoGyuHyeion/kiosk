package org.kiosk.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Com_iconVO {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int ic_no;
	private String ic_name;
	private String ic_icon;
	private int ic_default;
	private Date ic_ndt;

	public int getIc_no() {
		return ic_no;
	}

	public void setIc_no(int ic_no) {
		this.ic_no = ic_no;
	}

	public String getIc_name() {
		return ic_name;
	}

	public void setIc_name(String ic_name) {
		this.ic_name = ic_name;
	}

	public String getIc_icon() {
		return ic_icon;
	}

	public void setIc_icon(String ic_icon) {
		this.ic_icon = ic_icon;
	}

	public int getIc_default() {
		return ic_default;
	}

	public void setIc_default(int ic_default) {
		this.ic_default = ic_default;
	}

	public Date getIc_ndt() {
		return ic_ndt;
	}

	public void setIc_ndt(Date ic_ndt) {
		this.ic_ndt = ic_ndt;
	}

	@Override
	public String toString() {
		return "Com_iconVO [ic_no=" + ic_no + ", ic_name=" + ic_name + ", ic_icon=" + ic_icon + ", ic_default="
				+ ic_default + ", ic_ndt=" + ic_ndt + "]";
	}

}
