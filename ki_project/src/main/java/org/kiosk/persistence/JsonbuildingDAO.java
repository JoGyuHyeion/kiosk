package org.kiosk.persistence;

import java.util.List;
import org.kiosk.dto.Com_buildingDTO;

public interface JsonbuildingDAO {
	public void create(Com_buildingDTO dto) throws Exception;

	public Com_buildingDTO read(Integer bu_no) throws Exception;

	public void update(Com_buildingDTO dto) throws Exception;

	public void delete(Integer bu_no) throws Exception;

	public List<Com_buildingDTO> listAll() throws Exception;
}
