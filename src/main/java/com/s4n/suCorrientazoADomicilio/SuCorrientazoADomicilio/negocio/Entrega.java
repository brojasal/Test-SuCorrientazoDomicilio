package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.Archivo;
import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PosicionDron;
import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.PuntoCardinal;
import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.exception.ExcepcionPersonalizada;

public class Entrega {
	
	MovimientoAdelante movimientoAdelante = new MovimientoAdelante();
	MovimientoDerecha movimientoDerecha = new MovimientoDerecha();
	MovimientoIzquierda movimientoIzquierda = new MovimientoIzquierda();
	
	public PosicionDron fijarPoscionInicial(){
		PosicionDron posicionInicial = new PosicionDron();
		posicionInicial.setPosicionX(0);
		posicionInicial.setPosicionY(0);
		posicionInicial.setPuntoCardinal(PuntoCardinal.NORTE);
		return posicionInicial;
		
	}
		
	public PosicionDron avanzar(char movimiento, PosicionDron posicionActual){

		PosicionDron posicionDron  = posicionActual;
		switch (movimiento) {
		case 'A':
			posicionDron = movimientoAdelante.mover(posicionDron);
			break;
		case 'D':
			posicionDron = movimientoDerecha.mover(posicionDron);
			break;
		case 'I':
			posicionDron = movimientoIzquierda.mover(posicionDron);
		default:
			break;
		}
		return posicionDron;
	}

	public PosicionDron entregarPedido(String ruta, PosicionDron posicionDron) throws ExcepcionPersonalizada{
		if(!Pattern.matches("^[AIDaid]*",ruta)){
			throw new ExcepcionPersonalizada("No se ejecuta la ruta por caracter invalido", new Throwable("Caracteres invalidos")) ;
		}
		ruta = ruta.toUpperCase();
		for(int i=0; i<ruta.length();i++ ){
			posicionDron = this.avanzar(ruta.charAt(i), posicionDron);			
		}
		return posicionDron;
	}
	public Archivo realizarProcesoEntrega(String pathArchivo){
		System.out.println(pathArchivo);
		ProcesoArchivoPlano procesoArchivoPlano = new ProcesoArchivoPlano();
		Archivo archivo = new Archivo();
		archivo=procesoArchivoPlano.cargarArchivo(pathArchivo);
		archivo.setRuta(pathArchivo);
		String lineaSalida = "== Reporte de entregas ==";
		List<String> datosSalida = new ArrayList<String>();
		datosSalida.add(lineaSalida);
		String ruta = "";
		PosicionDron posicionDron  = fijarPoscionInicial();
		for(int i = 0; i<archivo.getContenidoArchivoEntrada().size(); i++){
			ruta = (String)archivo.getContenidoArchivoEntrada().get(i);
			try {
				posicionDron = entregarPedido(ruta, posicionDron);
				lineaSalida = "("+posicionDron.getPosicionX()+","+posicionDron.getPosicionY()+") "+posicionDron.getPuntoCardinal().getNombre();
			} catch (ExcepcionPersonalizada e) {
				lineaSalida = "("+posicionDron.getPosicionX()+","+posicionDron.getPosicionY()+") "+e.getMessage();
			}
			
			datosSalida.add(lineaSalida);
		}
		
		archivo.setContenidoArchivoSalida(datosSalida);
		return archivo;
	}
	
	public void procesarArchivos(File carpeta){
		for (final File ficheroEntrada : carpeta.listFiles()) {
	        if (ficheroEntrada.isDirectory()) {
	        	procesarArchivos(ficheroEntrada);
	        } else {
	            Archivo archivo = this.realizarProcesoEntrega(ficheroEntrada.toString());
	    		ProcesoArchivoPlano procesoArchivoPlano = new ProcesoArchivoPlano();
	    		procesoArchivoPlano.escribirArchivo(archivo);
	        }
	    }
	}
}
