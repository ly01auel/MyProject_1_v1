package cn.com.lin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.lin.entity.Comment;
import cn.com.lin.entity.User;
import cn.com.lin.service.ICommentService;
import cn.com.lin.service.impl.CommentServiceImpl;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICommentService service = new CommentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取uid
		User user = (User) request.getSession().getAttribute("user");
		String uid = null;
		if (user != null) {
			uid = user.getId();
		}
		// 获取用户评论
		String comm = (String) request.getAttribute("comment");

		if (comm != null && !"".equals(comm.trim())) {
			Comment comment = new Comment();
			comment.setComm_content(comm);
			comment.setUid(uid);
			service.insertComment(comment);
		}

		List<Comment> commentList = service.findAllComment();

		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("/comment.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
