package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Proyeccion {

	private Pelicula pelicula;
	private LocalDate fecha;
	private Cine.Sala sala;
	private TipoProyeccion tipo;
	private String hora;
	
	Set<Integer> asientosVendidos = new HashSet<Integer>(); 
	
	public Proyeccion(Pelicula pelicula, LocalDate fecha, Cine.Sala sala, TipoProyeccion tipo, String hora) {
		this.pelicula = pelicula;
		this.fecha = fecha;
		this.sala = sala;
		this.tipo = tipo;
		this.hora = hora;
		asientosVendidos = new HashSet<Integer>(); 
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

	public Cine.Sala getSala() {
		return sala;
	}

	public void setSala(Cine.Sala sala) {
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

	public Set<Integer> getAsientosVendidos() {
		return asientosVendidos;
	}

	public void setAsientosVendidos(Set<Integer> asientosVendidos) {
		this.asientosVendidos = asientosVendidos;
	}
	
	public void venderAsiento(Integer asiento)
	{
		asientosVendidos.add(asiento);
		System.out.println("Asiento vendido " + asiento);
	}

	@Override
	public String toString() {
		return "Proyeccion [pelicula=" + pelicula + ", fecha=" + fecha + ", sala=" + sala + ", tipo=" + tipo + "]";
	}
	
	

	
}
