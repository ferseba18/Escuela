package ar.edu.unlam.personas;

import ar.edu.unlam.escuela.Materia;
import ar.edu.unlam.escuela.Notas;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class testAlumno {

	@Test
	public void queSePuedaCrearAlumno() {
		Alumno alumno = new Alumno(40950675, "Alejandro");
		
		String nombre = "Alejandro";
		Integer dni = 40950675;
		
		assertEquals(nombre, alumno.getNombre());
		assertEquals(dni, alumno.getDni());
	}

	@Test
	public void queSePuedaConsultarPromedioFinal() {
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia matematicas = new Materia(1, "Matematicas");
		Materia sociales = new Materia(2, "Sociales");
		Materia historia = new Materia(3, "Historia");
		Notas notaFinalMatematica = new Notas(matematicas, 8);
		Notas notaFinalSociales = new Notas(sociales, 7);
		Notas notaFinalHistoria = new Notas(historia, 6);
		
		HashSet<Notas> notasFinales = new HashSet<>();
		notasFinales.add(notaFinalMatematica);
		notasFinales.add(notaFinalSociales);
		notasFinales.add(notaFinalHistoria);
		alumno.setNotasFinales(notasFinales);
		
		Double valorObtenido = alumno.consultarPromedioFinal();
		Double valorEsperado = 7.0;
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaConsultarPromedioDeXTrimestre() {
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia matematicas = new Materia(1, "Matematicas");
		Materia sociales = new Materia(2, "Sociales");
		Materia historia = new Materia(3, "Historia");
		Notas nota1erTMatematica = new Notas(matematicas, 7);
		Notas nota1erTSociales = new Notas(sociales, 7);
		Notas nota1erTHistoria = new Notas(historia, 7);
		
		ArrayList<Notas> notas1erTrimestre = new ArrayList<>();
		notas1erTrimestre.add(nota1erTMatematica);
		notas1erTrimestre.add(nota1erTSociales);
		notas1erTrimestre.add(nota1erTHistoria);
		alumno.setPrimerTrimestre(notas1erTrimestre);
		
		Double valorObtenido = alumno.consultarPromedioFinalDeXTrimestre(1);
		Double valorEsperado = 7.0;
	
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerReportePorTrimestre() {
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia matematicas = new Materia(1, "Matematicas");
		Materia sociales = new Materia(2, "Sociales");
		Materia historia = new Materia(3, "Historia");
		Notas nota1erTMatematica = new Notas(matematicas, 7);
		Notas nota1erTSociales = new Notas(sociales, 7);
		Notas nota1erTHistoria = new Notas(historia, 7);
		
		Notas nota2doTMatematica = new Notas(matematicas, 8);
		Notas nota2doTSociales = new Notas(sociales, 8);
		Notas nota2doTHistoria = new Notas(historia, 6);
		
		Notas nota3erTMatematica = new Notas(matematicas, 9);
		Notas nota3erTSociales = new Notas(sociales, 5);
		Notas nota3erTHistoria = new Notas(historia, 10);
		
		ArrayList<Notas> notas1erTrimestre = new ArrayList<>();
		notas1erTrimestre.add(nota1erTMatematica);
		notas1erTrimestre.add(nota1erTSociales);
		notas1erTrimestre.add(nota1erTHistoria);
		alumno.setPrimerTrimestre(notas1erTrimestre);
		
		ArrayList<Notas> notas2doTrimestre = new ArrayList<>();
		notas2doTrimestre.add(nota2doTMatematica);
		notas2doTrimestre.add(nota2doTSociales);
		notas2doTrimestre.add(nota2doTHistoria);
		alumno.setSegundoTrimestre(notas2doTrimestre);
	
		ArrayList<Notas> notas3erTrimestre = new ArrayList<>();
		notas3erTrimestre.add(nota3erTMatematica);
		notas3erTrimestre.add(nota3erTSociales);
		notas3erTrimestre.add(nota3erTHistoria);
		alumno.setTercerTrimestre(notas3erTrimestre);
		
		String reporte = alumno.obtenerReporteDeNotasPorTrimestre();
		
		String valorEsperado = "Primer Trimestre: \n"+
				"Matematicas = 7\n"+
				"Sociales = 7\n"+
				"Historia = 7\n"+
				"\n"+
				"Segundo Trimestre: \n"+
				"Matematicas = 8\n"+
				"Sociales = 8\n"+
				"Historia = 6\n"+
				"\n"+
				"Tercer Trimestre: \n"+
				"Matematicas = 9\n"+
				"Sociales = 5\n"+
				"Historia = 10\n"+
				"";
		assertEquals(valorEsperado, reporte);

	}
	
	@Test
	public void queSePuedaObtenerReporteDeNotasFinales() {
		Alumno alumno = new Alumno(40950675, "Alejandro");
		Materia matematicas = new Materia(1, "Matematicas");
		Materia sociales = new Materia(2, "Sociales");
		Materia historia = new Materia(3, "Historia");
		Notas notaMatematica = new Notas(matematicas, 7);
		Notas notaSociales = new Notas(sociales, 7);
		Notas notaHistoria = new Notas(historia, 8);
		
		HashSet<Notas> notasFinales = new HashSet<>();
		notasFinales.add(notaMatematica);
		notasFinales.add(notaSociales);
		notasFinales.add(notaHistoria);
		alumno.setNotasFinales(notasFinales);
		
		String reporte = alumno.obtenerReporteDeNotasFinales();
		
		String valorEsperado = "Matematicas = 7\n"+
				"Sociales = 7\n"+
				"Historia = 8\n";
	
		assertEquals(valorEsperado, reporte);
	}
}
