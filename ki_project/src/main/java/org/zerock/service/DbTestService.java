package org.zerock.service;

import java.util.List;

import org.zerock.domain.DbTestVO;

public interface DbTestService {

	public void regist(DbTestVO vo) throws Exception;

	public DbTestVO read(Integer no) throws Exception;

	public void modify(DbTestVO vo) throws Exception;

	public void remove(Integer no) throws Exception;

	public List<DbTestVO> listAll() throws Exception;
}
