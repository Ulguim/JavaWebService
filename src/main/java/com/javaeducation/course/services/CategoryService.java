package com.javaeducation.course.services;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.javaeducation.course.Repositories.CategoryRepository;

import com.javaeducation.course.entities.Category;


//@Component  Registra a classe como um componente do SpringBoot
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}