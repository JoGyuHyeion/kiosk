package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.Conn_logVO;

@Repository
public class Conn_logDAOImpl implements Conn_logDAO{

	@Inject
	private SqlSession session;

	private static String namespace = "org.zerock.mapper.Con_logMapper";

	@Override
	public void create(Conn_logVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		
	}

	@Override
	public Conn_logVO read(Integer conn_id) throws Exception {
		return session.selectOne(namespace + ".read", conn_id);
	}

	@Override
	public void update(Conn_logVO vo) throws Exception {
		session.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(Integer conn_id) throws Exception {
		session.delete(namespace + ".delete", conn_id);
		
	}

	@Override
	public List<Conn_logVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
