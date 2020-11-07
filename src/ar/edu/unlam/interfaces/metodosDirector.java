package ar.edu.unlam.interfaces;

import java.util.HashSet;

import ar.edu.unlam.escuela.Curso;
import ar.edu.unlam.escuela.Notas;
import ar.edu.unlam.personas.Alumno;

public interface metodosDirector {
	public Boolean agregarAlumnoACurso(Curso curso, Alumno alumno);
	public Boolean agregarAlumnosACurso(Curso curso, HashSet<Alumno> alumnos);
	public Boolean cargarNota(Alumno alumno, Integer trimestre, Notas nota);
	public Boolean modificarNotas(Alumno alumno,Notas notaVieja,Notas notaNueva);
}
