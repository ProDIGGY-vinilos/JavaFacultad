package ej6.logic;

import ej6.data.ProductData;
import ej6.entities.Product;

import java.util.LinkedList;

public class ProductLogic {
	private ProductData pd;

	public LinkedList<Product> getAll(){
		return pd.getAll();
	}

	public Product getById(int id) {
		return pd.getById( id );
	}

	public void updateOne(Product pr) {
		pd.updateOne( pr );
	}

	public void deleteOne(Product pr){
		pd.deleteOne( pr );
	}
}
