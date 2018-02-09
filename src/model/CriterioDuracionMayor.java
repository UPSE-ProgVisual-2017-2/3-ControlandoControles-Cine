package model;

public class CriterioDuracionMayor implements Criterio {

	private int duracion;
	
	public CriterioDuracionMayor(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public boolean verificar(Pelicula p) {
		if(p.getDuracionMinutos()>duracion)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "Duracion mayor a " + duracion + " minutos";
	}

}
