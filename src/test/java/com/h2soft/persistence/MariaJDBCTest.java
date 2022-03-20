package com.h2soft.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class MariaJDBCTest {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConection() {		
		try {
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/groupware", "scott", "tiger");
			
			log.info(con);
			
		} catch (SQLException e) {
			fail(e.getMessage());			
		}
	}
	
	@Test
	public void testRealConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mariadb://52.78.27.249:3306/groupware", "scott", "tiger");
			
			log.info(con);
			
		} catch (SQLException e) {
			fail(e.getMessage());			
		}
	}
}
