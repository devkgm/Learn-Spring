package com.devkgm.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList() throws Exception {
		return this.productDAO.getList();
	}
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		return this.productDAO.getDetail(productDTO);
	}
	public int add(ProductDTO productDTO) throws Exception {
		return this.productDAO.add(productDTO);
	}
	public int update(ProductDTO productDTO) throws Exception {
		return this.productDAO.update(productDTO);
	}
	public int delete(ProductDTO productDTO) throws Exception{
		return this.productDAO.delete(productDTO);
	}
}
