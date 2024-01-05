package com.devkgm.app.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkim.app.util.DBConnector;

@Repository
public class RegionDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.devkgm.app.regions.RegionDAO.";
	
	public int update(RegionDTO regionDTO) throws Exception{
		return sqlSession.update(namespace+"update", regionDTO);
	}
	
	public int delete(RegionDTO regionDTO) throws Exception{
		return sqlSession.delete(namespace+"delete", regionDTO);
	}
	
	public int add(RegionDTO regionDTO) throws Exception{
		return sqlSession.insert(namespace+"add",regionDTO);
		
	}
	
	public List<RegionDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
	}
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail", regionDTO);
	}

	
}
