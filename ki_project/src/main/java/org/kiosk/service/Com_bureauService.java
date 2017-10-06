package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.Com_bureauVO;

public interface Com_bureauService {

	public void regist(Com_bureauVO vo) throws Exception;

	public Com_bureauVO read(String bureau_cd) throws Exception;

	public void modify(Com_bureauVO vo) throws Exception;

	public void remove(String bureau_cd) throws Exception;

	public List<Com_bureauVO> listAll() throws Exception;

}
