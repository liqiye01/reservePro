package com.reserve.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.reserve.bean.User;

/**
 * 拦截所有请求，查看有没登录1
 * @author liqiye
 *
 */
public class UserInterceptor implements HandlerInterceptor{
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		User user=(User)request.getSession().getAttribute("user");
		if(null==user){
            //如果没有登录session，则返回到登录页面
            response.sendRedirect(request.getContextPath()+"/view/loginPage?loginFlag=1");
            return false;
        }
		return true;
	}

}
