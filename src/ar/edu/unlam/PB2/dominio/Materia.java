package ar.edu.unlam.PB2.dominio;

import java.util.HashSet;

public class Materia {

	private String nombre;
	private Integer id;
	private HashSet <Materia> materias= new HashSet<> ();
	//Lista de alumnos
	//Lista de notas
	//Profesor asignado
	
	
	
	public Materia(String nombre, Integer id) {
		
		this.nombre = nombre;
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
