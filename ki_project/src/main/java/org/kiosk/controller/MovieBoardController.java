package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.kiosk.domain.Com_imageVO;
import org.kiosk.domain.Com_staffVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.dto.Com_videoDTO;
import org.kiosk.service.Com_imageService;
import org.kiosk.service.Com_staffService;
import org.kiosk.service.Com_videoService;
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
@RequestMapping("/movieboard/*")
public class MovieBoardController {

	private static final Logger logger = LoggerFactory.getLogger(MovieBoardController.class);

	@Inject
	private Com_videoService service;

	@Resource(name = "uploadPath")
	private String uploadPath;

	private String img_fileName = "movie_";
	private String[] dirPath = { "movie" };
	//필요에 따라  arraylist로 원하는 항목을  add 하여 array 변환하면 유동적인 path를 생성할수있다.
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info("galleryboard/list - GET");
		logger.info(cri.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("galleryboard/register - GET");
		logger.info("regist get ...........");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_videoDTO board, RedirectAttributes rttr, @RequestParam("videoFile") MultipartFile videoFile)
			throws Exception {
		logger.info("galleryboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());

		String video_filenm = UploadFileUtils.uploadImageFile(uploadPath, videoFile.getOriginalFilename(),
				videoFile.getBytes(), img_fileName + (service.lastInsertID()), dirPath);
		board.setVi_video(video_filenm);
		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/galleryboard/list";
	}

	

}