package ar.edu.unlam.personas;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import ar.edu.unlam.escuela.Curso;
import ar.edu.unlam.escuela.Materia;
import ar.edu.unlam.escuela.Notas;

public class testDirector {

	@Test
	public void queSePuedaCrearUnDirector() {
		Director director = new Director(65432178, "Archundia");
		
		String nombre = "Archundia";
		Integer dni = 65432178;
		
		assertEquals(nombre, director.getNombre());
		assertEquals(dni, director.getDni());
	}

	@Test
	public void queSePuedaAgregarAlumnoAUnCurso() {
		Director director = new Director(65432178, "Archundia");
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Curso curso = new Curso("1ro A");
		
		Boolean valorObtenido = director.agregarAlumnoACurso(curso, alumno);
		
		assertTrue(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarAlumnosAUnCurso() {
		Director director = new Director(65432178, "Archundia");
		Alumno alumno1 = new Alumno(40950675, "Alejandro");
		Alumno alumno2 = new Alumno(12345678, "El");
		Alumno alumno3 = new Alumno(98765432, "Barto");
		Curso curso = new Curso("1ro A");
		HashSet<Alumno> listaAlumnos = new HashSet<>();
		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		
		Boolean valorObtenido = director.agregarAlumnosACurso(curso, listaAlumnos);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaCargarNota() {
		Director director = new Director(65432178, "Archundia");
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia matematicas = new Materia(3, "Matematicas");
		Notas nota = new Notas(matematicas, 8);
		
		Boolean valorObtenido = director.cargarNota(alumno, 1, nota);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaModificarNota() {
		Director director = new Director(65432178, "Archundia");
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia matematicas = new Materia(3, "Matematicas");
		Notas notaVieja = new Notas(matematicas, 7);
		Notas notaNueva = new Notas(matematicas, 8);
		director.cargarNota(alumno, 1, notaVieja);
		
		Boolean valorObtenido = director.modificarNotas(alumno, notaVieja, notaNueva);
		
		assertTrue(valorObtenido);
	}
	
}
