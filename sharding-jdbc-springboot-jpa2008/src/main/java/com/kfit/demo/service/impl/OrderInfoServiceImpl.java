package com.kfit.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.demo.bean.OrderInfo;
import com.kfit.demo.repository.OrderInfoRepository;
import com.kfit.demo.service.OrderInfoService;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	@Autowired
	private OrderInfoRepository orderInfoRepository;
	
	@Override
	public void save(OrderInfo orderInfo) {
		orderInfoRepository.save(orderInfo);
	}

}
