package org.kiosk.domain;

public class SearchCriteria extends Criteria{

	private String searchType;
	private String keyword;
	private String section_cd;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSection_cd() {
		return section_cd;
	}
	public void setSection_cd(String section_cd) {
		this.section_cd = section_cd;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", section_cd=" + section_cd + "]";
	}
	
}


