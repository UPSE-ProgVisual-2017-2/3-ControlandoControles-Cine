package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerPrincipalCine {

	ControllerHelper helper = new ControllerHelper();
	
	public void irViewPelicula()
	{
		helper.abrirPantalla("Ingreso Pelicula", "/viewPelicula.fxml");
	}
	
	public void irViewProyeccion()
	{
		helper.abrirPantalla("Ingreso Proyeccion", "/viewProyeccion.fxml");
	}
	
	public void irViewVentaBoleto()
	{
		helper.abrirPantalla("Venta de Boletos", "/viewCompraBoleto.fxml");
	}
	
	public void irViewBuscador()
	{
		helper.abrirPantalla("Buscador", "/ViewBuscadorGUI.fxml");
	}
	
	public ControllerPrincipalCine() {
		// TODO Auto-generated constructor stub
	}

}
