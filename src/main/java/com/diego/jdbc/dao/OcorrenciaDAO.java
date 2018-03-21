package com.diego.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diego.jdbc.ConnectionFactory;
import com.diego.model.Ocorrencia;

public class OcorrenciaDAO {
	private Connection connection;
	private TipoOcorrenciaDAO tipoOcorrenciaDAO = new TipoOcorrenciaDAO();
	
	public OcorrenciaDAO() throws SQLException {
		this.connection = ConnectionFactory.getConexao();
	}
	
	public void adicionarOcorrencia(Ocorrencia o) throws SQLException {
		try {
			
			if(verificarVeiculo(o.getPlacaVeiculo()) == 1) {
				o.setVeiculoCadastrado(true);
			} else {
				o.setVeiculoCadastrado(false);
			}
			
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO ocorrencia (placaVeiculo, data, hora, descricao, tipoOcorrencia, veiculoCadastrado) VALUES (?, ?, ?, ?, ?, ?)");
			
			statement.setString(1, o.getPlacaVeiculo());
			statement.setDate(2, o.getData());
			statement.setTime(3, o.getHora());
			statement.setString(4, o.getDescricao());
			statement.setInt(5, o.getTipoOcorrencia().getId());
			statement.setBoolean(6, o.isVeiculoCadastrado());
			
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
				
				o.setNumero(rs.getInt("numero"));
				o.setPlacaVeiculo(rs.getString("placaVeiculo"));
				o.setData(rs.getDate("data"));
				o.setHora(rs.getTime("hora"));
				o.setDescricao(rs.getString("descricao"));
				o.setTipoOcorrencia(tipoOcorrenciaDAO.buscarTipoOcorrencia(rs.getInt("tipoOcorrencia")));
				o.setVeiculoCadastrado(rs.getBoolean("veiculoCadastrado"));
				
				ocorrencias.add(o);
			}
			
			rs.close();
			
			statement.close();
			
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return ocorrencias;
	}
	
	public List<Ocorrencia> listarOcorrenciasByPlaca(String placa) throws SQLException {
		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		Ocorrencia o;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM ocorrencia WHERE placaVeiculo = ?");
			
			statement.setString(1, placa);

			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				o = new Ocorrencia();
				
				o.setNumero(rs.getInt("numero"));
				o.setPlacaVeiculo(rs.getString("placaVeiculo"));
				o.setData(rs.getDate("data"));
				o.setHora(rs.getTime("hora"));
				o.setDescricao(rs.getString("descricao"));
				o.setTipoOcorrencia(tipoOcorrenciaDAO.buscarTipoOcorrencia(rs.getInt("tipoOcorrencia")));
				o.setVeiculoCadastrado(rs.getBoolean("veiculoCadastrado"));
				
				ocorrencias.add(o);
			}
			
			rs.close();
			
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return ocorrencias;
	}

	public Ocorrencia buscarOcorrencia(int numero) throws SQLException {
		Ocorrencia o = new Ocorrencia();
		
		try { 
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM ocorrencia WHERE numero = ?");
			
			statement.setInt(1, numero);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				o.setNumero(rs.getInt("numero"));
				o.setPlacaVeiculo(rs.getString("placaVeiculo"));
				o.setData(rs.getDate("data"));
				o.setHora(rs.getTime("hora"));
				o.setDescricao(rs.getString("descricao"));
				o.setTipoOcorrencia(tipoOcorrenciaDAO.buscarTipoOcorrencia(rs.getInt("tipoOcorrencia")));
				o.setVeiculoCadastrado(rs.getBoolean("veiculoCadastrado"));
			}
			
			rs.close();
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return o;
	}
	
	public void excluirOcorrencia(int numero) throws SQLException {
		try  {
			PreparedStatement statement = this.connection.prepareStatement("DELETE FROM ocorrencia WHERE numero = ?");
			
			statement.setInt(1, numero);
			
			statement.execute();
			
			statement.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void alterarOcorrencia(int numero, Ocorrencia o) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("UPDATE ocorrencia SET descricao = ?, tipoOcorrencia = ? WHERE numero = ?");
			
			statement.setString(1, o.getDescricao());
			statement.setInt(2, o.getTipoOcorrencia().getId());
			statement.setInt(3, numero);
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public int verificarVeiculo(String placa) throws SQLException {
		int resultado = 0;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("SELECT count(1) FROM veiculo WHERE placa = ?");
			
			stmt.setString(1, placa);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				resultado = rs.getInt("count");
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return resultado;
	}

}
