package com.devkgm.app.departments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.devkgm.app.departments.DepartmentDAO.";
	
	public int update(DepartmentDTO departmentDTO) throws Exception{
		return sqlSession.update(namespace+"update",departmentDTO);
	}
	
	public int delete(DepartmentDTO departmentDTO) throws Exception{
		return sqlSession.delete(namespace+"delete", departmentDTO);
	}
	
	public int add(DepartmentDTO departmentDTO) throws Exception{
		return sqlSession.insert(namespace+"add", departmentDTO);
	}
	
	public List<DepartmentDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
	}
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",departmentDTO);
	}
}
