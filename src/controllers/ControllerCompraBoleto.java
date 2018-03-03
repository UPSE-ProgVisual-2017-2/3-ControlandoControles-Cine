package controllers;

import java.util.Set;

import javax.xml.stream.EventFilter;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.ManejadorEventoAbortar;
import model.Proyeccion;

public class ControllerCompraBoleto {

	@FXML ChoiceBox<Proyeccion> chbProyeccion;
	@FXML DatePicker dateProyeccion;
	@FXML CheckBox chkTarjetaDescuento;
	@FXML Button btnAbortarOperacion;
	
	ControllerHelper helper = new ControllerHelper();
	
	public ControllerCompraBoleto() {

	}
	
	public void initialize()
	{
		cargarProyecciones();
		
		//EventHandler<ActionEvent> manejador = new ManejadorEventoAbortar();
		//btnAbortarOperacion.setOnAction(manejador);
		
		
		/*btnAbortarOperacion.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Scene escena = chbProyeccion.getScene();
				Stage escenario = (Stage) escena.getWindow();
				escenario.close();
			}
		});*/
		
		/*btnAbortarOperacion.setOnAction(e -> {
			System.out.println("Expresion lambda =)");
			Scene escena = chbProyeccion.getScene();
			Stage escenario = (Stage) escena.getWindow();
			escenario.close();
		});*/
		
		//Este boton cierra la ventana
		
		btnAbortarOperacion.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("Entro al filtro");
				if(chbProyeccion.getValue()!=null)
				{
					System.out.println("Oye ya cargaste proyeccion, no puedes abortar.");
					helper.mostrarAlertaInformacion("No puedes abortar cuando hay elementos seleccionados");
					event.consume();
				}
				
			}
		
		});
		
		btnAbortarOperacion.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getText().equals("a"))
				{
					System.out.println("Abortando salvajamente");
					helper.mostrarAlertaInformacion("Ud. Ha abortado salvajemente");
					((Stage)chbProyeccion.getScene().getWindow()).close();
				}else
				{
					System.out.println("No se aborta hasta que presione A sobre boton abortar o de clic. Ud presiono "  + event.getText() );
					helper.mostrarAlertaInformacion("Metodo de Abortar incorrecto");
				}
				System.out.println(event.getText());
			}
		});
		
		
		btnAbortarOperacion.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Tooltip aviso = new Tooltip("Oye Cuidado, abortar borra todo");
				btnAbortarOperacion.setTooltip(aviso);
				
			}
			
		});
		
		//btnAbortarOperacion.setOnMouseEntered(null);
		
		btnAbortarOperacion.setOnMouseClicked(e -> ((Stage)chbProyeccion.getScene().getWindow()).close());
		//btnAbortarOperacion.setOnAction(e -> ((Stage)chbProyeccion.getScene().getWindow()).close());
		//btnAbortarOperacion.setOnAction(e -> Platform.exit() );
	}

	private void cargarProyecciones() {
		ObservableList<Proyeccion> listaProyecciones = FXCollections.observableArrayList(Context.getInstance().getListaProyecciones());
		chbProyeccion.setItems(listaProyecciones);
	}

	public void llamarVistaSeleccionAsiento()
	{
		Context.getInstance().setProyeccionActual(chbProyeccion.getValue());
		Proyeccion proyeccionSeleccionada = chbProyeccion.getValue();
		if(proyeccionSeleccionada!=null)
		{
			helper.abrirPantallaPasoParametros("Seleccion de Asientos", "/ViewSeleccionAsientos.fxml", proyeccionSeleccionada.getSala());
			//helper.abrirPantalla("Seleccion de Asientos", "/ViewSeleccionAsientos.fxml");
		}else{
			ControllerHelper.mostrarAlertaError("Debe seleccionar una proyeccion");
		}
	}
	
	public void confirmarCompra()
	{
		Set<Integer> asientosVendidos = Context.getInstance().getProyeccionActual().getAsientosVendidos();
		System.out.println("Asientos Vendidos al momento:" + asientosVendidos);
		System.out.println("Asientos seleccionados para vender: " + Context.getInstance().getAsientosSeleccionadosParaVenta());
		asientosVendidos.addAll(Context.getInstance().getAsientosSeleccionadosParaVenta());
		System.out.println("Lista Actualizada asientos vendidos: " + asientosVendidos);
		
	}
	
	
}
