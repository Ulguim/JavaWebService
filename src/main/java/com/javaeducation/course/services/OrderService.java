package com.javaeducation.course.services;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.javaeducation.course.Repositories.OrderRepository;
import com.javaeducation.course.entities.Order;

//@Component  Registra a classe como um componente do SpringBoot
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}