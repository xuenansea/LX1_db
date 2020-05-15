package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DAO_comment {
	private static BasicDataSource ds;
	static {
		
		try {
			Properties prop=new Properties();
			/*
			 * [����].class.getClassLoader():��ü���DBUtil�����������ClassLoader����
			 * .getResourceAsStream()����������ṩ�ķ�������������·��ȥ���������ļ���.properties��
			 * Ȼ�󷵻�InputStream
			 */
			prop.load(DAO_comment.class.getClassLoader().getResourceAsStream("config.properties"));
			String driverClass=prop.getProperty("driverclass");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			int maxActive=Integer.parseInt(prop.getProperty("maxactive"));
			int maxWait=Integer.parseInt(prop.getProperty("maxwait"));
			
			ds=new BasicDataSource();
			ds.setDriverClassName(driverClass);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMaxActive(maxActive);
			ds.setMaxWait(maxWait);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void closeConnection(Connection conn){
		try{
			if(conn!=null){
				conn.setAutoCommit(true);
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
