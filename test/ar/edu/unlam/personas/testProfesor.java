package ar.edu.unlam.personas;

import ar.edu.unlam.escuela.Materia;
import ar.edu.unlam.escuela.Notas;
import static org.junit.Assert.*;


import org.junit.Test;

public class testProfesor {

	@Test
	public void queSePuedaCrearProfesor() {
		Profesor profesor = new Profesor(98765432, "Skiner");
		
		String nombre = "Skiner";
		Integer dni = 98765432;
		
		assertEquals(nombre, profesor.getNombre());
		assertEquals(dni, profesor.getDni());
	}
	
	@Test
	public void queSePuedaCargarNotaAUnAlumno() {
		Profesor profesor = new Profesor(98765432, "Skiner");
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia historia = new Materia(3, "Historia");
		Notas nota1erTrimestre = new Notas(historia, 8);
		
		Boolean valorObtenido = profesor.cargarNotaAAlumno(alumno, 1, nota1erTrimestre);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaCargarNotaFinalAUnAlumno() {
		Profesor profesor = new Profesor(98765432, "Skiner");
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia historia = new Materia(3, "Historia");
		Notas notaFinal = new Notas(historia, 8);
		
		Boolean valorObtenido = profesor.cargarNotaAAlumno(alumno, 1, notaFinal);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaEliminarNotaXTrimestre() {
		Profesor profesor = new Profesor(98765432, "Skiner");
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia historia = new Materia(3, "Historia");
		Notas notaFinal = new Notas(historia, 8);
		
		profesor.cargarNotaAAlumno(alumno, 1, notaFinal);
		Boolean valorObtenido = profesor.eliminarNotaPorTrimestre(alumno, 1, notaFinal);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaEliminarNotaFinal() {
		Profesor profesor = new Profesor(98765432, "Skiner");
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia historia = new Materia(3, "Historia");
		Notas notaFinal = new Notas(historia, 8);
		
		profesor.cargarNotaFinalAAlumno(alumno,notaFinal);
		
		Boolean valorObtenido = profesor.eliminarNotaFinal(alumno, notaFinal);
		
		assertTrue(valorObtenido);
	}
}
