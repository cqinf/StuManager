package com.stu.filter;

import com.stu.entity.stu.Stu;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LARK on 2017/12/12.
 * 登录过滤器
 */

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		servletResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
		servletResponse.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		servletResponse.setHeader("Access-Control-Allow-Origin", "*");
		// 获取用户请求的URI
		String path = servletRequest.getRequestURI();

		// 获取session中用户名信息
		Stu stu = (Stu) session.getAttribute("loginUser");
		System.out.println("filter:" + stu);
		if(stu!=null) {
			System.out.println(stu.getSname());
			chain.doFilter(request, response);
			return;
		}
		// 判断是否为登陆界面，如果是登陆界面则放行，否则进行用户信息检查
		if(path.contains("/login.jsp") || path.contains("userLogin") || path.contains("/error.jsp")) {
			chain.doFilter(request, response);
			return;
		}else if(path.endsWith(".css")||path.endsWith(".js")||path.endsWith(".ttf")||path.endsWith(".ico")) {
			chain.doFilter(request, response);
			return;
		}else {
			if(stu == null) {
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/data/login.json");
				chain.doFilter(request, response);
				return;
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
