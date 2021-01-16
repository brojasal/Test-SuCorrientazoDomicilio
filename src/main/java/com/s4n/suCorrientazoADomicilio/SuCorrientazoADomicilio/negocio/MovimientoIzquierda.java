package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PosicionDron;

public class MovimientoIzquierda extends MovimientoDron{

	@Override
	public PosicionDron mover(PosicionDron posicionDron) {
		PosicionDron pos = posicionDron;
		//posicionDron.setPosicionX(posicionDron.getPosicionX()-1);
		posicionDron.setPuntoCardinal(super.calcularDireccion(posicionDron.getPuntoCardinal(), -1));
		return pos;
	}

}
