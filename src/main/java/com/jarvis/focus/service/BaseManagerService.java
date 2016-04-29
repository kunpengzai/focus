package com.jarvis.focus.service;

import java.util.List;

import com.jarvis.focus.dto.ShirtPropertyDTO;

public interface BaseManagerService {

	public List<ShirtPropertyDTO> getColorList();
	
	public List<ShirtPropertyDTO> getBrandList();
	
	public List<ShirtPropertyDTO> getSourceList();
	
//	public List<ShirtPropertyDTO> getPriceRangeList();
	
	public String getWeightScheduler();
}
