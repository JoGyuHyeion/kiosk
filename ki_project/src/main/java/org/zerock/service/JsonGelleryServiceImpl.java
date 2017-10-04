package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.zerock.dto.JsonGelleryDTO;
import org.zerock.persistence.JsonGelleryDAO;

public class JsonGelleryServiceImpl implements JsonGelleryService {
	
	@Inject
	private JsonGelleryDAO dao;

	@Override
	public void regist(JsonGelleryDTO dto) throws Exception {
		dao.create(dto);
		
	}

	@Override
	public JsonGelleryDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(JsonGelleryDTO dto) throws Exception {
		dao.update(dto);
		
	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);
		
	}

	@Override
	public List<JsonGelleryDTO> listAll(String section_cd) throws Exception {
		return dao.listAll(section_cd);
	}



}
