package com.devkgm.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO 보내기전 전처리, 후처리
@Service
public class RegionService {
	@Autowired
	private RegionDAO regionDAO;
	
	public List<RegionDTO> getList() throws Exception{
		List<RegionDTO> list = this.regionDAO.getList();
		
		return list;
	}
}
