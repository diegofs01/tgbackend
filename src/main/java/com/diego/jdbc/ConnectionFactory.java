package com.diego.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://ec2-50-17-235-5.compute-1.amazonaws.com:5432/d4qhqeo3pvebtc","zyzmyyntejwcrw","2d5807c1501b2ee3d1e06ae700dc4d9f4fd6a5de55df7401e1270ad821ecb45c");
		} catch (ClassNotFoundException ex) {
			throw new SQLException(ex.getMessage());
		}
	}
}
