package com.javaeducation.course.Resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaeducation.course.entities.User;
//  @RestController é uma anotação do Spring que indica que a classe é um recurso web, implementado por um controlador REST
@RestController
// @RequestMapping é uma anotação do Spring que indica o caminho do recurso
@RequestMapping(value = "/users")
public class UserResource {
    // @GetMapping é uma anotação do Spring que indica que o método abaixo responde a requisição do tipo GET do HTTP
    @GetMapping
    public ResponseEntity<User> findAll() {
        
        User u = new User(1L, "test", "william@gmail.com", "99999999", "12345");
        return  ResponseEntity.ok().body(u);
    }
}
