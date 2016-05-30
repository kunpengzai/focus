package com.jarvis.focus.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Jia Qianpeng
 * 2015-12-06
 */

public class CommonUtils {
	
	public static String getRequestUrl(HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		if (StringUtils.isNotEmpty(queryString)) {
			return requestUrl + "?" + queryString;
		}
		return requestUrl;
	}
	
	public static String getBaseUrl(HttpServletRequest request) {
		String baseUrl = "";//eg:http://jiaolianbao/clubwx/
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		Integer index = requestUrl.indexOf(requestUri);
		if (index == -1) {
			baseUrl = requestUrl + "/" + Constants.PROJECT_NAME + "/";
		} else {
			baseUrl = requestUrl.substring(0, index) + "/" + Constants.PROJECT_NAME + "/";
		}
		return baseUrl;
	}
	
	public static String getRequestUri(HttpServletRequest request) {
		String requestUrl = request.getRequestURI().substring(("/"+ Constants.PROJECT_NAME).length());
		String queryString = request.getQueryString();
		if (StringUtils.isNotEmpty(queryString)) {
			return requestUrl + "?" + queryString;
		}
		return requestUrl;
	}
	
	public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase();
    }

	public static String getFieldValueByCookie(HttpServletRequest request, String fieldName) {
		String result = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (fieldName.equals(cookie.getName()) && StringUtils.isNotEmpty(cookie.getValue())) {
					result = cookie.getValue();
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * 检查是否是重复提交，并返回新的token
	 * @param request
	 * @param token
	 * @return flag:0 不是重复提交 flag:-1 是重复提交
	 */
	public static Map<String, Object> checkDuplicateSubmit(HttpServletRequest request, String token) {
		Map<String, Object> m = new HashMap<String, Object>();
		TokenUtils tokenGen=TokenUtils.getInstance();
		request.setAttribute(token, tokenGen);
		if (!tokenGen.isTokenValid(request)){
			m.put("flag", -1);
			m.put("msg", "请勿重复提交，请刷新页面后重试。");//"这是重复提交或非法提交!"
			return m;
		} else {
			//处理请求，并执行resetToken方法，将session中的token去除
			tokenGen.resetToken(request);
		}
		//设置一个token，用于防止form表达重复提交
		TokenUtils.getInstance().saveToken(request);
		String newToken = (String)request.getSession().getAttribute("token");
		m.put("token", newToken);
		m.put("flag", 0);
		return m;
	}

	/**
	 * 获得IP地址
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteIp = request.getHeader("X-Real-IP"); //nginx反向代理
		System.out.println("remoteIP="+remoteIp);
		if (StringUtils.isNotEmpty(remoteIp)) {
			return remoteIp;
		} else {
			remoteIp = request.getHeader("X-Forwarded-For");//apache反射代理
			if (StringUtils.isNotEmpty(remoteIp)) {
				System.out.println("remoteIP2 part="+remoteIp);
				String[] ips = remoteIp.split(",");
				for (String ip : ips) {
					if (!"null".equalsIgnoreCase(ip)) {
						System.out.println("remoteIP2="+ip);
						return ip;
					}
				}
			}
			try {
				String remoteAddr = request.getRemoteAddr();
				if (StringUtils.isNotBlank(remoteAddr)) {
					System.out.println("remoteIP3=" + remoteAddr);
					return remoteAddr;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
	}
	
	public static void main(String[] args) {
		
	}
}
