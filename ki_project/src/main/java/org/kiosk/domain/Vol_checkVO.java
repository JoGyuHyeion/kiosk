package org.kiosk.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component("Vol_checkVO")
public class Vol_checkVO {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int vol_no;
	private String bgImg;
	private String board;
	private String bureau;
	private String icon;
	private String image;
	private String section;
	private String staff;
	private String team;
	private String video;
	private String building;

	public int getVol_no() {
		return vol_no;
	}

	public void setVol_no(int vol_no) {
		this.vol_no = vol_no;
	}

	public String getBgImg() {
		return bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Vol_checkVO [vol_no=" + vol_no + ", bgImg=" + bgImg + ", board=" + board + ", bureau=" + bureau
				+ ", icon=" + icon + ", image=" + image + ", section=" + section + ", staff=" + staff + ", team=" + team
				+ ", video=" + video + ", building=" + building + "]";
	}

}
