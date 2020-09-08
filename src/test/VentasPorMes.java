package test;

public class VentasPorMes {

	private String ciudad;
	private String almacen;
	private String mes;
	private Long venta;
	
	public VentasPorMes() {
	}
	
	public VentasPorMes(String ciudad, String almacen, String mes, Long venta) {
		super();
		this.ciudad = ciudad;
		this.almacen = almacen;
		this.mes = mes;
		this.venta = venta;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getAlmacen() {
		return almacen;
	}

	public String getMes() {
		return mes;
	}

	public Long getVenta() {
		return venta;
	}
	
}
