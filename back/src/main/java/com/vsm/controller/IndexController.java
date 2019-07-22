package com.vsm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vsm.model.Cliente;
import com.vsm.repository.IClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class IndexController {
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	
	//listando todos os clientes
	@GetMapping(value = "/", produces = "application/json")
	public  ResponseEntity<List<Cliente>> cliente(){
		
		List<Cliente> list = (List<Cliente>) clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping(value ="/{id}", produces = "application/json")
	public ResponseEntity<Cliente> init(@PathVariable(value = "id") Long id) {
		
		Optional<Cliente> cliente =clienteRepository.findById(id);
		return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
	}
	
	
	//cadastro de cliente
	
		@PostMapping(value="/", produces = "application/json")
		public  ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
			Cliente clienteSalvo= clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
		}

		//alterar dados do cliente
		@PutMapping(value="/", produces = "application/json")
		public  ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
			
			
			Cliente clienteSalvo= clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
		}
		
		@DeleteMapping(value = "/{id}", produces = "application/text")
		public String delete(@PathVariable("id")Long id) {
			
			clienteRepository.deleteById(id);
			return "ok";
		}
}
