package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.Com_videoDTO;
import org.springframework.stereotype.Repository;
@Repository
public class JsonvideoDAOImpl implements JsonvideoDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.com_videoMapper";

	@Override
	public void create(Com_videoDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);

	}

	@Override
	public Com_videoDTO read(Integer vi_no) throws Exception {
		return session.selectOne(namespace + ".read", vi_no);

	}

	@Override
	public void update(Com_videoDTO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(Integer vi_no) throws Exception {
		session.delete(namespace + ".delete", vi_no);

	}

	@Override
	public List<Com_videoDTO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
