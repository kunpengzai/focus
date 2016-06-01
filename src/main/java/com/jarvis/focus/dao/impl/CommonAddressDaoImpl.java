package com.jarvis.focus.dao.impl;

import com.jarvis.focus.dao.CommonAddressDao;
import com.jarvis.focus.dto.CommonAddressDTO;
import com.jarvis.focus.entity.CommonAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CommonAddressDaoImpl extends BaseDaoImpl implements CommonAddressDao {

    private static final Logger log = LoggerFactory.getLogger(CommonAddressDaoImpl.class);

    public void saveCommonAddress(CommonAddress commonAddress) {
        try{
            this.getSqlSession().insert("commonAddress.saveCommonAddress", commonAddress);
        } catch(RuntimeException e){
            log.error("commonAddressDao.saveCommonAddress", e);
            throw e;
        }
    }

    public void saveCommonAddressList(List<CommonAddress> commonAddressList) {
        try{
            this.getSqlSession().insert("commonAddress.saveCommonAddressList", commonAddressList);
        } catch(RuntimeException e){
            log.error("commonAddressDao.saveCommonAddressList", e);
            throw e;
        }
    }

    public Integer updateCommonAddress(CommonAddress commonAddress) {
        try{
            return this.getSqlSession().update("commonAddress.updateCommonAddress", commonAddress);
        } catch(RuntimeException e){
            log.error("commonAddressDao.updateCommonAddress", e);
            throw e;
        }
    }
    
    public List<CommonAddressDTO> getCommonAddressList(CommonAddressDTO commonAddress) {
        try{
            List<CommonAddressDTO>  list = this.getSqlSession().selectList("commonAddress.getCommonAddressList", commonAddress);
            return list;
        } catch(RuntimeException e){
            log.error("commonAddressDao.getCommonAddressList", e);
            throw e;
        }
    }
}
