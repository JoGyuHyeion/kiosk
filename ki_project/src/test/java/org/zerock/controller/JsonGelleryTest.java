package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dto.JsonGelleryDTO;
import org.zerock.persistence.JsonGelleryDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonGelleryTest {

	@Inject
	private JsonGelleryDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	@Test
	public void testCreate() throws Exception {

		JsonGelleryDTO dto = new JsonGelleryDTO();
		dto.setTitle("규현");
		dto.setCaption("몰라");
		dto.setFilenm("img.jsp");
		dao.create(dto);
	}

	// @Test
	public void testRead() throws Exception {
		// JsonGelleryDTO dto= dao.read(10093);
		 System.out.println("규현");
		 //System.out.println(dao.read(10093).toString());
		//logger.info(dao.read(10093).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		JsonGelleryDTO dto = new JsonGelleryDTO();
		dto.setNo(10092);
		dto.setTitle("1규현");
		dto.setCaption("1몰라");
		dto.setFilenm("1img.jsp");
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(10092);
	}

	 //@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll("").toString());

	}

}
