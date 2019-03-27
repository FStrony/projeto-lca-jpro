package com.jpro.lca.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

public static Connection getConnectionOracle() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "OPS$RM68461", "041194");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
}
