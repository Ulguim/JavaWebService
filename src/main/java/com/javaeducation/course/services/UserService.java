package com.javaeducation.course.services;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.javaeducation.course.Repositories.UserRepository;
import com.javaeducation.course.entities.User;

//@Component  Registra a classe como um componente do SpringBoot
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    
    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}