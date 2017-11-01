package org.kiosk.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.kiosk.dto.Com_bgImgDTO;
import org.springframework.stereotype.Repository;
@Repository
public class JsonBgImgDAOImpl implements JsonBgImgDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.kiosk.mapper.com_bgimgMapper";

	@Override
	public void create(Com_bgImgDTO dto) throws Exception {
		session.insert(namespace + ".create", dto);

	}

	@Override
	public Com_bgImgDTO read(Integer ic_no) throws Exception {
		return session.selectOne(namespace + ".read", ic_no);
	}

	@Override
	public void update(Com_bgImgDTO dto) throws Exception {
		session.update(namespace + ".update", dto);

	}

	@Override
	public void delete(Integer ic_no) throws Exception {
		session.delete(namespace + ".delete", ic_no);

	}

	@Override
	public List<Com_bgImgDTO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}