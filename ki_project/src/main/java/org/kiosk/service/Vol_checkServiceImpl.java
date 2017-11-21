package org.kiosk.service;

import javax.inject.Inject;
import org.kiosk.domain.Vol_checkVO;
import org.kiosk.persistence.Vol_checkDAO;
import org.springframework.stereotype.Service;

@Service
public class Vol_checkServiceImpl implements Vol_checkService {

	@Inject
	private Vol_checkDAO dao;

	@Override
	public Vol_checkVO read(Integer vol_no) throws Exception {
		return dao.read(1);
	}

	@Override
	public void update(String col_name) throws Exception {
		dao.update(col_name);
	}

}