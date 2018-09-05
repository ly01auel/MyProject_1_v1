package cn.com.lin.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.com.lin.dao.IContactDao;
import cn.com.lin.entity.Contact;
import cn.com.lin.entity.ContactCondition;
import cn.com.lin.entity.PageBean;
import cn.com.lin.util.JDBCUtils_v2;

public class ContactDaoImpl implements IContactDao {
	private QueryRunner qr = JDBCUtils_v2.getQueryRunner();

	@Override
	public void findPageDate(PageBean<Contact> pb) {
		String uid = pb.getUser().getId();
		int from = (pb.getCurrentPage() - 1) * pb.getPageCount();
		int limit = pb.getPageCount();
		String sql = "select * from t_contact where con_uid = ? limit ?,?";
		try {
			List<Contact> resList = qr.query(sql, new BeanListHandler<Contact>(Contact.class), uid, from, limit);
			pb.setDataList(resList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		getDateCount(pb);
		pb.setTotlePage();
	}

	@Override
	public void getDateCount(PageBean<Contact> pb) {
		String sql = "select count(*) from t_contact where con_uid = ?";
		try {
			String con_uid = pb.getUser().getId();
			// 查询返回记录数（long型）
			Long l = qr.query(sql, new ScalarHandler<>(), con_uid);
			int count = l.intValue();
			pb.setTotleCount(count);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addContact(Contact contact, String uid) {
		String sql = "insert into t_contact(con_name,con_sex,con_age,con_tel,con_qq,con_email,con_uid) values (?,?,?,?,?,?,?);";
		String sql2 = "select @@IDENTITY";
		// 定义自增长主键
		BigInteger key = null;

		Object[] params = new Object[] { contact.getCon_name(), contact.getCon_sex(), contact.getCon_age(),
				contact.getCon_tel(), contact.getCon_qq(), contact.getCon_email(), uid };

		try {
			qr.update(sql, params);
			key = qr.query(sql2, new ScalarHandler<BigInteger>());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return key.intValue();
	}

	@Override
	public Contact findContactById(int id) {
		Contact contact = null;
		String sql = "select * from t_contact where con_id=?";
		try {
			contact = qr.query(sql, new BeanHandler<Contact>(Contact.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return contact;
	}

	@Override
	public void modifyContact(Contact contact, int id) {
		String sql = "update t_contact set con_name=?,con_sex=?,con_age=?,con_tel=?,con_qq=?,con_email=? where con_id=?;";
		// 参数
		Object[] params = new Object[] { contact.getCon_name(), contact.getCon_sex(), contact.getCon_age(),
				contact.getCon_tel(), contact.getCon_qq(), contact.getCon_email(), id };

		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteContact(int id) {
		String sql = "delete from t_contact where con_id = ?;";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void serchByCondition(ContactCondition condition, PageBean<Contact> pb) {
		StringBuffer sqlbuf = new StringBuffer("select * from t_contact where ");
		// 如果condition不为空
		if (condition != null) {
			Map<String, String> conditions = condition.getConditionMap();
			if (conditions.size() != 0) {
				Iterator<Entry<String, String>> iterator = conditions.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, String> entry = iterator.next();
					String key = entry.getKey();
					String value = entry.getValue();
					sqlbuf.append(key + "='" + value + "' and ");
				}
			}
		}

		String uid = pb.getUser().getId();
		int from = (pb.getCurrentPage() - 1) * pb.getPageCount();
		int limit = pb.getPageCount();
		sqlbuf.append("con_uid = ? limit ?,?");
		try {
			List<Contact> resList = qr.query(sqlbuf.toString(), new BeanListHandler<Contact>(Contact.class), uid, from,
					limit);
			pb.setDataList(resList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String sql2 = sqlbuf.substring(0, sqlbuf.length() - 10).replace("*", "count(*)");
		try {
			String con_uid = pb.getUser().getId();
			// 查询返回记录数（long型）
			Long l = qr.query(sql2, new ScalarHandler<>(), con_uid);
			int count = l.intValue();
			pb.setTotleCount(count);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		pb.setTotlePage();
	}
}
