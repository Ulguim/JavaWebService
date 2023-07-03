package com.javaeducation.course.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaeducation.course.entities.Order;
import com.javaeducation.course.services.OrderService;
//  @RestController é uma anotação do Spring que indica que a classe é um recurso web, implementado por um controlador REST
@RestController
// @RequestMapping é uma anotação do Spring que indica o caminho do recurso
@RequestMapping(value = "/orders")
public class OrderResource {
    // @GetMapping é uma anotação do Spring que indica que o método abaixo responde a requisição do tipo GET do HTTP
    // Para funcionar a classe precisa estar registrada como serviço no springBoot
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        
        List <Order> list = service.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    // PathVariable é uma anotação do Spring que indica que o parâmetro do método abaixo é o mesmo que está na URL
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}