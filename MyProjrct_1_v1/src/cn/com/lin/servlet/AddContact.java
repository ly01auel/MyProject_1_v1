package cn.com.lin.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.com.lin.entity.Contact;
import cn.com.lin.entity.User;
import cn.com.lin.service.IContactService;
import cn.com.lin.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IContactService service =  new ContactServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Contact contact = new Contact();
			
			Map<String, String[]> parameterMap = request.getParameterMap();
			BeanUtils.populate(contact, parameterMap);
			
			User user = (User)request.getSession().getAttribute("user");
			String uid = user.getId();
			
			service.addContact(contact, uid);
			
			response.sendRedirect(request.getContextPath()+"/ContactShowPage");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
