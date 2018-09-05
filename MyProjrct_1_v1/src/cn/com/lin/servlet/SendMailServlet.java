package cn.com.lin.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 定义返回的信息
		String msg = "";
		boolean flag = false;
		/** 获取参数 **/
		// 收件人
		String revicer = request.getParameter("reciver");
		// 标题
		String title = request.getParameter("title");
		// 内容
		String content = request.getParameter("content");
		/**            **/

		try {
			// 读取配置文件
			InputStream in = SendMailServlet.class.getResourceAsStream("/mail.properties");
			Properties props = new Properties();
			props.load(in);
			// 创建会话
			Session session = Session.getInstance(props);
			// 穿件邮件体对象(一封邮件对象)
			MimeMessage message = new MimeMessage(session);

			message.setSubject(title);
			message.setSentDate(new Date());
			message.setFrom(props.getProperty("user"));
			message.setRecipient(RecipientType.TO, new InternetAddress(revicer));
			message.setContent(content, "text/html;charset=utf-8");

			Transport trans = session.getTransport();
			trans.connect(props.getProperty("user"), props.getProperty("password"));
			trans.sendMessage(message, message.getAllRecipients());
			trans.close();

			msg = "邮件已发送,具体请到邮件客户端进行确认!";
			flag = true;
		} catch (Exception e) {
			msg = "邮件发送失败,详细原因请联系管理员!";
			e.printStackTrace();
		} finally {
			request.setAttribute("msg", msg);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/sendMail.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
