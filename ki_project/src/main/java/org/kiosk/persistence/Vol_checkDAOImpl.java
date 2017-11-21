package org.kiosk.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.domain.Vol_checkVO;
import org.springframework.stereotype.Repository;

@Repository
public class Vol_checkDAOImpl implements Vol_checkDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.Vol_checkMapper";

	@Override
	public Vol_checkVO read(Integer vol_no) throws Exception {

		return session.selectOne(namespace + ".read", vol_no);
	}

	@Override
	public void update(String col_name) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("col_name", col_name);
		session.update(namespace + ".update", parameters);
	}


}
