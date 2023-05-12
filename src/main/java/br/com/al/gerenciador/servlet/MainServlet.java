package br.com.al.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.al.gerenciador.local.Action;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String callBackAction = null;
		
		try {
			Class classGeneric = Class.forName("br.com.al.gerenciador.action.EmpresasAction" );
			Action act = (Action) classGeneric.newInstance();
			Method method = act.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			callBackAction = (String) method.invoke(act, request,response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		String[] actionCompletyArray = callBackAction.split(":");
		if(actionCompletyArray[0].equals("foward")) {			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + actionCompletyArray[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(actionCompletyArray[1]);
		}
	}

}
