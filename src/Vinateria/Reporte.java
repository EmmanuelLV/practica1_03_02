package Vinateria;

import java.sql.Date;

public class Reporte {
	private Venta Ventas[];
	private Date Fecha;
	private float Ganancias;
	private float Gatos;
	public Reporte(Venta[] ventas, Date fecha, float ganancias, float gatos) {
		super();
		Ventas = ventas;
		Fecha = fecha;
		Ganancias = ganancias;
		Gatos = gatos;
	}
	public Venta[] getVentas() {
		return Ventas;
	}
	public void setVentas(Venta[] ventas) {
		Ventas = ventas;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public float getGanancias() {
		return Ganancias;
	}
	public void setGanancias(float ganancias) {
		Ganancias = ganancias;
	}
	public float getGatos() {
		return Gatos;
	}
	public void setGatos(float gatos) {
		Gatos = gatos;
	}
	public boolean writeTxt(){
		return true;
	}
	
}
