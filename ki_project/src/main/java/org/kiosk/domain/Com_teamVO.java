package org.kiosk.domain;

public class Com_teamVO {

	private String section_cd;
	private String team_cd;
	private String team_nm;
	private int team_sort;
	private String team_use;

	public String getSection_cd() {
		return section_cd;
	}

	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}

	public String getTeam_cd() {
		return team_cd;
	}

	public void setTeam_cd(String team_cd) {
		this.team_cd = team_cd;
	}

	public String getTeam_nm() {
		return team_nm;
	}

	public void setTeam_nm(String team_nm) {
		this.team_nm = team_nm;
	}

	public int getTeam_sort() {
		return team_sort;
	}

	public void setTeam_sort(int team_sort) {
		this.team_sort = team_sort;
	}

	public String getTeam_use() {
		return team_use;
	}

	public void setTeam_use(String team_use) {
		this.team_use = team_use;
	}

	@Override
	public String toString() {
		return "Com_teamVO [section_cd=" + section_cd + ", team_cd=" + team_cd + ", team_nm=" + team_nm + ", team_sort="
				+ team_sort + ", team_use=" + team_use + "]";
	}

}
