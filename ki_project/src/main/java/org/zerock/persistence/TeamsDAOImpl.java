package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.dto.TeamsDTO;
@Repository
public class TeamsDAOImpl implements TeamsDAO{
	@Inject
	private SqlSession session;
	private static String namespace = "org.zerock.mapper.Com_teamMapper";
	@Override
	public TeamsDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
	}

}
