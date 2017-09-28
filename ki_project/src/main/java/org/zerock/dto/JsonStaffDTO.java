package org.zerock.dto;

import java.util.List;

public class JsonStaffDTO {

	private String section_name;
	private String section_password;
	private List<TeamsDTO> teams;

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public String getSection_password() {
		return section_password;
	}

	public void setSection_password(String section_password) {
		this.section_password = section_password;
	}

	public List<TeamsDTO> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamsDTO> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "JsonStaffVO [section_name=" + section_name + ", section_password=" + section_password + ", teams="
				+ teams + "]";
	}

}
