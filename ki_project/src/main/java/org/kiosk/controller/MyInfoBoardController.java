package org.kiosk.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.domain.UserVO;
import org.kiosk.service.Com_bureauService;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.Com_teamService;
import org.kiosk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/myinfoboard/team";
	}

}