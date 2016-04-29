package com.jarvis.focus.dao;

import com.jarvis.focus.entity.IteeUser;

public interface IteeUserDao {

	public IteeUser getByCredentials(String username, String password);
	
	public void saveIteeUserLogin(Long iteeUserId);
}
