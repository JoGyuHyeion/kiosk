package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.DbTestVO;

public interface DbTestDAO {
	
	  public void create(DbTestVO vo) throws Exception;

	  public DbTestVO read(Integer bno) throws Exception;

	  public void update(DbTestVO vo) throws Exception;

	  public void delete(Integer no) throws Exception;
	  
	  public List<DbTestVO> listAll() throws Exception;

}
