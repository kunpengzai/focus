package com.jarvis.focus.dao;

import java.util.List;

import com.jarvis.focus.dto.ShirtDTO;
import com.jarvis.focus.entity.Shirt;
import com.jarvis.focus.entity.ShirtParam;
import com.jarvis.focus.entity.ShirtProperty;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-06
 */

public interface ShirtManagerDao {

	public List<ShirtDTO> getShirtList(Shirt shirt);
	
	public Integer getShirtNum(Shirt shirt);
	
	public ShirtDTO getShirt(Long shirtId);
	
	public int updateShirt(Shirt shirt);
	
	public int updateShirtParam(ShirtParam shirtParam);
	
	public Long saveShirt(Shirt shirt);
	
	public Long saveShirtParam(ShirtParam shirtParam);
	
	public void saveShirtLog(Long shirtId);

	public List<ShirtProperty> getColorList();

	public List<ShirtProperty> getBrandList();

	public List<ShirtProperty> getSourceList();

}
