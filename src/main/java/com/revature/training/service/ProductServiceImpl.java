package com.revature.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.training.pms.model.Product;
import com.revature.training.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Transactional(propagation=Propagation.MANDATORY)
	@Override
	public boolean addProduct(Product product) {
		System.out.println("##add product called - Service");
		productRepository.save(product);
		//updateStock
		return true;
	}
	
	@Transactional
	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
		return true;
	}
	
	@Transactional(propagation=Propagation.NESTED)
	@Override
	public boolean updateProduct(Product product) {
		productRepository.save(product);
		return true;
	}
	
	@Transactional(readOnly=true)
	@Override
	public Product getProductById(int productId) {
		Optional<Product> productData = productRepository.findById(productId);
		Product product = productData.get();
		return product;
	}
	@Override
	public List<Product> getProductByName(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByProductName(productName);
	}
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}
	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> productData = productRepository.findById(productId);
		return productData.isPresent();
	}
	@Override
	public List<Product> filterByPrice(int lowerPrice, int upperPrice) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(lowerPrice, upperPrice);
	}

}
