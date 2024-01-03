package com.devkgm.app.departments;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {
	@RequestMapping(value="/departments", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		DepartmentDAO dao = new DepartmentDAO();
		List<DepartmentDTO> list = dao.getList();
		request.setAttribute("list", list);
		return "departments/list";
	}
	@RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
	public String detail(HttpServletRequest request,@PathVariable int id) throws Exception {
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(id );
		dto = dao.getDetail(dto);
		request.setAttribute("dto", dto);
		return "departments/detail";
	}
}
