package br.com.al.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.al.gerenciador.entity.Db;
import br.com.al.gerenciador.entity.Empresa;


@WebServlet("/updateEmpresa")
public class UpdateEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("data");
		Date dtEmpresa = null;
		Db db = new Db();
		Empresa emp = db.showEmpresaById(id);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			dtEmpresa = sdf.parse(data);
		} catch (ParseException e) {			
			throw new ServletException(e);
		}
		emp.setDataAbertura(dtEmpresa);
		emp.setNome(nomeEmpresa);
		response.sendRedirect("listEmpresas");
	}

}
