package cn.bdqn.book.biz;

import java.util.List;

import cn.bdqn.book.entity.BookManage;

public interface BookManageBiz {
	  // ²éÑ¯
	  List<BookManage> getAllManagers();
	  // Ìí¼Ó
	  boolean addBookManage(BookManage book);
	  // É¾³ý
	  boolean deleteBookManage(int id);
}