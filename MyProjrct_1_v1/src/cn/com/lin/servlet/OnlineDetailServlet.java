package cn.com.lin.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.lin.entity.User;

/**
 * Servlet implementation class OnlineDetailServlet
 */
@WebServlet("/OnlineDetailServlet")
public class OnlineDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,User> onlineUserMap = (Map<String,User>) request.getServletContext().getAttribute("onlineUserMap");
		request.setAttribute("onlineUserMap", onlineUserMap);
		request.getRequestDispatcher("/onlineDetails.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
