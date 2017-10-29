package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.MateDTO;
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/persistence/MateDAOImpl.java
=======
import org.kiosk.dto.TeamsDTO;
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/persistence/MateDAOImpl.java
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
