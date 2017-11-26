package org.kiosk.dto;

import org.springframework.stereotype.Component;

@Component("JsonGelleryDTO")
public class JsonGelleryDTO {

	private int img_no;
	private String img_title;
	private String img_caption;
	private String img_filenm;

	public JsonGelleryDTO() {
		// TODO Auto-generated constructor stub
	}

	public JsonGelleryDTO(int img_no, String img_title, String img_caption, String img_filenm) {
		super();
		this.img_no = img_no;
		this.img_title = img_title;
		this.img_caption = img_caption;
		this.img_filenm = img_filenm;
	}

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

	@Override
	public String toString() {
		return "JsonGelleryDTO [img_no=" + img_no + ", img_title=" + img_title + ", img_caption=" + img_caption
				+ ", img_filenm=" + img_filenm + "]";
	}

}