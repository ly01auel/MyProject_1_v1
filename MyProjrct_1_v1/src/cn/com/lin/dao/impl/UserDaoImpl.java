package cn.com.lin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.com.lin.dao.IUserDao;
import cn.com.lin.entity.User;
import cn.com.lin.util.JDBCUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			// 获取连接
			conn = JDBCUtils.getConnection();
			// 准备sql
			String sql = "insert into t_user(uid,uname,upassword) values (?,?,?);";

			// 创建prepareStatement对象
			// 预编译sql
			stat = conn.prepareStatement(sql);

			// 添加参数
			stat.setString(1, user.getId());
			stat.setString(2, user.getUserName());
			stat.setString(3, user.getPassword());

			// 执行
			int count = stat.executeUpdate();
			// 打印影响
			System.out.println("影响了" + count + "行");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 关闭连接
			JDBCUtils.clossConnection(conn, stat);
		}

	}

	@Override
	public boolean isUserExist(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			// 获取连接
			conn = JDBCUtils.getConnection();
			// 准备sql
			String sql = "select * from t_user where uname=?;";

			// 创建prepareStatement对象
			// 预编译sql
			stat = conn.prepareStatement(sql);

			// 添加参数
			stat.setString(1, user.getUserName());

			// 执行
			rs = stat.executeQuery();

			// 判断user是否存在
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 关闭连接
			JDBCUtils.clossConnection(conn, stat, rs);
		}
	}

	@Override
	public boolean isLoginOk(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			// 获取连接
			conn = JDBCUtils.getConnection();
			// 准备sql
			String sql = "select * from t_user where uname=?;";

			// 创建prepareStatement对象
			// 预编译sql
			stat = conn.prepareStatement(sql);

			// 添加参数
			stat.setString(1, user.getUserName());

			// 执行
			rs = stat.executeQuery();

			// 判断user是否存在
			while (rs.next()) {
				String upassword = rs.getString("upassword");
				if (upassword != null) {
					if (upassword.equals(user.getPassword())) {
						user.setId(rs.getString(1));
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 关闭连接
			JDBCUtils.clossConnection(conn, stat, rs);
		}
	}

}
