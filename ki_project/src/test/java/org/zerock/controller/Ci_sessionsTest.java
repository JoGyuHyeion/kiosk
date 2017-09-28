package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Ci_sessionsVO;
import org.zerock.persistence.Ci_sessionsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Ci_sessionsTest {

	@Inject
	private Ci_sessionsDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	// @Test
	public void testCreate() throws Exception {

		Ci_sessionsVO vo = new Ci_sessionsVO();
		vo.setId("abc");
		vo.setIp_address("12.123.123.111");
		vo.setTimestamp(170929);
		vo.setData("test2");
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(170928).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Ci_sessionsVO vo = new Ci_sessionsVO();
		vo.setId("abcds");
		vo.setIp_address("12.123.123.7");
		vo.setTimestamp(170928);
		vo.setData("test");
		dao.update(vo);
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
