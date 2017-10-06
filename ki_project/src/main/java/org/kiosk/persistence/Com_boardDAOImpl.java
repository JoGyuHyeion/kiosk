package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Com_boardVO;
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

}
