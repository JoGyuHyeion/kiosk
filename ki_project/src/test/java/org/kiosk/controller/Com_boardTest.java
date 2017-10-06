package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_boardVO;
import org.kiosk.persistence.Com_boardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_boardTest {

	@Inject
	private Com_boardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Com_boardVO vo = new Com_boardVO();
		vo.setBbs_no(2);
		vo.setBrd_cd("abaaa");
		vo.setBbs_pno(3);
		vo.setBbs_lv(2);
		vo.setBbs_sort(13);
		vo.setBbs_title("title2");
		vo.setBbs_content("content2");
		vo.setBbs_file("file2");
		vo.setBbs_notice(11);
		vo.setBbs_tag("태그");
		vo.setBbs_cate("카테고리-1");
		vo.setBbs_hits(10);
		vo.setBbs_state(1);
		vo.setSection_cd("과코드1");
		vo.setBbs_exp_inx(2);
		vo.setBbs_exp_sdt(sqlDate);
		vo.setBbs_exp_edt(sqlDate);
		vo.setBbs_ndt(sqlDate);
		vo.setBbs_edt(sqlDate);

		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_boardVO vo = new Com_boardVO();
		vo.setBbs_no(1);
		vo.setBrd_cd("code");
		vo.setBbs_pno(1);
		vo.setBbs_lv(1);
		vo.setBbs_sort(1);
		vo.setBbs_title("title");
		vo.setBbs_content("content");
		vo.setBbs_file("file");
		vo.setBbs_notice(12);
		vo.setBbs_tag("해시태그sdfsdf?ㅎㅎ");
		vo.setBbs_cate("카테고리");
		vo.setBbs_hits(100);
		vo.setBbs_state(1);
		vo.setSection_cd("과코aaa드");
		vo.setBbs_exp_inx(2);
		vo.setBbs_exp_sdt(sqlDate);
		vo.setBbs_exp_edt(sqlDate);
		vo.setBbs_edt(sqlDate);

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
