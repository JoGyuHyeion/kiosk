package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.sql.rowset.JoinRowSet;

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
	public JsonStaffDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
	}

	@Override
	public void update(JsonStaffDTO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(Integer no) throws Exception {
		session.delete(namespace + ".delete", no);

	}

	@Override
	public List<JsonStaffDTO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
}
