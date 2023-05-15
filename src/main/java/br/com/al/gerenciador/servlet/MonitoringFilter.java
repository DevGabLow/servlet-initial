package br.com.al.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/main")
public class MonitoringFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long before = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		String action = request.getParameter("action");
		
		long after = System.currentTimeMillis();
		
		System.out.println("Time request " + action + ": "  + (after - before));
	}

}
