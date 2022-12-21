package com.axis.service;

import java.util.List;

import com.axis.dto.ProductDto;
import com.axis.model.Product;

//define Services
public interface ProductService {
	
	//public ProductDto addProduct(ProductDto productDto);
	public List<ProductDto> getAllProducts();
	public Product getProductById(int id);
	//public Product updateProduct(int id,Product product);
	//public String deleteProduct(int id);
}