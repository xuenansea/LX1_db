package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import JDBC.DAO;
import JDBC.DAO_1;
import JDBC.DAO_comment;

public class Test_JDBC {
		Connection conn=null;

	@Test
	public void test1(){
		try {
			conn=DAO_1.getCinnectin();
			System.out.println(conn);
			System.out.println("连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		DAO_1.close(conn);
	}
	@Test
	public void test2(){
		try {
			conn=DAO_comment.getConnection();
			System.out.println(conn);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败！");
		}
		DAO_comment.closeConnection(conn);
	}
	@Test
	public void test3() {
		try {
			conn=DAO.getConnection();
			System.out.println(conn);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败！");
		}
		DAO.closeConnection(conn);
	}

	
}
