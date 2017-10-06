package org.kiosk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.kiosk.domain.Com_staffVO;
import org.kiosk.domain.SampleVO;
import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.service.Com_staffService;
import org.kiosk.service.JsonGelleryService;
import org.kiosk.service.JsonNoticeService;
import org.kiosk.service.JsonStaffService;
import org.kiosk.service.MateService;
import org.kiosk.service.TeamsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {

	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);

	@Inject
	private JsonGelleryService jsonGelleryService;
	@Inject
	private JsonNoticeService jsonNoticeService;
	@Inject
	private JsonStaffService jsonStaffService;
	@Inject
	private Com_staffService staffService;
	@Inject
	private MateService mateService;
	@Inject
	private TeamsService teamsService;

<<<<<<< HEAD
	@RequestMapping(value = "/sendStaff/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<JsonStaffDTO> sendStaff(@PathVariable("section_cd") String section_cd) {
		ResponseEntity<JsonStaffDTO> entity = null;
		try {
			JsonStaffDTO dto = jsonStaffService.read(section_cd);
			//Com_staffVO staffVO=staffService.jsonRead(section_cd);
			//Map<Integer, MateDTO> mate =(Map<Integer, MateDTO>) mateService.listAll(staffVO);
			List<TeamsDTO> teams;
			entity = new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
=======
	@RequestMapping("/sendStaff")
	public JsonStaffDTO sendStaff() {
		JsonStaffDTO dto = new JsonStaffDTO();
		dto.setSection_name("K010-S010");
		dto.setSection_pass("12345");

		List<TeamsDTO> teams = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			TeamsDTO teamsdto = new TeamsDTO();
			teamsdto.setTeam_name("?ž„?›");

			Map<Integer, MateDTO> mate = new HashMap<>();

			for (int j = 0; j < 4; j++) {
				MateDTO matedto = new MateDTO();
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/controller/JsonController.java
				matedto.setNo(j);
				matedto.setName("ëª…ì?");
				matedto.setPosition("???Š¤?…");
				matedto.setJob("?›¹ ê°œë°œ?ž");
				matedto.setTel("010-5555-6666");
				matedto.setEmail("kj@naver.com");
=======
				matedto.setSt_no(j);
				matedto.setSt_nm("ëª…ì¤€");
				matedto.setSt_position("í’€ìŠ¤í…");
				matedto.setSt_job("ì›¹ ê°œë°œìž");;
				matedto.setSt_tel("010-5555-6666");
				matedto.setSt_email("kj@naver.com");
>>>>>>> c718f6c0b276656d7d57c48609db55c599051672:ki_project/src/main/java/org/kiosk/controller/JsonController.java
				matedto.setImg_filenm("staff_00882.jpg");
				matedto.setSt_sort(4);
				matedto.setSt_status(2);
				mate.put(j, matedto);
				
			}
			teamsdto.setMate(mate);
			teams.add(teamsdto);
			
>>>>>>> 099f6edf2ceaf0f96175d5d3a74cae515ddb4551
		}
		return entity;
	}

	@RequestMapping(value = "/sendGallery/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<List<JsonGelleryDTO>> sendGallery(@PathVariable("section_cd") String section_cd) {

		ResponseEntity<List<JsonGelleryDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonGelleryService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

<<<<<<< HEAD
	@RequestMapping(value = "/sendNotice/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<List<JsonNoticeDTO>> sendNotice(@PathVariable("section_cd") String section_cd) {

		ResponseEntity<List<JsonNoticeDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonNoticeService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
=======
		List<JsonNoticeDTO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JsonNoticeDTO dto = new JsonNoticeDTO();
			dto.setBbs_no(i);
			dto.setBbs_title("?‚¨ëª…ì??”¨");
			dto.setBbs_content("ë°”ì˜?‹œ?„¤ ê·¸ì°¸ ?°?´?„°?„ ?—†êµ¬ë§Œ");
			dto.setBbs_file("/_files/board/");
			list.add(dto);
>>>>>>> 099f6edf2ceaf0f96175d5d3a74cae515ddb4551
		}
		return entity;
	}

	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot() {

		List<SampleVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("ê¸¸ë™");
			vo.setLastName("?™");
			vo.setMno(i);
			list.add(vo);
		}

		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}

}
