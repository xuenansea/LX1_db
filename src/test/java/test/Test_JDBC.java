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
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		DAO_1.close(conn);
	}
	@Test
	public void test2(){
		try {
			conn=DAO_comment.getConnection();
			System.out.println(conn);
			System.out.println("���ӳɹ���");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ�ܣ�");
		}
		DAO_comment.closeConnection(conn);
	}
	@Test
	public void test3() {
		try {
			conn=DAO.getConnection();
			System.out.println(conn);
			System.out.println("���ӳɹ���");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ�ܣ�");
		}
		DAO.closeConnection(conn);
	}

	
}
