package cn.com.lin.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.com.lin.dao.ICommentDao;
import cn.com.lin.entity.Comment;
import cn.com.lin.util.JDBCUtils_v2;

public class CommentDaoImpl implements ICommentDao {
	private QueryRunner qr = JDBCUtils_v2.getQueryRunner();

	@Override
	public int insertComment(Comment comm) {
		String sql = "insert into t_comment(comm_content,comm_time,comm_uid) values(?,?,?);";
		String sql2 = "select @@IDENTITY";
		// 定义自增长主键
		BigInteger key = null;
		// 准备参数
		Object[] params = new Object[] { comm.getComm_content(), comm.getComm_time(), comm.getUid() };

		try {
			qr.update(sql, params);
			key = qr.query(sql2, new ScalarHandler<BigInteger>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key.intValue();
	}

	@Override
	public List<Comment> findAllComment() {
		List<Comment> commentList = null;

		String sql = "select c.comm_id,c.comm_content,c.comm_time,u.uid,u.uname from t_comment c left join t_user u on c.comm_uid = u.uid;";

		try {
			commentList = qr.query(sql, new BeanListHandler<Comment>(Comment.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}

}
