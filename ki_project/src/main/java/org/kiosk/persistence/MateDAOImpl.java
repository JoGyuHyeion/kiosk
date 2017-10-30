package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.springframework.stereotype.Repository;
@Repository
public class MateDAOImpl implements MateDAO {
	@Inject
	private SqlSession session;
	private static String namespace = "org.kiosk.mapper.MateMapper";

//	@Override
//	public void create(MateDTO dto) throws Exception {
//		session.insert(namespace + ".create", dto);
//
//	}

	@Override
	public MateDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
	}

	@Override
	public void update(MateDTO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(Integer no) throws Exception {
		session.delete(namespace + ".delete", no);

	}

	@Override
	public List<MateDTO> list(TeamsDTO dto) throws Exception {
		return session.selectList(namespace + ".list",dto);
	}
}