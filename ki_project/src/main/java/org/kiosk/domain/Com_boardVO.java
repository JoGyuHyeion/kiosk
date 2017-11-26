package org.kiosk.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component("Com_boardVO")
public class Com_boardVO {

	private int bbs_no;
	private String brd_cd;
	private int bbs_pno;
	private int bbs_lv;
	private int bbs_sort;
	private String bbs_title;
	private String bbs_content;
	private String bbs_file;
	private int bbs_notice;
	private String bbs_tag;
	private String bbs_cate;
	private int bbs_hits;
	private int bbs_state;
	private String section_cd;
	private int bbs_exp_inx;
	private Date bbs_exp_sdt;
	private Date bbs_exp_edt;
	private Date bbs_ndt;
	private Date bbs_edt;

	public int getBbs_no() {
		return bbs_no;
	}

	public void setBbs_no(int bbs_no) {
		this.bbs_no = bbs_no;
	}

	public String getBrd_cd() {
		return brd_cd;
	}

	public void setBrd_cd(String brd_cd) {
		this.brd_cd = brd_cd;
	}

	public int getBbs_pno() {
		return bbs_pno;
	}

	public void setBbs_pno(int bbs_pno) {
		this.bbs_pno = bbs_pno;
	}

	public int getBbs_lv() {
		return bbs_lv;
	}

	public void setBbs_lv(int bbs_lv) {
		this.bbs_lv = bbs_lv;
	}

	public int getBbs_sort() {
		return bbs_sort;
	}

	public void setBbs_sort(int bbs_sort) {
		this.bbs_sort = bbs_sort;
	}

	public String getBbs_title() {
		return bbs_title;
	}

	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}

	public String getBbs_content() {
		return bbs_content;
	}

	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}

	public String getBbs_file() {
		return bbs_file;
	}

	public void setBbs_file(String bbs_file) {
		this.bbs_file = bbs_file;
	}

	public int getBbs_notice() {
		return bbs_notice;
	}

	public void setBbs_notice(int bbs_notice) {
		this.bbs_notice = bbs_notice;
	}

	public String getBbs_tag() {
		return bbs_tag;
	}

	public void setBbs_tag(String bbs_tag) {
		this.bbs_tag = bbs_tag;
	}

	public String getBbs_cate() {
		return bbs_cate;
	}

	public void setBbs_cate(String bbs_cate) {
		this.bbs_cate = bbs_cate;
	}

	public int getBbs_hits() {
		return bbs_hits;
	}

	public void setBbs_hits(int bbs_hits) {
		this.bbs_hits = bbs_hits;
	}

	public int getBbs_state() {
		return bbs_state;
	}

	public void setBbs_state(int bbs_state) {
		this.bbs_state = bbs_state;
	}

	public String getSection_cd() {
		return section_cd;
	}

	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}

	public int getBbs_exp_inx() {
		return bbs_exp_inx;
	}

	public void setBbs_exp_inx(int bbs_exp_inx) {
		this.bbs_exp_inx = bbs_exp_inx;
	}

	public Date getBbs_exp_sdt() {
		return bbs_exp_sdt;
	}

	public void setBbs_exp_sdt(Date bbs_exp_sdt) {
		this.bbs_exp_sdt = bbs_exp_sdt;
	}

	public Date getBbs_exp_edt() {
		return bbs_exp_edt;
	}

	public void setBbs_exp_edt(Date bbs_exp_edt) {
		this.bbs_exp_edt = bbs_exp_edt;
	}

	public Date getBbs_ndt() {
		return bbs_ndt;
	}

	public void setBbs_ndt(Date bbs_ndt) {
		this.bbs_ndt = bbs_ndt;
	}

	public Date getBbs_edt() {
		return bbs_edt;
	}

	public void setBbs_edt(Date bbs_edt) {
		this.bbs_edt = bbs_edt;
	}

	@Override
	public String toString() {
		return "Com_boardVO [bbs_no=" + bbs_no + ", brd_cd=" + brd_cd + ", bbs_pno=" + bbs_pno + ", bbs_lv=" + bbs_lv
				+ ", bbs_sort=" + bbs_sort + ", bbs_title=" + bbs_title + ", bbs_content=" + bbs_content + ", bbs_file="
				+ bbs_file + ", bbs_notice=" + bbs_notice + ", bbs_tag=" + bbs_tag + ", bbs_cate=" + bbs_cate
				+ ", bbs_hits=" + bbs_hits + ", bbs_state=" + bbs_state + ", section_cd=" + section_cd
				+ ", bbs_exp_inx=" + bbs_exp_inx + ", bbs_exp_sdt=" + bbs_exp_sdt + ", bbs_exp_edt=" + bbs_exp_edt
				+ ", bbs_ndt=" + bbs_ndt + ", bbs_edt=" + bbs_edt + "]";
	}

}
