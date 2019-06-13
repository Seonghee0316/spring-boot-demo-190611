package com.amg.web.mapper;

import java.util.List;

import com.amg.web.domain.OrderDTO;

import org.springframework.stereotype.Repository;

/**
 * OderMapper
 */

@Repository 
public interface OrderMapper {
    public void insertOrder(OrderDTO order);
    public List<OrderDTO> selectOrders();
    public List<OrderDTO> selectOrdersByOption(OrderDTO option);
    public OrderDTO selectOrdersByOrderId(String orderId);
    public void updateOrder(OrderDTO order);
    public void deleteOrder(OrderDTO order);
    
}