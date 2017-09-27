package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.JsonGelleryVO;
import org.zerock.domain.JsonNoticeVO;
import org.zerock.domain.JsonStaffVO;
import org.zerock.domain.MateVO;
import org.zerock.domain.SampleVO;
import org.zerock.domain.TeamsVO;

@RestController
@RequestMapping("/json")
public class JsonController {

	@RequestMapping("/sendStaff")
	public JsonStaffVO sendStaff() {
		JsonStaffVO vo = new JsonStaffVO();
		vo.setSection_name("K010-S010");
		vo.setSection_password("12345");

		List<TeamsVO> teams = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			TeamsVO teamsVO = new TeamsVO();
			teamsVO.setTeam_name("임원");

			Map<Integer, MateVO> mate = new HashMap<>();

			for (int j = 0; j < 4; j++) {
				MateVO mateVO = new MateVO();
				mateVO.setNo(j);
				mateVO.setName("명준");
				mateVO.setPosition("풀스텍");
				mateVO.setJob("웹 개발자");
				mateVO.setTel("010-5555-6666");
				mateVO.setEmail("kj@naver.com");
				mateVO.setImg_filenm("staff_00882.jpg");
				mateVO.setSort(4);
				mateVO.setStatus(2);
				mate.put(j, mateVO);
				
			}
			teamsVO.setMate(mate);
			teams.add(teamsVO);
			
		}
		vo.setTeams(teams);;

		return vo;
	}

	@RequestMapping("/sendGallery")
	public List<JsonGelleryVO> sendGallery() {

		List<JsonGelleryVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JsonGelleryVO vo = new JsonGelleryVO();
			vo.setNo(i + 1);
			vo.setTitle("abc");
			vo.setCaption("캡션");
			vo.setFilenm("/_files/gallery/none/2017/09/20170911-59b6c8ae25dad368727049.png");
			list.add(vo);
		}
		return list;
	}

	@RequestMapping("/sendNotice")
	public List<JsonNoticeVO> sendNotice() {

		List<JsonNoticeVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JsonNoticeVO vo = new JsonNoticeVO();
			vo.setBbs_no(i);
			vo.setBbs_title("남명준씨");
			vo.setBbs_content("바쁘시네 그참 데이터도 없구만");
			vo.setBbs_file("/_files/board/");
			list.add(vo);
		}
		return list;
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
