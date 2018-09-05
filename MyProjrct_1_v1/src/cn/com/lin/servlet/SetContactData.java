package cn.com.lin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.lin.entity.Contact;
import cn.com.lin.service.IContactService;
import cn.com.lin.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class ModifyContact
 */
@WebServlet("/SetContactData")
public class SetContactData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IContactService service = new ContactServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("con_id"));
		Contact contact = service.findContactById(uid);
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/modifyContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
