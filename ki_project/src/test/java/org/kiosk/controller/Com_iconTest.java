package org.kiosk.controller;

import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_iconDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_iconTest {

	@Inject
	private Com_iconDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_iconTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

//	@Test
	public void testCreate() throws Exception {

		Com_iconVO dto = new Com_iconVO();
		dto.setIc_able(true);
		dto.setIc_icon("아이콘");
		dto.setIc_name("아이콘 이름");
		dto.setIc_ndt(sqlDate);
		dao.create(dto);
	}

//	@Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_iconVO dto = new Com_iconVO();
		dto.setIc_able(true);
		dto.setIc_icon("아이콘");
		dto.setIc_name("아이콘 이름");
		dto.setIc_ndt(sqlDate);
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

	@Test
	public void testLastInsertID() throws Exception {
		logger.info(String.valueOf(dao.lastInsertID()));
	}

	// @Test
	public void testListPage() throws Exception {

		int page = 1;

		List<Com_iconVO> list = dao.listPage(page);

		for (Com_iconVO Com_iconDTO : list) {
			logger.info(Com_iconDTO.getIc_no() + ":" + Com_iconDTO.getIc_name());
		}
	}

	// @Test
	public void testListCriteria() throws Exception {

		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);

		List<Com_iconVO> list = dao.listCriteria(cri);

		for (Com_iconVO Com_iconDTO : list) {
			logger.info(Com_iconDTO.toString());
		}
	}

	// @Test
	public void testURI() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/vo/read").queryParam("bno", 12)
				.queryParam("perPageNum", 20).build();

		logger.info("/vo/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());

	}

	// @Test
	public void testURI2() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/{module}/{page}").queryParam("bno", 12)
				.queryParam("perPageNum", 20).build().expand("vo", "read").encode();

		logger.info("/vo/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}

	// @Test
	public void testDynamic1() throws Exception {

		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("�?");
		cri.setSearchType("t");

		logger.info("=====================================");

		List<Com_iconVO> list = dao.listSearch(cri);

		for (Com_iconVO Com_iconDTO : list) {
			logger.info(Com_iconDTO.getIc_no() + ":" + Com_iconDTO.getIc_name());
		}

		logger.info("=====================================");

		logger.info("COUNT: " + dao.listSearchCount(cri));
	}

}
