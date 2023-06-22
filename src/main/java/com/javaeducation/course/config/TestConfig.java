package com.javaeducation.course.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
// CLasse auxiliar para configuração de testes
// Será utilizada para popular o banco de dados com dados de teste

import com.javaeducation.course.Repositories.UserRepository;
import com.javaeducation.course.entities.User;
@Configuration
@Profile("test")
// commandLineRunner é uma interface que permite executar um método quando a aplicação é iniciada
public class TestConfig implements CommandLineRunner{
    // AutoWired é uma anotação que faz a injeção de dependencia de forma transparente
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
     User user1 = new User(null, "William Ulguim", "williamulguim2014@gmail.com", "51999999999", "123456");   
     userRepository.saveAll(Arrays.asList(user1));
    }
    
}
