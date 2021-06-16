package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	void insert(Product product) throws Exception;

	void delete(int id) throws Exception;
	
	void update(Product product);
	
	Product get(int id) throws Exception;
	
	List<Product> listProduct(String name);
	
	void update(int id, int quantity);
}
