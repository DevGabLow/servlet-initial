package br.com.al.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.al.gerenciador.entity.Db;
import br.com.al.gerenciador.entity.Empresa;

/**
 * Servlet implementation class ShowEmpresa
 */
@WebServlet("/showEmpresa")
public class ShowEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id =Long.valueOf( request.getParameter("id") );
		Db db = new Db();
		Empresa empresa = db.showEmpresaById(id); 
		RequestDispatcher rd = request.getRequestDispatcher("/showEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
	}

}
