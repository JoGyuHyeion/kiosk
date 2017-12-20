package org.kiosk.domain;

import org.springframework.stereotype.Component;

@Component("BuildingVO")
public class BuildingVO {

	private int bu_type;
	private String building_name;

	public int getBu_type() {
		return bu_type;
	}

	public void setBu_type(int bu_type) {
		this.bu_type = bu_type;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	@Override
	public String toString() {
		return "BuildingVO [bu_type=" + bu_type + ", building_name=" + building_name + "]";
	}

}
