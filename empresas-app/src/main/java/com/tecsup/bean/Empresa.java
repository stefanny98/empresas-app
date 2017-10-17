package com.tecsup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//int id;
	String nombre;
	String descripcion;
	
	public static List<Empresa> empresas = new ArrayList<Empresa>();
	
	
	public static void setEmpresas(List<Empresa> empresas) {
		Empresa.empresas = empresas;
	}

	public static List<Empresa> getEmpresas() {
        return empresas;
    }
	
	public static void agregarEmpresa(Empresa empresa){
        empresas.add(empresa);
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/*
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
*/
}
