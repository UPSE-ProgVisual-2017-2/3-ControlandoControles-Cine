package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerHelper {


	public void abrirPantalla(String titulo, String view)
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource(view));
			Scene escena = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle(titulo);
			stage.setScene(escena);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void abrirPantallaPasoParametros(String titulo, String view, Object... params)
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
			Parent root = loader.load();
			Scene escena = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle(titulo);
			stage.setScene(escena);
			
			ControllerBase c = loader.<ControllerBase>getController();
			c.inicializarDatos(params);
			
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void mostrarAlertaError(String mensaje)
	{
		Alert alertError = new Alert(AlertType.ERROR);
		alertError.setTitle("Error");
		alertError.setContentText(mensaje);
		alertError.show();
	}
	
	public static void mostrarAlertaInformacion(String mensaje)
	{
		Alert alertError = new Alert(AlertType.INFORMATION);
		alertError.setTitle("Informacion");
		alertError.setContentText(mensaje);
		alertError.show();
	}
	
	
	
	public static void enviarEmail(String email, String mensaje)
	{
		System.out.println("Enviando email a " + email + "con el siguiente mensaje: ");
		System.out.println(mensaje);
		System.out.println("***Fin Email***");
	}

}
