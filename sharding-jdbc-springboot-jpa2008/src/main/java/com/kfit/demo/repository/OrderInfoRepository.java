package com.kfit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kfit.demo.bean.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long>{

}
