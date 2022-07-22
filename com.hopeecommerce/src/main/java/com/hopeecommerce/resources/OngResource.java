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

import com.hopeecommerce.entities.Ong;
import com.hopeecommerce.requests.OngRequest;

@RestController
@RequestMapping("ongs")
public class OngResource {
	
	@GetMapping
	public List<Ong> getAll(){
		return null;
	}
	
	@PostMapping
	public void add(@RequestBody OngRequest ongRequest) {
		
	}
	
	@PutMapping
	public void update(@RequestBody OngRequest ongRequest) {
		
	}
	
	@PatchMapping
	public void alter(@RequestBody OngRequest ongRequest) {
		
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteById(@RequestParam("id") Integer id) {
		
	}
}
