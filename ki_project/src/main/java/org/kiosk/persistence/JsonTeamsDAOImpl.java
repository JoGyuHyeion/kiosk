package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.TeamsDTO;
import org.springframework.stereotype.Repository;

@Repository
public class JsonTeamsDAOImpl implements JsonTeamsDAO {
	@Inject
	private SqlSession session;
	private static String namespace = "org.kiosk.mapper.teamMapper";

	@Override
	public List<TeamsDTO> list(String section_cd) throws Exception {
		return session.selectList(namespace + ".list", section_cd);
	}

}