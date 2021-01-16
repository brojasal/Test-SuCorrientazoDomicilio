package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.Archivo;

public class ProcesoArchivoPlano extends ProcesoArchivo{

	@Override
	public List<?> leerArchivo(File archivo) {
		List<String> contenidoArchivo = new ArrayList<String>();
		String linea = "";
		
		try {
			//super.setIdentificador(archivo.getCanonicalPath());
			FileReader inp = new FileReader(archivo);
			BufferedReader br = new BufferedReader(inp);
			while((linea=br.readLine())!=null){
				contenidoArchivo.add(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contenidoArchivo;
	}

	@Override
	public void escribirArchivo(Archivo archivo) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivo.getRuta().replaceFirst("ArchivosEntrada", "ArchivosSalida")
            			.replaceFirst("in", archivo.getPREFIJOSALIDA()).
            			replaceFirst("IN", archivo.getPREFIJOSALIDA()));
            pw = new PrintWriter(fichero);

            for (int i = 0; i < archivo.getContenidoArchivoSalida().size(); i++)
                pw.println(archivo.getContenidoArchivoSalida().get(i));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}

	@Override
	public Archivo cargarArchivo(String pathArchivo) {
		Archivo archivo = new Archivo();
		ProcesoArchivoPlano procesoArchivoPlano = new ProcesoArchivoPlano();
		archivo.setRuta(pathArchivo);
		File file = new File(pathArchivo);
		archivo.setContenidoArchivoEntrada(procesoArchivoPlano.leerArchivo(file));
		return archivo;
	}
	
	
}
