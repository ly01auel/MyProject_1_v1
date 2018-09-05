package cn.com.lin.test;

import org.junit.Test;

import cn.com.lin.dao.impl.UserDaoImpl;
import cn.com.lin.entity.User;
import junit.framework.Assert;

public class TestUserDaoImpl {
	@Test
	public void testUserDaoImpl_addUser() {
		User u = new User("王五一", "654321");
		UserDaoImpl ud = new UserDaoImpl();
		ud.addUser(u);
	}

	@Test
	public void testUserDaoImpl_isUserExist() {
		User u = new User("王五一", "654321");
		UserDaoImpl ud = new UserDaoImpl();
		boolean result = ud.isUserExist(u);
		Assert.assertSame(true, result);
	}

	@Test
	public void testUserDaoImpl_isUserExist2() {
		User u = new User("李静静", "654321");
		UserDaoImpl ud = new UserDaoImpl();
		boolean result = ud.isUserExist(u);
		Assert.assertSame(true, result);
	}

	@Test
	public void testUserDaoImpl_isUserExist3() {
		User u = new User("网而无", "654321");
		UserDaoImpl ud = new UserDaoImpl();
		boolean result = ud.isUserExist(u);
		Assert.assertSame(false, result);
	}

	@Test
	public void testUserDaoImpl_isLoginOk1() {
		User u = new User("李静静", "123456");
		UserDaoImpl ud = new UserDaoImpl();
		boolean result = ud.isLoginOk(u);
		Assert.assertSame(true, result);
	}

	@Test
	public void testUserDaoImpl_isLoginOk2() {
		User u = new User("李静静", "111222");
		UserDaoImpl ud = new UserDaoImpl();
		boolean result = ud.isLoginOk(u);
		Assert.assertSame(false, result);
	}
}
