package com.devkgm.app.regions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.Mytest;

public class RegionDAOTest extends Mytest{
	@Autowired
	private RegionDAO regionDAO;
	
	@Test
	public void getListTest() throws Exception{
		List<RegionDTO> list = regionDAO.getList();
		assertNotEquals(0,list.size());
	}
	
	@Test
	public void getDetailTest() throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(1);
		regionDTO = regionDAO.getDetail(regionDTO);
		assertNotNull(regionDTO);
	}
}
