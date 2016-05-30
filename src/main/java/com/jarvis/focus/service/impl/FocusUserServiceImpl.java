package com.jarvis.focus.service.impl;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jarvis.focus.dao.FocusUserDao;
import com.jarvis.focus.entity.FocusUser;
import com.jarvis.focus.service.FocusUserService;
import com.jarvis.focus.utils.Constants;
import com.jarvis.focus.utils.Des3Util;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-25
 */

@Service("iteeUserService")
public class FocusUserServiceImpl implements FocusUserService {

	@Resource
	private FocusUserDao focusUserDao;
	
	public FocusUser getByCredentials(String username, String password) throws Exception {
		FocusUser iUser = focusUserDao.getByCredentials(username, Des3Util.encode(Constants.DES_KEY, password));
		return iUser;
	}
	
	@Async
	public void increaseLonginUserNum(Long focusUserId, String ip) {
		focusUserDao.saveFocusUserLogin(focusUserId, ip);
	}
}
