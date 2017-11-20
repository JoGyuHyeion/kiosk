package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.JsonStaffDTO;
import org.springframework.stereotype.Repository;
@Repository
public class JsonStaffDAOImpl implements JsonStaffDAO {
	@Inject
	private SqlSession session;
	private static String namespace = "org.kiosk.mapper.JsonStaffMapper";

	@Override
	public void create(JsonStaffDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);

	}

	@Override
	public JsonStaffDTO read(String section_cd) throws Exception {
		return session.selectOne(namespace + ".read", section_cd);
	}

	@Override
	public void update(JsonStaffDTO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(String section_cd) throws Exception {
		session.delete(namespace + ".delete", section_cd);

	}

	@Override
	public List<JsonStaffDTO> listAll(String section_fullcode) throws Exception {
		return session.selectList(namespace + ".listAll",section_fullcode);
	}
}