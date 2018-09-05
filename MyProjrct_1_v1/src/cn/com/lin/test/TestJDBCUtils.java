package cn.com.lin.test;

import java.sql.Connection;

import org.junit.Test;

import cn.com.lin.util.JDBCUtils;

public class TestJDBCUtils {
	@Test
	public void getConnection() {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn);
	}
}
