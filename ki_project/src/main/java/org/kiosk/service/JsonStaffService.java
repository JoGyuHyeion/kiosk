package org.kiosk.service;

import java.util.List;
import java.util.Map;

import org.kiosk.dto.JsonStaffDTO;

public interface JsonStaffService {

	public void regist(JsonStaffDTO dto) throws Exception;

	public JsonStaffDTO read(String section_cd) throws Exception;

	public void modify(JsonStaffDTO dto) throws Exception;

	public void remove(String section_cd) throws Exception;

	public List<JsonStaffDTO> listAll(String section_fullpath) throws Exception;

	public JsonStaffDTO getJsonStaff(String section_cd) throws Exception;

//	public Map<String, JsonStaffDTO> getAllJsonStaff() throws Exception;
	
	
}