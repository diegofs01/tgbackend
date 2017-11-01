package com.diego.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/tgdb","postgres","postgres");
		} catch (ClassNotFoundException ex) {
			throw new SQLException(ex.getMessage());
		}
	}
}
