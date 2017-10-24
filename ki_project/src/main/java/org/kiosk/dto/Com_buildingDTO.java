package org.kiosk.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Com_buildingDTO {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int bu_no;
	private String bu_name;
	private String bu_img;
	private Date bu_ndt;

	public int getBu_no() {
		return bu_no;
	}

	public void setBu_no(int bu_no) {
		this.bu_no = bu_no;
	}

	public String getBu_name() {
		return bu_name;
	}

	public void setBu_name(String bu_name) {
		this.bu_name = bu_name;
	}

	public String getBu_img() {
		return bu_img;
	}

	public void setBu_img(String bu_img) {
		this.bu_img = bu_img;
	}

	public Date getBu_ndt() {
		return bu_ndt;
	}

	public void setBu_ndt(Date bu_ndt) {
		this.bu_ndt = bu_ndt;
	}

	@Override
	public String toString() {
		return "Com_buildingDTO [bu_no=" + bu_no + ", bu_name=" + bu_name + ", bu_img=" + bu_img + ", bu_ndt=" + bu_ndt
				+ "]";
	}



}
