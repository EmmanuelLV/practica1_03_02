package Vinateria;

public class Venta {
	private Producto producto;
	private float Cantidad;
	private float Total;
	private float TotalIVA;
	
	public Venta(Producto producto, float cantidad, float total, float totalIVA) {
		super();
		this.producto = producto;
		Cantidad = cantidad;
		Total = total;
		TotalIVA = totalIVA;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public float getCantidad() {
		return Cantidad;
	}
	public void setCantidad(float cantidad) {
		Cantidad = cantidad;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	public float getTotalIVA() {
		return TotalIVA;
	}
	public void setTotalIVA(float totalIVA) {
		TotalIVA = totalIVA;
	}
	

}
