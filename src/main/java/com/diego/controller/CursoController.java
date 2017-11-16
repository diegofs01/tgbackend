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

import com.diego.jdbc.dao.CursoDAO;
import com.diego.model.Curso;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class CursoController {
	
	public CursoDAO cursoDAO;
	
	public CursoController() throws SQLException {
		cursoDAO = new CursoDAO();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/curso", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listarTiposOcorrecias() throws SQLException {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos = cursoDAO.listarCursos();
		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/curso/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> buscarCurso(@PathVariable("id") int id) throws SQLException {
		Curso curso = new Curso();
		curso = cursoDAO.buscarCurso(id);
		if(curso == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/curso", method = RequestMethod.POST)
	public ResponseEntity<Curso> adicionarCurso(@RequestBody Curso curso) throws JsonParseException, JsonMappingException, IOException, SQLException {
		cursoDAO.adiciona(curso);
		return new ResponseEntity<Curso>(curso, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/curso/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Curso> alterarCurso(@PathVariable("id") int id, @RequestBody Curso curso) throws JsonParseException, JsonMappingException, IOException, SQLException {
		cursoDAO.alterarCurso(id, curso);
		return new ResponseEntity<Curso>(curso, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/curso/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluirCurso(@PathVariable("id") int id) throws SQLException {
		cursoDAO.excluirCurso(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
