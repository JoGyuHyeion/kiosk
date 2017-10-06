package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.TeamsDAO;
import org.springframework.stereotype.Service;
@Service
public class TeamsServiceImpl implements TeamsService{

	@Inject
	private TeamsDAO dao;
	
	@Override
<<<<<<< HEAD
	public List<TeamsDTO> list(String section_cd) throws Exception {
		//Com_teamVO teamVo = dao.read(vo);
		//return new TeamsDTO(teamVo.getTeam_nm());
		return dao.list(section_cd);
=======
	public TeamsDTO read(Integer no) throws Exception {
		Com_teamVO vo = dao.read(no);
		return new TeamsDTO(vo.getTeam_nm());
>>>>>>> 099f6edf2ceaf0f96175d5d3a74cae515ddb4551
	}

}
