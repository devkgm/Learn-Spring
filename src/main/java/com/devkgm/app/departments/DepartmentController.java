package com.devkgm.app.departments;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/departments/*")
public class DepartmentController {
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		DepartmentDAO dao = new DepartmentDAO();
		List<DepartmentDTO> list = dao.getList();
		request.setAttribute("list", list);
		return "departments/list";
	}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception {
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(Integer.parseInt(request.getParameter("id")) );
		dto = dao.getDetail(dto);
		request.setAttribute("dto", dto);
		return "departments/detail";
	}
}
