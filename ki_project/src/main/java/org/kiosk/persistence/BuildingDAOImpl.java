package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.BuildingVO;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingDAOImpl implements BuildingDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.buildingMapper";

	@Override
	public void create(BuildingVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public BuildingVO read(Integer bu_type) throws Exception {
		return session.selectOne(namespace + ".read", bu_type);
	}

	@Override
	public void update(BuildingVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(Integer bu_type) throws Exception {
		session.delete(namespace + ".delete", bu_type);

	}

	@Override
	public List<BuildingVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public int lastInsertID() throws Exception {
		return session.selectOne(namespace + ".lastInsertID");
	}

}
