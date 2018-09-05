package cn.com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.lin.entity.Contact;
import cn.com.lin.entity.PageBean;
import cn.com.lin.entity.User;
import cn.com.lin.service.IContactService;
import cn.com.lin.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class ContactShowPage
 */
@WebServlet("/ContactShowPage")
public class ContactShowPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IContactService contactService = new ContactServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String current = request.getParameter("currentPage");
			int currentPage = 1;
			if (current != null) {
				currentPage = Integer.parseInt(current);
			}

			PageBean<Contact> pb = new PageBean<Contact>();
			pb.setCurrentPage(currentPage);
			User user = (User) request.getSession().getAttribute("user");
			pb.setUser(user);
			contactService.findPageDate(pb);
			request.setAttribute("pageBean", pb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/showAllContact.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
