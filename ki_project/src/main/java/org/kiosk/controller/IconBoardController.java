package org.kiosk.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.UserVO;
import org.kiosk.service.Com_iconService;
import org.kiosk.util.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/iconboard/*")
public class IconBoardController {

	private static final Logger logger = LoggerFactory.getLogger(IconBoardController.class);

	@Inject
	private Com_iconService service;

	@Resource(name = "PageMaker")
	private PageMaker pageMaker;

	@Resource(name = "UploadFileUtils")
	private UploadFileUtils uploadFileUtils;

	private String img_fileName = "icon_";
	private String[] dirPath = { "resources", "upload", "icon" };
	// 필요에 따라 arraylist로 원하는 항목을 add 하여 array 변환하면 유동적인 path를 생성할수있다.

	private String uploadPath() {
		String uploadPath = File.separator;
		for (String path : dirPath) {
			uploadPath = uploadPath + path + File.separator;
		}
		return uploadPath;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(Model model, HttpServletRequest request) throws Exception {

		logger.info("iconboard/list - GET");

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());

		model.addAttribute("list", service.listAll());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("uploadPath", uploadPath());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(Model model, HttpServletRequest request) throws Exception {
		logger.info("iconboard/register - GET");
		logger.info("regist get ...........");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_iconVO board, RedirectAttributes rttr,
			@RequestParam("iconFile") MultipartFile iconFile, HttpServletRequest request) throws Exception {

		logger.info("iconboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());

		String root_path = request.getSession().getServletContext().getRealPath("/");

		String icon_filenm = uploadFileUtils.uploadFile(root_path, iconFile.getOriginalFilename(),
				iconFile.getBytes(), img_fileName + (service.lastInsertID()), dirPath);
		board.setIc_icon(icon_filenm);
		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/iconboard/list";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_iconVO board, RedirectAttributes rttr,
			@RequestParam("iconFile") MultipartFile iconFile, HttpServletRequest request,
			@RequestParam("iconName") String iconName) throws Exception {
		logger.info("iconboard/modifyPage - POST");
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String icon_filenm = null;
		String default_img_filenm = "icon" + board.getIc_no() + ".png";

		if (board.getIc_default() == 0 && !(iconFile.getOriginalFilename().equals(""))) {// custom 이고 받아오는 파일 값이 있을때
			uploadFileUtils.deleteFile(root_path + uploadPath(), service.read(board.getIc_no()).getIc_icon());
			icon_filenm = uploadFileUtils.uploadFile(root_path, iconFile.getOriginalFilename(),
					iconFile.getBytes(), img_fileName + board.getIc_no(), dirPath);

		} else if (board.getIc_default() == 0 && iconFile.getOriginalFilename().equals("")) {// custom 이고 받아오는 파일 값이 없을때
			icon_filenm = iconName;
		} else if (board.getIc_default() == 1) { // default 일때
			icon_filenm = default_img_filenm;
		}

		board.setIc_icon(icon_filenm);
		service.modify(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/iconboard/list";
	}

}