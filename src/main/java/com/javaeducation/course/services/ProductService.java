package com.javaeducation.course.services;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.javaeducation.course.Repositories.ProductRepository;
import com.javaeducation.course.entities.Product;

//@Component  Registra a classe como um componente do SpringBoot
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}