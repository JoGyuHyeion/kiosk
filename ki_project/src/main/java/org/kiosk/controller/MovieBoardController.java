package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kiosk.domain.Com_videoVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.domain.UserVO;
import org.kiosk.service.Com_videoService;
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
@RequestMapping("/movieboard/*")
public class MovieBoardController {

	private static final Logger logger = LoggerFactory.getLogger(MovieBoardController.class);

	@Inject
	private Com_videoService service;
	
	@Resource(name = "PageMaker")
	private PageMaker pageMaker;

	@Resource(name = "UploadFileUtils")
	private UploadFileUtils uploadFileUtils;

	@Resource(name = "uploadPath")
	private String uploadPath;

	private String video_fileName = "movie_";
	private String[] dirPath = { "movie" };
	// 필요에 따라 arraylist로 원하는 항목을 add 하여 array 변환하면 유동적인 path를 생성할수있다.

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {

		logger.info("movieboard/list - GET");
		logger.info(cri.toString());

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());

		cri.setPerPageNum(6);
		model.addAttribute("list", service.listSearchCriteria(cri));

		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("vi_no") int vi_no, @ModelAttribute("cri") SearchCriteria cri, Model model,
			HttpServletRequest request) throws Exception {
		logger.info("movieboard/readPage - GET");
		model.addAttribute(service.read(vi_no));
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request)
			throws Exception {
		logger.info("movieboard/register - GET");
		logger.info("regist get ...........");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_videoVO board, RedirectAttributes rttr,
			@RequestParam("videoFile") MultipartFile videoFile, HttpServletRequest request) throws Exception {
		logger.info("movieboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());

		String root_path = request.getSession().getServletContext().getRealPath("/");

		String video_filenm = uploadFileUtils.uploadImageFile(root_path + uploadPath, videoFile.getOriginalFilename(),
				videoFile.getBytes(), video_fileName + (service.lastInsertID()), dirPath);
		board.setVi_video(video_filenm);

		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/movieboard/list";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int vi_no, @ModelAttribute("cri") SearchCriteria cri, Model model,
			HttpServletRequest request) throws Exception {
		logger.info("movieboard/modifyPage - GET");
		model.addAttribute(service.read(vi_no));
		logger.info(service.read(vi_no).toString());
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		logger.info("Login : " + userVO.toString());
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_videoVO board, SearchCriteria cri, RedirectAttributes rttr,
			@RequestParam("videoFile") MultipartFile videoFile, HttpServletRequest request,
			@RequestParam("videoName") String videoName) throws Exception {
		logger.info("movieboard/modifyPage - POST");
		logger.info(cri.toString());
		String video_filenm;
		String root_path = request.getSession().getServletContext().getRealPath("/");

		System.out.println("경로 : " + root_path + uploadPath);
		if (videoName.equals(board.getVi_video())) {
			video_filenm = videoName;
		} else {
			uploadFileUtils.deleteFile(root_path + uploadPath, service.read(board.getVi_no()).getVi_video());

			video_filenm = uploadFileUtils.uploadImageFile(root_path + uploadPath, videoFile.getOriginalFilename(),
					videoFile.getBytes(), video_fileName + board.getVi_no(), dirPath);
		}
		board.setVi_video(video_filenm);

		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/movieboard/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("vi_no") int vi_no, SearchCriteria cri, RedirectAttributes rttr,
			HttpServletRequest request) throws Exception {
		logger.info("movieboard/removePage - POST");

		String root_path = request.getSession().getServletContext().getRealPath("/");

		uploadFileUtils.deleteFile(root_path + uploadPath, service.read(vi_no).getVi_video());
		service.remove(vi_no);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/movieboard/list?page=1";
	}

}