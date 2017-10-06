package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_boardVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class Com_boardDAOImpl implements Com_boardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.zerock.mapper.Com_boardMapper";

	@Override
	public void create(Com_boardVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public Com_boardVO read(Integer bbs_no) throws Exception {
		return session.selectOne(namespace + ".read", bbs_no);
	}

	@Override
	public void update(Com_boardVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(Integer bbs_no) throws Exception {
		session.delete(namespace + ".delete", bbs_no);

	}

	@Override
	public List<Com_boardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
	
	@Override
	public List<Com_boardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Com_boardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Com_boardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}


}
