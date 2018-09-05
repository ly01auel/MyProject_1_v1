package cn.com.lin.entity;

import java.util.HashMap;
import java.util.Map;

public class ContactCondition {
	private String con_name;
	private String con_sex;
	private String con_age;
	private String con_tel;
	private String con_qq;
	private String con_email;

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

	public String getCon_age() {
		return con_age;
	}

	public void setCon_age(String con_age) {
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

	public ContactCondition() {
		super();
	}

	// 返回该对象所有条件的值
	public Map<String, String> getConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		if (con_name != null && !con_name.trim().equals("")) {
			conditionMap.put("con_name", con_name);
		}
		if (con_sex != null && !con_sex.trim().equals("")) {
			conditionMap.put("con_sex", con_sex);
		}
		if (con_age != null && !con_age.trim().equals("")) {
			conditionMap.put("con_age", con_age);
		}
		if (con_tel != null && !con_tel.trim().equals("")) {
			conditionMap.put("con_tel", con_tel);
		}
		if (con_qq != null && !con_qq.trim().equals("")) {
			conditionMap.put("con_qq", con_qq);
		}
		if (con_email != null && !con_email.trim().equals("")) {
			conditionMap.put("con_email", con_email);
		}
		return conditionMap;
	}

	@Override
	public String toString() {
		return "ContactContion [con_name=" + con_name + ", con_sex=" + con_sex + ", con_age=" + con_age + ", con_tel="
				+ con_tel + ", con_qq=" + con_qq + ", con_email=" + con_email + "]";
	}

}
