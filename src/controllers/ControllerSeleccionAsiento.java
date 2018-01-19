package controllers;

import java.util.HashSet;
import java.util.Set;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Cine;
import model.Proyeccion;

public class ControllerSeleccionAsiento implements ControllerBase {

	@FXML TilePane tileAsientos;
	
	private Cine.Sala sala;
	private Proyeccion proyeccionActual;
	
	Set<Integer> asientosSeleccionadosParaVenta = new HashSet<Integer>();
	
	public ControllerSeleccionAsiento() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void initialize()
	{
	
		//cargarTiles(8, 10);
	}

	private void cargarTiles(int numeroFilas, int numeroColumnas) {
		tileAsientos.setPrefColumns(numeroColumnas);
		tileAsientos.setPrefRows(numeroFilas);
		//tileAsientos.
		int index = 0;
		for(int i = 0; i < numeroFilas; i++)
		{
			
			for(int j = 0; j<numeroColumnas; j++)
			{
				index++;
				ToggleButton asiento = new ToggleButton(Integer.toString(index));
				if(Context.getInstance().getProyeccionActual().getAsientosVendidos().contains(index))
				{
					asiento.setDisable(true);
				}
				//CheckBox silla = new CheckBox(Integer.toString(j));
				//tileAsientos.getChildren().add(index, asiento);
				
				asiento.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						System.out.println("Seleccionado asiento toogle button: " + asiento.getText());
						int numeroAsiento = Integer.parseInt(asiento.getText().trim());
						System.err.println("Este es el numero de siento capturado en el evento " + numeroAsiento);
						//Context.getInstance().getProyeccionActual().venderAsiento(numeroAsiento);
						asientosSeleccionadosParaVenta.add(numeroAsiento);
						Context.getInstance().setAsientosSeleccionadosParaVenta(asientosSeleccionadosParaVenta);
						
					}
				});
				
				tileAsientos.getChildren().add(asiento);
				
			}
		}
		
		//Para evitar que se cambie el tamano de la pantalla.
		Stage stage = (Stage) tileAsientos.getScene().getWindow();
		stage.setResizable(false);
	}
	
	public void confirmarVenta()
	{
		
	}

	@Override
	public void inicializarDatos(Object... parametros) throws Exception {
		if(parametros != null && parametros.length>0)
		{
			if(parametros[0].getClass()==Cine.Sala.class)
			{
				sala = (Cine.Sala) parametros[0];
				cargarTiles(sala.getFilas(), sala.getColumnas());
			}else {
				ControllerHelper.mostrarAlertaError("Error mal paso de parametro. Contacte al programador.");
				throw new ClassCastException("Mala conversion de objeto");
			}
		}
		
	}
	
	

}
