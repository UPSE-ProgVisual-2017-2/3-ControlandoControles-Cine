package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Buscador {

	public Buscador() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Enfoque 1: Busqueda simple, criterio unico
	 * Este metodo filtra peliculas por genero
	 * @param listaPeliculasDisponibles : La lista de peliculas
	 * @param tipo: El tipo o genero de las peliculas
	 * @return Una lista filtrada con las pelis que corresponden
	 * a dicho genero
	 */
	public List<Pelicula> buscarPeliculasPorGenero(List<Pelicula> listaPeliculasDisponibles, 
			TipoPelicula tipo)
	{
		List<Pelicula> listaPeliculasEncontradas = new ArrayList<Pelicula>();
		System.out.println("Las peliculas disponibles del tipo " + tipo + " son:");
		for(Pelicula p: listaPeliculasDisponibles)
		{
			if(p.getTipo() == tipo)
			{
				listaPeliculasEncontradas.add(p);
				System.out.println(p);
			}
		}
		return listaPeliculasEncontradas;
	}
	
	/**
	 * Enfoque 1: Busqueda simple, criterio unico
	 * Este metodo filtra peliculas por director
	 * @param listaPeliculasDisponibles : La lista de peliculas
	 * @param director: El director de las peliculas
	 * @return Una lista filtrada con las pelis que corresponden
	 * a dicho director
	 */
	public List<Pelicula> buscarPeliculasPorDirector(List<Pelicula> listaPeliculasDisponibles, 
			String director)
	{
		List<Pelicula> listaPeliculasEncontradas = new ArrayList<Pelicula>();
		System.out.println("Las peliculas disponibles del director " + director + " son:");
		for(Pelicula p: listaPeliculasDisponibles)
		{
			if(p.getDirector() == director)
			{
				listaPeliculasEncontradas.add(p);
				System.out.println(p);
			}
		}
		return listaPeliculasEncontradas;
	}
	
	public List<Pelicula> buscarPeliculasConRangoDeCosto(
			List<Pelicula> listaPeliculasDisponibles,
			int valorMinimo, int valorMaximo)
	{
		List<Pelicula> listaPeliculasEncontradas = new ArrayList<Pelicula>();
		System.out.println("Las peliculas que tuvieron un presupuesto de entre " 
				+ valorMinimo + " y " + valorMaximo + " son: ");
		for(Pelicula p: listaPeliculasDisponibles)
		{
			if(p.getCostoProduccion()>= valorMinimo && p.getCostoProduccion() <= valorMaximo)
			{
				listaPeliculasEncontradas.add(p);
				System.out.println(p);
			}
		}
		return listaPeliculasEncontradas;
	}

	//Enfoque 3 (y 4 y 5)
	public List<Pelicula> buscarPeliculasPorCriterioGeneral(List<Pelicula> listaPeliculasDisponibles, 
			Criterio criterio)
	{
		List<Pelicula> listaPeliculasEncontradas = new ArrayList<Pelicula>();
		System.out.println("Las peliculas disponibles del criterio " + criterio + " son:");
		for(Pelicula p: listaPeliculasDisponibles)
		{
			if(criterio.verificar(p))
			{
				listaPeliculasEncontradas.add(p);
				System.out.println(p);
			}
		}
		return listaPeliculasEncontradas;
	}
	
	//Enfoque 6: USo de interfaces funcionales estandar
	public List<Pelicula> buscarPeliculasPorCriterioGeneralPredicate(
			List<Pelicula> listaPeliculasDisponibles,
			Predicate<Pelicula> predicate)
	{
		List<Pelicula> listaPeliculasEncontradas = new ArrayList<Pelicula>();
		System.out.println("Las peliculas disponibles del criterio " + predicate + " son:");
		for(Pelicula p: listaPeliculasDisponibles)
		{
			if(predicate.test(p))
			{
				listaPeliculasEncontradas.add(p);
				System.out.println(p);
			}
		}
		return listaPeliculasEncontradas;
	}
	
	//Enfoque 7: Usar mas interfaces funcionales (consumer)
	public List<Pelicula> buscarPeliculaYEjecutarAccion(
			List<Pelicula> listaPeliculasDisponibles,
			Predicate<Pelicula> predicate,
			Consumer<Pelicula> accionConsumidoraAEjecutar)
	{
		List<Pelicula> listaPeliculasConsumidas = new ArrayList<Pelicula>();
		for(Pelicula p: listaPeliculasDisponibles)
		{
			if(predicate.test(p))
			{
				accionConsumidoraAEjecutar.accept(p);
				listaPeliculasConsumidas.add(p);
			}
		}
		return listaPeliculasConsumidas;
	}
	
	//Enfoque 7: Interfaces funcionales que testean (predicate), consume y mapea
	public List<Pelicula> buscarPeliculaEjecutarAccionMapeadoraYConsuma(
			List<Pelicula> listaPeliculasDisponibles,
			Predicate<Pelicula> predicate,
			Function<Pelicula, Float> accionMapeadora,
			Consumer<Float> accionConsumidora)
	{
		List<Pelicula> listaPeliculasConsumidas = new ArrayList<Pelicula>();
		for(Pelicula p: listaPeliculasDisponibles)
		{
			if(predicate.test(p))
			{
				Float resultado = accionMapeadora.apply(p);
				accionConsumidora.accept(resultado);
				listaPeliculasConsumidas.add(p);
			}
		}
		return listaPeliculasConsumidas;
	}
			
	//Enfoque 8: Usando genericos al extremo.
	public <X,H> List<X> procesadorElementosVerificados(
			Iterable<X> elementos,
			Predicate<X> predicado,
			Function<X, H> mapeadora,
			Consumer<H> consumidora)
	{
		List<X> listaElementosRetornables = new ArrayList<X>();
		for(X x:elementos)
		{
			if(predicado.test(x))
			{
				H h = mapeadora.apply(x);
				consumidora.accept(h);
				listaElementosRetornables.add(x);
			}
				
		}
		return listaElementosRetornables;
	}
	
}
