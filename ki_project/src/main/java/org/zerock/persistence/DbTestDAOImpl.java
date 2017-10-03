package org.zerock.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.DbTestVO;

@Repository
public class DbTestDAOImpl implements DbTestDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "org.zerock.mapper.DbTestMapper";

	@Override
	public void create(DbTestVO vo) throws Exception {
		session.insert(namespace + ".insert_DbTest", vo);

	}

	@Override
	public DbTestVO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".select_DbTest", no);
	}

	@Override
	public void update(DbTestVO vo) throws Exception {
		session.update(namespace + ".update_DbTest", vo);

	}

	@Override
	public void delete(Integer no) throws Exception {
		session.delete(namespace + ".delete_DbTest", no);

	}

	@Override
	public List<DbTestVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
