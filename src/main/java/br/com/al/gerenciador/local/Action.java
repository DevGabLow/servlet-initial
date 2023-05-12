package br.com.al.gerenciador.local;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public String list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public String create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public String viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
