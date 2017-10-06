package org.kiosk.dto;

import java.util.Map;

public class TeamsDTO {

	private String team_nm;
	private Map<Integer, MateDTO> mate;

	public TeamsDTO() {
		super();
	}

	public TeamsDTO(String team_nm) {
		super();
		this.team_nm = team_nm;
	}

	public String getTeam_name() {
		return team_nm;
	}

	public void setTeam_name(String team_nm) {
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
		return "TeamsVO [team_nm=" + team_nm + ", mate=" + mate + "]";
	}

}
