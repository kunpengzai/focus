package com.jarvis.focus.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jarvis.focus.dao.FocusUserDao;
import com.jarvis.focus.entity.FocusUser;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class FocusUserDaoImpl extends BaseDaoImpl implements FocusUserDao {
	
	private static final Logger log = LoggerFactory.getLogger(FocusUserDaoImpl.class);
	
	public FocusUser getByCredentials(String username, String password) {
		try{
			Map map = new HashMap();
			map.put("username", username);
			map.put("password", password);
			return this.getSqlSession().selectOne("focususer.getByCredentials", map);
		} catch(RuntimeException e){
			log.error("focusUserDao.getByCredentials", e);
			throw e;
		}
	}
	
	public void saveFocusUserLogin(Long focusUserId, String ip) {
		try {
			Map map = new HashMap();
			map.put("focusUserId", focusUserId);
			map.put("ip", ip);
			this.getSqlSession().insert("focususer.saveFocusUserLogin", map);
		} catch(RuntimeException e) {
			log.error("focusUserDao.saveFocusUserLogin", e);
			throw e;
		}
	}
}
