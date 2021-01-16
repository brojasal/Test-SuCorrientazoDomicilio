package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto;

import java.util.List;

public class Archivo {
	
	private static String PREFIJOSALIDA = "out";
	private String ruta;
	private List<?> contenidoArchivoEntrada;
	private List<?> contenidoArchivoSalida;
	
	public String getPREFIJOSALIDA() {
		return PREFIJOSALIDA;
	}
	public static void setPREFIJOSALIDA(String pREFIJOSALIDA) {
		PREFIJOSALIDA = pREFIJOSALIDA;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public List<?> getContenidoArchivoEntrada() {
		return contenidoArchivoEntrada;
	}
	public void setContenidoArchivoEntrada(List<?> contenidoArchivoEntrada) {
		this.contenidoArchivoEntrada = contenidoArchivoEntrada;
	}
	public List<?> getContenidoArchivoSalida() {
		return contenidoArchivoSalida;
	}
	public void setContenidoArchivoSalida(List<?> contenidoArchivoSalida) {
		this.contenidoArchivoSalida = contenidoArchivoSalida;
	}
	
	
}
