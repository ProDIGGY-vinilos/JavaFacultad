package ej6.data;

import ej6.entities.Product;

import java.sql.*;
import java.util.LinkedList;

public class ProductData {
	public LinkedList<Product> getAll() {
		Statement st = null;
		ResultSet rs = null;
		LinkedList<Product> prods = new LinkedList<>();
		try {
			st = ConnectionManager.getInstancia().getConn()
			                      .createStatement();
			String query = "SELECT id, description, price, stock, " +
					  "shippingIncluded FROM product";
			rs = st.executeQuery( query );
			if (rs!=null){
				while(rs.next()) {
					Product p = new Product();
					p.setId( rs.getInt( "id" ) );
					p.setName( rs.getString( "description" ) );
					p.setPrice( rs.getDouble( "price" ) );
					p.setStock( rs.getInt( "stock" ) );
					p.setShippingncluded( rs.getBoolean(
							  "shippingIncluded" ) );
					prods.add( p );
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException( e );
		} finally {
			try {
				if(rs!=null){rs.close();}
				if (st!=null){st.close();}
				ConnectionManager.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prods;
	}

	public  Product getById(int id) {
		Product prod = new Product();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT id, description, price, stock, " +
					  "shippingIncluded FROM product WHERE id = ?";
			ps = ConnectionManager.getInstancia().getConn().prepareStatement( query );
			ps.setInt( 1, id );
			rs = ps.executeQuery();
			if (rs!=null && rs.next()) {
				prod.setId( id );
				prod.setName( rs.getString( "name" ) );
				prod.setDescription( rs.getString( "description" ) );
				prod.setPrice( rs.getDouble( "price" ) );
				prod.setStock( rs.getInt( "price" ) );
				prod.setShippingncluded( rs.getBoolean(
						  "shippingIncluded" ) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){rs.close();}
				if (ps!=null){ps.close();}
				ConnectionManager.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prod;
	}

	public void updateOne (Product pr) {
		PreparedStatement st = null;
		try {
			String query = "UPDATE product SET name, description, " +
					  "price, stock, shippingIncluded VALUES (?,?,?,?,?)" +
					  " " +
					  "WHERE id = ?";
			st = ConnectionManager.getInstancia().getConn().prepareStatement( query );
			st.setString( 1, pr.getName());
			st.setString( 2, pr.getDescription() );
			st.setDouble( 3, pr.getPrice() );
			st.setInt( 4, pr.getStock() );
			st.setBoolean( 5, pr.isShippingncluded() );
			st.setInt( 6, pr.getId() );
			st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st!=null){st.close();}
				ConnectionManager.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteOne (Product pr) {
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM product WHERE id = ?";
			st =
					  ConnectionManager.getInstancia().getConn().prepareStatement( query );
			st.setInt( 1, pr.getId() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st!=null){st.close();}
				ConnectionManager.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
