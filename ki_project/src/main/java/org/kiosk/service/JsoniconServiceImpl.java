package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;
import org.kiosk.dto.Com_iconDTO;
import org.kiosk.persistence.JsoniconDAO;

public class JsoniconServiceImpl implements JsoniconService {

	@Inject
	private JsoniconDAO dao;


	@Override
	public void regist(Com_iconDTO dto) throws Exception {
		dao.create(dto);

	}

	@Override
	public Com_iconDTO read(Integer ic_no) throws Exception {
		return dao.read(ic_no);
	}

	@Override
	public void modify(Com_iconDTO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(Integer ic_no) throws Exception {
		dao.delete(ic_no);

	}

	@Override
	public List<Com_iconDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
