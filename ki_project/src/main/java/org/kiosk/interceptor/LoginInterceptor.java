package org.kiosk.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.kiosk.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("loginInterceptor post handle........................");
		HttpSession session = request.getSession();

		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		UserVO filterCode = (UserVO) userVO;

		if (userVO != null) {
			logger.info("login filterCode success");
			Cookie filterCookie = new Cookie("filterCode", filterCode.getSection_fullcode());
			response.addCookie(filterCookie);

			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);

			if (request.getParameter("useCookie") != null) {

				logger.info("remember me................");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(loginCookie);
			}
			Object dest = session.getAttribute("dest");

			response.sendRedirect(dest != null ? (String) dest : "/staff2board/list");
			System.out.println("loginInterceptor post handle........................dest:" + dest);

		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("loginInterceptor pre handle........................");
		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);

			Cookie filterCookie = new Cookie("filterCode", null);
			filterCookie.setMaxAge(0);
			response.addCookie(filterCookie);

		}
		return true;
	}
}
