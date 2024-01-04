package com.devkgm.app.regions;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegionController {
	@Autowired
	private RegionService regionService;
	
	
	@RequestMapping(value = "/regions", method = RequestMethod.GET	)
	public String list(Model model) throws Exception {
		List<RegionDTO> list = regionService.getList();
		model.addAttribute("list", list);
		return "regions/list"; 
	}
//	@RequestMapping(value= "/regions/{id}", method=RequestMethod.GET)
//	public String detail(@PathVariable int id,HttpServletRequest request) throws Exception {
//		RegionDTO regionDTO = new RegionDTO();
//		regionDTO.setRegion_id(id);
//		regionDTO = regionDAO.getDetail(regionDTO);
//		request.setAttribute("dto", regionDTO);
//		return "regions/detail";
//	}
//	
//	@RequestMapping(value="/regions/add", method=RequestMethod.GET)
//	public String add() throws Exception{
//		return "regions/add";
//	}
//	@RequestMapping(value="/regions", method=RequestMethod.POST)
//	public String add(Locale locale, RegionDTO regionDTO, HttpServletRequest request, HttpServletResponse response) throws Exception{
//		int result = regionDAO.add(regionDTO);
//		String msg="등록 실패";
//		if(result>0) {
//			msg = "등록 성공";
//		}
//		request.setAttribute("msg", msg);
//		request.setAttribute("path", "./");
//		List<RegionDTO> list = regionDAO.getList();		
//		request.setAttribute("list", list);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		request.setAttribute("date", formattedDate);
//		return "regions/list";
//
//	}
//	@DeleteMapping("/regions/{region_id}")
//	public String deleteRegion( @PathVariable int region_id, HttpServletRequest request) throws Exception{
//		RegionDTO regionDTO = new RegionDTO();
//		regionDTO.setRegion_id(region_id);
//		int result = regionDAO.delete(regionDTO);
//		String msg="삭제 실패";
//		if(result>0) {
//			msg = "삭제 성공";
//		}
//		request.setAttribute("msg", msg);
//		request.setAttribute("path", "./");
//		
//		return "commons/result";
//	}
}
