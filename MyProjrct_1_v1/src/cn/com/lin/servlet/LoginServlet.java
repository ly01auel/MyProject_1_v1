package cn.com.lin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.SetAdapterChange;

import cn.com.lin.entity.User;
import cn.com.lin.service.UserService;
import cn.com.lin.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		User user = new User(userName, password);
		// 定义跳转路径
		String uri = "";
		if (userService.isLoginOk(user)) {
			request.getSession().setAttribute("user", user);

			// 获取现在时间存入cookie发送给浏览器
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd<==>hh:mm:ss");
			Date date = new Date();
			String timeNow = sdf.format(date);
			String timeLast = null;
			Cookie timeLastCookie = null;
			String message = null;
			Cookie[] cookies = request.getCookies();
			if (cookies.length != 0) {
				for (Cookie cookie : cookies) {
					if ("timeLast".equals(cookie.getName())) {
						timeLastCookie = cookie;
						timeLast = cookie.getValue();
						break;
					}
				}
			}

			if (timeLastCookie != null && timeLast != null) {
				// 非首次
				message = userName + ",欢迎回来.       您上次登陆时间为:" + timeLast;
				timeLastCookie.setValue(timeNow);
				response.addCookie(timeLastCookie);
			} else {
				// 首次
				message = userName + ",欢迎您登录本系统.       现在时间为北京时间:" + timeNow;
				timeLastCookie = new Cookie("timeLast", timeNow);
				response.addCookie(timeLastCookie);
			}
			request.setAttribute("tiemNow", timeNow);
			request.setAttribute("message", message);
			uri = "/loginSuccess.jsp";
		} else {
			String message = "用户明或密码错误!";
			request.setAttribute("message", message);
			uri = "/login.jsp";
		}
		
		request.getRequestDispatcher(uri).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
