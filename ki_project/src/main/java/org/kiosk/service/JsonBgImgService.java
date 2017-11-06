package org.kiosk.service;

import java.util.List;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_bgImgDTO;

public interface JsonBgImgService {
	public void regist(Com_bgImgDTO dto) throws Exception;

	public Com_bgImgDTO read(Integer ic_no) throws Exception;

	public void modify(Com_bgImgDTO dto) throws Exception;

	public void remove(Integer ic_no) throws Exception;

	public List<Com_bgImgDTO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_bgImgDTO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Com_bgImgDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
