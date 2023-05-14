package br.com.al.gerenciador.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Db {
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static Long sequencialId = 1L;
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Db.sequencialId++);
		empresa.setNome("Alura");
		empresa.setDataAbertura(new Date());
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(new Date());
		empresa2.setId(Db.sequencialId++);
		Db.empresas.add(empresa);
		Db.empresas.add(empresa2);
		
		User u1 = new User();
		u1.setLogin("gabriel");
		u1.setSenha("123456");
		
		User u2 = new User();
		u2.setLogin("ana");
		u2.setSenha("123456");
		
		Db.users.add(u1);
		Db.users.add(u2);
	}
	
	public static <T> Collector<T, ?, T> toSingleton() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if (list.size() != 1) {
	                    return null;
	                }
	                return list.get(0);
	            }
	    );
	}
	
	public void add(Empresa emp) {
		emp.setId(Db.sequencialId++);
		Db.empresas.add(emp);
	}
	public static List<Empresa> getEmpresas() {
		return Db.empresas;
	}
	
	public static void removeEmpresa(Long id) {
		Db.getEmpresas().removeIf(emp -> emp.getId().equals(id));
	}
	public Empresa showEmpresaById(Long id) {
		return Db.empresas.stream().filter(emp -> emp.getId().equals(id)).collect(toSingleton());
	}

	public User existUser(String login, String password) {
		
		return Db.users.stream().filter(us -> (us.getLogin().equals(login) && us.getSenha().equals(password))).collect(toSingleton());
	}

}
