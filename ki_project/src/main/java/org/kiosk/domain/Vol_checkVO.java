package org.kiosk.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component("Vol_checkVO")
public class Vol_checkVO {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int vol_no;
	private Date bgImg;
	private Date board;
	private Date bureau;
	private Date icon;
	private Date image;
	private Date section;
	private Date staff;
	private Date team;
	private Date video;
	private Date building;

	public int getVol_no() {
		return vol_no;
	}

	public void setVol_no(int vol_no) {
		this.vol_no = vol_no;
	}

	public Date getBgImg() {
		return bgImg;
	}

	public void setBgImg(Date bgImg) {
		this.bgImg = bgImg;
	}

	public Date getBoard() {
		return board;
	}

	public void setBoard(Date board) {
		this.board = board;
	}

	public Date getBureau() {
		return bureau;
	}

	public void setBureau(Date bureau) {
		this.bureau = bureau;
	}

	public Date getIcon() {
		return icon;
	}

	public void setIcon(Date icon) {
		this.icon = icon;
	}

	public Date getImage() {
		return image;
	}

	public void setImage(Date image) {
		this.image = image;
	}

	public Date getSection() {
		return section;
	}

	public void setSection(Date section) {
		this.section = section;
	}

	public Date getStaff() {
		return staff;
	}

	public void setStaff(Date staff) {
		this.staff = staff;
	}

	public Date getTeam() {
		return team;
	}

	public void setTeam(Date team) {
		this.team = team;
	}

	public Date getVideo() {
		return video;
	}

	public void setVideo(Date video) {
		this.video = video;
	}

	public Date getBuilding() {
		return building;
	}

	public void setBuilding(Date building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Vol_checkVO [vol_no=" + vol_no + ", bgImg=" + bgImg + ", board=" + board + ", bureau=" + bureau
				+ ", icon=" + icon + ", image=" + image + ", section=" + section + ", staff=" + staff + ", team=" + team
				+ ", video=" + video + ", building=" + building + "]";
	}

}
