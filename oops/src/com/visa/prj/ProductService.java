package com.visa.training.productapp.service;

import java.util.List;

import com.visa.training.productapp.domain.Product;

public interface ProductService {
	public int createNewProduct(Product p);
	public Product findById(int id);
	public List<Product> findAll();

}
