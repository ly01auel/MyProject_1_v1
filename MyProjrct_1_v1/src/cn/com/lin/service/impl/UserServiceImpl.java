package cn.com.lin.service.impl;

import cn.com.lin.dao.IUserDao;
import cn.com.lin.dao.impl.UserDaoImpl;
import cn.com.lin.entity.User;
import cn.com.lin.service.UserService;

public class UserServiceImpl implements UserService {

	private static IUserDao dao = new UserDaoImpl();

	@Override
	public void addUser(User user) {
		dao.addUser(user);

	}

	@Override
	public boolean isUserExist(User user) {
		return dao.isUserExist(user);
	}

	@Override
	public boolean isLoginOk(User user) {
		return dao.isLoginOk(user);
	}

}
