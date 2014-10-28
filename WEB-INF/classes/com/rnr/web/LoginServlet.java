package com.rnr.web;

import com.rnr.model.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author dmlaomao
 *
 *LoginServlet inherits all the features of a servlet by extending HttpServlet.
 *By default the doPost method will be called by the webContainer.
 *If valid credentials are given the user is redirected to success.jsp page.
 *If invalid credentials are entered then the login.jsp page is displayed back to the user.  
 */
public class LoginServlet extends HttpServlet{

	
	/**
	 * The request comes to this method when the login button is clicked
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");

                HttpSession session=request.getSession();
                if(!session.isNew()){
                    response.sendRedirect("success.jsp");
                }	
               
	        else{try {
			//get the user entered input values from the "HttpServletRequest" object, i.e request 
			String userNameStr =  request.getParameter("usernameTB");
			String passwordStr =  request.getParameter("passwordTB");
			
                        Log loglog=new Log();			
			
                        if(loglog.isValidPassword(userNameStr,passwordStr)){
                                session.setAttribute("user",userNameStr);
				response.sendRedirect("success.jsp");
			}else{
				request.setAttribute("errMsg", "invalid login, check your username&password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}catch(Exception e){
			request.setAttribute("errMsg", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		 }
                }
	}
}
