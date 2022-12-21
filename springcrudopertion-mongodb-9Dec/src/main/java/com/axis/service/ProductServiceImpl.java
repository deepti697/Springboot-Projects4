package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IDNotFoundException;
import com.axis.exception.InvalidpriceException;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;
import com.axis.utils.AppConstants;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		if (product.getPrice()<=0)
			throw new InvalidpriceException(AppConstants.INVALID_PRICE_MESSAGE );
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.PRODUCT_ID_NOT_FOUND_MESSAGE));
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product prod=productRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.PRODUCT_ID_NOT_FOUND_MESSAGE));
		prod.setName(product.getName());
		prod.setCategory(product.getCategory());
		prod.setPrice(product.getPrice());
		
		return productRepository.save(prod);
	}

	@Override
	public String deleteProduct(int id) {
		Product prod=productRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.PRODUCT_ID_NOT_FOUND_MESSAGE));
		productRepository.delete(prod);
		return AppConstants.PRODUCT_DELETE_MESSAGE;
	}
	
	

}
