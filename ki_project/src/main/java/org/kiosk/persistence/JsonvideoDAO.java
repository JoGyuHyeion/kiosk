package org.kiosk.persistence;

import java.util.List;

import org.kiosk.dto.Com_videoDTO;

public interface JsonvideoDAO {
	public void create(Com_videoDTO dto) throws Exception;

	public Com_videoDTO read(Integer vi_no) throws Exception;

	public void update(Com_videoDTO dto) throws Exception;

	public void delete(Integer vi_no) throws Exception;

	public List<Com_videoDTO> listAll() throws Exception;
}
