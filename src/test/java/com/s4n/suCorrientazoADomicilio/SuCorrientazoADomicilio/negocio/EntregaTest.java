package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PosicionDron;
import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PuntoCardinal;
import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.exception.ExcepcionPersonalizada;

import junit.framework.TestCase;

public class EntregaTest extends TestCase{
	
	private Entrega entrega;
	
	public EntregaTest() {
		// TODO Auto-generated constructor stub
		entrega = new Entrega();
	}
	
	public void testAvanzarAdelante(){
		PosicionDron posicionInicial = entrega.fijarPoscionInicial();		
		PosicionDron posicionFinal = entrega.fijarPoscionInicial();
		posicionFinal.setPosicionY(1);
		
		posicionInicial = entrega.avanzar('A', posicionInicial);
		assertEquals(posicionInicial.getPosicionY(), posicionFinal.getPosicionY());	
		assertEquals(posicionInicial.getPosicionX(), posicionFinal.getPosicionX());
		assertEquals(posicionInicial.getPuntoCardinal(), posicionFinal.getPuntoCardinal());
		
	}
	
	public void testAvanzarDerecha(){
		PosicionDron posicionInicial = entrega.fijarPoscionInicial();		
		PosicionDron posicionFinal = entrega.fijarPoscionInicial();
		posicionFinal.setPuntoCardinal(PuntoCardinal.ORIENTE);
		
		posicionInicial = entrega.avanzar('D', posicionInicial);
		assertEquals(posicionInicial.getPosicionY(), posicionFinal.getPosicionY());	
		assertEquals(posicionInicial.getPosicionX(), posicionFinal.getPosicionX());
		assertEquals(posicionInicial.getPuntoCardinal(), posicionFinal.getPuntoCardinal());
		
	}
	
	public void testAvanzarIzquierda(){
		PosicionDron posicionInicial = entrega.fijarPoscionInicial();		
		PosicionDron posicionFinal = entrega.fijarPoscionInicial();
		posicionFinal.setPuntoCardinal(PuntoCardinal.OCCIDENTE);
		
		posicionInicial = entrega.avanzar('I', posicionInicial);
		assertEquals(posicionInicial.getPosicionY(), posicionFinal.getPosicionY());	
		assertEquals(posicionInicial.getPosicionX(), posicionFinal.getPosicionX());
		assertEquals(posicionInicial.getPuntoCardinal(), posicionFinal.getPuntoCardinal());
		
	}
	
	public void testEntregarPedido(){
		PosicionDron posicionFinal = entrega.fijarPoscionInicial();
		posicionFinal.setPosicionX(-2);
		posicionFinal.setPosicionY(4);
		posicionFinal.setPuntoCardinal(PuntoCardinal.OCCIDENTE);
		
		PosicionDron posicionInicial = entrega.fijarPoscionInicial();
		try {
			posicionInicial = entrega.entregarPedido("AAAAIAA", posicionInicial);
		} catch (ExcepcionPersonalizada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(posicionInicial.getPosicionY(), posicionFinal.getPosicionY());	
		assertEquals(posicionInicial.getPosicionX(), posicionFinal.getPosicionX());
		assertEquals(posicionInicial.getPuntoCardinal(), posicionFinal.getPuntoCardinal());
		
	}
}
