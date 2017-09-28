package org.zerock.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.Com_imageVO;

@Repository
public class Com_imageDAOImpl implements Com_imageDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.zerock.mapper.Com_imageMapper";

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

}
