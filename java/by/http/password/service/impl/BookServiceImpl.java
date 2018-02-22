package by.http.password.service.impl;

import java.util.List;

import by.http.password.bean.Book;
import by.http.password.dao.BookDao;
import by.http.password.dao.impl.BookDaoMySqlImpl;
import by.http.password.service.BookService;

public class BookServiceImpl implements BookService {
	
	//TODO Factory
	private BookDao bookDao = new BookDaoMySqlImpl();

	@Override
	public List<Book> getBookCatalog() {
		return bookDao.readAll();
	}

}
