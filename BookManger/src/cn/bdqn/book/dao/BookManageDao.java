package cn.bdqn.book.dao;

import java.util.List;

import cn.bdqn.book.entity.BookManage;

public interface BookManageDao
{
   List<BookManage> getAllManagers();
   boolean addBookManage(BookManage book);
   boolean deleteBookManage(int id);
}
