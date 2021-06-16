package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserImpl;
import model.User;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
	dispatcher.forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserImpl();
		User user = userDao.getByname(username);
		if(user != null && user.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", user);
			
			if(user.getRole().equals("admin")) {
				resp.sendRedirect("/sp/admin");
			}else {
				resp.sendRedirect("/sp/member");
			}
		}else {
			resp.sendRedirect("/sp/login");
		}
	}
}
