package org.kiosk.service;

import java.util.List;
import org.kiosk.dto.JsonStaffDTO;

public interface JsonStaffService {

	public void regist(JsonStaffDTO dto) throws Exception;

	public JsonStaffDTO read(String section_cd) throws Exception;

	public void modify(JsonStaffDTO dto) throws Exception;

	public void remove(String section_cd) throws Exception;

	public List<JsonStaffDTO> listAll(String section_fullpath) throws Exception;
}