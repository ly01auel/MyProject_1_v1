package cn.com.lin.test;

import java.sql.Connection;

import org.junit.Test;

import cn.com.lin.util.JDBCUtils_v2;

public class TestJDBCUtils_v2 {
	@Test
	public void TestGetConnection() {
		Connection conn = JDBCUtils_v2.getConnection();
		System.out.println(conn);
	}
	
	@Test
	public void TestGetQueryRunner() {
		System.out.println(JDBCUtils_v2.getQueryRunner());
	}
}
