package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.persistence.JsonStaffDAO;
import org.kiosk.persistence.JsonMateDAO;
import org.kiosk.persistence.JsonTeamsDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonStaffTest {

	@Inject
	private JsonStaffDAO staffdao;
	@Inject
	private JsonMateDAO mateDao;
	@Inject
	private JsonTeamsDAO teamDao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	// @Test
	public void testStaffCreate() throws Exception {

		// JsonStaffDTO dto = new JsonStaffDTO();

		// staffdao.create(dto);
	}

	// @Test
	public void testStaffRead() throws Exception {
		logger.info(staffdao.read("K010-S020").toString());
	}

	// @Test
	public void testStaffUpdate() throws Exception {

		JsonStaffDTO dto = new JsonStaffDTO();

		staffdao.update(dto);
	}

	// @Test
	public void testStaffDelete() throws Exception {

		staffdao.delete("S010");
	}

	// @Test
	public void testStaffListAll() throws Exception {
		logger.info(staffdao.listAll("K010-S010").toString());

	}

	// @Test
	public void testMateCreate() throws Exception {

		// MateDTO dto = new MateDTO();

		// mateDao.create(dto);
	}

	// @Test
	public void testMateRead() throws Exception {
		logger.info(mateDao.read(1).toString());
	}

	// @Test
	public void testMateUpdate() throws Exception {

		MateDTO dto = new MateDTO();

		mateDao.update(dto);
	}

	// @Test
	public void testMateDelete() throws Exception {

		mateDao.delete(1);
	}

	@Test
	public void testMateListAll() throws Exception {
		TeamsDTO vo = new TeamsDTO();
		vo.setSection_cd("K010-S010");
		vo.setTeam_cd("T00");
		logger.info(mateDao.list(vo).toString());
	}

	// @Test
	public void testTeamsCreate() throws Exception {

		// TeamsDTO dto = new TeamsDTO();

		// teamDao.create(dto);
	}

	// @Test
	public void testTeamsRead() throws Exception {
		// Com_teamVO vo = new Com_teamVO();
		// vo.setSection_cd("K010-S010");
		// vo.setTeam_cd("T05");
		// logger.info(teamDao.read(vo).toString());
	}

}