package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import dao.UserDao;
import dao.UserImpl;
import model.User;

@WebServlet(urlPatterns = "/admin/seachnameuser")
public class AdminSeachNameUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if (name == null) {
			name = "";
		}
		UserDao userDao = new UserImpl();
		List<User> u = userDao.listUser(name);
		req.setAttribute("listU", u);
		req.getRequestDispatcher("/admin-seach-name-user.jsp").forward(req, resp);
	}

}
