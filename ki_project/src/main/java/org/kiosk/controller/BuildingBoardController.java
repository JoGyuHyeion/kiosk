package org.kiosk.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.domain.UserVO;
import org.kiosk.service.Com_buildingService;
import org.kiosk.util.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/buildingboard/*")
public class BuildingBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BuildingBoardController.class);

	@Inject
	private Com_buildingService service;

	@Resource(name = "UploadFileUtils")
	private UploadFileUtils uploadFileUtils;

	private String img_fileName = "building_";
	private String[] dirPath = { "resources","upload","building" };
	// 필요에 따라 arraylist로 원하는 항목을 add 하여 array 변환하면 유동적인 path를 생성할수있다.
	
	private String uploadPath() {
		String uploadPath = File.separator;
		for (String path : dirPath) {
			uploadPath = uploadPath + path + File.separator;
		}
		return uploadPath;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri,Model model, HttpServletRequest request) throws Exception {
		logger.info("buildingboard/list - GET");

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));
		model.addAttribute("uploadPath", uploadPath());

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bu_no") int bu_no, Model model, HttpServletRequest request) throws Exception {
		logger.info("buildingboard/readPage - GET");
		model.addAttribute(service.read(bu_no));
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(Model model, HttpServletRequest request) throws Exception {
		logger.info("buildingboard/register - GET");
		logger.info("regist get ...........");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_buildingVO board, RedirectAttributes rttr,
			@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request) throws Exception {
		logger.info("buildingboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());

		String root_path = request.getSession().getServletContext().getRealPath("/");

		String img_filenm = uploadFileUtils.uploadImageFile(root_path, imgFile.getOriginalFilename(),
				imgFile.getBytes(), img_fileName + (service.lastInsertID()), dirPath);
		board.setBu_img(img_filenm);

		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buildingboard/list?page=1";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_buildingVO board, RedirectAttributes rttr,
			@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request,
			@RequestParam("imgName") String imgName) throws Exception {
		logger.info("buildingboard/modifyPage - POST");
		String img_filenm;
		String root_path = request.getSession().getServletContext().getRealPath("/");

		if (imgName.equals(board.getBu_img())) {
			img_filenm = imgName;
		} else {
			uploadFileUtils.deleteFile(root_path + uploadPath(), service.read(board.getBu_no()).getBu_img());

			img_filenm = uploadFileUtils.uploadImageFile(root_path, imgFile.getOriginalFilename(),
					imgFile.getBytes(), img_fileName + board.getBu_no(), dirPath);
		}
		board.setBu_img(img_filenm);

		service.modify(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/buildingboard/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bu_no") int bu_no, RedirectAttributes rttr, HttpServletRequest request)
			throws Exception {
		logger.info("buildingboard/removePage - POST");

		String root_path = request.getSession().getServletContext().getRealPath("/");

		uploadFileUtils.deleteFile(root_path + uploadPath(), service.read(bu_no).getBu_img());
		service.remove(bu_no);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buildingboard/list?page=1";
	}
}
