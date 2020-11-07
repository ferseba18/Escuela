package ar.edu.unlam.escuela;

import java.util.HashSet;

import ar.edu.unlam.personas.Alumno;
import ar.edu.unlam.personas.Profesor;

public class Curso {
	private Integer id;
	private static Integer idSiguiente=1;
	private String nombre;
	private HashSet <Alumno>  listaAlumnos=new HashSet<Alumno>();
	private HashSet <Materia> materias=    new HashSet<Materia>();
	
	
	public Curso( String nombre, HashSet<Alumno> listaAlumnos, HashSet<Materia> materias) {		
		this.id = idSiguiente;
		this.nombre = nombre;
		this.listaAlumnos = listaAlumnos;
		this.materias = materias;
		idSiguiente++;
	}

	public Curso( String nombre) {		
		this.id = idSiguiente;
		this.nombre = nombre;
		idSiguiente++;
	}

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public HashSet<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}


	public void setListaAlumnos(HashSet<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}


	public HashSet<Materia> getMaterias() {
		return materias;
	}

	
	public void setMaterias(HashSet<Materia> materias) {
		this.materias = materias;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
//ALUMNOS
	public Boolean agregarAlumno(Alumno alumno) {
		return this.listaAlumnos.add(alumno);
	}
	
	public Boolean eliminarAlumno(Alumno alumno) {
		return this.listaAlumnos.remove(alumno);
	}
	
	public Alumno buscarAlumno(Alumno alumno) {
		for (Alumno a : this.listaAlumnos) {
			if (a.equals(alumno)) {
				return a;
			}
		}
		return null;
	}
	
	public Alumno buscarAlumnoXDni(Integer dni) {
		for (Alumno a : this.listaAlumnos) {
			if (a.getDni().equals(dni)) {
				return a;
			}
		}
		return null;
	}

	
//MATERIA
	public Boolean agregarMateria(Materia materia) {
		return this.materias.add(materia);
	}
	
	public Boolean eliminarMateria(Materia materia) {
		return this.materias.remove(materia);
	}
	
	public Materia buscarMateria(Materia materia) {
		for (Materia m : this.materias) {
			if (m.equals(materia)) {
				return m;
			}
		}
		return null;
	}

	public Materia buscarMateriaXId(Integer iD) {
		for (Materia m : this.materias) {
			if (iD.equals(m.getIdMateria())) {
				return m;
			}
		}
		return null;
	}
	

//PROFESORES 
	public HashSet<Profesor> getListaDeProfesores(){
		HashSet<Profesor> lista=new HashSet<Profesor>();
		
		for (Materia m : this.materias) {
			lista.add(m.getProfe());
		}
		
		return lista;
	}
	
	public Profesor buscarProfeEnCurso(Profesor profe) {
		HashSet<Profesor> lista=getListaDeProfesores();
		
		for (Profesor p : lista) {
			if (p.equals(profe)) {
				return p;
			}
		}
		
		return null;		
	}

	public Profesor bucarProfeEnCursoXDni(Integer dni) {
		HashSet<Profesor> lista=getListaDeProfesores();
		
		for (Profesor p : lista) {
			if (p.getDni().equals(dni)) {
				return p;
			}
		}
		
		return null;	
	}

}
