package cn.com.lin.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// upload目录，保存上传的资源
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/********* 文件上传组件： 处理文件上传 ************/
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1. 文件上传工厂
		FileItemFactory factory = new DiskFileItemFactory();
		// 2. 创建文件上传核心工具类
		ServletFileUpload fileUpload = new ServletFileUpload(factory);

		// 一、设置单个文件允许的最大的大小： 30M
		fileUpload.setFileSizeMax(30 * 1024 * 1024);
		// 二、设置文件上传表单允许的总大小: 80M
		fileUpload.setSizeMax(80 * 1024 * 1024);
		// 三、 设置上传表单文件名的编码
		fileUpload.setHeaderEncoding("utf-8");// 相当于：request.setCharacterEncoding("UTF-8");

		// 3. 判断： 当前表单是否为文件上传表单
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> list = fileUpload.parseRequest(request);

				// 文件名
				String fileName = null;
				String customizeName = null;

				// 上传时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmssSSS_");
				String createTime = sdf.format(new Date());

				for (FileItem item : list) {
					if (item.isFormField()) {
						if ("fileName".equals(item.getFieldName())) {
							if(!"".equals(item.getString("utf-8").trim())) {
								customizeName = item.getString("utf-8");
							}
						}
					} else {
						if ("fileContent".equals(item.getFieldName())) {
							// 文件名
							fileName = item.getName();
							if (fileName == null || "".equals(fileName)) {
								request.setAttribute("msg", "请先选择文件之后再点击上传");
								break;
							}
							// 重新命名文件
							if (customizeName != null) {
								fileName = customizeName;
							}
							fileName = createTime + fileName;
							// 上传
							String uploadPath = request.getServletContext().getRealPath("/upload");
							File file = new File(uploadPath, fileName);
							// 写出数据
							item.write(file);
							// 清空临时文件
							item.delete();
						}

					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("不是一个多功能表单，不予处理");
		}

		/********* 获取下载列表 ************/
		String uploadPath = request.getServletContext().getRealPath("/upload");
		File file = new File(uploadPath);
		Map<String, String> downloadList = new HashMap<>();

		if (file.exists()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (!f.isDirectory()) {
					downloadList.put(f.getName(), f.getName());
				}
			}
		}

		request.setAttribute("downloadList", downloadList);
		request.getRequestDispatcher("/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
