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
	
	@Test
	public void getList() throws Exception {
		
		List<ProductDTO> list = sqlSession.selectList(namespace+"getList");
		System.out.println(list.size());
		assertNotEquals(0, list.size());
	}

}
