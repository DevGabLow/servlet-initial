package br.com.al.gerenciador.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Db {
	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setDataAbertura(new Date());
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(new Date());
		Db.empresas.add(empresa);
		Db.empresas.add(empresa2);
	}
	
	public void add(Empresa emp) {
		Db.empresas.add(emp);
	}
	public static List<Empresa> getEmpresas() {
		return Db.empresas;
	}

}
