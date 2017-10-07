package org.kiosk.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamsDTO {
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String team_cd;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String section_cd;
	private String team_nm;
	private Map<Integer, MateDTO> mate;

	public TeamsDTO() {
		super();
	}

	public TeamsDTO(String team_cd, String team_nm) {
		super();
		this.team_cd = team_cd;
		this.team_nm = team_nm;
	}

	public String getTeam_cd() {
		return team_cd;
	}

	public void setTeam_cd(String team_cd) {
		this.team_cd = team_cd;
	}

	public String getSection_cd() {
		return section_cd;
	}

	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}

	public String getTeam_nm() {
		return team_nm;
	}

	public void setTeam_nm(String team_nm) {
		this.team_nm = team_nm;
	}

	public Map<Integer, MateDTO> getMate() {
		return mate;
	}

	public void setMate(Map<Integer, MateDTO> mate) {
		this.mate = mate;
	}

	@Override
	public String toString() {
		return "TeamsDTO [team_cd=" + team_cd + ", section_cd=" + section_cd + ", team_nm=" + team_nm + ", mate=" + mate
				+ "]";
	}

}
