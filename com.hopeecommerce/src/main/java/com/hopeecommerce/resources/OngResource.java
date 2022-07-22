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

@RestController
@RequestMapping("ongs")
public class OngResource {
	
	@GetMapping
	public List<Ong> getAll(){
		return null;
	}
	
	@PostMapping
	public void add(@RequestBody Ong ong) {
		
	}
	
	@PutMapping
	public void update(@RequestBody Ong ong) {
		
	}
	
	@PatchMapping
	public void alter(@RequestBody Ong ong) {
		
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@RequestParam("id") Integer id) {
		
	}
}
