package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;
@Service
@Transactional


public class ProductServiceImpl implements ProductService{
	public ProductServiceImpl(){
		System.out.println("productServiceimpl object has created");
	}
	@Autowired
private ProductDao productDao;


	public void saveProduct(Product product) {
		productDao.saveProduct(product);
		
		
	}


	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}


	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}


	public void deleteProduct(int id) {
		Product product=getProductById(id);
		productDao.deleteProduct(product);
	}


	public void updateProduct(Product product) {
		productDao.editProduct(product);
		
		
	}


	public List<Category> getAllCategories() {
		return productDao.getAllCategories();
	}
	

}
