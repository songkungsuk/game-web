package com.game.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	private final static String DRIVER_NAME = "org.mariadb.jdbc.Driver";
	private final static String URL = "jdbc:mariadb://localhost:3306/game";
	private final static String ID = "root";
	private final static String PW = "kd1824java";
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (Exception e) {

		}
	}
	
	public static Connection getCon() {
		try {
			Connection con = DriverManager.getConnection(URL, ID, PW);
			return con;
		} catch (Exception e) {

		}
		return null;
	}
	
//	public static void main(String[] args) {
//		System.out.println(DBcon.getCon());
//	}
}
