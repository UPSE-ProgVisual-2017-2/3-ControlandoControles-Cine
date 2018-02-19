package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Cine;
import model.Pelicula;
import model.Proyeccion;
import model.TipoPelicula;

public class Context {

	private final static Context instance = new Context();

	private Cine cine = new Cine();
	private List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	private List<Proyeccion> listaProyecciones = new ArrayList<Proyeccion>();
	private Proyeccion proyeccionActual;
	private Set<Integer> asientosSeleccionadosParaVenta = new HashSet<Integer>();
	

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
	
	public Proyeccion getProyeccionActual() {
		return proyeccionActual;
	}

	public void setProyeccionActual(Proyeccion proyeccionActual) {
		this.proyeccionActual = proyeccionActual;
	}

	public Set<Integer> getAsientosSeleccionadosParaVenta() {
		return asientosSeleccionadosParaVenta;
	}

	public void setAsientosSeleccionadosParaVenta(Set<Integer> asientosSeleccionadosParaVenta) {
		this.asientosSeleccionadosParaVenta = asientosSeleccionadosParaVenta;
	}

	private void mockearCine()
	{
		
		Cine.Sala sala1 = cine.new Sala(10, 5, Cine.TipoSonido.MONO, 1, Cine.TipoSala.DIGITAL);
		Cine.Sala sala2 = cine.new Sala(15, 8, Cine.TipoSonido.DOLBY, 2, Cine.TipoSala.D3);
		Cine.Sala sala3 = cine.new Sala(3, 5, Cine.TipoSonido.SURROUND, 3, Cine.TipoSala.VIP);
		
		cine.agregarSala(sala1);
		cine.agregarSala(sala2);
		cine.agregarSala(sala3);
		
		mockearPeliculas();
		//Creo salas
		
	}

	private void mockearPeliculas() {
		Pelicula coco = new Pelicula("Coco", "Una pelicula triste", TipoPelicula.INFANTIL, 120);
		Pelicula logan3 = new Pelicula("Logan 3", null, TipoPelicula.COMIC, "Ridley Scott" ,180, 20000000);
		Pelicula terminator3 = new Pelicula("Terminator 3", "Vuelve Terminator para salvar a sara connors", TipoPelicula.ACCION, "Spielberg", 150, 50000000);
		Pelicula civicWar = new Pelicula("Civic War", "Guerra civil en su mortal extension", TipoPelicula.ACCION, "Juan Pueblo", 169, 45000000);
		Pelicula cincuentaSombrasSalvajes = new Pelicula("50 sombras salvajes", "Amarrarla no es suficiente. En esta pelicula hay animales. Warning!", TipoPelicula.ADULTOS, 140);
		Pelicula clasificacion2022 = new Pelicula("Clasificacion 2022 Qatar", "El espiritu de otilino toma el cuerpo de Felipao. Como harann los jugadores para escapar y clasificar", TipoPelicula.TERROR, 150);
		clasificacion2022.setCostoProduccion(18000000);
		Pelicula bambi2 = new Pelicula("Bambi2", "Bambi poseida con se de venganza, va a matar a quien quemo el bosque, ni el conejo se salvara.", TipoPelicula.TERROR, "Gotico", 135, 2000000);
		Pelicula ratasRatonesRateros = new Pelicula("Ratas, Ratones y Rateros", "Muchos nengos en una situacion mortal", TipoPelicula.DRAMA, "Juan Pueblo", 189, 100000); 
		Pelicula civicWar2 = new Pelicula("Civic War 2", "Guerra civil mas mortal. Mucha sangre.", TipoPelicula.ACCION, "Juan Pueblo", 180, 78000000);
		Pelicula civicWar3 = new Pelicula("Civic War 3", "Guerra civil donde mueren los que no habian muerto antes. Mucha sangre, como en mi primera vez", TipoPelicula.ACCION, "Juan Pueblo", 177, 93000000);
		Pelicula pulpFiction = new Pelicula("Pulp Fiction", "Muchos eventos se interrelacionan en una trama llenna de violecina. Quien es Marcelus Wallace?", TipoPelicula.ACCION, "Tarantino", 130, 33000000);
		
		
		pulpFiction.setCalificacion(5);
		civicWar.setCalificacion(2);
		civicWar2.setCalificacion(3);
		civicWar3.setCalificacion(1);
		
		cine.agregarPelicula(logan3);
		cine.agregarPelicula(terminator3);
		cine.agregarPelicula(civicWar);
		cine.agregarPelicula(cincuentaSombrasSalvajes);
		cine.agregarPelicula(clasificacion2022);
		cine.agregarPelicula(ratasRatonesRateros);
		cine.agregarPelicula(civicWar2);
		cine.agregarPelicula(civicWar3);
		cine.agregarPelicula(pulpFiction);
		cine.agregarPelicula(coco);
		cine.agregarPelicula(bambi2);
		
		
		listaPeliculas.addAll(cine.getListaPeliculas());
	}
	

}
