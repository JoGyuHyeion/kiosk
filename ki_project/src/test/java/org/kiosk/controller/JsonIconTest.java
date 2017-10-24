package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.dto.Com_iconDTO;
import org.kiosk.persistence.JsoniconDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonIconTest {

	@Inject
	private JsoniconDAO dao;

	private static Logger logger = LoggerFactory.getLogger(JsonIconTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	@Test
	public void testCreate() throws Exception {

		Com_iconDTO dto = new Com_iconDTO();
		dto.setIc_able(true);
		dto.setIc_icon("아이콘");
		dto.setIc_name("아이콘 이름");
		dto.setIc_ndt(sqlDate);
		dao.create(dto);
	}

	@Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_iconDTO dto = new Com_iconDTO();
		dto.setIc_able(true);
		dto.setIc_icon("아이콘");
		dto.setIc_name("아이콘 이름");
		dto.setIc_ndt(sqlDate);
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

}
