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

import com.diego.jdbc.dao.OcorrenciaDAO;
import com.diego.model.Ocorrencia;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class OcorrenciaController {

	public OcorrenciaDAO ocorrenciaDAO;
	
	public OcorrenciaController() throws SQLException {
		ocorrenciaDAO = new OcorrenciaDAO();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/ocorrencia", method = RequestMethod.GET)
	public ResponseEntity<List<Ocorrencia>> listarOcorrencias() throws SQLException {
		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		ocorrencias = ocorrenciaDAO.listarOcorrencias();
		return new ResponseEntity<List<Ocorrencia>>(ocorrencias, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/ocorrencia/{numero}", method = RequestMethod.GET)
	public ResponseEntity<Ocorrencia> buscarVeiculo(@PathVariable("numero") int numero) throws SQLException {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia = ocorrenciaDAO.buscarOcorrencia(numero);
		if(ocorrencia == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<Ocorrencia>(ocorrencia, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/api/ocorrencia/placa/{placa}", method = RequestMethod.GET)
	public ResponseEntity<List<Ocorrencia>> listarOcorrenciasByPlaca(@PathVariable("placa") String placa) throws SQLException {
		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		ocorrencias = ocorrenciaDAO.listarOcorrenciasByPlaca(placa);
		return new ResponseEntity<List<Ocorrencia>>(ocorrencias, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/ocorrencia", method = RequestMethod.POST)
	public ResponseEntity<Ocorrencia> adicionarOcorrencia(@RequestBody Ocorrencia ocorrencia) throws JsonParseException, JsonMappingException, IOException, SQLException {
		ocorrenciaDAO.adicionarOcorrencia(ocorrencia);
		return new ResponseEntity<Ocorrencia>(ocorrencia, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/ocorrencia/{numero}", method = RequestMethod.PUT)
	public ResponseEntity<Ocorrencia> alterarOcorrencia(@PathVariable("numero") int numero, @RequestBody Ocorrencia ocorrencia) throws JsonParseException, JsonMappingException, IOException, SQLException {
		ocorrenciaDAO.alterarOcorrencia(numero, ocorrencia);
		return new ResponseEntity<Ocorrencia>(ocorrencia, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/ocorrencia/{numero}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluirOcorrencia(@PathVariable("numero") int numero) throws SQLException {
		ocorrenciaDAO.excluirOcorrencia(numero);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/ocorrencia/verificarVeiculo/{placa}", method = RequestMethod.GET)
	public ResponseEntity<Integer> verificarVeiculo(@PathVariable("placa") String placa) throws SQLException {
		return new ResponseEntity<Integer>(ocorrenciaDAO.verificarVeiculo(placa), HttpStatus.OK);
	}
}
