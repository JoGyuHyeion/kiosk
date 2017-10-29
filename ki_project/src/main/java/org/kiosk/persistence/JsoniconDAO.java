package org.kiosk.persistence;

import java.util.List;
import org.kiosk.dto.Com_iconDTO;

public interface JsoniconDAO {
	public void create(Com_iconDTO dto) throws Exception;

	public Com_iconDTO read(Integer ic_no) throws Exception;

	public void update(Com_iconDTO dto) throws Exception;

	public void delete(Integer ic_no) throws Exception;

	public List<Com_iconDTO> listAll() throws Exception;
}
