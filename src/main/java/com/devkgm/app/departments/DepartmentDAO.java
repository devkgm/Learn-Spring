package com.devkgm.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.devkim.app.util.DBConnector;

public class DepartmentDAO {
	public int update(DepartmentDTO dto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, LOCATION_ID=? WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(3, dto.getDepartment_id());
		st.setString(1, dto.getDepartment_name());
		

		st.setInt(2, dto.getLacation_id());
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int delete(DepartmentDTO dto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getDepartment_id());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int add(DepartmentDTO dto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO DEPARTMENTS VALUES (?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getDepartment_id());
		st.setString(2, dto.getDepartment_name());
		st.setInt(3, dto.getManager_id());
		st.setInt(4, dto.getLacation_id());
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public List<DepartmentDTO> getList() throws Exception{
		List<DepartmentDTO> dtoList = new ArrayList<DepartmentDTO>();
		Connection connection = DBConnector.getConnector();
		String sql = "SELECT * FROM DEPARTMENTS";
		PreparedStatement st = connection.prepareStatement(sql);
		st.executeQuery();
		ResultSet resultSet = st.getResultSet();

		while(resultSet.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int DepartmentId = resultSet.getInt("DEPARTMENT_ID");
			String DepartmentName = resultSet.getString("DEPARTMENT_NAME");
			int ManagerId = resultSet.getInt("MANAGER_ID");
			int LocationId = resultSet.getInt("LOCATION_ID");
			departmentDTO.setDepartment_id(DepartmentId);
			departmentDTO.setDepartment_name(DepartmentName);
			departmentDTO.setManager_id(ManagerId);
			departmentDTO.setLacation_id(LocationId);
			dtoList.add(departmentDTO);
		}
		
		DBConnector.disConnect(resultSet, st, connection);
		return dtoList;
	}
	public DepartmentDTO getDetail(DepartmentDTO dto) throws Exception{
		DepartmentDTO departmentDTO = null;
		Connection connection= DBConnector.getConnector();
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, dto.getDepartment_id());
		ResultSet resultSet = st.executeQuery();
		
		if(resultSet.next()) {
			departmentDTO = new DepartmentDTO();
			int DepartmentId = resultSet.getInt("DEPARTMENT_ID");
			String DepartmentName = resultSet.getString("DEPARTMENT_NAME");
			int ManagerId = resultSet.getInt("MANAGER_ID");
			int LocationId = resultSet.getInt("LOCATION_ID");
			departmentDTO.setDepartment_id(DepartmentId);
			departmentDTO.setDepartment_name(DepartmentName);
			departmentDTO.setManager_id(ManagerId);
			departmentDTO.setLacation_id(LocationId);
		}
		DBConnector.disConnect(resultSet, st, connection);
		return departmentDTO;
	}
}
