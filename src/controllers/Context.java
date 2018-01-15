package controllers;

import java.util.ArrayList;
import java.util.List;

import model.Cine;
import model.Pelicula;
import model.Proyeccion;

public class Context {

	private final static Context instance = new Context();
	
	private Cine cine = new Cine();
	private List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	private List<Proyeccion> listaProyecciones = new ArrayList<Proyeccion>();
	
	public static Context getInstance()
	{
		return instance;
	}

	public Context()
	{
		mockearCine();
	}
	
	public List<Pelicula> getListaPeliculas() {
		System.err.println("Lista de Peliculas\n:" + listaPeliculas);
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	public void addPelicula(Pelicula p)
	{
		listaPeliculas.add(p);
	}

	public List<Proyeccion> getListaProyecciones() {
		return listaProyecciones;
	}

	public void setListaProyecciones(List<Proyeccion> listaProyecciones) {
		this.listaProyecciones = listaProyecciones;
	}
	
	public void addProyeccion(Proyeccion p)
	{
		listaProyecciones.add(p);
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}
	
	private void mockearCine()
	{
		
		Cine.Sala sala1 = cine.new Sala(10, 5, Cine.TipoSonido.MONO, 1, Cine.TipoSala.DIGITAL);
		Cine.Sala sala2 = cine.new Sala(15, 8, Cine.TipoSonido.DOLBY, 2, Cine.TipoSala.D3);
		Cine.Sala sala3 = cine.new Sala(3, 5, Cine.TipoSonido.SURROUND, 3, Cine.TipoSala.VIP);
		
		cine.agregarSala(sala1);
		cine.agregarSala(sala3);
		//Creo salas
		
	}
	

}
