package com.hopeecommerce.resources;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hopeecommerce.entities.Client;
import com.hopeecommerce.requests.ClientRequest;

@RestController
@RequestMapping("clients")
public class ClientResource {
	
	@GetMapping
	public List<Client> findAll() {
		return null;
	}
	
	@PostMapping
	public void add(@RequestBody ClientRequest clientRequest) {
		
	}
	
	@PutMapping
	public void update(@RequestBody ClientRequest clientRequest) {
		
	}
	
	@PatchMapping
	public void alter(@RequestBody ClientRequest clientRequest) {
		
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteById(@RequestParam("id") Integer id) {
		
	}
}