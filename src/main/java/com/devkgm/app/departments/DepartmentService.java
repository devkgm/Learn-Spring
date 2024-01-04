package com.devkgm.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	public List<DepartmentDTO> getList() throws Exception{
		return this.departmentDAO.getList();
	}
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception{
		return this.departmentDAO.getDetail(departmentDTO);
	}
}
