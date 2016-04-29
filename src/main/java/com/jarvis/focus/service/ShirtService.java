package com.jarvis.focus.service;

import java.util.Map;

import com.jarvis.focus.dto.PageInfo;
import com.jarvis.focus.dto.SearchInfo;

public interface ShirtService {

	public Map<String, Object> getMoreShirt(SearchInfo searchInfo, PageInfo pageInfo) throws Exception;

	public Map<String, Object> clickPoint(Long shirtId);
}
