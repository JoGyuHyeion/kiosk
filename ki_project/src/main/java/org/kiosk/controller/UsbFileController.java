package org.kiosk.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.Com_bureauVO;
import org.kiosk.domain.Com_sectionVO;
import org.kiosk.domain.Com_teamVO;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.domain.UserVO;
import org.kiosk.dto.JsonStaffDTO;
import org.kiosk.dto.MateDTO;
import org.kiosk.dto.TeamsDTO;
import org.kiosk.service.Com_bgImgService;
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
import org.kiosk.service.Vol_checkService;
import org.kiosk.util.UsbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usbFileboard/*")
public class UsbFileController {

	private static final Logger logger = LoggerFactory.getLogger(UsbFileController.class);

	@Inject
	private Com_sectionService sectionService;

	@Inject
	private Com_bureauService bureauService;

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
	private Com_iconService iconService;
	@Inject
	private Com_teamService teamService;
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

	@Resource(name = "DownloadView")
	private View downloadView;

	@RequestMapping(value = "/usb", method = RequestMethod.GET)
	public void usbGET(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request) {
		logger.info("usbFileboard/usb - GET ");

		try {
			model.addAttribute("sectionService", sectionService.listAll());
		} catch (Exception e) {
			e.getMessage();
		}
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/usb", method = RequestMethod.POST)
	public String usbPOST(RedirectAttributes rttr, @ModelAttribute("section_fullcode") String section_fullcode,
			HttpServletRequest request) throws Exception {
		String root_path = request.getSession().getServletContext().getRealPath("/");

		logger.info("/usbFileboard/usb - POST");
		logger.info("newUser post ...........");
		System.out.println(section_fullcode);
		

		String path = root_path + uploadPath;
		String toPath = path.substring(0, path.lastIndexOf("\\") + 1);
		String fileName = path.substring(path.lastIndexOf("\\") + 1);

		System.out.println("path : " + path);
		System.out.println("toPath : " + toPath);
		System.out.println("fileName : " + fileName);

		makeJsonTextFile(path,section_fullcode);

		usbUtils.createZipFile(path, toPath, fileName);
		rttr.addFlashAttribute("msg", "SUCCESS");
		rttr.addAttribute("zipFile", toPath + fileName + ".zip");
		return "redirect:/usbFileboard/download";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView sample(HttpServletRequest request, @RequestParam("zipFile") String zipFile) {
		ModelAndView mav = new ModelAndView();
		mav.setView(this.downloadView);
		File downloadFile = new File(zipFile);
		mav.addObject("downloadFile", downloadFile);

		return mav;
	}
	
	private void makeJsonTextFile(String path, String section_fullcode) throws Exception {
		
		if(section_fullcode.equals("none")) {
			List<JsonStaffDTO> jsonStaffList = new ArrayList<JsonStaffDTO>();
			for(Com_teamVO vo :teamService.listAll()) {
				JsonStaffDTO staffDTO = getJsonStaff(vo.getSection_cd());
				jsonStaffList.add(staffDTO);
			}
			
			usbUtils.makeJsonTextFile(path, "staff", usbUtils.makeJsonString(getJsonStaff(section_fullcode)));
			usbUtils.makeJsonTextFile(path, "gallery",usbUtils.makeJsonString(jsonGelleryService.listAll()));
			usbUtils.makeJsonTextFile(path, "notice", usbUtils.makeJsonString(jsonNoticeService.listAll()));
		}else {
			usbUtils.makeJsonTextFile(path, "staff", usbUtils.makeJsonString(getJsonStaff(section_fullcode)));
			usbUtils.makeJsonTextFile(path, "gallery",usbUtils.makeJsonString(jsonGelleryService.list(section_fullcode)));
			usbUtils.makeJsonTextFile(path, "notice", usbUtils.makeJsonString(jsonNoticeService.list(section_fullcode)));
		}
		usbUtils.makeJsonTextFile(path, "vol_check", usbUtils.makeJsonString(vol_checkService.read(1)));
		usbUtils.makeJsonTextFile(path, "building", usbUtils.makeJsonString(vol_checkService.read(1)));
		usbUtils.makeJsonTextFile(path, "teams", usbUtils.makeJsonString(getJsonTeams()));
		usbUtils.makeJsonTextFile(path, "icon", usbUtils.makeJsonString(iconService.listAll()));
		usbUtils.makeJsonTextFile(path, "video", usbUtils.makeJsonString(videoService.listAll()));
		usbUtils.makeJsonTextFile(path, "background", usbUtils.makeJsonString(bgImgService.jsonList()));
	}

	private JsonStaffDTO getJsonStaff(String section_cd) {
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

	private Map<String, List<Com_sectionVO>> getJsonTeams() {

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