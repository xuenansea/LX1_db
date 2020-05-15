package test;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mybatis.entity.User;

public class Test_mybatis_basic {
	private SqlSession session=null;
	@Before
	public void init(){
		String config="SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//getResourceAsStream字节输入流
		SqlSessionFactory ssf=ssfb.build(Test_mybatis_basic.class.getClassLoader().getResourceAsStream(config));  
		//获得SqlSession对象
		session=ssf.openSession();
	}
	@Test 
	public void test1() {
		Connection conn=session.getConnection();
		System.out.println(conn);
		session.commit();
		session.close();
	}
	@Test
	public void test2() {
		List<User>list=session.selectList("test.findAll");
		System.out.println(list);
		session.close();
	}
	
	
}
