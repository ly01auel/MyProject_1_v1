package cn.com.lin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoreController
 */
@WebServlet("/CoreController/*")
public class CoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 拦截请求路劲
		String requestPath = request.getRequestURI();
		// 拆分请求路径
		String[] paths = requestPath.split("/");
		// 获得请求
		String location = paths[paths.length - 1];

		System.out.println(location);
		// 注册页面
		if ("register".equals(location)) {
			request.getRequestDispatcher("/RegisterServlet").forward(request, response);
		}

		if ("login".equals(location)) {
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}

		if ("returnToMenu".equals(location)) {
			response.sendRedirect(request.getContextPath() + "/menu.jsp");
		}

		if ("logout".equals(location)) {
			request.getSession().removeAttribute("user");
			response.sendRedirect(request.getContextPath() + "/topPage.jsp");
		}

		if ("showPageAll".equals(location)) {
			request.getRequestDispatcher("/ContactShowPage").forward(request, response);
		}

		if ("AddContact".equals(location)) {
			request.getRequestDispatcher("/AddContact").forward(request, response);
		}

		if (location.indexOf("SetContactData") == 0) {
			request.getRequestDispatcher("/SetContactData").forward(request, response);
		}

		if ("ModifyServlet".equals(location)) {
			request.getRequestDispatcher("/ModifyServlet").forward(request, response);
		}

		if (location.indexOf("DeleteContact") == 0) {
			request.getRequestDispatcher("/DeleteContact").forward(request, response);
		}

		if ("showOnlineUsers".equals(location)) {
			request.getRequestDispatcher("/OnlineDetailServlet").forward(request, response);
		}

		if ("addComment".equals(location)) {
			request.getRequestDispatcher("/AddCommentServlet").forward(request, response);
		}
		if ("SerchByCondition".equals(location)) {
			request.getRequestDispatcher("/SerchByCondition").forward(request, response);
		}
		if ("fileUploadAndDownload".equals(location)) {
			request.getRequestDispatcher("/FileUploadServlet").forward(request, response);
		}
		if ("sendMail".equals(location)) {
			request.getRequestDispatcher("/SendMailServlet").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
