package org.kiosk.persistence;

import java.util.List;
import org.kiosk.dto.Com_bgImgDTO;

public interface JsonBgImgDAO {
	public void create(Com_bgImgDTO dto) throws Exception;

	public Com_bgImgDTO read(Integer ic_no) throws Exception;

	public void update(Com_bgImgDTO dto) throws Exception;

	public void delete(Integer ic_no) throws Exception;

	public List<Com_bgImgDTO> listAll() throws Exception;
}
