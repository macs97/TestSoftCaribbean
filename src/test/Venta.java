package test;

import java.io.Serializable;

public class Venta implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String date;
	private String nameProduct;
	private String nameDescription;
	
	
	public Venta(int id, String date, String nameProduct, String nameDescription) {
		super();
		this.id = id;
		this.date = date;
		this.nameProduct = nameProduct;
		this.nameDescription = nameDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getNameDescription() {
		return nameDescription;
	}
	public void setNameDescription(String nameDescription) {
		this.nameDescription = nameDescription;
	}
	@Override
	public String toString() {
		return "Venta [id=" + id + ", date=" + date + ", nameProduct=" + nameProduct + ", nameDescription="
				+ nameDescription + "]";
	}
	
	
}
