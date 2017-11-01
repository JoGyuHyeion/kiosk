package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.persistence.JsonGelleryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonGelleryTest {

	@Inject
	private JsonGelleryDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	// @Test
	public void testCreate() throws Exception {

		JsonGelleryDTO dto = new JsonGelleryDTO();
		dto.setImg_title("규현");
		dto.setImg_caption("몰라");
		dto.setImg_filenm("img.jsp");
		// dao.create(dto);
	}

	// @Test
	public void testRead() throws Exception {

		System.out.println("규현");
		logger.info(dao.read(10093).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		JsonGelleryDTO dto = new JsonGelleryDTO();
		dto.setImg_no(10092);
		dto.setImg_title("1규현");
		dto.setImg_caption("1몰라");
		dto.setImg_filenm("1img.jsp");
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(10092);
	}

	@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll("").toString());

	}

}