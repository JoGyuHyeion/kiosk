package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.JsonMateDAO;
import org.springframework.stereotype.Service;

@Service
public class JsonMateServiceImpl implements JsonMateService {

	@Inject
	private JsonMateDAO dao;
	@Inject
	private Vol_checkService volService;
	
	private static final String VERSION="staff";

	@Override
	public void regist(MateDTO dto) throws Exception {
		dao.create(dto);
		volService.update(VERSION);
	}

	@Override
	public MateDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(MateDTO dto) throws Exception {
		dao.update(dto);
		volService.update(VERSION);
	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);
		volService.update(VERSION);
	}

	@Override
	public List<MateDTO> list(TeamsDTO dto) throws Exception {
		return dao.list(dto);
	}

}