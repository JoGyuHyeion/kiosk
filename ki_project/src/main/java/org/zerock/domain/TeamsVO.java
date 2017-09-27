package org.zerock.domain;

import java.util.Map;

public class TeamsVO {

	private String team_name;
	private Map<Integer, MateVO> mate;

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Map<Integer, MateVO> getMate() {
		return mate;
	}

	public void setMate(Map<Integer, MateVO> mate) {
		this.mate = mate;
	}

	@Override
	public String toString() {
		return "TeamsVO [team_name=" + team_name + ", mate=" + mate + "]";
	}

}
