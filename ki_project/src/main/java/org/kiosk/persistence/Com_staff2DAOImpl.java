package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_staff2VO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class Com_staff2DAOImpl implements Com_staff2DAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.Com_staff2Mapper";

	@Override
	public void create(Com_staff2VO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public Com_staff2VO read(Integer st_no) throws Exception {
		return session.selectOne(namespace + ".read", st_no);
	}

	@Override
	public void update(Com_staff2VO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(Integer st_no) throws Exception {
		session.delete(namespace + ".delete", st_no);

	}

	@Override
	public List<Com_staff2VO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public int lastInsertID() throws Exception {
		return session.selectOne(namespace + ".lastInsertID");
	}

	@Override
	public List<Com_staff2VO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Com_staff2VO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Com_staff2VO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public int createSortNo(Com_staff2VO vo) throws Exception {
		return session.selectOne(namespace + ".createSortNo",vo);
	}

	@Override
	public void sortupdate(Com_staff2VO vo) throws Exception {
		session.update(namespace + ".sortupdate", vo);
		
	}

	@Override
	public List<Com_staff2VO> teamListSort(Com_staff2VO vo) throws Exception {
		return session.selectList(namespace + ".teamListSort",vo);
	}

}
