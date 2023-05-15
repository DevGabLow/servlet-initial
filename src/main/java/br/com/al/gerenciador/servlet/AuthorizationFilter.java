package br.com.al.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/main")
public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		boolean userIsLogged = !(session.getAttribute("user") == null);
		boolean pageNotProtected = !(action.equals("login") || action.equals("viewLogin"));
		if (!userIsLogged && pageNotProtected) {
			response.sendRedirect("main?action=viewLogin");
			return;
		}

		chain.doFilter(request, response);

	}

}
