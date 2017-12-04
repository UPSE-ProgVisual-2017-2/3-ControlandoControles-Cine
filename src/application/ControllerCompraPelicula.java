package application;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import model.Pelicula;

public class ControllerCompraPelicula {

	@FXML ChoiceBox<Pelicula> chbPelicula;
	@FXML DatePicker dateProyeccion;
	@FXML Spinner<Integer> spnNumBoletos;
	@FXML CheckBox chkTarjetaDescuento;
	
	
	public ControllerCompraPelicula() {

	}
	
	public void initialize()
	{
		
	}

}
