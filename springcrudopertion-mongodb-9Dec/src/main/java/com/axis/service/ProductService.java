package com.axis.service;

import java.util.List;

import com.axis.model.Product;

//define Services
public interface ProductService {
	
	public Product addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public Product updateProduct(int id,Product product);
	public String deleteProduct(int id);
}