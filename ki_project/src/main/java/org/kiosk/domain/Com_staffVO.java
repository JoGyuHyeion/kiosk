package org.kiosk.domain;

import java.sql.Date;

public class Com_staffVO {

	private int st_no;
	private String st_nm;
	private String st_position;
	private String st_tel;
	private String st_email;
	private String st_job;
	private String st_profile;
	private String img_filenm;
	private String img_filenm1;
	private String section_cd;
	private String team_cd;
	private String st_team;
	private int st_sort;
	private int st_display;
	private int st_status;
	private Date st_wdt;
	private Date st_edt;

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

	public String getSt_job() {
		return st_job;
	}

	public void setSt_job(String st_job) {
		this.st_job = st_job;
	}

	public String getSt_profile() {
		return st_profile;
	}

	public void setSt_profile(String st_profile) {
		this.st_profile = st_profile;
	}

	public String getImg_filenm() {
		return img_filenm;
	}

	public void setImg_filenm(String img_filenm) {
		this.img_filenm = img_filenm;
	}

	public String getImg_filenm1() {
		return img_filenm1;
	}

	public void setImg_filenm1(String img_filenm1) {
		this.img_filenm1 = img_filenm1;
	}

	public String getSection_cd() {
		return section_cd;
	}

	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}

	public String getTeam_cd() {
		return team_cd;
	}

	public void setTeam_cd(String team_cd) {
		this.team_cd = team_cd;
	}

	public String getSt_team() {
		return st_team;
	}

	public void setSt_team(String st_team) {
		this.st_team = st_team;
	}

	public int getSt_sort() {
		return st_sort;
	}

	public void setSt_sort(int st_sort) {
		this.st_sort = st_sort;
	}

	public int getSt_display() {
		return st_display;
	}

	public void setSt_display(int st_display) {
		this.st_display = st_display;
	}

	public int getSt_status() {
		return st_status;
	}

	public void setSt_status(int st_status) {
		this.st_status = st_status;
	}

	public Date getSt_wdt() {
		return st_wdt;
	}

	public void setSt_wdt(Date st_wdt) {
		this.st_wdt = st_wdt;
	}

	public Date getSt_edt() {
		return st_edt;
	}

	public void setSt_edt(Date st_edt) {
		this.st_edt = st_edt;
	}

	@Override
	public String toString() {
		return "Com_staffVO [st_no=" + st_no + ", st_nm=" + st_nm + ", st_position=" + st_position + ", st_tel="
				+ st_tel + ", st_email=" + st_email + ", st_job=" + st_job + ", st_profile=" + st_profile
				+ ", img_filenm=" + img_filenm + ", img_filenm1=" + img_filenm1 + ", section_cd=" + section_cd
				+ ", team_cd=" + team_cd + ", st_team=" + st_team + ", st_sort=" + st_sort + ", st_display="
				+ st_display + ", st_status=" + st_status + ", st_wdt=" + st_wdt + ", st_edt=" + st_edt + "]";
	}

}
