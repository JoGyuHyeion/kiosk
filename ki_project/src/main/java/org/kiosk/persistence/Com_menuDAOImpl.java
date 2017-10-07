package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_menuVO;
import org.springframework.stereotype.Repository;

@Repository
public class Com_menuDAOImpl implements Com_menuDAO{
	
	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.Com_menuMapper";

	@Override
	public void create(Com_menuVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		
	}

	@Override
	public Com_menuVO read(Integer menu_no) throws Exception {
		return session.selectOne(namespace + ".read", menu_no);
	}

	@Override
	public void update(Com_menuVO vo) throws Exception {
		session.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(Integer menu_no) throws Exception {
		session.delete(namespace + ".delete", menu_no);
		
	}

	@Override
	public List<Com_menuVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}


}
