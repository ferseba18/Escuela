package ar.edu.unlam.interfaces;

import ar.edu.unlam.escuela.Notas;
import ar.edu.unlam.personas.Alumno;

public interface metodosProfesor {
	public Boolean cargarNotaAAlumno(Alumno alumno, Integer trimestre, Notas nota);
	public Boolean cargarNotaFinalAAlumno(Alumno alumno, Notas nota);
	public Boolean eliminarNotaPorTrimestre(Alumno alumno, Integer trimestre, Notas nota);
	public Boolean eliminarNotaFinal(Alumno alumno, Notas nota);
		

}
