package mybatis.dao;

import java.util.List;

import mybatis.entity.User;

public interface UserDAO {
	public List<User>findAll();
}
