package br.com.al.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.al.gerenciador.entity.Db;
import br.com.al.gerenciador.entity.Empresa;
import br.com.al.gerenciador.local.Action;

public class EmpresasAction implements Action{

	public String list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Db banco = new Db();
		List<Empresa> empresas = banco.getEmpresas();

		
		request.setAttribute("empresas", empresas);
		return "foward:listEmpresas.jsp";
	}
	
	public String findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id =Long.valueOf( request.getParameter("id") );
		Db db = new Db();
		Empresa empresa = db.showEmpresaById(id); 		
		request.setAttribute("empresa", empresa);
		return "foward:showEmpresa.jsp";
	
	}
	
	public String viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "foward:formNovaEmpresa.jsp";
	}

	public String create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		return "redirect:main?action=list";
	}

	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		return "redirect:main?action=list";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		Db db = new Db();		
		db.removeEmpresa(id);
		return "redirect:main?action=list";
	}
	
	
}
