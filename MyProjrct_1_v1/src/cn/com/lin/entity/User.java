package cn.com.lin.entity;

import java.util.UUID;

public class User {
	private String id;
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setId() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		this.id = uuid;
	}

	public User() {
		super();
		setId();
	}

	public User(String userName, String password) {
		super();
		setId();
		this.userName = userName;
		this.password = password;
	}

	public User(String id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}
