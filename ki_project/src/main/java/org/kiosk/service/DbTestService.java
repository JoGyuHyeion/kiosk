package org.kiosk.service;

import java.util.List;

import org.kiosk.domain.DbTestVO;

public interface DbTestService {

	public void regist(DbTestVO vo) throws Exception;

	public DbTestVO read(Integer no) throws Exception;

	public void modify(DbTestVO vo) throws Exception;

	public void remove(Integer no) throws Exception;

	public List<DbTestVO> listAll() throws Exception;
}
