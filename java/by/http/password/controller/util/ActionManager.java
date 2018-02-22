package by.http.password.controller.util;

import by.http.password.controller.action.BaseAction;

import by.http.password.controller.action.impl.CheckLoginImpl;
import by.http.password.controller.action.impl.CreateBookImpl;
import by.http.password.controller.action.impl.DeafaultActionImpl;
import by.http.password.controller.action.impl.DeleteBookImpl;
import by.http.password.controller.action.impl.LookLibraryImlp;
import by.http.password.controller.action.impl.PreparingBookCreateImpl;
import by.http.password.controller.action.impl.PreparingBookUpdateImpl;
import by.http.password.controller.action.impl.RegistrationImpl;
import by.http.password.controller.action.impl.UpdateBookImpl;

import static by.http.password.controller.util.ControllerConstantPool.*;

public class ActionManager {
	
	private ActionManager(){}
	
	public static BaseAction determineAction(String action) {
		BaseAction act = null;
		
		switch (action){
			case REQUEST_PARAM_LOGIN_COMMAND:
				act = new CheckLoginImpl();
				break;
			case REQUEST_PARAM_BOOK_LIST:
				act = new LookLibraryImlp();
				break;
			case REQUEST_PARAM_DELETE_BOOK:
				act = new DeleteBookImpl();
				break;
			case REQUEST_PARAM_UPDATE_BOOK:
				act = new PreparingBookUpdateImpl();
				break;
			case REQUEST_PARAM_CREATE_BOOK:
				act = new PreparingBookCreateImpl();
				break;
			case REQUEST_PARAM_CREATE_BOOK_SECOND:
				act = new CreateBookImpl();
				break;
			case REQUEST_PARAM_UPDATE_BOOK_SECOND:
				act = new UpdateBookImpl();
				break;
			case REQUEST_PARAM_REGISTER_COMMAND:
				act = new RegistrationImpl();
				break;
			default:
				act = new DeafaultActionImpl();
		}
		return act;
	}
}
