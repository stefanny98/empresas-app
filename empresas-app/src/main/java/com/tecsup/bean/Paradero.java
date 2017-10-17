package com.tecsup.bean;

import java.io.Serializable;


public class Paradero implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String nombreParadero;
	String nombreEmpresa;
	
	
	public String getNombreParadero() {
		return nombreParadero;
	}
	public void setNombreParadero(String nombreParadero) {
		this.nombreParadero = nombreParadero;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	
	
}
