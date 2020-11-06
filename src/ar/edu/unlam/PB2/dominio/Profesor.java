package ar.edu.unlam.PB2.dominio;

import java.util.HashSet;

public class Profesor extends Persona{

	private HashSet <Materia> materias= new HashSet<> ();
	private HashSet <Curso> cursos= new HashSet<> ();
	private HashSet <Calificacion> calificaciones= new HashSet<>();
	private HashSet <Alumno> alumnos= new HashSet<> ();
	
	public Profesor(String nombre, String apellido, Integer id, Integer dni) {
		super(nombre, apellido, id, dni);
		
	}
	
	public Boolean agregarNotasAlAlumno(Calificacion calificacion) {
		return this.calificaciones.add(calificacion);  
	}
	
	
}
