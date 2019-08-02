package com.visa.training.productapp.ui;

import java.util.Scanner;

import com.visa.training.productapp.domain.Product;
import com.visa.training.productapp.service.ProductService;
import com.visa.training.productapp.service.ProductServiceImpl;

public class ProductConsoleUI {
	ProductService service = new ProductServiceImpl();//here we have to create obj of hardcoded class.no use of interface.
	Scanner sc=new Scanner(System.in);
	public void createProductWithUI()
	{
		System.out.println("enter name: ");
		String name=sc.nextLine();
		System.out.println("enter price: ");
		float price=Float.parseFloat(sc.nextLine());
		System.out.println("enter qoh: ");
		int qoh=Integer.parseInt(sc.nextLine());
		Product p=new Product(name,price,qoh);
		int id=service.createNewProduct(p);
		System.out.println("created a new product"+id);
	}

}
