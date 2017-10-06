package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.persistence.JsonNoticeDAO;

public class JsonNoticeServiceImpl implements JsonNoticeService{
	
	@Inject
	private JsonNoticeDAO dao;

	@Override
	public void regist(JsonNoticeDTO dto) throws Exception {
		dao.create(dto);
		
	}

	@Override
	public JsonNoticeDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(JsonNoticeDTO dto) throws Exception {
		dao.update(dto);
		
	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);
		
	}

	@Override
	public List<JsonNoticeDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
