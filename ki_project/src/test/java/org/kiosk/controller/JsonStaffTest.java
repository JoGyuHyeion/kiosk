package org.kiosk.controller;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.persistence.JsonTeamsDAO;
import org.kiosk.service.JsonStaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonStaffTest {

	@Inject
	private JsonStaffService service;
	@Inject
	private JsonTeamsDAO jsonTeamDao;

	private static Logger logger = LoggerFactory.getLogger(JsonStaffTest.class);


//	@Test
	public void testListAll2() throws Exception {

		logger.info(service.getJsonStaff("none").toString());

	}

	@Test
	public void testTeamListAll() throws Exception {

		logger.info(jsonTeamDao.list("none").toString());

	}
}
