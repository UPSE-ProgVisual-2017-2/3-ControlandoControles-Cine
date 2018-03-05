package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		criterios.add("Sinopsis");
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
		
		if(chbCriterio.getValue()=="Sinopsis")
		{

			//Para cada Palabra clave
			HBox cajaPorPalabra = agregarControlesNuevaPalabraClave();
			
			//Conjunto de Palabras clave
			VBox textoMasBoton = new VBox(5);
			VBox cajaPalabrasClave = new VBox(3);
			cajaPalabrasClave.getChildren().add(cajaPorPalabra);
			Button btnAgregarNuevaPalabraClave = new Button("Agregar nueva Palabra Clave");
			btnAgregarNuevaPalabraClave.setOnAction(e -> cajaPalabrasClave.getChildren().add(agregarControlesNuevaPalabraClave()));
			
			textoMasBoton.getChildren().add(cajaPalabrasClave);
			textoMasBoton.getChildren().add(btnAgregarNuevaPalabraClave);
			hboxDatosCriterio.getChildren().add(textoMasBoton);
			
			btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					List<Pelicula> peliculasEncontradas = new ArrayList<Pelicula>();
					peliculasEncontradas = buscador.buscarPeliculasPorCriterioGeneralPredicate(
							Context.getInstance().getListaPeliculas(),
							p -> {
								boolean cumpleTodasPalabrasClave = false;
								if(p!= null && p.getSinopsis()!= null && p.getSinopsis().length()>0)
								{
									List<String> listaPalabrasClave = new ArrayList<String>();
									for(Node n: cajaPalabrasClave.getChildren())
									{
										if(n.getClass().equals(HBox.class))
										{
											HBox caja = (HBox) n;
											if(caja.getChildren().size()>1)
											{
												Node nodoPalabraClave = caja.getChildren().get(1);
												if(nodoPalabraClave.getClass().equals(TextField.class))
												{
													TextField textFieldPalabraClave = (TextField) nodoPalabraClave;
													String palabraClave = textFieldPalabraClave.getText();
													System.out.println("Texto textfield:" + palabraClave);
													listaPalabrasClave.add(palabraClave.toUpperCase());
												}else
												{
													System.err.println("No es TextField");
												}
											}else {
												System.err.println("Caja muy pequena");
											}
										}else {
											System.err.println("No es HBox, es: " + n.getClass());
										}
									}
									System.out.println("Palabras clave: " + listaPalabrasClave);
									
									for(String palabraClave: listaPalabrasClave){
										if(p.getSinopsis().toUpperCase().contains(palabraClave))
										{
											cumpleTodasPalabrasClave = true;
										}else
										{
											return false;
										}
									}								
								}
								return cumpleTodasPalabrasClave;
								});
					
					ObservableList<Pelicula> listaObservablePeliculas = FXCollections.observableArrayList(peliculasEncontradas);
					lstViewPeliculasEncontradas.setItems(listaObservablePeliculas);
				}
			});
		}
	}
	
	private HBox agregarControlesNuevaPalabraClave()
	{
		Label label = new Label("Palabra clave");
		TextField palabraClave = new TextField();
		palabraClave.setPromptText("Ingrese Palabra clave");
		HBox cajaPorPalabra = new HBox(2);
		cajaPorPalabra.getChildren().add(label);
		cajaPorPalabra.getChildren().add(palabraClave);
		return cajaPorPalabra;
	}

}
