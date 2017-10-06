package org.kiosk.service;

import javax.inject.Inject;

import org.kiosk.domain.Com_teamVO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.Com_teamDAO;

public class TeamsServiceImpl implements TeamsService{

	@Inject
	private Com_teamDAO dao;
	
	@Override
	public TeamsDTO read(Com_teamVO vo) throws Exception {
		Com_teamVO teamVo = dao.read(vo);
		return new TeamsDTO(teamVo.getTeam_nm());
	}

}
