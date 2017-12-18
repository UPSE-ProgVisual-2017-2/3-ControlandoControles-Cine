package application;

import java.io.File;
import java.net.URI;
import java.text.FieldPosition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import model.Pelicula;
import model.TipoPelicula;

public class ControllerPelicula {

	@FXML TextField txtTitulo;
	@FXML TextArea txtAreaSinopsis;
	@FXML TextField txtDirector;
	@FXML Spinner<Integer> spnDuracion;
	@FXML TextField txtCosto;
	@FXML ChoiceBox<TipoPelicula> chbTipoPelicula;
	@FXML ImageView imgBanner;
	@FXML TextField txtUrlVideo;
	@FXML MediaView mediaMovie;
	
	private Pelicula pojo;
	
	
	public void initialize()
	{
		pojo = new Pelicula();
		ObservableList<TipoPelicula> listaTiposPelicula = FXCollections.observableArrayList(TipoPelicula.values());
		chbTipoPelicula.setItems(listaTiposPelicula);
		cargarImagen();
		cargar();
	}
	
	public void cargarImagen()
	{
		Image imagen = new Image("/spongebob.jpg");
		imgBanner.setImage(imagen);
		imgBanner.setPreserveRatio(true);
		//imgBanner.setFitHeight(100);
		imgBanner.setFitWidth(150);
		
	}
	
	public void guardar() {
		pojo = new Pelicula();
		System.out.println(txtTitulo.getText());
		pojo.setTitulo(txtTitulo.getText());
		pojo.setSinopsis(txtAreaSinopsis.getText());
		pojo.setDirector(txtDirector.getText());
		pojo.setDuracionMinutos(spnDuracion.getValue());
		pojo.setCostoProduccion(Integer.parseInt(txtCosto.getText()));
		pojo.setTipo(chbTipoPelicula.getValue());
		System.out.println(pojo);
		Context.getInstance().addPelicula(pojo);
		
	}
	
	public void cargar()
	{
		Pelicula p = new Pelicula("Piratas del Caribe", TipoPelicula.AVENTURA);
		p.setDirector("Zimmerman");
		p.setCostoProduccion(25000000);
		p.setDuracionMinutos(0);
		p.setSinopsis("Jack Sparrow se va de farra!");
		
		cargar(p);
	}
	
	public void cargar(Pelicula p)
	{
		txtTitulo.setText(p.getTitulo());
		txtAreaSinopsis.setText(p.getSinopsis());
		txtCosto.setText(Integer.toString(p.getCostoProduccion()));
		txtDirector.setText(p.getDirector());
		spnDuracion.getValueFactory().setValue(p.getDuracionMinutos());
		chbTipoPelicula.setValue(p.getTipo());
	}
	
	public void cargarVideoURL()
	{
		String videoURL = txtUrlVideo.getText();
		Media trailer = new Media(videoURL);
		cargarVideo(trailer);
	}
	
	public void cargarVideoFile()
	{
		File f = new File("resources/videos/Madamina.mp4");
		URI uri = f.toURI();
		System.out.println(uri.toString());
		try {
			Media trailer = new Media(uri.toString());
			cargarVideo(trailer);
		}catch (MediaException me) {
			System.out.println("Medio no soportado. Intente otro formato");
		}
	}
	
	public void cargarVideo(Media m) 
	{
		MediaPlayer mp = new MediaPlayer(m);
		mp.setAutoPlay(true);
		mediaMovie.setMediaPlayer(mp);
		mp.play();
	}
	
	public ControllerPelicula() {
		// TODO Auto-generated constructor stub
	}
	
	public void limpiar()
	{
		txtTitulo.clear();
		txtAreaSinopsis.clear();
		txtCosto.clear();
		txtDirector.clear();
		chbTipoPelicula.setValue(null);
		spnDuracion.getValueFactory().setValue(0);
	}

}
