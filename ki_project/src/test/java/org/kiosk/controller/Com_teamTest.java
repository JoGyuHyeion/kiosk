package org.kiosk.controller;

import javax.inject.Inject;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_teamVO;
import org.kiosk.persistence.Com_teamDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_teamTest {

	@Inject
	private Com_teamDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_teamTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Com_teamVO vo = new Com_teamVO();
		vo.setSection_cd("K010-S010");
		vo.setTeam_cd("T06");
		vo.setTeam_nm("김지혜 관리팀");
		vo.setTeam_sort(7);
		vo.setTeam_use("1");
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		Com_teamVO vo = new Com_teamVO();
		vo.setSection_cd("K010-S010");
		vo.setTeam_cd("T06");
		logger.info(dao.read(vo).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_teamVO vo = new Com_teamVO();
		vo.setSection_cd("K010-S010");
		vo.setTeam_cd("T06");
		vo.setTeam_nm("2김지혜 관리팀");
		vo.setTeam_sort(8);
		vo.setTeam_use("2");
		dao.update(vo);
	}

	// @Test
	public void testDelete() throws Exception {
		Com_teamVO vo = new Com_teamVO();
		vo.setSection_cd("K010-S010");
		vo.setTeam_cd("T06");
		dao.delete(vo);
	}

	// @Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

}
