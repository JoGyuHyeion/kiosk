package org.kiosk.dto;

public class MateDTO {

	private int st_no;
	private String st_nm;
	private String st_position;
	private String st_job;
	private String st_tel;
	private String st_email;
	private String img_filenm;
	private int st_sort;
	private int st_status;

	public MateDTO() {
		super();
	}

	public MateDTO(int st_no, String st_nm, String st_position, String st_job, String st_tel, String st_email,
			String img_filenm, int st_sort, int st_status) {
		super();
		this.st_no = st_no;
		this.st_nm = st_nm;
		this.st_position = st_position;
		this.st_job = st_job;
		this.st_tel = st_tel;
		this.st_email = st_email;
		this.img_filenm = img_filenm;
		this.st_sort = st_sort;
		this.st_status = st_status;
	}

	public int getSt_no() {
		return st_no;
	}

	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}

	public String getSt_nm() {
		return st_nm;
	}

	public void setSt_nm(String st_nm) {
		this.st_nm = st_nm;
	}

	public String getSt_position() {
		return st_position;
	}

	public void setSt_position(String st_position) {
		this.st_position = st_position;
	}

	public String getSt_job() {
		return st_job;
	}

	public void setSt_job(String st_job) {
		this.st_job = st_job;
	}

	public String getSt_tel() {
		return st_tel;
	}

	public void setSt_tel(String st_tel) {
		this.st_tel = st_tel;
	}

	public String getSt_email() {
		return st_email;
	}

	public void setSt_email(String st_email) {
		this.st_email = st_email;
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
		return "MateDTO [st_no=" + st_no + ", st_nm=" + st_nm + ", st_position=" + st_position + ", st_job=" + st_job
				+ ", st_tel=" + st_tel + ", st_email=" + st_email + ", img_filenm=" + img_filenm + ", st_sort="
				+ st_sort + ", st_status=" + st_status + "]";
	}

}
