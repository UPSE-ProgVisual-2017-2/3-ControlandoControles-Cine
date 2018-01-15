package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class ControllerSeleccionAsiento {

	@FXML TilePane tileAsientos;
	
	public ControllerSeleccionAsiento() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void initialize()
	{
		cargarTiles(8, 10);
	}

	private void cargarTiles(int numeroFilas, int numeroColumnas) {
		tileAsientos.setPrefColumns(numeroColumnas);
		tileAsientos.setPrefRows(numeroFilas);
		int index = 0;
		for(int i = 0; i < numeroColumnas; i++)
		{
			
			for(int j = 0; j<numeroFilas; j++)
			{
				Button asiento = new Button(Integer.toString(j));
				//tileAsientos.getChildren().add(index, asiento);
				tileAsientos.getChildren().add(asiento);
			}
			index++;
		}
		
	}

}
