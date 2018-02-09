package model;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ManejadorEventoAbortar implements EventHandler<ActionEvent> {

	public String test;
	public ManejadorEventoAbortar() {
		// TODO Auto-generated constructor stub
	}
	
	public ManejadorEventoAbortar(String test) {
		this.test = test;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Abortar");
		Platform.exit();
	}

}
