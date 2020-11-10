package ar.edu.unlam.interfaces;

public interface metodosAlumno {

	public Double consultarPromedioFinal();
	public Double consultarPromedioFinalDeXTrimestre(Integer trimestre);
	public String obtenerReporteDeNotasPorTrimestre();
	public String obtenerReporteDeNotasFinales();
	
}
