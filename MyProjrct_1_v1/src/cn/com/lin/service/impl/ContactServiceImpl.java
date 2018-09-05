package cn.com.lin.service.impl;

import cn.com.lin.dao.IContactDao;
import cn.com.lin.dao.impl.ContactDaoImpl;
import cn.com.lin.entity.Contact;
import cn.com.lin.entity.ContactCondition;
import cn.com.lin.entity.PageBean;
import cn.com.lin.service.IContactService;

public class ContactServiceImpl implements IContactService {
	IContactDao icd = new ContactDaoImpl();

	@Override
	public void findPageDate(PageBean<Contact> pb) {
		icd.findPageDate(pb);
	}

	@Override
	public void addContact(Contact contact, String uid) {
		int key = icd.addContact(contact, uid);
		contact.setCon_id(key);
	}

	@Override
	public Contact findContactById(int id) {
		return icd.findContactById(id);
	}

	@Override
	public void modifyContact(Contact contact, int id) {
		icd.modifyContact(contact, id);
	}

	@Override
	public void deleteContact(int id) {
		icd.deleteContact(id);
	}

	@Override
	public void serchByCondition(ContactCondition condition, PageBean<Contact> pb) {
		icd.serchByCondition(condition, pb);
		
	}
}
