package cn.com.lin.test;

import java.util.List;

import org.junit.Test;

import cn.com.lin.dao.impl.ContactDaoImpl;
import cn.com.lin.entity.Contact;
import cn.com.lin.entity.PageBean;
import cn.com.lin.entity.User;

public class TestContactDao {
	ContactDaoImpl cdi = new ContactDaoImpl();
	@Test
	public void testGetConnection() {
		PageBean<Contact> pb = new PageBean<Contact>();
		pb.setCurrentPage(1);
		User u = new User("ffaba0ae991d47679a0a38616bb07f58", null, null);
		pb.setUser(u);
		cdi.findPageDate(pb);
		System.out.println(pb);
	}
	
	@Test
	public void testGetConnection2() {
		PageBean<Contact> pb = new PageBean<Contact>();
		pb.setCurrentPage(1);
		User u = new User("ffaba0ae991d47679a0a38616bb07f58", null, null);
		pb.setUser(u);
		cdi.findPageDate(pb);
		List<Contact> dataList = pb.getDataList();
		for(Contact c : dataList) {
			System.out.println(c);
		}
	}
	
	@Test
	public void testAddContact() {
		String uid= "ffaba0ae991d47679a0a38616bb07f58";
		Contact contact = new Contact();
		contact.setCon_name("王飞飞飞");
		contact.setCon_sex("男");
		contact.setCon_age(30);
		contact.setCon_tel("13415678904");
		contact.setCon_qq("2323232323333");
		contact.setCon_email("wangdali@qq.com");
		int key = cdi.addContact(contact, uid);
		System.out.println(key);
	}
	
	@Test
	public void testFindContactById() {
		Contact con = cdi.findContactById(18);
		System.out.println(con);
	}
	
	@Test
	public void testModifyContact() {
		int id = 18;
		Contact contact = new Contact();
		contact.setCon_name("除臭");
		contact.setCon_sex("男");
		contact.setCon_age(56);
		contact.setCon_tel("90909090111");
		contact.setCon_qq("32333333");
		contact.setCon_email("chuchou@qq.com");
		cdi.modifyContact(contact, id);
	}
}
