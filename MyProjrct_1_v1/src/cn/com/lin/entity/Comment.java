package cn.com.lin.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
	private int comm_id;
	private String comm_content;
	private String comm_time;
	private String uid;
	private String uname;

	public Comment() {
		setTime();
	}

	private void setTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		String currentTime = sdf.format(date);
		setComm_time(currentTime);
	}

	public int getComm_id() {
		return comm_id;
	}

	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}

	public String getComm_content() {
		return comm_content;
	}

	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}

	public String getComm_time() {
		return comm_time;
	}

	public void setComm_time(String comm_time) {
		this.comm_time = comm_time;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "Comment [comm_id=" + comm_id + ", comm_content=" + comm_content + ", comm_time=" + comm_time + ", uid="
				+ uid + ", uname=" + uname + "]";
	}

}
