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

import com.diego.jdbc.dao.TipoOcorrenciaDAO;
import com.diego.model.TipoOcorrencia;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class TipoOcorrenciaController {

	public TipoOcorrenciaDAO tipoOcorrenciaDAO;
	
	public TipoOcorrenciaController() throws SQLException {
		tipoOcorrenciaDAO = new TipoOcorrenciaDAO();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/tipoOcorrencia", method = RequestMethod.GET)
	public ResponseEntity<List<TipoOcorrencia>> listarTiposOcorrecias() throws SQLException {
		List<TipoOcorrencia> tiposOcorrencia = new ArrayList<TipoOcorrencia>();
		tiposOcorrencia = tipoOcorrenciaDAO.listarTiposOcorrencias();
		return new ResponseEntity<List<TipoOcorrencia>>(tiposOcorrencia, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/tipoOcorrencia/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipoOcorrencia> buscarTipoOcorrencia(@PathVariable("id") int id) throws SQLException {
		TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
		tipoOcorrencia = tipoOcorrenciaDAO.buscarTipoOcorrencia(id);
		if(tipoOcorrencia == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<TipoOcorrencia>(tipoOcorrencia, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/tipoOcorrencia", method = RequestMethod.POST)
	public ResponseEntity<TipoOcorrencia> adicionarTipoOcorrencia(@RequestBody TipoOcorrencia tipoOcorrencia) throws JsonParseException, JsonMappingException, IOException, SQLException {
		tipoOcorrenciaDAO.adiciona(tipoOcorrencia);
		return new ResponseEntity<TipoOcorrencia>(tipoOcorrencia, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/tipoOcorrencia/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TipoOcorrencia> alterarTipoOcorrencia(@PathVariable("id") int id, @RequestBody TipoOcorrencia tipoOcorrencia) throws JsonParseException, JsonMappingException, IOException, SQLException {
		tipoOcorrenciaDAO.alterarTipoOcorrencia(id, tipoOcorrencia);
		return new ResponseEntity<TipoOcorrencia>(tipoOcorrencia, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/tipoOcorrencia/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluirTipoOcorrencia(@PathVariable("id") int id) throws SQLException {
		tipoOcorrenciaDAO.excluirTipoOcorrencia(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
