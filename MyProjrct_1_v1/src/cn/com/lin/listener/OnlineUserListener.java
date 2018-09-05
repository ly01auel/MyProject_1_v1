package cn.com.lin.listener;

import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.com.lin.entity.User;

public class OnlineUserListener implements HttpSessionAttributeListener {
	@Override
	@SuppressWarnings("unchecked")
	public void attributeAdded(HttpSessionBindingEvent se) {
		if ("user".equals(se.getName())) {
			Object obj = se.getSession().getServletContext().getAttribute("onlineUserMap");
			System.out.println(se.getSession().getServletContext());
			if (obj != null && obj instanceof Map) {
				Map<String, User> onlineUserMap = (Map<String, User>) obj;
				User user = (User) se.getValue();
				if (user != null) {
					String key = user.getId();
					onlineUserMap.put(key, user);
				}

			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void attributeReplaced(HttpSessionBindingEvent se) {
		if ("user".equals(se.getName())) {
			Object obj = se.getSession().getServletContext().getAttribute("onlineUserMap");
			if (obj != null && obj instanceof Map) {
				Map<String, User> onlineUserMap = (Map<String, User>) obj;
				User user = (User)se.getSession().getAttribute("user");
				if (user != null) {
					String key = user.getId();
					onlineUserMap.replace(key, user);
				}

			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void attributeRemoved(HttpSessionBindingEvent se) {
		if ("user".equals(se.getName())) {
			Object obj = se.getSession().getServletContext().getAttribute("onlineUserMap");
			if (obj != null && obj instanceof Map) {
				Map<String, User> onlineUserMap = (Map<String, User>) obj;
				User user = (User) se.getValue();
				if (user != null) {
					String key = user.getId();
					onlineUserMap.remove(key);
				}

			}
		}
	}
}
