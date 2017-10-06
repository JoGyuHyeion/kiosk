package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_sectionVO;
import org.kiosk.domain.Com_staffVO;
import org.kiosk.persistence.Com_sectionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_sectionTest {

	@Inject
	private Com_sectionDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_sectionTest.class);

	// @Test
	public void testCreate() throws Exception {

		Com_sectionVO vo = new Com_sectionVO();
		vo.setBureau_cd("xx국");
		vo.setSection_cd("xx과");
		vo.setSection_name("명칭");
		vo.setSection_type("a");
		vo.setSection_sort(1);
		vo.setSection_ip("12asd");
		vo.setSection_id("aasa");
		vo.setSection_pass("asdf");
		vo.setSection_fullcode("sss");
		vo.setSection_fullpath("aaasdf");
		vo.setSection_use("1");
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read("xx국").toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_sectionVO vo = new Com_sectionVO();
		vo.setBureau_cd("xx국");
		vo.setSection_cd("yy과");
		vo.setSection_name("명칭");
		vo.setSection_type("a");
		vo.setSection_sort(1);
		vo.setSection_ip("12asd");
		vo.setSection_id("aasa");
		vo.setSection_pass("asdf");
		vo.setSection_fullcode("sss");
		vo.setSection_fullpath("aaasdf");
		vo.setSection_use("1");
		dao.update(vo);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete("xx과");
	}

	// @Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}
}
