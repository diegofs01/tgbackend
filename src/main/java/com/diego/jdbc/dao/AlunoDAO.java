package com.diego.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diego.jdbc.ConnectionFactory;
import com.diego.model.Aluno;

public class AlunoDAO {
	private Connection connection;
	
	public AlunoDAO() throws SQLException {
		this.connection = ConnectionFactory.getConexao(); 
	}
	
	public void adicionarAluno(Aluno aluno) throws SQLException {
		try  {
			PreparedStatement statement = this.connection.prepareStatement("INSERT INTO aluno (ra, nome, cpf, rg, endereco, numero, complemento, bairro, cidade, estado, cep, numeroTelefone, numeroCelular, email, idCurso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			statement.setString(1, aluno.getRa());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getCpf());
			statement.setString(4, aluno.getRg());
			statement.setString(5, aluno.getEndereco());
			statement.setInt(6, aluno.getNumero());
			statement.setString(7, aluno.getComplemento());
			statement.setString(8, aluno.getBairro());
			statement.setString(9, aluno.getCidade());
			statement.setString(10, aluno.getEstado());
			statement.setString(11, aluno.getCep());
			statement.setString(12, aluno.getNumeroTelefone());
			statement.setString(13, aluno.getNumeroCelular());
			statement.setString(14, aluno.getEmail());
			statement.setInt(15, aluno.getIdCurso());
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public List<Aluno> listarAlunos() throws SQLException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno aluno;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM aluno");
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				aluno = new Aluno();
				
				aluno.setRa(rs.getString("ra"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setRg(rs.getString("rg"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setNumero(rs.getInt("numero"));
				aluno.setComplemento(rs.getString("complemento"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setEstado(rs.getString("estado"));
				aluno.setCep(rs.getString("cep"));
				aluno.setNumeroTelefone(rs.getString("numeroTelefone"));
				aluno.setNumeroCelular(rs.getString("numeroCelular"));
				aluno.setEmail(rs.getString("email"));
				aluno.setIdCurso(rs.getInt("idCurso"));
				
				alunos.add(aluno);
			}
			
			rs.close();
			
			statement.close();
			
			
		} catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return alunos;
	}
	
	public Aluno buscarAluno(String ra) throws SQLException {
		Aluno aluno = new Aluno();;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM aluno WHERE ra = ?");
			
			statement.setString(1, ra);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				
				aluno.setRa(rs.getString("ra"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setRg(rs.getString("rg"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setNumero(rs.getInt("numero"));
				aluno.setComplemento(rs.getString("complemento"));
				aluno.setBairro(rs.getString("bairro"));
				aluno.setCidade(rs.getString("cidade"));
				aluno.setEstado(rs.getString("estado"));
				aluno.setCep(rs.getString("cep"));
				aluno.setNumeroTelefone(rs.getString("numeroTelefone"));
				aluno.setNumeroCelular(rs.getString("numeroCelular"));
				aluno.setEmail(rs.getString("email"));
				aluno.setIdCurso(rs.getInt("idCurso"));
			}
			
			rs.close();
			
			statement.close();
			
			
			
		}  catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		
		return aluno;
	}
	
	public void excluirAluno(String ra) throws SQLException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("DELETE FROM aluno WHERE ra = ?");
			
			statement.setString(1, ra);
			
			statement.execute();
			
			statement.close();
			
			
		}  catch(SQLException ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void alterarAluno(String ra, Aluno aluno) throws SQLException {
		try  {
			PreparedStatement statement = this.connection.prepareStatement("UPDATE aluno SET nome = ?, cpf = ?, rg = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, numeroTelefone = ?, numeroCelular = ?, email = ?, idCurso = ? WHERE ra = ?");
			
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getCpf());
			statement.setString(3, aluno.getRg());
			statement.setString(4, aluno.getEndereco());
			statement.setInt(5, aluno.getNumero());
			statement.setString(6, aluno.getComplemento());
			statement.setString(7, aluno.getBairro());
			statement.setString(8, aluno.getCidade());
			statement.setString(9, aluno.getEstado());
			statement.setString(10, aluno.getCep());
			statement.setString(11, aluno.getNumeroTelefone());
			statement.setString(12, aluno.getNumeroCelular());
			statement.setString(13, aluno.getEmail());
			statement.setInt(14, aluno.getIdCurso());
			statement.setString(15, ra);
			
			statement.execute();
			
			statement.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}
	}

}
