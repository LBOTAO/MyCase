package cn.bdqn.book.biz;

import java.util.List;

import cn.bdqn.book.entity.BookManage;

public interface BookManageBiz {
	  // ��ѯ
	  List<BookManage> getAllManagers();
	  // ���
	  boolean addBookManage(BookManage book);
	  // ɾ��
	  boolean deleteBookManage(int id);
}