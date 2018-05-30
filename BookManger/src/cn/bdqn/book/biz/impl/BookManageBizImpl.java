package cn.bdqn.book.biz.impl;

import java.util.List;

import cn.bdqn.book.biz.BookManageBiz;
import cn.bdqn.book.dao.BookManageDao;
import cn.bdqn.book.dao.impl.BookManageDaoImpl;
import cn.bdqn.book.entity.BookManage;

public class BookManageBizImpl implements BookManageBiz {

	// 创建Dao对象
	BookManageDao daoImpl=new BookManageDaoImpl();
	
	/**
	 * 查询
	 */
	public List<BookManage> getAllManagers() {	
		return daoImpl.getAllManagers();
	}

	/**
	 * 添加
	 */
	public boolean addBookManage(BookManage book) {
		return daoImpl.addBookManage(book);
	}

	/**
	 * 删除
	 */
	public boolean deleteBookManage(int id) {	
		return daoImpl.deleteBookManage(id);
	}
}
