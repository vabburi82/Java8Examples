package org.koushik.javabrains.action;

import org.apache.commons.lang3.StringUtils;
import org.koushik.javabrains.model.User;
import org.koushik.javabrains.service.LoginService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@SuppressWarnings({ "serial" })
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	private User user= new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void validate(){
		if(StringUtils.isEmpty(user.getUserId())){
			addFieldError("userId", "UserID cannot be blank");
		}
		if(StringUtils.isEmpty(user.getPassword())){
			addFieldError("password", "password cannot be blank");
		}
	}
	public String execute(){
		LoginService loginService = new LoginService();
		if (loginService.verifyLogin(user)){
			return SUCCESS;
		}
		return LOGIN;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	

}
