package cn.bdqn.book.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookManagerSys";
	private String user = "sa";
	private String password = "zhao";

	private Connection conn = null;
	private PreparedStatement pment = null;

	public Connection getConn() {

		try {
			Class.forName(driver);

			if (conn == null || conn.isClosed()) {

				conn = DriverManager.getConnection(url, user, password);

			}
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void closeAll() {
		try {
			if (this.pment != null) {
				this.pment.close();
			}

			if (this.conn != null) {
				this.conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String sql, Object... sqlValues) {
		
		try {
			this.pment = this.getConn().prepareStatement(sql);
			setSqlValues(sqlValues);
			return this.pment.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int executeUpdate(String sql, Object... sqlValues) {
		try {
			this.pment = this.getConn().prepareStatement(sql);
			setSqlValues(sqlValues);
			return this.pment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private void setSqlValues(Object... sqlValues) throws SQLException {
		if (this.pment != null && sqlValues != null) {
			for (int i = 0; i < sqlValues.length; i++) {
				this.pment.setObject(i + 1, sqlValues[i]);
			}

		}
	}

}
