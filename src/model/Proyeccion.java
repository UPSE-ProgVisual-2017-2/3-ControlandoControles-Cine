package model;

import java.time.LocalDate;

public class Proyeccion {

	private Pelicula pelicula;
	private LocalDate fecha;
	private int sala;
	private TipoProyeccion tipo;
	private String hora;
	
	public Proyeccion(Pelicula pelicula, LocalDate fecha, int sala, TipoProyeccion tipo, String hora) {
		this.pelicula = pelicula;
		this.fecha = fecha;
		this.sala = sala;
		this.tipo = tipo;
		this.hora = hora;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public TipoProyeccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoProyeccion tipo) {
		this.tipo = tipo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Proyeccion [pelicula=" + pelicula + ", fecha=" + fecha + ", sala=" + sala + ", tipo=" + tipo + "]";
	}
	
	

	
}
