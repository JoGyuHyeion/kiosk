package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.persistence.JsonGelleryDAO;
import org.springframework.stereotype.Service;

@Service
public class JsonGelleryServiceImpl implements JsonGelleryService {

	@Inject
	private JsonGelleryDAO dao;
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="image";

	@Override
	public void regist(JsonGelleryDTO dto) throws Exception {
		dao.create(dto);
		volService.update(VERSION);
	}

	@Override
	public JsonGelleryDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(JsonGelleryDTO dto) throws Exception {
		dao.update(dto);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);
		volService.update(VERSION);
	}

	@Override
	public List<JsonGelleryDTO> list(String section_cd) throws Exception {
		return dao.list(section_cd);
	}

	@Override
	public List<JsonGelleryDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
