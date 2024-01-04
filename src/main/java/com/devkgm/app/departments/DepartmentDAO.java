package com.devkgm.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkim.app.util.DBConnector;

@Repository
public class DepartmentDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.devkgm.app.departments.DepartmentDAO.";
	
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
		return sqlSession.selectList(namespace+"getList");
	}
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",departmentDTO);
	}
}
