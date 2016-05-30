package com.jarvis.focus.dao;

import com.jarvis.focus.entity.FocusUser;

public interface FocusUserDao {

	public FocusUser getByCredentials(String username, String password);

	public void saveFocusUserLogin(Long focusUserId, String ip);
}
