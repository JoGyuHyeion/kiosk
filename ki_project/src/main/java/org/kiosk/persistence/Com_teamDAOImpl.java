package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_teamVO;
import org.springframework.stereotype.Repository;

@Repository
public class Com_teamDAOImpl implements Com_teamDAO{

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.Com_teamMapper";

	@Override
	public void create(Com_teamVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		
	}

	@Override
	public Com_teamVO read(Integer st_no) throws Exception {
		return session.selectOne(namespace + ".read", st_no);
	}

	@Override
	public void update(Com_teamVO vo) throws Exception {
		session.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(Integer st_no) throws Exception {
		session.delete(namespace + ".delete", st_no);
		
	}

	@Override
	public List<Com_teamVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
