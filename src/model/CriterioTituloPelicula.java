package model;

public class CriterioTituloPelicula implements Criterio {

	private String tituloPelicula;
	
	public CriterioTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}

	@Override
	public boolean verificar(Pelicula p) {
		if(p.getTitulo() == tituloPelicula)
		{
			return true;
		}else {
			return false;
		}
	}
	
	public String toString()
	{
		return "Titulo de Pelicula " + tituloPelicula;
	}

}
