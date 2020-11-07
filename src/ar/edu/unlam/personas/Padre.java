package ar.edu.unlam.personas;

import ar.edu.unlam.interfaces.metodosAlumno;

								 //Implementa mismos metodos que alumno ya que los dos 
								 //en el diseno de la clase ambos tienen las mismas funciones de solo
								 //Visualizar y no modificar NADA
public class Padre extends Persona implements metodosAlumno{
	private Alumno hijo;
	
	
	public Padre(Integer dni, String nombre, Alumno hijo) {
		super(dni, nombre);
		this.hijo=hijo;
	}
	
	@Override
	public Double consultarPromedioFinal() {
		return this.hijo.consultarPromedioFinal();
	}

	@Override
	public Double consultarPromedioFinalDeXTrimestre(Integer trimestre) {
		return this.hijo.consultarPromedioFinalDeXTrimestre(trimestre);
	}

	@Override
	public String obtenerReporteDeNotas() {
		return this.hijo.obtenerReporteDeNotas();
	}

	@Override
	public String obtenerReporteDeNotasDeTodosTrimestre() {
		return this.obtenerReporteDeNotasDeTodosTrimestre();
	}


}
