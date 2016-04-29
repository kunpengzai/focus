package com.jarvis.focus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jarvis.focus.dao.ShirtManagerDao;
import com.jarvis.focus.dao.SystemParamDao;
import com.jarvis.focus.dto.ShirtPropertyDTO;
import com.jarvis.focus.entity.ShirtProperty;
import com.jarvis.focus.entity.SystemParam;
import com.jarvis.focus.service.BaseManagerService;
import com.jarvis.focus.utils.Constants;

@Service("baseManagerService")
public class BaseManagerServiceImpl implements BaseManagerService {

	private List<ShirtPropertyDTO> colorList;
	private List<ShirtPropertyDTO> brandList;
	private List<ShirtPropertyDTO> sourceList;
	private List<ShirtPropertyDTO> priceRangeList;
	
	@Resource
	private ShirtManagerDao shirtManagerDao;
	@Resource
	private SystemParamDao systemParamDao;
	
	public List<ShirtPropertyDTO> getColorList() {
//		if (colorList == null) {
			colorList = new ArrayList<ShirtPropertyDTO>();
			List<ShirtProperty> list = shirtManagerDao.getColorList();
			for (ShirtProperty sp : list) {
				ShirtPropertyDTO dto = new ShirtPropertyDTO();
				dto.setId(sp.getId());
				dto.setName(sp.getName());
				dto.setOrder(sp.getOrder());
				colorList.add(dto);
			}
//		}
		return colorList;
	}
	public List<ShirtPropertyDTO> getBrandList() {
//		if (brandList == null) {
			brandList = new ArrayList<ShirtPropertyDTO>();
			List<ShirtProperty> list = shirtManagerDao.getBrandList();
			for (ShirtProperty sp : list) {
				ShirtPropertyDTO dto = new ShirtPropertyDTO();
				dto.setId(sp.getId());
				dto.setName(sp.getName());
				dto.setOrder(sp.getOrder());
				brandList.add(dto);
			}
//		}
		return brandList;
	}
	public List<ShirtPropertyDTO> getSourceList() {
//		if (sourceList == null) {
			sourceList = new ArrayList<ShirtPropertyDTO>();
			List<ShirtProperty> list = shirtManagerDao.getSourceList();
			for (ShirtProperty sp : list) {
				ShirtPropertyDTO dto = new ShirtPropertyDTO();
				dto.setId(sp.getId());
				dto.setName(sp.getName());
				dto.setOrder(sp.getOrder());
				sourceList.add(dto);
			}
//		}
		return sourceList;
	}
/*
	public List<ShirtPropertyDTO> getPriceRangeList() {
//		if (priceRangeList == null) {
			priceRangeList = new ArrayList<ShirtPropertyDTO>();
			List<ShirtProperty> list = shirtManagerDao.getPriceRangeList();
			for (ShirtProperty sp : list) {
				ShirtPropertyDTO dto = new ShirtPropertyDTO();
				dto.setId(sp.getId());
				dto.setMinPrice(sp.getMinPrice());
				dto.setMaxPrice(sp.getMaxPrice());
				dto.setOrder(sp.getOrder());
				priceRangeList.add(dto);
			}
//		}
		return priceRangeList;
	}
	*/
	public String getWeightScheduler() {
		SystemParam sysParam = systemParamDao.getSystemParam(Constants.SYSTEM_NAME_MANAGER, 
				Constants.WEIGHT_SWITCH);
		return sysParam.getValue();
	}
}
