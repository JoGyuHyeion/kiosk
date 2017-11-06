package org.kiosk.persistence;

import java.util.List;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_iconDTO;

public interface JsoniconDAO {
	public void create(Com_iconDTO dto) throws Exception;

	public Com_iconDTO read(Integer ic_no) throws Exception;

	public void update(Com_iconDTO dto) throws Exception;

	public void delete(Integer ic_no) throws Exception;

	public List<Com_iconDTO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_iconDTO> listPage(int page) throws Exception;

	public List<Com_iconDTO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_iconDTO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

}
