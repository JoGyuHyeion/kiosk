package org.kiosk.controller;

import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_staffVO;
import org.kiosk.domain.Com_teamVO;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.persistence.Com_staffDAO;
import org.kiosk.persistence.Com_teamDAO;
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
	@Inject
	private Com_teamDAO teamdao;

	private static Logger logger = LoggerFactory.getLogger(Com_staffTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	// @Test
	public void testCreate() throws Exception {

		Com_staffVO vo = new Com_staffVO();
		vo.setReal_use_dep_nm("지혜");
		vo.setUsr_nm("랩장");
		vo.setLogon_id("010-6666-7777");
		vo.setSt_key("ku@naver.com");
		vo.setClass_nm("학생");
		vo.setPosit_nm("profile");
		vo.setTelno("img1");
		vo.setImg_filenm("img_filenm1");
		vo.setEmail_addr("부서");
		vo.setUsr_work_state_code_nm("1");
		vo.setSt_status(1);
		vo.setEngm_se("11");
		vo.setAdi_info7("3");
		vo.setSt_sort(5);
		vo.setSection_cd("3");
		vo.setTeam_cd("3");
		dao.create(vo);
	}

	// @Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_staffVO vo = new Com_staffVO();
		vo.setUsr_nm("조규현");
		vo.setSt_no(1);

		dao.update(vo);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	// @Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());
		List<Com_staffVO> list = dao.listAll();
		for (Com_staffVO Com_staff2VO : list) {
			logger.info(Com_staff2VO.getSt_no() + ":" + Com_staff2VO.getReal_use_dep_nm());
		}

	}

	@Test
	public void testLastInsertID() throws Exception {
		logger.info(String.valueOf(dao.lastInsertID()));
	}

	// @Test
	public void testListPage() throws Exception {

		int page = 1;

		List<Com_staffVO> list = dao.listPage(page);

		for (Com_staffVO Com_staff2VO : list) {
			logger.info(Com_staff2VO.getSt_no() + ":" + Com_staff2VO.getReal_use_dep_nm());
		}
	}

	// @Test
	public void testListCriteria() throws Exception {

		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(20);

		List<Com_staffVO> list = dao.listCriteria(cri);

		for (Com_staffVO Com_staff2VO : list) {
			logger.info(Com_staff2VO.toString());
		}
	}

	// @Test
	public void testURI() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/vo/read").queryParam("sno", 12)
				.queryParam("perPageNum", 20).build();

		logger.info("/vo/read?sno=12&perPageNum=20");
		logger.info(uriComponents.toString());

	}

	// @Test
	public void testURI2() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/{module}/{page}").queryParam("sno", 12)
				.queryParam("perPageNum", 20).build().expand("vo", "read").encode();

		logger.info("/vo/read?sno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}

	// @Test
	public void testDynamic1() throws Exception {

		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		// cri.setKeyword("");
		cri.setSection_cd("none");
		// cri.setTeam_cd("none");

		logger.info("=====================================");

		List<Com_staffVO> list = dao.listSearch(cri);

		for (Com_staffVO Com_staff2VO : list) {
			logger.info(Com_staff2VO.getSt_no() + ":" + Com_staff2VO.getReal_use_dep_nm());
		}

		logger.info("=====================================");

		logger.info("COUNT: " + dao.listSearchCount(cri));
	}

	// @Test
	public void countSt_sort() throws Exception {
		Com_staffVO vo = new Com_staffVO();
		vo.setSection_cd("K010-S030");
		vo.setTeam_cd("T06");
		logger.info(dao.createSortNo(vo) + 1 + "다음들어갈 수 ");
	}

	// @Test
	public void St_sort() throws Exception {

		Com_staffVO vo = new Com_staffVO();
		int i = 0;

		for (Com_teamVO teamVO : teamdao.list("none")) {
			vo.setTeam_cd(teamVO.getTeam_cd());
			vo.setSection_cd(teamVO.getSection_cd());
			i = 0;

			for (Com_staffVO staffVO : dao.teamListSort(vo)) {
				staffVO.setSt_sort(i);
				dao.sortupdate(staffVO);
				i++;
			}

		}
	}

}
