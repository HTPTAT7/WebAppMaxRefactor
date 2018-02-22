package by.http.password.controller.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.http.password.controller.action.BaseAction;
import static by.http.password.controller.util.ControllerConstantPool.*;

public class DeafaultActionImpl implements BaseAction {

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		return PAGE_INDEX;
	}

}
