package com.devkgm.app.regions;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() throws Exception{
		return "regions/add";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addRegion(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int region_id = Integer.parseInt(request.getParameter("region_id")); 
		String region_name = request.getParameter("region_name");
		RegionDAO dao = new RegionDAO();
		RegionDTO dto = new RegionDTO();
		dto.setRegion_id(region_id);
		dto.setRegion_name(region_name);
		int result = dao.add(dto);

		response.sendRedirect("/regions/list");
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteRegion(@PathVariable int id, HttpServletResponse response) throws Exception{
		int region_id = id;

		RegionDAO dao = new RegionDAO();
		RegionDTO dto = new RegionDTO();
		dto.setRegion_id(region_id);

		int result = dao.delete(dto);

		response.sendRedirect("/regions/list");
	}
}
