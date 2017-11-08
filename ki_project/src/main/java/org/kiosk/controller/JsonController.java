package org.kiosk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Com_videoVO;
import org.kiosk.domain.SampleVO;
import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.service.Com_bgImgService;
import org.kiosk.service.JsonGelleryService;
import org.kiosk.service.JsonNoticeService;
import org.kiosk.service.JsonStaffService;
import org.kiosk.service.Com_buildingService;
import org.kiosk.service.Com_iconService;
import org.kiosk.service.Com_videoService;
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
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/json")
public class JsonController {

	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);

	@Inject
	private JsonGelleryService gelleryService;
	@Inject
	private JsonNoticeService noticeService;
	@Inject
	private JsonStaffService staffService;
	@Inject
	private MateService mateService;
	@Inject
	private TeamsService teamsService;
	@Inject
	private Com_buildingService buildingService;
	@Inject
	private Com_iconService iconService;
	@Inject
	private Com_videoService videoService;
	@Inject
	private Com_bgImgService bgImgService;

	@RequestMapping(value = "/sendStaff/{section_cd}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<JsonStaffDTO> sendStaff(@PathVariable("section_cd") String section_cd) {
		ResponseEntity<JsonStaffDTO> entity = null;
		logger.info("json/sendStaff/{section_cd}");
		try {
			int mapIndex = 0;
			JsonStaffDTO jsonStaffDTO = staffService.read(section_cd);
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

	@RequestMapping(value = "/sendGallery/{section_cd}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<List<JsonGelleryDTO>> sendGallery(@PathVariable("section_cd") String section_cd) {
		logger.info("json/sendGallery/{section_cd}");
		ResponseEntity<List<JsonGelleryDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(gelleryService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/sendNotice/{section_cd}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<List<JsonNoticeDTO>> sendNotice(@PathVariable("section_cd") String section_cd) {
		logger.info("json/sendNotice/{section_cd}");
		ResponseEntity<List<JsonNoticeDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(noticeService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/sendBuilding", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<Map<String, List<Com_buildingVO>>> sendBuilding() {
		logger.info("json/sendBuilding");
		ResponseEntity<Map<String, List<Com_buildingVO>>> entity = null;
		Map<String, List<Com_buildingVO>> buildingList = null;
		try {
			buildingList = new HashMap<String, List<Com_buildingVO>>();
			String rootName = Com_buildingVO.class.getAnnotation(JsonRootName.class).value();
			buildingList.put(rootName, buildingService.listAll());

			buildingList.put("원효관", buildingService.listAll());

			entity = new ResponseEntity<Map<String, List<Com_buildingVO>>>(buildingList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/sendIcon", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<List<Com_iconVO>> sendIcon() {
		logger.info("json/sendIcon");
		ResponseEntity<List<Com_iconVO>> entity = null;
		try {
			entity = new ResponseEntity<>(iconService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/sendVideo", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<List<Com_videoVO>> sendVideo() {
		logger.info("json/sendVideo");
		ResponseEntity<List<Com_videoVO>> entity = null;
		try {
			entity = new ResponseEntity<>(videoService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/sendBgImage", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<List<Com_bgImgVO>> sendBgImage() {
		logger.info("json/sendBgImage");
		ResponseEntity<List<Com_bgImgVO>> entity = null;
		try {
			entity = new ResponseEntity<>(bgImgService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getTeams/{section_cd}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> getTeamsPOST(@PathVariable("section_cd") String section_cd) {
		logger.info("json/getTeams/{section_cd}");
		ResponseEntity<String> entity = null;

		try {
			Map<String, String> obj = new HashMap<String, String>();
			for (TeamsDTO dto : teamsService.list(section_cd)) {
				obj.put(dto.getTeam_cd(), dto.getTeam_nm());
			}
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true); // key로 정렬 설정
			entity = new ResponseEntity<>(om.writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getTeams/{section_cd}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> getTeamsGET(@PathVariable("section_cd") String section_cd) {
		logger.info("json/getTeams/{section_cd}");
		ResponseEntity<String> entity = null;

		try {
			Map<String, String> obj = new HashMap<String, String>();
			for (TeamsDTO dto : teamsService.list(section_cd)) {
				obj.put(dto.getTeam_cd(), dto.getTeam_nm());
			}
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true); // key로 정렬 설정
			entity = new ResponseEntity<>(om.writeValueAsString(obj), HttpStatus.OK);
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