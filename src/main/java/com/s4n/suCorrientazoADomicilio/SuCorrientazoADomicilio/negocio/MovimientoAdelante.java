package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PosicionDron;

public class MovimientoAdelante extends MovimientoDron{

	@Override
	public PosicionDron mover(PosicionDron posicionDron) {
		PosicionDron pos = posicionDron;
		if(posicionDron.getPuntoCardinal().getDireccion().equals("VERTICAL"))
			posicionDron.setPosicionY(posicionDron.getPosicionY() + posicionDron.getPuntoCardinal().getMagnitud());	
		else
			posicionDron.setPosicionX(posicionDron.getPosicionX() + posicionDron.getPuntoCardinal().getMagnitud());
		return pos;
	}

}
