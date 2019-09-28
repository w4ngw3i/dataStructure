package com.test.service;

import com.test.dto.OrderDTO;

/**
 * @author: wangwei
 * @date: 2019-09-25 14:10
 */
public interface OrderService {

    /**
     * 根据订单的不同类型作出相应的处理
     * @param orderDTO
     * @return
     */
    String handle(OrderDTO orderDTO);
}
