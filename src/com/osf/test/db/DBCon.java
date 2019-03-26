package com.osf.test.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.osf.test.io.ReadFile;

public class DBCon {

	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final String DRIVER;
	public static final String CLIENT_ID;
	public static final String CLIENT_SECRET;
	public static final String METHOD;
	public static final String NAVER_URL;
	
	static {
		InputStream is = ReadFile.class.getResourceAsStream("/com/osf/test/config/db.properties");
		
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		URL=prop.getProperty("url");
		USER=prop.getProperty("user");
		PASSWORD=prop.getProperty("password");
		DRIVER=prop.getProperty("classname");
		CLIENT_ID=prop.getProperty("clientId");
		CLIENT_SECRET=prop.getProperty("clientSecret");
		NAVER_URL=prop.getProperty("naverUrl");
		METHOD=prop.getProperty("method");
		
	}
	
	private static Connection con = null;
	
	private static boolean open() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static Connection getCon() {
		if(con==null) {
			if(open()) {
				System.out.println("getCon Complete");
			}
		}
		return con;
	}
	
	public static void close() {
		if(con!=null) {
			try {
				if(!con.isClosed()) {
					System.out.println("close Complete");
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
	}
	
	public static void main(String[] args) {
		System.out.println(URL);
		System.out.println(USER);
		System.out.println(PASSWORD);
		System.out.println(DRIVER);
		getCon();
		close();
	}
	
}
