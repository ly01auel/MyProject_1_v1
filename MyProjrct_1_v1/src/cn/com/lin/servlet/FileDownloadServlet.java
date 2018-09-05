package cn.com.lin.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载
 */
@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取下载文件的的路劲
		String fileName = (String) request.getParameter("fileName");
		// 获取输入输出流
		String uploadPath = request.getServletContext().getRealPath("/upload");
		File file = new File(uploadPath, fileName);
		InputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		// 设置响应头
		response.setHeader("content-disposition", "attachment;fileName=" + fileName);

		// 写出文件,一边读一边写
		byte[] bye = new byte[1024];
		int length = 0;
		while ((length = in.read(bye)) != -1) {
			out.write(bye, 0, length);
		}
		// 关闭流
		out.flush();
		out.close();
		in.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
