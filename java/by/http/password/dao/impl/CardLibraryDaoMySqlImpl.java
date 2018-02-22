package by.http.password.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.http.password.bean.Book;
import by.http.password.bean.CardLibrary;
import by.http.password.bean.Employee;
import by.http.password.dao.CardLibraryDao;

public class CardLibraryDaoMySqlImpl /*extends AbstractDaoMySqlImpl implements CardLibraryDao */{

/*
	@Override
	public List<CardLibrary> getVisitorReadingMoreThan1Book() {
		String sql = "SELECT e.Name, COUNT(eb.Id_Book) AS countBook from Employee AS e "
				   + "inner join Employee_Book AS eb on e.ID = eb.Id_Employee group by eb.Id_Employee having count(eb.Id_Book) > 1";
		List<CardLibrary> cards = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				CardLibrary card = new CardLibrary();
				Employee employee = new Employee();
				employee.setName(resultSet.getString("e.Name"));
				card.setVisitor(employee);
				card.setCountBook(resultSet.getInt("countBook"));
				cards.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cards;
	}

	@Override
	public List<CardLibrary> getVisitorReading2orLessBooks() {
		String sql = "SELECT e.Name, e.Date_of_Birth AS BirthdayDate, COUNT(eb.Id_Book) AS countBook from Employee AS e "
				   + "inner join Employee_Book AS eb on e.ID = eb.Id_Employee "
				   + "group by eb.Id_Employee having count(eb.Id_Book) <= 2 order by BirthdayDate, countBook";
		List<CardLibrary> cards = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				CardLibrary card = new CardLibrary();
				Employee employee = new Employee();
				employee.setName(resultSet.getString("e.Name"));
				card.setVisitor(employee);
				card.setCountBook(resultSet.getInt("countBook"));
				cards.add(card);
			}
;		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return cards;
	}
	
	*/

}
