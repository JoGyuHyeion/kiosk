package org.kiosk.dto;

public class MateDTO {

	private int st_no;
	private String real_use_dep_nm;
	private String posit_nm;
	private String adi_info7;
	private String telno;
	private String email_addr;
	private String img_filenm;
	private int st_sort;
	private int st_status;

	public int getSt_no() {
		return st_no;
	}

	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}

	public String getReal_use_dep_nm() {
		return real_use_dep_nm;
	}

	public void setReal_use_dep_nm(String real_use_dep_nm) {
		this.real_use_dep_nm = real_use_dep_nm;
	}

	public String getPosit_nm() {
		return posit_nm;
	}

	public void setPosit_nm(String posit_nm) {
		this.posit_nm = posit_nm;
	}

	public String getAdi_info7() {
		return adi_info7;
	}

	public void setAdi_info7(String adi_info7) {
		this.adi_info7 = adi_info7;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getEmail_addr() {
		return email_addr;
	}

	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}

	public String getImg_filenm() {
		return img_filenm;
	}

	public void setImg_filenm(String img_filenm) {
		this.img_filenm = img_filenm;
	}

	public int getSt_sort() {
		return st_sort;
	}

	public void setSt_sort(int st_sort) {
		this.st_sort = st_sort;
	}

	public int getSt_status() {
		return st_status;
	}

	public void setSt_status(int st_status) {
		this.st_status = st_status;
	}

	@Override
	public String toString() {
		return "MateDTO [st_no=" + st_no + ", real_use_dep_nm=" + real_use_dep_nm + ", posit_nm=" + posit_nm
				+ ", adi_info7=" + adi_info7 + ", telno=" + telno + ", email_addr=" + email_addr + ", img_filenm="
				+ img_filenm + ", st_sort=" + st_sort + ", st_status=" + st_status + "]";
	}

}
