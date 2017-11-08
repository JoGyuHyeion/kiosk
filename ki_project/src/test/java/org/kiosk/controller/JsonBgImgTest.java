package org.kiosk.controller;

import java.util.List;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_bgImgDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonBgImgTest {

	@Inject
	private Com_bgImgDAO dao;

	private static Logger logger = LoggerFactory.getLogger(JsonBgImgTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Com_bgImgVO dto = new Com_bgImgVO();
		dto.setBi_able(true);
		dto.setBi_img("아이콘");
		dto.setBi_name("아이콘 이름");
		dto.setBi_ndt(sqlDate);
		dao.create(dto);
	}

	// @Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_bgImgVO dto = new Com_bgImgVO();
		dto.setBi_able(true);
		dto.setBi_img("아이콘");
		dto.setBi_name("아이콘 이름");
		dto.setBi_ndt(sqlDate);
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

		List<Com_bgImgVO> list = dao.listPage(page);

		for (Com_bgImgVO Com_bgImgDTO : list) {
			logger.info(Com_bgImgDTO.getBi_no() + ":" + Com_bgImgDTO.getBi_name());
		}
	}

	// @Test
	public void testListCriteria() throws Exception {

		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);

		List<Com_bgImgVO> list = dao.listCriteria(cri);

		for (Com_bgImgVO Com_bgImgDTO : list) {
			logger.info(Com_bgImgDTO.toString());
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

		List<Com_bgImgVO> list = dao.listSearch(cri);

		for (Com_bgImgVO Com_bgImgDTO : list) {
			logger.info(Com_bgImgDTO.getBi_no() + ":" + Com_bgImgDTO.getBi_name());
		}

		logger.info("=====================================");

		logger.info("COUNT: " + dao.listSearchCount(cri));
	}

}
