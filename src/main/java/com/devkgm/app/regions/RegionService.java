package com.devkgm.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO 보내기전 전처리, 후처리
@Service
public class RegionService {
	@Autowired
	private RegionDAO regionDAO;
	
	public int delete(RegionDTO regionDTO) throws Exception{
		return regionDAO.delete(regionDTO);
	}
	
	public int update(RegionDTO regionDTO) throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	public int add(RegionDTO regionDTO) throws Exception{
		return regionDAO.add(regionDTO);
	}
	
	public List<RegionDTO> getList() throws Exception{
		return this.regionDAO.getList();
	}
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		return this.regionDAO.getDetail(regionDTO);
	}
}
