package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/persistence/MateDAOImpl.java
=======
import org.kiosk.domain.Com_staffVO;
>>>>>>> c718f6c0b276656d7d57c48609db55c599051672:ki_project/src/main/java/org/kiosk/persistence/MateDAOImpl.java
import org.kiosk.dto.MateDTO;
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
	public List<MateDTO> listAll(Com_staffVO vo) throws Exception {
		return session.selectList(namespace + ".list",vo);
	}
}
