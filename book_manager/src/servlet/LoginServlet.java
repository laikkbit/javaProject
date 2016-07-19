package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

public class LoginServlet extends HttpServlet {


	public LoginServlet() {
		super();
	}

	public void destroy() {

		super.destroy(); 

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              String username=request.getParameter("user");
              String password=request.getParameter("passwird");
              UserService user=new UserService();
              boolean is=user.loginService(username, password);
              if(is){
            	  request.getRequestDispatcher("/html/indexRight.html");
              }
              else request.getRequestDispatcher("/html/loginWrong.html"); 
              
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}


	public void init() throws ServletException {

	}

}
