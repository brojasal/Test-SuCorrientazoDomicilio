package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio;

import java.io.File;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio.Entrega;


/**
 * Hello world!
 *
 */
public class App 
{

	
    public static void main( String[] args )
    	{
        Entrega entrega = new Entrega();
        final File carpeta = new File("ArchivosEntrada\\");
        entrega.procesarArchivos(carpeta);
    }
}
