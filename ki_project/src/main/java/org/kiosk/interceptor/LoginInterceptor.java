package org.kiosk.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kiosk.domain.Criteria;
import org.kiosk.domain.SearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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
		//ë¡œê·¸?¸?›„ ?ŒŒë¡? readPageë¡? ê°?ê¸°ìœ„?•´ UserController?—?„œ ?•„?š”?•œ ? •ë³´ë?? ë°›ì•„?˜¨?‹¤
		Criteria cri = (Criteria) modelMap.get("cri");
		Object id_num = modelMap.get("id_num");

		if (userVO != null) {

			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);

			if (request.getParameter("useCookie") != null) {

				logger.info("remember me................");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7);//60ì´?60ë¶?24?‹œê°?7ì£¼ì¼ê°? ë³´ê?ì´? 7ì£¼ì¼
				response.addCookie(loginCookie);//ì¿ í‚¤?Š” ë°˜ë“œ?‹œ HttpServletResponse?— ?‹´ê²¨ì„œ ? „?†¡?•œ?‹¤.
			} // response.sendRedirect("/");
			Object dest = session.getAttribute("dest");

//			response.sendRedirect(dest != null ? (String) dest : "/sboard/readPage"+gotoReadPage(id_num, cri));	//ë¡œê·¸?¸ ?˜ë©? listë¡? ?™”ë©´ì´ ë°”ë?ë‹¤.
			response.sendRedirect(dest != null ? (String) dest : "/");	//ë¡œê·¸?¸ ?˜ë©? listë¡? ?™”ë©´ì´ ë°”ë?ë‹¤.
			 System.out.println("loginInterceptor post handle........................dest:"+dest);
	
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
		}

		return true;
	}
	private String gotoReadPage(Object id_num,Criteria cri){
		String path="?id_num="+id_num+"&page="+cri.getPage()+"&perPageNum="+cri.getPerPageNum();
		return path;
	}
}
