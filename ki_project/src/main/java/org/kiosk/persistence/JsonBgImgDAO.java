package org.kiosk.persistence;

import java.util.List;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_bgImgDTO;

public interface JsonBgImgDAO {
	public void create(Com_bgImgDTO dto) throws Exception;

	public Com_bgImgDTO read(Integer ic_no) throws Exception;

	public void update(Com_bgImgDTO dto) throws Exception;

	public void delete(Integer ic_no) throws Exception;

	public List<Com_bgImgDTO> listAll() throws Exception;
	
	public int lastInsertID() throws Exception;

	public List<Com_bgImgDTO> listPage(int page) throws Exception;

	public List<Com_bgImgDTO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_bgImgDTO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
