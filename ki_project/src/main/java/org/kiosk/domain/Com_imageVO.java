package org.kiosk.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component("Com_imageVO")
public class Com_imageVO {
	private int img_no;
	private String img_title;
	private String img_caption;
	private String img_filenm;
	private int img_gallery;
	private int img_sort;
	private String section_cd;
	private int img_status;
	private Date wdt;
	private Date edt;

	public int getImg_no() {
		return img_no;
	}

	public void setImg_no(int img_no) {
		this.img_no = img_no;
	}

	public String getImg_title() {
		return img_title;
	}

	public void setImg_title(String img_title) {
		this.img_title = img_title;
	}

	public String getImg_caption() {
		return img_caption;
	}

	public void setImg_caption(String img_caption) {
		this.img_caption = img_caption;
	}

	public String getImg_filenm() {
		return img_filenm;
	}

	public void setImg_filenm(String img_filenm) {
		this.img_filenm = img_filenm;
	}

	public int getImg_gallery() {
		return img_gallery;
	}

	public void setImg_gallery(int img_gallery) {
		this.img_gallery = img_gallery;
	}

	public int getImg_sort() {
		return img_sort;
	}

	public void setImg_sort(int img_sort) {
		this.img_sort = img_sort;
	}

	public String getSection_cd() {
		return section_cd;
	}

	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}

	public int getImg_status() {
		return img_status;
	}

	public void setImg_status(int img_status) {
		this.img_status = img_status;
	}

	public Date getWdt() {
		return wdt;
	}

	public void setWdt(Date wdt) {
		this.wdt = wdt;
	}

	public Date getEdt() {
		return edt;
	}

	public void setEdt(Date edt) {
		this.edt = edt;
	}

	@Override
	public String toString() {
		return "Com_imageVO [img_no=" + img_no + ", img_title=" + img_title + ", img_caption=" + img_caption
				+ ", img_filenm=" + img_filenm + ", img_gallery=" + img_gallery + ", img_sort=" + img_sort
				+ ", section_cd=" + section_cd + ", img_status=" + img_status + ", wdt=" + wdt + ", edt=" + edt + "]";
	}

}
