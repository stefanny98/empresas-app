package com.tecsup.bean;

import java.io.Serializable;

public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String nombre;
	String descripcion;
	
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
	
	

}
