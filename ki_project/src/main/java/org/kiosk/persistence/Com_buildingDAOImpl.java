package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
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
	
	@Override
	public List<Com_buildingVO> list(Integer bu_type) throws Exception {
		return session.selectList(namespace + ".list",bu_type);
	}

	@Override
	public int lastInsertID() throws Exception {
		return session.selectOne(namespace + ".lastInsertID");
	}

	@Override
	public List<Com_buildingVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Com_buildingVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Com_buildingVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	

}
