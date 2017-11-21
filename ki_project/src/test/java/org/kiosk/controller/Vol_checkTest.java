package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.persistence.Vol_checkDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Vol_checkTest {
	@Inject
	private Vol_checkDAO dao;
	private static final String VERSION="session";
	private static Logger logger = LoggerFactory.getLogger(Vol_checkTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

//	 @Test
	public void testUpdate() throws Exception {
		dao.update(VERSION);
	}
}
