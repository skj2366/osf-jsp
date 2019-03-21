package com.osf.test.io;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class ReadFile {

	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final String DRIVER;
	static {
		InputStream is = ReadFile.class.getResourceAsStream("/com/osf/test/config/db.properties");
		//  src가 자바의 절대경로의 시작
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		URL = prop.getProperty("url");
		USER = prop.getProperty("user");
		PASSWORD = prop.getProperty("password");
		DRIVER = prop.getProperty("classname");

	}// static 영역이라서 final도 초기화가 된다!
	private static Connection con = null;

	public static void main(String[] args) {
		System.out.println(URL);
		System.out.println(USER);
		System.out.println(PASSWORD);
		System.out.println(DRIVER);
	}
}
