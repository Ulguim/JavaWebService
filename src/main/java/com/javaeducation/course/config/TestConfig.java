package com.javaeducation.course.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
// CLasse auxiliar para configuração de testes
// Será utilizada para popular o banco de dados com dados de teste

import com.javaeducation.course.Repositories.OrderRepository;
import com.javaeducation.course.Repositories.UserRepository;
import com.javaeducation.course.entities.Order;
import com.javaeducation.course.entities.User;
import com.javaeducation.course.enums.OrderStatus;
@Configuration
@Profile("test")
// commandLineRunner é uma interface que permite executar um método quando a aplicação é iniciada
public class TestConfig implements CommandLineRunner{
    // AutoWired é uma anotação que faz a injeção de dependencia de forma transparente
    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private OrderRepository orderRepository;

    
    @Override
    public void run(String... args) throws Exception {
     User user1 = new User(null, "William Ulguim", "williamulguim2014@gmail.com", "51999999999", "123456");   
    userRepository.saveAll(Arrays.asList(user1));

    Order order1 = new Order(null, Instant.parse("2021-09-30T19:53:07Z") , OrderStatus.PAID ,user1);
    //  Order order1 = new Order(null, Instant.parse("2021-09-30T19:53:07Z"),user1);    
    orderRepository.saveAll(Arrays.asList(order1));
    }

    
}
 