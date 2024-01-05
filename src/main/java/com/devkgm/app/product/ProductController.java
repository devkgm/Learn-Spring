package com.devkgm.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	
	
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) throws Exception{
		List<ProductDTO> list = productDAO.getList();
		model.addAttribute("list", list);
		return "products/list";
	}
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail( Model model, ProductDTO productDTO) throws Exception{
		productDTO = productDAO.getDetail(productDTO);
		model.addAttribute("dto", productDTO);
		return "products/detail";
	}
}
