package cn.com.lin.service;

import java.util.List;

import cn.com.lin.entity.Comment;

public interface ICommentService {
	// 添加评论
	public int insertComment(Comment comm);

	// 查询全部评论
	public List<Comment> findAllComment();
}
