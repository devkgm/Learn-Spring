package com.devkgm.app.departments;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.Mytest;


public class DepartmentDAOTest extends Mytest{
	@Autowired
	private DepartmentDAO departmentDAO;
	
//	@Test
	public void deleteTest() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(280);
		int result = departmentDAO.delete(departmentDTO);
		assertNotEquals(0, result);
	}
	
//	@Test
	public void updateTest() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(280);
		departmentDTO.setDepartment_name("IT");
		departmentDTO.setLocation_id(1700);
		departmentDTO.setManager_id(100);
		int result = departmentDAO.update(departmentDTO);
		assertNotEquals(0, result);
	}
	
//	@Test
	public void addTest() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_name("it");
		departmentDTO.setLocation_id(1700);
		departmentDTO.setManager_id(100);
		int result = departmentDAO.add(departmentDTO);
		assertNotEquals(0, result);
	}
	
	@Test
	public void getDetailTest() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(10);
		departmentDTO = departmentDAO.getDetail(departmentDTO);
		assertNotNull(departmentDTO);
	}
	@Test
	public void getListTest() throws Exception{
		List<DepartmentDTO> list = departmentDAO.getList();
		assertNotEquals(0, list.size());
	}
}
