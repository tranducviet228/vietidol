package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.ProductImpl;
import model.Product;

@WebServlet(urlPatterns = "/member/seachnameproduct")
public class MemberSeachNameProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		ProductDao productDao = new ProductImpl();
		if(name == null) {
			name ="";
		}
		List<Product> product = productDao.listProduct(name);
		req.setAttribute("list", product);
		req.getRequestDispatcher("/member-seach-name-product.jsp").forward(req, resp);
	}
}
