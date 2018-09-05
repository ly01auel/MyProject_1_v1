package cn.com.lin.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.com.lin.entity.Contact;
import cn.com.lin.entity.ContactCondition;
import cn.com.lin.entity.PageBean;
import cn.com.lin.entity.User;
import cn.com.lin.service.IContactService;
import cn.com.lin.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class SerchByCondition
 */
@WebServlet("/SerchByCondition")
public class SerchByCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IContactService contactService = new ContactServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ContactCondition condition = null;
		String current = request.getParameter("currentPage");
		int currentPage = 1;
		if (current != null) {
			currentPage = Integer.parseInt(current);
			condition =(ContactCondition)request.getSession().getAttribute("condition");
		}else {
			Map<String, String[]> parameter = request.getParameterMap();
			condition = new ContactCondition();
			try {
				BeanUtils.populate(condition, parameter);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		PageBean<Contact> pb = new PageBean<Contact>();
		pb.setCurrentPage(currentPage);
		User user = (User) request.getSession().getAttribute("user");
		pb.setUser(user);
		contactService.serchByCondition(condition, pb);
		request.getSession().setAttribute("condition", condition);
		request.setAttribute("condition", condition);
		request.setAttribute("pageBean", pb);
		request.getRequestDispatcher("/serchContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
