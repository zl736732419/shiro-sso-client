package com.zheng.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.AdviceFilter;

public class MySignOutFilter extends AdviceFilter {
	private Map<String, Object> cache = new HashMap<>();
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		String logoutReq = request.getParameter("logoutRequest"); 
		String ticket = request.getParameter("ticket");
		HttpSession session = req.getSession();
		String sid = session.getId();
		
		if(!StringUtils.isBlank(ticket)) {
			cache.put(ticket, sid);
		}
		
		if(!StringUtils.isBlank(logoutReq)) {
			if(cache.get(sid) != null) {
				session.invalidate();
				cache.remove(sid);
			}
		}
		
		return true;
	}
	
}
