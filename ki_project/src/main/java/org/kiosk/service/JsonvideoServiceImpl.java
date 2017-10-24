package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;
import org.kiosk.dto.Com_videoDTO;
import org.kiosk.persistence.JsonvideoDAO;

public class JsonvideoServiceImpl implements JsonvideoService {
	
	@Inject
	private JsonvideoDAO dao;

	@Override
	public void regist(Com_videoDTO dto) throws Exception {
		dao.create(dto);

	}

	@Override
	public Com_videoDTO read(Integer vi_no) throws Exception {
		return dao.read(vi_no);

	}

	@Override
	public void modify(Com_videoDTO dto) throws Exception {
		dao.update(dto);

	}

	@Override
	public void remove(Integer vi_no) throws Exception {
		dao.delete(vi_no);

	}

	@Override
	public List<Com_videoDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
