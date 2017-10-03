package org.zerock.service;

import javax.inject.Inject;

import org.zerock.domain.Com_teamVO;
import org.zerock.dto.TeamsDTO;
import org.zerock.persistence.Com_teamDAO;

public class TeamsServiceImpl implements TeamsService{

	@Inject
	private Com_teamDAO dao;
	
	@Override
	public TeamsDTO read(Integer no) throws Exception {
		Com_teamVO vo = dao.read(no);
		return new TeamsDTO(vo.getTeam_nm());
	}

}
