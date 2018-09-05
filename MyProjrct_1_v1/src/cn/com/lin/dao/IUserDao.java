package cn.com.lin.dao;

import cn.com.lin.entity.User;

public interface IUserDao {
	// 添加联系人
	public void addUser(User user);

	// 连接练习存在性
	public boolean isUserExist(User user);

	// 通过姓名查找USER
	public boolean isLoginOk(User user);
}
