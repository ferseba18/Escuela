package ar.edu.unlam.escuela;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.personas.Alumno;
import ar.edu.unlam.personas.Director;
import ar.edu.unlam.personas.Profesor;

public class escuelaTest {

	@Test
	public void testQueSeCargueLaNotaEnElTrismestreQueCorresponde() {
		Materia materia =new Materia(12, "Lengua");
		Profesor profesor =new Profesor(12345678, "Profe");
		Alumno alumno =new Alumno(43445028,"Esteban");
		Notas nota =new Notas(materia, 7);
		
		assertTrue(profesor.cargarNotaAAlumno(alumno, 1, nota));
		assertFalse(profesor.cargarNotaAAlumno(alumno, 2, nota));
		assertFalse(profesor.cargarNotaAAlumno(alumno, 3, nota));
	}
	
	@Test
	public void testQueAgregaAlumno() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);

		Alumno a=new Alumno(43445028,"Esteban");

		Boolean VE = true;
		Boolean VO= e.agregarAlumno(a);
		assertEquals(VE,VO);
	}
	@Test
	public void testQueBuscaAlumno() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);

		Alumno a2=new Alumno(38742362,"Marcelo");
		
		e.agregarAlumno(a2);
		
		Alumno VE=a2;
		Alumno VO=e.buscarAlumno(a2);
		assertEquals(VE,VO);
	}
	
	@Test
	public void testQueBuscaAlumnoPorDNI() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);

		Alumno a=new Alumno(43445028,"Esteban");

		e.agregarAlumno(a);
		
		Alumno VE=a;
		Alumno VO=e.buscarAlumno(a);
		assertEquals(VE,VO);
	}
	
	@Test
	public void testQueEliminaAlumno() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);

		Alumno a=new Alumno(43445028,"Esteban");

		e.agregarAlumno(a);
		
		Boolean VE=true;
		Boolean VO=e.eliminarAlumno(a);
		assertEquals(VE,VO);
	}
	
	@Test
	public void testQueEliminaAlumnoPorDNI() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);

		Alumno a=new Alumno(43445028,"Esteban");

		e.agregarAlumno(a);

		Boolean VE=true;
		Boolean VO=e.eliminarAlumno(a);
		assertEquals(VE,VO);
		
	}
	@Test
	public void testQueAgregaProfe() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);
		
		Profesor p1=new Profesor(1572328, "Profe1");
	
		Boolean VE = true;
		Boolean VO=e.agregarProfe(p1);
		assertEquals(VE,VO);
		
	}
	@Test
	public void testQueBuscaProfe() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);
	

		Profesor p1=new Profesor(1572328, "Profe1");
		
		e.agregarProfe(p1);

			
		Profesor VE = p1;
		Profesor VO=e.buscarProfesor(p1);
		assertEquals(VE,VO);
	}
	@Test
	public void testQueBuscaProfePorDNI() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);
	
		Profesor p=new Profesor(12345678, "Profe");
		e.agregarProfe(p);

		Profesor VE = p;
		Profesor VO=e.buscarProfesor(p.getDni());
		assertEquals(VE,VO);
	}
	
	@Test
	public void testQueEliminaProfe() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);

		Profesor p1=new Profesor(1572328, "Profe");
		
		e.agregarProfe(p1);

		Boolean VE = true;
		Boolean VO=e.eliminarProfesor(p1);
		assertEquals(VE,VO);
	}
	@Test
	public void testQueEliminaProfePorDNI() {
		Director d= new Director(15205201,"Pedro Pascuas");
		Escuela e= new Escuela("PeritoMoreno", d);

		Profesor p1=new Profesor(1572328, "Profe1");

		
		e.agregarProfe(p1);
		
		Boolean VE = true;
		Boolean VO=e.eliminarProfesor(p1.getDni());
		assertEquals(VE,VO);
		
	}

}
