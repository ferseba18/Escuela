import java.util.HashSet;

import org.junit.Test;

import ar.edu.unlam.escuela.Curso;
import ar.edu.unlam.escuela.Materia;
import ar.edu.unlam.personas.Alumno;
import ar.edu.unlam.personas.Profesor;
import junit.framework.Assert;

public class CursoTest {

	@Test
	public void testQueDevuelveProfesor() {
		Curso c=new Curso("4C");
		
		Profesor p=new Profesor(12376521, "leandro");		
		Materia m=new Materia(13, "Matematica",p);
		
		c.agregarMateria(m);
		
		Object VE =p ;
		Object VO= c.bucarProfeEnCursoXDni(12376521);
		assertEquals(VE, VO);
	}
	
	@Test
	public void testQuebuscarProfeEnCurso() {
		Curso c=new Curso("4C");
	
		Profesor p2=new Profesor(17812854, "Javier");
		Materia m=new Materia(13, "Matematica",p2);
		
		c.agregarMateria(m);
		
		Object VE= p2;
		Object VO=c.buscarProfeEnCurso(p2);
		
		assertEquals(VE, VO);
	}
	
	@Test
	public void testQueBuscaMateriaPorID() {
		Curso c=new Curso("4C");
		
		Profesor p=new Profesor(12314258, "Marcela");
		
		Materia m=new Materia(13, "Matematica",p);
		Materia m1=new Materia(12, "Geografia",p);
		Materia m2=new Materia(11, "Historia",p);
		
		c.agregarMateria(m);
		c.agregarMateria(m1);
		c.agregarMateria(m2);

        Materia VE=m;
        Materia VO=c.buscarMateriaXId(13);
        assertEquals(VE,VO);
	}
	
	@Test
	public void testQueBuscaMateria() {
		Curso c=new Curso("4C");
		
		Materia m=new Materia(13, "Matematica");
		Materia m1=new Materia(12, "Geografia");

		
		c.agregarMateria(m);
		c.agregarMateria(m1);

		
		
		Materia VE=m1;
        Materia VO=c.buscarMateria(m1); 
        assertEquals(VE,VO);
	}
	
	@Test
	public void testQueBorraMateria() {
		Curso c=new Curso("4C");
		Materia m=new Materia(13, "Matematica");

		c.agregarMateria(m);
		
		Boolean VE=true;
        Boolean VO=c.eliminarMateria(m); 
        assertEquals(VE,VO);
	}
	
	@Test
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
	
	@Test
	public void testQueBuscaAlumnoPorDNI() {
		Curso c=new Curso("4C");
		
		Alumno a=new Alumno(32432456, "Sofia");
		Alumno a1=new Alumno(32472345, "Marcelo");
		Alumno a2=new Alumno(31794379, "Juan");
		
		c.agregarAlumno(a);
		c.agregarAlumno(a2);
		c.agregarAlumno(a1);
		
		Object VE=a;
		Object VO=c.buscarAlumnoXDni(a.getDni());
		assertEquals(VE,VO);
	}
	
	@Test
	public void testQueBorraAlumno() {
		Curso c=new Curso("4C");
		
		Profesor p=new Profesor(12314258, "Marcela");
		Materia m=new Materia(12, "Geografia",p);
		
		Alumno a=new Alumno(32432456, "Sofia");
		Alumno a1=new Alumno(32472345, "Marcelo");
		Alumno a2=new Alumno(31794379, "Juan");
		
		c.agregarAlumno(a);
		c.agregarAlumno(a2);
		c.agregarAlumno(a1);
		
		
		Boolean VE=true;
        Boolean VO=c.eliminarAlumno(a1); 
        assertEquals(VE,VO);
	}
	
	@Test
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
