package ar.edu.unlam.interfaces;

public interface metodosAlumno {

	public Double consultarPromedioFinal();
	public Double consultarPromedioFinalDeXTrimestre(Integer trimestre);
	public String obtenerReporteDeNotas();
	public String obtenerReporteDeNotasDeTodosTrimestre();
	
}
