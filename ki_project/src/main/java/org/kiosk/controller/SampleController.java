package org.kiosk.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.kiosk.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RestController
@RequestMapping("/sample/*")
public class SampleController {

	@Resource(name = "DownloadView")
	private View downloadView;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView sample() {
		ModelAndView mav = new ModelAndView();
		mav.setView(this.downloadView);

		File downloadFile = new File("D:\\dongguk.jpg");
		mav.addObject("downloadFile", downloadFile);

		return mav;
	}

	@RequestMapping(value = "/downloadFile")
	public void downloadFile(HttpServletResponse response) throws Exception {

		String storedFileName = "dongguk.jpg";// "STORED_FILE_NAME";
		String originalFileName = "dongguk.jpg";// "ORIGINAL_FILE_NAME";

		byte fileByte[] = FileUtils.readFileToByteArray(new File("D:\\\\" + storedFileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World ";
	}

	@RequestMapping("/sendVO")
	public SampleVO sendVO() {

		SampleVO vo = new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(123);

		return vo;
	}

	@RequestMapping("/sendList")
	public List<SampleVO> sendList() {

		List<SampleVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}

	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap() {

		Map<Integer, SampleVO> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			map.put(i, vo);
		}
		return map;
	}

	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot() {

		List<SampleVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			list.add(vo);
		}

		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}

}
