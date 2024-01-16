package com.devkgm.app.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.Mytest;
import com.devkgm.app.product.ProductDTO;

public class noticeTest extends Mytest{

	@Autowired
	private SqlSession sqlSession;
	@Test
	public void test() {
		List<ProductDTO> list = sqlSession.selectList("com.devkgm.app.notice.NoticeDAO.getList");
		System.out.println(list.size());
		assertNotEquals(0, list.size());
	}

}
