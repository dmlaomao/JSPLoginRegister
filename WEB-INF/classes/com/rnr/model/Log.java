package com.rnr.model;

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

public class Log{
        private Connection conn;
	private String driver;
	private String url;
	private String userName;
	private String password;
	private	PreparedStatement stmt;

        public Log(){
		ResourceBundle labels = ResourceBundle.getBundle("dbParameters");
		driver = labels.getString("DB_DRIVER");
		url = labels.getString("DB_URL");
		userName = labels.getString("DB_USER");
		password = labels.getString("DB_PASSWORD");
        }
	public String getUserPassword(String username) {
                String passwordFromDB = null;
		
		try {
			conn = getDBConnection(); //get the data base connection object
			String sql = "SELECT USER_PASSWORD FROM userinfo where USER_NAME=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				passwordFromDB = res.getString("USER_PASSWORD");
			}
                        res.close();
			conn.close(); //close the database connection
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passwordFromDB;
	}

	public void writeUserinfo(String username,String password) {
		try {
			conn = getDBConnection(); //get the data base connection object
			String sql = "INSERT INTO userinfo(USER_NAME,USER_PASSWORD) VALUES(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.executeUpdate();
			conn.close(); //close the database connection
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isValidPassword(String UserName, String Password) {	
		String pwdFromDB = getUserPassword(UserName);
		if (null != pwdFromDB) {
			if (pwdFromDB.equals(Password)) {
				return true;
			}
		}
		return false;
	}
        
        public boolean isValidName(String UserName) {
		try{
                    conn=getDBConnection();
               	    String sql = "SELECT USER_NAME FROM userinfo";
		    stmt = conn.prepareStatement(sql);
		    ResultSet res = stmt.executeQuery();
		    while (res.next()) {
			    if(UserName.equals(res.getString("USER_NAME")))
                                   return false;
		    }
                    res.close();
         	    conn.close(); //close the database connection
		    return true;
                } catch (Exception e) {
			e.printStackTrace();
                }
                return false;
	}

	public Connection getDBConnection() throws SQLException {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			//give back the database connection object to the caller
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
                return null;
	}
}
