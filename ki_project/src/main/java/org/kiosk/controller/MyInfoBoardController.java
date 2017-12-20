package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.UserVO;
import org.kiosk.dto.LoginDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	@Resource(name = "LoginDTO")
	private LoginDTO loginDTO;
	

	@RequestMapping(value = "/passwd", method = RequestMethod.GET)
	public void passwdGET(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());
		logger.info("myinfoboard/passwd - GET");
	}

	@RequestMapping(value = "/passwd", method = RequestMethod.POST)
	public String passwdPOST(RedirectAttributes rttr, @RequestParam("id") String id,
			@RequestParam("cur_pass") String cur_pass, @RequestParam("newPass") String newPass) throws Exception {
		logger.info("myinfoboard/passwd - POST");

		loginDTO.setId(id);
		loginDTO.setPassword(cur_pass);
		loginDTO.setPassword(newPass);
		UserVO vo = userService.login(loginDTO);
		if (vo == null) {
			System.out.println("FALSE 현재 비밀번 오류");
			rttr.addFlashAttribute("msg", "FALSE 현재 비밀번 오류");
			return "redirect:/myinfoboard/passwd";
		}
		System.out.println("Sucess");
		userService.changePassword(loginDTO);
		rttr.addFlashAttribute("msg", "SUCCESS 새로운 password로 로그인 해주시기 바랍니다.");

		logger.info(rttr.toString());

		return "redirect:/logout";
	}
	
	@RequestMapping(value = "/bureau", method = RequestMethod.GET)
	public void bureauGET(Model model, @ModelAttribute("bcd") String bcd, HttpServletRequest request)
			throws Exception {

		logger.info("myinfoboard/bureau - GET ");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());
		
		model.addAttribute("bureauService", bureauService.listAll());

	}

	@RequestMapping(value = "/bureau", method = RequestMethod.POST)
	public String bureauPOST(RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/bureau - POST ");
		logger.info(rttr.toString());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/myinfoboard/section";
	}

	@RequestMapping(value = "/section", method = RequestMethod.GET)
	public void sectionGET(Model model, @ModelAttribute("bcd") String bcd, HttpServletRequest request)
			throws Exception {

		logger.info("myinfoboard/section - GET ");
		model.addAttribute("bureauService", bureauService.listAll());
		model.addAttribute("bcd", sectionService.bureauList(bcd));

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());

	}

	@RequestMapping(value = "/section", method = RequestMethod.POST)
	public String sectionPOST(RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/section - POST ");
		logger.info(rttr.toString());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/myinfoboard/section";
	}

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public void teamGET(Model model, HttpServletRequest request, String section_cd) throws Exception {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("login", userVO);
		logger.info("Login : " + userVO.toString());
		logger.info("myinfoboard/team - GET ");

		model.addAttribute("list", sectionService.listAll());
		model.addAttribute("teamList",teamService.list(section_cd != null ? section_cd : userVO.getSection_fullcode()));

	}

	@RequestMapping(value = "/team", method = RequestMethod.POST)
	public String teamPOST(RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/team - POST ");
		logger.info(rttr.toString());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/myinfoboard/team";
	}

}