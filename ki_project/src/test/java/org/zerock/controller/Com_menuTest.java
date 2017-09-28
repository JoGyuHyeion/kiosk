package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Com_menuVO;
import org.zerock.persistence.Com_menuDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_menuTest {

	@Inject
	private Com_menuDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_menuTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Com_menuVO vo = new Com_menuVO();
		vo.setMenu_no(1);
		vo.setMenu_cd("메뉴코드");
		vo.setMenu_nm("메뉴코드");
		vo.setMenu_icon("메뉴코드");
		vo.setMenu_url("메뉴코드");
		vo.setMenu_target("메뉴코드");
		vo.setMenu_pcd("메뉴코드");
		vo.setMenu_lv(1);
		vo.setMenu_inx(1);
		vo.setMenu_fullnm("메뉴코드");
		vo.setMenu_summary("메뉴코드");
		vo.setMenu_user("메뉴코드");
		vo.setMenu_use(0);
		vo.setMenu_dt(sqlDate);

		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_menuVO vo = new Com_menuVO();
		vo.setMenu_no(1);
		vo.setMenu_cd("메뉴코드");
		vo.setMenu_nm("메뉴이르으음");
		vo.setMenu_icon("icon");
		vo.setMenu_url("dongguk.ac.kr");
		vo.setMenu_target("target");
		vo.setMenu_pcd("parentCode");
		vo.setMenu_lv(1);
		vo.setMenu_inx(1);
		vo.setMenu_fullnm("풀네이임");
		vo.setMenu_summary("써머리라능");
		vo.setMenu_user("user");
		vo.setMenu_use(0);
		vo.setMenu_dt(sqlDate);

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
