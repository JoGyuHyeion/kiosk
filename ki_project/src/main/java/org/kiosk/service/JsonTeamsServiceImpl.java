package org.kiosk.service;

import java.util.List;
import javax.inject.Inject;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.JsonTeamsDAO;
import org.springframework.stereotype.Service;

@Service
public class JsonTeamsServiceImpl implements JsonTeamsService {
 
	@Inject
	private JsonTeamsDAO dao;

	@Override
	public List<TeamsDTO> list(String section_cd) throws Exception {
		return dao.list(section_cd);
	}

}