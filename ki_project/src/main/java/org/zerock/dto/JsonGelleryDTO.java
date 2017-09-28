package org.zerock.dto;

public class JsonGelleryDTO {

	private int no;
	private String title;
	private String caption;
	private String filenm;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getFilenm() {
		return filenm;
	}

	public void setFilenm(String filenm) {
		this.filenm = filenm;
	}

	@Override
	public String toString() {
		return "JsonGelleryVO [no=" + no + ", title=" + title + ", caption=" + caption + ", filenm=" + filenm + "]";
	}

}
