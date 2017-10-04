package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dto.JsonStaffDTO;
import org.zerock.persistence.JsonStaffDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonStaffTest {

	@Inject
	private JsonStaffDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	// @Test
	public void testCreate() throws Exception {

		JsonStaffDTO dto = new JsonStaffDTO();

		dao.create(dto);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(170928).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		JsonStaffDTO dto = new JsonStaffDTO();

		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(170928);
	}

	// @Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

}
