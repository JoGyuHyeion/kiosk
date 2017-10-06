package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.JsonGelleryDTO;
import org.springframework.stereotype.Repository;

@Repository
public class JsonGelleryDAOImpl implements JsonGelleryDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.JsonGelleryMapper";
	@Override
	public void create(JsonGelleryDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);
		
	}
	@Override
	public JsonGelleryDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
	}
	@Override
	public void update(JsonGelleryDTO dto) throws Exception {
		session.update(namespace + ".update", dto);
		
		
	}
	@Override
	public void delete(Integer no) throws Exception {
		session.delete(namespace + ".delete", no);
		
	}
	@Override
	public List<JsonGelleryDTO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
