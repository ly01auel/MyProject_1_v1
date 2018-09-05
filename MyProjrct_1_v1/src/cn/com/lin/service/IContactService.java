package cn.com.lin.service;

import cn.com.lin.entity.Contact;
import cn.com.lin.entity.ContactCondition;
import cn.com.lin.entity.PageBean;

public interface IContactService {
	// 得到分页每一页的数据
	public void findPageDate(PageBean<Contact> pb);

	// 添加联系人
	public void addContact(Contact contact, String uid);

	// Id查找联系人
	public Contact findContactById(int id);

	// 修改联系人
	public void modifyContact(Contact contact, int id);

	// 修改联系人
	public void deleteContact(int id);

	// 根据指定条件查询联系人
	public void serchByCondition(ContactCondition condition, PageBean<Contact> pb);
}
