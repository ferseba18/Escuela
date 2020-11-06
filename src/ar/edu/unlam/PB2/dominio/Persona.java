package ar.edu.unlam.PB2.dominio;

public class Persona {

	
	protected String nombre;
	protected String apellido;
	protected Integer id;
	protected Integer dni;
	
	public Persona (String nombre, String apellido, Integer id, Integer dni) {
		
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
		this.dni=dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	
}
