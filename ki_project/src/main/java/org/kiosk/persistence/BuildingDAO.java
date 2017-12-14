package org.kiosk.persistence;

import java.util.List;
import org.kiosk.domain.BuildingVO;

public interface BuildingDAO {
	public void create(BuildingVO vo) throws Exception;

	public BuildingVO read(Integer bu_type) throws Exception;

	public void update(BuildingVO vo) throws Exception;

	public void delete(Integer bu_type) throws Exception;

	public List<BuildingVO> listAll() throws Exception;

	public int lastInsertID() throws Exception;

	
}
