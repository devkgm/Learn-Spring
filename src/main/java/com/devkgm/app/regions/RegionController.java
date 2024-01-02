package com.devkgm.app.regions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/regions/*")
public class RegionController {
	@RequestMapping(value = "/list", method = RequestMethod.GET	)
	public String list(HttpServletRequest request) throws Exception {
		RegionDAO dao = new RegionDAO();
		List<RegionDTO> list = dao.getList();		
		request.setAttribute("list", list);
		return "regions/list"; 
	}
	
	@RequestMapping(value= "/detail", method=RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception {
		RegionDAO dao = new RegionDAO();
		RegionDTO dto = new RegionDTO();
		dto.setRegion_id(Integer.parseInt(request.getParameter("id")) );
		dto = dao.getDetail(dto);
		request.setAttribute("dto", dto);
		return "regions/detail";
	}
}
