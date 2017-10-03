package org.zerock.domain;

import java.sql.Date;

public class Com_menuVO {
	private int menu_no;
	private String menu_cd;
	private String menu_nm;
	private String menu_icon;
	private String menu_url;
	private String menu_target;
	private String menu_pcd;
	private int menu_lv;
	private int menu_inx;
	private String menu_fullnm;
	private String menu_summary;
	private String menu_user;
	private int menu_use;
	private Date menu_dt;

	public int getMenu_no() {
		return menu_no;
	}

	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
	}

	public String getMenu_cd() {
		return menu_cd;
	}

	public void setMenu_cd(String menu_cd) {
		this.menu_cd = menu_cd;
	}

	public String getMenu_nm() {
		return menu_nm;
	}

	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}

	public String getMenu_icon() {
		return menu_icon;
	}

	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	public String getMenu_target() {
		return menu_target;
	}

	public void setMenu_target(String menu_target) {
		this.menu_target = menu_target;
	}

	public String getMenu_pcd() {
		return menu_pcd;
	}

	public void setMenu_pcd(String menu_pcd) {
		this.menu_pcd = menu_pcd;
	}

	public int getMenu_lv() {
		return menu_lv;
	}

	public void setMenu_lv(int menu_lv) {
		this.menu_lv = menu_lv;
	}

	public int getMenu_inx() {
		return menu_inx;
	}

	public void setMenu_inx(int menu_inx) {
		this.menu_inx = menu_inx;
	}

	public String getMenu_fullnm() {
		return menu_fullnm;
	}

	public void setMenu_fullnm(String menu_fullnm) {
		this.menu_fullnm = menu_fullnm;
	}

	public String getMenu_summary() {
		return menu_summary;
	}

	public void setMenu_summary(String menu_summary) {
		this.menu_summary = menu_summary;
	}

	public String getMenu_user() {
		return menu_user;
	}

	public void setMenu_user(String menu_user) {
		this.menu_user = menu_user;
	}

	public int getMenu_use() {
		return menu_use;
	}

	public void setMenu_use(int menu_use) {
		this.menu_use = menu_use;
	}

	public Date getMenu_dt() {
		return menu_dt;
	}

	public void setMenu_dt(Date menu_dt) {
		this.menu_dt = menu_dt;
	}

	@Override
	public String toString() {
		return "Com_menuVO [menu_no=" + menu_no + ", menu_cd=" + menu_cd + ", menu_nm=" + menu_nm + ", menu_icon="
				+ menu_icon + ", menu_url=" + menu_url + ", menu_target=" + menu_target + ", menu_pcd=" + menu_pcd
				+ ", menu_lv=" + menu_lv + ", menu_inx=" + menu_inx + ", menu_fullnm=" + menu_fullnm + ", menu_summary="
				+ menu_summary + ", menu_user=" + menu_user + ", menu_use=" + menu_use + ", menu_dt=" + menu_dt + "]";
	}

}
