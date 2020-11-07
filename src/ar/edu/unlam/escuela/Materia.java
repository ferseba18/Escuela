package ar.edu.unlam.escuela;

import ar.edu.unlam.personas.Profesor;

public class Materia {

	private Integer idMateria;
	private Profesor profe;
	private String nombre;

	
	public Materia(Integer idMateria, String nombre) {
		this.idMateria = idMateria;
		this.nombre = nombre;
		
	}
	
	public Materia(Integer idMateria, String nombre, Profesor profe) {
		this.idMateria = idMateria;
		this.nombre = nombre;
		this.profe=profe;
	}

	
	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Profesor getProfe() {
		return profe;
	}

	public void setProfe(Profesor profe) {
		this.profe = profe;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMateria == null) ? 0 : idMateria.hashCode());
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
		Materia other = (Materia) obj;
		if (idMateria == null) {
			if (other.idMateria != null)
				return false;
		} else if (!idMateria.equals(other.idMateria))
			return false;
		return true;
	}

}
