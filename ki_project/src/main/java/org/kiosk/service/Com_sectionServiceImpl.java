package org.kiosk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.kiosk.domain.Com_bureauVO;
import org.kiosk.domain.Com_sectionVO;
import org.kiosk.persistence.Com_sectionDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_sectionServiceImpl implements Com_sectionService {

	@Inject
	private Com_sectionDAO dao;
	@Inject
	private Com_bureauService bureauService;
	@Inject
	private Vol_checkService volService;

	private static final String VERSION = "section";

	@Override
	public void regist(Com_sectionVO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
	}

	@Override
	public Com_sectionVO read(String section_cd) throws Exception {
		return dao.read(section_cd);
	}

	@Override
	public void modify(Com_sectionVO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);
	}

	@Override
	public void remove(String section_cd) throws Exception {
		dao.delete(section_cd);
		volService.update(VERSION);
	}

	@Override
	public List<Com_sectionVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Com_sectionVO> bureauList(String bureau_cd) throws Exception {
		return dao.bureauList(bureau_cd);
	}

	@Override
	public Map<String, List<Com_sectionVO>> getJsonSection() throws Exception {
		Map<String, List<Com_sectionVO>> sectionList = null;
		try {
			sectionList = new HashMap<String, List<Com_sectionVO>>();
			for (Com_bureauVO vo : bureauService.listAll()) {
				sectionList.put(vo.getBureau_name(), listAll());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sectionList;
	}

	@Override
	public int lastInsertSort(String bureau_cd) throws Exception {
		return dao.lastInsertSort(bureau_cd) + 1;
	}

}
