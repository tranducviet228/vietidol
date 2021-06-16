package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryImpl implements CategoryDao {

	@Override
	public void insert(Category category) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "insert into category(id, name) value(?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, category.getId());
		preparedStatement.setString(2, category.getName());

		int rs = preparedStatement.executeUpdate();

	}

	@Override
	public void delete(int id) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "delete from category where id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		int rs = preparedStatement.executeUpdate();
	}

	@Override
	public void update(Category category) {
		Connection connection  = JDBCConnection.getJDBCConnection();
		try {
		String sql = "update category set name = ? where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, category.getName());
		preparedStatement.setInt(2, category.getId());
		
		int rs = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category get(int id) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "select * from category where id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			int cid = rs.getInt("id");
			String cname = rs.getString("name");
			Category category = new Category();
			category.setId(cid);
			category.setName(cname);
			return category;
		}
		return null;
	}

	@Override
	public List<Category> listCategory(String name) {
		Connection connection = JDBCConnection.getJDBCConnection();
		ArrayList<Category> list = new ArrayList<Category>();
		try {
		String sql = "select * from category where name like ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name +"%");
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			int cid = rs.getInt("id");
			String cname = rs.getString("name");
			Category category = new Category();
			category.setId(cid);
			category.setName(cname);
			
			list.add(category);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
