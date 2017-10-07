package org.kiosk.dto;

import java.util.List;

public class JsonStaffDTO {

	private String section_fullcode;
	private String section_pass;
	private List<TeamsDTO> teams;

	public JsonStaffDTO() {
		// TODO Auto-generated constructor stub
	}

	public JsonStaffDTO(String section_fullcode, String section_pass) {
		super();
		this.section_fullcode = section_fullcode;
		this.section_pass = section_pass;
	}

	public String getSection_fullcode() {
		return section_fullcode;
	}

	public void setSection_fullcode(String section_fullcode) {
		this.section_fullcode = section_fullcode;
	}

	public String getSection_pass() {
		return section_pass;
	}

	public void setSection_pass(String section_pass) {
		this.section_pass = section_pass;
	}

	public List<TeamsDTO> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamsDTO> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "JsonStaffDTO [section_fullcode=" + section_fullcode + ", section_pass=" + section_pass + ", teams="
				+ teams + "]";
	}

}
