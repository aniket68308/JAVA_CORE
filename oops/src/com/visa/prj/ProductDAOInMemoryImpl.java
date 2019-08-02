package com.visa.training.productapp.dal;

import java.util.*;

import com.visa.training.productapp.domain.Product;

public class ProductDAOInMemoryImpl implements ProductDAO{
	
Map<Integer,Product> db=new HashMap<>();
int idSequence=0;
@Override
public Product save(Product toBesaved) {
	int id=idSequence++;
	toBesaved.setId(id);
	db.put(id, toBesaved);
	return toBesaved;
}

@Override
public Product findBYid(int id) {
	db.get(id);
	return db.get(id);
}

@Override
public List<Product> findAll() {
	return new ArrayList<>(db.values());
	
}
	
}
