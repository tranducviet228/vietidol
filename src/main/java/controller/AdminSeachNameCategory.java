package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.CategoryImpl;
import model.Category;

@WebServlet(urlPatterns = "/admin/seachnamecategory")
public class AdminSeachNameCategory extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		CategoryDao categoryDao = new CategoryImpl();
		if(name ==null) {
			name = "";
		}
		List<Category> listCategory = categoryDao.listCategory(name);
		req.setAttribute("list", listCategory);
		req.getRequestDispatcher("/admin-seach-name-category.jsp").forward(req, resp);
	}
}
