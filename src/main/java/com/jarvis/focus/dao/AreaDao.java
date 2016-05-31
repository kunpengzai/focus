package com.jarvis.focus.dao;

import com.jarvis.focus.dto.AreaDTO;

import java.util.List;
import java.util.Map;

public interface AreaDao {

    public List<AreaDTO> getProvinceList();

    public List<AreaDTO> getAreaCityListByParentId(Long parentId);

    public List<Map> getCitiesFullJson();

    public List<Map> getFullArea();

    public List<Map> getAllProvinceAndCity();
}