package org.zerock.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;
import org.zerock.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto,int id_num) {
		System.out.println("UserController logins GET");
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model, Criteria cri, int id_num) throws Exception {

		System.out.println("UserController loginPost POST");
		UserVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("userVO", vo);
		model.addAttribute("cri", cri);
		model.addAttribute("id_num", id_num);

		if (dto.isUseCookie()) {

			int amount = 60 * 60 * 24 * 7;

			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

			service.keepLogin(vo.getId(), session.getId(), sessionLimit);
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception {
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
		return "user/logout";
	}
}
