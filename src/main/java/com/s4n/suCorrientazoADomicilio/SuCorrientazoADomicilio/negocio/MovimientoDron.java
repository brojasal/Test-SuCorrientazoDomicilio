package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PosicionDron;
import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PuntoCardinal;


public abstract class MovimientoDron{
	PuntoCardinal[] puntosCardinales;
	public MovimientoDron() {
		puntosCardinales = PuntoCardinal.values();
	}
	public abstract PosicionDron mover(PosicionDron posicionDron);
	
	public PuntoCardinal calcularDireccion(PuntoCardinal puntoCardinal, int giro){
		PuntoCardinal nuevaDireccion;
		int direccionActual = puntoCardinal.ordinal();
		if(direccionActual+giro > puntosCardinales.length-1){
			nuevaDireccion = puntosCardinales[0];
		}else if(direccionActual+giro < 0){
			nuevaDireccion = puntosCardinales[puntosCardinales.length-1];
		}else{
			nuevaDireccion = puntosCardinales[direccionActual+giro];
		}
		return nuevaDireccion;
	}
}
