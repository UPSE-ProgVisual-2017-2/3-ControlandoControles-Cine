package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import model.Proyeccion;

public class ControllerCompraBoleto {

	@FXML ChoiceBox<Proyeccion> chbProyeccion;
	@FXML DatePicker dateProyeccion;
	@FXML Spinner<Integer> spnNumBoletos;
	@FXML CheckBox chkTarjetaDescuento;
	
	ControllerHelper helper = new ControllerHelper();
	
	public ControllerCompraBoleto() {

	}
	
	public void initialize()
	{
		
		SpinnerValueFactory<Integer> value = new IntegerSpinnerValueFactory(1,30);
		spnNumBoletos.setValueFactory(value);
		
		cargarProyecciones();
	}

	private void cargarProyecciones() {
		ObservableList<Proyeccion> listaProyecciones = FXCollections.observableArrayList(Context.getInstance().getListaProyecciones());
		chbProyeccion.setItems(listaProyecciones);
	}

	public void llamarVistaSeleccionAsiento()
	{
		helper.abrirPantalla("Seleccion de Asientos", "/ViewSeleccionAsientos.fxml");
	}
	
}
