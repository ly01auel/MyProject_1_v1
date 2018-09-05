package cn.com.lin.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils_v2 {
	/**
	 * 1. 初始化C3P0连接池
	 */
	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	/**
	 * 获取连接返回Connection
	 */
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// 获取失败
			System.out.println("C3p0---ComboPooledDataSource---获取连接失败");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 2. 创建DbUtils核心工具类对象
	 */
	public static QueryRunner getQueryRunner() {
		// 创建QueryRunner对象，传入连接池对象
		return new QueryRunner(ds);
	}
}
