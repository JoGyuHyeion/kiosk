package org.kiosk.service;

import java.util.List;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_videoDTO;

public interface Com_videoService {
	public void regist(Com_videoDTO dto) throws Exception;

	public Com_videoDTO read(Integer vi_no) throws Exception;

	public void modify(Com_videoDTO dto) throws Exception;

	public void remove(Integer vi_no) throws Exception;

	public List<Com_videoDTO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	public List<Com_videoDTO> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Com_videoDTO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
