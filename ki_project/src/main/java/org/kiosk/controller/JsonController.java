package org.kiosk.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.kiosk.domain.BuildingVO;
import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.Com_sectionVO;
import org.kiosk.domain.Com_videoVO;
import org.kiosk.domain.SampleVO;
import org.kiosk.domain.Vol_checkVO;
import org.kiosk.dto.JsonGelleryDTO;
import org.kiosk.dto.JsonNoticeDTO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.service.BuildingService;
import org.kiosk.service.Com_bgImgService;
import org.kiosk.service.JsonGelleryService;
import org.kiosk.service.JsonMateService;
import org.kiosk.service.JsonNoticeService;
import org.kiosk.service.JsonStaffService;
import org.kiosk.service.Com_buildingService;
import org.kiosk.service.Com_iconService;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.Com_videoService;
import org.kiosk.service.Vol_checkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
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
	private JsonMateService jsonMateService;
	@Inject
	private Com_sectionService sectionService;
	@Inject
	private Com_buildingService buildingService;
	@Inject
	private BuildingService buildingNameService;
	@Inject
	private Com_iconService iconService;
	@Inject
	private Com_videoService videoService;
	@Inject
	private Com_bgImgService bgImgService;
	@Inject
	private Vol_checkService vol_checkService;
	@Resource(name="MateDTO")
	private MateDTO staffDTO;
	
	////테스트용
	@RequestMapping(value = "/getAllStaff", method = RequestMethod.GET)
	public ResponseEntity<JsonStaffDTO> gettest() {
		logger.info("json/getAllStaff");
		ResponseEntity<JsonStaffDTO> entity = null;
		try {
			entity = new ResponseEntity<>(jsonStaffService.getJsonStaff("none"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/setStaffStaus/{st_no}/{st_status}", method = RequestMethod.PATCH)
	public ResponseEntity<String> setStaffStaus(@PathVariable("st_no") int st_no,@PathVariable("st_status") int st_status) {
		logger.info("json/setStaffStaus");
		ResponseEntity<String> entity = null;
		try {
			staffDTO.setSt_no(st_no);
			staffDTO.setSt_status(st_status);
			jsonMateService.modify(staffDTO);
			entity = new ResponseEntity<>("SUCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/testHeader1", method = RequestMethod.GET)
	public ResponseEntity<Vol_checkVO> testHeader1(HttpServletRequest request, HttpServletResponse response) {
		logger.info("json/getVersion");
		ResponseEntity<Vol_checkVO> entity = null;
		try {
			response.setHeader("JoGyuHyeon", "Test Accept");
			 String headerValue = CacheControl.maxAge(10, TimeUnit.SECONDS).getHeaderValue();
			 response.addHeader("Cache-Control", headerValue);
			entity = new ResponseEntity<>(vol_checkService.read(1), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/testHeader2", method = RequestMethod.GET)
	public ResponseEntity<Vol_checkVO> testHeader2(HttpServletRequest request, HttpServletResponse response) {
		logger.info("json/getVersion");
		ResponseEntity<Vol_checkVO> entity = null;
		try {
			URI location = new URI("http://localhost:8080/json/testHeader2");
			 HttpHeaders responseHeaders = new HttpHeaders();
			 responseHeaders.setLocation(location);
			 responseHeaders.set("JoGyuHyeontest2", "MyValue");
			entity = new ResponseEntity<>(vol_checkService.read(1), responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("/handle")
	 public ResponseEntity<String> handle() throws URISyntaxException {
		URI location = new URI("http://localhost:8080/json/handle");
	   return ResponseEntity.created(location).header("JoGyuHyeontest3", "MyValue").body("Hello World");
	 }



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
			entity = new ResponseEntity<>(jsonStaffService.getJsonStaff(section_cd), HttpStatus.OK);
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
			entity = new ResponseEntity<>(jsonGelleryService.list(section_cd), HttpStatus.OK);
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
			entity = new ResponseEntity<>(jsonNoticeService.list(section_cd), HttpStatus.OK);
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
			
			for(BuildingVO vo:buildingNameService.listAll() ) {
				buildingList.put(vo.getBuilding_name(), buildingService.list(vo.getBu_type()));
			}
			entity = new ResponseEntity<Map<String, List<Com_buildingVO>>>(buildingList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/getTeams", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<Com_sectionVO>>> getTeams() {
		logger.info("json/getTeams");
		ResponseEntity<Map<String, List<Com_sectionVO>>> entity = null;
		try {
			entity = new ResponseEntity<>(sectionService.getJsonSection(), HttpStatus.OK);
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