package br.com.al.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.al.gerenciador.local.Action;


public class ControllerFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String action = request.getParameter("action");

		String callBackAction = null;

		try {
			Class classGeneric = Class.forName("br.com.al.gerenciador.action.MainAction");
			Action act = (Action) classGeneric.newInstance();
			Method method = act.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			callBackAction = (String) method.invoke(act, request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		String[] actionCompletyArray = callBackAction.split(":");
		if (actionCompletyArray[0].equals("foward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + actionCompletyArray[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(actionCompletyArray[1]);
		}
	}

}
