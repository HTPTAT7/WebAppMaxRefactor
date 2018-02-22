package by.http.password.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface BaseAction {
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	String chooseAction(HttpServletRequest request) throws SQLException;

}
