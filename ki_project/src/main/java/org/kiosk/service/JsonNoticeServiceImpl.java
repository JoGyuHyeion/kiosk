package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.persistence.JsonNoticeDAO;
import org.springframework.stereotype.Service;

@Service
public class JsonNoticeServiceImpl implements JsonNoticeService {

	@Inject
	private JsonNoticeDAO dao;
	@Inject
	private Vol_checkService volService;

	private static final String VERSION = "board";

	@Override
	public void regist(JsonNoticeDTO dto) throws Exception {
		dao.create(dto);
		volService.update(VERSION);
	}

	@Override
	public JsonNoticeDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(JsonNoticeDTO dto) throws Exception {
		dao.update(dto);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);
		volService.update(VERSION);
	}

	@Override
	public List<JsonNoticeDTO> list(String section_cd) throws Exception {
		return dao.list(section_cd);
	}

	@Override
	public List<JsonNoticeDTO> listAll() throws Exception {
		return dao.listAll();
	}

}