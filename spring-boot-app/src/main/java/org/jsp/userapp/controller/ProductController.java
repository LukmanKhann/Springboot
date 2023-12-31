package org.jsp.userapp.controller;

import java.util.List;

import org.jsp.userapp.dto.Product;
import org.jsp.userapp.dto.ResponseStructure;
import org.jsp.userapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins  = "http://localhost:3000")

public class ProductController {
	
	@Autowired
	private ProductService service;

	@PostMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable int id) {
		return service.saveProduct(product, id);
	}
	@PutMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@PathVariable int id) {
		return service.updateProduct(product, id);
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@GetMapping("/products/byuser-id/{uid}")
	public ResponseEntity<ResponseStructure<List<Product>>> findProductByUserId(@PathVariable int uid) {
	return service.findProductByUserId(uid);	
	}
}
