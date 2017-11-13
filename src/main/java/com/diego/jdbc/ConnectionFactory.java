package com.diego.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			/* String url = "jdbc:postgresql://ec2-50-17-235-5.compute-1.amazonaws.com:5432/d4qhqeo3pvebtc?sslmode=require";
			Properties props = new Properties();
			props.setProperty("user","zyzmyyntejwcrw");
			props.setProperty("password","2d5807c1501b2ee3d1e06ae700dc4d9f4fd6a5de55df7401e1270ad821ecb45c");
			props.setProperty("ssl","true"); */

			String url = "jdbc:postgresql://localhost:5432/tgdb";
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","postgres");

			Connection conn = DriverManager.getConnection(url, props);

			return conn;
		} catch (ClassNotFoundException ex) {
			throw new SQLException(ex.getMessage());
		}
	}
}
