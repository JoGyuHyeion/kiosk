package org.kiosk.service;

import java.util.List;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_iconDTO;

public interface JsoniconService {
	public void regist(Com_iconDTO dto) throws Exception;

	public Com_iconDTO read(Integer ic_no) throws Exception;

	public void modify(Com_iconDTO dto) throws Exception;

	public void remove(Integer ic_no) throws Exception;

	public List<Com_iconDTO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_iconDTO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Com_iconDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
