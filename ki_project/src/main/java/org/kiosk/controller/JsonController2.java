//package org.kiosk.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.inject.Inject;
//
//import org.kiosk.domain.SampleVO;
//import org.kiosk.dto.JsonGelleryDTO;
//import org.kiosk.dto.JsonNoticeDTO;
//import org.kiosk.dto.JsonStaffDTO;
//import org.kiosk.dto.MateDTO;
//import org.kiosk.dto.TeamsDTO;
//import org.kiosk.service.JsonGelleryService;
//import org.kiosk.service.JsonNoticeService;
//import org.kiosk.service.JsonStaffService;
//import org.kiosk.service.MateService;
//import org.kiosk.service.TeamsService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/json")
//public class JsonController2 {
//
//	private static final Logger logger = LoggerFactory.getLogger(JsonController2.class);
//
//	@Inject
//	private JsonGelleryService gelleryService;
//	@Inject
//	private JsonNoticeService noticeService;
//	@Inject
//	private JsonStaffService staffService;
//	@Inject
//	private MateService mateService;
//	@Inject
//	private TeamsService teamsService;
//
//	@RequestMapping("/sendStaff")
//	public JsonStaffDTO sendStaff() {
//		JsonStaffDTO dto = new JsonStaffDTO();
//		dto.setSection_name("K010-S010");
//		dto.setSection_pass("12345");
//
//		List<TeamsDTO> teams = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			TeamsDTO teamsdto = new TeamsDTO();
//			teamsdto.setTeam_name("임원");
//
//			Map<Integer, MateDTO> mate = new HashMap<>();
//
//			for (int j = 0; j < 4; j++) {
//				MateDTO matedto = new MateDTO();
//				matedto.setSt_no(j);
//				matedto.setSt_nm("명준");
//				matedto.setSt_position("풀스텍");
//				matedto.setSt_job("웹 개발자");
//				;
//				matedto.setSt_tel("010-5555-6666");
//				matedto.setSt_email("kj@naver.com");
//				matedto.setImg_filenm("staff_00882.jpg");
//				matedto.setSt_sort(4);
//				matedto.setSt_status(2);
//				mate.put(j, matedto);
//
//			}
//			teamsdto.setMate(mate);
//			teams.add(teamsdto);
//
//		}
//		dto.setTeams(teams);
//
//		return dto;
//	}
//
//	@RequestMapping(value = "/sendGallery/{section_cd}", method = RequestMethod.GET)
//	public ResponseEntity<List<JsonGelleryDTO>> sendGallery(@PathVariable("section_cd") String section_cd) {
//
//		ResponseEntity<List<JsonGelleryDTO>> entity = null;
//		try {
//			entity = new ResponseEntity<>(gelleryService.listAll(section_cd), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		return entity;
//	}
//
//	@RequestMapping(value = "/sendNotice/{section_cd}", method = RequestMethod.GET)
//	public ResponseEntity<List<JsonNoticeDTO>> sendNotice(@PathVariable("section_cd") String section_cd) {
//
//		ResponseEntity<List<JsonNoticeDTO>> entity = null;
//		try {
//			entity = new ResponseEntity<>(noticeService.listAll(section_cd), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		return entity;
//	}
//
//	@RequestMapping("/sendErrorAuth")
//	public ResponseEntity<Void> sendListAuth() {
//
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
//
//	@RequestMapping("/sendErrorNot")
//	public ResponseEntity<List<SampleVO>> sendListNot() {
//
//		List<SampleVO> list = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			SampleVO vo = new SampleVO();
//			vo.setFirstName("길동");
//			vo.setLastName("홍");
//			vo.setMno(i);
//			list.add(vo);
//		}
//
//		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
//	}
//
//}
