package com.diego.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.jdbc.dao.AlunoDAO;
import com.diego.model.Aluno;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class AlunoController {

	public AlunoDAO alunoDAO;
	
	public AlunoController() throws SQLException {
		alunoDAO = new AlunoDAO();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/aluno", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listarAlunos() throws SQLException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = alunoDAO.listarAlunos();
		return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/aluno/{ra}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscarAluno(@PathVariable("ra") String ra) throws SQLException {
		Aluno aluno = new Aluno();
		aluno = alunoDAO.buscarAluno(ra);
		if(aluno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/aluno", method = RequestMethod.POST)
	public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) throws JsonParseException, JsonMappingException, IOException, SQLException {
		alunoDAO.adicionarAluno(aluno);
		return new ResponseEntity<Aluno>(aluno, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/aluno/{ra}", method = RequestMethod.PUT)
	public ResponseEntity<Aluno> alterarAluno(@PathVariable("ra") String ra, @RequestBody Aluno aluno) throws JsonParseException, JsonMappingException, IOException, SQLException {
		alunoDAO.alterarAluno(ra, aluno);
		return new ResponseEntity<Aluno>(aluno, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/aluno/{ra}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluirAluno(@PathVariable("ra") String ra) throws SQLException {
		alunoDAO.excluirAluno(ra);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
