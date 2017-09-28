package org.zerock.domain;

public class Com_sectionVO {
	private String bureau_cd;
	private String section_cd;
	private String section_name;
	private String section_type;
	private String section_ip;
	private String section_id;
	private String section_pass;
	private String section_fullcode;
	private String section_use;
	private int section_author;

	public String getBureau_cd() {
		return bureau_cd;
	}

	public void setBureau_cd(String bureau_cd) {
		this.bureau_cd = bureau_cd;
	}

	public String getSection_cd() {
		return section_cd;
	}

	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public String getSection_type() {
		return section_type;
	}

	public void setSection_type(String section_type) {
		this.section_type = section_type;
	}

	public String getSection_ip() {
		return section_ip;
	}

	public void setSection_ip(String section_ip) {
		this.section_ip = section_ip;
	}

	public String getSection_id() {
		return section_id;
	}

	public void setSection_id(String section_id) {
		this.section_id = section_id;
	}

	public String getSection_pass() {
		return section_pass;
	}

	public void setSection_pass(String section_pass) {
		this.section_pass = section_pass;
	}

	public String getSection_fullcode() {
		return section_fullcode;
	}

	public void setSection_fullcode(String section_fullcode) {
		this.section_fullcode = section_fullcode;
	}

	public String getSection_use() {
		return section_use;
	}

	public void setSection_use(String section_use) {
		this.section_use = section_use;
	}

	public int getSection_author() {
		return section_author;
	}

	public void setSection_author(int section_author) {
		this.section_author = section_author;
	}

	@Override
	public String toString() {
		return "Com_sectionVO [bureau_cd=" + bureau_cd + ", section_cd=" + section_cd + ", section_name=" + section_name
				+ ", section_type=" + section_type + ", section_ip=" + section_ip + ", section_id=" + section_id
				+ ", section_pass=" + section_pass + ", section_fullcode=" + section_fullcode + ", section_use="
				+ section_use + ", section_author=" + section_author + "]";
	}

}
