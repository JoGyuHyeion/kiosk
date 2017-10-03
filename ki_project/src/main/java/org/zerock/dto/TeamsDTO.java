package org.zerock.dto;

import java.util.Map;

public class TeamsDTO {

	private String team_name;
	private Map<Integer, MateDTO> mate;
	
	public TeamsDTO() {
		super();
	}

	public TeamsDTO(String team_name) {
		super();
		this.team_name = team_name;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Map<Integer, MateDTO> getMate() {
		return mate;
	}

	public void setMate(Map<Integer, MateDTO> mate) {
		this.mate = mate;
	}

	@Override
	public String toString() {
		return "TeamsVO [team_name=" + team_name + ", mate=" + mate + "]";
	}

}
