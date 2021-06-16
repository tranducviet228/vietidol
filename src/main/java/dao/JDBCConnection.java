package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/sp";
		final String user = "root";
		final String password = "conchongoan228";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static void main(String[] args) {
		Connection connection = getJDBCConnection();
		if (connection != null) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
	}
}
