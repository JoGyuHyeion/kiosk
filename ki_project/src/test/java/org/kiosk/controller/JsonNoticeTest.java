package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.persistence.JsonNoticeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonNoticeTest {

	@Inject
	private JsonNoticeDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	// @Test
	public void testCreate() throws Exception {

		JsonNoticeDTO dto = new JsonNoticeDTO();
		dto.setBbs_title("rbgus");
		dto.setBbs_content("rbgus");
		dto.setBbs_file("dfd.jsp");

		// dao.create(dto);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		JsonNoticeDTO dto = new JsonNoticeDTO();
		dto.setBbs_no(1);
		dto.setBbs_title("1rbgus");
		dto.setBbs_content("1rbgus");
		dto.setBbs_file("1d1fd.jsp");
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(170928);
	}

	@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll("K040-S200").toString());

	}

}
