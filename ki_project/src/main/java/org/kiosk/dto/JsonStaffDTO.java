package org.kiosk.dto;

import java.util.List;

public class JsonStaffDTO {

	private String section_name;
	private String section_pass;
	private List<TeamsDTO> teams;

	public JsonStaffDTO() {
		// TODO Auto-generated constructor stub
	}

	public JsonStaffDTO(String section_name, String section_pass) {
		super();
		this.section_name = section_name;
		this.section_pass = section_pass;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
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
		return "JsonStaffDTO [section_name=" + section_name + ", section_pass=" + section_pass + ", teams=" + teams
				+ "]";
	}

}
