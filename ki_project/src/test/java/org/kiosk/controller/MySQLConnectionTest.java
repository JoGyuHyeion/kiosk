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
		// DB 연결은 여기서 테스트 하는 것이 아니라 DataSourceTest.java 에서 테스트 해야 된다.
		// root-context.xml에 있는 정보들 중 url user pw 를 설정해야한다.
		Class.forName(DRIVER);

		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {

			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
