package com.niit.dao;

import com.niit.model.Cart;
import com.niit.model.CustomerOrder;

public interface CustomerOrderDao {

		CustomerOrder createOrder(Cart cart);

		}


