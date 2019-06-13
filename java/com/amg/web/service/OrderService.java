package com.amg.web.service;

import java.util.List;

import com.amg.web.domain.OrderDTO;

import org.springframework.stereotype.Component;

/**
 * OderService
 */
@Component
public interface OrderService {
    public void addOrder(OrderDTO order);
    public List<OrderDTO> findOrders();
    public List<OrderDTO> findOrdersByOption(OrderDTO option);
    public OrderDTO findOrdersByOrderId(String orderId);
    public void updateOrder(OrderDTO order);
    public void deleteOrder(OrderDTO order);
}