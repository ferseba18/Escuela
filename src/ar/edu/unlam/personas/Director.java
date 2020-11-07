package ar.edu.unlam.personas;

import java.util.HashSet;

import ar.edu.unlam.escuela.Curso;
import ar.edu.unlam.escuela.Notas;
import ar.edu.unlam.interfaces.metodosDirector;

public class Director extends Persona implements metodosDirector{

	public Director(Integer dni, String nombre) {
		super(dni, nombre);
	}

	@Override
	public Boolean agregarAlumnoACurso(Curso curso, Alumno alumno) {
		// TODO Auto-generated method stub
		return curso.getListaAlumnos().add(alumno);
	}

	@Override
	public Boolean agregarAlumnosACurso(Curso curso, HashSet<Alumno> alumnos) {
		// TODO Auto-generated method stub
		return curso.getListaAlumnos().addAll(alumnos);
	}

	@Override
	public Boolean modificarNotas(Alumno alumno,Notas notaVieja, Notas notaNueva) {
		Boolean check=alumno.getPrimerTrimestre().contains(notaVieja);
		Boolean check2=alumno.getSegundoTrimestre().contains(notaVieja);
		Boolean check3=alumno.getTercerTrimestre().contains(notaVieja);
		
		Boolean seElimino=false;
		
		if (check) {
			alumno.getPrimerTrimestre().remove(notaVieja);
			alumno.getPrimerTrimestre().add(notaNueva);
			seElimino=true;
		}
		
		if(check2) {
			alumno.getSegundoTrimestre().remove(notaVieja);
			alumno.getSegundoTrimestre().add(notaNueva);
			seElimino=true;
		}
		
		if(check3) {
			alumno.getTercerTrimestre().remove(notaVieja);
			alumno.getTercerTrimestre().add(notaNueva);
			seElimino=true;
		}
		
		
		return seElimino;
	}

	
	@Override
	public Boolean cargarNota(Alumno alumno, Integer trimestre, Notas nota) {
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

	

	
	
}
