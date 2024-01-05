package com.devkgm.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/departments/*")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<DepartmentDTO> list = departmentService.getList();
		model.addAttribute("list", list);
		return "departments/list";
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Model model,DepartmentDTO departmentDTO) throws Exception {
		departmentDTO = departmentService.getDetail(departmentDTO);
		model.addAttribute("dto", departmentDTO);
		return "departments/detail";
	}
}
