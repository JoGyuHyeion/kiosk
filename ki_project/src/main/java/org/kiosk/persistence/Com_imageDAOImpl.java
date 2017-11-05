package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_imageVO;
import org.kiosk.domain.Com_imageVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class Com_imageDAOImpl implements Com_imageDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.Com_imageMapper";

	@Override
	public void create(Com_imageVO vo) throws Exception {
		session.insert(namespace + ".create", vo);

	}

	@Override
	public Com_imageVO read(Integer img_no) throws Exception {
		return session.selectOne(namespace + ".read", img_no);
	}

	@Override
	public void update(Com_imageVO vo) throws Exception {
		session.update(namespace + ".update", vo);

	}

	@Override
	public void delete(Integer img_no) throws Exception {
		session.delete(namespace + ".delete", img_no);

	}

	@Override
	public List<Com_imageVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public int lastInsertID() throws Exception {
		return session.selectOne(namespace + ".lastInsertID");
	}

	@Override
	public List<Com_imageVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Com_imageVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Com_imageVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
