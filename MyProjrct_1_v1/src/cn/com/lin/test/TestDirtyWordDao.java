package cn.com.lin.test;

import java.util.List;

import org.junit.Test;

import cn.com.lin.dao.IDirtyWordDao;
import cn.com.lin.dao.impl.DirtyWordDaoImpl;

public class TestDirtyWordDao {
	IDirtyWordDao dirtyDao = new DirtyWordDaoImpl();
	
	@Test
	public void testGetDirtyWord() {
		List<String> dirtyWord = dirtyDao.getDirtyWord();
		System.out.println(dirtyWord);
	}
}
