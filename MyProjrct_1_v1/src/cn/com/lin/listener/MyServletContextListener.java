package cn.com.lin.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.com.lin.entity.User;

public class MyServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Map<String,User> onlineUserMap= new HashMap<>();
		sce.getServletContext().setAttribute("onlineUserMap", onlineUserMap);
		System.out.println(sce.getServletContext());
		System.out.println("onlineUserMap创建,并塞入ServletContext域对象");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().removeAttribute("onlineUserMap");
		System.out.println("ServletContext中的onlineUserMap已销毁");
	}
}
