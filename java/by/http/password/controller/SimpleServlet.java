package by.http.password.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.password.controller.action.BaseAction;

import static by.http.password.controller.util.ActionManager.determineAction;
import static by.http.password.controller.util.ControllerConstantPool.*;

public class SimpleServlet extends HttpServlet {

	private static final long serialVersionUID = 1701270869905837228L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

		BaseAction action = determineAction(request.getParameter(REQUEST_PARAM_COMMAND));
		String page;
		try {
			page = action.chooseAction(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
