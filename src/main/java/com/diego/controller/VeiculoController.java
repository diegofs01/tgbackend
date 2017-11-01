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

import com.diego.jdbc.dao.VeiculoDAO;
import com.diego.model.Veiculo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class VeiculoController {

	public VeiculoDAO veiculoDAO;
	
	public VeiculoController() throws SQLException {
		veiculoDAO = new VeiculoDAO();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/veiculo", method = RequestMethod.GET)
	public ResponseEntity<List<Veiculo>> listarVeiculos() throws SQLException {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos = veiculoDAO.listarCarros();
		return new ResponseEntity<List<Veiculo>>(veiculos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/veiculo/{placa}", method = RequestMethod.GET)
	public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable("placa") String placa) throws SQLException {
		Veiculo veiculo = new Veiculo();
		veiculo = veiculoDAO.buscarCarro(placa);
		if(veiculo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/veiculo", method = RequestMethod.POST)
	public ResponseEntity<Veiculo> adicionarVeiculo(@RequestBody Veiculo veiculo) throws JsonParseException, JsonMappingException, IOException, SQLException {
		veiculoDAO.adicionarCarro(veiculo);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/veiculo/{placa}", method = RequestMethod.PUT)
	public ResponseEntity<Veiculo> alterarVeiculo(@PathVariable("placa") String placa, @RequestBody Veiculo veiculo) throws JsonParseException, JsonMappingException, IOException, SQLException {
		veiculoDAO.alterarCarro(placa, veiculo);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/veiculo/{placa}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluirVeiculo(@PathVariable("placa") String placa) throws SQLException {
		veiculoDAO.excluirCarro(placa);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
