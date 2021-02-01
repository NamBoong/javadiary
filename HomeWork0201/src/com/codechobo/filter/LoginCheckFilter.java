package com.codechobo.filter;


import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/LoginCheckFilter")
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 1. ������ ��û�� �ޱ� ���� ó���� �۾� �ۼ�(��û ��ó�� �۾�)
		System.out.println("[start]" + new Date() + " ���� ó�� ����!");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpSession httpSession = httpServletRequest.getSession(false);
		boolean login = false;

		HttpSession session = ((HttpServletRequest) request).getSession();
		session = ((HttpServletRequest) request).getSession(true);
		
		// 2. filter�� �۾��� �� �ְ� ��û�� ���� ����(�˾Ƽ� ��������. �׳� ���� �ȴ�.)
		
		//�α��� �ߴ��� ���ߴ����� ���� ���� ������ ���Ѵ�.
		if(httpSession!=null) {
			if(httpSession.getAttribute("id")!=null) {
				login = true;
			}
		}
		
		if(session.getAttribute("id")!=null) {
			login = true;
		}
		
		
		if(login==true) {
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/loginForm.jsp");
			rd.forward(request, response);
		}
		
		
		// 3. ������ ������ ���Ŀ� ó���� �۾� �ۼ�(���� ��ó�� �۾�)
		System.out.println("[end]" + new Date() + "���� ó�� ��!");
	}
	
	public void destroy() {
	}

}
