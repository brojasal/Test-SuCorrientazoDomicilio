package com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.negocio;

import java.io.File;
import java.util.List;

import com.s4n.suCorrientazoADomicilio.SuCorrientazoADomicilio.dto.Archivo;

public abstract class ProcesoArchivo extends Archivo{
	
	public abstract List<?> leerArchivo(File archivo);
	
	public abstract void escribirArchivo(Archivo archivo);
	
	public abstract Archivo cargarArchivo(String pathArchivo);
}
