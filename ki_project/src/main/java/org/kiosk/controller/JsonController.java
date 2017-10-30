package org.kiosk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.kiosk.domain.SampleVO;
import org.kiosk.dto.Com_buildingDTO;
import org.kiosk.dto.Com_iconDTO;
import org.kiosk.dto.Com_videoDTO;
import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.service.JsonGelleryService;
import org.kiosk.service.JsonNoticeService;
import org.kiosk.service.JsonStaffService;
import org.kiosk.service.JsonbuildingService;
import org.kiosk.service.JsoniconService;
import org.kiosk.service.JsonvideoService;
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
	private MateService mateService;
	@Inject
	private TeamsService teamsService;
	@Inject
	private JsonbuildingService jsonbuildingService;
	@Inject
	private JsoniconService jsoniconService;
	@Inject
	private JsonvideoService jsonvideoService;

	@RequestMapping(value = "/sendStaff/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<JsonStaffDTO> sendStaff(@PathVariable("section_cd") String section_cd) {
		ResponseEntity<JsonStaffDTO> entity = null;
		logger.info("json/sendStaff/{section_cd}");
		try {
			int mapIndex = 0;
			JsonStaffDTO jsonStaffDTO = jsonStaffService.read(section_cd);
			List<TeamsDTO> teamList = teamsService.list(section_cd);

			for (int index = 0; index < teamList.size(); index++) {
				List<MateDTO> mateList = mateService.list(teamList.get(index));
				Map<Integer, MateDTO> mateMap = new HashMap<Integer, MateDTO>();
				mapIndex = 0;
				for (MateDTO mateDTO : mateList) {
					mateMap.put(mapIndex, mateDTO);
					mapIndex++;
				}
				teamList.get(index).setMate(mateMap);
			}
			jsonStaffDTO.setTeams(teamList);
			entity = new ResponseEntity<>(jsonStaffDTO, HttpStatus.OK);
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
	
	@RequestMapping(value = "/sendBuilding", method = RequestMethod.GET)
	public ResponseEntity<List<Com_buildingDTO>> sendBuilding() {
		logger.info("json/sendNotice/{section_cd}");
		ResponseEntity<List<Com_buildingDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonbuildingService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/sendIcon", method = RequestMethod.GET)
	public ResponseEntity<List<Com_iconDTO>> sendIcon() {
		logger.info("json/sendNotice/{section_cd}");
		ResponseEntity<List<Com_iconDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsoniconService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/sendVideo", method = RequestMethod.GET)
	public ResponseEntity<List<Com_videoDTO>> sendVideo() {
		logger.info("json/sendNotice/{section_cd}");
		ResponseEntity<List<Com_videoDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonvideoService.listAll(), HttpStatus.OK);
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