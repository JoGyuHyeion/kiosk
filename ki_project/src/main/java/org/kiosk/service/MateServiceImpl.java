package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

import org.kiosk.dto.MateDTO;
import org.kiosk.persistence.MateDAO;

public class MateServiceImpl implements MateService {
	@Inject
	private MateDAO dao;

	@Override
	public void regist(MateDTO dto) throws Exception {
		dao.create(dto);
		
	}

	@Override
	public MateDTO read(Integer no) throws Exception {
		return dao.read(no);
	}

	@Override
	public void modify(MateDTO dto) throws Exception {
		dao.update(dto);
		
	}

	@Override
	public void remove(Integer no) throws Exception {
		dao.delete(no);
		
	}

	@Override
	public List<MateDTO> listAll() throws Exception {
		return dao.listAll();
	}

}
