package org.kiosk.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.JsonNoticeDTO;
import org.springframework.stereotype.Repository;

@Repository
public class JsonNoticeDAOImpl implements JsonNoticeDAO{
	@Inject
	private SqlSession session;
	private static String namespace = "org.kiosk.mapper.jsonNoticeMapper";
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/persistence/JsonNoticeDAOImpl.java
	@Override
	public void create(JsonNoticeDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);
		
	}
=======
//	@Override
//	public void create(JsonNoticeDTO dto) throws Exception {
//		session.insert(namespace + ".create", dto);
//		
//	}
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/persistence/JsonNoticeDAOImpl.java
	@Override
	public JsonNoticeDTO read(Integer no) throws Exception {
		return session.selectOne(namespace + ".read", no);
	}
	@Override
	public void update(JsonNoticeDTO dto) throws Exception {
		session.update(namespace + ".update", dto);
		
		
	}
	@Override
	public void delete(Integer no) throws Exception {
		session.delete(namespace + ".delete", no);
		
	}
	@Override
	public List<JsonNoticeDTO> listAll(String section_cd) throws Exception {
		return session.selectList(namespace + ".listAll",section_cd);
	}
}
