package cn.com.lin.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.lin.dao.IDirtyWordDao;
import cn.com.lin.dao.impl.DirtyWordDaoImpl;

/**
 * Servlet Filter implementation class DirtyWordFilter
 */
public class DirtyWordFilter implements Filter {
	IDirtyWordDao dirtyWord = new DirtyWordDaoImpl();

	public DirtyWordFilter() {
		System.out.println("DirtyWordFilter构造");
	}

	public void destroy() {
		System.out.println("DirtyWordFilter销毁");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("DirtyWordFilter核心方法");
		// 向下转型
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 获取数据
		String comment = request.getParameter("comment");
		//定义过滤后的字符串
		String newComment = null;
		// 初始化需要过滤的数据
		List<String> list = dirtyWord.getDirtyWord();

		// 判断发表内容中时都存在需要过滤的词汇,有则过滤
		if (comment != null && !"".equals(comment.trim())) {
			for (String s : list) {
				if (comment.contains(s)) {
					comment = comment.replace(s, "***");
				}
			}
			request.setAttribute("comment", comment);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DirtyWordFilter初始化");
	}
}
