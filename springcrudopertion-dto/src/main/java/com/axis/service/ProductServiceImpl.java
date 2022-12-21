package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.ProductDto;
import com.axis.exception.IDNotFoundException;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;
import com.axis.utils.AppConstants;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

//	@Override
//	public ProductDto addProduct(ProductDto productDto) {
//		Product product = new Product();
//		product.setId(productDto.getId());
//		product.setName(productDto.getName());
//		product.setPrice(productDto.getPrice());
//		product.setCategory(productDto.getCategory());
//		
//		productRepository.save(product);
//		return productDto;
//	}
//
//	@Override
//	public List<ProductDto> getAllProducts() {
//		
//		return null;
//	}
	/*@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product  product = productRepository.save(convertToEntity(productDto));
		return convertToEntity(product);
	}*/

	@Override
	public List<ProductDto> getAllProducts() {

		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			productDtos.add(convertToDto(product));
		}
		return productDtos;
	}

	@Override
	public Product getProductById(int id) {

		Product product=productRepository.findById(id)
		.orElseThrow(()-> new IDNotFoundException(AppConstants.PRODUCT_ID_NOT_FOUND_MESSAGE));
		return product;
	}

	/*
	 * method to convert dto to entity
	 */
	private ProductDto convertToDto(Product product) {
		ProductDto productDto = new ModelMapper().map(product, ProductDto.class);
		return productDto;
	}
	
	private Product convertToEntity(ProductDto productDto) {
		Product product = new ModelMapper().map(productDto, Product.class);
		return product;
	}

	

	
}
