package cn.com.lin.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public EncodingFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("加载了EncodingFilter");
	}

	/**
	 * 过滤器业务处理方法：处理的公用的业务逻辑操作
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入了Encoding的doFilter方法");
		// 转型
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 一、处理公用业务
		request.setCharacterEncoding("UTF-8"); // POST提交有效
		response.setContentType("text/html;charset=UTF-8");

		/*
		 * 出现GET中文乱码，是因为在request.getParameter方法内部没有进行提交方式判断并处理。 String name =
		 * request.getParameter("userName");
		 * 
		 * 解决：对指定接口的某一个方法进行功能扩展，可以使用代理! 对request对象(目标对象)，创建代理对象！
		 */
		HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), // 指定当前使用的累加载器
				new Class[] { HttpServletRequest.class }, // 对目标对象实现的接口类型
				new InvocationHandler() {// 事件处理器

					// 定义方法返回值
					Object returnValue = null;

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if ("getParameter".equals(method.getName())) {
							System.out.println("进入了Encoding的doFilter方法---创建了request对象的代理对象");
							
							// 获取请求数据值
							String paramValue = request.getParameter(args[0].toString());

							// 获取提交方式(get/post)
							String submitType = request.getMethod();

							// post提交没问题,如果是get方法则走下列分支
							if ("GET".equalsIgnoreCase(submitType)) {
								// 获取请求数据值不为空
								if (paramValue != null && !"".equals(paramValue.trim())) {
									// 处理GET中文
									paramValue = new String(paramValue.getBytes("IOS8859-1"), "utf-8");
									System.out.println("进入了Encoding的doFilter方法---创建了request对象的代理对象---代理对象对getParamter获取的值进行了转码");
								}
							}

							return paramValue;
						} else {
							returnValue = method.invoke(request, args);
						}
						return returnValue;
					}
				});

		// 方形
		chain.doFilter(proxy, response);// 传入代理对象
	}
}
