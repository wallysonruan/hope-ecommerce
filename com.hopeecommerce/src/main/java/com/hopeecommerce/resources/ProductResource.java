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

import com.hopeecommerce.entities.Product;

@RestController
@RequestMapping("products")
public class ProductResource {
	
	@GetMapping
	public List<Product> getAll(){
		return null;
	}
	
	@PostMapping
	public void add(@RequestBody Product product) {
		
	}
	
	@PutMapping
	public void update(@RequestBody Product product) {
		
	}
	
	@PatchMapping
	public void alter(@RequestBody Product product) {
		
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@RequestParam("id") Integer id) {
		
	}
}