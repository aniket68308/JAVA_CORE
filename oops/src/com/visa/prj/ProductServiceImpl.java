package com.visa.training.productapp.service;

import java.util.List;

import com.visa.training.productapp.dal.ProductDAO;
import com.visa.training.productapp.dal.ProductDAOInMemoryImpl;
import com.visa.training.productapp.domain.Product;

public class ProductServiceImpl implements ProductService {

	ProductDAO dao = new ProductDAOInMemoryImpl();
	@Override
	public int createNewProduct(Product p) {
		if(p.getPrice()*p.getQoh()>=10000)
		{
			Product saved = dao.save(p);
			return saved.getId();
		}
		else
		{
			throw new IllegalArgumentException("too low");
		}
	}

	@Override
	public Product findById(int id) {
		return dao.findBYid(id);
		
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
		
	}

}
