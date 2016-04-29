package com.jarvis.focus.dao;

import java.util.List;

import com.jarvis.focus.dto.ShirtDTO;
import com.jarvis.focus.entity.Shirt;
import com.jarvis.focus.entity.ShirtProperty;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-06
 */

public interface ShirtDao {

	public List<ShirtDTO> getMoreShirt(Shirt shirt);
	
	public int updateShirtLog(Long shirtId, Integer clickNum);

	public List<ShirtProperty> getColorList(Integer status);

	public List<ShirtProperty> getBrandList(Integer status);

	public List<ShirtProperty> getSourceList(Integer status);

	public List<ShirtProperty> getPriceRangeList(Integer status);
	
}
