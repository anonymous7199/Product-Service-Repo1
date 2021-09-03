package com.shoppingsite.productservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingsite.productservice.model.Product;
import com.shoppingsite.productservice.model.ProductDto;
import com.shoppingsite.productservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	
	
	
	public Product saveProduct(ProductDto product) {

		Product p=new Product();
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		
		return productRepository.save(p);
	}

	public Optional<Product> getProductById(long id) {
		return productRepository.findById(id);
	}

	public Product updateProduct(Product product, long id) {

		Product p = productRepository.findById(id).get();
		System.out.println(p.toString());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());

		return productRepository.save(p);
	}

	public void deleteProduct(long id) {
		productRepository.deleteById(id);

	}

	public List<Product> getallproducts() {
		List<Product> allproducts=new ArrayList<Product>();
		productRepository.findAll().forEach(allproducts::add);
		return allproducts;
	}

	public Optional<Product> getProductByName(String name) {
		
		return productRepository.findByName(name);
	}

	public List<Product> getproductsbyname(String name) {
		List<Product> allproducts= productRepository.findAll().stream().filter(a->name.equals(a.getName())).toList();
		return allproducts;
		
	}

	public List<Product> getproductsbyprice(double price) {
		List<Product> allproducts= productRepository.findAll().stream().filter(a->price==a.getPrice()).toList();
		return allproducts;
	}

}
