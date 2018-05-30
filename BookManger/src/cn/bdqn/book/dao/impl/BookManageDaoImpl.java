package cn.bdqn.book.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.book.dao.BookManageDao;
import cn.bdqn.book.entity.BookManage;

public class BookManageDaoImpl extends BaseDao implements BookManageDao {

	/**
	 * ≤È—Ø
	 */
	public List<BookManage> getAllManagers() {
		String sql = "select * from BookManage";
		List<BookManage> list = new ArrayList<BookManage>();
		try {
			ResultSet resultSet = super.executeQuery(sql);
			while (resultSet.next()) {
				BookManage temp = new BookManage();
				temp.setB_Id(resultSet.getInt("b_Id"));
				temp.setB_name(resultSet.getString("b_name"));
				temp.setB_author(resultSet.getString("b_author"));
				temp.setB_time(resultSet.getDate("b_time"));
				temp.setB_type(resultSet.getString("b_type"));
				
				list.add(temp);
			}
			resultSet.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeAll();
		}
	}
	
	/**
	 * ÃÌº”
	 */
	public boolean addBookManage(BookManage book) {
		int count=0;
		String sql="insert into BookManage values(?,?,?,?,?)";
		try
		{
			Object[]sqlValues=
				{   
					book.getB_Id(),
					book.getB_name(),
					book.getB_author(),
					new Date(book.getB_time().getTime()),
					book.getB_type()};
			count=super.executeUpdate(sql, sqlValues);
		} catch (Exception e) {
			count=-1;
			//e.printStackTrace();
		}
		return count>0?true:false;
	}

	 /**
	  * …æ≥˝
	  */
	 public boolean deleteBookManage(int id) {
		int count=0;
		String sql="delete BookManage where b_Id=?";
		try
		{
			count=executeUpdate(sql,id);
		} catch (Exception e) {
			count=-1;
		}
		return count>0?true:false;
	}
}
