package cn.com.lin.service.impl;

import java.util.List;

import cn.com.lin.dao.ICommentDao;
import cn.com.lin.dao.impl.CommentDaoImpl;
import cn.com.lin.entity.Comment;
import cn.com.lin.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	private ICommentDao commDao = new CommentDaoImpl();

	@Override
	public int insertComment(Comment comm) {
		return commDao.insertComment(comm);
	}

	@Override
	public List<Comment> findAllComment() {
		return commDao.findAllComment();
	}

}
