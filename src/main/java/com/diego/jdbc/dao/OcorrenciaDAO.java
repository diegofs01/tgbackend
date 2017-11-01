package com.diego.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.diego.jdbc.ConnectionFactory;
import com.diego.model.Ocorrencia;

public class OcorrenciaDAO {
	private Connection connection;
	
	public OcorrenciaDAO() throws SQLException {
		this.connection = ConnectionFactory.getConexao();
	}
	
	public void adicionarOcorrencia(Ocorrencia o) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO ocorrencia (placaVeiculo, data, hora, descricao) VALUES (?, ?, ?, ?)");
			
			statement.setString(1, o.getPlacaVeiculo());
			statement.setDate(2, o.getData());
			statement.setTime(3, o.getHora());
			statement.setString(4, o.getDescricao());
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public List<Ocorrencia> listarOcorrencias() throws SQLException {
		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		Ocorrencia o;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM ocorrencia");
			
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				o = new Ocorrencia();
				
				o.setPlacaVeiculo(rs.getString("placaVeiculo"));
				o.setData(rs.getDate("data"));
				o.setHora(rs.getTime("hora"));
				o.setDescricao(rs.getString("descricao"));
				
				ocorrencias.add(o);
			}
			
			rs.close();
			
			statement.close();
			
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return ocorrencias;
	}
	
	public Ocorrencia buscarOcorrencia(String placa, Date data, Time hora) throws SQLException {
		Ocorrencia o = new Ocorrencia();
		
		try { 
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM ocorrencia WHERE placaVeiculo = ? AND data = ? AND hora = ?");
			
			statement.setString(1, placa);
			statement.setDate(2, data);
			statement.setTime(3, hora);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				o.setPlacaVeiculo(rs.getString("placaVeiculo"));
				o.setData(rs.getDate("data"));
				o.setHora(rs.getTime("hora"));
				o.setDescricao(rs.getString("descricao"));
			}
			
			rs.close();
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return o;
	}
	
	public void excluirOcorrencia(String placa, Date data, Time hora) throws SQLException {
		try  {
			PreparedStatement statement = this.connection.prepareStatement("DELETE FROM ocorrencia WHERE placaVeiculo = ? AND data = ? AND hora = ?");
			
			statement.setString(1, placa);
			statement.setDate(2, data);
			statement.setTime(3, hora);
			
			statement.execute();
			
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void alterarOcorrencia(String placa, Ocorrencia o) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("UPDATE ocorrencia SET descricao = ? WHERE placaVeiculo = ? AND data = ? AND hora = ?");
			
			statement.setString(1, o.getDescricao());
			statement.setString(2, placa);
			statement.setDate(3, o.getData());
			statement.setTime(4, o.getHora());
			
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}

}
