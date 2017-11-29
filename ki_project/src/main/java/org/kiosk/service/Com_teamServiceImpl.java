package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.domain.Com_teamVO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.Com_teamDAO;
import org.springframework.stereotype.Service;

@Service
public class Com_teamServiceImpl implements Com_teamService {

	@Inject
	private Com_teamDAO dao;
	@Inject
	private TeamsDTO dto;
	@Inject
	private Vol_checkService volService;

	private static final String VERSION = "team";

	@Override
	public void regist(Com_teamVO vo) throws Exception {
		dao.create(vo);
		volService.update(VERSION);
	}

	@Override
	public Com_teamVO read(Com_teamVO vo) throws Exception {
		return dao.read(vo);
	}

	@Override
	public void modify(Com_teamVO vo) throws Exception {
		dao.update(vo);
		volService.update(VERSION);
	}

	@Override
	public void remove(Com_teamVO vo) throws Exception {
		dao.delete(vo);
		volService.update(VERSION);
	}

	@Override
	public List<Com_teamVO> list(String section_cd) throws Exception {
		return dao.list(section_cd);
	}

	@Override
	public List<Com_teamVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Com_teamVO> jsonList(String bureau_cd) throws Exception {
		return dao.jsonList(bureau_cd);
	}

	@Override
	public int lastInsertSort(String section_cd) throws Exception {
		return dao.lastInsertSort(section_cd) + 1;
	}

	@Override
	public String readTeamCd(String section_cd, String team_nm) throws Exception {
		dto.setSection_cd(section_cd);
		dto.setTeam_nm(team_nm);
		return dao.readTeamCd(dto);
	}

	@Override
	public String readTeamNm(String section_cd, String team_cd) throws Exception {
		dto.setSection_cd(section_cd);
		dto.setTeam_cd(team_cd);
		return dao.readTeamNm(dto);
	}

}
