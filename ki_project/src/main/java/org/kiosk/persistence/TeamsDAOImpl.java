package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.TeamsDTO;
import org.springframework.stereotype.Repository;
@Repository
public class TeamsDAOImpl implements TeamsDAO{
	@Inject
	private SqlSession session;
	private static String namespace = "org.kiosk.mapper.Com_teamMapper";
	@Override
<<<<<<< HEAD
	public List<TeamsDTO> list(String section_cd) throws Exception {
		return session.selectList(namespace + ".list", section_cd);
=======
	public TeamsDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
>>>>>>> 099f6edf2ceaf0f96175d5d3a74cae515ddb4551
	}

}
