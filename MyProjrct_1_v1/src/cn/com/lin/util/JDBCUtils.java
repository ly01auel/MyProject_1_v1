package cn.com.lin.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driver = null;
	/**
	 * 静态代码块中（只加载一次）
	 */
	static {
		Properties pro = new Properties();
		try {
			InputStream in = JDBCUtils.class.getResourceAsStream("db.properties");
			pro.load(in);

			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			driver = pro.getProperty("driver");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {

		}
	}

	/**
	 * 抽取获取连接对象的方法
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败了!");
		}

		return connection;
	}

	/**
	 * 释放资源的方法
	 */
	public static void clossConnection(Connection conn, Statement stat) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 释放资源的方法2
	 */
	public static void clossConnection(Connection conn, Statement stat, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
