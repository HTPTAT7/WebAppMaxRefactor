package by.http.password.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.http.password.controller.action.BaseAction;
import by.http.password.dao.impl.BookDaoMySqlImpl;

public class DeleteBookImpl implements BaseAction {

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		String page = "";
		BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl();
		bookDao.delete(Integer.parseInt(request.getParameter("book_id")));
		page = "updateAdmin.jsp";
		return page;
	}
}
