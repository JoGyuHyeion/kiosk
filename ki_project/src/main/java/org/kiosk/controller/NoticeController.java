package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kiosk.domain.Com_boardVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.domain.UserVO;
import org.kiosk.service.Com_boardService;
import org.kiosk.util.UploadFileUtils;
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
@RequestMapping("/noticeboard/*")
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Inject
	private Com_boardService service;
	
	@Resource(name = "PageMaker")
	private PageMaker pageMaker;

	@Resource(name = "UploadFileUtils")
	private UploadFileUtils uploadFileUtils;

	@Resource(name = "uploadPath")
	private String uploadPath;

	private String img_fileName = "notice_";
	private String[] dirPath = { "notice" };

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {

		logger.info("noticeboard/list - GET");
		logger.info("test-" + cri.toString());

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());

		model.addAttribute("list", service.listSearchCriteria(cri));

		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bbs_no") int bbs_no, @ModelAttribute("cri") SearchCriteria cri, Model model,
			HttpServletRequest request) throws Exception {
		logger.info("noticeboard/readPage - GET");
		model.addAttribute(service.read(bbs_no));
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {
		logger.info("noticeboard/register - GET");
		logger.info("regist get ...........");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_boardVO board, RedirectAttributes rttr, @RequestParam("imgFile") MultipartFile imgFile,
			HttpServletRequest request) throws Exception {
		logger.info("noticeboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());

		String root_path = request.getSession().getServletContext().getRealPath("/");

		String bbs_file = uploadFileUtils.uploadImageFile(root_path + uploadPath, imgFile.getOriginalFilename(),
				imgFile.getBytes(), img_fileName + (service.lastInsertID()), dirPath);
		board.setBbs_file(bbs_file);

		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/noticeboard/list?page=1";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int bbs_no, @ModelAttribute("cri") SearchCriteria cri, Model model,
			HttpServletRequest request) throws Exception {
		logger.info("noticeboard/modifyPage - GET");
		model.addAttribute(service.read(bbs_no));
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_boardVO board, SearchCriteria cri, RedirectAttributes rttr,
			@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request,
			@RequestParam("imgName") String imgName) throws Exception {
		logger.info("noticeboard/modifyPage - POST");
		logger.info(cri.toString());
		String img_filenm;
		String root_path = request.getSession().getServletContext().getRealPath("/");

		System.out.println("경로 : " + root_path + uploadPath);
		if (imgName.equals(board.getBbs_file())) {
			img_filenm = imgName;
		} else {
			uploadFileUtils.deleteFile(root_path + uploadPath, service.read(board.getBbs_no()).getBbs_file());

			img_filenm = uploadFileUtils.uploadImageFile(root_path + uploadPath, imgFile.getOriginalFilename(),
					imgFile.getBytes(), img_fileName + board.getBbs_no(), dirPath);
		}
		board.setBbs_file(img_filenm);

		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/noticeboard/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bbs_no") int bbs_no, SearchCriteria cri, RedirectAttributes rttr,
			HttpServletRequest request) throws Exception {
		logger.info("noticeboard/removePage - POST");

		String root_path = request.getSession().getServletContext().getRealPath("/");

		System.out.println("경로 : " + root_path + uploadPath);
		uploadFileUtils.deleteFile(root_path + uploadPath, service.read(bbs_no).getBbs_file());
		service.remove(bbs_no);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/noticeboard/list?page=1";
	}

}