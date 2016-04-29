package com.jarvis.focus.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.focus.dto.PageInfo;
import com.jarvis.focus.dto.SearchInfo;
import com.jarvis.focus.dto.ShirtPropertyDTO;
import com.jarvis.focus.service.BaseService;
import com.jarvis.focus.service.ShirtService;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-06
 */

@Controller
@RequestMapping ("/shirt/")
public class ShirtController {
	
	@Resource
	private BaseService baseService;
	@Resource
	private ShirtService shirtService;
	
	@RequestMapping ("shirt-list")
	public String shirtState(HttpServletRequest request, Model model) {
		List<ShirtPropertyDTO> brandList = baseService.getBrandList();
		List<ShirtPropertyDTO> sourceList = baseService.getSourceList();
		List<ShirtPropertyDTO> colorList = baseService.getColorList();
		List<ShirtPropertyDTO> priceRangeList = baseService.getPriceRangeList();
		
		model.addAttribute("brandList", brandList);
		model.addAttribute("sourceList", sourceList);
		model.addAttribute("colorList", colorList);
		model.addAttribute("priceRangeList", priceRangeList);
		
		return "/shirt/shirt-list";
	}
	
	@ResponseBody
	@RequestMapping(value="get-more-shirt", produces="application/json;charset=UTF-8")
	public Map<String, Object> getMoreShirt(HttpServletRequest request, 
			SearchInfo searchInfo, PageInfo pageInfo) throws Exception {
		Map<String, Object> m = shirtService.getMoreShirt(searchInfo, pageInfo);
		return m;
	}

	@ResponseBody
	@RequestMapping(value="click-point", produces="application/json;charset=UTF-8", method= RequestMethod.POST)
	public Map<String, Object> clickPoint(Long shirtId) {
		Map<String, Object> m = shirtService.clickPoint(shirtId);
		return m;
	}
}
