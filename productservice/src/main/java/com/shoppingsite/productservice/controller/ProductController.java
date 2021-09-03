package com.shoppingsite.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingsite.productservice.model.Product;
import com.shoppingsite.productservice.model.ProductDto;
import com.shoppingsite.productservice.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
//	___________________________________POST Reuests_____________________________________
	
	@PostMapping("/products/addproduct")
	public ResponseEntity<?> saveProduct(@RequestBody ProductDto product) {
		return ResponseEntity.ok( productService.saveProduct(product));
	}

	

//	___________________________________GET Reuests_____________________________________
	@GetMapping("/products")
	public List<Product> getallProducts(){
		return productService.getallproducts();
	}
	
	@GetMapping("/products/getproductbyid/{id}")
	public Optional<Product> getProductById(@PathVariable(value = "id") long id) {
		return productService.getProductById(id);

	}
	
	@GetMapping("/products/getproductbyname/{name}")
	public Optional<Product> getProductByName(@PathVariable(value = "name") String name) {
		return productService.getProductByName(name);

	}
	
	@GetMapping("/products/getproductsbyname/{name}")
	public List<Product> getprouctsbyname(@PathVariable(value = "name")String name) {
		return productService.getproductsbyname(name);
		
	}
	
	@GetMapping("/products/getproductsbyprice/{price}")
	public List<Product> getprouctsbyprice(@PathVariable(value = "price")double price) {
		return productService.getproductsbyprice(price);
		
	}
	
	
//	___________________________________PUT Reuests_____________________________________
	@PutMapping("/products/updateproduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable(value = "id") long id) {
		return productService.updateProduct(product, id);
	}
	
	
	
	
//	___________________________________DELETE Reuests_____________________________________
	@DeleteMapping("/products/deleteproduct/{id}")
	public String deleteProduct(@PathVariable(value="id") long id) {
		productService.deleteProduct(id);
		return "product deleted";
	}
	
	
	
	

}
