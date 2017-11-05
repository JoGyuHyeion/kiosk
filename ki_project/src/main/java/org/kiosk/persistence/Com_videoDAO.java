package org.kiosk.persistence;

import java.util.List;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_videoDTO;

public interface Com_videoDAO {
	public void create(Com_videoDTO dto) throws Exception;

	public Com_videoDTO read(Integer vi_no) throws Exception;

	public void update(Com_videoDTO dto) throws Exception;

	public void delete(Integer vi_no) throws Exception;

	public List<Com_videoDTO> listAll() throws Exception;
	
	public int lastInsertID() throws Exception;

	public List<Com_videoDTO> listPage(int page) throws Exception;

	public List<Com_videoDTO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	// use for dynamic sql

	public List<Com_videoDTO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
