package by.http.password.controller.action.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.password.bean.Book;
import by.http.password.controller.action.BaseAction;
import by.http.password.dao.impl.BookDaoMySqlImpl;

public class PreparingBookUpdateImpl implements BaseAction {

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl();
		List<Book> books = bookDao.readAll();
		int idBook = Integer.parseInt(request.getParameter("book_id"));
		List<Integer> years = new ArrayList();
		for(int i = 1890; i <= 2018; i++) {
			years.add(i);
		}
		request.setAttribute("updateYear", years);
		request.setAttribute("updateBook", books);
		request.setAttribute("idBook", idBook);
		String page = "updateAdmin.jsp";
		return page;
	}

}
