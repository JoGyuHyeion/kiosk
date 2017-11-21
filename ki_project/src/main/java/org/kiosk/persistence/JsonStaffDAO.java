package org.kiosk.persistence;

import java.util.List;
import org.kiosk.dto.JsonStaffDTO;

public interface JsonStaffDAO {

	public void create(JsonStaffDTO dto) throws Exception;

	public JsonStaffDTO read(String section_cd) throws Exception;

	public void update(JsonStaffDTO dto) throws Exception;

	public void delete(String section_cd) throws Exception;

	public List<JsonStaffDTO> listAll(String section_fullcode) throws Exception;
}