package application;

import java.util.ArrayList;
import java.util.List;

import model.Pelicula;

public class Context {

	private final static Context instance = new Context();
	
	private List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	
	public static Context getInstance()
	{
		return instance;
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
	
	

}
