package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.dto.Com_buildingDTO;
import org.kiosk.persistence.JsonbuildingDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonBuildingTest {

	@Inject
	private JsonbuildingDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	 @Test
	public void testCreate() throws Exception {

		Com_buildingDTO dto = new Com_buildingDTO();
		dto.setBu_img("사진");
		dto.setBu_name("1층");
		dto.setBu_ndt(sqlDate);
		dao.create(dto);
	}

	// @Test
	public void testRead() throws Exception {

		logger.info(dao.read(10093).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_buildingDTO dto = new Com_buildingDTO();
		dto.setBu_no(1);
		dto.setBu_img("사진");
		dto.setBu_name("1층");
		dto.setBu_edt(sqlDate);
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	//@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

}
