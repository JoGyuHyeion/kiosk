package org.kiosk.service;

import org.kiosk.domain.Vol_checkVO;

public interface Vol_checkService {

	public Vol_checkVO read(Integer vol_no) throws Exception;

	public void update(String col_name) throws Exception;
}