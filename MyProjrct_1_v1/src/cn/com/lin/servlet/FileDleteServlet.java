package cn.com.lin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDleteServlet")
public class FileDleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 取得文件名
		String fileName = (String) request.getParameter("fileName");

		// 取得目标的所在文件夹
		String uploadPath = request.getServletContext().getRealPath("/upload");

		// 构建file
		File file = new File(uploadPath, fileName);

		// 如果file存在且不是个文件夹，则删除
		if (file.exists() && !file.isDirectory()) {
			file.delete();
		}
		// 重定向到upload页面
		response.sendRedirect(request.getContextPath() + "/CoreController/fileUploadAndDownload");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
