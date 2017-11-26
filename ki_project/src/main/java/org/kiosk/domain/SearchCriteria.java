package org.kiosk.domain;

import org.springframework.stereotype.Component;

@Component("SearchCriteria")
public class SearchCriteria extends Criteria {

	private String section_cd;
	private String keyword="";

	public String getSection_cd() {
		return section_cd;
	}

	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchCriteria [section_cd=" + section_cd + ", keyword=" + keyword + "]";
	}

}
