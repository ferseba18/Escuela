package ar.edu.unlam.escuela;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import ar.edu.unlam.personas.Alumno;
import ar.edu.unlam.personas.Profesor;
import junit.framework.Assert;

public class CursoTest {

	@Test
	public void testQueDevuelveProfesor() {
		Curso c=new Curso("4C");
		Materia m=new Materia(13, "Matematica");
		Profesor p=new Profesor(12376521, "leandro");
		Profesor p1=new Profesor(12314258, "Marcela");
		Profesor p2=new Profesor(17812854, "Javier");
		
		Object VE = p;
		Object VO= c.bucarProfeEnCursoXDni(12376521);
		assertEquals(VE, VO);
}
	public void testQuebuscarProfeEnCurso() {
		Curso c=new Curso("4C");
		Materia m=new Materia(13, "Matematica");
		Profesor p=new Profesor(12376521, "leandro");
		Profesor p1=new Profesor(12314258, "Marcela");
		Profesor p2=new Profesor(17812854, "Javier");
		Object VE= p;
		Object VO=c.buscarProfeEnCurso(p);
		assertEquals(VE, VO);
	}
	public void testQueBuscaMateriaPorID() {
		Curso c=new Curso("4C");
		Materia m=new Materia(13, "Matematica");
		Materia m1=new Materia(12, "Geografia");
		Materia m2=new Materia(11, "Historia");
		Profesor p=new Profesor(12314258, "Marcela");
        Materia VE=null;
        Materia VO=c.buscarMateriaXId(m.getIdMateria());
        assertEquals(VE,VO);
	}
	public void testQueBuscaMateria() {
		Curso c=new Curso("4C");
		Materia m=new Materia(13, "Matematica");
		Materia m1=new Materia(12, "Geografia");
		Materia m2=new Materia(11, "Historia");
		Profesor p=new Profesor(12314258, "Marcela");
		Materia VE=null;
        Materia VO=c.buscarMateria(m); 
        assertEquals(VE,VO);
	}
	
	public void testQueBorraMateria() {
		Curso c=new Curso("4C");
		Materia m=new Materia(13, "Matematica");
		Materia m1=new Materia(12, "Geografia");
		Materia m2=new Materia(11, "Historia");
		Profesor p=new Profesor(12314258, "Marcela");
		Boolean VE=true;
        Boolean VO=c.eliminarMateria(m1); 
        assertEquals(VE,VO);
	}
	public void testQueAgregaMateria() {
		Curso c=new Curso("4C");
		Materia m=new Materia(13, "Matematica");
		Materia m1=new Materia(12, "Geografia");
		Materia m2=new Materia(11, "Historia");
		Profesor p=new Profesor(12314258, "Marcela");
		Boolean VE=true;		
		Materia m3=new Materia(22,"Psicologia");
        Boolean VO=c.agregarMateria(m3); 
        assertEquals(VE,VO);
	}
	public void testQueBuscaAlumnoPorDNI() {
		Curso c=new Curso("4C");
		Materia m=new Materia(12, "Geografia");
		Profesor p=new Profesor(12314258, "Marcela");
		Alumno a=new Alumno(32432456, "Sofia");
		Alumno a1=new Alumno(32472345, "Marcelo");
		Alumno a2=new Alumno(31794379, "Juan");
		Object VE=a;
		Object VO=c.buscarAlumnoXDni(a.getDni());
		assertEquals(VE,VO);
	}
	public void testQueBorraAlumno() {
		Curso c=new Curso("4C");
		Materia m=new Materia(12, "Geografia");
		Profesor p=new Profesor(12314258, "Marcela");
		Alumno a=new Alumno(32432456, "Sofia");
		Alumno a1=new Alumno(32472345, "Marcelo");
		Alumno a2=new Alumno(31794379, "Juan");
		Boolean VE=true;
        Boolean VO=c.eliminarAlumno(a1); 
        assertEquals(VE,VO);
	}
	public void testQueAgregeAlumno() {
		Curso c=new Curso("4C");
		Materia m=new Materia(12, "Geografia");
		Profesor p=new Profesor(12314258, "Marcela");
		Alumno a=new Alumno(32432456, "Sofia");
		Alumno a1=new Alumno(32472345, "Marcelo");
		Alumno a2=new Alumno(31794379, "Juan");
		Alumno a3=new Alumno(22589543, "Nicolas");
		Boolean VE=true;
        Boolean VO=c.agregarAlumno(a3); 
        assertEquals(VE,VO);
	}
	
}
