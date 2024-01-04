package com.devkgm.app.departments;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.Mytest;


public class DepartmentDAOTest extends Mytest{
	@Autowired
	private DepartmentDAO departmentDAO;
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
