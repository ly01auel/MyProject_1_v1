package cn.com.lin.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.lin.entity.User;

/**
 * 登陆验证过滤器
 * 
 * 北有登录的情况除了登录和注册页面都不可访问
 * 
 * @author Jie.Yuan
 *
 */
@WebFilter(value = "/*", dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD })
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 类型转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取请求uri
		String url = request.getRequestURI();
		String uri = url.substring(url.lastIndexOf("/"), url.length());

		// 判断是否登录
		HttpSession session = request.getSession();
		if (session != null) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				if ("/addContact.jsp".equals(uri) || "/menu.jsp".equals(uri) || "/modifyContact.jsp".equals(uri)
						|| "/showAllContact.jsp".equals(uri) || "/onlineDetails.jsp".equals(uri)
						|| "/comment.jsp".equals(uri) || "/fileUpload.jsp".equals(uri)
						|| "/sendMail.jsp".equals(uri)) {
					uri = "/topPage.jsp";
					request.getRequestDispatcher(uri).forward(request, response);
				}
				chain.doFilter(request, response);
			}
		} else {
			uri = "/topPage.jsp";
			request.getRequestDispatcher(uri).forward(request, response);
		}

	}

}
