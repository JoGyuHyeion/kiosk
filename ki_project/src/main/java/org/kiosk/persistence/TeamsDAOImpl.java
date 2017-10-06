package org.kiosk.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_teamVO;
import org.kiosk.dto.TeamsDTO;
import org.springframework.stereotype.Repository;
@Repository
public class TeamsDAOImpl implements TeamsDAO{
	@Inject
	private SqlSession session;
	private static String namespace = "org.kiosk.mapper.teamMapper";
	@Override
	public TeamsDTO read(Com_teamVO vo) throws Exception {
		return session.selectOne(namespace + ".read", vo);
	}

}
