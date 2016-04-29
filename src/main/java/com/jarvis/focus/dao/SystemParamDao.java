package com.jarvis.focus.dao;

import com.jarvis.focus.entity.SystemParam;

public interface SystemParamDao {

	public SystemParam getSystemParam(String systemName, String name);
	
	public int updateSystemParam(SystemParam systemParam);
}
