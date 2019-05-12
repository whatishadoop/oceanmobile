package com.kfit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kfit.demo.bean.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	// 测试关联查询笛卡尔积问题
	@Query(nativeQuery=true,value="select i.* from order_info o,order_item i where o.oid=i.oid and o.oid in(10,11) ")
	public OrderItem testBindTable();
	
}
