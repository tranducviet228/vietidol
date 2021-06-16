package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import dao.ProductDao;
import dao.ProductImpl;
import model.Product;

@WebServlet(urlPatterns = "/admin/seachnameproduct")
public class AdminSeachNameProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		ProductDao productDao = new ProductImpl();
		if(name == null) {
			name ="";
		}
		List<Product> product = productDao.listProduct(name);
		req.setAttribute("listP", product);
		req.getRequestDispatcher("/admin-seach-name-product.jsp").forward(req, resp);
	}
}
