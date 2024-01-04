package com.devkgm.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/departments", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<DepartmentDTO> list = departmentService.getList();
		model.addAttribute("list", list);
		return "departments/list";
	}
	@RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
	public String detail(Model model,@PathVariable int id) throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(id);
		departmentDTO = departmentService.getDetail(departmentDTO);
		model.addAttribute("dto", departmentDTO);
		return "departments/detail";
	}
}
