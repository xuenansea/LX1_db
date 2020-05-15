package objectAboutStyle;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

public class PasswordAbout {

	public static void main(String[] args) {  
		//��ȡ ͨ��Ψһʶ���� Universally Unique Identifier
		String saltStr = UUID.randomUUID().toString();
		System.out.println(saltStr);//36
		ByteSource salt = ByteSource.Util.bytes(saltStr);
		System.out.println(salt);//48
		String password="1111";
		//����
		String pwd = new SimpleHash("MD5",password,salt).toString();
		System.out.println(pwd);//32λ
		System.out.println("--------------");
//		Subject subject = SecurityUtils.getSubject();
//		System.out.println("��ʼ��֤: "+subject);
		
		UsernamePasswordToken token=
				new UsernamePasswordToken("11121",pwd);
		System.out.println(token);
		
	 
		
	}

}
