package org.kiosk.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.kiosk.service.Com_sectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value ="/home/*")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private Com_sectionService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("service", service.listAll());

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public String doA(Locale locale, Model model) {

		System.out.println("doA.........................");
		return "home";

	}

	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB(Locale locale, Model model) {

		System.out.println("doB.........................");
		model.addAttribute("result", "DOB RESULT");
		return "home";

	}
	

	final private String[] dirPath = { "resources", "upload", "staff2" };

	final private String uploadPath() {
		String uploadPath = File.separator;
		for (String path : dirPath) {
			uploadPath = uploadPath + path + File.separator;
		}
		return uploadPath;
	}
	
	@RequestMapping(value = "/path", method = RequestMethod.GET)
	public String getPath(Locale locale, Model model, HttpServletRequest request) {

		System.out.println("getPath.........................");
		String root_path = request.getSession().getServletContext().getRealPath("/");
		model.addAttribute("rootpath", root_path);
		model.addAttribute("subpath", uploadPath());
		model.addAttribute("totalPath", root_path+uploadPath());
		return "path";

	}

}
