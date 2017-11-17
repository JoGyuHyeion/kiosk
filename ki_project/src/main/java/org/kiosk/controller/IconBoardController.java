package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.kiosk.domain.Com_iconVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.service.Com_iconService;
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
@RequestMapping("/iconboard/*")
public class IconBoardController {

	private static final Logger logger = LoggerFactory.getLogger(IconBoardController.class);

	@Inject
	private Com_iconService service;

	@Resource(name = "UploadFileUtils")
	private UploadFileUtils uploadFileUtils;

	@Resource(name = "uploadPath")
	private String uploadPath;

	private String img_fileName = "icon_";
	private String[] dirPath = { "icon" };
	// 필요에 따라 arraylist로 원하는 항목을 add 하여 array 변환하면 유동적인 path를 생성할수있다.

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info("iconboard/list - GET");
		logger.info(cri.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("iconboard/register - GET");
		logger.info("regist get ...........");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_iconVO board, RedirectAttributes rttr,
<<<<<<< HEAD
			@RequestParam("iconFile") MultipartFile iconFile, HttpServletRequest request) throws Exception {
=======
			@RequestParam("iconFile") MultipartFile iconFile) throws Exception {
>>>>>>> 4508eaf5fa25d7724301e69dffeb89ed910adb9b
		logger.info("iconboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());

		String root_path = request.getSession().getServletContext().getRealPath("/");

		String icon_filenm = uploadFileUtils.uploadImageFile(root_path + uploadPath, iconFile.getOriginalFilename(),
				iconFile.getBytes(), img_fileName + (service.lastInsertID()), dirPath);
		board.setIc_icon(icon_filenm);
		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/iconboard/list";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_iconVO board, SearchCriteria cri, RedirectAttributes rttr,
			MultipartFile iconFile) throws Exception {
		logger.info("iconboard/modifyPage - POST");
		logger.info("test1"+cri.toString());
		String icon_filenm;

		if (board.isIc_default() == 0) {
			icon_filenm = UploadFileUtils.uploadImageFile(uploadPath, iconFile.getOriginalFilename(),
					iconFile.getBytes(), img_fileName + (service.lastInsertID()), dirPath);
		} else {
			icon_filenm = "icon"+board.getIc_no()+".png";
		}
		logger.info("test" + icon_filenm + " " + board.isIc_default());

		board.setIc_icon(icon_filenm);
		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/iconboard/list";
	}

}