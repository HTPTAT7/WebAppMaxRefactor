package by.http.password.controller.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.password.bean.Book;
import by.http.password.bean.User;
import by.http.password.controller.action.BaseAction;
import by.http.password.dao.impl.BookDaoMySqlImpl;
import by.http.password.dao.impl.UserDaoMySqlImpl;
import by.http.password.service.BookService;
import by.http.password.service.UserService;
import by.http.password.service.impl.BookServiceImpl;
import by.http.password.service.impl.UserServiceImpl;

import static by.http.password.controller.util.RequestParamValidator.*;
import static by.http.password.controller.util.ControllerConstantPool.*;

public class CheckLoginImpl implements BaseAction {

	// TODO change to FactoryPattern
	private UserService userService = new UserServiceImpl();
	private BookService bookService = new BookServiceImpl();

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {

		String login = request.getParameter("login");
		String pass = request.getParameter("password");

		validateUserLoginPass(login, pass);

		User user = userService.authorizeUser(login, pass);
		if (user != null) {
			if (user.getRole().equals("admin")) {
				List<Book> books = bookService.getBookCatalog();
				request.setAttribute(REQUEST_PARAM_BOOK_LIST, books);
				return PAGE_ADMIN_MAIN;
			} else if (user.getRole().equals("user")) {
				return PAGE_USER_MAIN;
			}
		} else {
			return PAGE_ERROR;
		}

		return PAGE_INDEX;
	}

}
