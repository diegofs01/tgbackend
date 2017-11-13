package com.diego.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diego.jdbc.ConnectionFactory;
import com.diego.model.TipoOcorrencia;

public class TipoOcorrenciaDAO {
	private Connection connection;
	
	public TipoOcorrenciaDAO() throws SQLException {
		this.connection = ConnectionFactory.getConexao();
	}
	
	public void adiciona(TipoOcorrencia to) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO tipoOcorrencia (nome) VALUES (?)");
			
			statement.setString(1, to.getNome());
			
			statement.execute();
			
			statement.close();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	public List<TipoOcorrencia> listarTiposOcorrencias() throws SQLException {
		List<TipoOcorrencia> tiposOcorrencias = new ArrayList<TipoOcorrencia>();
		TipoOcorrencia to;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tipoOcorrencia");
			
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				to = new TipoOcorrencia();
				
				to.setId(rs.getInt("id"));
				to.setNome(rs.getString("nome"));
				
				tiposOcorrencias.add(to);
			}
			
			rs.close();
			
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return tiposOcorrencias;
	}
	
	
	public TipoOcorrencia buscarTipoOcorrencia(int id) throws SQLException {
		TipoOcorrencia to = new TipoOcorrencia();
		
		try { 
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tipoOcorrencia WHERE id = ?");
			
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				to.setId(rs.getInt("id"));
				to.setNome(rs.getString("nome"));
			}
			
			rs.close();
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return to;
	}
	
	public void excluirTipoOcorrencia(int id) throws SQLException {
		try  {
			PreparedStatement statement = this.connection.prepareStatement("DELETE FROM tipoOcorrencia WHERE id = ?");
			
			statement.setInt(1, id);
			
			statement.execute();
			
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void alterarTipoOcorrencia(int id, TipoOcorrencia to) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("UPDATE tipoOcorrencia SET nome = ? WHERE id = ?");
			
			statement.setString(1, to.getNome());
			statement.setInt(2, id);
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
}
