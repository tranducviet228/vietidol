package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillDao;
import dao.BillImpl;
import dao.ProductDao;
import dao.ProductImpl;
import model.Bill;
import model.Product;

@WebServlet(urlPatterns = "/member/createbill")
public class MemberCreateBill extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/member-create-bill.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String quantity = req.getParameter("quantity");
		String price = req.getParameter("price");
		String date = req.getParameter("date");
		String idproduct = req.getParameter("idproduct");
		try {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		ProductDao productDao = new ProductImpl();
		Product product = productDao.get(Integer.parseInt(idproduct));
		
		Bill bill = new Bill();
		bill.setId(Integer.parseInt(id));
		bill.setQuantity(Integer.parseInt(quantity));
		bill.setPrice(Integer.parseInt(price));
		bill.setBuyDate(simpleDateFormat.parse(date));
		bill.setProduct(product);
		 
		BillDao billDao = new BillImpl();
		billDao.createBill(bill);
		
		int afterQuantity = bill.getProduct().getQuantity()-bill.getQuantity();
		productDao.update(bill.getProduct().getId(), afterQuantity);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<h1>Thành công</h1>");
		}catch (Exception e) {
			e.printStackTrace();
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("<h1>Thất bại</h1>");
		}
	}
}
