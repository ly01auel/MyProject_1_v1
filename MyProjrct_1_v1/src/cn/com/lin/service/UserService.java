package cn.com.lin.service;

import cn.com.lin.entity.User;

public interface UserService {
	// 添加联系人
	public void addUser(User user);

	// 连接练习存在性
	public boolean isUserExist(User user);

	// 用姓名查找User
	public boolean isLoginOk(User user);
}
