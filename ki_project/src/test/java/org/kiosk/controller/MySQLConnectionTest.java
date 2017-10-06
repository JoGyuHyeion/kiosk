package org.kiosk.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/kipro?useSSL=false";
	private static final String USER = "kipro";
	private static final String PW = "ki12345!";

	@Test
	public void testConnection() throws Exception {
//DB ?��결�? ?��기서 ?��?��?�� ?��?�� 것이 ?��?��?�� DataSourceTest.java ?��?�� ?��?��?�� ?��?�� ?��?��. 
//root-context.xml?�� ?��?�� ?��보들 �? url user pw �? ?��?��?��?��?��?��.
		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {

			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
