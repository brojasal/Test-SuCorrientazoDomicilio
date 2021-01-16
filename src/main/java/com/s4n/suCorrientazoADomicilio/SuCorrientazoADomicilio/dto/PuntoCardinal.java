package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto;

public enum PuntoCardinal {
	NORTE("Direccion Norte",'N',1,"VERTICAL"),
	ORIENTE("Direccion Oriente", 'E',1,"HORIZONTAL"),
	SUR("Direccion Sur",'S',-1,"VERTICAL"),
	OCCIDENTE("Direccion Occidente", 'W',-1,"HORIZONTAL");
	
	private String nombre;
	private char sigla;
	private int magnitud;
	private String direccion;
	
	private PuntoCardinal(String nombre, char sigla, int magnitud, String direccion){
		this.nombre = nombre;
		this.sigla = sigla;
		this.magnitud = magnitud;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSigla() {
		return sigla;
	}

	public void setSigla(char sigla) {
		this.sigla = sigla;
	}

	public int getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(int magnitud) {
		this.magnitud = magnitud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
