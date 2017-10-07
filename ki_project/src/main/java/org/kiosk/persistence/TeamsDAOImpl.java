package org.kiosk.persistence;

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
	public TeamsDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
	}

}
