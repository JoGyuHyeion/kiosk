package org.kiosk.service;

import java.util.List;

import org.kiosk.dto.JsonNoticeDTO;

public interface JsonNoticeService {

	public void regist(JsonNoticeDTO dto) throws Exception;

	public JsonNoticeDTO read(Integer no) throws Exception;

	public void modify(JsonNoticeDTO dto) throws Exception;

	public void remove(Integer no) throws Exception;

	public List<JsonNoticeDTO> listAll(String section_cd) throws Exception;
}