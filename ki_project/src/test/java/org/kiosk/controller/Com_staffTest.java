package org.kiosk.controller;

import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_staffVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_staffDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class Com_staffTest {

	@Inject
	private Com_staffDAO dao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Com_staffVO vo = new Com_staffVO();
		vo.setSt_nm("규현");
		vo.setSt_position("랩장");
		vo.setSt_tel("010-6666-7777");
		vo.setSt_email("ku@naver.com");
		vo.setSt_job("학생");
		vo.setSt_profile("profile");
		vo.setImg_filenm("img1");
		vo.setImg_filenm1("img_filenm1");
		vo.setSection_cd("부서");
		vo.setTeam_cd("팀");
		vo.setSt_team("st팀");
		vo.setSt_sort(2);
		vo.setSt_display(3);
		vo.setSt_status(5);
		vo.setSt_wdt(sqlDate);
		vo.setSt_edt(sqlDate);
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(2).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_staffVO vo = new Com_staffVO();
		vo.setSt_nm("조규현");
		vo.setSt_no(1139);

		dao.update(vo);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(1138);
	}

	@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

	// @Test
	public void testCount() throws Exception {
		logger.info(String.valueOf(dao.maxNum()));
	}

	// @Test
	public void testListPage() throws Exception {

		int page = 1;

		List<Com_staffVO> list = dao.listPage(page);

		// for (Com_staffVO Com_staffVO : list) {
		// logger.info(Com_staffVO.getBno() + ":" + Com_staffVO.getTitle());
		// }
	}

	// @Test
	public void testListCriteria() throws Exception {

		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);

		List<Com_staffVO> list = dao.listCriteria(cri);

		for (Com_staffVO Com_staffVO : list) {
			logger.info(Com_staffVO.toString());
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

		List<Com_staffVO> list = dao.listSearch(cri);

		// for (Com_staffVO Com_staffVO : list) {
		// logger.info(Com_staffVO.getBno() + ": " + Com_staffVO.getTitle());
		// }

		logger.info("=====================================");

		logger.info("COUNT: " + dao.listSearchCount(cri));
	}

}
