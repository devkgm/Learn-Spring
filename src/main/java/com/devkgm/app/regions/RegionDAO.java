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
	
	public int update(RegionDTO dto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(2, dto.getRegion_id());
		st.setString(1, dto.getRegion_name());
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int delete(RegionDTO dto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "DELETE FROM REGIONS WHERE REGION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getRegion_id());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int add(RegionDTO dto) throws SQLIntegrityConstraintViolationException, Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES (?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getRegion_id());
		st.setString(2, dto.getRegion_name());
		int result = st.executeUpdate();
		DBConnector.disConnect( st, con);
		return result;
		
	}
	
	public List<RegionDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
	}
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail", regionDTO);
	}

	
}
