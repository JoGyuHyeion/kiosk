package org.kiosk.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.domain.Com_buildingVO;
import org.kiosk.persistence.Com_buildingDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class JsonBuildingTest {

	@Inject
	private Com_buildingDAO dao;

	private static Logger logger = LoggerFactory.getLogger(JsonBuildingTest.class);

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

//	@Test
	public void testCreate() throws Exception {

		Com_buildingVO dto = new Com_buildingVO();
		dto.setBu_img("사진");
		dto.setBu_name("1층");
		dto.setBu_ndt(sqlDate);
		dao.create(dto);
	}

//	@Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());
	}

	// @Test
	public void testUpdate() throws Exception {

		Com_buildingVO dto = new Com_buildingVO();
		dto.setBu_no(1);
		dto.setBu_img("사진");
		dto.setBu_name("1층");
		dao.update(dto);
	}

	// @Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

//	@Test
	public void testListAll() throws Exception {

		logger.info(dao.listAll().toString());

	}

//	@Test
	public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {

		Com_buildingVO dto = new Com_buildingVO();
		dto.setBu_img("img");
		dto.setBu_name("name");
		dto.setBu_ndt(sqlDate);
		dto.setBu_no(1);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String result = mapper.writeValueAsString(dto);
		System.out.println(result);

		assertThat(result, containsString("name"));
		assertThat(result, containsString("building"));
	}
	
	@Test
	public void whenSerializingUsingListJsonRootName_thenCorrect() throws JsonProcessingException {

		Com_buildingVO dto = new Com_buildingVO();
		dto.setBu_img("img");
		dto.setBu_name("name");
		dto.setBu_ndt(sqlDate);
		dto.setBu_no(1);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		List<Com_buildingVO> list = new ArrayList<Com_buildingVO>();
		list.add(dto);
		list.add(dto);
		String rootName = Com_buildingVO.class.getAnnotation(JsonRootName.class).value();
		String result =mapper.writer().withRootName(rootName).writeValueAsString(list);
		System.out.println(result);

		assertThat(result, containsString("name"));
		assertThat(result, containsString("building"));
	}

}
