package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Com_bureauVO;
import org.zerock.persistence.Com_bureauDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })


public class Com_bureauTest {
	@Inject
	private Com_bureauDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(Com_bureauTest.class);
	
	 //@Test
		public void testCreate() throws Exception {

			Com_bureauVO vo = new Com_bureauVO();
			vo.setBureau_cd("test2");
			vo.setBureau_name("namee2");
			vo.setBureau_use("1");
			dao.create(vo);
		}

		// @Test
		public void testRead() throws Exception {

			logger.info(dao.read("김치").toString());

		}

		// @Test
		public void testUpdate() throws Exception {

			Com_bureauVO vo = new Com_bureauVO();
			vo.setBureau_cd("김치");
			vo.setBureau_name("바뀐이름");
			vo.setBureau_use("0");
			dao.update(vo);
		}

		// @Test
		public void testDelete() throws Exception {
			
			dao.delete("test");
		}

		// @Test
		public void testListAll() throws Exception {

			logger.info(dao.listAll().toString());

		}

}
