package com.jarvis.focus.dao.impl;

import com.jarvis.focus.dao.AreaDao;
import com.jarvis.focus.dto.AreaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AreaDaoImpl extends BaseDaoImpl implements AreaDao {

    private static final Logger log = LoggerFactory.getLogger(AreaDaoImpl.class);

    @Override
    public List<AreaDTO> getProvinceList() {
        try{
            return this.getSqlSession().selectList("area.getProvinceList");
        } catch(RuntimeException e){
            log.error("areaDao.getProvinceList error", e);
            throw e;
        }
    }

    public List<AreaDTO> getAreaCityListByParentId(Long parentId) {
        try{
            return this.getSqlSession().selectList("area.getAreaCityListByParentId", parentId);
        } catch(RuntimeException e){
            log.error("areaDao.getAreaCityListByParentId error", e);
            throw e;
        }
    }

    @Override
    public List<Map> getCitiesFullJson() {
        try {
            return this.getSqlSession().selectList("area.getCitiesFull");
        } catch (RuntimeException e) {
            log.error("areaDao.getCitiesFull error", e);
            throw e;
        }
    }

    @Override
    public List<Map> getFullArea() {
        try{
            return this.getSqlSession().selectList("area.getFullArea");
        } catch(RuntimeException e){
            log.error("areaDao.getFullArea error", e);
            throw e;
        }
    }

    @Override
    public List<Map> getAllProvinceAndCity() {
        try{
            return this.getSqlSession().selectList("area.getAllProvinceAndCity");
        } catch(RuntimeException e){
            log.error("areaDao.getAllProvinceAndCity error", e);
            throw e;
        }
    }
}