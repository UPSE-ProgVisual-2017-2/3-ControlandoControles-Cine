package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.portable.ValueFactory;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import model.Pelicula;
import model.Proyeccion;
import model.TipoPelicula;
import model.TipoProyeccion;

public class ControllerProyeccion {

	@FXML ChoiceBox<Pelicula> chbPelicula;
	@FXML DatePicker dateProyeccion;
	@FXML Spinner<Integer> spnSala;
	@FXML ChoiceBox<TipoProyeccion> chbTipoProyeccion;
	@FXML Slider sldrHora;
	@FXML Slider sldrMinuto;
	@FXML Label lblHora;
	@FXML Label lblMinuto;
	
	private Proyeccion pojo;
	
	public ControllerProyeccion() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize() 
	{
		//Creo el observable list con los valores del Enum TipoProyecciones
		ObservableList<TipoProyeccion> observableTipoProyeccion = 
				FXCollections.observableArrayList(TipoProyeccion.values());
		//Amarro el observable list con el ChoiceBox
		chbTipoProyeccion.setItems(observableTipoProyeccion);
		
		SpinnerValueFactory<Integer> spnValueFactoryInteger = 
				new IntegerSpinnerValueFactory(1,10,1);
		spnSala.setValueFactory(spnValueFactoryInteger);
		
		//Creo un metodo falso para cargar peliculas (hasta mientras).
		//cargarPeliculas();
		
		//Ahora si cargo las peliculas de verdad ingresadas 
		//por medio de la vista viewPelicula
		ObservableList<Pelicula> listaObservablePeliculas = 
				FXCollections.observableArrayList(Context.getInstance().getListaPeliculas());
		chbPelicula.setItems(listaObservablePeliculas);
		
		//Metodo para inicializar hora con valores max y min. 
		//Luego amarro propiedad de texto de label a propiedad valor del Slider.
		inicializarHora();
		
		inicializarMinutos();
	}

	private void inicializarHora() {
		sldrHora.setMax(23);
		sldrHora.setMin(0);
		sldrHora.setValue(17);
		
		//Convertir el valor del slider value de double a entero
		sldrHora.valueProperty().addListener(
				(obs, oldVal, newVal) -> sldrHora.setValue(newVal.intValue()));
				
		lblHora.textProperty().bind(sldrHora.valueProperty().asString());		
	}
	
	private void inicializarMinutos() {
		sldrMinuto.setMax(59);
		sldrMinuto.setMin(0);
		sldrMinuto.setValue(0);
		
		sldrMinuto.valueProperty().addListener(
				(obs, oldVal, newVal) -> sldrMinuto.setValue(newVal.intValue()));
		
		//Amarren la propiedad
		lblMinuto.textProperty().bind(sldrMinuto.valueProperty().asString());
	}


	private void cargarPeliculas() {
		List<Pelicula> peliculasCartelera = new ArrayList<Pelicula>();
		
		Pelicula p1 = new Pelicula("Thor: Ragnarok", TipoPelicula.COMIC);
		Pelicula p2 = new Pelicula("El regreso de Rafico", TipoPelicula.DRAMA);
		Pelicula p3 = new Pelicula("Examen de Programacion Visual 1", TipoPelicula.COMEDIA);
		
		peliculasCartelera.add(p1);
		peliculasCartelera.add(p2);
		peliculasCartelera.add(p3);
		
		ObservableList<Pelicula> observableListPelicula = FXCollections.observableArrayList(peliculasCartelera);
		chbPelicula.setItems(observableListPelicula);
	}
	
	public void guardar()
	{
		Pelicula pelicula = chbPelicula.getValue();
		LocalDate fecha = dateProyeccion.getValue();
		int sala = spnSala.getValue();
		TipoProyeccion tipo = chbTipoProyeccion.getValue();
		String hora = sldrHora.getValue() + "H" + sldrMinuto.getValue(); 
		pojo = new Proyeccion(pelicula, fecha, sala, tipo, hora);
		System.out.println(pojo);
	}
	
	public void limpiar()
	{
		chbPelicula.setValue(null);
		dateProyeccion.setValue(null);
		spnSala.getValueFactory().setValue(1);
		chbTipoProyeccion.setValue(null);
		sldrHora.setValue(0);
		sldrMinuto.setValue(0);
	}
}
