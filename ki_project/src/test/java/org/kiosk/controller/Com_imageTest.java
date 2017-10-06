package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_imageVO;
import org.kiosk.persistence.Com_imageDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_imageTest {

	@Inject
	private Com_imageDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Com_imageVO vo = new Com_imageVO();
		vo.setImg_no(2);
		vo.setImg_title("?‚¬ì§?1");
		vo.setImg_caption("asd");
		vo.setImg_filenm("asss");
		vo.setImg_gallery(1);
		vo.setImg_sort(1);
		vo.setSection_cd("asd");
		vo.setImg_status(1);
		vo.setWdt(sqlDate);
		vo.setEdt(sqlDate);
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_imageVO vo = new Com_imageVO();
		vo.setImg_no(2);
		vo.setImg_title("?‚¬ì§?1");
		vo.setImg_caption("a");
		vo.setImg_filenm("sdg");
		vo.setImg_gallery(1);
		vo.setImg_sort(1);
		vo.setSection_cd("aga");
		vo.setImg_status(1);
		vo.setWdt(sqlDate);
		vo.setEdt(sqlDate);

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
