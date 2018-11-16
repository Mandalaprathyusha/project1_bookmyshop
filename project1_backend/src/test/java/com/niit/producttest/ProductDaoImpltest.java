package com.niit.producttest;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.model.Product;


public class ProductDaoImpltest extends TestCase
{
	ApplicationContext ac=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
	ProductDao productDao=(ProductDao)ac.getBean("productDaoImpl");

	
	@Test
	public void testAddProducts() {
		Product p=new Product();
		p.setProductName("IPHONE");
		p.setDescription("IPHONE6S");
		p.setQuantity(5);
		p.setPrice(85000);
		//p.setId(5);
		productDao.saveProduct(p);
		assertTrue(p.getId()>0);
	}

	@Ignore
	@Test
	public void testUpdateProducts() 
	{
		Product p=productDao.getProductById(1);

	p.setPrice(2500000);
	productDao.editProduct(p);
		
		p=productDao.getProductById(1);
		assertTrue(p.getPrice() == 2500000);
	}
	/*
	
	@Ignore
	@Test
	public void testDeleteProducts() {
		productDao.deleteProducts(2);
		Product p=productDao.selectProducts(2);
		assertNull(p);
	}
	@Ignore
	@Test
	public void testSelectProducts() {
		Product actualproduct1=productDao.selectProducts(1);
		Product actualproduct2=productDao.selectProducts(45);
		assertNotNull(actualproduct1);
		assertNull(actualproduct2);
	}
	@Ignore
	@Test
	public void testGetAllProducts() {
		List<Product> p=productDao.getAllProducts();
		assertFalse(p.isEmpty());
		assertTrue(p.size()==1);
	}
*/
}
