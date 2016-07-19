package service;

import dao.UserDao;

public class UserService {

	 public boolean loginService(String username,String password){
    	 UserDao user=new UserDao();
    	 return user.loginRequest(username, password);
     }
}
