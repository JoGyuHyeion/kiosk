package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.Com_staffVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class Com_staffDAOImpl implements Com_staffDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.zerock.mapper.Com_staffMapper";

	@Override
	public void create(Com_staffVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public Com_staffVO read(Integer st_no) throws Exception {
		return session.selectOne(namespace + ".read", st_no);
	}

	@Override
	public void update(Com_staffVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(Integer st_no) throws Exception {
		session.delete(namespace + ".delete", st_no);

	}

	@Override
	public List<Com_staffVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<Com_staffVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Com_staffVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Com_staffVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
