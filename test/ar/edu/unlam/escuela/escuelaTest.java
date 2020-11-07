package ar.edu.unlam.escuela;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.personas.Alumno;
import ar.edu.unlam.personas.Profesor;

public class escuelaTest {

	@Test
	public void test() {
		Materia m=new Materia(12, "Lengua");
		Profesor p=new Profesor(12345678, "Profe");
		Alumno a=new Alumno(43445028,"Esteban");
		Notas n=new Notas(m, 7);
		
		assertTrue(p.cargarNotaAAlumno(a, 1, n));
		assertFalse(p.cargarNotaAAlumno(a, 2, n));
		assertFalse(p.cargarNotaAAlumno(a, 3, n));
		//Queria chequear que no se cargue la misma nota en distintos trimestres
	}

}
