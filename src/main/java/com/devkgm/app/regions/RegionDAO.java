package com.devkgm.app.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devkim.app.util.DBConnector;

@Repository
public class RegionDAO {
	
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
//		db접속 후 부서 테입블의 모든 정보를 출력

	
		List<RegionDTO> dtoList = new ArrayList<RegionDTO>();
		Connection connection = DBConnector.getConnector();
		String sql = "SELECT * FROM REGIONS";
		PreparedStatement st = connection.prepareStatement(sql);
		st.executeQuery();
		ResultSet resultSet = st.getResultSet();
		
		while(resultSet.next()) {
			RegionDTO regionDTO = new RegionDTO();
			int RegionId = resultSet.getInt("REGION_ID");
			String RegionName = resultSet.getString("REGION_NAME");
			
			regionDTO.setRegion_id(RegionId);
			regionDTO.setRegion_name(RegionName);
			
			dtoList.add(regionDTO);
		}
		
		DBConnector.disConnect(resultSet, st, connection);
		return dtoList;
		
		
	}
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		RegionDTO dto = null;
		Connection connection = DBConnector.getConnector();
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, regionDTO.getRegion_id());
		
		ResultSet resultSet = st.executeQuery();
		
		if(resultSet.next()) {
			dto = new RegionDTO();
			dto.setRegion_id(resultSet.getInt("REGION_ID"));
			dto.setRegion_name(resultSet.getString("REGION_NAME"));
		}
		DBConnector.disConnect(resultSet, st, connection);
		return dto;
		
	}

	
}
