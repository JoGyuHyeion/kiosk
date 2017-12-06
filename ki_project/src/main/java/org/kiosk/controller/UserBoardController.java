package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.UserVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.UserService;
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
@RequestMapping("/userboard/*")
public class UserBoardController {

	private static final Logger logger = LoggerFactory.getLogger(UserBoardController.class);

	@Inject
	private UserService service;
	@Inject
	private Com_sectionService sectionService;

	@Resource(name = "PageMaker")
	private PageMaker pageMaker;

	@Resource(name = "UserVO")
	private UserVO userVO;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {

		logger.info("userboard/list - GET");
		pageMaker.setCri(cri);
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);

		model.addAttribute("list", service.listSearchCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void newUserGET(Model model, HttpServletRequest request) throws Exception {

		logger.info("myinfoboard/passwd - GET");
		model.addAttribute("sectionList", sectionService.listAll());
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String newUserPOST(UserVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("/myinfoboard/newUser - POST");
		logger.info("newUser post ...........");
		logger.info(vo.toString());

		service.newUser(vo);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/userboard/list";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(String modifyId, @ModelAttribute("cri") SearchCriteria cri, Model model,
			HttpServletRequest request) throws Exception {
		logger.info("userboard/modifyPage - GET");
		logger.info(service.read(modifyId).toString());
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		logger.info("Login : " + userVO.toString());

		model.addAttribute("sectionList", sectionService.listAll());
		model.addAttribute(service.read(modifyId));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(UserVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("userboard/modifyPage - POST");
		logger.info(cri.toString());
System.out.println(board.toString());
		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/userboard/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("id") String id, SearchCriteria cri, RedirectAttributes rttr,
			HttpServletRequest request) throws Exception {
		logger.info("userboard/removePage - POST");

		service.remove(id);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/userboard/list?page=1";
	}

}