package cn.com.lin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.com.lin.dao.IDirtyWordDao;
import cn.com.lin.util.JDBCUtils_v2;

public class DirtyWordDaoImpl implements IDirtyWordDao {
	QueryRunner qr = JDBCUtils_v2.getQueryRunner();

	// 获取脏话数据实现
	@Override
	public List<String> getDirtyWord() {
		List<String> list = null;

		// sql
		String sql = "select dirtyWord from t_dirtyWord;";

		// 执行sql
		try {
			list = qr.query(sql, new ResultSetHandler<List<String>>() {
				@Override
				public List<String> handle(ResultSet rs) throws SQLException {
					List<String> reslist = new ArrayList<String>();
					while (rs.next()) {
						String word = rs.getString(1);
						reslist.add(word);
					}
					return reslist;
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
