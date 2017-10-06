package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.DbTestVO;
import org.kiosk.persistence.DbTestDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class jjyeDBTest {

	@Inject
	private DbTestDAO dao;

	private static Logger logger = LoggerFactory.getLogger(jjyeDBTest.class);

	// @Test
	public void testCreate() throws Exception {

		DbTestVO vo = new DbTestVO();
		vo.setId("김치");
		vo.setPwd(12345);
		dao.create(vo);
	}

	 @Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());

	}

	// @Test
	public void testUpdate() throws Exception {

		DbTestVO vo = new DbTestVO();
		vo.setId_no(1);
		vo.setId("김지혜");
		vo.setPwd(123123);
		dao.update(vo);
	}

	// @Test
	public void testDelete() throws Exception {
		// 번호로 db 삭제함
		dao.delete(1);
	}

	// @Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}
}