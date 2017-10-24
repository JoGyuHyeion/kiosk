package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.Com_buildingDTO;
import org.springframework.stereotype.Repository;
@Repository
public class JsonbuildingDAOImpl implements JsonbuildingDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.com_buildingMapper";

	@Override
	public void create(Com_buildingDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);

	}

	@Override
	public Com_buildingDTO read(Integer bu_no) throws Exception {
		return session.selectOne(namespace + ".read", bu_no);
	}

	@Override
	public void update(Com_buildingDTO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(Integer bu_no) throws Exception {
		session.delete(namespace + ".delete", bu_no);

	}

	@Override
	public List<Com_buildingDTO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
