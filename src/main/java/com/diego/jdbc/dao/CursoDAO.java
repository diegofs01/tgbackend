package com.diego.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diego.jdbc.ConnectionFactory;
import com.diego.model.Curso;

public class CursoDAO {
private Connection connection;
	
	public CursoDAO() throws SQLException {
		this.connection = ConnectionFactory.getConexao();
	}
	
	public void adiciona(Curso c) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO curso (nome) VALUES (?)");
			
			statement.setString(1, c.getNome());
			
			statement.execute();
			
			statement.close();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	public List<Curso> listarCursos() throws SQLException {
		List<Curso> cursos = new ArrayList<Curso>();
		Curso c;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM curso");
			
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				c = new Curso();
				
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				
				cursos.add(c);
			}
			
			rs.close();
			
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return cursos;
	}
	
	
	public Curso buscarCurso(int id) throws SQLException {
		Curso c = new Curso();
		
		try { 
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM curso WHERE id = ?");
			
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
			}
			
			rs.close();
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return c;
	}
	
	public void excluirCurso(int id) throws SQLException {
		try  {
			PreparedStatement statement = this.connection.prepareStatement("DELETE FROM curso WHERE id = ?");
			
			statement.setInt(1, id);
			
			statement.execute();
			
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void alterarCurso(int id, Curso c) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("UPDATE curso SET nome = ? WHERE id = ?");
			
			statement.setString(1, c.getNome());
			statement.setInt(2, id);
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}

}
