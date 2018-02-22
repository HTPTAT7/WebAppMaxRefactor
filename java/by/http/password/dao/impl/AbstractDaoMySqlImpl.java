package by.http.password.dao.impl;

import by.http.password.bean.User;
import by.http.password.dao.UserDao;
import by.http.password.dao.util.WrapMySqlConnect;

abstract class AbstractDaoMySqlImpl {
	
	protected static final String SQL_USER = "user";
	protected static final String SQL_USER_ID = "id";
	protected static final String SQL_USER_PASS = "password";
	protected static final String SQL_USER_LOGIN = "login";
	protected static final String SQL_USER_ROLE = "role";

	WrapMySqlConnect wcn;

	// bad style
	{
		wcn = new WrapMySqlConnect();
	}
	
	
}
