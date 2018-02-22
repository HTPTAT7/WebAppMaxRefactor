package by.http.password.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.http.password.bean.Book;
import by.http.password.controller.action.BaseAction;
import by.http.password.dao.impl.BookDaoMySqlImpl;

public class CreateBookImpl implements BaseAction {

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl();
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int publishYear = Integer.parseInt(request.getParameter("date"));
		Book book = new Book();
		book.setTitel(title);
		book.setAuthor(author);
		book.setPublishDate(publishYear);
		bookDao.create(book);
		String page = "admin.jsp";
		return page;
	}

}
