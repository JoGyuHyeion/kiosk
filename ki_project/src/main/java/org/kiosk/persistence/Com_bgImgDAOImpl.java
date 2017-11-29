package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.springframework.stereotype.Repository;
@Repository
public class Com_bgImgDAOImpl implements Com_bgImgDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.com_bgimgMapper";

	@Override
	public void create(Com_bgImgVO dto) throws Exception {
		session.insert(namespace + ".create", dto);

	}

	@Override
	public Com_bgImgVO read(int bi_no) throws Exception {
		return session.selectOne(namespace + ".read",bi_no);
	}

	@Override
	public void update(Com_bgImgVO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(int bi_no) throws Exception {
		session.delete(namespace + ".delete", bi_no);

	}

	@Override
	public List<Com_bgImgVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
	
	@Override
	public List<Com_bgImgVO> jsonList() throws Exception {
		return session.selectList(namespace + ".jsonList");
	}
	
	@Override
	public int lastInsertID() throws Exception {
		return session.selectOne(namespace + ".lastInsertID");
	}

	@Override
	public List<Com_bgImgVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Com_bgImgVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<Com_bgImgVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
