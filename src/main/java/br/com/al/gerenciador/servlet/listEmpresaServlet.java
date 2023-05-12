package br.com.al.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.al.gerenciador.entity.Db;
import br.com.al.gerenciador.entity.Empresa;

/**
 * Servlet implementation class listEmpresaServlet
 */
@WebServlet("/listEmpresas")
public class listEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Db banco = new Db();
		List<Empresa> empresas = banco.getEmpresas();

		RequestDispatcher rd =  request.getRequestDispatcher("/listEmpresas.jsp");
		request.setAttribute("empresas", empresas);
		rd.forward(request, response);

	}

}
