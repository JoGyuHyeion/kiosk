package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.dto.Com_videoDTO;
import org.kiosk.persistence.JsonvideoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonVideoTest {

	@Inject
	private JsonvideoDAO dao;

	private static Logger logger = LoggerFactory.getLogger(JsonVideoTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	@Test
	public void testCreate() throws Exception {

		Com_videoDTO dto = new Com_videoDTO();
		dto.setVi_name("비디오 이름");
		dto.setVi_ndt(sqlDate);
		dto.setVi_video("비디오");
		dao.create(dto);
	}

	// @Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_videoDTO dto = new Com_videoDTO();
		dto.setVi_name("비디오 이름");
		dto.setVi_ndt(sqlDate);
		dto.setVi_video("비디오");
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	// @Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

}
