package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cine {

	private static String RUC = "007123456123001";
	
	private List<Sala> listaSalas = new ArrayList<Sala>();
	
 	public static class Factura{
		private LocalDate fechaEmision;
		private String cajero;
		private Cliente cliente;
		private DetalleFactura detalle;
		private float subtotal;
		private float impuestos;
		private float total;
		
		public Factura(Cliente c)
		{
			fechaEmision = LocalDate.now();
			cliente = c;
		}
		
		public class DetalleFactura{
			List<Item> listaItems = new ArrayList<Item>();
			
		}

		public LocalDate getFechaEmision() {
			return fechaEmision;
		}

		public void setFechaEmision(LocalDate fechaEmision) {
			this.fechaEmision = fechaEmision;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		@Override
		public String toString() {
			return "Factura [fechaEmision=" + fechaEmision + ", cajero=" + cajero + ", cliente=" + cliente
					+ ", detalle=" + detalle + ", subtotal=" + subtotal + ", impuestos=" + impuestos + ", total="
					+ total + "]";
		}
		
		public float calcularTotal() {
			total = subtotal + impuestos;
			return total;
		}
		
		
	}
	
	public class Sala
	{
		private int filas;
		private int columnas;
		private TipoSonido tipoSonido;
		private int id;
		private TipoSala tipoSala;
		
		public Sala(int filas, int columnas, TipoSonido tipoSonido, int id, TipoSala tipoSala) {
			super();
			this.filas = filas;
			this.columnas = columnas;
			this.tipoSonido = tipoSonido;
			this.id = id;
			this.tipoSala = tipoSala;
		}

		public int getFilas() {
			return filas;
		}

		public void setFilas(int filas) {
			this.filas = filas;
		}

		public int getColumnas() {
			return columnas;
		}

		public void setColumnas(int columnas) {
			this.columnas = columnas;
		}

		public TipoSonido getTipoSonido() {
			return tipoSonido;
		}

		public void setTipoSonido(TipoSonido tipoSonido) {
			this.tipoSonido = tipoSonido;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public TipoSala getTipoSala() {
			return tipoSala;
		}

		public void setTipoSala(TipoSala tipoSala) {
			this.tipoSala = tipoSala;
		}

		@Override
		public String toString() {
			return "Sala [id=" + id + ", tipoSala=" + tipoSala + "]";
		}

	}
	
	public enum TipoSala{
		VIP, DIGITAL, D3;
	}
	
	public enum TipoSonido{
		SURROUND, DOLBY, MONO, STEREO;
	}
	
	public Cine() {
		listaSalas = new ArrayList<Sala>();
	}
	
	public void agregarSala(Sala s)
	{
		listaSalas.add(s);
	}
	
	public void borrarSala(Sala s)
	{
		listaSalas.remove(s);
	}
	
	public List<Sala> getListaSalas()
	{
		return listaSalas;
	}

}
