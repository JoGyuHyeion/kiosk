package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_bureauVO;
import org.kiosk.domain.Conn_logVO;
import org.kiosk.persistence.Conn_logDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Conn_logTest {
	@Inject
	private Conn_logDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Conn_logTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Timestamp timestamp = new java.sql.Timestamp(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Conn_logVO vo = new Conn_logVO();
		vo.setConn_id(1); // autoIncrement
		vo.setDevice_id("device_id2");
		vo.setRegdate(timestamp);
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());

	}

	// @Test
	public void testUpdate() throws Exception {

		Conn_logVO vo = new Conn_logVO();
		vo.setDevice_id("device_id1");
		vo.setRegdate(timestamp);
		dao.update(vo);
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
