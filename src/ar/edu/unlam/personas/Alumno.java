package ar.edu.unlam.personas;

import java.util.ArrayList;
import java.util.HashSet;

import ar.edu.unlam.escuela.Notas;
import ar.edu.unlam.interfaces.metodosAlumno;


public class Alumno extends Persona implements metodosAlumno {

	private ArrayList <Notas> primerTrimestre=new ArrayList<Notas>();
	private ArrayList <Notas> segundoTrimestre=new ArrayList<Notas>();
	private ArrayList <Notas> tercerTrimestre=new ArrayList<Notas>();
	private HashSet   <Notas> notasFinales=new HashSet<Notas>();
	
	public Alumno(Integer dni, String nombre) {
		super(dni, nombre);
	}

	public ArrayList<Notas> getPrimerTrimestre() {
		return primerTrimestre;
	}

	public void setPrimerTrimestre(ArrayList<Notas> primerTrimestre) {
		this.primerTrimestre = primerTrimestre;
	}

	public ArrayList<Notas> getSegundoTrimestre() {
		return segundoTrimestre;
	}

	public void setSegundoTrimestre(ArrayList<Notas> segundoTrimestre) {
		this.segundoTrimestre = segundoTrimestre;
	}

	public ArrayList<Notas> getTercerTrimestre() {
		return tercerTrimestre;
	}

	public void setTercerTrimestre(ArrayList<Notas> tercerTrimestre) {
		this.tercerTrimestre = tercerTrimestre;
	}

	public HashSet<Notas> getNotasFinales() {
		return notasFinales;
	}

	public void setNotasFinales(HashSet<Notas> notasFinales) {
		this.notasFinales = notasFinales;
	}

	
	
	@Override
	public Double consultarPromedioFinal() {
		// TODO Auto-generated method stub
		double promedio=0.0;
		
		promedio=sumatoria(this.notasFinales)/this.notasFinales.size();
		
		return promedio;
	}

	private Double sumatoria(HashSet<Notas> notasFinales2) {
		
		Double sumatoria=0.0;
		
		for (Notas n : notasFinales2) {
			sumatoria+=n.getResultado();
		}
		
		return sumatoria;
	}

	
	
	
	@Override
	public Double consultarPromedioFinalDeXTrimestre(Integer trimestre) {
		// TODO Auto-generated method stub
		Double promedio=0.0;
		
		switch (trimestre) {
		case 1:
			promedio=(sumatoria(this.primerTrimestre)/this.primerTrimestre.size());
			break;
		case 2:
			promedio=(sumatoria(this.segundoTrimestre)/this.segundoTrimestre.size());
			break;
		case 3:
			promedio=(sumatoria(this.tercerTrimestre)/this.tercerTrimestre.size());
			break;
		default:
			break;
		}
		
		return promedio;
	}

	private Double sumatoria(ArrayList<Notas> trimestre) {
		Double sumatoria=0.0;
		
		for (Notas n : trimestre) {
			sumatoria+=n.getResultado();
		}
		
		return sumatoria;
	}

	
	
	
	@Override
	public String obtenerReporteDeNotas() {
		String reporte="";
		
		for (Notas n : this.primerTrimestre) {
			reporte+= (n.getMateria() + "= " + n.getResultado()+ "\n");
		}
		
		reporte+="\n Segundo Trimestre: \n";
		
		for (Notas n : this.segundoTrimestre) {
			reporte+= (n.getMateria() + "=" + n.getResultado()+ "\n");
		}
		
		reporte+="\n Tercer Trimestre: \n";
		for (Notas n : this.tercerTrimestre) {
			reporte+= (n.getMateria() + "=" + n.getResultado()+ "\n");
		}
		
		return reporte;
	}

	@Override
	public String obtenerReporteDeNotasDeTodosTrimestre() {
		// TODO Auto-generated method stub
		String reporte="";
		
		for (Notas n : this.notasFinales) {
			reporte+= (n.getMateria() + "= " + n.getResultado()+ "\n");
		}
		
		return reporte;
	}
	
	public Boolean buscarNotaEnOtrosTrimestres(Notas nota) {
		Integer contador=0;
		Boolean seRepite=false;
		
		if (this.primerTrimestre.contains(nota)) {
			contador++;
		}
		
		if (this.segundoTrimestre.contains(nota)) {
			contador++;
		}
		
		if (this.tercerTrimestre.contains(nota)) {
			contador++;
		}
		
		if (!contador.equals(0)) {
			seRepite=true;
		}
		
		return seRepite;
	}
	
	


	

}
