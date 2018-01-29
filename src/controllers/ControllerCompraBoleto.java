package controllers;

import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
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
		
		btnAbortarOperacion.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Aborto mas rapido jajaja");
				
			}
		});
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
