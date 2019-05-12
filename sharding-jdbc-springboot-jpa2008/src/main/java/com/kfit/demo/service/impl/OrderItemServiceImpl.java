package com.kfit.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.demo.bean.OrderItem;
import com.kfit.demo.repository.OrderItemRepository;
import com.kfit.demo.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public OrderItem testBindTable() {
		return orderItemRepository.testBindTable();
	}
}
