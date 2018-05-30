package cn.bdqn.book.biz.impl;

import java.util.List;

import cn.bdqn.book.biz.BookManageBiz;
import cn.bdqn.book.dao.BookManageDao;
import cn.bdqn.book.dao.impl.BookManageDaoImpl;
import cn.bdqn.book.entity.BookManage;

public class BookManageBizImpl implements BookManageBiz {

	// ����Dao����
	BookManageDao daoImpl=new BookManageDaoImpl();
	
	/**
	 * ��ѯ
	 */
	public List<BookManage> getAllManagers() {	
		return daoImpl.getAllManagers();
	}

	/**
	 * ���
	 */
	public boolean addBookManage(BookManage book) {
		return daoImpl.addBookManage(book);
	}

	/**
	 * ɾ��
	 */
	public boolean deleteBookManage(int id) {	
		return daoImpl.deleteBookManage(id);
	}
}
