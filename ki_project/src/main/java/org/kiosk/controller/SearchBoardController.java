package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/controller/SearchBoardController.java

=======
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/controller/SearchBoardController.java
import org.kiosk.domain.Com_staffVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.service.Com_staffService;
<<<<<<< HEAD:ki_project/src/main/java/org/kiosk/controller/SearchBoardController.java
=======
import org.kiosk.util.UploadFileUtils;
>>>>>>> 8990e218fa1fb8e7e3d91484a8974a0d83798bc1:ki_project/src/main/java/org/kiosk/controller/SearchBoardController.java
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
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);

	@Inject
	private Com_staffService service;

	@Resource(name = "uploadPath")
	private String uploadPath;

	private String img_fileName = "staff_";
	private String[] dirPath = { "staff" };
	//필요에 따라  arraylist로 원하는 항목을  add 하여 array 변환하면 유동적인 path를 생성할수있다.

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		// model.addAttribute("page", page);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("st_no") int st_no, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		model.addAttribute(service.read(st_no));
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("st_no") int st_no, SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.remove(st_no);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/sboard/list";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int st_no, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		model.addAttribute(service.read(st_no));
		
		System.out.println("규현쓰 테스트");
		logger.info(service.read(st_no).toString());
		System.out.println("현아쓰 내껏임 노건들!!");
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_staffVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info(cri.toString());
		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/sboard/list";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") SearchCriteria cri) throws Exception {

		logger.info("regist get ...........");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_staffVO board, RedirectAttributes rttr, @RequestParam("imgFile") MultipartFile imgFile)
			throws Exception {

		logger.info("regist post ...........");
		logger.info(board.toString());

		String img_filenm = UploadFileUtils.uploadImageFile(uploadPath, imgFile.getOriginalFilename(),
				imgFile.getBytes(), img_fileName + (service.maxNum() + 1), dirPath);
		board.setImg_filenm(img_filenm);
		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/sboard/list";
	}

}
