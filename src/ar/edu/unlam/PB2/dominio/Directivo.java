package ar.edu.unlam.PB2.dominio;

public class Directivo extends Persona{

	public Directivo(String nombre, String apellido, Integer id, Integer dni) {
		super(nombre, apellido, id, dni);
	
	}

	public Boolean abrirTrimestre(Integer idIngresado) 
	{
		boolean cerrado=true;
		if(idIngresado.equals(id)) 
		{
			cerrado=false;
		
			return true;
		}
		return false;
	}
	
}
