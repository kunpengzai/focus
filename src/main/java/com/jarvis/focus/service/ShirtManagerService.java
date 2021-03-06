package com.jarvis.focus.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.jarvis.focus.dto.PageInfo;
import com.jarvis.focus.dto.SearchInfo;
import com.jarvis.focus.dto.ShirtDTO;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-06
 */

public interface ShirtManagerService {

	public Map<String, Object> getShirtList(SearchInfo searchInfo, PageInfo pageInfo);
	
	public Map<String, Object> shirtDetail(Long shirtId);
	
	public void addShirt(ShirtDTO shirt, MultipartFile imageFile) throws IOException;
	
	public Map<String, Object> deleteShirt(Long shirtId);
	
	public void editShirt(ShirtDTO shirt, MultipartFile imageFile) throws IOException;
	
	public Map<String, Object> changeShirtStatus(Long shirtId, Integer status);
	
	public Map<String, Object> changeWeightScheduler(Integer status);

	public Map<String, Object> compressImg();
}
