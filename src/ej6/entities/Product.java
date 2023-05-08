package ej6.entities;

public class Product {
	private int id, stock;
	private String name, description;
	private boolean shippingncluded;
	private double price;

	public Product( int id, int stock, String name, String description,
	                boolean shippingncluded, double price ) {
		this.id = id;
		this.stock = stock;
		this.name = name;
		this.description = description;
		this.shippingncluded = shippingncluded;
		this.price = price;
	}

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock( int stock ) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public boolean isShippingncluded() {
		return shippingncluded;
	}

	public void setShippingncluded( boolean shippingncluded ) {
		this.shippingncluded = shippingncluded;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice( double price ) {
		this.price = price;
	}
}
