package com.jarvis.focus.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jarvis.focus.dao.IteeUserDao;
import com.jarvis.focus.entity.IteeUser;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class IteeUserDaoImpl extends BaseDaoImpl implements IteeUserDao {
	
	private static final Logger log = LoggerFactory.getLogger(IteeUserDaoImpl.class);
	
	public IteeUser getByCredentials(String username, String password) {
		try{
			Map map = new HashMap();
			map.put("username", username);
			map.put("password", password);
			return this.getSqlSession().selectOne("iteeuser.getByCredentials", map);
		} catch(RuntimeException e){
			log.error("iteeUserDao.getByCredentials", e);
			throw e;
		}
	}
	
	public void saveIteeUserLogin(Long iteeUserId) {
		try {
			this.getSqlSession().insert("iteeuser.saveIteeUserLogin", iteeUserId);
		} catch(RuntimeException e) {
			log.error("iteeUserDao.saveIteeUserLogin", e);
			throw e;
		}
	}
}
