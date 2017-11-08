package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_buildingVO;
import org.springframework.stereotype.Repository;
@Repository
public class Com_buildingDAOImpl implements Com_buildingDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.com_buildingMapper";

	@Override
	public void create(Com_buildingVO dto) throws Exception {
		session.insert(namespace + ".create", dto);

	}

	@Override
	public Com_buildingVO read(Integer bu_no) throws Exception {
		return session.selectOne(namespace + ".read", bu_no);
	}

	@Override
	public void update(Com_buildingVO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(Integer bu_no) throws Exception {
		session.delete(namespace + ".delete", bu_no);

	}

	@Override
	public List<Com_buildingVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
