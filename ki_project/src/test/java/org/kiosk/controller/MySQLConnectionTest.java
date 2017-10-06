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
//DB ?—°ê²°ì? ?—¬ê¸°ì„œ ?…Œ?Š¤?Š¸ ?•˜?Š” ê²ƒì´ ?•„?‹ˆ?¼ DataSourceTest.java ?—?„œ ?…Œ?Š¤?Š¸ ?•´?•¼ ?œ?‹¤. 
//root-context.xml?— ?ˆ?Š” ? •ë³´ë“¤ ì¤? url user pw ë¥? ?„¤? •?•´?•¼?•œ?‹¤.
		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {

			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
