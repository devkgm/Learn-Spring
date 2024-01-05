package com.devkgm.app.regions;


import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/regions/*")
public class RegionController {
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(RegionDTO regionDTO,ModelAndView modelAndView) throws Exception{
		int result = regionService.update(regionDTO);
		String msg="수정 실패";
		if(result>0) {
			msg = "수정 성공";
		}
		modelAndView.addObject("msg", msg);
		modelAndView.addObject("path", "/regions/list");
		modelAndView.setViewName("commons/result");
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, RegionDTO regionDTO) throws Exception{
		regionDTO = regionService.getDetail(regionDTO);
		model.addAttribute("dto", regionDTO);
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET	)
	public String list(Model model) throws Exception {
		List<RegionDTO> list = regionService.getList();
		model.addAttribute("list", list);
		return "regions/list"; 
	}
	@RequestMapping(value= "detail/{id}", method=RequestMethod.GET)
	public String detail(@PathVariable int id,Model model) throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(id);
		regionDTO = regionService.getDetail(regionDTO);
		model.addAttribute("dto", regionDTO);
		return "regions/detail";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() throws Exception{
		return "regions/add";
	}
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(RegionDTO regionDTO, Model model, HttpServletResponse response) throws Exception{
		int result = regionService.add(regionDTO);

		String msg="등록 실패";
		if(result>0) {
			msg = "등록 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", "/regions/list");
		
		return "commons/result";

	}
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String deleteRegion(Model model, RegionDTO regionDTO) throws Exception{
		int result = regionService.delete(regionDTO);
		String msg="삭제 실패";
		if(result>0) {
			msg = "삭제 성공";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", "/regions/list");

		return "commons/result";
	}
}
