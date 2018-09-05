package cn.com.lin.entity;

public class Contact {
	private int con_id;
	private String con_name;
	private String con_sex;
	private int con_age;
	private String con_tel;
	private String con_qq;
	private String con_email;

	public Contact() {
		super();
	}

	public Contact(int con_id, String con_name, String con_sex, int con_age, String con_tel, String con_qq,
			String con_email) {
		super();
		this.con_id = con_id;
		this.con_name = con_name;
		this.con_sex = con_sex;
		this.con_age = con_age;
		this.con_tel = con_tel;
		this.con_qq = con_qq;
		this.con_email = con_email;
	}

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public String getCon_name() {
		return con_name;
	}

	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}

	public String getCon_sex() {
		return con_sex;
	}

	public void setCon_sex(String con_sex) {
		this.con_sex = con_sex;
	}

	public int getCon_age() {
		return con_age;
	}

	public void setCon_age(int con_age) {
		this.con_age = con_age;
	}

	public String getCon_tel() {
		return con_tel;
	}

	public void setCon_tel(String con_tel) {
		this.con_tel = con_tel;
	}

	public String getCon_qq() {
		return con_qq;
	}

	public void setCon_qq(String con_qq) {
		this.con_qq = con_qq;
	}

	public String getCon_email() {
		return con_email;
	}

	public void setCon_email(String con_email) {
		this.con_email = con_email;
	}

	@Override
	public String toString() {
		return "Contact [con_id=" + con_id + ", con_name=" + con_name + ", con_sex=" + con_sex + ", con_age=" + con_age
				+ ", con_tel=" + con_tel + ", con_qq=" + con_qq + ", con_email=" + con_email + "]";
	}


}
