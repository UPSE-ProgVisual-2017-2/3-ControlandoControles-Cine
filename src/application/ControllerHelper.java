package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

}
