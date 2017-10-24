package org.kiosk.dto;

import java.sql.Date;

public class Com_videoDTO {
	private int vi_no;
	private String vi_name;
	private String vi_video;
	private Date vi_ndt;

	public int getVi_no() {
		return vi_no;
	}

	public void setVi_no(int vi_no) {
		this.vi_no = vi_no;
	}

	public String getVi_name() {
		return vi_name;
	}

	public void setVi_name(String vi_name) {
		this.vi_name = vi_name;
	}

	public String getVi_video() {
		return vi_video;
	}

	public void setVi_video(String vi_video) {
		this.vi_video = vi_video;
	}

	public Date getVi_ndt() {
		return vi_ndt;
	}

	public void setVi_ndt(Date vi_ndt) {
		this.vi_ndt = vi_ndt;
	}

	@Override
	public String toString() {
		return "Com_videoVO [vi_no=" + vi_no + ", vi_name=" + vi_name + ", vi_video=" + vi_video + ", vi_ndt=" + vi_ndt
				+ "]";
	}

}
