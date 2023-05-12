package br.com.al.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Hello
@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out =  resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello World!");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
