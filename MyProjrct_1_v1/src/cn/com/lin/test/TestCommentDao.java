package cn.com.lin.test;

import java.util.List;

import org.junit.Test;

import cn.com.lin.dao.ICommentDao;
import cn.com.lin.dao.impl.CommentDaoImpl;
import cn.com.lin.entity.Comment;

public class TestCommentDao {
	ICommentDao commDao = new CommentDaoImpl();

	@Test
	public void testInsertComment() {
		Comment comm = new Comment();
		comm.setComm_content(
				"用Navicat为mysql数据库的两个表之间建立外键关系，出现“cannot add foreign key constraint”错误，当时真的不知道是怎么回事儿，~~~~(>_<)~~~~，不过，说到这儿，先谈谈外键的建立吧。");
		comm.setUid("4fd0daa5e45b425d9ac1c2a9c1d28cf2");
		int id = commDao.insertComment(comm);
		System.out.println(id);
	}

	@Test
	public void testFindAllComment() {
		List<Comment> commentList = commDao.findAllComment();
		System.out.println(commentList);
	}
}
