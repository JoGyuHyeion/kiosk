package org.kiosk.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.kiosk.domain.Com_buildingVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.service.Com_buildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/buildingboard/*")
public class BuildingBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BuildingBoardController.class);

	@Inject
	private Com_buildingService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info("buildingboard/list - GET");
		logger.info(cri.toString());
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bu_no") int bu_no, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		logger.info("buildingboard/readPage - GET");
		model.addAttribute(service.read(bu_no));
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("galleryboard/register - GET");
		logger.info("regist get ...........");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_buildingVO board, RedirectAttributes rttr, HttpServletRequest request)
			throws Exception {
		logger.info("noticeboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());
		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buildingboard/list?page=1";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int bu_no, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info("buildingboard/modifyPage - GET");
		model.addAttribute(service.read(bu_no));
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_buildingVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("buildingboard/modifyPage - POST");
		logger.info(cri.toString());
		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/buildingboard/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bu_no") int bbs_no, SearchCriteria cri, RedirectAttributes rttr,
			HttpServletRequest request) throws Exception {
		logger.info("buildingboard/removePage - POST");

		// String root_path = request.getSession().getServletContext().getRealPath("/");

		// System.out.println("경로 : " + root_path + uploadPath);
		// uploadFileUtils.deleteFile(root_path + uploadPath,
		// service.read(bbs_no).getBbs_file());
		// service.remove(bbs_no);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buildingboard/list?page=1";
	}
}
