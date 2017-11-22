package org.kiosk.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.Criteria;
import org.kiosk.domain.UserVO;
import org.kiosk.dto.LoginDTO;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

	@Inject
	private Com_sectionService sectionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginGET(@ModelAttribute("dto") LoginDTO dto, Model model) throws Exception {
		model.addAttribute("service", sectionService.listAll());
		System.out.println("UserController logins GET");

		return "login";
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model, Criteria cri) throws Exception {

		System.out.println("UserController loginPost POST");
		System.out.println("user check : " + dto.toString());
		UserVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("userVO", vo);
		model.addAttribute("cri", cri);

		if (dto.isUseCookie()) {

			System.out.println("isUseCookie");
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			service.keepLogin(vo.getId(), session.getId(), sessionLimit);
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		System.out.println("UserController logout GET");
		Object obj = session.getAttribute("login");

		if (obj != null) {
			UserVO vo = (UserVO) obj;

			session.removeAttribute("login");
			session.invalidate();

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				loginCookie.setPath("/");// 내가 원하는 결로 지정
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getId(), session.getId(), new Date());

			}
		}
		return "/logout";
	}

}
