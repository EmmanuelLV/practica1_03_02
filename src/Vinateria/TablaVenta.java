package Vinateria;

public class TablaVenta {
	private Venta venta[];
	private float TotalPagado;
	public TablaVenta(Venta[] venta, float totalPagado) {
		super();
		this.venta = venta;
		TotalPagado = totalPagado;
	}
	public Venta[] getVenta() {
		return venta;
	}
	public void setVenta(Venta[] venta) {
		this.venta = venta;
	}
	public float getTotalPagado() {
		return TotalPagado;
	}
	public void setTotalPagado(float totalPagado) {
		TotalPagado = totalPagado;
	}
	public String[] modelo() {
		String[] modelo = new String[]{ "hello", "world" };
		return modelo;
	}
	
}
