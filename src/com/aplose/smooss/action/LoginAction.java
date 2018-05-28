package com.aplose.smooss.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action{
	
    @Override
	public boolean execute(HttpServletRequest req , HttpServletResponse rep) {
    	String email = req.getParameter("email");
        String password = req.getParameter("password");

	return email.equals("admin")&&password.equals("admin");
      //  User u = UserService.getInsance().findUser
      //  if ok : 
      //  req.getSession().setAttribute("userInfo", u.getUserInfo());
      //  return u != null;
	}

}
