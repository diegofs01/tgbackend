package com.diego.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diego.jdbc.ConnectionFactory;
import com.diego.model.Veiculo;

public class VeiculoDAO {
	private Connection connection;
	
	public VeiculoDAO() throws SQLException {
		this.connection = ConnectionFactory.getConexao();
	}
	
	public void adicionarCarro(Veiculo carro) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO veiculo (placa, marca, modelo, anoModelo, anoFabricacao, cor, paisFabricacao, raAluno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			
			statement.setString(1, carro.getPlaca());
			statement.setString(2, carro.getMarca());
			statement.setString(3, carro.getModelo());
			statement.setInt(4, carro.getAnoModelo());
			statement.setInt(5, carro.getAnoFabricacao());
			statement.setString(6, carro.getCor());
			statement.setString(7, carro.getPaisFabricacao());
			statement.setString(8, carro.getRaAluno());
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}

	public List<Veiculo> listarCarros() throws SQLException {
		List<Veiculo> carros = new ArrayList<Veiculo>();
		Veiculo car;
		try {
			
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM veiculo");
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				car = new Veiculo();
				
				car.setPlaca(rs.getString("placa"));
				car.setMarca(rs.getString("marca"));
				car.setModelo(rs.getString("modelo"));
				car.setAnoModelo(rs.getInt("anoModelo"));
				car.setAnoFabricacao(rs.getInt("anoFabricacao"));
				car.setCor(rs.getString("cor"));
				car.setPaisFabricacao(rs.getString("paisFabricacao"));
				car.setRaAluno(rs.getString("raAluno"));
				
				carros.add(car);
			}
			
			rs.close();
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return carros;
	}
	
	public Veiculo buscarCarro(String placa) throws SQLException {
		Veiculo carro = new Veiculo();
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM veiculo WHERE placa = ?");
			
			statement.setString(1, placa);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				carro.setPlaca(rs.getString("placa"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
				carro.setAnoModelo(rs.getInt("anoModelo"));
				carro.setAnoFabricacao(rs.getInt("anoFabricacao"));
				carro.setCor(rs.getString("cor"));
				carro.setPaisFabricacao(rs.getString("paisFabricacao"));
				carro.setRaAluno(rs.getString("raAluno"));
			}
			
			rs.close();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return carro;
	}
	
	public void excluirCarro(String placa) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("DELETE FROM veiculo WHERE placa = ?");
			
			statement.setString(1, placa);
			
			statement.execute();
			
			statement.close();
			
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void alterarCarro(String placa, Veiculo carro) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("UPDATE veiculo SET marca = ?, modelo = ?, anoModelo = ?, anoFabricacao = ?, cor = ?, paisFabricacao = ?, raALuno = ? WHERE placa = ?");
			
			statement.setString(1, carro.getMarca());
			statement.setString(2, carro.getModelo());
			statement.setInt(3, carro.getAnoModelo());
			statement.setInt(4, carro.getAnoFabricacao());
			statement.setString(5, carro.getCor());
			statement.setString(6, carro.getPaisFabricacao());
			statement.setString(7, carro.getRaAluno());
			statement.setString(8, placa);
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
}
