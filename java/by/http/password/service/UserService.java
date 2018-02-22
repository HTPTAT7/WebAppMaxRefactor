package by.http.password.service;

import by.http.password.bean.User;

public interface UserService {
	
	User authorizeUser(String login, String pass);

}
