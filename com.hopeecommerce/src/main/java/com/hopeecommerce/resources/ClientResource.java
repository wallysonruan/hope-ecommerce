package com.hopeecommerce.resources;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hopeecommerce.entities.Client;

@RestController
@RequestMapping("clients")
public class ClientResource {
	
	@GetMapping
	public List<Client> findAll() {
		return null;
	}
	
	@PostMapping
	public void add(@RequestBody Client client) {
		
	}
	
	@PutMapping
	public void update(@RequestBody Client client) {
		
	}
	
	@PatchMapping
	public void alter(@RequestBody Client client) {
		
	}
	
	@DeleteMapping
	public void deleteById(Integer id) {
		
	}
}