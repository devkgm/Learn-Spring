package com.devkgm.app.product;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.Mytest;

public class productTest extends Mytest{
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.devkgm.app.product.ProductDAO.";
	
//	@Test
	public void getList() throws Exception {
		
		List<ProductDTO> list = sqlSession.selectList(namespace+"getList");
		System.out.println(list.size());
		assertNotEquals(0, list.size());
	}
	
	
	@Test
	public void addTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		for(int i =1 ; i <= 100;i++) {
			productDTO.setDescription("Test Description"+ i);
			productDTO.setName("Test Name" + i);
			productDTO.setRate( i * 1.0);
			sqlSession.insert(namespace+"add", productDTO);
			if(i%10 == 0) {
				Thread.sleep(500);
			}
		}
	}

}
