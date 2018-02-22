package by.http.password.controller.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.password.bean.Book;
import by.http.password.controller.action.BaseAction;
import by.http.password.dao.impl.BookDaoMySqlImpl;

public class LookLibraryImlp implements BaseAction{

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String page = "";
		String name = request.getParameter("name");
		
		if(name.equals("Book")) {
			BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl();
			List<Book> books = bookDao.readAll();
			request.setAttribute("lookBook", books);
			page = "admin.jsp";
		} else if(name.equals("Users")) {
			page = "";
		}
		
		return page;
	}
	
	

}
