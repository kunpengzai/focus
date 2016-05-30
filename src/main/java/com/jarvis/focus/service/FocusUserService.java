package com.jarvis.focus.service;

import com.jarvis.focus.entity.FocusUser;

public interface FocusUserService {

	public FocusUser getByCredentials(String username, String password) throws Exception;
	
	public void increaseLonginUserNum(Long focusUserId, String ip);
}
