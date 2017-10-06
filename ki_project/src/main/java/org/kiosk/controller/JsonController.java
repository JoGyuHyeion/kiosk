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


	@RequestMapping(value = "/sendStaff/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<JsonStaffDTO> sendStaff(@PathVariable("section_cd") String section_cd) {
		ResponseEntity<JsonStaffDTO> entity = null;
		logger.info("json/sendStaff/{section_cd}");
		try {
			JsonStaffDTO dto = jsonStaffService.read(section_cd);
			//Com_staffVO staffVO=staffService.jsonRead(section_cd);
			//Map<Integer, MateDTO> mate =(Map<Integer, MateDTO>) mateService.listAll(staffVO);
			List<TeamsDTO> teams;
			entity = new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/sendGallery/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<List<JsonGelleryDTO>> sendGallery(@PathVariable("section_cd") String section_cd) {
		logger.info("json/sendGallery/{section_cd}");
		ResponseEntity<List<JsonGelleryDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonGelleryService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}


	@RequestMapping(value = "/sendNotice/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<List<JsonNoticeDTO>> sendNotice(@PathVariable("section_cd") String section_cd) {
		logger.info("json/sendNotice/{section_cd}");
		ResponseEntity<List<JsonNoticeDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonNoticeService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			list.add(vo);
		}

		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}

}
