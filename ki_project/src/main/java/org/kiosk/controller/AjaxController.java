package org.kiosk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.kiosk.domain.Com_sectionVO;
import org.kiosk.domain.Com_teamVO;
import org.kiosk.dto.LoginDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.service.Com_bureauService;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.Com_teamService;
import org.kiosk.service.JsonTeamsService;
import org.kiosk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	@Inject
	private JsonTeamsService jsonTeamsService;
	@Inject
	private Com_teamService teamService;
	@Inject
	private Com_sectionService sectionService;
	@Inject
	private Com_bureauService bureauService;
	@Inject
	private UserService userService;

	private static final String SUCCESS = "SUCCESS";

	@RequestMapping(value = "/section/insert", method = RequestMethod.POST)
	public ResponseEntity<String> sectionReister(@RequestBody Com_sectionVO vo) {
		logger.info("/section/insert");
		ResponseEntity<String> entity = null;
		try {
			vo.setSection_sort(sectionService.lastInsertSort(vo.getBureau_cd()));
			vo.setSection_fullpath(bureauService.read(vo.getBureau_cd()).getBureau_name() + ">" + vo.getSection_name());
			sectionService.regist(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	// 제거되어야 할 메소드
	// @RequestMapping(value = "/section/update/{section_fullcode}", method = {
	// RequestMethod.PUT, RequestMethod.PATCH })
	// public ResponseEntity<String> sectionUpdate(@PathVariable("section_fullcode")
	// String section_fullcode,
	// @RequestBody Com_sectionVO vo) {
	// logger.info("/section/update/{section_fullcode}");
	// ResponseEntity<String> entity = null;
	// try {
	// vo.setSection_fullcode(section_fullcode);
	// sectionService.modify(vo);
	// entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	// } catch (Exception e) {
	// e.printStackTrace();
	// entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	// }
	// return entity;
	// }

	@RequestMapping(value = "/section/listUpdate/{bureau_cd}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> sectionListUpdate(@PathVariable("bureau_cd") String bureau_cd,
			@RequestBody List<Com_sectionVO> secList) {
		logger.info("/section/update/{section_fullcode}");
		ResponseEntity<String> entity = null;
		try {
			for (Com_sectionVO vo : secList) {
				sectionService.modify(vo);
			}
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/section/del/{section_fullcode}", method = RequestMethod.DELETE)
	public ResponseEntity<String> sectionRemove(@PathVariable("section_fullcode") String section_fullcode) {
		logger.info("/section/del/{section_fullcode}");
		ResponseEntity<String> entity = null;
		try {
			sectionService.remove(section_fullcode);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/team/insert", method = RequestMethod.POST)
	public ResponseEntity<String> teamReister(@RequestBody Com_teamVO vo) {
		logger.info("/section/insert");
		ResponseEntity<String> entity = null;
		try {
			teamService.regist(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/team/update/{section_cd}/{team_cd}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> teamUpdate(@PathVariable("section_cd") String section_cd,
			@PathVariable("team_cd") String team_cd, @RequestBody Com_teamVO vo) {
		logger.info("/team/update/{section_cd}/{team_cd}");
		ResponseEntity<String> entity = null;
		try {
			vo.setSection_cd(section_cd);
			vo.setTeam_cd(team_cd);
			teamService.modify(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/team/del/{section_cd}/{team_cd}", method = RequestMethod.DELETE)
	public ResponseEntity<String> teamRemove(@PathVariable("section_cd") String section_cd,
			@PathVariable("team_cd") String team_cd) {
		logger.info("/team/del/{section_cd}/{team_cd}");
		ResponseEntity<String> entity = null;
		Com_teamVO vo = null;
		try {
			vo = new Com_teamVO();
			vo.setSection_cd(section_cd);
			vo.setTeam_cd(team_cd);
			teamService.remove(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/staff/getTeams/{section_cd}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> getTeamsPOST(@PathVariable("section_cd") String section_cd) {
		logger.info("staff/getTeams/{section_cd}");
		ResponseEntity<String> entity = null;

		try {
			Map<String, String> obj = new HashMap<String, String>();
			for (TeamsDTO dto : jsonTeamsService.list(section_cd)) {
				obj.put(dto.getTeam_cd(), dto.getTeam_nm());
			}
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true); // key濡� �젙�젹 �꽕�젙
			entity = new ResponseEntity<String>(om.writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/staff/getTeams/{section_cd}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> getTeamsGET(@PathVariable("section_cd") String section_cd) {
		logger.info("staff/getTeams/{section_cd}");
		ResponseEntity<String> entity = null;

		try {
			Map<String, String> obj = new HashMap<String, String>();
			for (TeamsDTO dto : jsonTeamsService.list(section_cd)) {
				obj.put(dto.getTeam_cd(), dto.getTeam_nm());
			}
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true); // key濡� �젙�젹 �꽕�젙
			entity = new ResponseEntity<String>(om.writeValueAsString(obj), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/staffModify/getTeams/{section_cd}", method = RequestMethod.GET)
	public ResponseEntity<List<Com_teamVO>> getStaffTeamsGET(@PathVariable("section_cd") String section_cd) {
		logger.info("staff/getTeams/{section_cd}");

		ResponseEntity<List<Com_teamVO>> entity = null;
		try {
			entity = new ResponseEntity<List<Com_teamVO>>(teamService.list(section_cd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/user/duplCheck/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getDuplCheck(@PathVariable("id") String id) {
		logger.info("/user/duplCheck");

		ResponseEntity<String> entity = null;
		LoginDTO dto = null;
		String msg = "";

		try {
			dto = new LoginDTO();
			dto.setId(id);

			if (userService.dupCheck(dto) == null) {
				msg = SUCCESS;
			} else {
				msg = "FASLE";
			}

			entity = new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
