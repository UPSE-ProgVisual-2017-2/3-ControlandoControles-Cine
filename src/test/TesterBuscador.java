package test;

import java.util.ArrayList;
import java.util.List;

import controllers.Context;
import controllers.ControllerHelper;
import model.Buscador;
import model.Cine;
import model.Cliente;
import model.Criterio;
import model.CriterioDuracionMayor;
import model.CriterioTituloPelicula;
import model.Pelicula;
import model.TipoPelicula;

public class TesterBuscador {

	public TesterBuscador() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context contexto = new Context();
		Cine cinecito = Context.getInstance().getCine();
		
		
		Buscador googleTrucho = new Buscador();
		
		//Prueba enfoque 1
		/*
		List<Pelicula> peliculasPorGenero = 
				googleTrucho.buscarPeliculasPorGenero(cinecito.getListaPeliculas(),
						TipoPelicula.ACCION);
		*/
		
		//Prueba enfoque 2
		/*List<Pelicula> peliculasPorRangoCosto =
				googleTrucho.buscarPeliculasConRangoDeCosto(cinecito.getListaPeliculas(), 
						40000000, 120000000);
		*/
		
		//Prueba enfoque 3
		/*CriterioTituloPelicula criterioTitulo = new CriterioTituloPelicula("Civic War");
		List<Pelicula> peliculasPorTitulo = 
				googleTrucho.buscarPeliculasPorCriterioGeneral(cinecito.getListaPeliculas(),
						criterioTitulo);
		*/
		//Otra prueba enfoque 3
		/*CriterioDuracionMayor criterioDuracionMayor = new CriterioDuracionMayor(160);
		List<Pelicula> peliculasDeDuracionMayorA160 = 
				googleTrucho.buscarPeliculasPorCriterioGeneral(
						cinecito.getListaPeliculas(),
						criterioDuracionMayor);
		*/
		//Prueba Criterio 4: Clases anonimas
		/*List<Pelicula> peliculasDeDirectorMayoresADuracion = 
				googleTrucho.buscarPeliculasPorCriterioGeneral(
						cinecito.getListaPeliculas(),
						new Criterio() {
							public static final int minutos = 130;
							public static final String director = "Juan Pueblo";
							
							@Override
							public boolean verificar(Pelicula p) {
								if(p.getDuracionMinutos()>minutos && p.getDirector()== director)
									return true;
								return false;
							}
							
							public String toString()
							{
								return "Pelicula con director " + director 
										+ " y duracion mayor a " + minutos +" minutos";
							}
						});
		*/
		
		//Enfoque 4 prueba 2
		/*List<Pelicula> listaPeliculasConPalabraClave =
				googleTrucho.buscarPeliculasPorCriterioGeneral(
						cinecito.getListaPeliculas(),
						new Criterio() {
							
							@Override
							public boolean verificar(Pelicula p)
							{
								String sinopsis = p.getSinopsis();
								if(sinopsis.contains("mortal"))
								{
									return true;
								}
								return false;
							}
						});
		 */
		
		//Enfoque 5: Lambdas
		/*List<Pelicula> listaPeliculasConPalabraClaveLambda =
				googleTrucho.buscarPeliculasPorCriterioGeneral(
						cinecito.getListaPeliculas(),
						(p) -> {
							if(p.getSinopsis().contains("mortal"))
							{	
								return true;
										}
							else {
								return false;
							}
						});
		*/
		/*
		List<Pelicula> listaPeliculasConCostoAlto =
				googleTrucho.buscarPeliculasPorCriterioGeneral(
						cinecito.getListaPeliculas(), 
						p -> p.getCostoProduccion()>120000);
		*/
		/*
		List<Pelicula> listaPeliculasConCostoAltoFunctional =
				googleTrucho.buscarPeliculasPorCriterioGeneralPredicate(
						cinecito.getListaPeliculas(),
						p -> p.getCostoProduccion()>1200000);
		*/
		/*
		List<Pelicula> listaPeliculasDeDirectorTarantino =
				googleTrucho.buscarPeliculasPorCriterioGeneralPredicate(
						cinecito.getListaPeliculas(),
						p -> {
							if(p.getDirector()=="Tarantino")
							{
								return true;
							}
							return false;
						} );
		*/
		/*
		List<Pelicula> listaPeliculasSinopsisCambiadaGenerica =
				googleTrucho.buscarPeliculaYEjecutarAccion(
						cinecito.getListaPeliculas(), 
						p -> p.getSinopsis()==null, 
						p -> p.setSinopsis("Estimado usuario, la pelicula es muy bacan como para tener sinopsis"));
		
		System.out.println("****Peliculas sin sinopsis a las que se agrego sinopsis generica****");
		System.out.println(listaPeliculasSinopsisCambiadaGenerica);
		*/
		/*
		List<Pelicula> listaPeliculasRankingPorDefault =
				googleTrucho.buscarPeliculaYEjecutarAccion(
						cinecito.getListaPeliculas(), 
						p -> p.getCalificacion()==0, 
						p -> p.setCalificacion(3));
		
		System.out.println("****Peliculas sin calificacion a las que se agrego calificacion por defecto****");
		System.out.println(listaPeliculasRankingPorDefault);
		*/
		/*
		List<Pelicula> listaPeliculasRankeadasYSugeridas =
				googleTrucho.buscarPeliculaEjecutarAccionMapeadoraYConsuma(cinecito.getListaPeliculas(), 
						p -> p.getTipo()==TipoPelicula.TERROR, 
						p -> {
								Float rankingNetflixTrucho;
								rankingNetflixTrucho = (float) (p.getDuracionMinutos()/60 * p.getCostoProduccion()/1000000);
								return rankingNetflixTrucho;
						}, 
						ranking -> ControllerHelper.enviarEmail("peladoSadico@gmail.com", 
								"Te hemos sugerido la siguiente pelicula con el ranking " + ranking ));
		System.out.println("****Peliculas Sadicas Salvajes 7****");
		System.out.println(listaPeliculasRankeadasYSugeridas);
		*/
		
		/*
		List<Pelicula> listaPeliculasRankeadasYSugeridasGenericas =
				 googleTrucho.<Pelicula,Float>procesadorElementosVerificados(
						cinecito.getListaPeliculas(),
						p -> p.getTipo()==TipoPelicula.ACCION,
						(Pelicula p) -> {
							Float rankingNetflixTrucho;
							rankingNetflixTrucho = (float) (p.getDuracionMinutos()/60 * p.getCostoProduccion()/1000000);
							return rankingNetflixTrucho;
						}, 
						(Float ranking) -> ControllerHelper.enviarEmail("peladoSadico@gmail.com", 
								"Te hemos sugerido la siguiente pelicula con el ranking " + ranking ) );
		System.out.println("****Peliculas de Accion Activas****");
		System.out.println(listaPeliculasRankeadasYSugeridasGenericas);
		*/
		/*
		//Clientes de Prueba
		Cliente c1 = new Cliente("Janio", "2099876654");
		Cliente c2 = new Cliente("Bryan", "2499999999", "Chanduy", "042333555");
		Cliente c3 = new Cliente("Sra. Paola", "0922222222", "Ancon", "042444422");
		List<Cliente> clientesCine = new ArrayList<Cliente>();
		clientesCine.add(c1);
		clientesCine.add(c2);
		clientesCine.add(c3);
		
		List<Cliente> listaClientesPuntuados =
				 googleTrucho.<Cliente,Integer>procesadorElementosVerificados(
						clientesCine,
						(Cliente c) -> c.getDireccion()!=null && c.getDireccion()!="",
						(Cliente c) -> {
							Integer rango;
							rango = ((c.getNombre().length()<6)?1:0);
							return rango;
						}, 
						(Integer rango) -> { if(rango>0)
							{ControllerHelper.enviarEmail("email@gmail.com", 
								"Te invitamos gratis a la funcion vip por se cliente rango" + rango ); }
						});
		System.out.println("****Clientes Preferenciales****");
		System.out.println(listaClientesPuntuados);
		*/
		
		//Enfoque 9: Streams (Son reales Jordy)
		cinecito.getListaPeliculas()
			.stream()
			.filter(p -> p.getCalificacion()>2)
			.map( p -> p.getTitulo())
			.forEach(titulo -> System.out.println("Pelicula Rankeada " + titulo));
	}
}
