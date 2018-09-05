package cn.com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.lin.entity.User;
import cn.com.lin.service.UserService;
import cn.com.lin.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName, password);
		if (userService.isUserExist(user)) {
			String message = "该用户已存在，请修改用户名";
			request.setAttribute("message", message);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		userService.addUser(user);
		String message = userName + " ,恭喜您注册成功！！";
		request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
