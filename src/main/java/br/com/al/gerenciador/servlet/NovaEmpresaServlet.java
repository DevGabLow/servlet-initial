package br.com.al.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.al.gerenciador.entity.Db;
import br.com.al.gerenciador.entity.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("data");
		Date dtEmpresa = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			dtEmpresa = sdf.parse(data);
		} catch (ParseException e) {			
			throw new ServletException(e);
		}
		
		Empresa emp = new Empresa();
		emp.setNome(nomeEmpresa);
		emp.setDataAbertura(dtEmpresa);
		
		Db db = new Db();
		db.add(emp);
		request.setAttribute("empresa", emp.getNome());
		response.sendRedirect("listEmpresas");
	//	RequestDispatcher rd =  request.getRequestDispatcher("/listEmpresas");		
		//rd.forward(request, response);
	}

}
