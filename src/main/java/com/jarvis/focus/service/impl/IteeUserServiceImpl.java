package com.jarvis.focus.service.impl;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jarvis.focus.dao.IteeUserDao;
import com.jarvis.focus.entity.IteeUser;
import com.jarvis.focus.service.IteeUserService;
import com.jarvis.focus.utils.Constants;
import com.jarvis.focus.utils.Des3Util;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-25
 */

@Service("iteeUserService")
public class IteeUserServiceImpl implements IteeUserService {

	@Resource
	private IteeUserDao iteeUserDao;
	
	public IteeUser getByCredentials(String username, String password) throws Exception {
		IteeUser iUser = iteeUserDao.getByCredentials(username, Des3Util.encode(Constants.DES_KEY, password));
		return iUser;
	}
	
	@Async
	public void increaseLonginUserNum(Long iteeUserId) {
		iteeUserDao.saveIteeUserLogin(iteeUserId);
	}
}
