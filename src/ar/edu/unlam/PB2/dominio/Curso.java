package ar.edu.unlam.PB2.dominio;

import java.util.HashSet;



public class Curso {
	
	private String division;
	private Integer anio;
	private HashSet <Alumno> alumnos = new HashSet<>();
	private HashSet <Materia> materias = new HashSet<>();
	private HashSet <Profesor> profesores = new HashSet<>();
	
	
	public Curso(String division, Integer anio) {
		this.division=division;
		this.anio=anio;
	}

	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public Integer getAnio() {
		return anio;
	}


	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Boolean agregarProfeAunCurso(Profesor profesor)
	{
		return this.profesores.add(profesor);
	}
	
	public Boolean agregarMateriasAunCurso(Materia materia) {
		
		return this.materias.add(materia);
	}
	
	public Boolean agregarAlumnoAunCurso(Alumno alumno) {
		
		return this.alumnos.add(alumno);
	}
	}

//Curso
//
//ObtenerMaterias
//ObtenerNotas

// * 
// * ObtenerCurso(Anio, Division);
// * ObtenerCursos();
