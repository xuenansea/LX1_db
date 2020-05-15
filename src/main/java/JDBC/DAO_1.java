package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DAO_1 {
	private static String driverclass;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			driverclass=prop.getProperty("driverclass");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			System.out.println("初始化数据库连接。。。");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCinnectin() throws Exception{
		try{
			Class.forName(driverclass);
			Connection conn=DriverManager.getConnection(url,username,password);
			return conn;
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}














