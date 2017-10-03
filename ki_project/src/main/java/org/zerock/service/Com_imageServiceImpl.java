package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.Com_imageVO;
import org.zerock.persistence.Com_imageDAO;

@Service
public class Com_imageServiceImpl implements Com_imageService {

	@Inject
	private Com_imageDAO dao;

	@Override
	public void regist(Com_imageVO vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public Com_imageVO read(Integer img_no) throws Exception {
		return dao.read(img_no);
	}

	@Override
	public void modify(Com_imageVO vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void remove(Integer img_no) throws Exception {
		dao.delete(img_no);

	}

	@Override
	public List<Com_imageVO> listAll() throws Exception {
		return dao.listAll();
	}

}
