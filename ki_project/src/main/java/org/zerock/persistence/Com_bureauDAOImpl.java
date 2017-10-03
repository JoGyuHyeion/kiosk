package org.zerock.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.Com_bureauVO;

@Repository
public class Com_bureauDAOImpl implements Com_bureauDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.Com_bureauMapper";

	
	@Override
	public void create(Com_bureauVO vo) throws Exception {
		session.insert(namespace+".create",vo);
		
	}

	@Override
	public Com_bureauVO read(String bureau_cd) throws Exception {
		return session.selectOne(namespace+".read",bureau_cd);
	
	}

	@Override
	public void update(Com_bureauVO vo) throws Exception {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(String bureau_cd) throws Exception {
		session.delete(namespace+".delete",bureau_cd);
				
	}

	@Override
	public List<Com_bureauVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
		
	}

}
