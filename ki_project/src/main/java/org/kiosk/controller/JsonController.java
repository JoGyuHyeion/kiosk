package org.kiosk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.Com_bureauVO;
import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Com_teamVO;
import org.kiosk.domain.Com_videoVO;
import org.kiosk.domain.SampleVO;
import org.kiosk.domain.Vol_checkVO;
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
import org.kiosk.service.Com_bureauService;
import org.kiosk.service.Com_iconService;
import org.kiosk.service.Com_teamService;
import org.kiosk.service.Com_videoService;
import org.kiosk.service.JsonMateService;
import org.kiosk.service.JsonTeamsService;
import org.kiosk.service.Vol_checkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonRootName;

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
	private JsonMateService jsonMateService;
	@Inject
	private JsonTeamsService jsonTeamsService;
	@Inject
	private Com_bureauService bureauService;
	@Inject
	private Com_buildingService buildingService;
	@Inject
	private Com_teamService teamService;
	@Inject
	private Com_iconService iconService;
	@Inject
	private Com_videoService videoService;
	@Inject
	private Com_bgImgService bgImgService;
	@Inject
	private Vol_checkService vol_checkService;
	
	@RequestMapping(value = "/getVersion", method = RequestMethod.GET)
	public ResponseEntity<Vol_checkVO> getVersion() {
		logger.info("json/getVersion");
		ResponseEntity<Vol_checkVO> entity = null;
		try {
			entity = new ResponseEntity<>(vol_checkService.read(1), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getStaff/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<JsonStaffDTO> getStaff(@PathVariable("section_cd") String section_cd) {
		ResponseEntity<JsonStaffDTO> entity = null;
		logger.info("json/getStaff/{section_cd}");
		try {
			int mapIndex = 0;
			JsonStaffDTO jsonStaffDTO = jsonStaffService.read(section_cd);
			List<TeamsDTO> teamList = jsonTeamsService.list(section_cd);

			for (int index = 0; index < teamList.size(); index++) {
				List<MateDTO> mateList = jsonMateService.list(teamList.get(index));
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

	@RequestMapping(value = "/getGallery/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<List<JsonGelleryDTO>> getGallery(@PathVariable("section_cd") String section_cd) {
		logger.info("json/getGallery/{section_cd}");
		ResponseEntity<List<JsonGelleryDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonGelleryService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getNotice/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<List<JsonNoticeDTO>> getNotice(@PathVariable("section_cd") String section_cd) {
		logger.info("json/getNotice/{section_cd}");
		ResponseEntity<List<JsonNoticeDTO>> entity = null;
		try {
			entity = new ResponseEntity<>(jsonNoticeService.listAll(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getBuilding", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<Com_buildingVO>>> getBuilding() {
		logger.info("json/getBuilding");
		ResponseEntity<Map<String, List<Com_buildingVO>>> entity = null;
		Map<String, List<Com_buildingVO>> buildingList = null;
		try {
			buildingList = new HashMap<String, List<Com_buildingVO>>();
			String rootName = Com_buildingVO.class.getAnnotation(JsonRootName.class).value();
			buildingList.put(rootName, buildingService.listAll());

			// buildingList.put("건물이름", buildingService.listAll());

			entity = new ResponseEntity<Map<String, List<Com_buildingVO>>>(buildingList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getTeams", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<Com_teamVO>>> getTeams() {
		logger.info("json/getTeams");
		ResponseEntity<Map<String, List<Com_teamVO>>> entity = null;
		Map<String, List<Com_teamVO>> temaList = null;
		try {
			temaList = new HashMap<String, List<Com_teamVO>>();
			for (Com_bureauVO vo : bureauService.listAll()) {
				temaList.put(vo.getBureau_name(), teamService.jsonList(vo.getBureau_cd()));
			}
			entity = new ResponseEntity<>(temaList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getIcon", method = RequestMethod.GET)
	public ResponseEntity<List<Com_iconVO>> getIcon() {
		logger.info("json/getIcon");
		ResponseEntity<List<Com_iconVO>> entity = null;
		try {
			entity = new ResponseEntity<>(iconService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getVideo", method = RequestMethod.GET)
	public ResponseEntity<List<Com_videoVO>> getVideo() {
		logger.info("json/getVideo");
		ResponseEntity<List<Com_videoVO>> entity = null;
		try {
			entity = new ResponseEntity<>(videoService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getBgImage", method = RequestMethod.GET)
	public ResponseEntity<List<Com_bgImgVO>> getBgImage() {
		logger.info("json/getBgImage");
		ResponseEntity<List<Com_bgImgVO>> entity = null;
		try {
			entity = new ResponseEntity<>(bgImgService.jsonList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}


	@RequestMapping("/getErrorAuth")
	public ResponseEntity<Void> getListAuth() {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/getErrorNot")
	public ResponseEntity<List<SampleVO>> getListNot() {

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