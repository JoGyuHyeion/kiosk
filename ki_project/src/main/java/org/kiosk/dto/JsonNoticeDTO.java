package org.kiosk.dto;

public class JsonNoticeDTO {

	private int bbs_no;
	private String bbs_title;
	private String bbs_content;
	private String bbs_file;

	public int getBbs_no() {
		return bbs_no;
	}

	public void setBbs_no(int bbs_no) {
		this.bbs_no = bbs_no;
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

	@Override
	public String toString() {
		return "JsonNoticeVO [bbs_no=" + bbs_no + ", bbs_title=" + bbs_title + ", bbs_content=" + bbs_content
				+ ", bbs_file=" + bbs_file + "]";
	}

}
