package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PosicionDron;

public class MovimientoDerecha extends MovimientoDron {

	@Override
	public PosicionDron mover(PosicionDron posicionDron) {
		PosicionDron pos = posicionDron;
		posicionDron.setPuntoCardinal(super.calcularDireccion(posicionDron.getPuntoCardinal(), 1));
		return pos;
	}
}
