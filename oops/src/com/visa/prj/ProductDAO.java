package com.visa.training.productapp.dal;

import java.util.List;

import com.visa.training.productapp.domain.Product;

public interface ProductDAO {
	public Product save(Product toBesaved);
	public Product findBYid(int id);
	public List<Product> findAll();

}
