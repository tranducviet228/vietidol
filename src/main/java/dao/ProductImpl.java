package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Product;

public class ProductImpl implements ProductDao {

	@Override
	public void insert(Product product) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "insert into product(id, pname, price, category,quantity) value(?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setInt(3, product.getPrice());
		preparedStatement.setInt(4, product.getCategory().getId());
		preparedStatement.setInt(5, product.getQuantity());
		int rs = preparedStatement.executeUpdate();

	}

	@Override
	public void delete(int id) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "delete from product where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rs = preparedStatement.executeUpdate();

	}

	@Override
	public void update(Product product) {
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			String sql = "update product set pname = ?, price = ?, category = ?, quantity = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(5, product.getId());
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, product.getPrice());
			preparedStatement.setInt(3, product.getCategory().getId());
			preparedStatement.setInt(4, product.getQuantity());
			int rs = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product get(int id) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "select product.id,product.pname,product.price,product.quantity,category.name \r\n"
				+ "from product,category\r\n" + "where product.category = category.id and product.id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int pid = rs.getInt("id");
			String pname = rs.getString("pname");
			int pprice = rs.getInt("price");
			int pquantity = rs.getInt("quantity");
			 
			String cname = rs.getString("name");
			Product product = new Product();
			Category category = new Category();
			category.setName(cname);

			product.setId(pid);
			product.setName(pname);
			product.setPrice(pprice);
			product.setQuantity(pquantity);
			product.setCategory(category);

			return product;
		}
		return null;
	}

	@Override
	public List<Product> listProduct(String name) {
		Connection connection = JDBCConnection.getJDBCConnection();
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			String sql = "select product.id,product.pname,product.price,product.quantity,category.name\r\n"
					+ "from product,category where product.category = category.id and product.pname like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String pname = rs.getString("pname");
				int pprice = rs.getInt("price");
				int pquantity = rs.getInt("quantity");
				String cname = rs.getString("name");
				Product product = new Product();
				product.setId(pid);
				product.setName(pname);
				product.setPrice(pprice);
				product.setQuantity(pquantity);
				Category category = new Category();
				category.setName(cname);
				
				product.setCategory(category);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(int id, int quantity) {
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			String sql = "update product set quantity = ? where id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, id);
			int rs = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
