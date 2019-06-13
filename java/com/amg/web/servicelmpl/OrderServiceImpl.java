package com.amg.web.servicelmpl;

import java.util.List;

import com.amg.web.domain.OrderDTO;
import com.amg.web.service.OrderService;

import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void addOrder(OrderDTO order) {

    }

    @Override
    public List<OrderDTO> findOrders() {
        return null;
    }

    @Override
    public List<OrderDTO> findOrdersByOption(OrderDTO option) {
        return null;
    }

    @Override
    public OrderDTO findOrdersByOrderId(String orderId) {
        return null;
    }

    @Override
    public void updateOrder(OrderDTO order) {

    }

    @Override
    public void deleteOrder(OrderDTO order) {

    }

    
}