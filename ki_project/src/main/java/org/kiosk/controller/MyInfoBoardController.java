package org.kiosk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kiosk.domain.Com_bureauVO;
import org.kiosk.domain.Com_sectionVO;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.domain.UserVO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.service.Com_bgImgService;
import org.kiosk.service.Com_buildingService;
import org.kiosk.service.Com_bureauService;
import org.kiosk.service.Com_iconService;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.Com_teamService;
import org.kiosk.service.Com_videoService;
import org.kiosk.service.JsonGelleryService;
import org.kiosk.service.JsonMateService;
import org.kiosk.service.JsonNoticeService;
import org.kiosk.service.JsonStaffService;
import org.kiosk.service.JsonTeamsService;
import org.kiosk.service.UserService;
import org.kiosk.service.Vol_checkService;
import org.kiosk.util.UsbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/myinfoboard/*")
public class MyInfoBoardController {

	private static final Logger logger = LoggerFactory.getLogger(MyInfoBoardController.class);

	@Inject
	private Com_sectionService sectionService;
	@Inject
	private Com_teamService teamService;
	@Inject
	private Com_bureauService bureauService;
	@Inject
	private UserService userService;

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
	private Com_buildingService buildingService;
	@Inject
	private Com_iconService iconService;
	@Inject
	private Com_videoService videoService;
	@Inject
	private Com_bgImgService bgImgService;
	@Inject
	private Vol_checkService vol_checkService;

	@Resource(name = "UsbUtils")
	private UsbUtils usbUtils;

	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public void newUserGET(Model model, HttpServletRequest request) throws Exception {

		logger.info("myinfoboard/passwd - GET");
		model.addAttribute("sectionList", sectionService.listAll());
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());

	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUserPOST(UserVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("/myinfoboard/newUser - POST");
		logger.info("newUser post ...........");
		logger.info(vo.toString());

		userService.newUser(vo);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myinfoboard/newUser";
	}

	@RequestMapping(value = "/passwd", method = RequestMethod.GET)
	public void passwdGET(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
		logger.info("myinfoboard/passwd - GET");
	}

	@RequestMapping(value = "/passwd", method = RequestMethod.POST)
	public String passwdPOST(SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/passwd - POST");
		logger.info(cri.toString());

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/myinfoboard/passwd";
	}

	@RequestMapping(value = "/section", method = RequestMethod.GET)
	public void sectionGET(@ModelAttribute("cri") SearchCriteria cri, Model model, @ModelAttribute("bcd") String bcd,
			HttpServletRequest request) throws Exception {

		logger.info("myinfoboard/section - GET ");
		model.addAttribute("bureauService", bureauService.listAll());
		model.addAttribute("bcd", sectionService.bureauList(bcd));

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());

	}

	@RequestMapping(value = "/section", method = RequestMethod.POST)
	public String sectionPOST(SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/section - POST ");
		logger.info(cri.toString());

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/myinfoboard/section";
	}

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public void teamGET(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
		logger.info("myinfoboard/team - GET ");
		if (userVO.getAuth() == 0) {
			model.addAttribute("list", teamService.superListAll());
		} else if (userVO.getAuth() == 1) {
			model.addAttribute("list", teamService.listAll(userVO.getSection_fullcode()));
		}

	}

	@RequestMapping(value = "/team", method = RequestMethod.POST)
	public String teamPOST(SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/team - POST ");
		logger.info(cri.toString());

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/myinfoboard/team";
	}

	@RequestMapping(value = "/usb", method = RequestMethod.GET)
	public void usbGET(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {
		logger.info("myinfoboard/usb - GET ");
		model.addAttribute("sectionService", sectionService.listAll());
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/usb", method = RequestMethod.POST)
	public String usbPOST(RedirectAttributes rttr, @ModelAttribute("section_fullcode") String section_fullcode,
			HttpServletRequest request) throws Exception {
		String root_path = request.getSession().getServletContext().getRealPath("/");

		logger.info("/myinfoboard/usb - POST");
		logger.info("newUser post ...........");
		System.out.println(section_fullcode);
		rttr.addFlashAttribute("msg", "SUCCESS");

		usbUtils.makeJsonTextFile(root_path + uploadPath, "vol_check", usbUtils.makeJsonString(vol_checkService.read(1)));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "staff", usbUtils.makeJsonString(getJsonStaff(section_fullcode)));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "gallery", usbUtils.makeJsonString(jsonGelleryService.listAll(section_fullcode)));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "notice", usbUtils.makeJsonString(jsonNoticeService.listAll(section_fullcode)));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "building",usbUtils.makeJsonString(vol_checkService.read(1)));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "teams", usbUtils.makeJsonString(getJsonTeams()));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "icon", usbUtils.makeJsonString(iconService.listAll()));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "video", usbUtils.makeJsonString(videoService.listAll()));
		usbUtils.makeJsonTextFile(root_path + uploadPath, "background",usbUtils.makeJsonString(bgImgService.jsonList()));

		return "redirect:/myinfoboard/usb";
	}

	public JsonStaffDTO getJsonStaff(String section_cd) {
		int mapIndex = 0;
		JsonStaffDTO jsonStaffDTO = null;
		try {
			jsonStaffDTO = jsonStaffService.read(section_cd);
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
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStaffDTO;
	}

	public Map<String, List<Com_sectionVO>> getJsonTeams() {

		Map<String, List<Com_sectionVO>> sectionList = null;
		try {
			sectionList = new HashMap<String, List<Com_sectionVO>>();
			for (Com_bureauVO vo : bureauService.listAll()) {
				sectionList.put(vo.getBureau_name(), sectionService.listAll());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sectionList;
	}

}