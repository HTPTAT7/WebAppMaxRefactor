package by.http.password.controller.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.password.bean.User;
import by.http.password.controller.action.BaseAction;
import by.http.password.dao.impl.UserDaoMySqlImpl;

public class RegistrationImpl implements BaseAction {

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		UserDaoMySqlImpl userDao = new UserDaoMySqlImpl();
		String page = "";
		
		User regUser = new User();
		regUser.setLogin(request.getParameter("login"));
		System.out.println(request.getParameter("login"));
		regUser.setPass(Integer.parseInt(request.getParameter("password")));
		System.out.println(Integer.parseInt(request.getParameter("password")));
		
		List<User> users = userDao.readAll();
		
		for(User user: users) {
			if(user.getLogin().equals(regUser.getLogin())==false &&
					user.getPass()!=regUser.getPass()) {
				UserDaoMySqlImpl usDao = new UserDaoMySqlImpl();
				usDao.create(regUser);
				page = "login.jsp";
			} else {
				page = "error.jsp";
			}
		}
		return page;
	}

}
