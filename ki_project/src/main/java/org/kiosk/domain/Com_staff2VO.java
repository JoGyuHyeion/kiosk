package org.kiosk.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component("Com_staff2VO")
public class Com_staff2VO {

	private int st_no;
	private String real_use_dep_nm;
	private String usr_nm;
	private String logon_id;
	private String st_key;
	private String class_nm;
	private String posit_nm;
	private String telno;
	private String img_filenm;
	private String email_addr;
	private String usr_work_state_code_nm;
	private int st_status;
	private String engm_se;
	private String adi_info7;
	private int st_sort;
	private String section_cd;
	private String team_cd;
	private Date st_wdt;
	private Date st_edt;

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

	public String getUsr_nm() {
		return usr_nm;
	}

	public void setUsr_nm(String usr_nm) {
		this.usr_nm = usr_nm;
	}

	public String getLogon_id() {
		return logon_id;
	}

	public void setLogon_id(String logon_id) {
		this.logon_id = logon_id;
	}

	public String getSt_key() {
		return st_key;
	}

	public void setSt_key(String st_key) {
		this.st_key = st_key;
	}

	public String getClass_nm() {
		return class_nm;
	}

	public void setClass_nm(String class_nm) {
		this.class_nm = class_nm;
	}

	public String getPosit_nm() {
		return posit_nm;
	}

	public void setPosit_nm(String posit_nm) {
		this.posit_nm = posit_nm;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getImg_filenm() {
		return img_filenm;
	}

	public void setImg_filenm(String img_filenm) {
		this.img_filenm = img_filenm;
	}

	public String getEmail_addr() {
		return email_addr;
	}

	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}

	public String getUsr_work_state_code_nm() {
		return usr_work_state_code_nm;
	}

	public void setUsr_work_state_code_nm(String usr_work_state_code_nm) {
		this.usr_work_state_code_nm = usr_work_state_code_nm;
	}

	public int getSt_status() {
		return st_status;
	}

	public void setSt_status(int st_status) {
		this.st_status = st_status;
	}

	public String getEngm_se() {
		return engm_se;
	}

	public void setEngm_se(String engm_se) {
		this.engm_se = engm_se;
	}

	public String getAdi_info7() {
		return adi_info7;
	}

	public void setAdi_info7(String adi_info7) {
		this.adi_info7 = adi_info7;
	}

	public int getSt_sort() {
		return st_sort;
	}

	public void setSt_sort(int st_sort) {
		this.st_sort = st_sort;
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
		return "Com_staff2VO [st_no=" + st_no + ", real_use_dep_nm=" + real_use_dep_nm + ", usr_nm=" + usr_nm
				+ ", logon_id=" + logon_id + ", st_key=" + st_key + ", class_nm=" + class_nm + ", posit_nm=" + posit_nm
				+ ", telno=" + telno + ", img_filenm=" + img_filenm + ", email_addr=" + email_addr
				+ ", usr_work_state_code_nm=" + usr_work_state_code_nm + ", st_status=" + st_status + ", engm_se="
				+ engm_se + ", adi_info7=" + adi_info7 + ", st_sort=" + st_sort + ", section_cd=" + section_cd
				+ ", team_cd=" + team_cd + ", st_wdt=" + st_wdt + ", st_edt=" + st_edt + "]";
	}

}
