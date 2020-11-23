package com.tcs.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import com.tcs.springbootdemo.model.Product;

public interface ProductService {
	public String  createProduct(Product product);
	public Optional<Product> getProductById(int id);
	public void deleteProduct(int id);
	public Optional<java.util.List<Product>> getProducts();
	public Optional<java.util.List<Product>> getProductsByCategory(String catName);
	public Optional<java.util.List<Product>> findByPriceGreaterThan(float priceValue);
	public List<Product> findByCategoryAndPriceLessThan(String catName, float price);
	
	//("a%")==>> all prods that start with "a"
	public List<Product> findByProductNameLike(String productName);


}
