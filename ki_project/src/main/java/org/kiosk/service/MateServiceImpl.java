package org.kiosk.service;

import java.util.List;

import javax.inject.Inject;

<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/service/MateServiceImpl.java
=======
import org.kiosk.domain.Com_staffVO;
>>>>>>> c718f6c0b276656d7d57c48609db55c599051672:ki_project/src/main/java/org/kiosk/service/MateServiceImpl.java
import org.kiosk.dto.MateDTO;
import org.kiosk.persistence.MateDAO;
import org.springframework.stereotype.Service;
@Service
public class MateServiceImpl implements MateService {
	@Inject
	private MateDAO dao;

//	@Override
//	public void regist(MateDTO dto) throws Exception {
//		dao.create(dto);
//		
//	}

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
	public List<MateDTO> listAll(Com_staffVO vo) throws Exception {
		return dao.listAll(vo);
	}

}
