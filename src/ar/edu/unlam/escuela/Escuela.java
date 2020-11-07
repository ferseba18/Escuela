package ar.edu.unlam.escuela;

import java.util.HashSet;


import ar.edu.unlam.personas.Alumno;
import ar.edu.unlam.personas.Director;
import ar.edu.unlam.personas.Padre;
import ar.edu.unlam.personas.Profesor;


public class Escuela {

	private String nombre;
	
	private Director director;
	
	private HashSet <Curso> cursos= new HashSet<> ();
	
	private HashSet <Profesor> profesores= new HashSet<> ();

	private HashSet <Materia> materias= new HashSet<> ();
		
	private HashSet <Alumno> alumnos= new HashSet<> ();

	private HashSet <Padre> padres= new HashSet<> ();
	
//CONSTRUCTORES	
	public Escuela(String nombre, Director director) {
		this.nombre=nombre;
		this.director=director;
	}


	
	
//GETTERS & SETTERS	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(HashSet<Profesor> profesores) {
		this.profesores = profesores;
	}

	public HashSet<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(HashSet<Materia> materias) {
		this.materias = materias;
	}

	public HashSet<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(HashSet<Curso> cursos) {
		this.cursos = cursos;
	}

	public HashSet<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(HashSet<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public HashSet<Padre> getPadres() {
		return padres;
	}

	public void setPadres(HashSet<Padre> padres) {
		this.padres = padres;
	}
		
    public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}




//METODOS ALUMNO
	public Boolean agregarAlumno(Alumno alumno) {
		return this.alumnos.add(alumno);
	}
	
	public Alumno buscarAlumno(Alumno alumno) {
		for(Alumno a: this.alumnos) {
			
			if(a.getDni().equals(alumno)){
				
				return a;
			}
		}
		return null;
	}
	
	public Alumno buscarAlumno(Integer dni) {
		for(Alumno a: this.alumnos) {
			
			if(a.getDni().equals(dni)){
				
				return a;
			}
		}
		return null;
	}
	
	public Boolean eliminarAlumno(Alumno alumno) {
		return this.alumnos.remove(alumno);
	}
	
	public Boolean eliminarAlumno(Integer dni) {
		Alumno encontrado=buscarAlumno(dni);
		Boolean eliminado=false;
		
		if (encontrado != null) {
			eliminado=eliminarAlumno(buscarAlumno(dni));
		}
		
		return eliminado;
		
	}
	
	
	
//METODOS CURSO
	public Boolean agregarCurso(Curso curso) {
		return this.cursos.add(curso);
	}
	
	public Curso buscarCurso(Curso curso) {
		
		for(Curso c: this.cursos) {
			if(c.equals(curso)) {			
			 return c;
			}				 
		}
		return null;
	}

	public Curso buscarCurso(Integer id) {
		for (Curso c : this.cursos) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	public Boolean eliminarCurso(Curso curso) {
		return this.cursos.remove(curso);
	}
	
	public Boolean eliminarCurso(Integer id) {
		Curso curso=buscarCurso(id);
		Boolean check=false;
		
		if (curso != null) {
			check=this.cursos.remove(buscarCurso(id));
		}
		
		return check;
	}
	
	
	
//METODOS PROFESOR
	public Boolean agregarProfe(Profesor profe) {
		return this.profesores.add(profe);
	}
	
	public Profesor buscarProfesor(Profesor profe) {
		for (Profesor p : this.profesores) {
			if (p.equals(profe)) {
				return p;
			}
		}
		return null;
	}
	
	public Profesor buscarProfesor(Integer dni) {
		for (Profesor p : this.profesores) {
			if (p.getDni().equals(dni)) {
				return p;
			}
		}
		return null;
	}
	
	public Boolean eliminarProfesor(Profesor profe) {
		return this.profesores.remove(profe);
	}
	
	public Boolean eliminarProfesor(Integer dni) {
		Profesor profe=buscarProfesor(dni);
		Boolean check=false;
		
		if (profe != null) {
			check=this.cursos.remove(buscarCurso(dni));
		}
		
		return check;
	}
	
	public Boolean agregarTodosLosProfesDeTodosLosCursos() {
		HashSet<Profesor> aux=new HashSet<Profesor>();
		Boolean terminado=false;
		
		for (Curso curso : this.cursos) {
			terminado=aux.addAll(curso.getListaDeProfesores());
		}
		
		return terminado;
		
	}
	
	
	
//METODOS MATERIA
	public Boolean agregarMateria(Materia materia) {
		return this.materias.add(materia);
	}
	
	public Materia buscarMateria(Materia materia) {
		for (Materia m : this.materias) {
			if (m.equals(materia)) {
				return m;
			}
		}
		return null;
	}
	
	public Materia buscarMateria(Integer id) {
		for (Materia m : this.materias) {
			if (m.getIdMateria().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public Boolean eliminarMateria(Materia materia) {
		return this.materias.remove(materia);
	}

	public Boolean eliminarMateria(Integer id) {
		Materia m=buscarMateria(id);
		Boolean seBorro=false;
		
		if (m != null) {
			seBorro=this.materias.remove(buscarMateria(id));
		}
		return seBorro;		
		
	}

	public Boolean agregarTodosLasMateriasDeTodosLosCursos() {
		HashSet<Materia> materias=new HashSet<Materia>();
		Boolean terminado=false;
		
		for (Curso curso : this.cursos) {
			terminado=materias.addAll(curso.getMaterias());
		}
		
		return terminado;		
	}

}
