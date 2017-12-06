package org.kiosk.controller;

import java.io.File;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.UserVO;
import org.kiosk.service.Com_bgImgService;
import org.kiosk.service.Com_iconService;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.Com_videoService;
import org.kiosk.service.JsonGelleryService;
import org.kiosk.service.JsonNoticeService;
import org.kiosk.service.JsonStaffService;
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
	private JsonGelleryService jsonGelleryService;
	@Inject
	private JsonNoticeService jsonNoticeService;
	@Inject
	private JsonStaffService jsonStaffService;
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

	@Resource(name = "DownloadView")
	private View downloadView;
	
	private String[] dirPath = { "resources","upload" };
	// 필요에 따라 arraylist로 원하는 항목을 add 하여 array 변환하면 유동적인 path를 생성할수있다.
	
	private String uploadPath() {
		String uploadPath = File.separator;
		for (String path : dirPath) {
			uploadPath = uploadPath + path + File.separator;
		}
		return uploadPath;
	}

	@RequestMapping(value = "/usb", method = RequestMethod.GET)
	public void usbGET(Model model, HttpServletRequest request) {
		logger.info("usbFileboard/usb - GET ");

		try {
			model.addAttribute("sectionService", sectionService.listAll());
		} catch (Exception e) {
			e.getMessage();
		}
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/usb", method = RequestMethod.POST)
	public String usbPOST(RedirectAttributes rttr, @ModelAttribute("section_fullcode") String section_fullcode,
			HttpServletRequest request) throws Exception {
		String root_path = request.getSession().getServletContext().getRealPath("/");

		logger.info("/usbFileboard/usb - POST");
		logger.info("newUser post ...........");
		System.out.println(section_fullcode);

		String path = root_path + uploadPath().substring(0, uploadPath().length()-1);
		String paths=path.replace("\\\\", "\\");
		String toPath = path.substring(0, path.lastIndexOf("\\") + 1);
		String fileName = dirPath[dirPath.length-1];
		//path.replace("\\\\", "\\");
String ss="D:\\workspace-sts-3.9.0.RELEASE\\2017-2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ki_project\\resources\\upload";
//path="D:\\workspace-sts-3.9.0.RELEASE\\2017-2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ki_project\\resources\\upload";
		System.out.println("path : " + paths);
		System.out.println("toPath : " + toPath);
		System.out.println("fileName : " + fileName);

		makeJsonTextFile(path, section_fullcode);

		usbUtils.createZipFile(ss, toPath, fileName);
		rttr.addFlashAttribute("msg", "SUCCESS");
		rttr.addAttribute("zipFile", toPath + fileName + ".zip");
		return "redirect:/usbFileboard/download";
		
//		return null;
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

		if (section_fullcode.equals("none")) {

			 usbUtils.makeJsonTextFile(path, "staff",usbUtils.makeJsonString(jsonStaffService.getJsonStaff("none")));

			usbUtils.makeJsonTextFile(path, "gallery", usbUtils.makeJsonString(jsonGelleryService.listAll()));
			usbUtils.makeJsonTextFile(path, "notice", usbUtils.makeJsonString(jsonNoticeService.listAll()));
		} else {
			usbUtils.makeJsonTextFile(path, "staff", usbUtils.makeJsonString(jsonStaffService.getJsonStaff(section_fullcode)));
			usbUtils.makeJsonTextFile(path, "gallery",
					usbUtils.makeJsonString(jsonGelleryService.list(section_fullcode)));
			usbUtils.makeJsonTextFile(path, "notice",
					usbUtils.makeJsonString(jsonNoticeService.list(section_fullcode)));
		}
		usbUtils.makeJsonTextFile(path, "vol_check", usbUtils.makeJsonString(vol_checkService.read(1)));
		usbUtils.makeJsonTextFile(path, "building", usbUtils.makeJsonString(vol_checkService.read(1)));
		usbUtils.makeJsonTextFile(path, "teams", usbUtils.makeJsonString(sectionService.getJsonSection()));
		usbUtils.makeJsonTextFile(path, "icon", usbUtils.makeJsonString(iconService.listAll()));
		usbUtils.makeJsonTextFile(path, "video", usbUtils.makeJsonString(videoService.listAll()));
		usbUtils.makeJsonTextFile(path, "background", usbUtils.makeJsonString(bgImgService.jsonList()));
	}


}