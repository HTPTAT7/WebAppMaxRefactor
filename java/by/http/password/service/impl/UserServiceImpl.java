package by.http.password.service.impl;

import by.http.password.bean.User;
import by.http.password.dao.UserDao;
import by.http.password.dao.impl.UserDaoMySqlImpl;
import by.http.password.service.UserService;

public class UserServiceImpl implements UserService {

	// TODO Factory
	private UserDao userDao = new UserDaoMySqlImpl();

	@Override
	public User authorizeUser(String login, String pass) {

		Integer intPass = Integer.parseInt(pass);
		User user = new User(login, intPass);

		return userDao.readUser(user);
	}

}
