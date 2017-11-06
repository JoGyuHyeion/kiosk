package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_bgImgDTO;
import org.kiosk.persistence.JsonBgImgDAO;
import org.springframework.stereotype.Service;

@Service
public class JsonBgImgServiceImpl implements JsonBgImgService {

	@Inject
	private JsonBgImgDAO dao;

	@Override
	public void regist(Com_bgImgDTO dto) throws Exception {
		dao.create(dto);

	}

	@Override
	public Com_bgImgDTO read(Integer ic_no) throws Exception {
		return dao.read(ic_no);
	}

	@Override
	public void modify(Com_bgImgDTO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(Integer ic_no) throws Exception {
		dao.delete(ic_no);

	}

	@Override
	public List<Com_bgImgDTO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int lastInsertID() throws Exception {
		return dao.lastInsertID() + 1;
	}

	@Override
	public List<Com_bgImgDTO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Com_bgImgDTO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

}
