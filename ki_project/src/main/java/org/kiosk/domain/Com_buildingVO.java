package org.kiosk.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("building")
@Component("Com_buildingVO")
public class Com_buildingVO {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int bu_no;
	private String bu_name;
	private String bu_img;
	private Date bu_ndt;
	private int bu_type;

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

	public int getBu_type() {
		return bu_type;
	}

	public void setBu_type(int bu_type) {
		this.bu_type = bu_type;
	}

	@Override
	public String toString() {
		return "Com_buildingVO [bu_no=" + bu_no + ", bu_name=" + bu_name + ", bu_img=" + bu_img + ", bu_ndt=" + bu_ndt
				+ ", bu_type=" + bu_type + "]";
	}

}
