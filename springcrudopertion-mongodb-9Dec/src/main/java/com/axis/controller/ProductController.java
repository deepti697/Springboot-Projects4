package com.axis.controller;

import java.util.List;

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

import com.axis.model.Product;
import com.axis.service.ProductService;

@RestController
@RequestMapping("api/v1")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addproduct(@RequestBody Product product){
		Product product2 = productService.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable int id){
		Product products = productService.getProductById(id);
		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(id, product),HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		return new ResponseEntity<String>(productService.deleteProduct(id),HttpStatus.OK);
	}

}
