package model;

public class Item {

	private int id;
	private String descripcion;
	private float precioUnitario;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String descripcion, float precioUnitario) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + "]";
	}
	
	

}
