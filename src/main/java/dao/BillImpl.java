package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Bill;

public class BillImpl implements BillDao{

	@Override
	public void createBill(Bill bill) {
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			String sql = "insert into bill(id,quantity,price,date,idproduct) value(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bill.getId());
			preparedStatement.setInt(2, bill.getQuantity());
			preparedStatement.setInt(3, bill.getPrice());
			preparedStatement.setDate(4, new java.sql.Date(bill.getBuyDate().getTime()));
			preparedStatement.setInt(5, bill.getProduct().getId());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
