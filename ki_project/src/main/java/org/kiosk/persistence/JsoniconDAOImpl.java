package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.Com_iconDTO;

public class JsoniconDAOImpl implements JsoniconDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.com_iconMapper";

	@Override
	public void create(Com_iconDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);

	}

	@Override
	public Com_iconDTO read(Integer ic_no) throws Exception {
		return session.selectOne(namespace + ".read", ic_no);
	}

	@Override
	public void update(Com_iconDTO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(Integer ic_no) throws Exception {
		session.delete(namespace + ".delete", ic_no);

	}

	@Override
	public List<Com_iconDTO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
