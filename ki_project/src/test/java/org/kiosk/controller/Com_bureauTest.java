package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_bureauVO;
import org.kiosk.persistence.Com_bureauDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_bureauTest {
	@Inject
	private Com_bureauDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_bureauTest.class);

	// @Test
	public void testCreate() throws Exception {

		Com_bureauVO vo = new Com_bureauVO();
		vo.setBureau_cd("test3");
		vo.setBureau_name("namee2");
		vo.setBureau_use("0");
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {

		logger.info(dao.read("test2").toString());

	}

	// @Test
	public void testUpdate() throws Exception {

		Com_bureauVO vo = new Com_bureauVO();
		vo.setBureau_cd("test2");
		vo.setBureau_name("change");
		vo.setBureau_use("1");
		dao.update(vo);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete("test3");
	}

	// @Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

}
