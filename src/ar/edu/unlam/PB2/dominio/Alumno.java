package ar.edu.unlam.PB2.dominio;

import java.util.ArrayList;


public class Alumno extends Persona{
	
	private ArrayList <Calificacion> calificaciones= new ArrayList<>();


	public Alumno(String nombre, String apellido, Integer id, Integer dni) {
		super(nombre, apellido, id, dni);
		
	}

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	public Boolean setCalificacion(Calificacion calificacion) {
		return this.calificaciones.add(calificacion);
	}
}
