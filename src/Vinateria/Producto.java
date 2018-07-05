package Vinateria;

public class Producto {
	private String  nombre;
	private int id;
	private float precioVenta;
	private float precioCosto;
	private String tipo;
	
	public Producto(String nombre, int id, float precioVenta, float precioCosto, String tipo) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.precioVenta = precioVenta;
		this.precioCosto = precioCosto;
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public float getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(float precioCosto) {
		this.precioCosto = precioCosto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
