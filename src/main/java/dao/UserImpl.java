package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.User;

public class UserImpl implements UserDao {

	@Override
	public void insert(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "insert into user(id, name, username, password, role) value(?, ?, ? ,? ,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getUsername());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getRole());
		int rs = preparedStatement.executeUpdate();
	}

	@Override
	public void delete(int id) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();

		try {
			String sql = "DELETE FROM user where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			int rs = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			String sql = "update user set name = ?,username =?, password = ?, role = ? where id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(5, user.getId());
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());

			int rs = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public User get(int id) throws Exception {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "select * from user where id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			return user;
		}
		return null;

	}

	@Override
	public List<User> listUser(String name) {
		String sql = "select * from user where name like ?";
		ArrayList<User> list = new ArrayList<User>();
		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name+"%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User getByname(String username) {
		String sql = "select * from user where username = ?";
		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
