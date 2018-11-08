 package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;
  
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;



@Configuration
@EnableTransactionManagement

public class DBConfiguration {
	@Bean(name="dataSource")
	
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
		}
   @Bean
	public SessionFactory sessionFactory(){
	
		LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		Class classes[]=new Class[]{Product.class,Category.class,
				User.class,Customer.class,Authorities.class,BillingAddress.class,ShippingAddress.class,Cart.class,CartItem.class,CustomerOrder.class};
		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
		
	}
   @Bean
   public HibernateTransactionManager hibTransManagement(){
	   return new HibernateTransactionManager(sessionFactory());  
	   
   }
}
