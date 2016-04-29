package com.jarvis.focus.service;

import com.jarvis.focus.entity.IteeUser;

public interface IteeUserService {

	public IteeUser getByCredentials(String username, String password) throws Exception;
	
	public void increaseLonginUserNum(Long iteeUserId);
}
