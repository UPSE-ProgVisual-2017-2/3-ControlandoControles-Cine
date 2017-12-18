package application;

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
	
	
	public ControllerCompraBoleto() {

	}
	
	public void initialize()
	{
		
		SpinnerValueFactory<Integer> value = new IntegerSpinnerValueFactory(1,30);
		spnNumBoletos.setValueFactory(value);
	}

}
