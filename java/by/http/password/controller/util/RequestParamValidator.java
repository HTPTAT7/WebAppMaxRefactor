package by.http.password.controller.util;

import by.http.password.controller.RequestParamValidationException;

public class RequestParamValidator {
	
	private RequestParamValidator(){}
	
	
	public static void validateUserLoginPass(String login, String pass){
		if(login == null || pass == null){
			throw new RequestParamValidationException();
		}
	}

}
