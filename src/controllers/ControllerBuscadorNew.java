package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Buscador;
import model.Pelicula;
import model.TipoPelicula;

public class ControllerBuscadorNew {

	@FXML ChoiceBox<String> chbCriterio;
	@FXML ListView<Pelicula> lstViewPeliculasEncontradas;
	@FXML HBox hboxDatosCriterio;
	@FXML Button btnBuscar;

	private Buscador buscador = new Buscador();
	Context c = new Context();
	
	public ControllerBuscadorNew() {
		// TODO Auto-generated constructor stub
	}

	public void initialize()
	{
		List<String> criterios = new ArrayList<String>();
		criterios.add("Titulo");
		criterios.add("Tipo");
		criterios.add("Duracion Minutos");
		criterios.add("Calificacion");

		ObservableList<String> listaObservableCriterios =
				FXCollections.observableArrayList(criterios);

		chbCriterio.setItems(listaObservableCriterios);

		chbCriterio.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				hboxDatosCriterio.getChildren().clear();
				cargarControlesSegunCriterio();

			}
		}
				);

	}

	private void cargarControlesSegunCriterio()
	{

		
		if(chbCriterio.getValue()=="Titulo")
		{
			Label label = new Label("Titulo de La Pelicula");
			TextField txtTitulo = new TextField();
			hboxDatosCriterio.getChildren().add(label);
			hboxDatosCriterio.getChildren().add(txtTitulo);
			
			System.out.println("Antes de Evento");
			btnBuscar.setOnAction(e -> {
				System.out.println("Ingreso a evento");
				List<Pelicula> peliculasEncontradas = new ArrayList<Pelicula>();
				peliculasEncontradas =
				buscador.buscarPeliculasPorCriterioGeneralPredicate(Context.getInstance().getListaPeliculas(), 
						p -> p.getTitulo().equals(txtTitulo.getText().trim()));
				
				System.out.println(peliculasEncontradas);
				ObservableList<Pelicula> listaObservablePeliculas;
				listaObservablePeliculas =
						FXCollections.observableArrayList(peliculasEncontradas);
				lstViewPeliculasEncontradas.setItems(listaObservablePeliculas);
			});
			
		}
		
		if(chbCriterio.getValue()=="Tipo")
		{
			Label label = new Label("Genero de Pelicula");
			
			ObservableList<TipoPelicula> listaObservableTipoPelicula =
					FXCollections.observableArrayList(TipoPelicula.values());
			ChoiceBox<TipoPelicula> chbTipoPelicula = new ChoiceBox<TipoPelicula>();
			chbTipoPelicula.setItems(listaObservableTipoPelicula);
			
			hboxDatosCriterio.getChildren().add(label);
			hboxDatosCriterio.getChildren().add(chbTipoPelicula);
			
			btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					List<Pelicula> peliculasEncontradas = new ArrayList<Pelicula>();

					peliculasEncontradas = buscador.buscarPeliculasPorCriterioGeneralPredicate(
							Context.getInstance().getListaPeliculas(),
							p -> p.getTipo().equals(chbTipoPelicula.getValue()));
					
					ObservableList<Pelicula> listaObservablePeliculas = FXCollections.observableArrayList(peliculasEncontradas);
					lstViewPeliculasEncontradas.setItems(listaObservablePeliculas);
				}
			});
		}
	}

}
