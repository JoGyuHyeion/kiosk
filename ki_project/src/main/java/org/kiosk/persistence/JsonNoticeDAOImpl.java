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
	private static String namespace = "org.zerock.mapper.jsonNoticeMapper";
	@Override
	public void create(JsonNoticeDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);
		
	}
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
	public List<JsonNoticeDTO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
}
