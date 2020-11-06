package ar.edu.unlam.PB2.dominio;

public class Calificacion {
	
	private Double notaParcial;
	private Integer trimestre;
	private Integer idMateria;
	private Boolean cerrada;

	public Calificacion(Double notaParcial, Integer trimestre, Integer idMateria) {
		this.notaParcial=notaParcial;
		this.trimestre=trimestre;
		this.idMateria=idMateria;
		this.cerrada=true;
	}


	public Integer getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}


	public Integer getTrimestre() {
		return trimestre;
	}


	public void setTrimestre(Integer trimestre) {
		this.trimestre = trimestre;
	}


	public Double getNotaParcial() {
		return notaParcial;
	}


	public void setNotaParcial(Double notaParcial) {
		this.notaParcial = notaParcial;
	}		
}
