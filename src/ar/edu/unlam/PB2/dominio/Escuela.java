package ar.edu.unlam.PB2.dominio;

import java.util.ArrayList;
import java.util.HashSet;




public class Escuela {

	private String nombre;
	
	private HashSet<Profesor>profesores= new HashSet<> ();

	private HashSet <Materia> materias= new HashSet<> ();
	
	private HashSet <Curso> cursos= new HashSet<> ();
	
	private HashSet <Alumno> alumnos= new HashSet<> ();

	private HashSet <Padre> padres= new HashSet<> ();
	
	private HashSet <Directivo> directivos= new HashSet<> ();
	
	private ArrayList<Calificacion> calificaciones= new ArrayList<>();
    //Se la pongo como Lista a la clase Calificacion?
	
	public Escuela(String nombre) {
		
		this.nombre=nombre;
	}
		
	public Boolean agregarCurso(String division, Integer anio) { 
			
			Curso curso= new Curso(division, anio);
			return this.cursos.add (curso);	
	}	
	
	public Curso obtenerCurso(String division, Integer anio) {
		
			for(Curso curso: this.cursos) {
				
				if(curso.getAnio().equals(anio)&& curso.getDivision().equals(division)) {
					
				 return curso;
				}				 
			}
			return null;
	}

	public Profesor buscarProfesor(Integer dni) {
		
		for(Profesor profesor: this.profesores) { //Por cada profesor en la colección profesores(lista), ejecuto este código
			
			if(profesor.getDni().equals(dni));
			
			return profesor;
		}
		return null;
	}
	
//	
	public Boolean agregarProfeAunCurso(String division, Integer anio, Integer dni)
	{	
		Curso curso= obtenerCurso(division, anio); 
		Profesor profesor = buscarProfesor(dni);
	
		if(curso != null && profesor != null) //  Si el curso existe y si el profesor existe, lo agrego
		{
			return curso.agregarProfeAunCurso(profesor);
		}
		
		return false;
	}
	
	public Materia buscarMateria(Integer id) {
		
		for(Materia materia: this.materias) {
			
			if(materia.getId().equals(id)) {
				
				return materia;
				
			}
		}
		return null;
		
	}	
	public Boolean agregarMateriasACurso(String nombre, Integer id,String division, Integer anio ) {  
		
		    Curso curso= obtenerCurso(division, anio);
		    Materia materia= buscarMateria(id);
		    
		    if(curso != null&& materia != null)  
		    
		    {
		    	return curso.agregarMateriasAunCurso(materia);
		    }
		    return false;
		    
	}
	public Alumno obtenerAlumno( Integer dni) {
		
		for(Alumno alumno: this.alumnos) {
			
			if(alumno.getDni().equals(dni)){
				
				return alumno;
			}
		}
		return null;
	}
	
	
	public Boolean agregarAlumnosAUnCurso(Integer dni, String division, Integer anio) {
		
		Curso curso= obtenerCurso(division, anio);
		Alumno alumno=obtenerAlumno(dni);
		
		if(curso!=null && alumno!=null) {
			
			return curso.agregarAlumnoAunCurso(alumno);
		}
		return false;
	}
	public Boolean agregarNotaAlAlumnoPor(Integer dniAlumno, Integer dniProfesor, Integer idMateria, Double notaParcial, Integer trimestre) {
		
		Alumno alumno=obtenerAlumno(dniAlumno);
		Profesor profesor = buscarProfesor(dniProfesor);
	    Materia materia= buscarMateria(idMateria);
		
		
		if(alumno!=null && profesor!= null&& materia !=null) {
			
			Calificacion calificacion= new Calificacion(notaParcial, trimestre, idMateria);			
			return profesor.agregarNotasAlAlumno(calificacion);
			
		}
		
		return false;
	}
	
	public ArrayList <Calificacion> consultarNotas(Integer dniUsuario, Integer dniAlumno, Integer trimestre, Integer idMateria) {
		
		ArrayList <Calificacion> calficacionesMateriaAlumno = new ArrayList<>();  //Creamos una lista para mostrar lo nota por materia
		for(Alumno alumno: this.alumnos) {
			
			if(alumno.getDni().equals(dniAlumno)){
				ArrayList <Calificacion> calficacionesAlumno = alumno.getCalificaciones(); 
				
				for(Calificacion calificacion: calficacionesAlumno) {
					if(calificacion.getIdMateria().equals(idMateria)&& calificacion.getTrimestre().equals(trimestre)) {
						calficacionesMateriaAlumno.add(calificacion);
					}
				}
			}
		}
		
		return calficacionesMateriaAlumno;
	}
	
	public Double calcularNotaTrimestrePorMateria(Integer dniUsuario, Integer idMateria, Integer dniAlumno, Integer trimestre ) {
		
		Double notaTrimestral=0.0;
		Double sumaNotas=0.0;
		Integer cantidadNotas=0;
		
		ArrayList <Calificacion> calificacionesMateriaAlumno = consultarNotas(dniUsuario, dniAlumno, trimestre, idMateria);
		
		
		for(Calificacion calificacion:calificacionesMateriaAlumno) {
			
			sumaNotas=sumaNotas+calificacion.getNotaParcial();
			cantidadNotas++;
		}
		
		if(cantidadNotas>0) {
			notaTrimestral= sumaNotas/cantidadNotas;
		}
		
		return notaTrimestral;	
	}
	
	public Double calcularNotaAnualDelAlumnoPorMateria(Integer dniUsuario, Integer idMateria, Integer dniAlumno, Integer cantidadTrimestre) 
	{
		
		Double notaAnual=0.0;
		Double sumaNotas=0.0;
		
 		
		for(int i=1; i<= cantidadTrimestre; i++) {
			
			Double NotaTrimestre= calcularNotaTrimestrePorMateria(dniUsuario,  idMateria,  dniAlumno, i);
			sumaNotas= sumaNotas+NotaTrimestre;
		}
		
		notaAnual= sumaNotas/cantidadTrimestre;
		return notaAnual;
	}

	public Boolean agregarCurso(Curso curso) {
		
		return this.cursos.add(curso);
	}

	public Boolean agregarMateriasACurso(Materia materia) {
		
		return this.materias.add(materia);
	}

	public Boolean agregarProfesor(Profesor profesor) {
		return this.profesores.add(profesor);
	}

	public Boolean agregarAlumno(Alumno alumno) {
		return this.alumnos.add(alumno);
	}

	public Boolean agregarNotaAlAlumno(Calificacion prueba, int dniAlumno) {
		
		Alumno alumno  = obtenerAlumno(dniAlumno);
		
		if(alumno != null)
		{
			return	alumno.setCalificacion(prueba);
		}
		return false;
		
	}

	
	public Boolean eliminarAlumnoDeUnCurso(Integer dni) 
	{
		
		Alumno alumnoEncontrado=obtenerAlumno(dni); 
		
		Boolean borro=false;
		
		if(alumnoEncontrado!= null) {
			
			this.alumnos.remove(alumnoEncontrado);
			borro=true;
		}
		return borro;
	}

	public Boolean eliminarAlumnoDeUnCurso(Alumno alumno) {
		return this.alumnos.remove(alumno);
		
	}
	
//	public Boolean cerrarNotasTrimestrales() {
//		
//	Double NotasDelTrimestre= calcularNotaTrimestrePorMateria(dniUsuario, idMateria,  dniAlumno, trimestre);
//	
//	private HashSet <Directivo> directivos= new HashSet<> ();
//	
//	public Profesor buscarProfesor(Integer dni) {
//		
//		for(Profesor profesor: this.profesores) { //Por cada profesor en la colección profesores(lista), ejecuto este código
//			
//			if(profesor.getDni().equals(dni));
//			
//			return profesor;
//		}
//		return null;
//	}
//	*
//	}
}
	
//public Boolean cerrarPeriodo
	//Si todas las notas no son null y si el id es el correcto, cerra periodoTrue
	//public Boolean reabrirPeriodo(iddirectivo)
	
		//Se empieza con el sistema abierto x default.
		//para validar reabrirlo, una vez
	
	
	 
	//public Boolean calcularAprobados
	//Podemos hacer un TreeSet para ordenar aprobados y desaprobados
	
	
	//cargar notas de los chicos por id del profe o del directivo

	//reabrir periodo x id Directivo
	//cerrar periodo por id del docente o del directivo. PAra cerrarse tienen que estar todas las notas cargadas.
	

