package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.springframework.stereotype.Repository;
@Repository
public class Com_iconDAOImpl implements Com_iconDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.com_iconMapper";

	@Override
	public void create(Com_iconVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public Com_iconVO read(Integer ic_no) throws Exception {
		return session.selectOne(namespace + ".read", ic_no);
	}

	@Override
	public void update(Com_iconVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(Integer ic_no) throws Exception {
		session.delete(namespace + ".delete", ic_no);

	}

	@Override
	public List<Com_iconVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
	
	@Override
	public int lastInsertID() throws Exception {
		return session.selectOne(namespace + ".lastInsertID");
	}

	@Override
	public List<Com_iconVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Com_iconVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Com_iconVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
