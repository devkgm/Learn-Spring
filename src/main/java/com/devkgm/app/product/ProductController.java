package com.devkgm.app.product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	private ProductDAO productDAO;
	
	public ProductController () {
		this.productDAO = new ProductDAO();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String list(Model model) throws Exception{
		List<ProductDTO> list = productDAO.getList();
		model.addAttribute("list", list);
		return "products/list";
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET)
	public String detail(@PathVariable Long id, Model model) throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productDTO = productDAO.getDetail(productDTO);
		model.addAttribute("dto", productDTO);
		return "products/detail";
	}
}
