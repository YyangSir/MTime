package com.yang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Yyang
 * @create 2017/12/2.
 * user 拦截器 拦截评论
 */
public class UserInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		System.out.println("UserInterceptor...");
		HttpSession session = httpServletRequest.getSession();

		if (session.getAttribute("id") == null) {
			httpServletRequest.getRequestDispatcher("/loginError").forward(httpServletRequest, httpServletResponse);
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
