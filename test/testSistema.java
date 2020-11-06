
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.PB2.dominio.Alumno;
import ar.edu.unlam.PB2.dominio.Calificacion;
import ar.edu.unlam.PB2.dominio.Curso;
import ar.edu.unlam.PB2.dominio.Directivo;
import ar.edu.unlam.PB2.dominio.Escuela;
import ar.edu.unlam.PB2.dominio.Materia;
import ar.edu.unlam.PB2.dominio.Profesor;


public class testSistema {
	
	
	@Test
	public void queSeAgregueUnCursoAunaEscuela(){
		
		//preparación
		Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");		
		Curso curso1=new Curso("A", 1);

		//ejecución
		
		//verificación
		assertTrue(miEscuela.agregarCurso(curso1));
	}

	@Test
	public void QueAgregueProfesorAunCurso () {
		
		Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
		Curso curso1=new Curso("A", 1);
		Materia literatura= new Materia ("literatura", 10);
		Profesor profesor= new Profesor("María", "Perez", 1234, 34567899);
		
		miEscuela.agregarCurso(curso1);
		miEscuela.agregarMateriasACurso(literatura);
		miEscuela.agregarProfesor(profesor);
				
		assertTrue (miEscuela.agregarProfeAunCurso("A", 1, 34567899));	
		assertNotNull(miEscuela.buscarProfesor(34567899));
	}
	
	@Test
	public void QueSeAgreguenAlumnosACurso() {
		
		Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
		Alumno alumno1= new Alumno("Leandro", "Suarez", 2345, 30333555);
		Curso curso1=new Curso("A", 1);
		
		miEscuela.agregarCurso(curso1);
		miEscuela.agregarAlumno(alumno1);
		
		assertTrue(miEscuela.agregarAlumnosAUnCurso(30333555, "A", 1));
	}
	
	@Test
	public void QueSeAgreguenNotasAlAlumno() {
		
		Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
		Alumno alumno1= new Alumno("Leandro", "Suarez", 2345, 30333555);
		Materia literatura= new Materia ("literatura", 10);
		Calificacion prueba= new Calificacion(8.00,1,10);
		Curso curso1=new Curso("A", 1);
		Profesor profesor= new Profesor("María", "Perez", 1234, 34567899);
		
		
		miEscuela.agregarCurso(curso1);
		miEscuela.agregarMateriasACurso(literatura);
		miEscuela.agregarProfesor(profesor);
		miEscuela.agregarAlumno(alumno1);
		miEscuela.agregarNotaAlAlumno(prueba,30333555);
		
		assertTrue(miEscuela.agregarNotaAlAlumnoPor(30333555, 34567899, 10, 8.00, 1));
		
	}	
	@Test
	public void QueSePuedanConsultarNotasPorAlumnoPorTrimestrePorMateria() {
		
		Double nota = 8.00;
		
		Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
		Alumno alumno1= new Alumno("Leandro", "Suarez", 2345, 30333555);
		Materia literatura= new Materia ("literatura", 10);
		Calificacion prueba= new Calificacion(8.00,1,10);
		Curso curso1=new Curso("A", 1);
		Profesor profesor= new Profesor("María", "Perez", 1234, 34567899);
		
		miEscuela.agregarCurso(curso1);
		miEscuela.agregarMateriasACurso(literatura);
		miEscuela.agregarProfesor(profesor);
		miEscuela.agregarAlumno(alumno1);
		miEscuela.agregarNotaAlAlumno(prueba,30333555);
		
		ArrayList<Calificacion> calificaciones = miEscuela.consultarNotas(34567899, 30333555, 1, 10);
		
		for(Calificacion calificacion: calificaciones) {
			assertEquals(nota,calificacion.getNotaParcial());
		}
	}
	
	
     @Test
     public void QueSePuedaCalcularNotaTrimestrePorMateria() {
    	 
    	
		Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
		Alumno alumno1= new Alumno("Leandro", "Suarez", 2345, 30333555);
		Materia literatura= new Materia ("literatura", 10);
		Calificacion prueba= new Calificacion(8.00,1,10);
		Calificacion prueba2=new Calificacion(6.00,1,10);
		Calificacion prueba3=new Calificacion(7.00,1,10);
		Curso curso1=new Curso("A", 1);
		Profesor profesor= new Profesor("María", "Perez", 1234, 34567899);
 		
 		miEscuela.agregarCurso(curso1);
 		miEscuela.agregarMateriasACurso(literatura);
 		miEscuela.agregarProfesor(profesor);
 		miEscuela.agregarAlumno(alumno1);
 		miEscuela.agregarNotaAlAlumno(prueba,30333555);
 		miEscuela.agregarNotaAlAlumno(prueba2,30333555);
 		miEscuela.agregarNotaAlAlumno(prueba3,30333555);
 		
 		Double esperado = 7.00;
 		
 		Double notaTrimestral = miEscuela.calcularNotaTrimestrePorMateria(30333555, 10, 30333555, 1);
 
 		assertEquals(esperado, notaTrimestral);
     }
     
     @Test
     public void QueSeCalculeNotaAnualDelAlumnoPorMateria() {
    	 
    	 
    	Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
 		Alumno alumno1= new Alumno("Leandro", "Suarez", 2345, 30333555);
 		Materia literatura= new Materia ("literatura", 10);
 		Calificacion trimestre1= new Calificacion(8.00,1,10);
 		Calificacion trimestre2=new Calificacion(6.00,2,10);
 		Calificacion trimestre3=new Calificacion(7.00,3,10);
 		Curso curso1=new Curso("A", 1);
 		Profesor profesor= new Profesor("María", "Perez", 1234, 34567899);
  		
  		miEscuela.agregarCurso(curso1);
  		miEscuela.agregarMateriasACurso(literatura);
  		miEscuela.agregarProfesor(profesor);
  		miEscuela.agregarAlumno(alumno1);
  		miEscuela.agregarNotaAlAlumno(trimestre1,30333555);
  		miEscuela.agregarNotaAlAlumno(trimestre2,30333555);
  		miEscuela.agregarNotaAlAlumno(trimestre3,30333555);
  		
  		Double esperado = 7.00;
  		
  		Double notaAnual = miEscuela.calcularNotaAnualDelAlumnoPorMateria(34567899, 10, 30333555, 3);
  
  		assertEquals(esperado, notaAnual);
     }
     
     @Test
     public void QueSePuedaEliminarUnAlumnoDeUnCurso() {
    	 
    	Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
  		Alumno alumno1= new Alumno("Leandro", "Suarez", 2345, 30333555);
  		Curso curso1=new Curso("A", 1);
  		
  		miEscuela.agregarCurso(curso1);
  		miEscuela.agregarAlumno(alumno1);
  		
  		
  		assertTrue(miEscuela.eliminarAlumnoDeUnCurso(30333555));
		assertNull(miEscuela.obtenerAlumno(30333555));
  	}
     
     //que un trimestre esté abierto
     
//     @Test 
//     public void QueUnDirectorPuedaCerrarUnTrimestre() {
//    	 
//    	 //¿validamos solo por id o además que las notas estén cargadas?
//    	 
//    	Escuela miEscuela= new Escuela("Instituto Sagrado Corazón");
//   		Directivo directivo1= new Directivo("Julia", "López", 5789, 20202020);
//   		Curso curso1=new Curso("A", 1);
//   		
//    	 
//     }
     
     
     //CADA UNO TIENE QUE HACER CREAR UNA COLECCIÓN
     //ELIMINAR ALGO. X EJ: PROFE, CURSO, MATERIA
     //TENEMOS LA CLASE HERENCIA. ¿QUÉ ONDA CÓMO TERMINAMOS DE DECLARAR LAS CLASES HIJAS?
     //TENEMOS QUE HACER UN REPORTE CADA UNO.X EJ: ??
     //FALTAN LOS MÉTODOS PARA VALIDAR QUE EL PERÍODO SE CIERRE Y SE ABRA 

     //CONSULTAR LOS DESAPROBADOS por curso
     //consutlar desaprobados por escuela
     //cantidad de aprobados por curso
     //
     
}
