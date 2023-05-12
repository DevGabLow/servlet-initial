package br.com.al.gerenciador.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Db {
	private static List<Empresa> empresas = new ArrayList<>();
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
	}
	
	public static <T> Collector<T, ?, T> toSingleton() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if (list.size() != 1) {
	                    throw new IllegalStateException();
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

}
