package com.h2soft.persistence;



import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;



import lombok.extern.log4j.Log4j;

@Log4j
public class OracleJDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
			log.info(con);
			
		} catch (SQLException e) {
			fail(e.getMessage());			
		}
	}
}
