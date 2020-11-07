package ar.edu.unlam.personas;

import ar.edu.unlam.escuela.Notas;
import ar.edu.unlam.interfaces.metodosProfesor;

public class Profesor extends Persona implements metodosProfesor {

	public Profesor(Integer dni, String nombre) {
		super(dni, nombre);
		
	}

	public Boolean cargarNotaAAlumno(Alumno alumno, Integer trimestre, Notas nota) {
		switch (trimestre) {
		case 1:
			if (!alumno.buscarNotaEnOtrosTrimestres(nota)) {
				return alumno.getPrimerTrimestre().add(nota);
			}
			
		case 2:
			if (!alumno.buscarNotaEnOtrosTrimestres(nota)) {
				return alumno.getSegundoTrimestre().add(nota);
			}
			
		case 3:
			if (!alumno.buscarNotaEnOtrosTrimestres(nota)) {
				return alumno.getTercerTrimestre().add(nota);
			}
		default:
			break;
		}
		return false;
	}
	
	public Boolean cargarNotaFinalAAlumno(Alumno alumno, Notas nota) {
		if (!alumno.buscarNotaEnOtrosTrimestres(nota)) {
			return alumno.getNotasFinales().add(nota);
		}
		return false;
	}
	
	public Boolean eliminarNotaPorTrimestre(Alumno alumno, Integer trimestre, Notas nota) {
		switch (trimestre) {
		case 1:
			return alumno.getPrimerTrimestre().remove(nota);
		case 2:
			return alumno.getSegundoTrimestre().remove(nota);
		case 3:
			return alumno.getTercerTrimestre().remove(nota);
		default:
			break;
		}
		return false;
	}

	public Boolean eliminarNotaFinal(Alumno alumno, Notas nota) {
		return alumno.getNotasFinales().remove(nota);
	}

	
}
