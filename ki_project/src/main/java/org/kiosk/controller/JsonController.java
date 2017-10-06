package org.kiosk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.kiosk.domain.SampleVO;
import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.service.JsonGelleryService;
import org.kiosk.service.JsonNoticeService;
import org.kiosk.service.JsonStaffService;
import org.kiosk.service.MateService;
import org.kiosk.service.TeamsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);

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

	@RequestMapping("/sendStaff")
	public JsonStaffDTO sendStaff() {
		JsonStaffDTO dto = new JsonStaffDTO();
		dto.setSection_name("K010-S010");
		dto.setSection_password("12345");

		List<TeamsDTO> teams = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			TeamsDTO teamsdto = new TeamsDTO();
			teamsdto.setTeam_name("?��?��");

			Map<Integer, MateDTO> mate = new HashMap<>();

			for (int j = 0; j < 4; j++) {
				MateDTO matedto = new MateDTO();
				matedto.setNo(j);
				matedto.setName("명�?");
				matedto.setPosition("???��?��");
				matedto.setJob("?�� 개발?��");
				matedto.setTel("010-5555-6666");
				matedto.setEmail("kj@naver.com");
				matedto.setImg_filenm("staff_00882.jpg");
				matedto.setSort(4);
				matedto.setStatus(2);
				mate.put(j, matedto);
				
			}
			teamsdto.setMate(mate);
			teams.add(teamsdto);
			
		}
		dto.setTeams(teams);;

		return dto;
	}

	@RequestMapping("/sendGallery")
	public List<JsonGelleryDTO> sendGallery() {

		List<JsonGelleryDTO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JsonGelleryDTO dto = new JsonGelleryDTO();
			dto.setNo(i + 1);
			dto.setTitle("abc");
			dto.setCaption("캡션");
			dto.setFilenm("/_files/gallery/none/2017/09/20170911-59b6c8ae25dad368727049.png");
			list.add(dto);
		}
		return list;
	}

	@RequestMapping("/sendNotice")
	public List<JsonNoticeDTO> sendNotice() {

		List<JsonNoticeDTO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JsonNoticeDTO dto = new JsonNoticeDTO();
			dto.setBbs_no(i);
			dto.setBbs_title("?��명�??��");
			dto.setBbs_content("바쁘?��?�� 그참 ?��?��?��?�� ?��구만");
			dto.setBbs_file("/_files/board/");
			list.add(dto);
		}
		return list;
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
			vo.setFirstName("길동");
			vo.setLastName("?��");
			vo.setMno(i);
			list.add(vo);
		}

		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}

}
