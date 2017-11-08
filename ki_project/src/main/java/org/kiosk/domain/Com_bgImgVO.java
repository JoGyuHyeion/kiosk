package org.kiosk.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Com_bgImgVO {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int bi_no;
	private String bi_name;
	private String bi_img;
	private boolean bi_able;
	private Date bi_ndt;

	public int getBi_no() {
		return bi_no;
	}

	public void setBi_no(int bi_no) {
		this.bi_no = bi_no;
	}

	public String getBi_name() {
		return bi_name;
	}

	public void setBi_name(String bi_name) {
		this.bi_name = bi_name;
	}

	public String getBi_img() {
		return bi_img;
	}

	public void setBi_img(String bi_img) {
		this.bi_img = bi_img;
	}

	public boolean isBi_able() {
		return bi_able;
	}

	public void setBi_able(boolean bi_able) {
		this.bi_able = bi_able;
	}

	public Date getBi_ndt() {
		return bi_ndt;
	}

	public void setBi_ndt(Date bi_ndt) {
		this.bi_ndt = bi_ndt;
	}

	@Override
	public String toString() {
		return "Com_bgImgDTO [bi_no=" + bi_no + ", bi_name=" + bi_name + ", bi_img=" + bi_img + ", bi_able=" + bi_able
				+ ", bi_ndt=" + bi_ndt + "]";
	}

}
