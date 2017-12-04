package model;

public class Pelicula {

	private String titulo;
	private String sinopsis;
	private TipoPelicula tipo;
	private String director;
	private int duracionMinutos;
	private int costoProduccion;
	
	public Pelicula()
	{
		
	}
	
	public Pelicula(String titulo, String sinopsis, TipoPelicula tipo, int duracion) {
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.tipo = tipo;
		this.duracionMinutos = duracion;
	}

	public Pelicula(String titulo, String sinopsis, TipoPelicula tipo, String director, int duracionMinutos,
			int costoProduccion) {
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.tipo = tipo;
		this.director = director;
		this.duracionMinutos = duracionMinutos;
		this.costoProduccion = costoProduccion;
	}

	public Pelicula(String titulo, TipoPelicula tipo) {
		this.titulo = titulo;
		this.tipo = tipo;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public TipoPelicula getTipo() {
		return tipo;
	}

	public void setTipo(TipoPelicula tipo) {
		this.tipo = tipo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public int getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(int costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public String getTitulo()
	{
		return titulo;
	}
	
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", sinopsis=" + sinopsis + ", tipo=" + tipo + ", director=" + director
				+ ", duracionMinutos=" + duracionMinutos + ", costoProduccion=" + costoProduccion + "]";
	}
	
	

}
